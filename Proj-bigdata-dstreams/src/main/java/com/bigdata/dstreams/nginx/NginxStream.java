package com.bigdata.dstreams.nginx;

import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.bson.Document;

import com.bigdata.base.spark.SparkUtil;
import com.bigdata.base.spark.writers.ConsoleWriter;
import com.bigdata.base.spark.writers.MongoWriter;
import com.bigdata.base.utils.RegexUtil;

public class NginxStream {

	public static StreamingQuery start(SparkSession spark, String servers, String topicsIn, String topicOut,
			String checkpointLocation) {
		Dataset<Row> source = SparkUtil.readKafka(spark, servers, topicsIn);
		Encoder<NginxLog> encoder = Encoders.bean(NginxLog.class);
		Dataset<String> jsonStrSet = source.map((MapFunction<Row, String>) row -> String.valueOf(row.get(1)), Encoders.STRING());
		Dataset<Row> rowSet = jsonStrSet
				.select(functions.from_json(functions.col("value"), encoder.schema()).as("root")).selectExpr("root.*")
				.withColumn("timestamp", functions.current_timestamp());
		Dataset<NginxLog> dataset = rowSet.as(encoder);
		dataset.writeStream().foreach(new ConsoleWriter<NginxLog>() {
			@Override
			public void process(NginxLog item) {
				System.out.println(item.getUid());
				System.out.println(item.getRemoteAddr());
				System.out.println(item.getRequest());
				System.out.println(item.getStatus());
			}
		}).start();

		// Dataset<String> requestDS = dataset
		// .filter((FilterFunction<NginxLog>) value -> (value != null &&
		// value.getStatus() != null && value.getStatus() == 200))
		// .map((MapFunction<NginxLog, String>) value -> value.getRemoteAddr(),
		// Encoders.STRING());
		// Dataset<Row> counts =
		// requestDS.groupBy("value").count().withColumnRenamed("value",
		// "key").withColumnRenamed("count", "value");
		// dataset to mongodb
		Dataset<Row> counts = dataset
				.filter((FilterFunction<NginxLog>) value -> (value != null && value.getStatus() != null
						&& value.getStatus() == 200))
				.groupBy("remoteAddr").count().selectExpr("remoteAddr as key", "count as value");
		// counts to mongodb
		StreamingQuery query = SparkUtil.writeKafka(counts, servers, topicOut, checkpointLocation, "complete");
		return query;
	}

	/**
	 * 将每条记录etl到mongodb
	 * 
	 * @param spark
	 * @param servers
	 * @param topicsIn
	 * @param checkpointLocation
	 * @param mongoOutputUri
	 * @return
	 */
	public static StreamingQuery startETLToMongo(SparkSession spark, String servers, String topicsIn, String mongoOutputUri, String checkpointLocation) {
		Dataset<Row> source = SparkUtil.readKafka(spark, servers, topicsIn);
		Dataset<String> dataset = source
				.map((MapFunction<Row, String>) row -> String.valueOf(row.get(1)), Encoders.STRING())
				.filter((FilterFunction<String>) value -> (value != null && value.length() > 0
						&& RegexUtil.isJson(value)));
		StreamingQuery query = dataset.writeStream().option("checkpointLocation", checkpointLocation)
				.outputMode("append").foreach(new MongoWriter<String>(mongoOutputUri) {
					@Override
					public void process(String json) {
						documents.add(Document.parse(json));
					}
				}).start();
		return query;
	}

	/**
	 * 处理流数据，并将结果保存到mongodb
	 * 
	 * @param spark
	 * @param servers
	 * @param topicsIn
	 * @param checkpointLocation
	 * @return
	 */
	public static StreamingQuery startToMongo(SparkSession spark, String servers, String topicsIn,
			String mongoOutputUri, String checkpointLocation) {
		Dataset<Row> source = SparkUtil.readKafka(spark, servers, topicsIn);
		Encoder<NginxLog> encoder = Encoders.bean(NginxLog.class);
		Dataset<String> jsonStrSet = source.map((MapFunction<Row, String>) row -> String.valueOf(row.get(1)), Encoders.STRING());
		Dataset<Row> rowSet = jsonStrSet
				.select(functions.from_json(functions.col("value"), encoder.schema()).as("root")).selectExpr("root.*")
				.withColumn("timestamp", functions.current_timestamp());
		Dataset<NginxLog> dataset = rowSet.as(encoder);
		dataset.writeStream().foreach(new ConsoleWriter<NginxLog>() {
			@Override
			public void process(NginxLog item) {
				System.out.println(item.getUid());
				System.out.println(item.getRemoteAddr());
				System.out.println(item.getRequest());
				System.out.println(item.getStatus());
			}
		}).start();

		Dataset<Row> counts = dataset
				.filter((FilterFunction<NginxLog>) value -> (value != null && value.getStatus() != null
						&& value.getStatus() == 200))
				.groupBy("remoteAddr").count().selectExpr("remoteAddr as key", "count as value");
		
		StreamingQuery query = counts.writeStream().option("checkpointLocation", checkpointLocation)
				.outputMode("complete").foreach(new MongoWriter<Row>(mongoOutputUri) {
					@Override
					public void process(Row item) {
						documents.add(new Document().append("key", item.get(0)).append("value", item.get(1)));
					}
				}).start();
		return query;
	}

}

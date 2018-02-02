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

import com.bigdata.base.spark.ConsoleWriter;
import com.bigdata.base.spark.SparkUtil;

public class NginxStream {

	public static StreamingQuery start(SparkSession spark, String servers, String topicsIn, String topicOut, String checkpointLocation) {

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
		
//		 Dataset<String> requestDS = dataset
//				 .filter((FilterFunction<NginxLog>) value -> (value != null && value.getStatus() != null && value.getStatus() == 200))
//				 .map((MapFunction<NginxLog, String>) value -> value.getRemoteAddr(), Encoders.STRING());
//		 Dataset<Row> counts = requestDS.groupBy("value").count().withColumnRenamed("value", "key").withColumnRenamed("count", "value");

		 Dataset<Row> counts = dataset
				 .filter((FilterFunction<NginxLog>) value -> (value != null && value.getStatus() != null && value.getStatus() == 200))
				 .groupBy("remoteAddr").count().selectExpr("remoteAddr as key", "count as value");
		 
		 StreamingQuery query = SparkUtil.writeKafka(counts, servers, topicOut, checkpointLocation, "complete");

		 return query;
	}

}


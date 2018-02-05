package com.bigdata.base.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import com.bigdata.base.spark.writers.ConsoleWriter;

/**
 * spark util
 * 
 * @author architect.bian
 *         http://spark.apache.org/docs/latest/api/java/org/apache/spark/sql/Dataset.html
 *         http://spark.apache.org/docs/latest/api/java/org/apache/spark/sql/functions.html
 */
public class SparkUtil {

	/**
	 * 创建sparksession，若windows则运行测试环境
	 * 
	 * @param uri
	 * @param appName
	 * @return
	 */
	public static SparkSession createSession(String uri, String appName) {
		String os = System.getProperty("os.name");
		if (os.toLowerCase().startsWith("windows") || os.toLowerCase().startsWith("mac")) {
			return SparkSession.builder().master("local[3]").appName(appName).getOrCreate();
		} else {
			SparkConf conf = new SparkConf().setMaster(uri).setAppName(appName);
			return createSession(conf);
		}
	}

	/**
	 * 创建操作mongo的sparksession
	 * @param uri
	 * @param appName
	 * @param mongoInputUri
	 * @param mongoOutputUri
	 * @return
	 */
	public static SparkSession createSession(String uri, String appName, String mongoInputUri, String mongoOutputUri) {
		SparkConf conf = new SparkConf();
		String os = System.getProperty("os.name");
		if (os.toLowerCase().startsWith("windows") || os.toLowerCase().startsWith("mac")) {
			conf = conf.setMaster("local[3]").setAppName(appName);
		} else {
			conf = conf.setMaster(uri).setAppName(appName);
		}
		return createSession(conf
				.set("spark.mongodb.input.uri", mongoInputUri)
				.set("spark.mongodb.output.uri", mongoOutputUri));
	}

	/**
	 * 通过sparkconf创建sparksession
	 * @param conf
	 * @return
	 */
	public static SparkSession createSession(SparkConf conf) {
		return SparkSession.builder().config(conf).getOrCreate();
	}

	/**
	 * Create a local StreamingContext with batch interval of x second
	 * 
	 * @param uri
	 * @param appName
	 * @param seconds
	 * @return
	 */
	public static JavaStreamingContext createStreamingContext(String uri, String appName, int seconds) {
		SparkConf conf = new SparkConf().setMaster(uri).setAppName(appName); //setIfMissing("spark.master", "local[*]")
		if (System.getProperty("os.name").toLowerCase().startsWith("windows")
				|| System.getProperty("os.name").toLowerCase().startsWith("mac")) {
			conf = new SparkConf().setMaster("local[3]").setAppName(appName); // n > 运行接收器的数量
		}

		return createStreamingContext(conf, seconds);
	}

	public static JavaStreamingContext createStreamingContext(String uri, String appName, int seconds, String mongoInputUri, String mongoOutputUri) {
		SparkConf conf = new SparkConf().setMaster(uri).setAppName(appName); //setIfMissing("spark.master", "local[*]")
		if (System.getProperty("os.name").toLowerCase().startsWith("windows")
				|| System.getProperty("os.name").toLowerCase().startsWith("mac")) {
			conf = new SparkConf().setMaster("local[3]").setAppName(appName); // n > 运行接收器的数量
		}
		conf = conf.set("spark.mongodb.input.uri", mongoInputUri).set("spark.mongodb.output.uri", mongoOutputUri);

		return createStreamingContext(conf, seconds);
	}
	
	/**
	 * 通过sparkconf创建streamingcontext
	 * @param conf
	 * @param seconds
	 * @return
	 */
	public static JavaStreamingContext createStreamingContext(SparkConf conf, int seconds) {
		return new JavaStreamingContext(conf, Durations.seconds(seconds));
	}

	public static Dataset<Row> readKafka(SparkSession spark, String servers, String topics) {
		Dataset<Row> df = spark.readStream().format("kafka").option("kafka.bootstrap.servers", servers)
				.option("subscribe", topics)
//				.option("startingOffsets", "{\"nginxIn\":{\"0\":-1}}")
//				.option("startingOffsets", "{\"topic1\":{\"0\":23,\"1\":-2},\"topic2\":{\"0\":-2}}")
//				.option("endingOffsets", "{\"topic1\":{\"0\":50,\"1\":-1},\"topic2\":{\"0\":-1}}")
//				.option("subscribePattern", "topic.*")
			    .option("startingOffsets", "latest")
//			    .option("endingOffsets", "latest")
				.load()
				.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)", "partition", "offset", "timestamp");
//				.selectExpr("CAST(value AS STRING) as body")
		return df;
	}

	public static StreamingQuery writeKafka(Dataset<Row> df, String servers, String topicOut, String checkpointLocation, String outputMode) {
		StreamingQuery query = df
				  .selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
				  .writeStream()
				  .option("checkpointLocation", checkpointLocation)
				  .outputMode(outputMode)
				  .format("kafka")
				  .option("kafka.bootstrap.servers", servers)
				  .option("topic", topicOut)
				  .start();
		return query;
	}

	public static StreamingQuery printStringSet(Dataset<String> strSet) {
		return strSet.writeStream().foreach(new ConsoleWriter<String>() {
			 @Override
			 public void process(String value) {
				 System.out.println();
				 System.out.println("printStringSet.process:");
				 System.out.println("processing:" + value);
			 }
		 }).start();
	}

	public static StreamingQuery printRowSet(Dataset<Row> rowSet) {
		return rowSet.writeStream().foreach(new ConsoleWriter<Row>() {
			 @Override
			 public void process(Row row) {
				 System.out.println();
				 System.out.println("printRowSet.process:");
				 int len = row.length();
				 for (int i = 0; i < len; i++) {
					 System.out.println("processing:[" +  i+ "]" + row.get(i));
				}
			 }
		 }).start();
	}

}

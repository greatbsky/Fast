package com.bigdata.dstreams;

import java.util.Arrays;

import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;

import com.bigdata.base.spark.SparkUtil;

public class Main {

	public static void main(String[] args) throws InterruptedException, StreamingQueryException {
//		if (args.length < 2) {
//			System.err.println("Usage: JavaStructuredNetworkWordCount <hostname> <port>");
//			System.exit(1);
//		}
//		String host = args[0];
//	    int port = Integer.parseInt(args[1]);
		SparkSession spark = SparkUtil.createSession("spark://172.17.0.9:7077", "JavaWordCount");
		Dataset<Row> lines = spark.readStream().format("socket").option("host", "192.168.1.167").option("port", 9999).load();

		// 将 lines 切分成 words
		Dataset<String> words = lines.as(Encoders.STRING()).flatMap(
				(FlatMapFunction<String, String>) x -> Arrays.asList(x.split(" ")).iterator(), Encoders.STRING()
				);

		// 生成正在运行着的 word count
		Dataset<Row> wordCounts = words.groupBy("value").count();
		
		// Start running the query that prints the running counts to the console
//	    StreamingQuery query = wordCounts.writeStream()
//	    		.outputMode("complete")
//	    		  .format("console").start();

//	    StreamingQuery query = wordCounts.writeStream()
//	    		.outputMode("append")
////	    		  .option("checkpointLocation", "path/to/HDFS/dir")
//	    		.option("path", "dir")
//	    		.format("parquet").start();
//	    query.awaitTermination();
		
		StreamingQuery query = wordCounts.writeStream()
				  .outputMode("complete")
//				  .option("checkpointLocation", "path/to/HDFS/dir")
				  .format("memory")
				  .queryName("myqn")
				  .start();
		System.out.println(query.id());
	}

}

// 集成kafka
// http://spark.apachecn.org/docs/cn/2.2.0/streaming-kafka-0-10-integration.html


// TODO 设置checkpoint
//// Create a factory object that can create and setup a new
// JavaStreamingContext
// JavaStreamingContextFactory contextFactory = new
// JavaStreamingContextFactory() {
// @Override public JavaStreamingContext create() {
// JavaStreamingContext jssc = new JavaStreamingContext(...); // new context
// JavaDStream<String> lines = jssc.socketTextStream(...); // create DStreams
// ...
// jssc.checkpoint(checkpointDirectory); // set checkpoint directory
// return jssc;
// }
// };
//
//// Get JavaStreamingContext from checkpoint data or create a new one
// JavaStreamingContext context =
// JavaStreamingContext.getOrCreate(checkpointDirectory, contextFactory);

//
// Source（数据源） Artifact（坐标）
// Kafka spark-streaming-kafka-0-8_2.11
// Flume spark-streaming-flume_2.11

//
//
// [root@cloud0 ~]# systemctl stop firewalld
// [root@cloud0 ~]# nc -lk 9999
// hi world!
// haha hello great world!
//
// -------------------------------------------
// Time: 1517052260000 ms
// -------------------------------------------
// (haha,1)
// (great,1)
// (hello,1)
// (world!,1)



/**
 * 
 * 
public class DeviceData {
  private String device;
  private String deviceType;
  private Double signal;
  private java.sql.Date time;
  ...
  // Getter and setter methods for each field
}

Dataset<Row> df = ...;    // streaming DataFrame with IOT device data with schema { device: string, type: string, signal: double, time: DateType }
Dataset<DeviceData> ds = df.as(ExpressionEncoder.javaBean(DeviceData.class)); // streaming Dataset with IOT device data

// Select the devices which have signal more than 10
df.select("device").where("signal > 10"); // using untyped APIs
ds.filter((FilterFunction<DeviceData>) value -> value.getSignal() > 10)
  .map((MapFunction<DeviceData, String>) value -> value.getDevice(), Encoders.STRING());

// Running count of the number of updates for each device type
df.groupBy("deviceType").count(); // using untyped API

// Running average signal for each device type
ds.groupByKey((MapFunction<DeviceData, String>) value -> value.getDeviceType(), Encoders.STRING())
  .agg(typed.avg((MapFunction<DeviceData, Double>) value -> value.getSignal()));
 * 
 */









/*
 * dstream处理方式 public static void main(String[] args) throws
 * InterruptedException {
 * 
 * JavaStreamingContext context =
 * SparkUtil.createStreamingContext("spark://172.17.0.9:7077",
 * "NetworkWordCount", 10); JavaReceiverInputDStream<String> lines =
 * context.socketTextStream("192.168.1.167", 9999); JavaDStream<String> words =
 * lines.flatMap(x -> Arrays.asList(x.split(" ")).iterator()); // Count each
 * word in each batch JavaPairDStream<String, Integer> pairs = words.mapToPair(s
 * -> new Tuple2<>(s, 1)); JavaPairDStream<String, Integer> wordCounts =
 * pairs.reduceByKey((i1, i2) -> i1 + i2);
 * 
 * // Print the first ten elements of each RDD generated in this DStream to the
 * console wordCounts.print(); context.start(); // Start the computation
 * context.awaitTermination(); // Wait for the computation to terminate }
 * 
 */

/*
 * //Note: JDBC loading and saving can be achieved via either the load/save or
 * jdbc methods //Loading data from a JDBC source Dataset<Row> jdbcDF =
 * spark.read() .format("jdbc") .option("url", "jdbc:postgresql:dbserver")
 * .option("dbtable", "schema.tablename") .option("user", "username")
 * .option("password", "password") .load();
 * 
 * Properties connectionProperties = new Properties();
 * connectionProperties.put("user", "username");
 * connectionProperties.put("password", "password"); Dataset<Row> jdbcDF2 =
 * spark.read() .jdbc("jdbc:postgresql:dbserver", "schema.tablename",
 * connectionProperties);
 * 
 * //Saving data to a JDBC source jdbcDF.write() .format("jdbc") .option("url",
 * "jdbc:postgresql:dbserver") .option("dbtable", "schema.tablename")
 * .option("user", "username") .option("password", "password") .save();
 * 
 * jdbcDF2.write() .jdbc("jdbc:postgresql:dbserver", "schema.tablename",
 * connectionProperties);
 * 
 * //Specifying create table column data types on write jdbcDF.write()
 * .option("createTableColumnTypes", "name CHAR(64), comments VARCHAR(1024)")
 * .jdbc("jdbc:postgresql:dbserver", "schema.tablename", connectionProperties);
 * 
 */
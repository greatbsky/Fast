package com.bigdata.dstreams.nginx;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;


public class NginxStream {

	public static StreamingQuery start(SparkSession spark) {
		// TODO Auto-generated method stub
		
//		Dataset<Row> df = spark.read().json("examples/src/main/resources/people.json");
//		df.printSchema();
		Encoder<NginxLog> encoder = Encoders.bean(NginxLog.class);
		Dataset<NginxLog> dataSet = spark.read().json("examples/src/main/resources/people.json").as(encoder);
		
//		writeStream
//		.option("checkpointLocation", "path/to/HDFS/dir")
//	    .format("kafka")
//	    .option("kafka.bootstrap.servers", "host1:port1,host2:port2")
//	    .option("topic", "updates")
//	    .start()
		return null;
	}

}


//df = spark \  
//.readStream \
//.format("kafka") \
//.option("kafka.bootstrap.servers", "host1:port1,host2:port2") \
//.option("subscribe", "topic1") \
//.option("startingOffsets", "earliest") \
//.load()
//df.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)") 

//query = df \  
//.selectExpr("CAST(userId AS STRING) AS key", "to_json(struct(*)) AS value") \
//.writeStream \
//.format("kafka") \
//.option("kafka.bootstrap.servers", "host1:port1,host2:port2") \
//.option("topic", "topic1") \
//.option("checkpointLocation", "/path/to/HDFS/dir") \
//.start()




//ds.writeStream.foreach(...)


//Dataset<String> teenagerNamesByIndexDF = teenagersDF.map(
//	    (MapFunction<Row, String>) row -> "Name: " + row.getString(0),
//	    stringEncoder);


//peopleDF.select("name", "age").write().format("parquet").save("namesAndAges.parquet");


////Group the data by window and word and compute the count of each group
//Dataset<Row> windowedCounts = words
// .withWatermark("timestamp", "10 minutes")
// .groupBy(
//     functions.window(words.col("timestamp"), "10 minutes", "5 minutes"),
//     words.col("word"))
// .count();


//dataSet.show();
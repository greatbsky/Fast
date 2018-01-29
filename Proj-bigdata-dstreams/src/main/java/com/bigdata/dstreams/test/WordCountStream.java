package com.bigdata.dstreams.test;

import java.util.Arrays;

import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.Trigger;

public class WordCountStream {

	public static StreamingQuery start(SparkSession spark) {
		Dataset<Row> lines = spark.readStream().format("socket").option("host", "192.168.1.167").option("port", 9999).load();
		lines.printSchema();

		// 将 lines 切分成 words
		Dataset<String> words = lines.as(Encoders.STRING()).flatMap(
				(FlatMapFunction<String, String>) x -> Arrays.asList(x.split(" ")).iterator(), Encoders.STRING()
				);
		words.printSchema();

		// 生成正在运行着的 word count
		Dataset<Row> wordCounts = words.groupBy("value").count();
		wordCounts.printSchema();
		
		// Start running the query that prints the running counts to the console
	    StreamingQuery query = wordCounts
	    		.writeStream().trigger(Trigger.ProcessingTime(10 * 1000))
	    		.outputMode("append")
	    		.format("console").start();
	    return query;
	}

}

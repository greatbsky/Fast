package com.bigdata.dstreams.test;

import java.util.Arrays;

import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.Trigger;

/**
 * 
提交任务：
docker exec -it spark /data/env/spark/bin/spark-submit --master spark://172.17.0.9:7077 --deploy-mode cluster --class com.bigdata.dstreams.Main /data/share/jars/bigdata-dstreams-1.0.0-SNAPSHOT-jar-with-dependencies.jar wordcount 192.168.1.78 9999 hdfs://172.17.0.3:9000/my/spark

[root@cloud0 ~]# systemctl stop firewalld
[root@cloud0 ~]# nc -lk 9999
hi world!
haha hello great world!

-------------------------------------------
Time: 1517052260000 ms
-------------------------------------------
(haha,1)
(great,1)
(hello,1)
(world!,1)
 *
 */
public class WordCountStream {

	public static StreamingQuery start(SparkSession spark, String host, int port, String checkpointLocation) {
		Dataset<Row> lines = spark.readStream().format("socket").option("host", host).option("port", port).load();
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
				.option("checkpointLocation", checkpointLocation)
	    		.outputMode("complete")
	    		.format("console").start();
	    return query;
	}
}



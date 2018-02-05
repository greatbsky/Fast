package com.bigdata.dstreams;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;

import com.bigdata.base.spark.SparkUtil;
import com.bigdata.dstreams.nginx.NginxStream;
import com.bigdata.dstreams.test.WordCountStream;

public class Main {

	public static void main(String[] args) throws InterruptedException, StreamingQueryException {
		
		if (args.length < 1) {
			System.err.println("Usage: Main <stream> <...>");
			System.exit(1);
		}
		String appName = args[0];
		StreamingQuery query = null;
		SparkSession spark = SparkUtil.createSession("spark://172.17.0.9:7077", appName);
		if (appName.toLowerCase().contains("nginx2kafka")) {
			if (args.length != 5) {
				System.err.println("Usage: Main nginx2kafka <servers> <topicIn1,topicIn2> <topicOut> <checkpointLocation>");
				System.exit(1);
			}
			String servers = args[1];
			String topicsIn = args[2];
			String topicsOut = args[3];
			String checkpointLocation = args[4];
			query = NginxStream.start(spark, servers, topicsIn, topicsOut, checkpointLocation);
		} else if (appName.toLowerCase().contains("nginxetl")) {
			if (args.length != 5) {
				System.err.println("Usage: Main nginxetl <servers> <topicIn1,topicIn2> <mongoOutputUri> <checkpointLocation>");
				System.exit(1);
			}
			String servers = args[1];
			String topicsIn = args[2];
			String mongoOutputUri = args[3];
			String checkpointLocation = args[4];
			query = NginxStream.startETLToMongo(spark, servers, topicsIn, mongoOutputUri, checkpointLocation);
		} else if (appName.toLowerCase().contains("nginx2mongo")) {
			if (args.length != 5) {
				System.err.println("Usage: Main nginx2mongo <servers> <topicIn1,topicIn2> <mongoOutputUri> <checkpointLocation>");
				System.exit(1);
			}
			String servers = args[1];
			String topicsIn = args[2];
			String mongoOutputUri = args[3];
			String checkpointLocation = args[4];
			query = NginxStream.startToMongo(spark, servers, topicsIn, mongoOutputUri, checkpointLocation);
		} else if(appName.toLowerCase().contains("wordcount")) {
			if (args.length != 4) {
				System.err.println("Usage: Main wordcount <host> <port> <checkpointLocation>");
				System.exit(1);
			}
			String host = args[1]; //192.168.1.167
			int port = Integer.parseInt(args[2]); //9999
			String checkpointLocation = args[3];
			query = WordCountStream.start(spark, host, port, checkpointLocation);
		}
		
	    query.awaitTermination();
	}

}


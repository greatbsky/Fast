package com.bigdata.dstreams;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;

import com.bigdata.base.spark.SparkUtil;
import com.bigdata.dstreams.nginx.NginxStream;
import com.bigdata.dstreams.test.WordCountStream;

public class Main {

	public static void main(String[] args) throws InterruptedException, StreamingQueryException {
		
		if (args.length < 2) {
			System.err.println("Usage: --class xxx.Main xxx.jar <master uri> <app name> <...>");
			System.exit(1);
		}
		String masterUri = args[0]; //"spark://172.17.0.7:7077"
		String appName = args[1];
		StreamingQuery query = null;
		SparkSession spark = SparkUtil.createSession(masterUri, appName);
		if (appName.toLowerCase().contains("nginx2kafka")) {
			if (args.length != 6) {
				System.err.println("Usage: --class xxx.Main xxx.jar <master uri> nginx2kafka <servers> <topicIn1,topicIn2> <topicOut> <checkpointLocation>");
				System.exit(1);
			}
			String servers = args[2];
			String topicsIn = args[3];
			String topicsOut = args[4];
			String checkpointLocation = args[5];
			query = NginxStream.start(spark, servers, topicsIn, topicsOut, checkpointLocation);
		} else if (appName.toLowerCase().contains("nginxetl")) {
			if (args.length != 6) {
				System.err.println("Usage: --class xxx.Main xxx.jar <master uri> nginxetl <servers> <topicIn1,topicIn2> <mongoOutputUri> <checkpointLocation>");
				System.exit(1);
			}
			String servers = args[2];
			String topicsIn = args[3];
			String mongoOutputUri = args[4];
			String checkpointLocation = args[5];
			query = NginxStream.startETLToMongo(spark, servers, topicsIn, mongoOutputUri, checkpointLocation);
		} else if (appName.toLowerCase().contains("nginx2mongo")) {
			if (args.length != 6) {
				System.err.println("Usage: --class xxx.Main xxx.jar <master uri> nginx2mongo <servers> <topicIn1,topicIn2> <mongoOutputUri> <checkpointLocation>");
				System.exit(1);
			}
			String servers = args[2];
			String topicsIn = args[3];
			String mongoOutputUri = args[4];
			String checkpointLocation = args[5];
			query = NginxStream.startToMongo(spark, servers, topicsIn, mongoOutputUri, checkpointLocation);
		} else if(appName.toLowerCase().contains("wordcount")) {
			if (args.length != 5) {
				System.err.println("Usage: --class xxx.Main xxx.jar <master uri> wordcount <host> <port> <checkpointLocation>");
				System.exit(1);
			}
			String host = args[2]; //192.168.1.167
			int port = Integer.parseInt(args[3]); //9999
			String checkpointLocation = args[4];
			query = WordCountStream.start(spark, host, port, checkpointLocation);
		}
		
	    query.awaitTermination();
	}

}


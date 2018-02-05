package com.bigdata.base.spark;

import java.util.Map;

import org.apache.spark.SparkConf;

import com.mongodb.spark.config.ReadConfig;
import com.mongodb.spark.config.WriteConfig;

public class MongoUtil {

	public static WriteConfig createWriteConfig(String mongoOutputUri) {
		return WriteConfig.create(new SparkConf().set("spark.mongodb.output.uri", mongoOutputUri));
	}
	
	public static WriteConfig createWriteConfig(String mongoOutputUri, Map<String, String> option) {
		return createWriteConfig(mongoOutputUri).withOptions(option);
	}

	public static SparkConf newSparkConf(String mongoInputUri, String mongoOutputUri) {
		return new SparkConf().set("spark.mongodb.input.uri", mongoInputUri).set("spark.mongodb.output.uri", mongoOutputUri);
	}

	public static ReadConfig createReadConfig(String mongoInputUri) {
		return ReadConfig.create(new SparkConf().set("spark.mongodb.input.uri", mongoInputUri));
	}
	
	public static ReadConfig createReadConfig(String mongoInputUri, Map<String, String> optionOverrides) {
		return createReadConfig(mongoInputUri).withOptions(optionOverrides);
	}

}

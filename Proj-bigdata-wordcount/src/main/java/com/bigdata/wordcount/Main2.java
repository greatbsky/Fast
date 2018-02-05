package com.bigdata.wordcount;

import java.util.HashMap;
import java.util.Map;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.bigdata.base.spark.SparkUtil;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.config.ReadConfig;

public class Main2 {

	public static void main(String[] args) {

		SparkSession spark = SparkUtil.createSession("spark://172.17.0.9:7077", "JavaWordCount", "mongodb://192.168.1.78/bigdb.logs", "mongodb://192.168.1.78/bigdb.logsstats");
		JavaSparkContext context = new JavaSparkContext(spark.sparkContext());
		
		// Create a custom ReadConfig
	    Map<String, String> readOverrides = new HashMap<String, String>();
	    readOverrides.put("readPreference.name", "secondaryPreferred");
	    ReadConfig readConfig = ReadConfig.create(context).withOptions(readOverrides);

	    // Load data using the custom ReadConfig
	    Dataset<Row> df = MongoSpark.load(context, readConfig).toDF();
	    df.printSchema();
        df.show();
	    
        Dataset<Row> result = df.groupBy("remoteAddr").count().selectExpr("remoteAddr as key", "count as value");
        MongoSpark.write(result).option("collection", "logsstats").save();

		context.close();
		
	}

}

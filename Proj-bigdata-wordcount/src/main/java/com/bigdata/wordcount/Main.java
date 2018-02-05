package com.bigdata.wordcount;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.bson.Document;

import com.bigdata.base.spark.MongoUtil;
import com.bigdata.base.spark.SparkUtil;
import com.bigdata.base.utils.StrUtil;
import com.mongodb.spark.MongoSpark;
import com.mongodb.spark.config.ReadConfig;
import com.mongodb.spark.config.WriteConfig;
import com.mongodb.spark.rdd.api.java.JavaMongoRDD;

import scala.Tuple2;

public class Main {

	public static void main(String[] args) {

		SparkSession spark = SparkUtil.createSession("spark://172.17.0.9:7077", "JavaWordCount");
		JavaSparkContext context = new JavaSparkContext(spark.sparkContext());

	    Map<String, String> readOverrides = new HashMap<String, String>();
	    readOverrides.put("readPreference.name", "secondaryPreferred");
	    ReadConfig readConfig = MongoUtil.createReadConfig("mongodb://192.168.1.78/bigdb.logs", readOverrides);

	    // Load data using the custom ReadConfig
	    JavaMongoRDD<Document> rdd = MongoSpark.load(context, readConfig);
		System.out.println(rdd.count());
	    System.out.println(rdd.first().toJson());
	    
		JavaRDD<String> words = rdd.flatMap(doc -> {
			System.out.println(doc.toJson());
			return Arrays.asList(doc.toJson().split(",")).iterator();
		});

		JavaPairRDD<String, Integer> ones = words.mapToPair(s -> new Tuple2<>(s.trim(), 1));

		JavaPairRDD<String, Integer> counts = ones.reduceByKey((v1, v2) -> v1 + v2);

		List<Tuple2<String, Integer>> output = counts.collect();
		for (Tuple2<?, ?> tuple : output) {
			System.out.println(tuple._1() + ": " + tuple._2());
		}
		JavaRDD<Document> result = context.parallelize(output).map(item -> Document.parse("{\"" + StrUtil.base64Enc(item._1().getBytes()) + "\": " + item._2() + "}"));

	    Map<String, String> writeOverrides = new HashMap<String, String>();
	    writeOverrides.put("writeConcern.w", "majority");
	    WriteConfig writeConfig = MongoUtil.createWriteConfig("mongodb://192.168.1.78/bigdb.logsstats").withOptions(writeOverrides);
		MongoSpark.save(result, writeConfig);
		context.close();
	}

}

package com.bigdata.wordcount;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.SparkSession;

import com.bigdata.base.spark.SparkUtil;

import scala.Tuple2;

public class Main {

	public static void main(String[] args) {

//		if (args.length < 1) {
//			System.err.println("Usage: JavaWordCount <file>");
//			System.exit(1);
//		}

		SparkSession spark = SparkUtil.createSession("spark://172.17.0.9:7077", "JavaWordCount");

//		JavaRDD<String> lines = spark.read().textFile("E:/MyWork2/Genius-core/Spark/pom.xml").javaRDD();
		JavaRDD<String> lines = spark.read().textFile("/Data/MyWork8/BigData/Proj-bigdata-wordcount/pom.xml").javaRDD();

		JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
			@Override
			public Iterator<String> call(String s) {
				return Arrays.asList(s.split(" ")).iterator();
			}
		});

		JavaPairRDD<String, Integer> ones = words.mapToPair(new PairFunction<String, String, Integer>() {
			@Override
			public Tuple2<String, Integer> call(String s) {
				return new Tuple2<>(s.trim(), 1);
			}
		});

		JavaPairRDD<String, Integer> counts = ones.reduceByKey(new Function2<Integer, Integer, Integer>() {
			@Override
			public Integer call(Integer i1, Integer i2) {
				return i1 + i2;
			}
		});

		List<Tuple2<String, Integer>> output = counts.collect();
		for (Tuple2<?, ?> tuple : output) {
			System.out.println(tuple._1() + ": " + tuple._2());
		}
		spark.stop();
		
	}

}






















/*
//Note: JDBC loading and saving can be achieved via either the load/save or jdbc methods
//Loading data from a JDBC source
Dataset<Row> jdbcDF = spark.read()
.format("jdbc")
.option("url", "jdbc:postgresql:dbserver")
.option("dbtable", "schema.tablename")
.option("user", "username")
.option("password", "password")
.load();

Properties connectionProperties = new Properties();
connectionProperties.put("user", "username");
connectionProperties.put("password", "password");
Dataset<Row> jdbcDF2 = spark.read()
.jdbc("jdbc:postgresql:dbserver", "schema.tablename", connectionProperties);

//Saving data to a JDBC source
jdbcDF.write()
.format("jdbc")
.option("url", "jdbc:postgresql:dbserver")
.option("dbtable", "schema.tablename")
.option("user", "username")
.option("password", "password")
.save();

jdbcDF2.write()
.jdbc("jdbc:postgresql:dbserver", "schema.tablename", connectionProperties);

//Specifying create table column data types on write
jdbcDF.write()
.option("createTableColumnTypes", "name CHAR(64), comments VARCHAR(1024)")
.jdbc("jdbc:postgresql:dbserver", "schema.tablename", connectionProperties);

*/
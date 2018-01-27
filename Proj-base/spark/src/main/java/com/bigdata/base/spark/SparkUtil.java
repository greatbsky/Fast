package com.bigdata.base.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

/**
 * spark util
 * @author architect.bian
 * http://spark.apache.org/docs/latest/api/java/org/apache/spark/sql/Dataset.html
 * http://spark.apache.org/docs/latest/api/java/org/apache/spark/sql/functions.html
 */
public class SparkUtil {

	/**
	 * 创建sparksession，若windows则运行测试环境
	 * @param uri
	 * @param appName
	 * @return
	 */
	public static SparkSession createSession(String uri, String appName) {
		String os = System.getProperty("os.name");
		if(os.toLowerCase().startsWith("windows")) {
			return SparkSession.builder().master("local[3]").appName(appName).getOrCreate();
		} else {
			return SparkSession.builder().master(uri).appName(appName).getOrCreate();
		}
	}

	/**
	 * Create a local StreamingContext with batch interval of x second
	 * @param uri
	 * @param appName
	 * @param seconds
	 * @return
	 */
	public static JavaStreamingContext createStreamingContext(String uri, String appName, int seconds) {
		SparkConf conf = new SparkConf().setMaster(uri).setAppName(appName);
		if(System.getProperty("os.name").toLowerCase().startsWith("windows")) {
			conf = new SparkConf().setMaster("local[3]").setAppName(appName); //n > 运行接收器的数量
		}

		return new JavaStreamingContext(conf, Durations.seconds(seconds));
	}

}



















/**
Dataset<Row> df = spark.read().json("examples/src/main/resources/people.json");
*/




/**
Encoder<Person> personEncoder = Encoders.bean(Person.class);
Dataset<Person> javaBeanDS = spark.createDataset(
  Collections.singletonList(person),
  personEncoder
);
javaBeanDS.show();
// +---+----+
// |age|name|
// +---+----+
// | 32|Andy|
// +---+----+


*/

//Dataset<Row> peopleDF = spark.read().format("json").load("examples/src/main/resources/people.json");
//peopleDF.select("name", "age").write().format("parquet").save("namesAndAges.parquet");









/**



**/
























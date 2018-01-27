

1. mvn clean install
2. genius-core-spark-1.0.0-SNAPSHOT.jar��/data/share
3. docker exec hadoop hadoop fs -put /data/share/genius-core-spark-1.0.0-SNAPSHOT.jar /my/spark/genius-core-spark-1.0.0-SNAPSHOT.jar
4. 






错误：Please increase heap size using the --driver-memory option or spark.driver.memory in Spark
解决：设置-Xms256m -Xmx1024m 





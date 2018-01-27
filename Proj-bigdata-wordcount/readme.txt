

1. mvn clean install
2. 复制genius-core-spark-1.0.0-SNAPSHOT.jar到/data/share
3. docker exec hadoop hadoop fs -put /data/share/genius-core-spark-1.0.0-SNAPSHOT.jar /my/spark/genius-core-spark-1.0.0-SNAPSHOT.jar
4. 





TODO:
https://github.com/mongodb/mongo-spark
http://www.mongoing.com/tj/mongodb_shanghai_spark
https://docs.mongodb.com/spark-connector/current/java-api/
./bin/spark-submit examples/src/main/python/pi.py --driver-class-path postgresql-9.4.1207.jar --jars postgresql-9.4.1207.jar

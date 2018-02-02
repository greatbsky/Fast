# 数据流实时处理平台


#提交任务：参考http://spark.apache.org/docs/latest/submitting-applications.html
docker exec -it spark /data/env/spark/bin/spark-submit --master <master-url> --deploy-mode cluster --class <main-class> <application-jar> [application-arguments]
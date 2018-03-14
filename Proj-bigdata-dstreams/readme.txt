
---------------------------------------------------------------------------------------------------------------------------------启动nginxetl
docker exec hadoop hadoop fs -rm -r hdfs://172.99.0.5:9000/data/env/spark/tmp10
[root@cloud0 ~]# docker exec -it spark /data/env/spark/bin/spark-submit --master spark://172.99.0.7:7077 --deploy-mode cluster --class com.bigdata.dstreams.Main /data/share/jars/bigdata-dstreams-1.0.0-SNAPSHOT-jar-with-dependencies.jar spark://172.99.0.7:7077 nginxetl01 172.99.0.3:9092 nginxin mongodb://172.99.0.6/bigdb.logs hdfs://172.99.0.5:9000/data/env/spark/tmp10


[root@cloud0 ~]# echo '{"remoteAddr": "203.208.60.145","timeLocal": "13/Mar/2018:02:59:55 +0800","timeSec": 1520881195.707,"requestTime": 0.000,"bodyBytes": 6633,"host": "sv2data.supergenius.cn","request": "GET /imgs/webdata/article/180312153513882ief.jpg HTTP/1.1","status": 200,"requestBody": "-","httpReferer": "-","httpUserAgent": "Googlebot-Image/1.0","httpForward": "-","cookie": "-"}' >> /data/share/logs/nginx/access.log

#查看mongodb数据库，数据已经被写入到bigdb.logs中


---------------------------------------------------------------------------------------------------------------------------------启动nginx2mongo

[root@cloud0 ~]# docker exec hadoop hadoop fs -rm -r /data/env/spark/tmp2*
[root@cloud0 ~]# docker exec -it spark /data/env/spark/bin/spark-submit --master spark://172.99.0.7:7077 --deploy-mode cluster --class com.bigdata.dstreams.Main /data/share/jars/bigdata-dstreams-1.0.0-SNAPSHOT-jar-with-dependencies.jar spark://172.99.0.7:7077 nginx2mongo01 172.99.0.3:9092 nginxin mongodb://172.99.0.6/bigdb.logsstats hdfs://172.99.0.5:9000/data/env/spark/tmp20

[root@cloud0 ~]# echo '{"remoteAddr": "203.208.60.115","timeLocal": "13/Mar/2018:02:59:55 +0800","timeSec": 1520881195.707,"requestTime": 0.000,"bodyBytes": 6633,"host": "sv2data.supergenius.cn","request": "GET /imgs/webdata/article/180312153513882ief.jpg HTTP/1.1","status": 200,"requestBody": "-","httpReferer": "-","httpUserAgent": "Googlebot-Image/1.0","httpForward": "-","cookie": "-"}' >> /data/share/logs/nginx/access.log

#查看mongodb数据库，数据已经被写入到bigdb.logsstats中




http://192.168.1.167:8080
http://192.168.1.167:8008
http://192.168.1.167:50070
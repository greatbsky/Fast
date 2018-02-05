package com.bigdata.base.spark.writers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.spark.sql.ForeachWriter;
import org.bson.Document;

import com.bigdata.base.spark.MongoUtil;
import com.bigdata.base.utils.Maps;
import com.mongodb.spark.MongoConnector;
import com.mongodb.spark.config.WriteConfig;

public abstract class MongoWriter<T> extends ForeachWriter<T> {

	private String mongoOutputUri;
	private HashMap<String, String> option;

	public MongoWriter(String mongoOutputUri) {
		this.mongoOutputUri  = mongoOutputUri;
		this.option = Maps.<String, String>newHashMap().put("writeConcern.w", "majority").create();
	}

	MongoConnector connector = null;
	protected List<Document> documents = null;
	
	@Override
	public void close(Throwable arg0) {
		if (documents.size() > 0) {
			WriteConfig writeConfig = MongoUtil.createWriteConfig(mongoOutputUri, option);
			connector.withCollectionDo(writeConfig, Document.class, collection -> {
				collection.insertMany(documents);
				return true;
			});
		}
	}

	@Override
	public boolean open(long partitionId, long version) {
  	    connector = MongoConnector.create(MongoUtil.newSparkConf(mongoOutputUri, mongoOutputUri));
  	    documents = new ArrayList<Document>();
  	    return true;
	}

	@Override
	public abstract void process(T arg0);

}

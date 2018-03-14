package com.bigdata.base.spark.writers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.spark.sql.ForeachWriter;
import org.bson.Document;

import com.bigdata.base.spark.MongoUtil;
import com.bigdata.base.utils.DateUtil;
import com.bigdata.base.utils.Maps;
import com.mongodb.spark.MongoConnector;
import com.mongodb.spark.config.WriteConfig;

public abstract class MongoWriter<T> extends ForeachWriter<T> {

	protected String mongoOutputUri;
	protected HashMap<String, String> option;
	protected WriteConfig writeConfig;
	private boolean appendDateSuffix = false;

	public MongoWriter(String mongoOutputUri) {
		this.mongoOutputUri = mongoOutputUri;
		this.option = Maps.<String, String>newHashMap().put("writeConcern.w", "majority").create();
	}

	public MongoWriter(String mongoOutputUri2, boolean collNameAppendWithDateSuffix) {
		this.appendDateSuffix  = collNameAppendWithDateSuffix;
	}

	protected MongoConnector connector = null;
	protected List<Document> documents = null;

	@Override
	public void close(Throwable arg0) {
		if (documents.size() > 0) {
			if (appendDateSuffix) {
				writeConfig = writeConfig.withOption("collection", writeConfig.collectionName() + DateUtil.getDate());
			}
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
		writeConfig = MongoUtil.createWriteConfig(mongoOutputUri, option);
		return true;
	}

	/**
	 * 
		StreamingQuery query = counts.writeStream().option("checkpointLocation", checkpointLocation)
				.outputMode("complete").foreach(new MongoWriter<Row>(mongoOutputUri) {
					@Override
					public void process(Row item) {
						System.out.println("public void process(Row item) {");
						documents.add(new Document().append("key", item.get(0)).append("value", item.get(1)));
					}
				}).start();
	 */
	@Override
	public abstract void process(T arg0);

}

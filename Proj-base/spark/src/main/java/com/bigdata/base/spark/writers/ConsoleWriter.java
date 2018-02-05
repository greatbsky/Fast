package com.bigdata.base.spark.writers;

import org.apache.spark.sql.ForeachWriter;

public abstract class ConsoleWriter<T> extends ForeachWriter<T> {

	@Override
	public void close(Throwable arg0) {
	}

	@Override
	public boolean open(long arg0, long arg1) {
		return true;
	}

	@Override
	public void process(T arg0) {
		System.out.println(arg0);
	}

}

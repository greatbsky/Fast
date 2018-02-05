package com.bigdata.base.utils;

import java.util.HashMap;

public class Maps<K, V> {

	private HashMap<K, V> map = new HashMap<K, V>();

	public Maps() { }
	public Maps(HashMap<K, V> map) {
		this.map = map;
	}

	public static <K, V> Maps<K, V> newHashMap() {
		return new Maps<K, V>();
	}

	public static <K, V> Maps<K, V> newHashMap(HashMap<K, V> map) {
		return new Maps<K, V>(map);
	}
	public Maps<K, V> put(K key, V value) {
		this.map.put(key, value);
		return this;
	}

	public HashMap<K, V> create() {
		return this.map;
	}

}

package com.servant.wiki.core.redisDemo.dict.model;

public class DictEntry {

	private Object key;
	
	private Union v;
	
	private DictEntry next;

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public Union getV() {
		return v;
	}

	public void setV(Union v) {
		this.v = v;
	}

	public DictEntry getNext() {
		return next;
	}

	public void setNext(DictEntry next) {
		this.next = next;
	}
	
}

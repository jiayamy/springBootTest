package com.servant.wiki.core.redisDemo.dict.model;

public class Dict {
	
	private DictType type;
	
	private Object privdata;
	
	private Dictht[] ht = new Dictht[2];
	
	private Long rehashidx;
	
	private Integer iterators;

	public DictType getType() {
		return type;
	}

	public void setType(DictType type) {
		this.type = type;
	}

	public Object getPrivdata() {
		return privdata;
	}

	public void setPrivdata(Object privdata) {
		this.privdata = privdata;
	}

	public Dictht[] getHt() {
		return ht;
	}

	public void setHt(Dictht[] ht) {
		this.ht = ht;
	}

	public Long getRehashidx() {
		return rehashidx;
	}

	public void setRehashidx(Long rehashidx) {
		this.rehashidx = rehashidx;
	}

	public Integer getIterators() {
		return iterators;
	}

	public void setIterators(Integer iterators) {
		this.iterators = iterators;
	}
	
}

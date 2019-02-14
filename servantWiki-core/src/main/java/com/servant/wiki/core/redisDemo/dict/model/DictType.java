package com.servant.wiki.core.redisDemo.dict.model;

public interface DictType {

	public Integer hashFunction(Object key);

	public Object keyDup(Object privdata, Object key);

	public Object valDup(Object privdata, Object obj);

	public Integer keyCompare(Object privdata, Object key1, Object key2);

	public void keyDestructor(Object privdata, Object key);

	public void valDestructor(Object privdata, Object obj);
}

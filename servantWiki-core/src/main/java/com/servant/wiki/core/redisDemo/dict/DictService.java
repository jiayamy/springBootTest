package com.servant.wiki.core.redisDemo.dict;

public abstract class DictService {
	
	public static Integer DICT_OK = 0;
	
	public static Integer DICT_ERR = 1;
	
	public static Integer DICT_HT_INITIAL_SIZE = 4;
	
	public abstract Integer dictGenHashFunction(Object key, Integer len);
	
}

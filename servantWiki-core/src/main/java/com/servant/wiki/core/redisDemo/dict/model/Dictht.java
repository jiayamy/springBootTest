package com.servant.wiki.core.redisDemo.dict.model;

public class Dictht {

	private DictEntry[] table;
	
	private Long size;
	
	private Long sizemask;
	
	private Long used;

	public DictEntry[] getTable() {
		return table;
	}

	public void setTable(DictEntry[] table) {
		this.table = table;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getSizemask() {
		return sizemask;
	}

	public void setSizemask(Long sizemask) {
		this.sizemask = sizemask;
	}

	public Long getUsed() {
		return used;
	}

	public void setUsed(Long used) {
		this.used = used;
	}
	
}

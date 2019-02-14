package com.servant.wiki.core.redisDemo.dict.model;

public class DictIterator {

	private Dict dict;
	
	private Long index;
	
	private Integer table;
	
	private Integer safe;
	
	private DictEntry entry;
	
	private DictEntry nextEntry;
	
	private Long fingerprint;

	public Dict getDict() {
		return dict;
	}

	public void setDict(Dict dict) {
		this.dict = dict;
	}

	public Long getIndex() {
		return index;
	}

	public void setIndex(Long index) {
		this.index = index;
	}

	public Integer getTable() {
		return table;
	}

	public void setTable(Integer table) {
		this.table = table;
	}

	public Integer getSafe() {
		return safe;
	}

	public void setSafe(Integer safe) {
		this.safe = safe;
	}

	public DictEntry getEntry() {
		return entry;
	}

	public void setEntry(DictEntry entry) {
		this.entry = entry;
	}

	public DictEntry getNextEntry() {
		return nextEntry;
	}

	public void setNextEntry(DictEntry nextEntry) {
		this.nextEntry = nextEntry;
	}

	public Long getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(Long fingerprint) {
		this.fingerprint = fingerprint;
	}
	
}

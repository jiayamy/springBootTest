package com.servant.wiki.worker.policy.redis;

public abstract class Policy {

	private String tableName;

	private String logFileName;

	private String logFileOffSet;

	private String schemaName;

	private String eventType;
	
	private String redisKey;
	
	private String redisColumn;
	
	private Integer timeOut;

	public abstract void initPolicy();

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getLogFileName() {
		return logFileName;
	}

	public void setLogFileName(String logFileName) {
		this.logFileName = logFileName;
	}

	public String getLogFileOffSet() {
		return logFileOffSet;
	}

	public void setLogFileOffSet(String logFileOffSet) {
		this.logFileOffSet = logFileOffSet;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getRedisKey() {
		return redisKey;
	}

	public void setRedisKey(String redisKey) {
		this.redisKey = redisKey;
	}
	
	public String getRedisColumn() {
		return redisColumn;
	}

	public void setRedisColumn(String redisColumn) {
		this.redisColumn = redisColumn;
	}

	public Integer getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Integer timeOut) {
		this.timeOut = timeOut;
	}

}

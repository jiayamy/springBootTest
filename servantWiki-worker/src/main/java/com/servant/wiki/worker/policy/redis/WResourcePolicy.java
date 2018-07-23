package com.servant.wiki.worker.policy.redis;

public class WResourcePolicy extends Policy{

	
	public WResourcePolicy() {
		super();
		this.initPolicy();
	}

	@Override
	public void initPolicy() {
		this.setRedisKey("wResource:");
		this.setRedisColumn("id");
		this.setTimeOut(1000);
	}

}

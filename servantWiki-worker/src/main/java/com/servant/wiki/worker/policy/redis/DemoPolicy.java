package com.servant.wiki.worker.policy.redis;

import com.servant.wiki.worker.entity.Demo;

public class DemoPolicy extends Policy{
	
	private Demo demo;

	@Override
	public void initPolicy() {
		this.setTableName("demo");
		this.setSchemaName("servertWiki");
		this.setRedisKey("demo");
	}

	public Demo getDemo() {
		return demo;
	}

	public void setDemo(Demo demo) {
		this.demo = demo;
	}

}

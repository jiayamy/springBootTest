package com.servant.wiki.worker.policy.redis;

import com.servant.wiki.worker.entity.Demo;
import com.servant.wiki.worker.task.redis.WriteTask;

public class DemoPolicy extends Policy{
	
	private Demo demo;
	
	private WriteTask task;
	
	public DemoPolicy(WriteTask task) {
		this.task = task;
		initPolicy();
	}

	@Override
	public void initPolicy() {
		this.setTableName("demo");
		this.setSchemaName("servertWiki");
		this.setRedisKey("demo:");
		this.setTimeOut(1000);
	}

	public Demo getDemo() {
		return demo;
	}

	public void setDemo(Demo demo) {
		this.demo = demo;
	}

}

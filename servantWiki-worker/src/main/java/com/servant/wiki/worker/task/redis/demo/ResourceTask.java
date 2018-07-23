package com.servant.wiki.worker.task.redis.demo;

import com.servant.wiki.worker.policy.redis.Policy;
import com.servant.wiki.worker.policy.redis.WResourcePolicy;
import com.servant.wiki.worker.result.redis.RedisResult;
import com.servant.wiki.worker.task.redis.WriteTask;

public class ResourceTask extends WriteTask{

	
	public ResourceTask() {
		super();
		this.setType("w_resource");
	}

	@Override
	public void execute() {
		RedisResult redisResult = new RedisResult();
		Policy policy = new WResourcePolicy();
		excuteTask(policy, this, redisResult);
	}

}

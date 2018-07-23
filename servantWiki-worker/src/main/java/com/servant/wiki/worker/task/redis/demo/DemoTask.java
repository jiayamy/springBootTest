package com.servant.wiki.worker.task.redis.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servant.wiki.worker.policy.redis.DemoPolicy;
import com.servant.wiki.worker.policy.redis.Policy;
import com.servant.wiki.worker.result.redis.RedisResult;
import com.servant.wiki.worker.task.redis.WriteTask;

public class DemoTask extends WriteTask{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public void execute() {
		RedisResult redisResult = new RedisResult();
		Policy policy = new DemoPolicy(this);
		excuteTask(policy, this, redisResult);
	}
	
}

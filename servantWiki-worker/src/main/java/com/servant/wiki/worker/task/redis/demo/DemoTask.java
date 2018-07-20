package com.servant.wiki.worker.task.redis.demo;

import com.servant.wiki.worker.result.redis.RedisResult;
import com.servant.wiki.worker.task.redis.WriteTask;

public class DemoTask extends WriteTask{

	@Override
	public void execute() {
		RedisResult redisResult = new RedisResult();
		
	}
	
}

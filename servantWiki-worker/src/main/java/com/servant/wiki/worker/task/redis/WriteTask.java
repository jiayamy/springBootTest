package com.servant.wiki.worker.task.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servant.wiki.worker.policy.Policy;
import com.servant.wiki.worker.result.BaseResult;
import com.servant.wiki.worker.worker.redis.RedisWorker;


public abstract class WriteTask extends RedisWorker{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void excuteTask(Policy policy, WriteTask task, BaseResult result) {
		
    }
	
}

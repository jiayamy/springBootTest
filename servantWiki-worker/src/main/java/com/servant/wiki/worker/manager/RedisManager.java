package com.servant.wiki.worker.manager;

import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.servant.wiki.worker.task.redis.WriteTask;
import com.servant.wiki.worker.task.redis.demo.DemoTask;
import com.servant.wiki.worker.task.redis.demo.ResourceTask;
import com.servant.wiki.worker.thread.RedisThreadPool;
import com.servant.wiki.worker.thread.ThreadPoolFactory;

@Service
public class RedisManager {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ThreadPoolExecutor largeTaskPool = ThreadPoolFactory.getInstance()
			.getThreadPool("thread_pool_small_task",
					RedisThreadPool.POOL_SMALL);
	private ThreadPoolExecutor bigTaskPool = ThreadPoolFactory.getInstance()
			.getThreadPool("thread_pool_middle_task",
					RedisThreadPool.POOL_MIDDLE);
	private ThreadPoolExecutor normalTaskPool = ThreadPoolFactory.getInstance()
			.getThreadPool("thread_pool_large_task",
					RedisThreadPool.POOL_LARGE);
//	@Async
	public void submit(WriteTask task){
		if("demo".equals(task.getType()) 
				|| "w_resource".equals(task.getType())){
			bigTaskPool.submit(task);
		}
	}
	
	public WriteTask getTaskByType(String type){
		if("demo".equals(type)){
			return new DemoTask();
		}
		if("w_resource".equals(type)){
			return new ResourceTask();
		}
		return null;
	}
}



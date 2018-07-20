package com.servant.wiki.worker.manager;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.stereotype.Service;

import com.servant.wiki.worker.task.redis.WriteTask;
import com.servant.wiki.worker.task.redis.demo.DemoTask;
import com.servant.wiki.worker.thread.RedisThreadPool;
import com.servant.wiki.worker.thread.ThreadPoolFactory;

@Service
public class RedisManager {

	private ThreadPoolExecutor largeTaskPool = ThreadPoolFactory.getInstance()
			.getThreadPool("thread_pool_export_large_task",
					RedisThreadPool.POOL_SMALL);
	private ThreadPoolExecutor bigTaskPool = ThreadPoolFactory.getInstance()
			.getThreadPool("thread_pool_export_big_task",
					RedisThreadPool.POOL_MIDDLE);
	private ThreadPoolExecutor normalTaskPool = ThreadPoolFactory.getInstance()
			.getThreadPool("thread_pool_export_normal_task",
					RedisThreadPool.POOL_LARGE);
	
	public void submit(WriteTask task){
		if("demo".equals(task.getType())){
			bigTaskPool.submit(task);
		}
	}
	
	public WriteTask getTaskByType(String type){
		if("demo".equals(type)){
			return new DemoTask();
		}
		return null;
	}
}



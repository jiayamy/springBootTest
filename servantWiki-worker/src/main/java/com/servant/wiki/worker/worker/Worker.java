package com.servant.wiki.worker.worker;

import java.io.Serializable;
import java.util.Map;

public interface Worker extends Runnable, Serializable{

	/**
	 * 线程池的名称
	 * 
	 * @param name
	 */
	String getPoolName();

	/**
	 * 设置这个任务属于哪个线程池
	 * 
	 * @param name
	 */
	void setPoolName(String name);

	void setWorkName(String workName);

	String getWorkName();

	void execute();

	void setMessage(Map<? extends Serializable,? extends Serializable> params);

	Map getMessage();

	void submit();

	void end();

	/**
	 * 返回这个任务是否成功执行
	 * 
	 * @return
	 */
	boolean isSucc();

	void setSucc(boolean succ);
	
	/**
	 * 设置任务回调
	 * @param callBack
	 */
	void setCallBack(WorkerCallBack callBack);
	
	WorkerCallBack getCallBack();
}

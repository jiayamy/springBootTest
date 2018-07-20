package com.servant.wiki.worker.worker.redis;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

import com.servant.wiki.worker.worker.Worker;
import com.servant.wiki.worker.worker.WorkerCallBack;

public abstract class RedisWorker implements Worker {

	private static final long serialVersionUID = 1L;

	private boolean succ = false;

	private String poolName;
	/**
	 * work名称，保证同一个线程池中唯一
	 */
	private String workName;

	protected Map<? extends Serializable, ? extends Serializable> params;

	protected WorkerCallBack callBack;

	public void run() {

		try {
			execute();
			if (callBack != null) {
				callBack.complete(params);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void submit() {
		// TODO: 提交时需要处理
	}
	
	@Override
	public void end() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPoolName() {
		return poolName;
	}

	@Override
	public void setPoolName(String name) {
		this.poolName = name;
	}

	@Override
	public void setWorkName(String workName) {
		this.workName = workName;
	}

	@Override
	public String getWorkName() {
		if (workName == null) {
			return UUID.randomUUID().toString();
		}
		return workName;
	}

	@Override
	public void setMessage(Map<? extends Serializable, ? extends Serializable> params) {
		this.params = params;
	}

	@Override
	public Map getMessage() {
		return params;
	}

	@Override
	public boolean isSucc() {
		return this.succ;
	}

	@Override
	public void setSucc(boolean succ) {
		this.succ = succ;
	}

	@Override
	public void setCallBack(WorkerCallBack callBack) {
		this.callBack = callBack;
	}

	@Override
	public WorkerCallBack getCallBack() {
		return callBack;
	}

}

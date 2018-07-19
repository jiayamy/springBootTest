package com.servant.wiki.worker.worker.redis;

import java.io.Serializable;
import java.util.Map;

import com.servant.wiki.worker.worker.Worker;
import com.servant.wiki.worker.worker.WorkerCallBack;

public abstract class RedisWorker implements Worker{

	private static final long serialVersionUID = 1L;
	
	protected Map<? extends Serializable, ? extends Serializable> params;
	
	protected WorkerCallBack callBack;
	
	public void run(){
		
		try {
			execute();
			if(callBack != null){
				callBack.complete(params);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void submit() {
		// TODO: 提交时需要处理
	}

}

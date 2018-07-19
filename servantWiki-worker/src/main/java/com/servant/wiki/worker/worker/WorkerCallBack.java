package com.servant.wiki.worker.worker;

public interface WorkerCallBack<T> {

	public void complete(T param);

	public void failed(Throwable t);
	
}

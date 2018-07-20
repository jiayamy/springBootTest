package com.servant.wiki.worker.result;

import java.io.Serializable;

public class BaseResult implements Serializable{

	private static final long serialVersionUID = 1L;
	
	String msg;
	
	Object data;
	
	String code;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}

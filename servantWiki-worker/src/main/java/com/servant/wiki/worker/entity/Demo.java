package com.servant.wiki.worker.entity;

import java.io.Serializable;

public class Demo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String content;

	private String addition;

	private String content2;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAddition() {
		return addition;
	}

	public void setAddition(String addition) {
		this.addition = addition;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}
	
}

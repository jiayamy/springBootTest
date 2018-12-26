package com.servant.wiki.core.entity.validate;

import java.io.Serializable;
import java.util.List;

public class ValidateResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer spam;
	
	private List<ValidatePoint> review;
	
	private List<ValidatePoint> reject;
	
	private List<ValidatePoint> pass;

	public Integer getSpam() {
		return spam;
	}

	public void setSpam(Integer spam) {
		this.spam = spam;
	}

	public List<ValidatePoint> getReview() {
		return review;
	}

	public void setReview(List<ValidatePoint> review) {
		this.review = review;
	}

	public List<ValidatePoint> getReject() {
		return reject;
	}

	public void setReject(List<ValidatePoint> reject) {
		this.reject = reject;
	}

	public List<ValidatePoint> getPass() {
		return pass;
	}

	public void setPass(List<ValidatePoint> pass) {
		this.pass = pass;
	}
	
}

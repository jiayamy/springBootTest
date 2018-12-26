package com.servant.wiki.core.entity.validate;

import java.io.Serializable;
import java.util.List;

public class ValidatePoint implements Serializable{

	private static final long serialVersionUID = 1L;

	private Double score;
	
	private List<String> hit;
	
	private Integer label;

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public List<String> getHit() {
		return hit;
	}

	public void setHit(List<String> hit) {
		this.hit = hit;
	}

	public Integer getLabel() {
		return label;
	}

	public void setLabel(Integer label) {
		this.label = label;
	}
	
}

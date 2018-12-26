package com.servant.wiki.core.maze.site;

public enum Direction {
	
	North(1, "北面"),
	
	South(2, "南面"),
	
	West(3, "西面"),
	
	East(4, "东面");
	
	private int code;
	
	private String description;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	Direction(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static Direction getByCode(int code) {
        for (Direction codeEnum : Direction.values()) {
            if (codeEnum.getCode() == code) {
                return codeEnum;
            }
        }
        return null;
    }
}

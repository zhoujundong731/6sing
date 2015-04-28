package com.zhou.song.bean;

import java.io.Serializable;

public class ArtType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1538960393246566085L;
	private Long atId;
	private String atName;
	public Long getAtId() {
		return atId;
	}
	public void setAtId(Long atId) {
		this.atId = atId;
	}
	public String getAtName() {
		return atName;
	}
	public void setAtName(String atName) {
		this.atName = atName;
	}
	@Override
	public String toString() {
		return "ArtType [atId=" + atId + ", atName=" + atName + "]";
	}
	
	
}

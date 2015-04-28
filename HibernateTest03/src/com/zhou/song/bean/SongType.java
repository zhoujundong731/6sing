package com.zhou.song.bean;

import java.io.Serializable;

public class SongType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5612109349658895226L;
	private Long stId;
	private String stName;
	
	public Long getStId() {
		return stId;
	}
	public void setStId(Long stId) {
		this.stId = stId;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	@Override
	public String toString() {
		return "SongType [stId=" + stId + ", stName=" + stName + "]";
	}
	public SongType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

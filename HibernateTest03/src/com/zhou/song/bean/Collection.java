package com.zhou.song.bean;

import java.io.Serializable;
import java.util.Date;

public class Collection implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4741639947500247202L;
	private Long ctId;
	private Long singerId;
	private Long songId;
	private Date createDate;
	public Long getCtId() {
		return ctId;
	}
	public void setCtId(Long ctId) {
		this.ctId = ctId;
	}
	public Long getSingerId() {
		return singerId;
	}
	public void setSingerId(Long singerId) {
		this.singerId = singerId;
	}
	public Long getSongId() {
		return songId;
	}
	public void setSongId(Long songId) {
		this.songId = songId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Collection [ctId=" + ctId + ", singerId=" + singerId
				+ ", songId=" + songId + ", createDate=" + createDate + "]";
	}
	public Collection() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

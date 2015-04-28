package com.zhou.song.bean;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7879978380128180997L;
	private Long cId;
	private Long songId;
	private Long userId;
	private String userName;
	private String userImgAdd;
	private Date createDate;
	private String cText;
	public Long getcId() {
		return cId;
	}
	public void setcId(Long cId) {
		this.cId = cId;
	}
	public Long getSongId() {
		return songId;
	}
	public void setSongId(Long songId) {
		this.songId = songId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserImgAdd() {
		return userImgAdd;
	}
	public void setUserImgAdd(String userImgAdd) {
		this.userImgAdd = userImgAdd;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getcText() {
		return cText;
	}
	public void setcText(String cText) {
		this.cText = cText;
	}
	@Override
	public String toString() {
		return "Comment [cId=" + cId + ", songId=" + songId + ", userId="
				+ userId + ", userName=" + userName + ", userImgAdd="
				+ userImgAdd + ", createDate=" + createDate + ", cText="
				+ cText + "]";
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
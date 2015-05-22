package com.zhou.song.bean;

import java.io.Serializable;
import java.util.Date;

import com.zhou.account.bean.UserAccount;

public class Collection implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4741639947500247202L;
	private Long ctId;
/*	private Long singerId;
	private Long songId;*/
	private Date createDate;
	private UserAccount user;
	private Song song;
	
	public UserAccount getUser() {
		return user;
	}
	public void setUser(UserAccount user) {
		this.user = user;
	}
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}
	public Long getCtId() {
		return ctId;
	}
	public void setCtId(Long ctId) {
		this.ctId = ctId;
	}
/*	public Long getSingerId() {
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
	}*/
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/*@Override
	public String toString() {
		return "Collection [ctId=" + ctId + ", singerId=" + singerId
				+ ", songId=" + songId + ", createDate=" + createDate + "]";
	}*/
	
	
	public Collection() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Collection [ctId=" + ctId + ", createDate=" + createDate
				+ "]";
	}
	/*+ ", song=" + song */
	
}

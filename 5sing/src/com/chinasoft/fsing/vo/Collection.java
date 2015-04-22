package com.chinasoft.fsing.vo;

import java.io.Serializable;
import java.util.Date;

import com.chinasoft.fsing.util.DateUtil;

public class Collection implements Serializable{
	private long ctid;
	private String cttime;
	private User user;
	private Song song;
	
	//全信息构造方法
	public Collection(long ctid, String cttime, User user, Song song) {
		super();
		this.ctid = ctid;
		this.cttime = cttime;
		this.user = user;
		this.song = song;
	}
	//添加的构造方法

	public Collection(User user, Song song) {
		super();
		Date date=new Date();
		this.user = user;
		this.song = song;
		this.ctid=DateUtil.getLongTime(date);
		this.cttime=DateUtil.getTime(date);
	}

	public long getCtid() {
		return ctid;
	}

	public void setCtid(long ctid) {
		this.ctid = ctid;
	}

	public String getCttime() {
		return cttime;
	}

	public void setCttime(String cttime) {
		this.cttime = cttime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}
	
	
	
	

}

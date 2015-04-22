package com.chinasoft.fsing.vo;

import java.io.Serializable;
import java.util.Date;

import com.chinasoft.fsing.util.DateUtil;

public class Comment implements Serializable{
	private long cid;
	private String ctext;
	private String ctime;
	private User user;
	private Song song;
	
	//全信息的构造方法
	public Comment(long cid, String ctext, String ctime, User user, Song song) {
		super();
		this.cid = cid;
		this.ctext = ctext;
		this.ctime = ctime;
		this.user = user;
		this.song = song;
	}
	//添加的构造方法
	public Comment(String ctext, User user, Song song) {
		super();
		Date date=new Date();
		this.ctext = ctext;
		this.user = user;
		this.song = song;
		this.cid=DateUtil.getLongTime(date);
		this.ctime=DateUtil.getTime(date);
	}
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public String getCtext() {
		return ctext;
	}
	public void setCtext(String ctext) {
		this.ctext = ctext;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
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

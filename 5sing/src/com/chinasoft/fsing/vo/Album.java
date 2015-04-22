package com.chinasoft.fsing.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.chinasoft.fsing.util.DateUtil;
//专辑 
public class Album  implements Serializable{
	private int bid;
	private String bname;
	private String btext;
	private String btime;
	private String bimage;
	private User user;
	private List<Song> songs;
	
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	public Album() {
		super();
	}
	//全部信息的构造方法
	public Album(int bid, String bname, String btext, String btime,
			String bimage, User user) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.btext = btext;
		this.btime = btime;
		this.bimage = bimage;
		this.user = user;
	}
	//没有用户的构造方法
	public Album(int bid, String bname, String btext, String btime,
			String bimage) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.btext = btext;
		this.btime = btime;
		this.bimage = bimage;
	}
	//添加专辑
	public Album(String bname, String btext, String bimage,
			User user) {
		super();
		this.bname = bname;
		this.btext = btext;
		Date date=new Date();
		this.btime = DateUtil.getTime(date);
		this.bimage = bimage;
		this.user = user;
	}
	
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBtext() {
		return btext;
	}
	public void setBtext(String btext) {
		this.btext = btext;
	}
	public String getBtime() {
		return btime;
	}
	public void setBtime(String btime) {
		this.btime = btime;
	}
	public String getBimage() {
		return bimage;
	}
	public void setBimage(String bimage) {
		this.bimage = bimage;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}

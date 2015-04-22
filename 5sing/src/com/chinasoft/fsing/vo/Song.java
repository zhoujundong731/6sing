package com.chinasoft.fsing.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.chinasoft.fsing.util.DateUtil;

public class Song  implements Serializable{
	private long sid;
	private User user;
	private Album album;
	private String sname;
	private String smaddress;
	private String swaddress;
	private String svaddress;
	private String slrc;
	private String stext;
	private int sclick;
	private int sdown;
	private int scnum;
	private String stime;
	private List<SongType> songtypes;
	
	public Song() {
		super();
	}
	
	
	
	public Song(long sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}



	//没有歌曲类型的构造方法
	public Song(long sid, User user, Album album, String sname,
			String smaddress, String swaddress, String svaddress, String slrc,String stext,
			int sclick, int sdown, int scnum, String stime) {
		super();
		this.sid = sid;
		this.user = user;
		this.album = album;
		this.sname = sname;
		this.smaddress = smaddress;
		this.swaddress = swaddress;
		this.svaddress = svaddress;
		this.slrc=slrc;
		this.stext = stext;
		this.sclick = sclick;
		this.sdown = sdown;
		this.scnum = scnum;
		this.stime = stime;
	}
	//添加的构造方法
	public Song(User user, Album album, String sname, String smaddress,
			String swaddress, String svaddress, String slrc,String stext) {
		super();
		this.user = user;
		this.album = album;
		this.sname = sname;
		this.smaddress = smaddress;
		this.swaddress = swaddress;
		this.svaddress = svaddress;
		this.slrc=slrc;
		this.stext = stext;
		Date date=new Date();
		this.stime=DateUtil.getTime(date);
		this.sid=DateUtil.getLongTime(date);
	}
	
	//查询全部歌曲的构造方法
	public Song(long sid, User user, String sname, String smaddress,
			String swaddress, String svaddress, String stext, int sclick,
			int sdown, int scnum) {
		super();
		this.sid = sid;
		this.user = user;
		this.sname = sname;
		this.smaddress = smaddress;
		this.swaddress = swaddress;
		this.svaddress = svaddress;
		this.stext = stext;
		this.sclick = sclick;
		this.sdown = sdown;
		this.scnum = scnum;
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSmaddress() {
		return smaddress;
	}
	public void setSmaddress(String smaddress) {
		this.smaddress = smaddress;
	}
	public String getSwaddress() {
		return swaddress;
	}
	public void setSwaddress(String swaddress) {
		this.swaddress = swaddress;
	}
	public String getSvaddress() {
		return svaddress;
	}
	public void setSvaddress(String svaddress) {
		this.svaddress = svaddress;
	}
	public String getStext() {
		return stext;
	}
	public void setStext(String stext) {
		this.stext = stext;
	}
	public int getSclick() {
		return sclick;
	}
	public void setSclick(int sclick) {
		this.sclick = sclick;
	}
	public int getSdown() {
		return sdown;
	}
	public void setSdown(int sdown) {
		this.sdown = sdown;
	}
	public int getScnum() {
		return scnum;
	}
	public String getSlrc() {
		return slrc;
	}
	public void setSlrc(String slrc) {
		this.slrc = slrc;
	}
	public void setScnum(int scnum) {
		this.scnum = scnum;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public List<SongType> getSongtypes() {
		return songtypes;
	}
	public void setSongtypes(List<SongType> songtypes) {
		this.songtypes = songtypes;
	}
	
	

}

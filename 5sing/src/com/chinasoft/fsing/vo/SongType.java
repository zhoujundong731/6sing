package com.chinasoft.fsing.vo;

import java.io.Serializable;
import java.util.List;

public class SongType implements Serializable{
	private int stid;
	private String stname;
	private List<Song> songs;
	//全信息构造方法
	public SongType(int stid, String stname, List<Song> songs) {
		super();
		this.stid = stid;
		this.stname = stname;
		this.songs = songs;
	}
	//没有歌曲的构造方法
	public SongType(int stid, String stname) {
		super();
		this.stid = stid;
		this.stname = stname;
	}
	//添加歌曲类型的构造方法
	public SongType(String stname) {
		super();
		this.stname = stname;
	}
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	
	
	
	
	//

	

}

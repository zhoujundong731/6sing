package com.chinasoft.fsing.vo;

import java.io.Serializable;

public class SubMenu  implements Serializable{
	private  int suid;
	private int mid;
	private String suname;
	private String supath;
	private int isdirect;
	private int suorder;
	private int sudisplay;
	//全信息构造
	public SubMenu(int suid, int mid, String suname, String supath,
			int isdirect, int suorder, int sudisplay) {
		super();
		this.suid = suid;
		this.mid = mid;
		this.suname = suname;
		this.supath = supath;
		this.isdirect = isdirect;
		this.suorder = suorder;
		this.sudisplay = sudisplay;
	}
	//显示菜单的构造方法
	public SubMenu(int suid, String suname, String supath, int isdirect) {
		super();
		this.suid = suid;
		this.suname = suname;
		this.supath = supath;
		this.isdirect = isdirect;
	}
	//
	public int getSuid() {
		return suid;
	}
	public void setSuid(int suid) {
		this.suid = suid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getSuname() {
		return suname;
	}
	public void setSuname(String suname) {
		this.suname = suname;
	}
	public String getSupath() {
		return supath;
	}
	public void setSupath(String supath) {
		this.supath = supath;
	}
	public int getIsdirect() {
		return isdirect;
	}
	public void setIsdirect(int isdirect) {
		this.isdirect = isdirect;
	}
	public int getSuorder() {
		return suorder;
	}
	public void setSuorder(int suorder) {
		this.suorder = suorder;
	}
	public int getSudisplay() {
		return sudisplay;
	}
	public void setSudisplay(int sudisplay) {
		this.sudisplay = sudisplay;
	}
	
	
	

}

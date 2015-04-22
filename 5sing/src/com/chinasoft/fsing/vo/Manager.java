package com.chinasoft.fsing.vo;

import java.io.Serializable;

public class Manager  implements Serializable {
	private int mid;
	private String mname;
	private String mpass;
	private String mphone;
	private String memail;
	private int mpower;
	private int mflag;
	//管理员信息读取(没有密码)
	public Manager(int mid, String mname, String mphone, String memail,
			int mpower, int mflag) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mphone = mphone;
		this.memail = memail;
		this.mpower = mpower;
		this.mflag = mflag;
	}
	public Manager() {
		super();
	}
	
	//登陆
	public Manager(String mname, String mpass) {
		super();
		this.mname = mname;
		this.mpass = mpass;
	}
	//添加的封装
	public Manager(String mname, String mpass, String mphone, String memail) {
		super();
		this.mname = mname;
		this.mpass = mpass;
		this.mphone = mphone;
		this.memail = memail;
	}

	
	//全部信息封装
	public Manager(int mid, String mname, String mpass, String mphone,
			String memail, int mpower, int mflag) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mpass = mpass;
		this.mphone = mphone;
		this.memail = memail;
		this.mpower = mpower;
		this.mflag = mflag;
	}

	
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMpass() {
		return mpass;
	}

	public void setMpass(String mpass) {
		this.mpass = mpass;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public int getMpower() {
		return mpower;
	}

	public void setMpower(int mpower) {
		this.mpower = mpower;
	}
	public int getMflag() {
		return mflag;
	}
	public void setMflag(int mflag) {
		this.mflag = mflag;
	}

}

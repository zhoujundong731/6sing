package com.chinasoft.fsing.vo;

import java.io.Serializable;
import java.util.Date;

import com.chinasoft.fsing.util.DateUtil;

public class Notic implements Serializable{
	private long nid;
	private String ntitle;
	private String ntext;
	private String nimage;
	private String ntime;
	private int nflag;
	private Manager manager;
	//全信息构造方法
	public Notic(long nid, String ntitle, String ntext, String nimage,
			String ntime, int nflag, Manager manager) {
		super();
		this.nid = nid;
		this.ntitle = ntitle;
		this.ntext = ntext;
		this.nimage = nimage;
		this.ntime = ntime;
		this.nflag = nflag;
		this.manager = manager;
	}
	//查看信息的构造方法
	public Notic(long nid, String ntitle, String ntext, String nimage,
			String ntime) {
		super();
		this.nid = nid;
		this.ntitle = ntitle;
		this.ntext = ntext;
		this.nimage = nimage;
		this.ntime = ntime;
	}
	//发布公告的构造方法
	public Notic(String ntitle, String ntext, String nimage, Manager manager) {
		super();
		Date date=new Date();
		this.nid=DateUtil.getLongTime(date);
		this.ntime=DateUtil.getTime(date);
		this.nflag=0;
		this.ntitle = ntitle;
		this.ntext = ntext;
		this.nimage = nimage;
		this.manager = manager;
	}
	
	public long getNid() {
		return nid;
	}
	public void setNid(long nid) {
		this.nid = nid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNtext() {
		return ntext;
	}
	public void setNtext(String ntext) {
		this.ntext = ntext;
	}
	public String getNimage() {
		return nimage;
	}
	public void setNimage(String nimage) {
		this.nimage = nimage;
	}
	public String getNtime() {
		return ntime;
	}
	public void setNtime(String ntime) {
		this.ntime = ntime;
	}
	public int getNflag() {
		return nflag;
	}
	public void setNflag(int nflag) {
		this.nflag = nflag;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	
	

}

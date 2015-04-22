package com.chinasoft.fsing.vo;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable{
	private int mid;
	private String mname;
	private int morder;
	private int mpower;
	private int mdisplay;
	private List<SubMenu> submenus;
	//没有子菜单的构造方法
	public Menu(int mid, String mname, int morder, int mpower, int mdisplay) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.morder = morder;
		this.mpower = mpower;
		this.mdisplay = mdisplay;
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
	public int getMorder() {
		return morder;
	}
	public void setMorder(int morder) {
		this.morder = morder;
	}
	public int getMpower() {
		return mpower;
	}
	public void setMpower(int mpower) {
		this.mpower = mpower;
	}
	public int getMdisplay() {
		return mdisplay;
	}
	public void setMdisplay(int mdisplay) {
		this.mdisplay = mdisplay;
	}
	public List<SubMenu> getSubmenus() {
		return submenus;
	}
	public void setSubmenus(List<SubMenu> submenus) {
		this.submenus = submenus;
	}
	
	
	
	
	

}

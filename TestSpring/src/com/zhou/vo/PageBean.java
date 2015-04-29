package com.zhou.vo;

import java.util.ArrayList;

public class PageBean {
	private int showNumber;//每页显示的条目数
	private int currentPage;//当前页数
	private int totalElement;//总条目数
	private int totalPage;//总页数
	private ArrayList date;
	public int getShowNumber() {
		return showNumber;
	}
	public void setShowNumber(int showNumber) {
		this.showNumber = showNumber;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalElement() {
		return totalElement;
	}
	public void setTotalElement(int totalElement) {
		this.totalElement = totalElement;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}

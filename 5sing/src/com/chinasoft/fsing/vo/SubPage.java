package com.chinasoft.fsing.vo;

import java.io.Serializable;
public class SubPage implements Serializable {
	private int showNumber;//每页显示的条目数
	private int currentPage;//当前页数
	private int totalElement;//总条目数
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
	public SubPage(int showNumber, int currentPage, int totalElement) {
		super();
		this.showNumber = showNumber;
		this.currentPage = currentPage;
		this.totalElement = totalElement;
	}
	public SubPage() {
		super();
	}
	//获取总的页面数
	public int getTotalPage(){
		return (totalElement-1)/showNumber+1;
	}
	//起始位置
	public int getStartIndex(){
		return(currentPage-1)*showNumber;
	}
	//上一页
	public int getPrev(){
		int temp= currentPage-1;
		if(temp<1){
			temp=1;
		}
		return temp;
	}
	//下一页
	public int getNexts(){
		int temp=currentPage+1;
		if(temp>this.getTotalPage()){
			temp=this.getTotalPage();
		}
		return temp;
	}

}

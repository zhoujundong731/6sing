package com.chinasoft.fsing.vo;

import java.io.Serializable;
public class SubPage implements Serializable {
	private int showNumber;//ÿҳ��ʾ����Ŀ��
	private int currentPage;//��ǰҳ��
	private int totalElement;//����Ŀ��
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
	//��ȡ�ܵ�ҳ����
	public int getTotalPage(){
		return (totalElement-1)/showNumber+1;
	}
	//��ʼλ��
	public int getStartIndex(){
		return(currentPage-1)*showNumber;
	}
	//��һҳ
	public int getPrev(){
		int temp= currentPage-1;
		if(temp<1){
			temp=1;
		}
		return temp;
	}
	//��һҳ
	public int getNexts(){
		int temp=currentPage+1;
		if(temp>this.getTotalPage()){
			temp=this.getTotalPage();
		}
		return temp;
	}

}

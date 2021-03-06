package com.zhou.song.bean;

import java.io.Serializable;
import java.util.Date;

public class Album implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5253649476595544010L;
	private Long bId;
	private String bName;
	private String bText;
	private String bImage;
	private Date bIssueDate;
	private Date bCreateDate;
	private String bOwner;
	private Long singerId;
	
	
	public Long getbId() {
		return bId;
	}



	public void setbId(Long bId) {
		this.bId = bId;
	}



	public String getbName() {
		return bName;
	}



	public void setbName(String bName) {
		this.bName = bName;
	}



	public String getbText() {
		return bText;
	}



	public void setbText(String bText) {
		this.bText = bText;
	}



	public String getbImage() {
		return bImage;
	}



	public void setbImage(String bImage) {
		this.bImage = bImage;
	}



	public Date getbIssueDate() {
		return bIssueDate;
	}



	public void setbIssueDate(Date bIssueDate) {
		this.bIssueDate = bIssueDate;
	}



	public Date getbCreateDate() {
		return bCreateDate;
	}



	public void setbCreateDate(Date bCreateDate) {
		this.bCreateDate = bCreateDate;
	}


	public String getbOwner() {
		return bOwner;
	}



	public void setbOwner(String bOwner) {
		this.bOwner = bOwner;
	}



	public Long getSingerId() {
		return singerId;
	}



	public void setSingerId(Long singerId) {
		this.singerId = singerId;
	}



	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Album [bId=" + bId + ", bName=" + bName + ", bText=" + bText
				+ ", bImage=" + bImage + ", bIssueDate=" + ", bOwner=" + bOwner
				+ ", singerId=" + singerId
				+ "]";
	}
	
}

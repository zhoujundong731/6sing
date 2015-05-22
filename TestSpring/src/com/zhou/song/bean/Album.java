package com.zhou.song.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.zhou.account.bean.SingerAccount;

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
	private Set<Song> songs=new HashSet<Song>();
	private SingerAccount singer;
	
	
	public SingerAccount getSinger() {
		return singer;
	}



	public void setSinger(SingerAccount singer) {
		this.singer = singer;
	}



	public Set<Song> getSongs() {
		return songs;
	}



	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}



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


	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Album [bId=" + bId + ", bName=" + bName + ", bText=" + bText
				+ ", bImage=" + bImage + ", bIssueDate=" + ", bOwner=" + bOwner
				+ "]";
	}
	
}

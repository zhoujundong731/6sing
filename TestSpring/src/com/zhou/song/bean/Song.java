package com.zhou.song.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.zhou.account.bean.Account;

public class Song implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -464485369861555359L;
	private Long sId;
	private String sName;
	private String sMp3Add;
	private String sWAdd;
	private String sMvAdd;
	private String sLrcAdd;
	private String sText;
	private int sClickNum;
	private int sDown;
	private String sOwner;
	private String sAlbum;
/*	private Long singerId;*/
	private Date createDate;
	private Set<SongType> songtypes=new HashSet<SongType>();
	private Account account;
	private Album album;
	private Set<Comment> comments=new HashSet<Comment>();
	 
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Set<SongType> getSongtypes() {
		return songtypes;
	}
	public void setSongtypes(Set<SongType> songtypes) {
		this.songtypes = songtypes;
	}
	public Long getsId() {
		return sId;
	}
	public void setsId(Long sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsMp3Add() {
		return sMp3Add;
	}
	public void setsMp3Add(String sMp3Add) {
		this.sMp3Add = sMp3Add;
	}
	public String getsWAdd() {
		return sWAdd;
	}
	public void setsWAdd(String sWAdd) {
		this.sWAdd = sWAdd;
	}
	public String getsMvAdd() {
		return sMvAdd;
	}
	public void setsMvAdd(String sMvAdd) {
		this.sMvAdd = sMvAdd;
	}
	public String getsLrcAdd() {
		return sLrcAdd;
	}
	public void setsLrcAdd(String sLrcAdd) {
		this.sLrcAdd = sLrcAdd;
	}
	public String getsText() {
		return sText;
	}
	public void setsText(String sText) {
		this.sText = sText;
	}
	public int getsClickNum() {
		return sClickNum;
	}
	public void setsClickNum(int sClickNum) {
		this.sClickNum = sClickNum;
	}
	public int getsDown() {
		return sDown;
	}
	public void setsDown(int sDown) {
		this.sDown = sDown;
	}
	public String getsOwner() {
		return sOwner;
	}
	public void setsOwner(String sOwner) {
		this.sOwner = sOwner;
	}
	public String getsAlbum() {
		return sAlbum;
	}
	public void setsAlbum(String sAlbum) {
		this.sAlbum = sAlbum;
	}
	/*public Long getSingerId() {
		return singerId;
	}
	public void setSingerId(Long singerId) {
		this.singerId = singerId;
	}*/
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Song [sId=" + sId + ", sName=" + sName + ", sMp3Add=" + sMp3Add
				+ ", sWAdd=" + sWAdd + ", sMvAdd=" + sMvAdd + ", sLrcAdd="
				+ sLrcAdd + ", sText=" + sText + ", sClickNum=" + sClickNum
				+ ", sDown=" + sDown + ", sOwner=" + sOwner + ", sAlbum="
				+ sAlbum + ", createDate=" + createDate + "]";
	}
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

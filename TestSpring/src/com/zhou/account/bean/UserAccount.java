package com.zhou.account.bean;

import java.util.HashSet;
import java.util.Set;

import com.zhou.song.bean.Collection;
import com.zhou.song.bean.Comment;
import com.zhou.song.bean.Song;

public class UserAccount extends Account {
	/**
	 * 
	 */
	private static final long serialVersionUID = -403630745067224249L;
	private String nikeName;
	private String password;
	private String email;
	private Long phoneNumber;
	private String presentation;
	private String address;
	private Set<Song> songs=new HashSet<Song>();
	private Set<Collection> collections=new HashSet<Collection>();
	private Set<Comment> comments=new HashSet<Comment>();
	
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Set<Collection> getCollections() {
		return collections;
	}
	public void setCollections(Set<Collection> collections) {
		this.collections = collections;
	}
	public Set<Song> getSongs() {
		return songs;
	}
	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNikeName() {
		return nikeName;
	}
	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public UserAccount() {
		super();
		this.setType(AccountTypes.USER.name());
	}
	@Override
	public String toString() {
		return "UserAccount [nikeName=" + nikeName
				+ ", password=" + password + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", presentation="
				+ presentation + ",address="+ address +", toString()=" + super.toString() + "]";
	}	
}

package com.zhou.account.bean;

import java.util.Date;

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

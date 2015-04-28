package com.zhou.account.bean;

public class ManagerAccount extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3215871868959565587L;
	private String email;
	private String phoneNumber;
	private Integer power;
	private String password;
	
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Integer getPower() {
		return power;
	}


	public void setPower(Integer power) {
		this.power = power;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	

	@Override
	public String toString() {
		return "ManagerAccount [email=" + email + ", phoneNumber="
				+ phoneNumber + ", power=" + power + ", password=" + password
				+ ", toString()=" + super.toString() + "]";
	}


	public ManagerAccount() {
		super();
		this.setType(AccountTypes.MANAGER.name());
	}
	
	
	
}

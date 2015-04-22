package com.chinasoft.fsing.vo;

import java.io.Serializable;
import java.util.List;

public class ArtType  implements Serializable {
	private int atid;
	private String atname;
	private List<User> users;
	
	
	public ArtType() {
		super();
	}
	//ֻ��ID
	public ArtType(int atid) {
		super();
		this.atid = atid;
	}
	//û�и��ֹ��췽��
	public ArtType(int atid, String atname) {
		super();
		this.atid = atid;
		this.atname = atname;
	}

	//��ӵĹ��췽��
	public ArtType(String atname) {
		super();
		this.atname = atname;
	}
	public int getAtid() {
		return atid;
	}
	public void setAtid(int atid) {
		this.atid = atid;
	}
	public String getAtname() {
		return atname;
	}
	public void setAtname(String atname) {
		this.atname = atname;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

}

package com.zhou.song.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.zhou.account.bean.SingerAccount;

public class ArtType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1538960393246566085L;
	private Long atId;
	private String atName;
	private Set<SingerAccount> singers=new HashSet<SingerAccount>();
	
	
	public Set<SingerAccount> getSingers() {
		return singers;
	}
	public void setSingers(Set<SingerAccount> singers) {
		this.singers = singers;
	}
	public Long getAtId() {
		return atId;
	}
	public void setAtId(Long atId) {
		this.atId = atId;
	}
	public String getAtName() {
		return atName;
	}
	public void setAtName(String atName) {
		this.atName = atName;
	}
	@Override
	public String toString() {
		return "ArtType [atId=" + atId + ", atName=" + atName + "]";
	}
	
	
}

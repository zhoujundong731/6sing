package com.zhou.account.bean;

public class SingerAccount extends Account {

	/**
	 * 
	 */
	private static final long serialVersionUID = 837256776239388085L;
	/**
	 * 歌手简介
	 * 
	 */
	private String presentation;
	private int heat;
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public int getHeat() {
		return heat;
	}
	public void setHeat(int heat) {
		this.heat = heat;
	}
	public SingerAccount() {
		super();
		this.setType(AccountTypes.SINGER.name());
	}
	@Override
	public String toString() {
		return "SingerAccount [presentation=" + presentation + ", heat=" + heat
				+ ", toString()=" + super.toString() + "]";
	}
	
}

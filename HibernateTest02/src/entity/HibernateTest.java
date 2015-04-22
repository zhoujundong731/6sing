package entity;

import java.io.Serializable;

public class HibernateTest implements Serializable{
	/**
	 * 
	 */
	//private static final long serialVersionUID = -2237224168366855408L;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long hId;
	private String hName;
	private Double hNum;
	private int hAge;
	public int gethAge() {
		return hAge;
	}
	public void sethAge(int hAge) {
		this.hAge = hAge;
	}
	public Long gethId() {
		return hId;
	}
	public void sethId(Long hId) {
		this.hId = hId;
	}
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	public Double gethNum() {
		return hNum;
	}
	public void sethNum(Double hNum) {
		this.hNum = hNum;
	}
	@Override
	public String toString() {
		return "HibernateTest [hId=" + hId + ", hName=" + hName + ", hNum="
				+ hNum + ", hAge=" + hAge + "]";
	}

	
	
}

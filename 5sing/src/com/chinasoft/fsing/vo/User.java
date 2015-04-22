package com.chinasoft.fsing.vo;

import java.io.Serializable;
import java.util.List;

public class User  implements Serializable{
	private int uid;
	private String uaccount;
	private String uname;
	private String upass;
	private String uemail;
	private String uphone;
	private String uaddress;
	private int usex;
	private String uimage;
	private String usign;
	private int uflag;
	private int upower;
	private List<ArtType> arttypes;
	private List<Song> songs;
	
	
	public List<Song> getSongs() {
		return songs;
	}
	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
	public User() {
		super();
	}
	
	
	public User(int uid, String uname) {
		super();
		this.uid = uid;
		this.uname = uname;
	}
	//不带歌手类型的封装
	public User(int uid, String uaccount, String uname, String upass,
			String uemail, String uphone, String uaddress, int usex,
			String uimage, String usign, int uflag, int upower) {
		super();
		this.uid = uid;
		this.uaccount = uaccount;
		this.uname = uname;
		this.upass = upass;
		this.uemail = uemail;
		this.uphone = uphone;
		this.uaddress = uaddress;
		this.usex = usex;
		this.uimage = uimage;
		this.usign = usign;
		this.uflag = uflag;
		this.upower = upower;
	}

	

	//用户注册的构造方法
	public User(String uaccount, String upass, String uemail,
			String uphone, int usex) {
		super();
		this.uaccount = uaccount;
		this.upass = upass;
		this.uemail = uemail;
		this.uphone = uphone;
		this.usex = usex;
	}
	
	//查询歌手的构造方法
	public User(int uid, String uname, int usex, String uimage, String usign) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.usex = usex;
		this.uimage = uimage;
		this.usign = usign;
	}
	//(丁)----用于查询用户信息的构造方法（）
		public User( String uaccount, String uname,int uid, String uemail,int usex,
				String uphone, String uaddress,  String uimage,
				String usign) {
			super();
			this.uid = uid;
			this.uaccount = uaccount;
			this.uname = uname;
			this.uemail = uemail;
			this.uphone = uphone;
			this.uaddress = uaddress;
			this.usex = usex;
			this.uimage = uimage;
			this.usign = usign;
		}
	//丁
	public User(String uimage, String uaccount, int uid) {
		super();
		this.uid = uid;
		this.uaccount = uaccount;
		this.uimage = uimage;
	}
	
	public User(int uid, String uname, String uimage) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uimage = uimage;
	}
	//歌手添加
	public User(String uname, int usex,
			String uimage, String usign,List<ArtType> arttypes) {
		super();
		this.uname = uname;
		this.uaccount=uname;
		this.upass = "1";
		this.usex = usex;
		this.uimage = uimage;
		this.usign = usign;
		this.uflag = 1;
		this.upower = 1;
		this.arttypes = arttypes;
	}
	public int getUid() {
		return uid;
	}



	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUaccount() {
		return uaccount;
	}
	public void setUaccount(String uaccount) {
		this.uaccount = uaccount;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public int getUsex() {
		return usex;
	}
	public void setUsex(int usex) {
		this.usex = usex;
	}
	public String getUimage() {
		return uimage;
	}
	public void setUimage(String uimage) {
		this.uimage = uimage;
	}
	public String getUsign() {
		return usign;
	}
	public void setUsign(String usign) {
		this.usign = usign;
	}
	public int getUflag() {
		return uflag;
	}
	public void setUflag(int uflag) {
		this.uflag = uflag;
	}
	public int getUpower() {
		return upower;
	}
	public void setUpower(int upower) {
		this.upower = upower;
	}

//歌手类型封装
	public List<ArtType> getArttypes() {
		return arttypes;
	}
	public void setArttypes(List<ArtType> arttypes) {
		this.arttypes = arttypes;
	}
	
	

}

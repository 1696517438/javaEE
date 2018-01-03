package com.jio.entity;

public class User {
	private int uid ;
	private String uname;
	private String upassword;
	private int utype;
	private int uresumeid;
	private int eid;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public int getUtype() {
		return utype;
	}
	public void setUtype(int utype) {
		this.utype = utype;
	}
	public int getUresumeid() {
		return uresumeid;
	}
	public void setUresumeid(int uresumeid) {
		this.uresumeid = uresumeid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public User(int uid, String uname, String upassword, int utype, int uresumeid, int eid) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.utype = utype;
		this.uresumeid = uresumeid;
		this.eid = eid;
	}
	
	public User(String uname, String upassword, int utype) {
		super();
		this.uname = uname;
		this.upassword = upassword;
		this.utype = utype;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + ", utype=" + utype
				+ ", uresumeid=" + uresumeid + ", eid=" + eid + "]";
	}
}

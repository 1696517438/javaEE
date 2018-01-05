package com.jio.entity;

public class Post {
	private int pid;
	private String pname;
	private int did;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public Post(int pid, String pname, int did) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.did = did;
	}
	public Post() {
		super();
	}
	@Override
	public String toString() {
		return "Post [pid=" + pid + ", pname=" + pname + ", did=" + did + "]";
	}
	

}

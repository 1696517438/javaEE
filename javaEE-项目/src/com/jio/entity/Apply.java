package com.jio.entity;

import java.util.Date;

public class Apply {
	private int id;
	private String uname;
	private Date sendTime;
	private String status;
	private String interviewStatus;
	private String post;
	
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInterviewStatus() {
		return interviewStatus;
	}
	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	public Apply() {
		super();
	}
	public Apply(int id, String uname, Date sendTime, String status, String interviewStatus) {
		super();
		this.id = id;
		this.uname = uname;
		this.sendTime = sendTime;
		this.status = status;
		this.interviewStatus = interviewStatus;
	}
	public Apply(int id, String uname, Date sendTime, String status, String interviewStatus, String post) {
		super();
		this.id = id;
		this.uname = uname;
		this.sendTime = sendTime;
		this.status = status;
		this.interviewStatus = interviewStatus;
		this.post = post;
	}
	@Override
	public String toString() {
		return "Apply [id=" + id + ", uname=" + uname + ", sendTime=" + sendTime + ", status=" + status
				+ ", interviewStatus=" + interviewStatus + ", post=" + post + "]";
	}
	
}

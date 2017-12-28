package com.jio.entity;

public class Student {
	private int sId;
	private String sName;
	private String sPassword;
	private int sAge;
	private String sCreateDate;
	private Subject subject;

	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsPassword() {
		return sPassword;
	}
	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}
	public int getsAge() {
		return sAge;
	}
	public void setsAge(int sAge) {
		this.sAge = sAge;
	}
	public String getsCreateDate() {
		return sCreateDate;
	}
	public void setsCreateDate(String sCreateDate) {
		this.sCreateDate = sCreateDate;
	}


	public Student(int sId, String sName, String sPassword, int sAge, String sCreateDate, Subject subject) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sPassword = sPassword;
		this.sAge = sAge;
		this.sCreateDate = sCreateDate;
		this.subject = subject;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sPassword=" + sPassword + ", sAge=" + sAge
				+ ", sCreateDate=" + sCreateDate + ", subject=" + subject + "]";
	}
	
}

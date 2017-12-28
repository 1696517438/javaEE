package com.jio.entity;

public class AddStudent {
	private int sId;
	private String sName;
	private String sPassword;
	private int sAge;
	private String sCreateDate;
	private int subjectId;
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
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public AddStudent() {
		super();
	}
	public AddStudent(String sName, String sPassword, int sAge, String sCreateDate, int subjectId) {
		super();
		this.sName = sName;
		this.sPassword = sPassword;
		this.sAge = sAge;
		this.sCreateDate = sCreateDate;
		this.subjectId = subjectId;
	}
	public AddStudent(int sId, String sName, String sPassword, int sAge, String sCreateDate, int subjectId) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sPassword = sPassword;
		this.sAge = sAge;
		this.sCreateDate = sCreateDate;
		this.subjectId = subjectId;
	}
	
}

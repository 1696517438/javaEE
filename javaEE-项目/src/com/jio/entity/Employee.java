package com.jio.entity;

import java.util.Date;

public class Employee {
	private int eid;
	private String ename;
	private String egender;
	private int age;
	private String education;
	private String phone;
	private String email;
	private Date cometime;
	private String sface;
	private String hobby;
	private int rid;
	private String rename;
	private int did;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEgender() {
		return egender;
	}
	public void setEgender(String egender) {
		this.egender = egender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCometime() {
		return cometime;
	}
	public void setCometime(Date cometime) {
		this.cometime = cometime;
	}
	public String getSface() {
		return sface;
	}
	public void setSface(String sface) {
		this.sface = sface;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRename() {
		return rename;
	}
	public void setRename(String rename) {
		this.rename = rename;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public Employee() {
		super();
		
	}
	public Employee(String ename, String egender, int age, String education, String phone, String email, Date cometime,
			String sface, String hobby, int rid, String rename, int did) {
		super();
		this.ename = ename;
		this.egender = egender;
		this.age = age;
		this.education = education;
		this.phone = phone;
		this.email = email;
		this.cometime = cometime;
		this.sface = sface;
		this.hobby = hobby;
		this.rid = rid;
		this.rename = rename;
		this.did = did;
	}
	
	public Employee(int eid, String ename, String egender, int age, String education, String phone, String email,
			Date cometime, String sface, String hobby, int rid, String rename, int did) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.egender = egender;
		this.age = age;
		this.education = education;
		this.phone = phone;
		this.email = email;
		this.cometime = cometime;
		this.sface = sface;
		this.hobby = hobby;
		this.rid = rid;
		this.rename = rename;
		this.did = did;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", egender=" + egender + ", age=" + age + ", education="
				+ education + ", phone=" + phone + ", email=" + email + ", cometime=" + cometime + ", sface=" + sface
				+ ", hobby=" + hobby + ", rid=" + rid + ", rename=" + rename + ", did=" + did + "]";
	}
	
}

package com.jio.entity;

public class Resume {

	private int rid;
	private int rage;
	private String rname;
	private String reducation;
	private String rphone;
	private String remail;
	private String rename;
	private String salary;
	private int workexperience;
	private String lastwork;
	private String sface;
	private String hobby;
	private String gender;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getRage() {
		return rage;
	}
	public void setRage(int rage) {
		this.rage = rage;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getReducation() {
		return reducation;
	}
	public void setReducation(String reducation) {
		this.reducation = reducation;
	}
	public String getRphone() {
		return rphone;
	}
	public void setRphone(String rphone) {
		this.rphone = rphone;
	}
	public String getRemail() {
		return remail;
	}
	public void setRemail(String remail) {
		this.remail = remail;
	}
	public String getRename() {
		return rename;
	}
	public void setRename(String rename) {
		this.rename = rename;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public int getWorkexperience() {
		return workexperience;
	}
	public void setWorkexperience(int workexperience) {
		this.workexperience = workexperience;
	}
	public String getLastwork() {
		return lastwork;
	}
	public void setLastwork(String lastwork) {
		this.lastwork = lastwork;
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
	public Resume() {
		super();
	}
	public Resume(int rid, int rage, String rname, String reducation, String rphone, String remail, String rename,
			String salary, int workexperience, String lastwork, String sface, String hobby) {
		super();
		this.rid = rid;
		this.rage = rage;
		this.rname = rname;
		this.reducation = reducation;
		this.rphone = rphone;
		this.remail = remail;
		this.rename = rename;
		this.salary = salary;
		this.workexperience = workexperience;
		this.lastwork = lastwork;
		this.sface = sface;
		this.hobby = hobby;
	}
	public Resume(int rage, String rname, String reducation, String rphone, String remail, String rename, String salary,
			int workexperience, String lastwork, String sface, String hobby) {
		super();
		this.rage = rage;
		this.rname = rname;
		this.reducation = reducation;
		this.rphone = rphone;
		this.remail = remail;
		this.rename = rename;
		this.salary = salary;
		this.workexperience = workexperience;
		this.lastwork = lastwork;
		this.sface = sface;
		this.hobby = hobby;
	}
	public Resume(int rage, String rname, String reducation, String rphone, String remail, String rename, String salary,
			int workexperience, String lastwork, String sface, String hobby, String gender) {
		super();
		this.rage = rage;
		this.rname = rname;
		this.reducation = reducation;
		this.rphone = rphone;
		this.remail = remail;
		this.rename = rename;
		this.salary = salary;
		this.workexperience = workexperience;
		this.lastwork = lastwork;
		this.sface = sface;
		this.hobby = hobby;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Resume [rid=" + rid + ", rage=" + rage + ", rname=" + rname + ", reducation=" + reducation + ", rphone="
				+ rphone + ", remail=" + remail + ", rename=" + rename + ", salary=" + salary + ", workexperience="
				+ workexperience + ", lastwork=" + lastwork + ", sface=" + sface + ", hobby=" + hobby + ", gender="
				+ gender + "]";
	}
	public Resume(int rid, int rage, String rname, String reducation, String rphone, String remail, String rename,
			String salary, int workexperience, String lastwork, String sface, String hobby, String gender) {
		super();
		this.rid = rid;
		this.rage = rage;
		this.rname = rname;
		this.reducation = reducation;
		this.rphone = rphone;
		this.remail = remail;
		this.rename = rename;
		this.salary = salary;
		this.workexperience = workexperience;
		this.lastwork = lastwork;
		this.sface = sface;
		this.hobby = hobby;
		this.gender = gender;
	}
	
	
}

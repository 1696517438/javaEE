package com.jio.entity;

import java.util.Date;

public class PushCard {
	private int id;
	private String ename;
	private String starttime;
	private String endtime;
	private String islate;
	private String isearly;
	private String year;
	private String month;
	private String day;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getIslate() {
		return islate;
	}
	public void setIslate(String islate) {
		this.islate = islate;
	}
	public String getIsearly() {
		return isearly;
	}
	public void setIsearly(String isearly) {
		this.isearly = isearly;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public PushCard() {
		super();
	}
	public PushCard(String ename, String starttime, String endtime, String islate, String isearly, String year,
			String month, String day) {
		super();
		this.ename = ename;
		this.starttime = starttime;
		this.endtime = endtime;
		this.islate = islate;
		this.isearly = isearly;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	@Override
	public String toString() {
		return "PushCard [id=" + id + ", ename=" + ename + ", starttime=" + starttime + ", endtime=" + endtime
				+ ", islate=" + islate + ", isearly=" + isearly + ", year=" + year + ", month=" + month + ", day=" + day
				+ "]";
	}

	
}

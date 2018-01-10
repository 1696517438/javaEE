package com.jio.entity;

public class Salary {
	
	private int sid;
	private double bases;
	private double performances;
	private double overtime;
	private double bouns;
	private double social;
	private double eid;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public double getBases() {
		return bases;
	}
	public void setBases(double bases) {
		this.bases = bases;
	}
	public double getPerformances() {
		return performances;
	}
	public void setPerformances(double performances) {
		this.performances = performances;
	}
	public double getOvertime() {
		return overtime;
	}
	public void setOvertime(double overtime) {
		this.overtime = overtime;
	}
	public double getBouns() {
		return bouns;
	}
	public void setBouns(double bouns) {
		this.bouns = bouns;
	}
	public double getSocial() {
		return social;
	}
	public void setSocial(double social) {
		this.social = social;
	}
	public double getEid() {
		return eid;
	}
	public void setEid(double eid) {
		this.eid = eid;
	}
	public Salary() {
		super();
	}
	public Salary(double bases, double performances, double overtime, double bouns, double social, double eid) {
		super();
		this.bases = bases;
		this.performances = performances;
		this.overtime = overtime;
		this.bouns = bouns;
		this.social = social;
		this.eid = eid;
	}
	@Override
	public String toString() {
		return "Salary [sid=" + sid + ", bases=" + bases + ", performances=" + performances + ", overtime=" + overtime
				+ ", bouns=" + bouns + ", social=" + social + ", eid=" + eid + "]";
	}	
}

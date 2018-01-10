package com.jio.entity;

import java.util.Date;

public class Mesage {

	private int id;
	private Date InterviewTime;
	private int aid;
	private String isInterview;
	
	private Apply apply;
	
	private String isEmploy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getInterviewTime() {
		return InterviewTime;
	}

	public void setInterviewTime(Date interviewTime) {
		InterviewTime = interviewTime;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getIsInterview() {
		return isInterview;
	}

	public void setIsInterview(String isInterview) {
		this.isInterview = isInterview;
	}

	public Apply getApply() {
		return apply;
	}

	public void setApply(Apply apply) {
		this.apply = apply;
	}

	public String getIsEmploy() {
		return isEmploy;
	}

	public void setIsEmploy(String isEmploy) {
		this.isEmploy = isEmploy;
	}

	public Mesage(int id, Date interviewTime, int aid, String isInterview, String isEmploy) {
		super();
		this.id = id;
		InterviewTime = interviewTime;
		this.aid = aid;
		this.isInterview = isInterview;
		this.isEmploy = isEmploy;
	}

	public Mesage(int id, Date interviewTime, int aid, String isInterview, Apply apply, String isEmploy) {
		super();
		this.id = id;
		InterviewTime = interviewTime;
		this.aid = aid;
		this.isInterview = isInterview;
		this.apply = apply;
		this.isEmploy = isEmploy;
	}

	public Mesage() {
		super();
	
	}

	@Override
	public String toString() {
		return "Mesage [id=" + id + ", InterviewTime=" + InterviewTime + ", aid=" + aid + ", isInterview=" + isInterview
				+ ", apply=" + apply + ", isEmploy=" + isEmploy + "]";
	}
	
}

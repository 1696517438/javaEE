package com.jio.entity;

import java.util.List;

public class Subject {
	private int jId;
	
	private String jName;

	public int getjId() {
		return jId;
	}

	public void setjId(int jId) {
		this.jId = jId;
	}

	public String getjName() {
		return jName;
	}

	public void setjName(String jName) {
		this.jName = jName;
	}

	public Subject(int jId, String jName) {
		super();
		this.jId = jId;
		this.jName = jName;
	}

	public Subject() {
		super();
	}

	@Override
	public String toString() {
		return "Subject [jId=" + jId + ", jName=" + jName + "]";
	}
	
	
	

}

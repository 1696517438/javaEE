package com.jio.entity;

public class Recruit {
	private int id;
	private String positions;
	private String workexperience;
	private String diploma;
	private String requires;
	private String name;
	private String salary;
	private String describes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPositions() {
		return positions;
	}
	public void setPositions(String positions) {
		this.positions = positions;
	}
	public String getWorkexperience() {
		return workexperience;
	}
	public void setWorkexperience(String workexperience) {
		this.workexperience = workexperience;
	}
	public String getDiploma() {
		return diploma;
	}
	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}
	public String getRequires() {
		return requires;
	}
	public void setRequires(String requires) {
		this.requires = requires;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	public Recruit(int id, String positions, String workexperience, String diploma, String requires, String name,
			String salary, String describes) {
		super();
		this.id = id;
		this.positions = positions;
		this.workexperience = workexperience;
		this.diploma = diploma;
		this.requires = requires;
		this.name = name;
		this.salary = salary;
		this.describes = describes;
	}
	public Recruit() {
		super();
	}
	@Override
	public String toString() {
		return "Recruit [id=" + id + ", positions=" + positions + ", workexperience=" + workexperience + ", diploma="
				+ diploma + ", requires=" + requires + ", name=" + name + ", salary=" + salary + ", describes="
				+ describes + "]";
	}

}

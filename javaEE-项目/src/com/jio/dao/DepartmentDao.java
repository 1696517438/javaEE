package com.jio.dao;

import java.util.List;

import com.jio.entity.Department;

public interface DepartmentDao {
	public List<Department> queryAllDepartment();
	
	public Department queryDeptByName(String name);
	
	public int addDepartment(String name);
	
	public Department queryDeptByid(int id);
	
	public int  delDepartById(int id);
	
	public Department queryDepartMentLikeDName(String name);
}

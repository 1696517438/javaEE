package com.jio.service;

import java.util.List;

import com.jio.entity.Department;

public interface DepartmentService {
	public List<Department> queryAllDepartment();
	public Department queryDeptByName(String name);
	public int addDepartment(String name);
	public Department queryDeptByid(int id);
	public int  delDepartById(int id);

}

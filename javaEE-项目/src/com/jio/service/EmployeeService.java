package com.jio.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jio.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> queryAllEmployee();
	
	public Employee queryEmployeeByName(String name);		
	
	public int addEmployee(Employee employee);

	public Employee queryEmployeeById(int id);	
	
	public int delEmployeeByName(String name);
	
	public int updateEmployee (String rename,int did,String name);
}

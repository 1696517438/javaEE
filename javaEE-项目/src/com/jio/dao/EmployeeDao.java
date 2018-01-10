package com.jio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jio.entity.Employee;

public interface EmployeeDao {
	public List<Employee> queryAllEmployee();
	
	public Employee queryEmployeeByName(String name);		
	
	public int addEmployee(Employee employee);
	
	public Employee queryEmployeeById(int id);	
	
	public int delEmployeeByName(String name);
	
	public int updateEmployee (@Param("rename")String rename,@Param("did") int did,@Param("name") String name);
	

}

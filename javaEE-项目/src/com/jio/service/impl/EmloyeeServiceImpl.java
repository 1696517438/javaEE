package com.jio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.dao.EmployeeDao;
import com.jio.entity.Employee;
import com.jio.service.EmployeeService;

@Service
public class EmloyeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	@Override
	public List<Employee> queryAllEmployee() {
		
		return employeeDao.queryAllEmployee();
	}

	@Override
	public Employee queryEmployeeByName(String name) {
		
		return employeeDao.queryEmployeeByName(name);
	}

	@Override
	public int addEmployee(Employee employee) {
		
		return employeeDao.addEmployee(employee);
	}

	@Override
	public Employee queryEmployeeById(int id) {
		
		return employeeDao.queryEmployeeById(id);
	}

	@Override
	public int delEmployeeByName(String name) {
		
		return employeeDao.delEmployeeByName(name);
	}

	@Override
	public int updateEmployee(String rename, int did, String name) {
		
		return employeeDao.updateEmployee(rename, did, name);
	}

}

package com.jio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.dao.DepartmentDao;
import com.jio.entity.Department;
import com.jio.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentDao departmentDao; 
	@Override
	public List<Department> queryAllDepartment() {
		return departmentDao.queryAllDepartment();
	}

	@Override
	public Department queryDeptByName(String name) {
		return departmentDao.queryDeptByName(name);
	}

	@Override
	public int addDepartment(String name) {
		return departmentDao.addDepartment(name);
	}

	@Override
	public Department queryDeptByid(int id) {
		return departmentDao.queryDeptByid(id);
	}

	@Override
	public int delDepartById(int id) {
		return departmentDao.delDepartById(id);
	}

}

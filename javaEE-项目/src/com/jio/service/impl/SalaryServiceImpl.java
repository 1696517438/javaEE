package com.jio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.dao.SalaryDao;
import com.jio.entity.Salary;
import com.jio.service.SalaryService;

@Service("salaryService")
public class SalaryServiceImpl  implements SalaryService{

	@Autowired
	private SalaryDao salaryDao;
	@Override
	public Salary querySalaryByEid(int id) {
		
		return salaryDao.querySalaryByEid(id);
	}

	@Override
	public int addSalery(Salary salary) {
		
		return salaryDao.addSalery(salary);
	}
	

}

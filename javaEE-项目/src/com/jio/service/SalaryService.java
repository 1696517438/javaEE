package com.jio.service;

import com.jio.entity.Salary;

public interface SalaryService {
	
	public Salary querySalaryByEid(int id);
	
	public int addSalery(Salary salary);

}

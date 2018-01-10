package com.jio.dao;

import com.jio.entity.Salary;

public interface SalaryDao {
	
	public Salary querySalaryByEid(int id);
	
	public int addSalery(Salary salary);
	
	public int updateSalary(Salary salary);

}

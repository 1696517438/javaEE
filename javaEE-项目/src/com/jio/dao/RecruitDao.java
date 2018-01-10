package com.jio.dao;

import java.util.List;

import com.jio.entity.Recruit;

public interface RecruitDao {
	public List<Recruit> queryAllRecruit();
	
	public int addRecruit(Recruit recruit);
	
	public int delRecruit(int id);
	
	public int updateRecruit(Recruit recruit);

}

package com.jio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.dao.RecruitDao;
import com.jio.entity.Recruit;
import com.jio.service.RecruitService;

@Service("recruitService")
public class RecruitServiceImpl implements RecruitService {
	
	@Autowired
	private RecruitDao recruitDao;

	@Override
	public List<Recruit> queryAllRecruit() {
		
		return recruitDao.queryAllRecruit();
	}

}

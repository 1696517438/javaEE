package com.jio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.dao.ApplyDao;
import com.jio.entity.Apply;
import com.jio.service.ApplyService;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService{

	@Autowired
	private ApplyDao applyDao;
	@Override
	public List<Apply> quryAllApply() {

		return applyDao.quryAllApply();
	}

	@Override
	public int addApply(Apply apply) {
		
		return applyDao.addApply(apply);
	}

	@Override
	public int delApply(int id) {
		
		return applyDao.delApply(id);
	}

	@Override
	public int updateStatus(String name, String postname) {
		
		return applyDao.updateStatus(name, postname);
	}

	@Override
	public int updateInterviewStatus(String name, String postname) {
		
		return applyDao.updateInterviewStatus(name, postname);
	}

	@Override
	public Apply queryApplyByNameAndPost(String name, String postname) {
		
		return applyDao.queryApplyByNameAndPost(name, postname);
	}

	
}

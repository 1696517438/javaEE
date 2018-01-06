package com.jio.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jio.entity.Apply;

public interface ApplyService {

public List<Apply> quryAllApply();
	
	public int addApply(Apply apply);
	
	public int delApply(int id);
	
	public int updateStatus(String name,String postname);
	
	public int updateInterviewStatus(String name,String postname);
	
	public Apply queryApplyByNameAndPost(String name,String postname);
}

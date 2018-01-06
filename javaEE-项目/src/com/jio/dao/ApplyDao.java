package com.jio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jio.entity.Apply;

public interface ApplyDao {
	
	public List<Apply> quryAllApply();
	
	public int addApply(Apply apply);
	
	public int delApply(int id);
	
	public int updateStatus(@Param("name")String name,@Param("postname")String postname);
	
	public int updateInterviewStatus(@Param("name")String name,@Param("postname")String postname);
	
	public Apply queryApplyByNameAndPost(@Param("name")String name,@Param("postname")String postname);

}

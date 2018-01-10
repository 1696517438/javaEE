package com.jio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jio.entity.Mesage;

public interface MesageDao {

	public List<Mesage> queryAllMesage(String name);
	
	public int addMesage(Mesage mesage);
	
	public int updateMesage(int id);
	
	public List<Mesage> queryAllMesageNoNmae();
}

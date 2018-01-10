package com.jio.service;

import java.util.List;

import com.jio.entity.Mesage;

public interface MesageService {
	
	public List<Mesage> queryAllMesage(String name);
	
	public int addMesage(Mesage mesage);
	
	public int updateMesage(int id);
	
	public List<Mesage> queryAllMesageNoNmae();

}

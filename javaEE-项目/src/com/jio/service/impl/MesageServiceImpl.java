package com.jio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.dao.MesageDao;
import com.jio.entity.Mesage;
import com.jio.service.MesageService;

@Service("mesageService")
public class MesageServiceImpl implements MesageService{

	@Autowired
	private MesageDao mesageDao;
	
	@Override
	public List<Mesage> queryAllMesage(String name) {
		
		return mesageDao.queryAllMesage(name);
	}

	@Override
	public int addMesage(Mesage mesage) {
		
		return mesageDao.addMesage(mesage);
	}

	@Override
	public int updateMesage(int id) {
		return mesageDao.updateMesage(id);
	}

	@Override
	public List<Mesage> queryAllMesageNoNmae() {
		
		return mesageDao.queryAllMesageNoNmae();
	}

}

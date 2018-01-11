package com.jio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.dao.PushCardDao;
import com.jio.entity.PushCard;
import com.jio.service.PushCardService;

@Service("pushCardService")
public class PushCardServiceImpl implements PushCardService{
	
	@Autowired
	private PushCardDao pushCardDao;
	@Override
	public List<PushCard> queryCardByEname(String name) {
		
		return pushCardDao.queryCardByEname(name);
	}

	@Override
	public int addCard(PushCard card) {
		
		return pushCardDao.addCard(card);
	}

	@Override
	public int updateCard(PushCard card) {
		
		return pushCardDao.updateCard(card);
	}

	@Override
	public PushCard queryCardByEnameYearAndMonth(String name, int year, int month, int day) {
		
		return pushCardDao.queryCardByEnameYearAndMonth(name, year, month, day);
	}

	@Override
	public List<PushCard> queryCardByEnameAndYearMonth(String name, int year, int month) {
		
		return pushCardDao.queryCardByEnameAndYearMonth(name, year, month);
	}

}

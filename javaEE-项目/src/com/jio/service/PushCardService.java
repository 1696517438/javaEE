package com.jio.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jio.entity.PushCard;

public interface PushCardService {
	
	public List<PushCard> queryCardByEname(String name);
	
	public int addCard(PushCard card);
	
	public int updateCard(PushCard card);
	
	public PushCard queryCardByEnameYearAndMonth(String name,int year,int month,int day);

	public List<PushCard> queryCardByEnameAndYearMonth(String name,int year,int month);
}

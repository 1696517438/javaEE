package com.jio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jio.entity.PushCard;

public interface PushCardDao {
	
	public List<PushCard> queryCardByEname(String name);
	
	public int addCard(PushCard card);
	
	public int updateCard(PushCard card);
	
	public PushCard queryCardByEnameYearAndMonth(@Param("name")String name,@Param("year") int year,@Param("month")int month,@Param("day")int day);

	public List<PushCard> queryCardByEnameAndYearMonth(@Param("name")String name,@Param("year") int year,@Param("month")int month);
}

package com.jio.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jio.entity.User;

public interface UserDao {
	
	public int addUser(User user);
	
	public User queryUserById(int id);
	
	public User queryUserByName(String name);
	
	public User queryUserByNameAndPassword(@Param("name")String name,@Param("password")String password);
	
	public List<User> queryAllUser();
	
	public int updateRid(@Param("id")int id,@Param("name")String name);
}

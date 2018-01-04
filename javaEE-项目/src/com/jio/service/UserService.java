package com.jio.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jio.entity.User;

public interface UserService {
	
	public int addUser(User user);
	
	public User queryUserById(int id);
	
	public User queryUserByName(String name);
	
	public List<User> queryAllUser();
	
	public User queryUserByNameAndPassword(String name,String password);
	
	public int updateRid(int id,String name);
}

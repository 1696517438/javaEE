package com.jio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.dao.UserDao;
import com.jio.entity.User;
import com.jio.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public int addUser(User user) {
		
		return userDao.addUser(user);
	}

	@Override
	public User queryUserById(int id) {
		
		return userDao.queryUserById(id);
	}

	@Override
	public User queryUserByName(String name) {
		
		return userDao.queryUserByName(name);
	}

	@Override
	public List<User> queryAllUser() {
		
		return userDao.queryAllUser();
	}

	@Override
	public User queryUserByNameAndPassword(String name, String password) {
		
		return userDao.queryUserByNameAndPassword(name, password);
	}

	@Override
	public int updateRid(int id, String name) {
		
		return userDao.updateRid(id, name);
	}

	@Override
	public int updatepassword(String upassword, String name) {
		
		return userDao.updatepassword(upassword, name);
	}

}

package com.jio.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jio.dao.UserDao;
import com.jio.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml","/spring-mvc.xml","/spring-mybatis.xml"})
public class HwTest {

	@Autowired
	private UserDao userdao;
	@Test
	public void selectUser() {
		List<User> queryAllUser = userdao.queryAllUser();
		System.out.println(queryAllUser);
		
	}
	@Test
	public void selectUserById() {
		User queryUserById = userdao.queryUserById(6);
		System.out.println(queryUserById);
	}
	@Test
	public void selectUserByName() {
		User queryUserByName = userdao.queryUserByName("ÕÅÈý");
		System.out.println(queryUserByName);
		
	}
	@Test
	public void addUsers() {
		int addUser = userdao.addUser(new User("123", "123", 0));
		System.out.println(addUser);
	}
	@Test
	public void selectUserByNameAndPassword() {
		User queryUserByNameAndPassword = userdao.queryUserByNameAndPassword("111", "111");
		System.out.println(queryUserByNameAndPassword);
	}
	
}

package com.jio.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jio.dao.ResumeDao;
import com.jio.dao.UserDao;
import com.jio.entity.Resume;
import com.jio.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml","/spring-mvc.xml","/spring-mybatis.xml"})
public class HwTest {

	@Autowired
	private UserDao userdao;
	@Autowired
	private ResumeDao resumeDao;
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
		User queryUserByName = userdao.queryUserByName("张三");
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
	@Test
	public void selectResumeByName() {
		Resume queryResumeByName = resumeDao.queryResumeByName("张三");
		System.out.println(queryResumeByName);
	}
	@Test
	public void addResume() {
		int addResume = resumeDao.addResume(new Resume(22, "李四", "本科", "123698547", "152@169", "编辑部文员", "300-600", 3, "物业", "社会良民", "学习"));
		System.out.println(addResume);
	}
	
	
}

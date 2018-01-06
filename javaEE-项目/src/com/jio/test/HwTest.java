package com.jio.test;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jio.dao.ApplyDao;
import com.jio.dao.DepartmentDao;
import com.jio.dao.PostDao;
import com.jio.dao.RecruitDao;
import com.jio.dao.ResumeDao;
import com.jio.dao.UserDao;
import com.jio.entity.Apply;
import com.jio.entity.Department;
import com.jio.entity.Post;
import com.jio.entity.Recruit;
import com.jio.entity.Resume;
import com.jio.entity.User;
import com.jio.service.DepartmentService;
import com.jio.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml","/spring-mvc.xml","/spring-mybatis.xml"})
public class HwTest {

	@Autowired
	private UserDao userdao;
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private RecruitDao recruirDao;
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private PostDao postDao;
	@Autowired
	private DepartmentService de;
	@Autowired
	private ApplyDao applyDao; 
	@Autowired
	private UserService userService;
	
	@Test
	public void quryuser() {
		User queryUserByName = userService.queryUserByName("111");
		System.out.println(queryUserByName);
	}
	
	@Test
	public void queryApplyByNameAndPost() {
		Apply queryApplyByNameAndPost = applyDao.queryApplyByNameAndPost("111","人事部");
		System.out.println(queryApplyByNameAndPost);
	}
	@Test
	public void delRecruit() {
		recruirDao.delRecruit(2);
	}
	
	@Test
	public void addRecruit() {
		recruirDao.addRecruit(new Recruit(0, "人事部", "2年混日子的经验", "本科", "认认真真", "德玛西亚学员", "600起步", "混吃等死"));
	}
	@Test
	public void updateInterviewStatus() {
		applyDao.updateInterviewStatus("111","人事部");
	}
	@Test
	public void updateStatus() {
		int updateStatus = applyDao.updateStatus("111","人事部");
		System.out.println(updateStatus);
	}
	@Test
	public void delApply() {
		int delApply = applyDao.delApply(1);
		System.out.println(delApply);
	}
	@Test
	public void addApply() {
		int addApply = applyDao.addApply(new Apply(0, "111", new Date(), "未查看", "未面试"));
	}
	@Test
	public void queryAllApply() {
		List<Apply> quryAllApply = applyDao.quryAllApply();
		System.out.println(quryAllApply);
	}
	@Test
	public void queryPostByDidAndPname() {
		Post queryPostByDidAndPname = postDao.queryPostByDidAndPname(5,"推销");
		System.out.println(queryPostByDidAndPname);
	}
	@Test
	public void updatePassword() {
		int updatepassword = userdao.updatepassword("123", "111");
		System.out.println(updatepassword);
	}
	@Test
	public void deldept1() {
		int delDepartById = de.delDepartById(4);
		System.out.println(delDepartById);
	}
	@Test
	public void queryAllpost() {
		List<Post> queryAllPost = postDao.queryAllPost();
		System.out.println(queryAllPost);
	}
	@Test
	public void delPost() {
		int addPost = postDao.delPost(3);
		System.err.println(addPost);
	}
	@Test
	public void addPost() {
		int addPost = postDao.addPost("小工", 1);
	}
	@Test
	public void queryPostByDid() {
		List<Post> queryPostByDid = postDao.queryPostByDid(1);
		System.out.println(queryPostByDid);
	}
	@Test
	public void delDepartById() {
		int delDepartById = departmentDao.delDepartById(3);
		System.out.println(delDepartById);
	}
	@Test
	public void queryDeptById() {
		Department queryDeptByid = departmentDao.queryDeptByid(1);
		System.out.println(queryDeptByid);
	}
	@Test
	public void addDepartment() {
		int addDepartment = departmentDao.addDepartment("研发部");
		System.out.println(addDepartment);
	}
	@Test
	public void queryDepartmentByName() {
		Department queryDeptByName = departmentDao.queryDeptByName("财务部");
		
		System.out.println(queryDeptByName);
	}
	
	@Test
	public void queryAllDepartment() {
		List<Department> deprs = departmentDao.queryAllDepartment();
		System.out.println(deprs);
		
	}
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
		User queryUserByName = userdao.queryUserByName("111");
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
	@Test
	public void updateResume() {
		resumeDao.updateResume(new Resume(2, 28, "李四", "小科", "123698547", "152@169", "编辑部文员", "300-600", 3, "物业", "社会良民", "学习"));
		
	}
	@Test
	public void updateRid() {
		int updateRid = userdao.updateRid(2, "123");
		System.out.println(updateRid);
		
	}
	@Test
	public void queryResumeById() {
		Resume queryResumeById = resumeDao.queryResumeById(3);
		System.out.println(queryResumeById);
		
	}
	@Test
	public void queryAllRecruit() {
		
		List<Recruit> r = recruirDao.queryAllRecruit();
		System.out.println(r);
		
	}
	
}

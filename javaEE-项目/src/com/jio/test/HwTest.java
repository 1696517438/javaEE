package com.jio.test;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jio.dao.ApplyDao;
import com.jio.dao.DepartmentDao;
import com.jio.dao.EmployeeDao;
import com.jio.dao.MesageDao;
import com.jio.dao.PostDao;
import com.jio.dao.PushCardDao;
import com.jio.dao.RecruitDao;
import com.jio.dao.ResumeDao;
import com.jio.dao.SalaryDao;
import com.jio.dao.UserDao;
import com.jio.entity.Apply;
import com.jio.entity.Department;
import com.jio.entity.Employee;
import com.jio.entity.Mesage;
import com.jio.entity.Post;
import com.jio.entity.PushCard;
import com.jio.entity.Recruit;
import com.jio.entity.Resume;
import com.jio.entity.Salary;
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
	@Autowired
	private MesageDao mesageDao;
	@Autowired
	private EmployeeDao eployeeDao;
	@Autowired
	private SalaryDao salaryDao;
	@Autowired
	private PushCardDao pushCardDao;
	
	@Test
	public void queryCardByEnameAndYearMonth() {
		List<PushCard> queryCardByEnameAndYearMonth = pushCardDao.queryCardByEnameAndYearMonth("小黄", 2018, 1);
		System.out.println(queryCardByEnameAndYearMonth);
	}
	@Test
	public void queryCardByEnameYearAndMonth() {
		PushCard queryCardByEnameYearAndMonth = pushCardDao.queryCardByEnameYearAndMonth("蔡康", 2018, 1, 11);
		System.out.println(queryCardByEnameYearAndMonth);
	}
	
	@Test
	public void updateCard() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		String time =sdf.format(date); 
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONDAY);
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR);
		month = month + 1;
		pushCardDao.updateCard(new PushCard("小黄", "",time, "", "正常下班", ""+year, ""+month, ""+day));
	}
	
	@Test
	public void addCard() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		String time =sdf.format(date); 
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONDAY);
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR);
		month = month + 1;
		if(hour<10 && hour > 0) {
			pushCardDao.addCard(new PushCard("小黄", time, "", "正常上班", "", ""+year, ""+month, ""+day));
		}
		else if(hour >= 10 && hour < 11) {
			pushCardDao.addCard(new PushCard("小黄", time, "", "迟到", "", ""+year, ""+month, ""+day));
		}else {
			pushCardDao.addCard(new PushCard("小黄", time, "", "旷工", "", ""+year, ""+month, ""+day));
		}
		
		
		
	}
	
	@Test
	public void queryCardByname() {
		List<PushCard> card = pushCardDao.queryCardByEname("蔡康");
		System.out.println(card);
	}
	
	
	@Test
	public void updateEmployee() {
		int updateEmployee = eployeeDao.updateEmployee("财务部 文员", 2, "小黄");
		System.out.println(updateEmployee);
	}
	
	@Test
	public void delEmployeeByName() {
		int delEmployeeByName = eployeeDao.delEmployeeByName("hh");
		System.out.println(delEmployeeByName);
	}
	
	@Test
	public void updateSalary() {
		Salary salary = salaryDao.querySalaryByEid(1);
		int res = salaryDao.updateSalary(
				new Salary
				(salary.getBases()+100, salary.getPerformances(), salary.getOvertime(), salary.getBouns(), salary.getSocial(), salary.getEid()));
		System.out.println(res);
	}
	@Test
	public void addSalary() {
		 int addSalery = salaryDao.addSalery(new Salary(2300, 200, 0, 0, -500, 3));
		 System.out.println(addSalery);
		
	}
	@Test
	public void querySalaryByEid() {
		Salary salary = salaryDao.querySalaryByEid(1);
		System.out.println(salary);
		
	}
	
	
	@Test
	public void queryEmployeeById() {
		
		Employee queryEmployeeById = eployeeDao.queryEmployeeById(5);
		System.out.println(queryEmployeeById);
	}
	
	@Test
	public void updateApply() {
		
		int updateMesage = mesageDao.updateMesage(2);
	}
	
	
	
	@Test
	public void updateEid() {
		int updateEid = userdao.updateEid(3, "333");
		
	}
	
	
	@Test
	public void queryDepartMentLikeDName() {
		Department department = departmentDao.queryDepartMentLikeDName("研");
		System.out.println(department.getDid());
		
	}
	
	@Test
	public void queryAllEmployee() {
		
		List<Employee> queryAllEmployee = eployeeDao.queryAllEmployee();
		
		System.out.println(queryAllEmployee);
	}
	
	@Test
	public void addEmployee() {
		int addEmployee = eployeeDao.addEmployee(new Employee("hh", "nan", 18, "12", "12", "64656@616516", new Date(), "adf", "adsf", 1, "das",1));
		
		System.out.println(addEmployee);
	}
	@Test
	public void queryEmployeeByName() {
		Employee employee = eployeeDao.queryEmployeeByName("张三");
		System.out.println(employee);
	}
	@Test
	public void queryAllMesageNoNmae() {
		List<Mesage> queryAllMesageNoNmae = mesageDao.queryAllMesageNoNmae();
		System.out.println(queryAllMesageNoNmae);
	}
	@Test
	public void updateRecruit() {
		recruirDao.updateRecruit(new Recruit(3, "0", "0", "0", "0", "0", "0", "0"));
	}
	@Test
	public void updateMesage() {
		int updateMesage = mesageDao.updateMesage(2);
		System.out.println(updateMesage);
	}
	@Test
	public void addMesage() {
		int addMesage = mesageDao.addMesage(new Mesage(0, new Date(), 16, "按时面试", "未录用"));
		
		System.out.println(addMesage);
	}
	@Test
	public void queryAllMesage() {
		List<Mesage> queryAllMesage = mesageDao.queryAllMesage("222");
		for (Mesage mesage : queryAllMesage) {
			System.out.println(mesage);
		}
		
	}
	@Test
	public void delRecuit() {
		int delRecruit = recruirDao.delRecruit(2);
		
	}
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

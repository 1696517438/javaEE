package com.jio.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jio.entity.Department;
import com.jio.entity.Employee;
import com.jio.entity.Post;
import com.jio.entity.PushCard;
import com.jio.entity.Resume;
import com.jio.entity.User;
import com.jio.service.DepartmentService;
import com.jio.service.EmployeeService;
import com.jio.service.PostService;
import com.jio.service.PushCardService;
import com.jio.service.ResumeService;
import com.jio.service.UserService;

@RequestMapping("/employee")
@Controller
public class EmployeeController {
	@Autowired
	private UserService userService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PostService postService;
	@Autowired
	private PushCardService pushCardService;
	@Autowired
	private ResumeService resumeService;

	
	@RequestMapping("queryEmployeeByname")
	public String queryEmployeeByname(String name,Model model) {
		User user = userService.queryUserByName(name);
		Employee employee = employeeService.queryEmployeeById(user.getEid());
		model.addAttribute("user", user);
		model.addAttribute("employee", employee);
		return "forward:/WEB-INF/pages/employee.jsp";
	}
	@RequestMapping("queryAllEmployee")
	public String queryAllEmployee(String name,Model model) {
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		List<Employee> employee = employeeService.queryAllEmployee();
		model.addAttribute("employee", employee);
		
		return "forward:/WEB-INF/pages/admin.jsp";
	}
	@RequestMapping("findEmpById")
	public String findEmpById(int id,String name,Model model) {
		User user = userService.queryUserByName(name);
		Employee employeeMes = employeeService.queryEmployeeById(id);
		model.addAttribute("user", user);
		model.addAttribute("employeeMes", employeeMes);
		return "forward:/WEB-INF/pages/admin.jsp";
	}
	@RequestMapping("queryAlldept")
	public String queryAlldept(String name,String ename,Model model) {
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		List<Department> departments = departmentService.queryAllDepartment();
		model.addAttribute("departments", departments);
		
		model.addAttribute("ename",ename);
		List<Employee> employee = employeeService.queryAllEmployee();
		model.addAttribute("employee", employee);
		return "forward:/WEB-INF/pages/admin.jsp";
	}
	
	@RequestMapping(value="updateDept",method=RequestMethod.POST)
	@ResponseBody
	public String updateDept(int id) {
		List<Post> post = postService.queryPostByDid(id);
		
		String data = "";
		for (Post post2 : post) {
			data+=post2.getPname()+",";
		}
		return data;
	}
	
	@RequestMapping("updateEmp")
	public String updateEmp(String name,String ename,int dept,String post,Model model) {
		
		User user = userService.queryUserByName(name);
		
		Department byid = departmentService.queryDeptByid(dept);
		
		String rename=byid.getDname()+" "+ post;
		
		employeeService.updateEmployee(rename, dept, ename);
		model.addAttribute("user", user);
		
		List<Department> departments = departmentService.queryAllDepartment();
		model.addAttribute("departments", departments);
		
		model.addAttribute("ename",ename);
		List<Employee> employee = employeeService.queryAllEmployee();
		
		model.addAttribute("employee", employee);
		return "forward:/WEB-INF/pages/admin.jsp";
	}
	@RequestMapping(value="delEmpByName",method=RequestMethod.POST)
	@ResponseBody
	public String delEmpByName(String name) {
		int res = employeeService.delEmployeeByName(name);
		String result = ""+res;
		return result;
	}
	@RequestMapping(value="queryCard",method=RequestMethod.POST)
	@ResponseBody
	public String queryCard(String name) {
		User user = userService.queryUserByName(name);
		
		Resume resume = resumeService.queryResumeById(user.getUresumeid());
		
		Employee employee = employeeService.queryEmployeeByName(resume.getRname());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String time =sdf.format(date); 
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONDAY);
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		month = month + 1;
		
		PushCard pushCard = pushCardService.queryCardByEnameYearAndMonth(employee.getEname(), year, month, day);
		String result = "";
		if(pushCard == null) {
			if(hour<8 && hour > 0) {
				pushCardService.addCard(new PushCard(employee.getEname(), time, "", "正常上班", "", ""+year, ""+month, ""+day));
			}
			else if(hour >= 8 && hour < 11) {
				pushCardService.addCard(new PushCard(employee.getEname(), time, "", "迟到", "", ""+year, ""+month, ""+day));
			}else {
				pushCardService.addCard(new PushCard(employee.getEname(), time, "", "旷工", "", ""+year, ""+month, ""+day));
			}
			result=result + 1;
		}else {
			result=result + 2;
		}
		return result;
	}
	@RequestMapping(value="updateCard",method=RequestMethod.POST)
	@ResponseBody
	public String updateCard(String name) {
		User user = userService.queryUserByName(name);
		Resume resume = resumeService.queryResumeById(user.getUresumeid());
		Employee employee = employeeService.queryEmployeeByName(resume.getRname());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String time =sdf.format(date); 
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONDAY);
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		month = month + 1;
		
		String result = "";
		if(hour > 18) {
			pushCardService.updateCard(new PushCard(employee.getEname(), "",time, "", "正常下班", ""+year, ""+month, ""+day));
			result=result+1;
		}else if(hour-18==3) {
			pushCardService.updateCard(new PushCard(employee.getEname(), "",time, "", "早退", ""+year, ""+month, ""+day));
			result=result+2;
		}else {
			pushCardService.updateCard(new PushCard(employee.getEname(), "",time, "", "旷工", ""+year, ""+month, ""+day));
			result=result+3;
		}
		
		return result;
	}
	@RequestMapping("queryDept")
	public String queryDept(String name,Model model) {
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		List<Department> departments = departmentService.queryAllDepartment();
		model.addAttribute("departments", departments);
		return "forward:/WEB-INF/pages/employee.jsp";
	}
	@RequestMapping("queryPost")
	public String queryPost(String name,String dname,Model model) {
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		Department department = departmentService.queryDeptByName(dname);
		List<Post> posts = postService.queryPostByDid(department.getDid());
		model.addAttribute("posts", posts);
		List<Department> departments = departmentService.queryAllDepartment();
		model.addAttribute("departments", departments);
		return "forward:/WEB-INF/pages/employee.jsp";
	}
	
	@RequestMapping("queryPushCard")
	public String queryPushCard(String name,Model model) {
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		Resume resume = resumeService.queryResumeById(user.getUresumeid());
		
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONDAY);
		month = month+1;
		List<PushCard> pushCard = pushCardService.queryCardByEnameAndYearMonth(resume.getRname(), year, month);
		model.addAttribute("pushCard", pushCard);
		return "forward:/WEB-INF/pages/employee.jsp";
	}
	@RequestMapping("findCard")
	public String findCard(String name,int year,int month,Model model) {
		User user = userService.queryUserByName(name);
		
		model.addAttribute("user", user);
		Resume resume = resumeService.queryResumeById(user.getUresumeid());
		
		List<PushCard> pushCard = pushCardService.queryCardByEnameAndYearMonth(resume.getRname(), year, month);
		model.addAttribute("pushCard", pushCard);
		return "forward:/WEB-INF/pages/employee.jsp";
	}
}

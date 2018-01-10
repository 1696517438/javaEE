package com.jio.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jio.entity.Apply;
import com.jio.entity.Department;
import com.jio.entity.Employee;
import com.jio.entity.Mesage;
import com.jio.entity.Resume;
import com.jio.entity.User;
import com.jio.service.ApplyService;
import com.jio.service.DepartmentService;
import com.jio.service.EmployeeService;
import com.jio.service.MesageService;
import com.jio.service.ResumeService;
import com.jio.service.UserService;

@RequestMapping("user")
@Controller
public class Usercontroller {
	@Autowired
	private UserService userService;
	@Autowired
	private MesageService mesageService;
	@Autowired
	private ApplyService applyService;
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	
	
	
	
	
	@RequestMapping("addUser")
	public String addUser(String uname,String upassword) {
		userService.addUser(new User(uname, upassword, 0));
		return "forward:/index.jsp";
	}
	@RequestMapping("queryUserByName")
	@ResponseBody
	public String queryUserByName(String uname) {
		User queryUserByName = userService.queryUserByName(uname);
		int res = 0;
		if(queryUserByName != null) {
			res+=1;
		}
		String result = ""+res;
		return result;
	}
	@RequestMapping("loginSuccess")
	public String loginSuccess(String name,String password,Model model) {
		User user = userService.queryUserByNameAndPassword(name, password);
		if(user == null) {
			String manges="没有此用户";
			model.addAttribute("manges", manges);
			return "forward:/index.jsp";
		}else {
			if(user.getUtype() ==0) {
				model.addAttribute("user", user);
				return "forward:/WEB-INF/pages/tourist.jsp";
			}else if(user.getUtype()==2) {
				model.addAttribute("user", user);
				return "forward:/WEB-INF/pages/dmanager.jsp";
			}else if(user.getUtype()==1) {
				model.addAttribute("user", user);
				return "forward:/WEB-INF/pages/employee.jsp";
			}
		}
		model.addAttribute("user", user);
		return "forward:/WEB-INF/pages/admin.jsp";
	}
	@RequestMapping("queryUserByNameAndName")
	@ResponseBody
	public String queryUserByNameAndName(String uname,String password) {
		User user = userService.queryUserByNameAndPassword(uname, password);
		int res = 0;
		if(user != null) {
			res+=1;
		}
		String result = ""+res;
		return result;
		
	}
	@RequestMapping("updateUserPassword")
	public String updateUserPassword(String updatename,String upassword) {
		 userService.updatepassword(upassword, updatename);
		return "forward:/index.jsp";
	}
	@RequestMapping("queryMes")
	@ResponseBody
	public String queryMes(String name) {
		List<Mesage> mesage = mesageService.queryAllMesage(name);
		String result = "";
		if(mesage!=null) {
			result=result+1;
		}
		return result;
	}
	//游客转换成用工
	@RequestMapping("updateType")
	@ResponseBody
	public String updateType(String name,String postname) {
		User user = userService.queryUserByName(name);
		Apply apply = applyService.queryApplyByNameAndPost(name, postname);
		String result = "";
		if(user.getEid()==0) {
			String dname = postname.substring(0, 3);
			Department department = departmentService.queryDeptByName(dname);
			Resume resume = resumeService.queryResumeById(user.getUresumeid());
			employeeService.addEmployee(new Employee(resume.getRname(), resume.getGender(), resume.getRage(), resume.getReducation(), resume.getRphone(), resume.getRemail(), new Date(), resume.getSface(), resume.getHobby(), resume.getRid(), resume.getRename(), department.getDid()));
			Employee employee = employeeService.queryEmployeeByName(resume.getRname());
			int updateEid = userService.updateEid(employee.getEid(), name);
			mesageService.updateMesage(apply.getId());			
			int res = userService.updateType(name);
			applyService.updateInterviewStatus(name, postname);
			result = result+res;
		}else {
			result=result+2;
		}
		
	
		
		return result;
	}
	@RequestMapping("returnDmanager")
	public String returnDmanager(String name,Model model) {
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		return "forward:/WEB-INF/pages/dmanager.jsp";
	}
	@RequestMapping("returnIndex")
	public String returnIndex() {
		
		return "forward:/index.jsp";
	}
}

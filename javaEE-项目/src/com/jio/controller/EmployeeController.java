package com.jio.controller;

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
import com.jio.entity.User;
import com.jio.service.DepartmentService;
import com.jio.service.EmployeeService;
import com.jio.service.PostService;
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
}

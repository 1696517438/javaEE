package com.jio.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jio.entity.Apply;
import com.jio.entity.Department;
import com.jio.entity.Mesage;
import com.jio.entity.Post;
import com.jio.entity.Resume;
import com.jio.entity.User;
import com.jio.service.ApplyService;
import com.jio.service.DepartmentService;
import com.jio.service.MesageService;
import com.jio.service.PostService;
import com.jio.service.ResumeService;
import com.jio.service.UserService;

@RequestMapping("/department")
@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private ApplyService applyService;
	
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private MesageService mesageService;

	@RequestMapping("/queryAllDept")
	public String queryAllDept(String name, Model model) {
		List<Department> department = departmentService.queryAllDepartment();

		model.addAttribute("department", department);
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		return "forward:/WEB-INF/pages/admin.jsp";
	}

	@RequestMapping("/queryById")
	public String queryById(String name, int id, Model model) {
		List<Department> department = departmentService.queryAllDepartment();
		model.addAttribute("department", department);
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		List<Post> post = postService.queryPostByDid(id);
		model.addAttribute("post", post);
		return "forward:/WEB-INF/pages/admin.jsp";
	}

	@RequestMapping("/delpost")
	public String delpost(String name, int pid, int id, Model model) {
		List<Department> department = departmentService.queryAllDepartment();
		model.addAttribute("department", department);
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		int delPost = postService.delPost(pid);
		List<Post> post = postService.queryPostByDid(id);
		model.addAttribute("post", post);
		return "forward:/WEB-INF/pages/admin.jsp";
	}

	@RequestMapping("/deldept")
	public String deldept(String name, int id, Model model) {
		List<Post> post = postService.queryPostByDid(id);
		if (post.size() > 0) {
			String mgs = "该部门下面还有员工不能删除！！";
			model.addAttribute("mgs", mgs);
			List<Department> department = departmentService.queryAllDepartment();
			model.addAttribute("department", department);
			User user = userService.queryUserByName(name);
			model.addAttribute("user", user);
			model.addAttribute("post", post);
			return "forward:/WEB-INF/pages/admin.jsp";
		}
		departmentService.delDepartById(id);
		List<Department> department = departmentService.queryAllDepartment();
		model.addAttribute("department", department);
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		model.addAttribute("post", post);
		return "forward:/WEB-INF/pages/admin.jsp";
	}
	@RequestMapping("/addDept")
	public String addDept(String name,Model model) {
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		
		List<Department> department = departmentService.queryAllDepartment();
		model.addAttribute("department", department);
		return "forward:/WEB-INF/pages/addDepartAndPost.jsp";
	}
	@RequestMapping("/addDepartment")
	@ResponseBody
	public String addDepartment(String dname) {
		Department department = departmentService.queryDeptByName(dname);
		String result=null;
		if(department == null) {
			int res = departmentService.addDepartment(dname);
			if(res!=0) {
				result=""+res;
			}
		}
		return result;
	}
	@RequestMapping("/addPost")
	@ResponseBody
	public String addPost(String pname,int pid) {
		Post post = postService.queryPostByDidAndPname(pid, pname);
		String result=null;
		if(post==null) {
			int res = postService.addPost(pname, pid);
			if(res!=0) {
				result=""+res;
			}
		}
		return result;
	}

	@RequestMapping("/returnAdmin")
	public String returnAdmin(String name,Model model) {
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		return "forward:/WEB-INF/pages/admin.jsp";
	}
	@RequestMapping("/showApply")
	public String showApply(String name,Model model) {
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		List<Apply> apply = applyService.quryAllApply();
		model.addAttribute("apply", apply);
		return "forward:/WEB-INF/pages/admin.jsp";
	}
	@RequestMapping("/delApply")
	@ResponseBody
	public String delApply(int del,String postname,Model model) {
		int res = applyService.delApply(del);
		String result=""+res;
		return result;
	}
	
	@RequestMapping("/LookResume")
	public String LookResume(String name,String uname,String postname,Model model) {
		
		User user = userService.queryUserByName(name);
		User user1 = userService.queryUserByName(uname);
		Resume resume = resumeService.queryResumeById(user1.getUresumeid());
		Apply apply1 = applyService.queryApplyByNameAndPost(uname, postname);
		
		applyService.updateStatus(uname,postname);
		
		model.addAttribute("apply1",apply1 );
		model.addAttribute("resume",resume );
		model.addAttribute("user", user);
		return "forward:/WEB-INF/pages/admin.jsp";
	}
	
	@RequestMapping("/returnShowApply")
	public String returnShowApply(String name,Model model) {
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		List<Apply> apply = applyService.quryAllApply();
		model.addAttribute("apply", apply);
		return "forward:/WEB-INF/pages/admin.jsp";
	}
	@RequestMapping("/addMesage")
	public String addMesage(String name,int id,String time,Model model) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String newDate=sdf.format(new Date());
		Date date = sdf.parse(time);
		
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		mesageService.addMesage(new Mesage(0, date, id, "按时面试", "未录用"));
		return "forward:/WEB-INF/pages/admin.jsp";
	}
	@RequestMapping("/queryResume")
	public String queryResume(String name,String uname,Model model) {
		User user = userService.queryUserByName(name);
		User user1 = userService.queryUserByName(uname);
		Resume resume = resumeService.queryResumeById(user1.getUresumeid());
		model.addAttribute("resume",resume );
		model.addAttribute("user", user);
		model.addAttribute("user1", user1);
		return "forward:/WEB-INF/pages/dmanager.jsp";
	}
}

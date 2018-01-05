package com.jio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jio.entity.Resume;
import com.jio.entity.User;
import com.jio.service.ResumeService;
import com.jio.service.UserService;

@Controller
@RequestMapping("resume")
public class ResumeController {
	@Autowired
	private UserService userService;
	@Autowired
	private ResumeService resumeService;
	
	@RequestMapping("/addResumes")
	public String addResume(String name,Model model) {
		User user = userService.queryUserByName(name);
		System.out.println(user.getUresumeid());
		model.addAttribute("user", user);
		Resume resume = resumeService.queryResumeById(user.getUresumeid());
		model.addAttribute("resume", resume);
		return "forward:/WEB-INF/pages/addResume.jsp";
	}
	/**
	 * 
	 * @param names
	 * @param uname
	 * @param gender
	 * @param rage
	 * @param reducation
	 * @param phone
	 * @param email
	 * @param rename
	 * @param sface
	 * @param lastwork
	 * @param workexperience
	 * @param salary
	 * @param hobby
	 * @return 游客填写简历 在游客表里 添加简历表的id
	 */
	@RequestMapping("/addResumeSuccess")
	public String addResumeSuccess(String names,String uname,String gender,int rage,String reducation,String phone,String email,String rename,String sface,String lastwork,int workexperience,String salary,String hobby,Model model  ) {
		resumeService.addResume(new Resume(rage, uname, reducation, phone, email, rename, salary, workexperience, lastwork, sface, hobby, gender));
		Resume resume = resumeService.queryResumeByName(uname);
		userService.updateRid(resume.getRid(), names);
		User user = userService.queryUserByName(names);
		model.addAttribute("user", user);
		return "forward:/WEB-INF/pages/tourist.jsp";
	}
	@RequestMapping("/updateResume")
	public String updateResume(int rid,String names,String uname,String gender,int rage,String reducation,String phone,String email,String rename,String sface,String lastwork,int workexperience,String salary,String hobby,Model model  ) {
		resumeService.updateResume(new Resume(rid,rage, uname, reducation, phone, email, rename, salary, workexperience, lastwork, sface, hobby, gender));
		
		User user = userService.queryUserByName(names);
		model.addAttribute("user", user);
		return "forward:/WEB-INF/pages/tourist.jsp";
	}
}

package com.jio.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jio.entity.Apply;
import com.jio.entity.Mesage;
import com.jio.entity.Recruit;
import com.jio.entity.User;
import com.jio.service.ApplyService;
import com.jio.service.MesageService;
import com.jio.service.RecruitService;
import com.jio.service.UserService;

@Controller
@RequestMapping("recruit")
public class RecruitController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecruitService recruitService;
	
	@Autowired
	private ApplyService applyService;
	
	@Autowired
	private MesageService mesageservice;
	
	@RequestMapping("queryAllRecruit")
	public String queryAllRecruit(String name1,Model model) {
		List<Recruit> recruit = recruitService.queryAllRecruit();
		model.addAttribute("recruit", recruit);
		
		User user = userService.queryUserByName(name1);
		model.addAttribute("user", user);
		return "forward:/WEB-INF/pages/recruit.jsp";
	}
	
	@RequestMapping("queryRid")
	@ResponseBody
	public String queryRid(String uname,String postname,Model model) {
		User user = userService.queryUserByName(uname);
		Apply appy = applyService.queryApplyByNameAndPost(uname, postname);
		String result="";
		if(user.getUresumeid() == 0) {
			result= ""+0;
		}else {
			if(appy!=null) {
				result= ""+2;
			}else {
				int res = applyService.addApply(new Apply(0, uname, new Date(), "Œ¥≤Èø¥", "Œ¥√Ê ‘", postname));
				result=""+res;
			}
		}
		return result;
	}
	@RequestMapping("returnTourist")
	public String returnTourist(String uname,Model model) {
		
		
		User user = userService.queryUserByName(uname);
		model.addAttribute("user", user);
		return "forward:/WEB-INF/pages/tourist.jsp";
	}
	
	@RequestMapping("addrecruit")
	public String addrecruit(String name,Model model) {
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		return "forward:/WEB-INF/pages/addRecruit.jsp";
	}
	
	@RequestMapping("addRecruit")
	public String addRecruit(String uname,String rname,String positions,String workexperience,String diploma,String requires,String salary,String describes,Model model) {
		User user = userService.queryUserByName(uname);
		model.addAttribute("user", user);
		
		int addRecruit = recruitService.addRecruit(new Recruit(0, positions, workexperience, diploma, requires, rname, salary, describes));
		return "forward:/WEB-INF/pages/addRecruit.jsp";
	}
	@RequestMapping("showAllRecruit")
	public String showAllRecruit(String name,Model model) {
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		
		List<Recruit> recruit = recruitService.queryAllRecruit();
		model.addAttribute("recruit", recruit);
		return "forward:/WEB-INF/pages/recruitShow.jsp";
	}
	@RequestMapping("retunAddRecruit")
	public String retunAddRecruit(String name,Model model) {
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		return "forward:/WEB-INF/pages/addRecruit.jsp";
	}
	
	@RequestMapping("delRecruit")
	@ResponseBody
	public String delRecruit(int id) {
		int res = recruitService.delRecruit(id);
		String result=""+res;
		return result;
	}
	
	@RequestMapping("queryAllMesage")
	public String queryAllMesage(String name,Model model) {
		List<Mesage> mesage = mesageservice.queryAllMesage(name);
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		model.addAttribute("mesage", mesage);
		return "forward:/WEB-INF/pages/tourist.jsp";
	}
	@RequestMapping("updateRecruit")
	public String updateRecruit(String name,String rname,int id,String positions,String workexperience,String diploma,String requires,String salary,String describes,Model model) {
		
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		recruitService.updateRecruit(new Recruit(id, positions, workexperience, diploma, requires, rname, salary, describes));
		List<Recruit> recruit = recruitService.queryAllRecruit();
		model.addAttribute("recruit", recruit);
		return "forward:/WEB-INF/pages/recruitShow.jsp";
	}
	
	@RequestMapping("querySomeMes")
	public String querySomeMes(String name,Model model) {
		List<Mesage> mesage = mesageservice.queryAllMesageNoNmae();
		User user = userService.queryUserByName(name);
		model.addAttribute("user", user);
		model.addAttribute("mesage", mesage);
		return "forward:/WEB-INF/pages/dmanager.jsp";
	}
}

package com.jio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jio.entity.Recruit;
import com.jio.entity.User;
import com.jio.service.RecruitService;
import com.jio.service.UserService;

@Controller
@RequestMapping("recruit")
public class RecruitController {
	@Autowired
	private UserService userService;
	@Autowired
	private RecruitService recruitService;
	@RequestMapping("queryAllRecruit")
	public String queryAllRecruit(String name1,Model model) {
		List<Recruit> recruit = recruitService.queryAllRecruit();
		model.addAttribute("recruit", recruit);
		User user = userService.queryUserByName(name1);
		model.addAttribute("user", user);
		return "forward:/WEB-INF/pages/recruit.jsp";
	}
	@RequestMapping("queryRid")
	public String queryRid(String uname,Model model) {
		User user = userService.queryUserByName(uname);
		if(user.getUresumeid() == 0) {
			String mgs = "请填写简历！！";
			model.addAttribute("mgs", mgs);
			List<Recruit> recruit = recruitService.queryAllRecruit();
			model.addAttribute("recruit", recruit);
			model.addAttribute("user", user);
			return "forward:/WEB-INF/pages/recruit.jsp";
		}
		String mgs = "投递成功！";
		model.addAttribute("mgs", mgs);
		List<Recruit> recruit = recruitService.queryAllRecruit();
		model.addAttribute("recruit", recruit);
		model.addAttribute("user", user);
		return "forward:/WEB-INF/pages/recruit.jsp";
	}
	
}

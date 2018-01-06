package com.jio.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jio.entity.Apply;
import com.jio.entity.Recruit;
import com.jio.entity.User;
import com.jio.service.ApplyService;
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
	
}

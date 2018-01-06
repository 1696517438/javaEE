package com.jio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jio.entity.User;
import com.jio.service.UserService;

@RequestMapping("user")
@Controller
public class Usercontroller {
	@Autowired
	private UserService userService;
	
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
//	@RequestMapping("/touristpage")
//	public String tourist() {
//		return "tourist";
//	}
	
}

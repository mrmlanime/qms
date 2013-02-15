package com.torm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.torm.domain.User;
import com.torm.domain.UserType;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(){
		return "login";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String createRequestForm(@ModelAttribute("user") User user, Model model){
		
	model.addAttribute("usertypeList",UserType.findAllUserTypes());
		return "user/create";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String addUserType(@ModelAttribute("user") User user, Model model){
		user.persist();
		return "redirect:login";
	}
}

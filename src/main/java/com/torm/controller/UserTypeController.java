package com.torm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.torm.domain.User;
import com.torm.domain.UserType;

@RequestMapping("/usertype")
@Controller
public class UserTypeController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(){
		return "login";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String createRequestForm(@ModelAttribute("userType") User user, Model model){	
		return "usertype/create";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String addUserType(@ModelAttribute("userType") UserType usertype, Model model){
		usertype.persist();
		return "redirect:login";
	}
}

package com.torm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.torm.domain.Staff;
import com.torm.domain.Visitor;

@Controller
public class VisitorController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index(){
		return "login";
	}
	
	@RequestMapping(value="/visitor/add", method=RequestMethod.GET)
	public String createRequestForm(@ModelAttribute("visitor") Visitor visitor, Model model){
		
		model.addAttribute("staffList", Staff.findAllStaffs());
		return "visitor/create";
	}
	
	
	@RequestMapping(value="/visitor/create", method=RequestMethod.POST)
	public String createRequest(@ModelAttribute("visitor") Visitor visitor, Model model){
		visitor.setStatus("waiting");
		visitor.persist();
		model.addAttribute("visitor", visitor);
		return "visitor/display";
	}
}

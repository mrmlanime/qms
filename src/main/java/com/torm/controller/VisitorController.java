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
	
	@SuppressWarnings("static-access")
	@RequestMapping(value="/visitor/create", method=RequestMethod.POST)
	public String createRequest(@ModelAttribute("visitor") Visitor visitor, Model model){
		System.out.println(visitor.getFirstName() + "-" + visitor.getStaff());
		visitor.persist();
		Visitor visit = new Visitor();
		model.addAttribute("requestNumber", visit.findVisitor(1L));
		return "visitor/display";
	}
	
	
}

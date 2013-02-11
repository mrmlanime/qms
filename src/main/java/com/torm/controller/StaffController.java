package com.torm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.torm.domain.Staff;
import com.torm.domain.Visitor;

@Controller
public class StaffController {

	@RequestMapping(value = "/staff/queue", method = RequestMethod.GET)
	public String queue(Model model) {
		List<Visitor> visitors = Visitor.findVisitorsByStaffAndStatus(Staff.findStaff(1L), "waiting").getResultList();
		long id = visitors.get(0).getId();
		
		Visitor visitor = Visitor.findVisitor(id);
		visitor.setStatus("ready");
		visitor.merge();
		
		model.addAttribute("visitor", Visitor.findVisitor(id));
		return "staff/home";
	}
	
	@RequestMapping(value = "/staff/done", method = RequestMethod.GET)
	public String done(Model model) {
		
		List<Visitor> visitors = Visitor.findVisitorsByStaffAndStatus(Staff.findStaff(1L), "waiting").getResultList();
		model.addAttribute("visitor", Visitor.findVisitor(visitors.get(0).getId()));
		return "staff/home";
	}
	
	@RequestMapping(value = "/staff/serve/{id}", method = RequestMethod.GET)
	public String serve(@PathVariable("id") long id, Model model) {
		Visitor visitor = Visitor.findVisitor(id);
		visitor.setStatus("served");
		visitor.merge();
		
		model.addAttribute("visitor", Visitor.findVisitor(id));
		model.addAttribute("service", "serve");
		
		return "staff/home";
	}
	
	@RequestMapping(value = "/staff/transfer", method = RequestMethod.GET)
	public String transfer(){
		return "staff/home";
	}
}

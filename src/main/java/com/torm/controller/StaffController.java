package com.torm.controller;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value = "/staff/done/{id}", method = RequestMethod.GET)
	public String done(@PathVariable("id") long id, Model model) {
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String endTime = sdf.format(cal.getTime());
		
		Visitor visitor = Visitor.findVisitor(id);
		visitor.setEndTimeServed(Time.valueOf(endTime));
		visitor.merge();
		List<Visitor> visitors = Visitor.findVisitorsByStaffAndStatus(Staff.findStaff(1L), "waiting").getResultList();
		model.addAttribute("visitor", Visitor.findVisitor(visitors.get(0).getId()));
		return "staff/home";
	}
	
	@RequestMapping(value = "/staff/serve/{id}", method = RequestMethod.GET)
	public String serve(@PathVariable("id") long id, Model model) {
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String startTime = sdf.format(cal.getTime());
		Visitor visitor = Visitor.findVisitor(id);
		visitor.setStatus("served");
		visitor.setStartTimeServed(Time.valueOf(startTime));
		visitor.merge();
		
		model.addAttribute("visitor", Visitor.findVisitor(id));
		model.addAttribute("service", "serve");
		
		return "staff/home";
	}
	
	@RequestMapping(value = "/staff/transferVisitor/{id}", method = RequestMethod.POST)
	public String transfer(@PathVariable("id") long id, @ModelAttribute("visitor") Visitor visitor,Model model){
		Visitor visit = Visitor.findVisitor(id);
		visit.setId(id);
		visit.setStaff(visitor.getStaff());
		visit.setStatus("waiting");
		visit.merge();
		List<Visitor> visitors = Visitor.findVisitorsByStaffAndStatus(Staff.findStaff(1L), "waiting").getResultList();
		model.addAttribute("visitor", Visitor.findVisitor(visitors.get(0).getId()));
		return "staff/home";
	}
	
	@RequestMapping(value = "/staff/transfer/{id}", method = RequestMethod.GET)
	public String transferForm(@PathVariable("id") long id, @ModelAttribute("visitor") Visitor visitor,Model model){
		model.addAttribute("staffList", Staff.findAllStaffs());
		model.addAttribute("visitor", Visitor.findVisitor(id));
		return "staff/transfer";
	}
}

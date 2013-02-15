package com.torm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.torm.domain.Staff;

@Controller
public class AdminController {

	@RequestMapping(value="/admin/home")
	public String display(Model model){
		model.addAttribute("staffs", Staff.findAllStaffs());
		return "admin/home";
	}
}

package com.torm.controller;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.torm.domain.Staff;
import com.torm.domain.Visitor;

@RequestMapping("/visitors")
@Controller
@RooWebScaffold(path = "visitors", formBackingObject = Visitor.class)
public class VisitorController {
	
	public void rodel(){
		Staff staff = new Staff();
		Visitor visitor = new Visitor();
		visitor.setStaff(staff);
		
		visitor.persist();
	}
}

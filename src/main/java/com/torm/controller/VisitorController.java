package com.torm.controller;

import com.torm.domain.Visitor;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/visitors")
@Controller
@RooWebScaffold(path = "visitors", formBackingObject = Visitor.class)
public class VisitorController {
	
}

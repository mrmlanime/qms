package com.torm.controller;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.torm.domain.Staff;

@RequestMapping("/staff")
@Controller
@RooWebScaffold(path = "staff", formBackingObject = Staff.class)
public class StaffController {

}

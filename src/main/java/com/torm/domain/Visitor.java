package com.torm.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Visitor {

	@NotNull
	private long requestNumber;
	
	@NotNull
	@Pattern(regexp="[A-Za-z]", message="Invalid First Name")
	private String firstName;
	
	@NotNull
	@Pattern(regexp="[A-Za-z]", message="Invalid Last Name")
	private String lastName;
	
	
	private Staff staff;
	
	@NotNull
	private String purpose;
}

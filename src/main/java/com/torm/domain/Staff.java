package com.torm.domain;

import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Staff {

	@NotNull
	private String userName;
	
	@NotNull
	private String password;
	
    @NotNull
    private String firstName;

    private String middleName;
    
    @NotNull
    private String lastName;
}

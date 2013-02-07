package com.torm.domain;

import java.util.Set;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord

public class User {
    @NotNull
    @Pattern(regexp="[A-Za-z]", message="Invalid First Name")
    private String firstName;

    @Pattern(regexp="[A-Za-z]", message="Invalid Middle Name")
    private String middleName;
    
    @NotNull
    @Pattern(regexp="[A-Za-z]", message="Invalid Last Name")
    private String lastName;
    
	@NotNull
	private String userName;
	
	@NotNull
	private String password;
	
    @OneToMany
    private Set<UserType> usertype;
}

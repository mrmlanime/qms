package com.torm.domain;

import java.util.Set;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;

@RooJavaBean
@RooJpaActiveRecord
public class Staff {

	@NotNull
	private String userName;
	
	@NotNull
	private String password;
	
    @NotNull
    @Pattern(regexp="[A-Za-z]", message="Invalid First Name")
    private String firstName;

    @Pattern(regexp="[A-Za-z]", message="Invalid Middle Name")
    private String middleName;
    
    @NotNull
    @Pattern(regexp="[A-Za-z]", message="Invalid Last Name")
    private String lastName;
    
    @OneToMany
    private Set<Visitor> visitors;

	@Override
	public String toString() {
		return firstName + " " + middleName + " " + lastName;
	}
}

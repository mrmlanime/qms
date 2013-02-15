package com.torm.domain;

import java.sql.Time;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findVisitorsByLastNameLike", "findVisitorsByFirstNameLike", "findVisitorsByFirstNameAndLastNameLike", "findVisitorsById", "findVisitorsByStaff", "findVisitorsByStaffAndStatus" })
public class Visitor {

    private long requestNumber;

    @NotNull
    @Size(min = 1)
    private String firstName;

    @NotNull
    @Size(min = 1)
    private String lastName;

    @NotNull
    @Size(min = 1)
    private String purpose;

    @ManyToOne
    private Staff staff;

    private String status;
    
    private Time startTimeServed;
    
    private Time endTimeServed;
}

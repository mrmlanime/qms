// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.torm.domain;

import com.torm.domain.Staff;
import com.torm.domain.Visitor;

privileged aspect Visitor_Roo_JavaBean {
    
    public long Visitor.getRequestNumber() {
        return this.requestNumber;
    }
    
    public void Visitor.setRequestNumber(long requestNumber) {
        this.requestNumber = requestNumber;
    }
    
    public String Visitor.getFirstName() {
        return this.firstName;
    }
    
    public void Visitor.setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String Visitor.getLastName() {
        return this.lastName;
    }
    
    public void Visitor.setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String Visitor.getPurpose() {
        return this.purpose;
    }
    
    public void Visitor.setPurpose(String purpose) {
        this.purpose = purpose;
    }
    
    public Staff Visitor.getStaff() {
        return this.staff;
    }
    
    public void Visitor.setStaff(Staff staff) {
        this.staff = staff;
    }
    
}
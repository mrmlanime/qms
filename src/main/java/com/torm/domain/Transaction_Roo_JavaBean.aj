// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.torm.domain;

import com.torm.domain.Staff;
import com.torm.domain.Transaction;

privileged aspect Transaction_Roo_JavaBean {
    
    public long Transaction.getRequestNumber() {
        return this.requestNumber;
    }
    
    public void Transaction.setRequestNumber(long requestNumber) {
        this.requestNumber = requestNumber;
    }
    
    public String Transaction.getFirstName() {
        return this.firstName;
    }
    
    public void Transaction.setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String Transaction.getLastName() {
        return this.lastName;
    }
    
    public void Transaction.setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Staff Transaction.getStaff() {
        return this.staff;
    }
    
    public void Transaction.setStaff(Staff staff) {
        this.staff = staff;
    }
    
    public String Transaction.getPurpose() {
        return this.purpose;
    }
    
    public void Transaction.setPurpose(String purpose) {
        this.purpose = purpose;
    }
    
}

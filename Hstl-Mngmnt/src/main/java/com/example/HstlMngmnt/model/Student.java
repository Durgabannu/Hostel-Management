package com.example.HstlMngmnt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long registrationNumber;
    private String name;
    private String department;
    private int semester;
    private String outingrequest;
    private String password;
    private String status;

    public Student() {
    }
    public Student(Long id, String name, String department, int semester,Long registrationNumber) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.semester = semester;
        this.outingrequest=outingrequest;
        this.registrationNumber=registrationNumber;
        this.status=status;
    }
    public Long getId() {
        return id;
    }
    public Long getRegistrationNumber() {
        return registrationNumber;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public int getSemester() {
        return semester;
    }
    public String getoutingrequest(){
        return outingrequest;
    }
    public String getstatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setSemester(int semester) {
        this.semester = semester;
    }
    public void setOutingRequest(String outingrequest) {
        this.outingrequest = outingrequest;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    @Override
    public String toString() {
        return "Student [id=" + id + ", registrationNumber=" + registrationNumber + ", name=" + name + ", department="
                + department + ", semester=" + semester + ", outingrequest=" + outingrequest + ", status=" + status
                + "]";
    }
    public Object getOtherFields() {
        return null;
    }
    public void setOtherFields(Object otherFields) {
    }
    // public void setRegistrationNumber(Long registrationNumber) {
    // }
    

    
    
    
}
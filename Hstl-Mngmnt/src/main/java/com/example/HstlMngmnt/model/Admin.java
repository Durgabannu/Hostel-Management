package com.example.HstlMngmnt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;
    public Admin() {
    }
    public Admin(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "Admin [id=" + id + ", name=" + name + ", role=" + role + "]";
    }
    public void setOtherFields(Object otherFields) {
    }
    
    
}

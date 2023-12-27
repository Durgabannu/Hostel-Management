package com.example.HstlMngmnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HstlMngmnt.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    List<Admin> findByName(String name);
}

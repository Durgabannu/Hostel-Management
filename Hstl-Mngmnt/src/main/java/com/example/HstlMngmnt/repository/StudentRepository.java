package com.example.HstlMngmnt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.HstlMngmnt.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByDepartment(String department);
    Optional<Student> findById(Long id);


    // Add a method to find students by outing request
    List<Student> findByOutingrequest(String outingrequest);
    Optional<Student> findByRegistrationNumberAndPassword(Long registrationNumber, String password);
    Optional<Student> findByRegistrationNumber(Long registrationNumber);
}

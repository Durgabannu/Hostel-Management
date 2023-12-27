package com.example.HstlMngmnt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.HstlMngmnt.model.Admin;
import com.example.HstlMngmnt.model.Student;
import com.example.HstlMngmnt.services.AdminService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Student Endpoints

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return adminService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = adminService.getStudentById(id);
        return student.map(s -> {
            // Check if the status is null or empty, set it to "pending"
            if (s.getstatus() == null || s.getstatus().isEmpty()) {
                s.setStatus("pending");
            }
            return ResponseEntity.ok(s);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // @PostMapping("/students")
    // public ResponseEntity<Student> addStudent(@RequestBody Student student) {
    //     Student savedStudent = adminService.addStudent(student);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    // }
    @PostMapping("/students")
public ResponseEntity<Student> addStudent(@RequestBody Student student) {
    // Ensure that the registration number is set in the request body
    // You can print the student object here for debugging
    System.out.println(student);

    Student savedStudent = adminService.addStudent(student);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
}



    // @PutMapping("/students/{id}")
    // public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
    //     Optional<Student> student = adminService.updateStudent(id, updatedStudent);
    //     return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    // }

    @PutMapping("/students/{id}/update-status")
public ResponseEntity<Student> updateOutingRequestStatus(
        @PathVariable Long id,
        @RequestBody Map<String, String> requestBody) {
    String newStatus = requestBody.get("newStatus");
    Optional<Student> student = adminService.updateOutingRequestStatus(id, newStatus);

    return student.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
}

    

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (adminService.deleteStudent(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Admin Endpoints

    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/admins/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Optional<Admin> admin = adminService.getAdminById(id);
        return admin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/admins")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        Admin savedAdmin = adminService.addAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdmin);
    }

    @PutMapping("/admins/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin updatedAdmin) {
        Optional<Admin> admin = adminService.updateAdmin(id, updatedAdmin);
        return admin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/admins/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        if (adminService.deleteAdmin(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

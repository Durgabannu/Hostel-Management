package com.example.HstlMngmnt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.HstlMngmnt.model.Admin;
import com.example.HstlMngmnt.model.Student;
import com.example.HstlMngmnt.repository.AdminRepository;
import com.example.HstlMngmnt.repository.StudentRepository;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final StudentRepository studentRepository;

    public AdminService(
            AdminRepository adminRepository,
            StudentRepository studentRepository) {
        this.adminRepository = adminRepository;
        this.studentRepository = studentRepository;
    }

    // Student Methods

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> getCompleteStudentDetails(Long id) {
        return studentRepository.findById(id);
    }

    // public Student addStudent(Student student) {
    //     return studentRepository.save(student);
    // }
    public Student addStudent(Student student) {
        // Check if outingrequest is null before setting it
        if (student.getoutingrequest() == null) {
            // Set a default value or leave it unset
            // student.setOutingRequest("Default Outing Request");
    
            // Set status to null
            student.setStatus(null);
        } else {
            // Set the status to "pending" when outingrequest is provided
            student.setStatus("pending");
        }
    
        // Add logic to handle registration number (you can set a default value if needed)
        // student.setRegistrationNumber(yourRegistrationNumber);
    
        return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student updatedEntity = existingStudent.get();
            updatedEntity.setName(updatedStudent.getName());
            updatedEntity.setDepartment(updatedStudent.getDepartment());
            updatedEntity.setSemester(updatedStudent.getSemester());
            updatedEntity.setOutingRequest(updatedStudent.getName());

            updatedEntity.setOtherFields(updatedStudent.getOtherFields());
            return Optional.of(studentRepository.save(updatedEntity));
        } else {
            return Optional.empty(); // Student with given id not found
        }
    }

    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false; // Student with given id not found
        }
    }

    // Admin Methods

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Optional<Admin> updateAdmin(Long id, Admin updatedAdmin) {
        Optional<Admin> existingAdmin = adminRepository.findById(id);
        if (existingAdmin.isPresent()) {
            Admin updatedEntity = existingAdmin.get();
            updatedEntity.setName(updatedAdmin.getName());
            updatedEntity.setRole(updatedAdmin.getRole());
            return Optional.of(adminRepository.save(updatedEntity));
        } else {
            return Optional.empty(); // Admin with given id not found
        }
    }

    public boolean deleteAdmin(Long id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return true;
        } else {
            return false; // Admin with given id not found
        }
    }

    // New method to update outing request status
    public Optional<Student> updateOutingRequestStatus(Long id, String newStatus) {
        Optional<Student> existingStudent = studentRepository.findById(id);

        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setStatus(newStatus);
            return Optional.of(studentRepository.save(student));
        } else {
            return Optional.empty(); // Student with given id not found
        }
    }
}

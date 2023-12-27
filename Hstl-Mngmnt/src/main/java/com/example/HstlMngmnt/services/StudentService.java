package com.example.HstlMngmnt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HstlMngmnt.model.Student;
import com.example.HstlMngmnt.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByDepartment(String department) {
        return studentRepository.findByDepartment(department);
    }

    public Optional<Student> updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            // Update logic, assuming Student has appropriate setters
            Student studentToUpdate = existingStudent.get();
            studentToUpdate.setRegistrationNumber(updatedStudent.getRegistrationNumber());
            studentToUpdate.setName(updatedStudent.getName());
            studentToUpdate.setDepartment(updatedStudent.getDepartment());
            studentToUpdate.setSemester(updatedStudent.getSemester());
            studentToUpdate.setOutingRequest(updatedStudent.getoutingrequest()); 

            studentToUpdate.setStatus("pending");

            return Optional.of(studentRepository.save(studentToUpdate));
        } else {
            return Optional.empty();
        }
    }
    

    public Optional<Student> updateOutingRequestStatus(Long studentId, String newStatus) {
        Optional<Student> existingStudent = studentRepository.findById(studentId);

        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setStatus(newStatus);
            return Optional.of(studentRepository.save(student));
        } else {
            return Optional.empty(); // Student with given id not found
        }
    }
    

    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false; // Student with the given id not found
        }
    }

    // public Student addStudent(Student student) {
    //     return studentRepository.save(student);
    // }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student addStudent(Student student) {
        // Set the status to "pending" when adding a new student
        student.setStatus("pending");
        return studentRepository.save(student);
    }

    // StudentService.java
    public Optional<Student> login(Long registrationNumber, String password) {
        Optional<Student> studentOptional = studentRepository.findByRegistrationNumber(registrationNumber);

        // Check if the student exists and if the registration number is used as the password
        if (studentOptional.isPresent() && studentOptional.get().getRegistrationNumber().toString().equals(password)) {
            return studentOptional;
        } else {
            return Optional.empty();
        }
    }
    }



package com.cognizant.student_app_docker;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String status() {
        return "<h1>Student App is Running</h1>";
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @GetMapping("/add-student")
    public Student addStudent() {
        Student newStudent = new Student();

        newStudent.setName("New Student");
        newStudent.setAge(23);

        return repository.save(newStudent);
    }

}

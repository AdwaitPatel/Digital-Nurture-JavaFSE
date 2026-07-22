package com.cognizant.SpringBoot15Jul.controller;

import com.cognizant.SpringBoot15Jul.entity.Student;
import com.cognizant.SpringBoot15Jul.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // GET ALL
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentRepository.findById(id).orElse(null);
    }

    // get by email
    @GetMapping("/email/{email}")
    public Student getStudentByEmail(@PathVariable String email) {
        return studentRepository.findByEmail(email);
    }

    // find by name
    @GetMapping("/name/{name}")
    public List<Student> getStudentsByName(@PathVariable String name) {
        return studentRepository.findByName(name);
    }

    // get by age
    @GetMapping("/age/{age}")
    public List<Student> getStudentsByAge(@PathVariable int age) {
        return studentRepository.findByAge(age);
    }

    // get greater than age
    @GetMapping("/more-than-age/{age}")
    public List<Student> getStudentsByAgeGreaterThan(@PathVariable int age) {
        return studentRepository.findByAgeGreaterThan(age);
    }

    // CREATE
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }


    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable int id,
            @RequestBody Student updatedStudent
    ) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setAge(updatedStudent.getAge());

            return studentRepository.save(student);
        }

        return null;
    }


    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        Student student = studentRepository.findById(id).orElse(null);

        if (student != null) {
            studentRepository.deleteById(id);
            return "Student Deleted Successfully";
        }

        return "Student Not Found";
    }
}



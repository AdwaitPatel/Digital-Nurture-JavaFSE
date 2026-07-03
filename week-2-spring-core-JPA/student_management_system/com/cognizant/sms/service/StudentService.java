package com.cognizant.sms.service;

import com.cognizant.sms.model.Student;
import com.cognizant.sms.repository.StudentDBRepository;
import java.util.ArrayList;

// this class is for validations and business logics
public class StudentService {

    private StudentDBRepository repository = new StudentDBRepository();

    // add student validations
    public boolean addStudent(String name, String email, int age) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        if (!email.contains("@")) {
            return false;
        }
        if (age <= 10) {
            return false;
        }
        // if email already exists don't create a new student
        if (repository.findStudentByEmail(email) != null) {
            return false;
        }

        Student student = new Student(name.trim(), email.trim(), age);
        repository.addStudent(student);
        return true;
    }

    // get all students
    public ArrayList<Student> getAllStudents() {
        return repository.getAllStudents();
    }

    // update student validation
    public boolean updateStudent(Student student) {
        if (student.getName() == null || student.getName().trim().isEmpty()) {
            return false;
        }
        if (!student.getEmail().contains("@")) {
            return false;
        }
        if (student.getAge() <= 10) {
            return false;
        }

        return repository.updateStudent(student);
    }

    // delete student
    public boolean deleteStudent(int id) {
        return repository.deleteStudent(id);
    }

    public Student findStudentById(int id) {
        return repository.findStudentById(id);
    }


}

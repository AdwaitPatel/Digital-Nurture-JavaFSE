package com.cognizant.sms.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.cognizant.sms.model.Student;
import java.util.ArrayList;

// this class is for storing and retrieving students
public class StudentRepository {

    private static final String FILE_NAME = "students.txt";

    // this arraylist will act as a db for now
    private ArrayList<Student> students = new ArrayList<>();

    public StudentRepository() {
        loadFromFile();
    }

    private int nextId = 1001;

    // add student
    public void addStudent(Student student) {
        student.setId(nextId++);
        students.add(student);
        saveToFile();
    }

    // get all students
    public ArrayList<Student> getAllStudents() {
        return students;
    }

    // search student by email
    public Student findStudentByEmail(String email) {
        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                return student;
            }
        }
        return null;
    }

    // search by id
    public Student findStudentById(int id) {
        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }

    // update student
    public void updateStudent(Student student) {
        saveToFile();
    }

    // delete student
    public boolean deleteStudent(int id) {
        Student student = findStudentById(id);

        if (student != null) {
            students.remove(student);
            saveToFile();
            return true;
        }

        return false;
    }



    // file operation methods

    // read from file
    private void loadFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String email = data[2];
                int age = Integer.parseInt(data[3]);

                if (id >= nextId) {
                    nextId = id + 1;
                }

                students.add(new Student(id, name, email, age));
            }
        } catch (IOException e) {
            System.out.println("No existing data found.");
        }
    }

    // save to file
    private void saveToFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student student : students) {

                writer.write(
                        student.getId() + "," +
                                student.getName() + "," +
                                student.getEmail() + "," +
                                student.getAge()
                );
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }
}

package com.cognizant.sms.presentation;

import com.cognizant.sms.model.Student;
import com.cognizant.sms.service.StudentService;

import java.util.InputMismatchException;
import java.util.Scanner;

import java.sql.*;

// this class acts as a UI for interaction with all 4 layers
public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StudentService service = new StudentService();

        while (true) {

            System.out.println();
            System.out.println("==============================================");
            System.out.println("           STUDENT MANAGEMENT SYSTEM");
            System.out.println("==============================================");
            System.out.printf("%-5s %s%n", "[1]", "Add Student");
            System.out.printf("%-5s %s%n", "[2]", "View Students");
            System.out.printf("%-5s %s%n", "[3]", "Update Student");
            System.out.printf("%-5s %s%n", "[4]", "Delete Student");
            System.out.printf("%-5s %s%n", "[5]", "Exit");
            System.out.println("==============================================");
            System.out.print("Choice > ");

            int choice = 5;
            try {
                System.out.print("Enter your choice : ");
                choice = sc.nextInt();
                sc.nextLine(); // nextInt() leaves a new line in input buffer that's why we used nextLine()
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid number only!!");
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email : ");
                    String email = sc.nextLine();

                    System.out.print("Enter Age : ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    if (service.addStudent(name, email, age)) {
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Failed to add student.");
                    }

                    break;

                case 2:
                    int totalStudents = service.getAllStudents().size();
                    if (totalStudents == 0) {
                        System.out.println("There are no students yet.");
                        break;
                    }
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.printf("%-10s %-20s %-33s %-5s%n", "Id", "Name", "Email", "Age");
                    System.out.println("-------------------------------------------------------------------------");

                    for (Student student : service.getAllStudents()) {
                        System.out.printf("%-10d %-20s %-33s %-5d%n",
                                student.getId(),
                                student.getName(),
                                student.getEmail(),
                                student.getAge());
                    }

                    System.out.println("-------------------------------------------------------------------------");
                    System.out.println("Total Students: " + totalStudents);

                    break;

                case 3:
                    totalStudents = service.getAllStudents().size();
                    if (totalStudents == 0) {
                        System.out.println("Add some students before updating.");
                        break;
                    }
                    System.out.print("Enter id of Student : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Student student = service.findStudentById(id);

                    if (student == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.println("\nCurrent Details:");
                    System.out.println("ID    : " + student.getId());
                    System.out.println("Name  : " + student.getName());
                    System.out.println("Email : " + student.getEmail());
                    System.out.println("Age   : " + student.getAge());

                    System.out.println();
                    System.out.println("==============================================");
                    System.out.printf("%-5s %s%n", "[1]", "Update Student name");
                    System.out.printf("%-5s %s%n", "[2]", "Update Student email");
                    System.out.printf("%-5s %s%n", "[3]", "Update Student age");
                    System.out.printf("%-5s %s%n", "[4]", "Update all three");
                    System.out.println("==============================================");
                    System.out.print("Choice > ");
                    int update_choice = sc.nextInt();
                    sc.nextLine();

                    switch (update_choice) {
                        case 1:
                            System.out.print("Enter New Name : ");
                            String newName = sc.nextLine();
                            student.setName(newName);
                            break;
                        case 2:
                            System.out.print("Enter New Email : ");
                            String newEmail = sc.nextLine();
                            student.setEmail(newEmail);
                            break;
                        case 3:
                            System.out.print("Enter New Age : ");
                            int newAge = sc.nextInt();
                            sc.nextLine();
                            student.setAge(newAge);
                            break;
                        case 4:
                            System.out.print("Enter New Name : ");
                            newName = sc.nextLine();

                            System.out.print("Enter New Email : ");
                            newEmail = sc.nextLine();

                            System.out.print("Enter New Age : ");
                            newAge = sc.nextInt();
                            sc.nextLine();

                            student.setName(newName);
                            student.setEmail(newEmail);
                            student.setAge(newAge);
                            break;
                        default:
                            System.out.println("Enter a valid choice.");
                    }

                    if (service.updateStudent(student)) {
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Invalid data.");
                    }

                    break;

                case 4:
                    totalStudents = service.getAllStudents().size();
                    if (totalStudents == 0) {
                        System.out.println("There are no students to delete.");
                        break;
                    }
                    System.out.print("Enter id of student : ");
                    id = sc.nextInt();
                    sc.nextLine();

                    if (service.deleteStudent(id)) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 5:

                    System.out.println("Thanks for using our SMS!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Choose again!");
            }
        }


    }
}

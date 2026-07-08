package com.employee.model;

public class Employee {
    private int id;
    private String name;
    private String email;

    // Constructors
    public Employee() {}

    public Employee(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Employee(String name, String email) {
        this(0, name, email);
    }

    // Getters and Setters with fluent API
    public int id() {
        return id;
    }
    public Employee id(int id) {
        this.id = id; return this;
    }

    public String name() {
        return name;
    }
    public Employee name(String name) {
        this.name = name; return this;
    }

    public String email() {
        return email;
    }
    public Employee email(String email) {
        this.email = email; return this;
    }

    // Traditional getters/setters for compatibility
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';

    }

}





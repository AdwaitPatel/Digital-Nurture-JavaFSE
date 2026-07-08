# Builder Design Pattern

## Definition

The **Builder Design Pattern** is a **Creational Design Pattern** that constructs **complex objects step by step**.

It is particularly useful when:

- An object has many **optional parameters**.
- Different representations of the same object need to be created.
- Object construction should be separated from the object's representation.

Instead of creating objects using long constructors, the Builder Pattern constructs them gradually using a **Builder**.

---

# Why do we need the Builder Pattern?

Suppose we have a `Student` class.

Mandatory fields:

- Roll Number
- Name
- Age
- Branch

Optional fields:

- Father's Name
- Mother's Name
- Mobile Number
- Email
- Subjects

Without Builder, we usually write constructors like:

```java
Student s1 = new Student(1,20,"John","CSE");

Student s2 = new Student(1,20,"John","CSE","Paul");

Student s3 = new Student(1,20,"John","CSE","Paul","Jane");

Student s4 = new Student(
    1,
    20,
    "John",
    "CSE",
    "Paul",
    "Jane",
    subjects,
    "9876543210",
    "john@gmail.com"
);
```

As more optional fields are added, constructors become longer and harder to maintain.

This problem is called the **Telescoping Constructor Problem**.

Builder Pattern solves this issue.

---

# Problems Without Builder Pattern

When we use constructor overloading for many optional parameters, several problems arise:

### 1. Telescoping Constructors

Large number of constructors are required.

```text
Student()

Student(id)

Student(id,name)

Student(id,name,email)

Student(id,name,email,phone)

Student(id,name,email,phone,address)
```

The number of constructors keeps increasing.

---

### 2. Poor Readability

```java
Student s = new Student(
    1,
    20,
    "John",
    "CSE",
    "Paul",
    "Jane",
    subjects,
    "9876543210",
    "john@gmail.com"
);
```

Without looking at the constructor definition, it's impossible to know what each parameter represents.

---

### 3. Error-Prone

Consider:

```java
new Student(
    1,
    20,
    "John",
    "CSE",
    "9876543210",
    "john@gmail.com"
);
```

Since both parameters are `String`, accidentally swapping them still compiles but creates incorrect objects.

---

### 4. Passing null

Sometimes optional values aren't needed.

```java
new Student(
    1,
    20,
    "John",
    "CSE",
    null,
    null,
    null,
    null,
    "john@gmail.com"
);
```

This is ugly and increases the chance of bugs.

---

### 5. Difficult to Create Immutable Objects

If fields are `final`, setters cannot be used later.

Builder solves this by constructing the object completely before creation.

---

### 6. Difficult Testing

Creating test objects becomes very verbose.

Builder makes test object creation simple.

---

### 7. Violates SRP

The Student class handles both:

- Data storage
- Object construction

Builder separates construction from representation.

---

# Real-World Analogy

Imagine ordering a burger.

You choose:

Mandatory:

- Bun
- Patty

Optional:

- Cheese
- Onion
- Tomato
- Extra Sauce
- Jalapenos

You don't create the burger yourself.

Instead, you tell the chef your requirements.

The chef builds it step by step.

Builder Pattern works exactly the same way.

Client → Builder → Complex Object

---

# Components of Builder Pattern

## 1. Product

The complex object that is being built.

Example:

```java
Student
```

Contains:

- Mandatory fields
- Optional fields

---

## 2. Builder

Defines all construction steps.

Provides setter methods for each field.

Contains:

```java
build()
```

method to create the final object.

---

## 3. Concrete Builder

Implements the Builder.

Contains construction logic specific to a product.

Example:

```text
EngineeringStudentBuilder

MBAStudentBuilder
```

Each creates different subjects.

---

## 4. Director (Optional)

Controls the construction sequence.

Knows how to create standard objects.

Example:

```text
StudentRegistrationDirector
```

---

## 5. Client

Uses Builder or Director to create objects.

---

# Implementation

## Step 1 : Product

```java
public class Student {

    int rollNumber;
    int age;
    String name;
    String branch;

    String fatherName;
    String motherName;
    String mobileNo;
    String emailId;
    List<String> subjects;

    Student(StudentBuilder builder){

        this.rollNumber = builder.rollNumber;
        this.age = builder.age;
        this.name = builder.name;
        this.branch = builder.branch;
        this.fatherName = builder.fatherName;
        this.motherName = builder.motherName;
        this.mobileNo = builder.mobileNo;
        this.emailId = builder.emailId;
        this.subjects = builder.subjects;
    }

}
```

Notice that only the Builder creates Student objects.

---

## Step 2 : Abstract Builder

```java
public abstract class StudentBuilder {

    int rollNumber;
    int age;
    String name;
    String branch;

    String fatherName;
    String motherName;
    String mobileNo;
    String emailId;
    List<String> subjects;

    public StudentBuilder setRollNumber(int rollNumber){
        this.rollNumber = rollNumber;
        return this;
    }

    public StudentBuilder setAge(int age){
        this.age = age;
        return this;
    }

    public StudentBuilder setName(String name){
        this.name = name;
        return this;
    }

    public StudentBuilder setBranch(String branch){
        this.branch = branch;
        return this;
    }

    public StudentBuilder setFatherName(String fatherName){
        this.fatherName = fatherName;
        return this;
    }

    public StudentBuilder setMotherName(String motherName){
        this.motherName = motherName;
        return this;
    }

    public StudentBuilder setMobileNo(String mobileNo){
        this.mobileNo = mobileNo;
        return this;
    }

    public StudentBuilder setEmailId(String emailId){
        this.emailId = emailId;
        return this;
    }

    public abstract StudentBuilder setSubjects();

    public Student build(){
        return new Student(this);
    }

}
```

Notice every setter returns

```java
this
```

This enables **Method Chaining**

---

# Fluent Interface

Builder Pattern commonly uses a **Fluent Interface**.

Instead of

```java
builder.setName("John");

builder.setAge(20);

builder.setBranch("CSE");
```

we write

```java
builder
    .setName("John")
    .setAge(20)
    .setBranch("CSE")
    .build();
```

This improves readability.

---

## Step 3 : Concrete Builder

### Engineering Student

```java
public class EngineeringStudentBuilder extends StudentBuilder {

    @Override
    public StudentBuilder setSubjects(){

        subjects = List.of(
            "Operating Systems",
            "Computer Architecture",
            "Data Structures",
            "DBMS"
        );

        return this;
    }

}
```

---

### MBA Student

```java
public class MBAStudentBuilder extends StudentBuilder {

    @Override
    public StudentBuilder setSubjects(){

        subjects = List.of(
            "Micro Economics",
            "Business Studies",
            "Operations Management",
            "Financial Management"
        );

        return this;
    }

}
```

---

## Step 4 : Director (Optional)

```java
public class StudentRegistrationDirector {

    StudentBuilder builder;

    StudentRegistrationDirector(StudentBuilder builder){
        this.builder = builder;
    }

    public Student createStudent(){

        return builder
                .setRollNumber(1)
                .setName("John")
                .setAge(22)
                .setBranch("CSE")
                .setSubjects()
                .build();

    }

}
```

Director defines a standard construction sequence.

---

## Step 5 : Client

```java
StudentRegistrationDirector director = new StudentRegistrationDirector(
        new EngineeringStudentBuilder()
    );

Student student = director.createStudent();

System.out.println(student);
```

---

# How Builder Pattern Works

1. Client creates a Builder.
2. Builder sets values step by step.
3. Builder calls `build()`.
4. Builder creates the Product.
5. Client receives the completed object.

---

# Advantages

- Eliminates Telescoping Constructors.
- Better readability.
- Supports immutable objects.
- Easy to add optional fields.
- Separates construction from representation.
- Supports method chaining.
- Follows Single Responsibility Principle.
- Easy to create test objects.

---

# Disadvantages

- More classes.
- Slightly more code.
- Overkill for simple objects.

---

# When Should We Use Builder Pattern?

Use Builder when:

- Object has many optional fields.
- Constructor has many parameters.
- Object creation is complex.
- Immutable objects are required.
- Different representations of the same object are needed.

---

# Builder vs Constructor

| Constructor | Builder |
|-------------|---------|
| Long parameter list | Step-by-step construction |
| Difficult to read | Highly readable |
| Hard to maintain | Easy to maintain |
| No method chaining | Supports fluent interface |
| Hard to create immutable objects | Ideal for immutable objects |

---

# Builder vs Decorator

| Builder | Decorator |
|----------|-----------|
| Creates complex objects | Adds responsibilities dynamically |
| Focuses on object construction | Focuses on object behavior |
| Creational Pattern | Structural Pattern |
| Object built once | Behavior can be extended repeatedly |

---

# Interview Questions

## Why Builder Pattern?

To solve the Telescoping Constructor Problem.

---

## What is Method Chaining?

Returning `this` from every setter.

Example:

```java
builder
    .setName("John")
    .setAge(20)
    .build();
```

---

## Is Director mandatory?

No.

Many modern Builder implementations skip the Director.

---

## Which SOLID principle does Builder support?

**Single Responsibility Principle (SRP)**

Construction logic is separated from the Product.

---

## Does Builder support immutable objects?

Yes.

Objects can have `final` fields and be initialized only once through the Builder.

---

# Key Points

- Product → Complex object
- Builder → Defines construction steps
- Concrete Builder → Implements construction
- Director → Controls building sequence (optional)
- Client → Uses Builder

---

# One-Line Revision

> **Builder Pattern constructs complex objects step by step, making object creation more readable, flexible, and maintainable.**
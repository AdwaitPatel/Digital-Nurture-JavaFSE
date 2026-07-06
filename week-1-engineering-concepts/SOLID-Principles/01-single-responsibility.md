# Single Responsibility Principle

**A class should have only one reason to change.**

A class should have only **one responsibility**. If it performs multiple unrelated tasks, it becomes difficult to maintain, test, and extend.

### Bad Example

``` java
class Employee {

    public void calculateSalary() {
        // Salary calculation
    }

    public void saveToDatabase() {
        // Database logic
    }

    public void sendEmail() {
        // Email logic
    }
}
```

#### Problems

This class has three responsibilities: 
1. Salary calculation 
2. Database operations 
3. Email notifications

Any change to one responsibility requires modifying the same class.

### Good Example

#### Employee.java

``` java
class Employee {

    public double calculateSalary() {
        return 50000;
    }
}
```

#### EmployeeRepository.java

``` java
class EmployeeRepository {

    public void save(Employee employee) {
        System.out.println("Employee saved.");
    }
}
```

#### EmailService.java

``` java
class EmailService {

    public void sendEmail(Employee employee) {
        System.out.println("Email sent.");
    }
}
```

Each class now has exactly one responsibility.

### Key Points

-   One class = One responsibility
-   One responsibility = One reason to change
-   Split unrelated functionalities into separate classes.
-   Improves maintainability, readability, and testability.




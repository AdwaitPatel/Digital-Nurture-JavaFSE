# Dependency Inversion Principle (DIP)

**High-level modules should not depend on low-level modules. Both should depend on abstractions.**

In simple words:

> **Classes should depend on interfaces (or abstract classes), not on concrete implementations.**

This makes the system flexible, maintainable, and easy to extend.

---

## Why do we need DIP?

Suppose you're developing a user management system.

Initially, you use MySQL as your database.

After a few months, your company decides to migrate to PostgreSQL.

If your business logic directly depends on MySQL, you'll need to modify the business logic itself.

This tightly couples your code to one implementation.

DIP solves this by introducing an abstraction (interface) between the high-level and low-level modules.

Benefits:

- Loose coupling
- Easier testing
- Easier maintenance
- Better scalability
- Easy to swap implementations

---

## Bad Example

### MySQLDatabase.java

```java
class MySQLDatabase {

    public void save() {
        System.out.println("Saving data in MySQL");
    }
}
```

### UserService.java

```java
class UserService {

    private MySQLDatabase database = new MySQLDatabase();

    public void registerUser() {
        database.save();
    }
}
```

### Problems

`UserService` directly depends on `MySQLDatabase`.

If tomorrow we change the database to:

- PostgreSQL
- MongoDB
- Oracle

We must modify `UserService`.

This violates DIP because the high-level module depends on a low-level implementation.

---

## Good Example

### Step 1: Create an abstraction

```java
interface Database {

    void save();
}
```

---

### Step 2: Implement the abstraction

```java
class MySQLDatabase implements Database {

    @Override
    public void save() {
        System.out.println("Saving data in MySQL");
    }
}
```

```java
class PostgreSQLDatabase implements Database {

    @Override
    public void save() {
        System.out.println("Saving data in PostgreSQL");
    }
}
```

---

### Step 3: High-level module depends on abstraction

```java
class UserService {

    private Database database;

    public UserService(Database database) {
        this.database = database;
    }

    public void registerUser() {
        database.save();
    }
}
```

---

### Step 4: Main Method

```java
public class Main {

    public static void main(String[] args) {

        Database database = new MySQLDatabase();

        UserService service = new UserService(database);

        service.registerUser();
    }
}
```

If we later switch to PostgreSQL:

```java
Database database = new PostgreSQLDatabase();

UserService service = new UserService(database);
```

No changes are required in `UserService`.

Only the implementation changes.

This follows the Dependency Inversion Principle.

---

## Another Example

Imagine a notification system.

### Bad Design

```java
class EmailService {

    public void send() {
        System.out.println("Email Sent");
    }
}
```

```java
class NotificationManager {

    private EmailService email = new EmailService();

    public void notifyUser() {
        email.send();
    }
}
```

Tomorrow the company wants SMS notifications.

You must modify `NotificationManager`.

This violates DIP.

---

### Better Design

```java
interface Notification {

    void send();
}
```

```java
class EmailNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Email Sent");
    }
}
```

```java
class SMSNotification implements Notification {

    @Override
    public void send() {
        System.out.println("SMS Sent");
    }
}
```

```java
class NotificationManager {

    private Notification notification;

    public NotificationManager(Notification notification) {
        this.notification = notification;
    }

    public void notifyUser() {
        notification.send();
    }
}
```

Now new notification types can be added without modifying `NotificationManager`.

---

## Real-World Analogy

Think about charging your phone.

Your phone does **not** depend on a specific charger brand.

Instead, it depends on a **USB-C port** (the abstraction).

Different companies can manufacture compatible chargers because they all follow the USB-C standard.

Phone → Depends on USB-C

Not on Samsung charger.

Not on Apple charger.

Not on Google charger.

Similarly, classes should depend on interfaces rather than concrete classes.

---

## Advantages

- Loose coupling
- Easy to replace implementations
- Easier unit testing using mock objects
- Better scalability
- Easier maintenance
- Promotes clean architecture
- Foundation of Dependency Injection (DI)

---

## Key Points

- Depend on interfaces, not concrete classes.
- Use constructor injection whenever possible.
- Easy to replace implementations.
- Enables dependency injection.
- Reduces coupling between classes.

---

## Common Interview Questions

### Q1. What is the Dependency Inversion Principle?

High-level modules should depend on abstractions instead of concrete implementations.

---

### Q2. What is the difference between Dependency Inversion and Dependency Injection?

**Dependency Inversion Principle (DIP)**

A design principle that says:

> Depend on abstractions, not implementations.

**Dependency Injection (DI)**

A technique used to implement DIP by providing dependencies from outside the class.

---

### Q3. Why does Spring use interfaces everywhere?

Spring follows DIP.

Classes depend on interfaces, allowing implementations to be swapped easily and making testing simpler.

---

### Q4. Which type of Dependency Injection is preferred?

Constructor Injection.

Example:

```java
public UserService(Database database) {
    this.database = database;
}
```

Constructor injection ensures required dependencies are available when the object is created and makes the class easier to test.

---

## One-Line Revision

**Depend on abstractions (interfaces), not concrete implementations.**
# Interface Segregation Principle (ISP)

**Clients(classes) should not be forced to depend on interfaces they do not use.**

In simple words:

> **Instead of creating one large interface with many methods, create multiple small, specific interfaces.**

A class should implement **only the methods it actually needs**.

---

## Why do we need ISP?

Imagine we create one huge interface containing many unrelated methods.

When a class implements this interface, it is forced to provide implementations for every method—even those that are irrelevant.

This leads to:

- Empty method implementations
- Runtime exceptions
- Unnecessary dependencies
- Difficult maintenance

ISP solves this by encouraging **small, focused interfaces**.

Benefits:
- Cleaner code
- Better maintainability
- Higher flexibility
- Easier testing
- Lower coupling

---

## Bad Example

### Worker.java

```java
interface Worker {

    void work();

    void eat();

    void sleep();
}
```

### Human.java

```java
class Human implements Worker {

    @Override
    public void work() {
        System.out.println("Working...");
    }

    @Override
    public void eat() {
        System.out.println("Eating...");
    }

    @Override
    public void sleep() {
        System.out.println("Sleeping...");
    }
}
```

### Robot.java

```java
class Robot implements Worker {

    @Override
    public void work() {
        System.out.println("Working...");
    }

    @Override
    public void eat() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sleep() {
        throw new UnsupportedOperationException();
    }
}
```

### Problems

A robot can work, but it doesn't eat or sleep.

Yet it is forced to implement those methods.

This violates the Interface Segregation Principle.

---

## Good Example

Split the large interface into smaller interfaces.

### Workable.java

```java
interface Workable {

    void work();
}
```

### Eatable.java

```java
interface Eatable {

    void eat();
}
```

### Sleepable.java

```java
interface Sleepable {

    void sleep();
}
```

### Human.java

```java
class Human implements Workable, Eatable, Sleepable {

    @Override
    public void work() {
        System.out.println("Working...");
    }

    @Override
    public void eat() {
        System.out.println("Eating...");
    }

    @Override
    public void sleep() {
        System.out.println("Sleeping...");
    }
}
```

### Robot.java

```java
class Robot implements Workable {

    @Override
    public void work() {
        System.out.println("Working...");
    }
}
```

Now each class implements only the interfaces it actually needs.
No unnecessary methods.
No exceptions.
ISP is satisfied.

---

## Another Example

### Bad Design

```java
interface SmartDevice {

    void call();

    void takePhoto();

    void playMusic();

    void printDocument();
}
```

Now consider a smartphone.

```java
class Smartphone implements SmartDevice {

    @Override
    public void call() {}

    @Override
    public void takePhoto() {}

    @Override
    public void playMusic() {}

    @Override
    public void printDocument() {
        throw new UnsupportedOperationException();
    }
}
```

A smartphone cannot directly print documents, but it is forced to implement the method.

This is an ISP violation.

A better design would be:

```java
interface Callable {
    void call();
}

interface Camera {
    void takePhoto();
}

interface MusicPlayer {
    void playMusic();
}

interface Printer {
    void printDocument();
}
```

Now each device implements only the required interfaces.

---

## Real-World Analogy

Think about a TV remote.

A simple TV remote usually has:

- Power
- Volume
- Channel

Imagine the manufacturer adds buttons for:

- Washing Machine
- Air Conditioner
- Refrigerator
- Microwave

Most users will never use them.

A remote should only provide the controls required for its purpose.

Similarly, classes should only implement the methods they actually need.

---

## Advantages

- Smaller and focused interfaces.
- No unnecessary method implementations.
- Better flexibility.
- Easier maintenance.
- Easier testing.
- Reduced coupling.
- Encourages composition over large interfaces.

---

## Key Points

- Prefer multiple small interfaces over one large interface.
- Classes should implement only what they need.
- Avoid empty methods.
- Avoid throwing `UnsupportedOperationException`.
- Focus on interface-specific behavior.

---

## Common Interview Questions

### Q1. What is a "Fat Interface"?

An interface containing many unrelated methods that force implementing classes to provide unnecessary implementations.

Example:

```java
interface Worker {

    void work();

    void eat();

    void sleep();

    void code();

    void drive();

    void cook();
}
```

This is called a **Fat Interface** and should be split into multiple smaller interfaces.

---

### Q2. What usually indicates an ISP violation?

- Empty method implementations
- Throwing `UnsupportedOperationException`
- Large interfaces with unrelated methods
- Classes implementing methods they never use

---

### Q3. How is ISP different from SRP?

**SRP (Single Responsibility Principle):**
Focuses on **classes**.

> A class should have only one responsibility.

**ISP (Interface Segregation Principle):**
Focuses on **interfaces**.

> An interface should expose only related methods so implementing classes aren't forced to implement unnecessary ones.

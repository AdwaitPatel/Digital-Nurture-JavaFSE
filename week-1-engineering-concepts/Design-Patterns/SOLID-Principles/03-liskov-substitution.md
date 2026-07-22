# Liskov Substitution Principle

**Objects of a subclass should be replaceable with objects of the superclass without affecting the correctness of the program.**

In simple words:

**If class B extends class A, then wherever class A is used, class B should be usable without causing unexpected behavior or errors.**

A child class should **extend** the behavior of its parent, **not break it**.

---

## Why do we need LSP?

Inheritance represents an **"is-a" relationship**.

For example:

- Car is a Vehicle
- Dog is an Animal
- Circle is a Shape

If a subclass cannot behave like its parent, then inheritance has been used incorrectly.

Violating LSP leads to:

- Runtime exceptions
- Unexpected behavior
- Difficult debugging
- Poor code maintainability

---

## Bad Example

### Bird.java

```java
class Bird {

    public void fly() {
        System.out.println("Bird is flying");
    }
}
```

### Penguin.java

```java
class Penguin extends Bird {

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins cannot fly");
    }
}
```

### Main.java

```java
public class Main {

    public static void main(String[] args) {

        Bird bird = new Penguin();

        bird.fly();
    }
}
```

### Problems

The program expects every `Bird` to fly.

However, `Penguin` cannot.

Instead of behaving like a normal Bird, it throws an exception.

This violates the **Liskov Substitution Principle** because replacing `Bird` with `Penguin` changes the expected behavior.

---

## Good Example

Instead of assuming every bird can fly, separate flying birds from non-flying birds.

### Bird.java

```java
class Bird {

    public void eat() {
        System.out.println("Bird is eating");
    }
}
```

### FlyingBird.java

```java
class FlyingBird extends Bird {

    public void fly() {
        System.out.println("Flying...");
    }
}
```

### Sparrow.java

```java
class Sparrow extends FlyingBird {

}
```

### Eagle.java

```java
class Eagle extends FlyingBird {

}
```

### Penguin.java

```java
class Penguin extends Bird {

}
```

Now:

- Sparrow can fly.
- Eagle can fly.
- Penguin simply doesn't have a `fly()` method.

No exceptions are thrown.

LSP is satisfied.

---

## Another Example

### Bad Design

```java
class Rectangle {

    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}
```

```java
class Square extends Rectangle {

    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(int height) {
        this.width = height;
        this.height = height;
    }
}
```

Now consider:

```java
Rectangle rectangle = new Square();

rectangle.setWidth(5);
rectangle.setHeight(10);

System.out.println(rectangle.getArea());
```

Expected output:

```
50
```

Actual output:

```
100
```

Why?

Because changing the height also changes the width.

The subclass changes the expected behavior of the parent.

This is one of the most famous examples of violating LSP.

---

## Advantages

- Prevents unexpected runtime errors.
- Makes inheritance reliable.
- Improves code reusability.
- Reduces bugs.
- Makes polymorphism work correctly.
- Leads to better object-oriented design.

---

## Key Points

- Child classes should behave like their parent.
- Do not override methods just to throw exceptions.
- Do not remove functionality inherited from the parent.
- Inheritance should represent a true **"is-a" relationship**.
- If a subclass cannot fully behave like its parent, inheritance is probably the wrong choice.

---

---

### Ques. What usually indicates an LSP violation?

- Throwing `UnsupportedOperationException`
- Empty overridden methods
- Changing the expected behavior of inherited methods
- Runtime failures when using polymorphism

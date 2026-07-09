# Decorator Design Pattern

## Definition

The **Decorator Design Pattern** is a **Structural Design Pattern** that allows you to **add new functionality to objects dynamically without altering their original structure.**

Instead of modifying an existing class or creating numerous subclasses, the Decorator Pattern wraps an existing object and adds new behavior at runtime.

> **One-Line Definition:** Decorator dynamically adds responsibilities to an object without changing its original code.

---

# Why do we need the Decorator Pattern?

Suppose we have a Pizza Shop.

### Base Pizza
- Plain Pizza
- Farmhouse
- Tandoori Paneer Delight
- Chicken Dominator

### Available Toppings
- Extra Cheese
- Veggies
- Mushroom
- Pepperoni

Without the Decorator Pattern, we would need a separate class for every possible combination of toppings, leading to **Class Explosion**.

---

# Problem: Class Explosion

```
PlainPizza
PlainPizzaWithCheese
PlainPizzaWithVeggies
PlainPizzaWithCheeseAndVeggies
PlainPizzaWithCheeseAndMushroom
...
```

Decorator solves this by wrapping objects dynamically.

---

# Real-World Analogies

## Pizza Shop

```
Plain Pizza
      |
Extra Cheese
      |
Veggies
      |
Mushroom
```

Every topping wraps the previous pizza.

## Coffee Cafe

Base Coffee: Espresso

Add-ons:
- Milk
- Sugar
- Ice
- Chocolate Syrup
- Vanilla Ice Cream

Each add-on decorates the previous coffee.

---

# Components

## 1. Component

```java
public interface BasePizza {
    String getDescription();
    double getCost();
}
```

## 2. Concrete Component

```java
public class PlainPizza implements BasePizza {

    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 200;
    }
}
```

Other concrete components:
- Farmhouse
- TandooriPaneerDelight
- ChickenDominator

## 3. Base Decorator

```java
public abstract class ToppingDecorator implements BasePizza {

    protected BasePizza pizza;

    public ToppingDecorator(BasePizza pizza) {
        this.pizza = pizza;
    }
}
```

## 4. Concrete Decorators

### Extra Cheese

```java
public class ExtraCheeseTopping extends ToppingDecorator {

    public ExtraCheeseTopping(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Extra Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 20;
    }
}
```

### Veggies

```java
public class VeggiesTopping extends ToppingDecorator {

    public VeggiesTopping(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Veggies";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 30;
    }
}
```

### Mushroom

```java
public class MushroomTopping extends ToppingDecorator {

    public MushroomTopping(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Mushroom";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 40;
    }
}
```

### Pepperoni

```java
public class PepperoniTopping extends ToppingDecorator {

    public PepperoniTopping(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " + Pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 50;
    }
}
```

---

# Client

```java
BasePizza pizza =
    new MushroomTopping(
        new PepperoniTopping(
            new ExtraCheeseTopping(
                new PlainPizza()
            )
        )
    );

System.out.println(pizza.getDescription());
System.out.println(pizza.getCost());
```

Output

```
Plain Pizza + Extra Cheese + Pepperoni + Mushroom
Cost = 310
```

---

# Relationships

## IS-A
- PlainPizza is-a BasePizza
- ToppingDecorator is-a BasePizza
- ExtraCheeseTopping is-a ToppingDecorator
- ExtraCheeseTopping is-a BasePizza

## HAS-A
- ToppingDecorator has-a BasePizza
- Every decorator wraps another BasePizza

---

# Advantages

- Adds functionality dynamically
- Avoids class explosion
- Uses Composition over Inheritance
- Follows Open/Closed Principle
- Flexible and reusable

---

# Disadvantages

- Many small classes
- Slightly complex
- Deep decorator chains can be harder to debug

---

# When to Use

- Optional features
- Many feature combinations
- Runtime behavior changes
- Avoid subclass explosion

---

# Decorator vs Inheritance

| Inheritance | Decorator |
|-------------|-----------|
| Compile-time | Runtime |
| Fixed behavior | Dynamic behavior |
| Class explosion | Avoids class explosion |

---

# Decorator vs Adapter

| Decorator | Adapter |
|-----------|---------|
| Adds behavior | Converts interfaces |
| Enhances object | Makes incompatible classes compatible |

---

# Interview Questions

## Why use Decorator?

To add functionality dynamically without modifying existing classes.

## Which SOLID principle does it support?

Open/Closed Principle.

## Which relationship is most important?

HAS-A (Composition).

## Common examples?

- Pizza toppings
- Coffee add-ons
- Java I/O Streams

---

# 30-Second Revision

- Structural Pattern
- Dynamic behavior
- Composition over Inheritance
- Avoids Class Explosion
- Decorators can be chained

---

# One-Line Revision

> Decorator Pattern dynamically adds functionality to an object by wrapping it instead of modifying its original class.

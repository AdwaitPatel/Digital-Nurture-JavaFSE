# Strategy Design Pattern

## Definition

The **Strategy Design Pattern** is a **Behavioral Design Pattern** that defines a family of algorithms, encapsulates each algorithm into separate classes, and allows the algorithm to be selected **at runtime**.

Instead of writing multiple `if-else` or `switch` statements, each algorithm is implemented as an independent strategy.

> **One-Line Definition:** Strategy Pattern allows you to change an object's behavior at runtime by selecting different algorithms dynamically.

---

# Why do we need Strategy Pattern?

Suppose you have a Shopping Cart that supports multiple payment methods:

- Credit Card
- PayPal
- UPI
- Net Banking
- Cash

Without Strategy Pattern:

```java
switch(paymentType){
    case "Credit Card":
        ...
        break;
    case "UPI":
        ...
        break;
    case "PayPal":
        ...
        break;
}
```

Every new payment method requires modifying the existing class.

Problems:

- Large `if-else` or `switch` statements
- Violates Open/Closed Principle
- Code Duplication
- Tight Coupling
- Difficult Testing

Strategy Pattern separates each algorithm into its own class.

---

# Real-World Examples

- Shopping Cart Payment Methods
- Google Maps Route Selection
- Vehicle Drive Modes
- Shipping Cost Calculation
- File Compression Algorithms
- Sorting Algorithms
- Authentication Methods

Examples from the notes:

- Vehicle Drive Modes
- Shopping Cart Payment Options

---

# Components

## 1. Strategy Interface

Defines the common contract.

Example:

```java
public interface PaymentStrategy {

    void pay(double amount);

}
```

or

```java
public interface DriveStrategy {

    void drive();

}
```

---

## 2. Concrete Strategies

Different implementations of the Strategy interface.

Examples:

```
CreditCardPayment

PayPalPayment

UPIPayment
```

or

```
NormalDrive

SportsDrive

EVDrive
```

Each strategy contains one specific algorithm.

---

## 3. Context

Uses a Strategy object.

Example:

```
ShoppingCart
```

or

```
Vehicle
```

The Context delegates work to the selected Strategy instead of implementing the logic itself.

---

## 4. Client

Chooses which strategy should be used at runtime.

---

# Structure

```
            Client
               |
               ▼
            Context
               |
         HAS-A Strategy
               |
      ---------------------
      |         |         |
      ▼         ▼         ▼
 StrategyA StrategyB StrategyC
```

The Client decides which Strategy to use.

The Context simply delegates the work.

---

# How It Works

1. Client creates a Context.
2. Client selects a Strategy.
3. Context stores the Strategy.
4. Client calls Context.
5. Context delegates the request to the selected Strategy.

No conditional statements are required.

---

# Example 1: Vehicle Drive Modes

Vehicle types:

- Passenger Vehicle
- Sports Vehicle
- Goods Vehicle
- Hybrid Vehicle

Different drive modes:

- Normal Drive
- Sports Drive
- EV Drive

Instead of overriding `drive()` in every subclass, each drive mode becomes a separate strategy.

```
Vehicle

↓

DriveStrategy

↓

NormalDrive

SportsDrive

EVDrive
```

Different vehicles simply choose the appropriate strategy. :contentReference[oaicite:3]{index=3}

---

# Example 2: Shopping Cart Payment

Payment methods:

- Credit Card
- PayPal
- UPI

Instead of using a large `switch` statement:

```
ShoppingCart

↓

PaymentStrategy

↓

CreditCardPayment

PayPalPayment

UPIPayment
```

New payment methods can be added without changing the Shopping Cart class. :contentReference[oaicite:4]{index=4}

---

# Relationships

## IS-A Relationship

```
CreditCardPayment

IS-A

PaymentStrategy
```

```
PayPalPayment

IS-A

PaymentStrategy
```

```
SportsDrive

IS-A

DriveStrategy
```

---

## HAS-A Relationship

```
ShoppingCart

HAS-A

PaymentStrategy
```

```
Vehicle

HAS-A

DriveStrategy
```

The Context contains a reference to the Strategy.

---

# Advantages

- Eliminates large `if-else` and `switch` statements.
- Follows Open/Closed Principle.
- Follows Single Responsibility Principle.
- Easy to add new algorithms.
- Promotes Loose Coupling.
- Algorithms can be changed at runtime.
- Improves code reusability.
- Easier to test individual algorithms.

---

# Disadvantages

- More classes.
- Client must know which strategy to choose.
- Slight increase in complexity for simple applications.

---

# When Should We Use It?

Use Strategy Pattern when:

- Multiple ways exist to perform the same task.
- Algorithms need to change at runtime.
- Large conditional statements exist.
- New algorithms are added frequently.
- Different business rules apply in different situations.

---

# Strategy vs State

| Strategy | State |
|----------|-------|
| Client chooses the algorithm | Object changes behavior based on its internal state |
| Focuses on selecting an algorithm | Focuses on changing behavior automatically |
| Behavior selected externally | Behavior changes internally |

---

# Strategy vs Template Method

| Strategy | Template Method |
|----------|-----------------|
| Uses Composition | Uses Inheritance |
| Algorithm can change at runtime | Algorithm fixed at compile time |
| Flexible | Less flexible |

---

# Strategy vs Factory

| Strategy | Factory |
|----------|---------|
| Selects an algorithm | Creates an object |
| Behavioral Pattern | Creational Pattern |
| Focuses on behavior | Focuses on object creation |

---

# Interview Questions

## Why do we need Strategy Pattern?

To encapsulate multiple algorithms and select one dynamically without modifying existing code.

---

## Which SOLID Principle does Strategy support?

- **Open/Closed Principle (OCP)** → Add new strategies without modifying existing code.
- **Single Responsibility Principle (SRP)** → Each strategy has only one responsibility.

---

## Why is Strategy better than using `if-else`?

Because each algorithm is placed in its own class, making the code easier to maintain, test, and extend.

---

## Which relationship is used?

**HAS-A (Composition)**

The Context contains a Strategy object.

---

## Can Strategy be changed at runtime?

**Yes.**

This is the biggest advantage of the Strategy Pattern.

---

# Real-World Examples

- Google Maps Route Selection
- Payment Gateways
- Vehicle Drive Modes
- Shipping Cost Calculation
- Compression Algorithms
- Sorting Algorithms
- Authentication Providers
- Recommendation Engines

---

# Key Points

- Behavioral Design Pattern
- Encapsulates algorithms
- Eliminates `if-else` and `switch`
- Uses Composition
- Algorithms interchangeable at runtime
- Supports Open/Closed Principle
- Promotes Loose Coupling

---

# Revision

- Behavioral Pattern
- Family of algorithms
- Strategy Interface
- Context uses Strategy
- Client selects strategy
- Runtime behavior change
- Composition over Inheritance
- Eliminates conditional logic

---

# One-Line Revision

> **Strategy Pattern encapsulates multiple algorithms into separate classes and allows the client to choose the required algorithm dynamically at runtime.**
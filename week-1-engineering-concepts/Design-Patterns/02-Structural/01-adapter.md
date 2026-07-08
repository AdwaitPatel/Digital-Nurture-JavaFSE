# Adapter Design Pattern

## Definition

The **Adapter Design Pattern** is a **Structural Design Pattern** that acts as a **bridge between two incompatible interfaces**, allowing them to work together.

It converts the interface of an existing class (Adaptee) into another interface (Target) that the client expects.

> **In simple words:** Adapter translates one interface into another so that incompatible classes can communicate.

---

# Why do we need Adapter Pattern?

Imagine you're integrating an old library into a new application.

Your application expects data in one format, but the library provides data in another format.

Without Adapter:

- Client code needs conversion logic everywhere.
- Tight coupling with legacy code.
- Difficult to maintain.

Adapter encapsulates the conversion logic into a single class.

---

# Real-World Analogies

## 1. Plug, Socket & Power Adapter

Suppose you have:

- 2-pin charger
- 3-pin socket

The charger cannot directly connect to the socket.

A **Power Adapter** converts the 2-pin plug into a compatible 3-pin plug.

```
2-Pin Plug
      |
      ▼
Power Adapter
      |
      ▼
3-Pin Socket
```

The adapter makes two incompatible interfaces compatible.

---

## 2. Weighing Scale

Suppose:

Existing weighing machine gives weight in **Pounds**.

Your application expects **Kilograms**.

Instead of modifying the weighing machine, create an Adapter.

```
Pounds
   |
   ▼
Weight Adapter
   |
   ▼
Kilograms
```

---

## 3. XML to JSON Parser

Old System:

```
XML
```

New Application:

```
JSON
```

Adapter converts

```
XML
    ↓
Adapter
    ↓
JSON
```

---

# Structure of Adapter Pattern

The Adapter Pattern consists of four main components.

---

## 1. Target (Adapter Interface)

The interface that the **client expects**.

Example:

```java
public interface WeighingMachineAdapter {

    double getWeightInKg();

}
```

The client only knows this interface.

---

## 2. Adaptee

An existing class with an incompatible interface.

Example:

```java
public interface ImperialWeighingMachine {

    double getWeightInPounds();

}
```

This class already exists.

We don't want to modify it.

---

## 3. Concrete Adapter

Implements the Target interface.

Internally uses the Adaptee.

Responsible for conversion.

Example:

```
Pounds
   ↓
Adapter
   ↓
Kilograms
```

---

## 4. Client

Uses only the Target interface.

The client never knows that conversion is happening internally.

---

# Class Relationship

```
                Client
                   |
                   ▼
        WeighingMachineAdapter
                   ▲
                   |
     WeightMachineAdapterImpl
                   |
                has-a
                   |
                   ▼
     ImperialWeighingMachineImpl
```

Notice:

The Adapter **has** an Adaptee object.

This is **Composition**, not Inheritance.

---

# Implementation

## Step 1 : Adaptee

```java
public interface ImperialWeighingMachine {

    double getWeightInPounds();

}
```

---

## Step 2 : Existing Implementation

```java
public class ImperialWeighingMachineImpl
        implements ImperialWeighingMachine {

    private double weightInPounds;

    public ImperialWeighingMachineImpl(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    @Override
    public double getWeightInPounds() {
        return weightInPounds;
    }
}
```

This is the legacy class.

It only returns weight in Pounds.

---

## Step 3 : Target Interface

```java
public interface WeighingMachineAdapter {

    double getWeightInKg();

}
```

This is the interface expected by the client.

---

## Step 4 : Adapter

```java
public class WeightMachineAdapterImpl
        implements WeighingMachineAdapter {

    private ImperialWeighingMachine machine;

    public WeightMachineAdapterImpl(
            ImperialWeighingMachine machine) {

        this.machine = machine;

    }

    @Override
    public double getWeightInKg() {

        double pounds = machine.getWeightInPounds();

        return pounds * 0.453592;

    }
}
```

Notice:

The Adapter performs only one task:

**Converts Pounds into Kilograms.**

---

## Step 5 : Client

```java
public class MetricWeighingMachine {

    public static void main(String[] args) {

        ImperialWeighingMachine machine =
                new ImperialWeighingMachineImpl(25);

        WeighingMachineAdapter adapter =
                new WeightMachineAdapterImpl(machine);

        System.out.println(
                "Weight in KG : " +
                adapter.getWeightInKg()
        );

    }

}
```

Output

```
Weight in KG : 11.3398
```

---

# How Adapter Works

Step 1

Client asks for

```
Weight in KG
```

↓

Step 2

Adapter receives request.

↓

Step 3

Adapter calls

```
getWeightInPounds()
```

↓

Step 4

Adapter converts

```
Pounds → Kilograms
```

↓

Step 5

Returns result to Client.

The Client never knows that the original machine worked in Pounds.

---

# Advantages

- Reuses existing code.
- No modification to legacy classes.
- Follows Open/Closed Principle.
- Promotes loose coupling.
- Improves code reusability.
- Easy integration with third-party libraries.

---

# Disadvantages

- Adds one extra layer.
- Slightly increases complexity.
- Too many adapters may make the design difficult to understand.

---

# When Should We Use Adapter Pattern?

Use Adapter when:

- Working with legacy systems.
- Integrating third-party libraries.
- Two incompatible interfaces need to communicate.
- Existing code cannot be modified.
- Data format conversion is required.

---

# Adapter vs Decorator

| Adapter | Decorator |
|----------|-----------|
| Converts one interface into another | Adds new behavior to an object |
| Makes incompatible classes work together | Enhances existing functionality |
| Structural Pattern | Structural Pattern |
| Focuses on compatibility | Focuses on extending behavior |

---

# Adapter vs Facade

| Adapter | Facade |
|----------|---------|
| Makes incompatible interfaces compatible | Simplifies a complex subsystem |
| Converts interface | Provides simplified interface |
| Used for integration | Used for abstraction |

---

# Interview Questions

## Why do we need Adapter Pattern?

To make two incompatible interfaces work together without modifying existing code.

---

## Which SOLID principle does Adapter follow?

**Open/Closed Principle (OCP)**

Existing classes remain unchanged.

Only an Adapter is added.

---

## Does Adapter modify the existing class?

No.

It wraps the existing class and translates requests.

---

## Is Adapter based on Composition or Inheritance?

Mostly **Composition**.

The Adapter contains an object of the Adaptee.

---

## Where is Adapter commonly used?

- Payment Gateway Integration
- Legacy System Integration
- XML → JSON Conversion
- Database Driver Wrappers
- Spring Framework
- JDBC Drivers

---

# Key Points

- Target → Interface expected by Client
- Adaptee → Existing incompatible class
- Adapter → Converts one interface into another
- Client → Uses only Target interface

---

# One-Line Revision

> **Adapter Pattern converts one interface into another so that incompatible classes can work together without modifying existing code.**
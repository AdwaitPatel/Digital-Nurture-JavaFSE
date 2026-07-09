# Observer Design Pattern

## Definition

The **Observer Design Pattern** is a **Behavioral Design Pattern** in which an object (called the **Subject**, **Observable**, or **Publisher**) maintains a list of dependent objects (**Observers**) and automatically **notifies** them whenever its state changes.

Observers can also be **added or removed dynamically at runtime**.

> **One-Line Definition:** Observer Pattern establishes a **One-to-Many dependency** so that when one object changes its state, all dependent objects are automatically notified.

---

# Why do we need Observer Pattern?

Consider an E-commerce application.

Whenever an iPhone comes back in stock:

- John should receive a Push Notification.
- Jane should receive an Email.
- George should receive an Email.
- Katy should receive a Push Notification.

Without the Observer Pattern, the product class would directly call every notification service.

Problems:

- Tight Coupling
- Difficult to add new notification types
- Violates Open/Closed Principle
- Hard to maintain

Observer Pattern solves this by allowing users to **subscribe** and **unsubscribe** dynamically. :contentReference[oaicite:1]{index=1}

---

# Real-World Examples

- Weather Station
- YouTube Subscription
- Instagram/Facebook Followers
- Stock Market Updates
- E-commerce "Notify Me"
- Cricket Live Score Updates
- Event Notification Systems :contentReference[oaicite:2]{index=2}

---

# Components

## 1. Observable (Subject)

Maintains a list of observers.

Responsibilities:

- Add Observer
- Remove Observer
- Notify Observers
- Maintain State

Example:

```java
public interface WeatherObservable {

    void addObserver(WeatherObserver observer);

    void removeObserver(WeatherObserver observer);

    void notifyObservers();

}
```

---

## 2. Concrete Observable

Implements the Observable.

Example:

```java
WeatherStation
```

or

```java
IphoneProductObservable
```

Responsibilities:

- Stores actual data/state
- Notifies observers when state changes

---

## 3. Observer Interface

Implemented by all observers.

Example:

```java
public interface WeatherObserver {

    void update();

}
```

---

## 4. Concrete Observer

Receives updates from Observable.

Examples:

- CurrentConditionsDisplay
- ForecastDisplay
- EmailNotificationObserver
- PushNotificationObserver

Each observer reacts differently to the same event.

---

## 5. Client

Creates Observable and Observers.

Registers observers with the Observable.

---

# Structure

```
             Client
                |
                ▼
        Observable (Subject)
                |
      -----------------------
      |         |          |
      ▼         ▼          ▼
 Observer1  Observer2  Observer3
```

Whenever the Subject changes,

↓

All registered observers are notified.

---

# How It Works

1. Client creates Observable.
2. Client registers Observers.
3. Observable state changes.
4. Observable calls `notifyObservers()`.
5. Every Observer executes its `update()` method.
6. Each Observer performs its own action.

---

# Weather Station Example

### Observable

```
WeatherStation
```

Stores:

- Temperature
- Humidity
- Pressure

Whenever weather changes,

```
notifyObservers()
```

is called.

Observers:

- CurrentConditionsDisplay
- ForecastDisplay

Both receive updates automatically. :contentReference[oaicite:3]{index=3}

---

# E-Commerce "Notify Me" Example

Suppose:

```
iPhone 15
```

goes out of stock.

Users subscribe.

```
John
Jane
George
Katy
```

↓

Stock arrives.

↓

Observable calls

```
notifyObservers()
```

↓

Every user receives a notification.

Notification types can differ:

- Email
- Push Notification

without changing the Product class. :contentReference[oaicite:4]{index=4}

---

# Relationships

## IS-A

```
WeatherStation

IS-A

WeatherObservable
```

```
CurrentConditionsDisplay

IS-A

WeatherObserver
```

---

## HAS-A

```
WeatherStation

HAS-A

List<WeatherObserver>
```

The Subject maintains a collection of observers.

---

# Advantages

- Loose Coupling
- Supports Open/Closed Principle
- Easy to add new observers
- Dynamic subscription/unsubscription
- One-to-Many communication
- Easy maintenance
- Highly scalable

---

# Disadvantages

- Notification order is not guaranteed.
- Too many observers can impact performance.
- Debugging becomes difficult with many observers.
- Circular updates can occur if not handled carefully.

---

# When Should We Use It?

Use Observer Pattern when:

- Multiple objects depend on one object.
- State changes should automatically notify others.
- Subscribers may join or leave dynamically.
- Event-driven systems.
- Notification systems.
- Real-time dashboards.
- Chat applications.
- Stock market applications.

---

# Observer vs Strategy

| Observer | Strategy |
|----------|----------|
| Behavioral Pattern | Behavioral Pattern |
| Communication between objects | Selects an algorithm |
| One-to-Many relationship | One-to-One relationship |
| Event-driven | Algorithm-driven |

---

# Observer vs Pub-Sub

| Observer | Pub-Sub |
|----------|---------|
| Direct communication | Uses Message Broker |
| Subject knows observers | Publisher doesn't know subscribers |
| Same process | Can be distributed |

---

# Advantages over Polling

Polling:

```
Client

↓

Keeps asking

"Has anything changed?"
```

Observer:

```
Subject

↓

Automatically notifies
```

Observer is much more efficient.

---

# Interview Questions

## Why do we need Observer Pattern?

To automatically notify dependent objects whenever the Subject changes.

---

## Which SOLID Principle does it support?

**Open/Closed Principle (OCP)**

New observers can be added without modifying existing code.

---

## What relationship does Observer implement?

**One-to-Many**

One Subject

↓

Many Observers

---

## Difference between Push and Pull Model?

### Push Model

Observable sends complete data.

```text
Subject -----> Observer(data)
```

### Pull Model

Observable only sends notification.

Observer fetches required data.

```text
Subject -----> Observer

Observer -----> Subject
```

---

## Real-world Examples

- YouTube Subscription
- Instagram Notifications
- WhatsApp Status Updates
- Weather Applications
- Stock Market
- E-commerce Notify Me
- Live Cricket Score

---

# Key Points

- Behavioral Design Pattern
- One-to-Many Relationship
- Subject maintains list of observers
- Supports Dynamic Registration
- Automatic Notifications
- Loose Coupling
- Event Driven
- Supports Open/Closed Principle

---

# Revision

- Behavioral Pattern
- Subject → Maintains observers
- Observer → Receives updates
- One-to-Many relationship
- Dynamic subscribe/unsubscribe
- Automatic notifications
- Loose coupling
- Event-driven architecture

---

# One-Line Revision

> **Observer Pattern defines a One-to-Many dependency where a Subject automatically notifies all registered Observers whenever its state changes.**
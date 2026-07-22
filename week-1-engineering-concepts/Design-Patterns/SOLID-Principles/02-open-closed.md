# Open/Closed Principle

**Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.**

This means you should be able to **add new functionality without changing existing code**.


## Why do we need this?

Imagine you have a payment system.

Initially, your application supports:
- UPI
- Credit Card

After a few months, your client asks to add:
- Net Banking
- PayPal
- Crypto Payment

If you keep modifying the existing payment class every time a new payment method is added, you increase the risk of introducing bugs into code that already works.

OCP solves this problem by allowing new functionality to be added without changing existing code.

Benefits:
- Existing code remains stable.
- Easier to add new features.
- Lower risk of introducing bugs.
- Easier maintenance.
- Better scalability.

---

## Bad Example

```java
class PaymentService {

    public void pay(String paymentType) {

        if(paymentType.equals("UPI")) {
            System.out.println("Processing UPI Payment");
        }
        else if(paymentType.equals("CARD")) {
            System.out.println("Processing Card Payment");
        }
        else if(paymentType.equals("NETBANKING")) {
            System.out.println("Processing Net Banking Payment");
        }
    }
}
```

### Problems

Every time a new payment method is introduced, this class must be modified.

For example:

- Add PayPal
- Add Crypto
- Add Apple Pay
- Add Google Pay

Every new feature requires changing existing code, which violates the Open/Closed Principle.

---

## Good Example

### Step 1: Create an interface

```java
interface Payment {

    void pay();
}
```

---

### Step 2: Implement different payment methods

```java
class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Processing UPI Payment");
    }
}
```

```java
class CardPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Processing Card Payment");
    }
}
```

---

### Step 3: Create PaymentService

```java
class PaymentService {

    public void processPayment(Payment payment) {
        payment.pay();
    }
}
```

---

### Step 4: Add a new payment method

```java
class PaypalPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Processing PayPal Payment");
    }
}
```

Notice that **PaymentService never changes.**

We simply create a new implementation.

This follows the Open/Closed Principle.

---

## Advantages

- Easy to extend functionality.
- Existing code remains unchanged.
- Reduces chances of introducing bugs.
- Improves maintainability.
- Makes the application scalable.

---

## Common Interview Questions

### Q1. What is the main goal of the Open/Closed Principle?

To allow software to grow by adding new functionality without modifying existing code.

### Q2. Which Java feature is commonly used to implement OCP?

- Interfaces
- Inheritance
- Polymorphism

## Revision

**Open for Extension → Add new functionality**  
**Closed for Modification → Do not change existing, tested code**
# Proxy Design Pattern

## Definition

The **Proxy Design Pattern** is a **Structural Design Pattern** that provides a **representative (Proxy) or placeholder** for another object (Real Subject) to **control access** to it.

Instead of interacting directly with the real object, the client communicates with the Proxy, which decides whether the request should be forwarded.

> **One-Line Definition:** A Proxy controls access to another object while providing the same interface as the original object.

---

# Why do we need the Proxy Pattern?

Sometimes accessing an object directly is not desirable because:

- The object is expensive to create.
- Access should be restricted.
- Extra processing is required before/after execution.
- Results should be cached.
- Logging or monitoring is needed.

Instead of modifying the original class, we introduce a **Proxy**.

---

# Real-World Analogies

## 1. Security Guard

Imagine entering a company's office.

```
Visitor
    |
Security Guard
    |
Office
```

The Security Guard verifies your identity before allowing access.

The guard is the **Proxy**.

---

## 2. ATM Machine

```
Customer
     |
ATM Machine
     |
Bank Server
```

The ATM performs authentication before contacting the bank.

The ATM acts as a Proxy.

---

## 3. Web Proxy Server

```
Client
    |
Proxy Server
    |
Internet
```

The proxy may:

- Cache pages
- Block websites
- Monitor traffic
- Authenticate users

---

# Common Use Cases

## 1. Access Control

Restrict operations based on user permissions.

Example:

- ADMIN can create employees.
- USER can only view employees.

---

## 2. Lazy Loading

Delay expensive object creation until actually required.

Example:

- Loading large images
- Database connections
- Video streaming

---

## 3. Logging & Monitoring

Perform operations before and after the actual request.

Examples:

- Logging
- Audit Trails
- Performance Monitoring

---

## 4. Caching

Cache previously computed results.

Example:

```
Client
    |
Proxy
(Cache)
    |
Database
```

If data exists in cache, database isn't called.

---

# Structure of Proxy Pattern

The Proxy Pattern consists of four main components.

---

## 1. Subject Interface

Defines the common interface implemented by both the Proxy and the Real Subject.

```java
public interface EmployeeDao {

    void getEmployeeInfo(int empId);

    void createEmployee(EmployeeDo obj);

}
```

---

## 2. Real Subject

Contains the actual business logic.

```java
public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void getEmployeeInfo(int empId) {
        System.out.println("Fetching Employee : " + empId);
    }

    @Override
    public void createEmployee(EmployeeDo obj) {
        System.out.println("Creating Employee");
    }

}
```

The client should not directly interact with this class.

---

## 3. Proxy

The Proxy controls access to the Real Subject.

```java
public class EmployeeDaoProxy
        implements EmployeeDao {

    private EmployeeDao employeeDao;

    private String clientRole;

    public EmployeeDaoProxy(String clientRole) {

        employeeDao = new EmployeeDaoImpl();
        this.clientRole = clientRole;

    }

    @Override
    public void getEmployeeInfo(int empId) {

        if(clientRole.equals("ADMIN")
                || clientRole.equals("USER")) {

            employeeDao.getEmployeeInfo(empId);

        }
        else{

            throw new RuntimeException(
                    "Access Denied"
            );

        }

    }

    @Override
    public void createEmployee(EmployeeDo obj) {

        if(clientRole.equals("ADMIN")) {

            employeeDao.createEmployee(obj);

        }
        else{

            throw new RuntimeException(
                    "Access Denied"
            );

        }

    }

}
```

Notice:

The Proxy decides whether the request should reach the real object.

---

## 4. Client

```java
public class EmployeeManagement {

    public static void main(String[] args) {

        EmployeeDao dao =
                new EmployeeDaoProxy("USER");

        dao.getEmployeeInfo(101);

        dao.createEmployee(new EmployeeDo());

    }

}
```

Output

```
Fetching Employee : 101

Exception:
Access Denied
```

---

# How Proxy Works

```
Client
   │
   ▼
EmployeeDaoProxy
   │
Permission Check
   │
   ▼
EmployeeDaoImpl
```

The client never directly accesses the real object.

---

# Components

## Subject

Common interface.

Example:

```java
EmployeeDao
```

---

## Real Subject

Actual implementation.

Example:

```java
EmployeeDaoImpl
```

---

## Proxy

Controls access.

Example:

```java
EmployeeDaoProxy
```

---

## Client

Uses only the Subject interface.

---

# Relationships

## IS-A Relationship

```
EmployeeDaoProxy
        is-a
EmployeeDao
```

```
EmployeeDaoImpl
        is-a
EmployeeDao
```

Both implement the same interface.

---

## HAS-A Relationship

```
EmployeeDaoProxy

      HAS-A

EmployeeDaoImpl
```

The Proxy internally contains a reference to the Real Subject.

This is **Composition**.

---

# Types of Proxy

## 1. Virtual Proxy

Creates expensive objects only when needed.

Example:

- Image loading
- Video streaming

---

## 2. Protection Proxy

Controls access based on permissions.

Example:

- Role-based Authentication

---

## 3. Remote Proxy

Represents an object located on another machine.

Example:

- RMI
- RPC
- Web Services

---

## 4. Caching Proxy

Stores previous results.

Example:

- Redis Cache
- Browser Cache

---

## 5. Smart Proxy

Adds additional behavior.

Examples:

- Logging
- Monitoring
- Reference Counting

---

# Advantages

- Controls access.
- Improves security.
- Supports lazy loading.
- Supports caching.
- Adds logging without modifying business logic.
- Follows Open/Closed Principle.

---

# Disadvantages

- Adds one extra layer.
- Slightly increases complexity.
- Can introduce small performance overhead.

---

# When Should We Use Proxy?

Use Proxy when:

- Access needs to be restricted.
- Expensive objects should be lazily initialized.
- Logging is required.
- Monitoring is required.
- Caching is required.
- Working with remote objects.

---

# Proxy vs Decorator

| Proxy | Decorator |
|--------|-----------|
| Controls access | Adds behavior |
| Focuses on security/performance | Focuses on extending functionality |
| Client often doesn't know proxy exists | Client intentionally decorates object |
| Structural Pattern | Structural Pattern |

---

# Proxy vs Adapter

| Proxy | Adapter |
|--------|----------|
| Controls access | Converts interface |
| Same interface | Different interface |
| Security/Lazy Loading | Compatibility |

---

# Interview Questions

## Why do we need Proxy Pattern?

To control access to an object without modifying the original class.

---

## Which SOLID Principle does Proxy support?

**Open/Closed Principle (OCP)**

Behavior is extended without changing existing classes.

---

## Which relationship is used?

**HAS-A (Composition)**

Proxy contains the Real Subject.

---

## Difference between Proxy and Decorator?

Decorator adds functionality.

Proxy controls access.

---

## Difference between Proxy and Facade?

Facade simplifies a subsystem.

Proxy controls access to one object.

---

# Real-World Examples

- ATM Machines
- Security Guards
- Spring Security
- Hibernate Lazy Loading
- Redis Cache
- Browser Cache
- API Gateway
- Reverse Proxy (NGINX)

---

# Key Points

- Subject → Common Interface
- Real Subject → Actual Business Logic
- Proxy → Controls Access
- Client → Uses Subject Interface
- Uses Composition
- Supports Lazy Loading
- Supports Security
- Supports Logging
- Supports Caching

---

# 30-Second Revision

- Structural Pattern
- Controls access to another object
- Same interface as Real Subject
- Uses Composition
- Supports Lazy Loading
- Supports Access Control
- Supports Caching
- Supports Logging
- Client is unaware of the Real Subject

---

# One-Line Revision

> **Proxy Pattern provides a placeholder for another object to control access, improve security, optimize performance, and add additional behavior without modifying the original object.**
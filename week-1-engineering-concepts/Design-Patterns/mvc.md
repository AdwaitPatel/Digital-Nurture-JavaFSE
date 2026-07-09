# MVC (Model-View-Controller) Design Pattern

## Definition

The **MVC (Model-View-Controller)** Pattern is a **Software Architectural Pattern** that separates an application into **three independent components**:

- **Model** → Manages Data and Business Logic
- **View** → Displays Data (UI)
- **Controller** → Handles User Requests and Coordinates between Model & View

This separation makes applications **cleaner, easier to maintain, scalable, and testable**.

> **One-Line Definition:** MVC separates an application into Model, View, and Controller to achieve better separation of concerns and maintainability.

---

# Why do we need MVC?

Imagine building a Blog Application.

Without MVC:

```
UI

↓

Business Logic

↓

Database

(All mixed together)
```

Problems:

- Huge classes
- Difficult debugging
- Difficult testing
- Poor scalability
- Tight coupling
- Code duplication

MVC separates responsibilities into different layers.

---

# Real-World Examples

- Spring MVC
- Spring Boot
- Ruby on Rails
- Django (uses MVT, a variation of MVC)
- ASP.NET MVC
- Laravel

---

# MVC Architecture

```
          User
            │
            ▼
         View (UI)
            │
            ▼
      Controller
            │
            ▼
         Model
            │
            ▼
        Database
```

The Controller acts as the bridge between the View and the Model.

---

# Components

## 1. Model

The **Model** represents the application's data and business logic.

Responsibilities:

- Stores data
- Database operations
- Business rules
- Data validation
- CRUD operations

Example:

```java
Blog
```

Fields:

```
title
content
author
createdAt
```

The Model **does not know anything about the UI.**

---

## 2. View

The **View** represents the user interface.

Responsibilities:

- Displays data
- Takes user input
- Shows success/error messages
- No business logic

Example:

```java
BlogView
```

Methods:

```
displayBlog()

displayAllBlogs()
```

The View only presents information.

---

## 3. Controller

The **Controller** acts as the bridge between the Model and the View.

Responsibilities:

- Receives user requests
- Calls Model methods
- Updates Model
- Sends data to View
- Controls application flow

Example:

```java
BlogController
```

Methods:

```
addBlog()

updateBlog()

deleteBlog()

showBlog()

showAllBlogs()
```

---

# Structure

```
          User
            │
            ▼
          View
            │
            ▼
      Controller
            │
            ▼
          Model
            │
            ▼
        Database
```

Each component has a separate responsibility.

---

# How MVC Works

### Step 1

User interacts with the View.

Example:

```
Click "Add Blog"
```

↓

### Step 2

View sends the request to the Controller.

↓

### Step 3

Controller processes the request.

↓

### Step 4

Controller updates the Model.

↓

### Step 5

Model stores or retrieves data.

↓

### Step 6

Controller sends updated data to the View.

↓

### Step 7

View refreshes the UI.

This flow keeps the application loosely coupled. :contentReference[oaicite:1]{index=1}

---

# Blog Application Example

### Model

```
Blog
```

Stores:

- Title
- Content
- Author
- Created Date

---

### View

```
BlogView
```

Displays:

- Blog Details
- List of Blogs

---

### Controller

```
BlogController
```

Handles:

- Add Blog
- Update Blog
- Delete Blog
- Display Blog
- Display All Blogs

The Controller communicates with both the Model and the View. :contentReference[oaicite:2]{index=2}

---

# Relationships

## HAS-A Relationship

```
BlogController

HAS-A

BlogView
```

```
BlogController

HAS-A

List<Blog>
```

The Controller maintains references to the View and the Model.

---

# Advantages

- Clear Separation of Concerns.
- Easy to maintain.
- Easy to test.
- Supports parallel development (Model, View, and Controller can be developed independently).
- High reusability.
- Easy to scale.
- Multiple Views can use the same Model.
- Easy to replace UI or database independently.

---

# Disadvantages

- More files and classes.
- Can be overkill for small projects.
- Slight performance overhead due to multiple layers.
- Controller may become large if not designed properly.
- Higher maintenance cost for simple applications.

---

# When Should We Use MVC?

Use MVC when:

- Building Web Applications.
- Building Desktop Applications.
- Developing Large Projects.
- Multiple developers are working simultaneously.
- UI and Business Logic should remain independent.
- Scalability and maintainability are important.

---

# MVC vs Layered Architecture

| MVC | Layered Architecture |
|------|----------------------|
| Focuses on UI separation | Focuses on application layers |
| Model, View, Controller | Controller, Service, Repository, DAO |
| Common in web frameworks | Common in enterprise applications |

---

# MVC vs MVP

| MVC | MVP |
|------|-----|
| Controller handles user input | Presenter handles user input |
| View communicates with Controller | View communicates with Presenter |
| More common in web applications | More common in Android (older architecture) |

---

# MVC vs MVVM

| MVC | MVVM |
|------|------|
| Uses Controller | Uses ViewModel |
| View interacts with Controller | View binds directly to ViewModel |
| Less data binding | Supports automatic data binding |

---

# Interview Questions

## What does MVC stand for?

- **Model**
- **View**
- **Controller**

---

## What is the responsibility of the Model?

- Stores data
- Business logic
- Validation
- Database operations

---

## What is the responsibility of the View?

Displays data to the user.

It should **not contain business logic.**

---

## What is the responsibility of the Controller?

Acts as a bridge between the Model and the View.

Processes requests and controls application flow.

---

## Can one Model have multiple Views?

**Yes.**

Example:

The same data can be displayed as:

- Table
- Graph
- Chart
- Mobile UI
- Web UI

---

## Does the View communicate directly with the Database?

**No.**

Communication always goes through the Controller and Model.

---

## Which SOLID Principle does MVC support?

- **Single Responsibility Principle (SRP)** → Each component has one responsibility.
- **Separation of Concerns (SoC)** → Different responsibilities are isolated into separate layers.

---

# Real-World Examples

- Spring MVC
- Spring Boot
- Django (MVT)
- Ruby on Rails
- ASP.NET MVC
- Laravel
- Java Swing Applications

---

# Key Points

- Software Architectural Pattern
- Three Components:
  - Model
  - View
  - Controller
- Separation of Concerns
- Easier Testing
- Easier Maintenance
- Scalable
- Reusable
- Controller acts as the bridge

---

# Revision

- Architectural Pattern
- Model = Data & Business Logic
- View = User Interface
- Controller = Bridge between Model & View
- Improves Maintainability
- Supports Reusability
- Easy Testing
- Easy Scaling
- Used in Spring MVC & Spring Boot

---

# One-Line Revision

> **MVC is an architectural pattern that separates an application into Model, View, and Controller, enabling clean code, scalability, maintainability, and separation of concerns.**
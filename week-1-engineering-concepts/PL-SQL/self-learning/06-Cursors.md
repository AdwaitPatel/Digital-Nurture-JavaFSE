# Cursors

## What is a Cursor?

A cursor is a pointer to the result set of an SQL query.

It allows PL/SQL to process query results **one row at a time**.

### Why do we need Cursors?

SQL normally works with complete result sets.

PL/SQL often needs to process each row individually, for example:

* Calculate salary for every employee.
* Apply discounts to customers.
* Generate monthly statements.
* Send reminder messages.

Cursors make row-by-row processing possible.

---

# Types of Cursors

## 1. Implicit Cursor

* Created automatically by Oracle.
* Used for DML statements:
  * INSERT
  * UPDATE
  * DELETE
  * MERGE
* Also used when a `SELECT INTO` statement returns exactly one row.

Example:

```sql
UPDATE Employees
SET Salary = Salary + 1000
WHERE EmployeeID = 1;
```

Oracle automatically creates and manages the cursor.

---

## 2. Explicit Cursor

* Created by the programmer.
* Used when a query returns multiple rows.
* Gives full control over processing.

Syntax:

```sql
DECLARE
    CURSOR cursor_name IS
        SELECT ...
BEGIN
    ...
END;
/
```

---

# Working with Explicit Cursors

An explicit cursor has four steps.

## Step 1: Declare Cursor

```sql
CURSOR c_emp IS
SELECT *
FROM Employees;
```

---

## Step 2: Open Cursor

```sql
OPEN c_emp;
```

Executes the query and prepares the result set.

---

## Step 3: Fetch Rows

```sql
FETCH c_emp INTO emp_record;
```

Retrieves one row at a time.

---

## Step 4: Close Cursor

```sql
CLOSE c_emp;
```

Releases the resources.

---

# Cursor Attributes

| Attribute   | Description                       |
| ----------- | --------------------------------- |
| `%FOUND`    | TRUE if last fetch returned a row |
| `%NOTFOUND` | TRUE if no row was found          |
| `%ROWCOUNT` | Number of rows fetched            |
| `%ISOPEN`   | TRUE if cursor is open            |

Example:

```sql
EXIT WHEN c_emp%NOTFOUND;
```

---

# Cursor FOR LOOP

The easiest way to process multiple rows.

Oracle automatically:

* Opens the cursor
* Fetches each row
* Closes the cursor

Example:

```sql
BEGIN
    FOR emp IN (
        SELECT *
        FROM Employees
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(emp.Name);
    END LOOP;
END;
/
```

No need to write:

* OPEN
* FETCH
* CLOSE

---

# Explicit Cursor Example

```sql
DECLARE
    CURSOR c_emp IS
        SELECT Name
        FROM Employees;

    emp_name Employees.Name%TYPE;

BEGIN
    OPEN c_emp;

    LOOP
        FETCH c_emp INTO emp_name;

        EXIT WHEN c_emp%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(emp_name);

    END LOOP;

    CLOSE c_emp;
END;
/
```

---

# Cursor FOR LOOP vs Explicit Cursor

| Cursor FOR LOOP             | Explicit Cursor                   |
| --------------------------- | --------------------------------- |
| Simple                      | More control                      |
| OPEN handled automatically  | OPEN manually                     |
| FETCH handled automatically | FETCH manually                    |
| CLOSE handled automatically | CLOSE manually                    |
| Recommended for most cases  | Used when extra control is needed |

---

# When to Use Cursors

Use cursors when:

* Processing multiple rows
* Applying row-by-row calculations
* Updating rows individually
* Printing details for each record

Do **not** use cursors for queries returning only one row.

---

# Quick Revision

| Concept         | Purpose                                   |
| --------------- | ----------------------------------------- |
| Cursor          | Processes query results one row at a time |
| Implicit Cursor | Managed automatically by Oracle           |
| Explicit Cursor | Created and managed by programmer         |
| OPEN            | Executes the query                        |
| FETCH           | Retrieves one row                         |
| CLOSE           | Releases cursor resources                 |
| Cursor FOR LOOP | Automatically opens, fetches, and closes  |

---

# Questions

### What is a Cursor?

A pointer to the result set of a SQL query.

### Why are Cursors used?

To process query results one row at a time.

### What are the types of Cursors?

* Implicit Cursor
* Explicit Cursor

### What are the steps of an Explicit Cursor?

1. Declare
2. Open
3. Fetch
4. Close

### Which cursor should beginners prefer?

Cursor FOR LOOP, because Oracle automatically manages the cursor lifecycle.

---

# My Notes

* Cursor = Row-by-row processing.
* Use `SELECT INTO` for a single row.
* Use Cursor FOR LOOP for multiple rows.
* Explicit cursors are useful when you need manual control.
* Oracle automatically handles OPEN, FETCH, and CLOSE in a Cursor FOR LOOP.

# Triggers in PL/SQL

## What is a Trigger?

A **Trigger** is a stored PL/SQL program that executes **automatically** when a specified event occurs.

Triggers are mainly used to:

* Validate data
* Maintain data integrity
* Audit database changes
* Automatically update related data
* Enforce business rules

Unlike procedures and functions, **triggers cannot be called explicitly**.

---

# Events That Fire a Trigger

A trigger can be fired by:

### 1. DML Events

* INSERT
* UPDATE
* DELETE

### 2. DDL Events

* CREATE
* ALTER
* DROP

### 3. Database Events

* LOGON
* LOGOFF
* STARTUP
* SHUTDOWN

---

# Trigger Syntax

```sql
CREATE OR REPLACE TRIGGER trigger_name

BEFORE | AFTER

INSERT OR UPDATE OR DELETE

ON table_name

[FOR EACH ROW]

BEGIN

    -- Trigger body

END;
/
```

---

# Types of Triggers

## 1. BEFORE Trigger

Executes **before** the DML operation.

Used for:

* Validation
* Modifying values before insertion
* Preventing invalid operations

Example:

```sql
CREATE OR REPLACE TRIGGER check_salary
BEFORE INSERT
ON Employees
FOR EACH ROW
BEGIN
    IF :NEW.Salary < 0 THEN
        RAISE_APPLICATION_ERROR(-20001,'Salary cannot be negative');
    END IF;
END;
/
```

---

## 2. AFTER Trigger

Executes **after** the DML operation.

Used for:

* Logging
* Auditing
* Updating related tables
* Sending notifications

Example:

```sql
CREATE OR REPLACE TRIGGER employee_log
AFTER INSERT
ON Employees
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Employee Added');
END;
/
```

---

# Row-Level Trigger

Executes once for **each affected row**.

Uses:

* `:NEW`
* `:OLD`

Example:

```sql
CREATE OR REPLACE TRIGGER update_balance
BEFORE UPDATE
ON Accounts
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(
        'Old Balance: ' || :OLD.Balance
    );

    DBMS_OUTPUT.PUT_LINE(
        'New Balance: ' || :NEW.Balance
    );
END;
/
```

---

# Statement-Level Trigger

Executes **once** for the entire SQL statement.

No `FOR EACH ROW`.

Example:

```sql
CREATE OR REPLACE TRIGGER log_update
AFTER UPDATE
ON Employees
BEGIN
    DBMS_OUTPUT.PUT_LINE('Employees table updated');
END;
/
```

Even if 100 rows are updated:

```sql
UPDATE Employees
SET Salary = Salary + 1000;
```

the trigger executes **only once**.

---

# :OLD and :NEW

Used only in **Row-Level Triggers**.

| Keyword | Meaning             |
| ------- | ------------------- |
| `:OLD`  | Value before change |
| `:NEW`  | Value after change  |

Example:

```sql
:OLD.Salary
:NEW.Salary
```

---

# Trigger Timing

| Trigger       | Executes               |
| ------------- | ---------------------- |
| BEFORE INSERT | Before inserting a row |
| AFTER INSERT  | After inserting a row  |
| BEFORE UPDATE | Before updating a row  |
| AFTER UPDATE  | After updating a row   |
| BEFORE DELETE | Before deleting a row  |
| AFTER DELETE  | After deleting a row   |

---

# Trigger Example

Automatically update the `LastModified` column.

```sql
CREATE OR REPLACE TRIGGER update_last_modified
BEFORE UPDATE
ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/
```

Whenever a customer record is updated, `LastModified` is automatically set to the current date.

---

# Advantages of Triggers

* Automatic execution
* Maintains data integrity
* Enforces business rules
* Reduces duplicate application code
* Useful for auditing

---

# Limitations

* Cannot be called manually.
* Too many triggers can make debugging difficult.
* Excessive trigger logic may reduce performance.
* Hidden logic can make applications harder to understand.

---

# Quick Revision

| Concept                 | Purpose                            |
| ----------------------- | ---------------------------------- |
| Trigger                 | Executes automatically on an event |
| BEFORE                  | Runs before the event              |
| AFTER                   | Runs after the event               |
| Row-Level Trigger       | Executes once per affected row     |
| Statement-Level Trigger | Executes once per SQL statement    |
| `:OLD`                  | Previous value                     |
| `:NEW`                  | Updated value                      |

---

# Questions

### What is a Trigger?

A stored PL/SQL program that executes automatically when a specified database event occurs.

### Difference between BEFORE and AFTER Trigger?

* BEFORE → Executes before the DML operation.
* AFTER → Executes after the DML operation.

### Difference between Row-Level and Statement-Level Trigger?

* Row-Level → Executes once for each affected row.
* Statement-Level → Executes once for the entire SQL statement.

### What are `:OLD` and `:NEW`?

* `:OLD` contains the value before modification.
* `:NEW` contains the value after modification.

### Can a Trigger be called manually?

No. A trigger executes automatically when its associated event occurs.

---

# My Notes

* Trigger = Automatic Procedure.
* Fires on INSERT, UPDATE, DELETE (and other database events).
* BEFORE → Validation.
* AFTER → Logging/Auditing.
* Row-Level Trigger uses `FOR EACH ROW`.
* `:OLD` = Previous value.
* `:NEW` = Updated value.
* Triggers are commonly used for auditing, validation, and maintaining data consistency.

# Introduction to PL/SQL

## What is PL/SQL?

PL/SQL (Procedural Language/SQL) is Oracle's extension of SQL that adds programming features such as:

* Variables
* Conditions (IF-ELSE)
* Loops
* Procedures
* Functions
* Exception Handling
* Cursors
* Triggers

SQL tells the database **what** to do, while PL/SQL allows us to define **how** to do it.

---

## Why PL/SQL?

SQL alone cannot perform complex business logic.

PL/SQL helps by providing:
* Better performance (multiple SQL statements executed as one block)
* Error handling using exceptions
* Reusable code through procedures and functions
* Modular programming
* Improved security

---

## Features of PL/SQL

* Block-structured language
* Supports variables and constants
* Supports loops and conditional statements
* Supports exception handling
* Allows creation of procedures, functions, packages, and triggers
* Tight integration with SQL

---

## Structure of a PL/SQL Block

```sql
DECLARE
    -- Variable declarations
BEGIN
    -- Executable statements
EXCEPTION
    -- Error handling code
END;
/
```

### Sections

1. DECLARE (Optional)
   * Variables, constants, cursors

2. BEGIN (Mandatory)
   * Main executable code

3. EXCEPTION (Optional)
   * Handles runtime errors

4. END (Mandatory)
   * End of block

---

## SQL vs PL/SQL

| SQL                              | PL/SQL                       |
| -------------------------------- | ---------------------------- |
| Declarative language             | Procedural language          |
| Executes one statement at a time | Executes blocks of code      |
| No variables                     | Supports variables           |
| No loops                         | Supports loops               |
| Limited error handling           | Exception handling available |
| Used for data operations         | Used for business logic      |

---

## Advantages of PL/SQL

* Reduced network traffic
* Faster execution
* Better code reusability
* Improved maintainability
* Enhanced security

---

## Identifiers in PL/SQL

- **Constants**: Fixed values that cannot be modified.
- **Procedures**: Named blocks that perform a task.
- **Functions**: Named blocks that perform a task and return a value.
- **Cursors**: Used to process query results row by row.
- **Triggers**: Execute automatically when specific database events occur.
- **Packages**: Collections of related procedures, functions, variables, and cursors.

--- 

## My Notes

* PL/SQL = SQL + Programming Concepts.
* Oracle uses PL/SQL for backend database logic.
* Every PL/SQL program is written inside a block.
* DECLARE and EXCEPTION sections are optional.
* BEGIN and END are mandatory.

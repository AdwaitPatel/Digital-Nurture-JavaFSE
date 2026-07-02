/* Scenario 1: Handle exceptions during fund transfers between accounts. 
Question: Write a stored procedure SafeTransferFunds that transfers funds between two accounts. Ensure that if any error occurs (e.g., insufficient funds), an appropriate error message is logged and the transaction is rolled back.
*/

CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount       IN NUMBER
)
IS
    v_balance Accounts.Balance%TYPE;
BEGIN

    -- Get sender's balance
    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    -- Check for sufficient balance
    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(
            -20001,
            'Insufficient funds.'
        );
    END IF;

    -- Debit sender
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account;

    -- Credit receiver
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE('Transfer Failed!');
        DBMS_OUTPUT.PUT_LINE(SQLCODE);
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/


-- Successful transfer
BEGIN
    SafeTransferFunds(1, 2, 500);
END;
/

-- Transfer with insufficient balance
BEGIN
    SafeTransferFunds(1, 2, 50000);
END;
/




/* 
Scenario 2: Manage errors when updating employee salaries. 
Question: Write a stored procedure UpdateSalary that increases the salary of an employee by a given percentage. If the employee ID does not exist, handle the exception and log an error message. 
*/


CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_empid IN NUMBER,
    p_percent IN NUMBER
)
IS
    v_salary Employees.Salary%TYPE;
BEGIN

    -- Check if employee exists
    SELECT Salary
    INTO v_salary
    FROM Employees
    WHERE EmployeeID = p_empid;

    -- Update salary
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percent / 100)
    WHERE EmployeeID = p_empid;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salary Updated Successfully');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee ID does not exist.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/


-- Existing employee
BEGIN
    UpdateSalary(1,10);
END;
/


-- Non-existing employee
BEGIN
    UpdateSalary(100,10);
END;
/





/*
Scenario 3: Ensure data integrity when adding a new customer. 
Question: Write a stored procedure AddNewCustomer that inserts a new customer into the Customers table. If a customer with the same ID already exists, handle the exception by logging an error and preventing the insertion.
*/


CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customerid IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
)
IS
BEGIN

    INSERT INTO Customers(
        CustomerID,
        Name,
        DOB,
        Balance,
        LastModified
    )
    VALUES(
        p_customerid,
        p_name,
        p_dob,
        p_balance,
        SYSDATE
    );

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer added successfully.');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Customer ID already exists.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/


-- Successful
BEGIN
    AddNewCustomer(
        3,
        'Adwait',
        TO_DATE('2004-09-01','YYYY-MM-DD'),
        20000
    );
END;
/


-- Duplicate ID
BEGIN
    AddNewCustomer(
        1,
        'Adwait',
        TO_DATE('2004-09-01','YYYY-MM-DD'),
        20000
    );
END;
/










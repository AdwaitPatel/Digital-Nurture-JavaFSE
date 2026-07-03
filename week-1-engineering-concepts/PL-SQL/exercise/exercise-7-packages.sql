/*
Scenario 1: Group all customer-related procedures and functions into a package. 
Question: Create a package CustomerManagement with procedures for adding a new customer, updating customer details, and a function to get customer balance. 
*/


CREATE OR REPLACE PACKAGE CustomerManagement AS

    PROCEDURE AddNewCustomer(
        p_customerid IN NUMBER,
        p_name       IN VARCHAR2,
        p_dob        IN DATE,
        p_balance    IN NUMBER
    );

    PROCEDURE UpdateCustomerDetails(
        p_customerid IN NUMBER,
        p_name       IN VARCHAR2,
        p_balance    IN NUMBER
    );

    FUNCTION GetCustomerBalance(
        p_customerid IN NUMBER
    )
    RETURN NUMBER;

END CustomerManagement;
/




CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    -- add new customer

    PROCEDURE AddNewCustomer(
        p_customerid IN NUMBER,
        p_name       IN VARCHAR2,
        p_dob        IN DATE,
        p_balance    IN NUMBER
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

    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Customer already exists.');

    END AddNewCustomer;

    -- update customer

    PROCEDURE UpdateCustomerDetails(
        p_customerid IN NUMBER,
        p_name       IN VARCHAR2,
        p_balance    IN NUMBER
    )
    IS
    BEGIN

        UPDATE Customers
        SET Name = p_name,
            Balance = p_balance
        WHERE CustomerID = p_customerid;

        COMMIT;

    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE(SQLERRM);

    END UpdateCustomerDetails;

    -- get balance

    FUNCTION GetCustomerBalance(
        p_customerid IN NUMBER
    )
    RETURN NUMBER
    IS
        v_balance Customers.Balance%TYPE;
    BEGIN

        SELECT Balance
        INTO v_balance
        FROM Customers
        WHERE CustomerID = p_customerid;

        RETURN v_balance;

    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;

    END GetCustomerBalance;

END CustomerManagement;
/




-- Add Customer
BEGIN
    CustomerManagement.AddNewCustomer(
        3,
        'Adwait',
        TO_DATE('2004-09-01','YYYY-MM-DD'),
        20000
    );
END;
/


-- Update Customer
BEGIN
    CustomerManagement.UpdateCustomerDetails(
        3,
        'Adwait Patel',
        25000
    );
END;
/



-- get customer balance
DECLARE
    balance NUMBER;
BEGIN

    balance :=
        CustomerManagement.GetCustomerBalance(3);

    DBMS_OUTPUT.PUT_LINE('Balance : ' || balance);

END;
/





/*
Scenario 2: Create a package to manage employee data. 
Question: Write a package EmployeeManagement with procedures to hire new 
employees, update employee details, and a function to calculate annual salary. 
*/


CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_employeeid IN NUMBER,
        p_name       IN VARCHAR2,
        p_position   IN VARCHAR2,
        p_salary     IN NUMBER,
        p_department IN VARCHAR2,
        p_hiredate   IN DATE
    );

    PROCEDURE UpdateEmployeeDetails(
        p_employeeid IN NUMBER,
        p_position   IN VARCHAR2,
        p_salary     IN NUMBER,
        p_department IN VARCHAR2
    );

    FUNCTION CalculateAnnualSalary(
        p_employeeid IN NUMBER
    )
    RETURN NUMBER;

END EmployeeManagement;
/


CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    -- Hire New Employee

    PROCEDURE HireEmployee(
        p_employeeid IN NUMBER,
        p_name       IN VARCHAR2,
        p_position   IN VARCHAR2,
        p_salary     IN NUMBER,
        p_department IN VARCHAR2,
        p_hiredate   IN DATE
    )
    IS
    BEGIN

        INSERT INTO Employees(
            EmployeeID,
            Name,
            Position,
            Salary,
            Department,
            HireDate
        )
        VALUES(
            p_employeeid,
            p_name,
            p_position,
            p_salary,
            p_department,
            p_hiredate
        );

        COMMIT;

    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Employee already exists.');

    END HireEmployee;

    -- Update Employee Details

    PROCEDURE UpdateEmployeeDetails(
        p_employeeid IN NUMBER,
        p_position   IN VARCHAR2,
        p_salary     IN NUMBER,
        p_department IN VARCHAR2
    )
    IS
    BEGIN

        UPDATE Employees
        SET Position   = p_position,
            Salary     = p_salary,
            Department = p_department
        WHERE EmployeeID = p_employeeid;

        COMMIT;

    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE(SQLERRM);

    END UpdateEmployeeDetails;

    -- Calculate Annual Salary

    FUNCTION CalculateAnnualSalary(
        p_employeeid IN NUMBER
    )
    RETURN NUMBER
    IS
        v_salary Employees.Salary%TYPE;
    BEGIN

        SELECT Salary
        INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_employeeid;

        RETURN v_salary * 12;

    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;

    END CalculateAnnualSalary;

END EmployeeManagement;
/




-- hire employee
BEGIN
    EmployeeManagement.HireEmployee(
        3,
        'Adwait',
        'Software Engineer',
        75000,
        'IT',
        SYSDATE
    );
END;
/



-- update employee
BEGIN
    EmployeeManagement.UpdateEmployeeDetails(
        3,
        'Senior Software Engineer',
        90000,
        'IT'
    );
END;
/


-- calculate annual salary
DECLARE
    annual_salary NUMBER;
BEGIN

    annual_salary :=
        EmployeeManagement.CalculateAnnualSalary(3);

    DBMS_OUTPUT.PUT_LINE(
        'Annual Salary = ' || annual_salary
    );

END;
/










/*
Scenario 3: Group all account-related operations into a package. 
Question: Create a package AccountOperations with procedures for opening a new 
account, closing an account, and a function to get the total balance of a customer across all accounts. 
*/



CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount(
        p_accountid   IN NUMBER,
        p_customerid  IN NUMBER,
        p_accounttype IN VARCHAR2,
        p_balance     IN NUMBER
    );

    PROCEDURE CloseAccount(
        p_accountid IN NUMBER
    );

    FUNCTION GetTotalBalance(
        p_customerid IN NUMBER
    )
    RETURN NUMBER;

END AccountOperations;
/


CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    -- Open New Account

    PROCEDURE OpenAccount(
        p_accountid   IN NUMBER,
        p_customerid  IN NUMBER,
        p_accounttype IN VARCHAR2,
        p_balance     IN NUMBER
    )
    IS
    BEGIN

        INSERT INTO Accounts(
            AccountID,
            CustomerID,
            AccountType,
            Balance,
            LastModified
        )
        VALUES(
            p_accountid,
            p_customerid,
            p_accounttype,
            p_balance,
            SYSDATE
        );

        COMMIT;

    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE('Account already exists.');

    END OpenAccount;

    -- Close Account

    PROCEDURE CloseAccount(
        p_accountid IN NUMBER
    )
    IS
    BEGIN

        DELETE FROM Accounts
        WHERE AccountID = p_accountid;

        COMMIT;

    EXCEPTION
        WHEN OTHERS THEN
            ROLLBACK;
            DBMS_OUTPUT.PUT_LINE(SQLERRM);

    END CloseAccount;

    -- Get Total Balance

    FUNCTION GetTotalBalance(
        p_customerid IN NUMBER
    )
    RETURN NUMBER
    IS
        v_total_balance NUMBER;
    BEGIN

        SELECT SUM(Balance)
        INTO v_total_balance
        FROM Accounts
        WHERE CustomerID = p_customerid;

        RETURN NVL(v_total_balance, 0);

    EXCEPTION
        WHEN OTHERS THEN
            RETURN 0;

    END GetTotalBalance;

END AccountOperations;
/



-- Open a New Account
BEGIN
    AccountOperations.OpenAccount(
        3,
        1,
        'Savings',
        5000
    );
END;
/


-- Close an Account
BEGIN
    AccountOperations.CloseAccount(3);
END;
/



-- Get Total Balance
DECLARE
    total_balance NUMBER;
BEGIN

    total_balance :=
        AccountOperations.GetTotalBalance(1);

    DBMS_OUTPUT.PUT_LINE(
        'Total Balance = ' || total_balance
    );

END;
/







/*
Scenario 1: Automatically update the last modified date when a customer's record is updated. 
Question: Write a trigger UpdateCustomerLastModified that updates the LastModified column of the Customers table to the current date whenever a customer's record is updated. 
*/


CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE
ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

-- Before update
SELECT CustomerID, Name, LastModified
FROM Customers;

-- Update Customer
UPDATE Customers
SET Balance = 5000
WHERE CustomerID = 1;


-- After update
SELECT CustomerID, Name, LastModified
FROM Customers;




/*
Scenario 2: Maintain an audit log for all transactions. 
Question: Write a trigger LogTransaction that inserts a record into an AuditLog table whenever a transaction is inserted into the Transactions table. 
*/

-- create auditlog table
CREATE TABLE AuditLog (
    AuditID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    AccountID NUMBER,
    Amount NUMBER,
    TransactionType VARCHAR2(20),
    AuditDate DATE
);


-- trigger
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT
ON Transactions
FOR EACH ROW
BEGIN

    INSERT INTO AuditLog(
        AuditID,
        TransactionID,
        AccountID,
        Amount,
        TransactionType,
        AuditDate
    )
    VALUES(
        :NEW.TransactionID,
        :NEW.TransactionID,
        :NEW.AccountID,
        :NEW.Amount,
        :NEW.TransactionType,
        SYSDATE
    );

END;
/


-- insert a transaction
INSERT INTO Transactions(
    TransactionID,
    AccountID,
    TransactionDate,
    Amount,
    TransactionType
)
VALUES(3, 1, SYSDATE, 500, 'Deposit');


-- check
SELECT * FROM AuditLog;



/* 
Scenario 3: Enforce business rules on deposits and withdrawals. 
Question: Write a trigger CheckTransactionRules that ensures withdrawals do not exceed the balance and deposits are positive before inserting a record into the Transactions table. 
*/


CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT
ON Transactions
FOR EACH ROW
DECLARE
    v_balance Accounts.Balance%TYPE;
BEGIN

    -- Deposit validation
    IF :NEW.TransactionType = 'Deposit'
       AND :NEW.Amount <= 0 THEN

        RAISE_APPLICATION_ERROR(
            -20001,
            'Deposit amount must be positive.'
        );

    END IF;

    -- Withdrawal validation
    IF :NEW.TransactionType = 'Withdrawal' THEN

        SELECT Balance
        INTO v_balance
        FROM Accounts
        WHERE AccountID = :NEW.AccountID;

        IF :NEW.Amount > v_balance THEN

            RAISE_APPLICATION_ERROR(
                -20002,
                'Insufficient account balance.'
            );

        END IF;
    END IF;
END;
/


-- valid deposit -> 1 row inserted
INSERT INTO Transactions
VALUES (
    4,
    1,
    SYSDATE,
    500,
    'Deposit'
);



-- Invalid Deposit -> Error
INSERT INTO Transactions
VALUES (
    4,
    1,
    SYSDATE,
    -500,
    'Deposit'
);




-- Valid Withdrawal -> 1 Row inserted
INSERT INTO Transactions
VALUES (
    5,
    1,
    SYSDATE,
    100,
    'Withdrawal'
);


-- Invalid Withdrawal -> Error
INSERT INTO Transactions
VALUES (
    5,
    1,
    SYSDATE,
    10000,
    'Withdrawal'
);




/*
Scenario 1: Generate monthly statements for all customers. 
Question: Write a PL/SQL block using an explicit cursor GenerateMonthlyStatements that retrieves all transactions for the current month and prints a statement for each customer. 
*/

DECLARE

    CURSOR c_statement IS
        SELECT c.Name,
               t.TransactionID,
               t.TransactionDate,
               t.Amount,
               t.TransactionType
        FROM Customers c
        JOIN Accounts a
            ON c.CustomerID = a.CustomerID
        JOIN Transactions t
            ON a.AccountID = t.AccountID
        WHERE t.TransactionDate >= TRUNC(SYSDATE, 'MM');

    v_name Customers.Name%TYPE;
    v_transactionid Transactions.TransactionID%TYPE;
    v_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_type Transactions.TransactionType%TYPE;

BEGIN

    OPEN c_statement;

    LOOP

        FETCH c_statement
        INTO v_name,
             v_transactionid,
             v_date,
             v_amount,
             v_type;

        EXIT WHEN c_statement%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Customer: ' || v_name
        );

        DBMS_OUTPUT.PUT_LINE(
            'Transaction ID: ' || v_transactionid
        );

        DBMS_OUTPUT.PUT_LINE(
            'Date: ' || TO_CHAR(v_date,'DD-MON-YYYY')
        );

        DBMS_OUTPUT.PUT_LINE(
            'Amount: ' || v_amount
        );

        DBMS_OUTPUT.PUT_LINE(
            'Type: ' || v_type
        );

        DBMS_OUTPUT.PUT_LINE(
            '-----------------------------'
        );

    END LOOP;

    CLOSE c_statement;

END;
/





/*
Scenario 2: Apply annual fee to all accounts. 
Question: Write a PL/SQL block using an explicit cursor ApplyAnnualFee that deducts an annual maintenance fee from the balance of all accounts. 
*/


declare

    CURSOR c_accounts IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_accountid Accounts.AccountID%TYPE;
    v_balance   Accounts.Balance%TYPE;

    annual_fee CONSTANT NUMBER := 100;

BEGIN

    OPEN c_accounts;

    LOOP

        FETCH c_accounts
        INTO v_accountid,
             v_balance;

        EXIT WHEN c_accounts%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - annual_fee
        WHERE AccountID = v_accountid;

    END LOOP;

    CLOSE c_accounts;

    commit;

    DBMS_OUTPUT.PUT_LINE('annual maintenance fee applied successfully');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
end;
/






/*
Scenario 3: Update the interest rate for all loans based on a new policy. 
Question: Write a PL/SQL block using an explicit cursor UpdateLoanInterestRates that fetches all loans and updates their interest rates based on the new policy.
*/

DECLARE

    CURSOR c_loans IS
        SELECT LoanID, InterestRate
        FROM Loans;

    v_loanid Loans.LoanID%TYPE;
    v_rate   Loans.InterestRate%TYPE;

BEGIN

    OPEN c_loans;

    LOOP
        FETCH c_loans
        INTO v_loanid,
             v_rate;

        EXIT WHEN c_loans%NOTFOUND;

        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE LoanID = v_loanid;

    END LOOP;
    CLOSE c_loans;
    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Loan interest rates updated successfully.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);

END;
/








/*
Scenario 1: Calculate the age of customers for eligibility checks. 
Question: Write a function CalculateAge that takes a customer's date of birth as input and returns their age in years. 
*/


CREATE OR REPLACE FUNCTION CalculateAge(
    p_dob IN DATE
)
RETURN NUMBER
IS
BEGIN

    RETURN TRUNC(
        MONTHS_BETWEEN(SYSDATE, p_dob) / 12
    );

END;
/


-- check customer's age of id 1
DECLARE
    age NUMBER;
BEGIN

    SELECT CalculateAge(DOB)
    INTO age
    FROM Customers
    WHERE CustomerID = 1;

    DBMS_OUTPUT.PUT_LINE('Age : ' || age);

END;
/






/*
Scenario 2: The bank needs to compute the monthly installment for a loan. 
Question: Write a function CalculateMonthlyInstallment that takes the loan amount, interest rate, and loan duration in years as input and returns the monthly installment amount. 
*/

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount   IN NUMBER,
    p_interest_rate IN NUMBER,
    p_years         IN NUMBER
)
RETURN NUMBER
IS
    v_monthly_rate NUMBER;
    v_months       NUMBER;
    v_emi          NUMBER;
BEGIN
    v_monthly_rate := (p_interest_rate / 100) / 12;
    v_months := p_years * 12;

    v_emi :=
        (p_loan_amount * v_monthly_rate *
         POWER(1 + v_monthly_rate, v_months)) /
        (POWER(1 + v_monthly_rate, v_months) - 1);

    RETURN ROUND(v_emi, 2);
END;
/


-- execute
DECLARE
    monthly_installment NUMBER;
BEGIN
    monthly_installment :=
        CalculateMonthlyInstallment(
            500000,
            8,
            10
        );
    DBMS_OUTPUT.PUT_LINE(
        'Monthly EMI = ' || monthly_installment
    );
END;
/




/*
Scenario 3: Check if a customer has sufficient balance before making a transaction. 
Question: Write a function HasSufficientBalance that takes an account ID and an amount as input and returns a boolean indicating whether the account has at least the specified amount. 
*/

CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id IN NUMBER,
    p_amount     IN NUMBER
)
RETURN BOOLEAN
IS
    v_balance Accounts.Balance%TYPE;
BEGIN

    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/


-- execute
DECLARE
    result BOOLEAN;
BEGIN

    result := HasSufficientBalance(1, 500);

    IF result THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient Balance');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');
    END IF;

END;
/








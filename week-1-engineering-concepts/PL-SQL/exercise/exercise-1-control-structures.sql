/*
Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.
Question: Write a PL/SQL block that loops through all customers, checks their age, and if they are above 60, apply a 1% discount to their current loan interest rates. 
*/

DECLARE
    age NUMBER;
BEGIN
    FOR customer IN (
        SELECT *
        FROM Customers
    )
    LOOP
        age := TRUNC(MONTHS_BETWEEN(SYSDATE, customer.DOB) / 12);
        IF age > 60 THEN
            UPDATE LOANS
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = customer.CustomerID;
        END IF;
    END LOOP;
END;
/


/*
Scenario 2: A customer can be promoted to VIP status based on their balance. 
Question: Write a PL/SQL block that iterates through all customers and sets a flag IsVIP 
to TRUE for those with a balance over $10,000. 
*/


/*
Scenario 3: The bank wants to send reminders to customers whose loans are due within the 
next 30 days. 
Question: Write a PL/SQL block that fetches all loans due in the next 30 days and prints a 
reminder message for each customer. 
*/










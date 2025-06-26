--Scenario 1
BEGIN
  FOR cust IN (
    SELECT CustomerID, DOB
      FROM Customers
  ) LOOP
    IF TRUNC(MONTHS_BETWEEN(SYSDATE, cust.DOB) / 12) > 60 THEN
      UPDATE Loans
         SET InterestRate = InterestRate - 1
       WHERE CustomerID = cust.CustomerID;
    END IF;
  END LOOP;

  COMMIT;
END;
/

ALTER TABLE Customers ADD (IsVIP CHAR(1) DEFAULT 'N');

--Scenario 2
BEGIN
  FOR cust IN (
    SELECT CustomerID, Balance
      FROM Customers
  ) LOOP
    IF cust.Balance > 10000 THEN
      UPDATE Customers
         SET IsVIP = 'Y'
       WHERE CustomerID = cust.CustomerID;
    END IF;
  END LOOP;

  COMMIT;
END;
/
--Scenario 3
BEGIN
  FOR rec IN (
    SELECT l.LoanID,
           c.Name      AS CustomerName,
           l.EndDate
      FROM Loans l
      JOIN Customers c
        ON l.CustomerID = c.CustomerID
     WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE(
      'Reminder: Loan ' || rec.LoanID
      || ' for ' || rec.CustomerName
      || ' is due on ' || TO_CHAR(rec.EndDate, 'DD-MON-YYYY')
    );
  END LOOP;
END;
/
--Scenarion 1
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
  UPDATE Accounts
     SET Balance = Balance * 1.01
   WHERE AccountType = 'Savings';

  COMMIT;
END ProcessMonthlyInterest;
/
--Scenario 2
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  p_department IN VARCHAR2,
  p_bonus_pct  IN NUMBER  -- e.g. pass 10 for a 10% bonus
)
IS
BEGIN
  UPDATE Employees
     SET Salary = Salary * (1 + p_bonus_pct/100)
   WHERE Department = p_department;

  COMMIT;
END UpdateEmployeeBonus;
/
BEGIN
  UpdateEmployeeBonus('Sales', 5);
END;
/
--Scenario 3
CREATE OR REPLACE PROCEDURE TransferFunds(
  p_from_acct IN NUMBER,
  p_to_acct   IN NUMBER,
  p_amount    IN NUMBER
)
IS
  v_balance  Accounts.Balance%TYPE;
BEGIN
  -- Lock the source row to prevent concurrent modifications
  SELECT Balance
    INTO v_balance
    FROM Accounts
   WHERE AccountID = p_from_acct
     FOR UPDATE;

  -- Check sufficient funds
  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(
      -20001,
      'Insufficient funds in account ' || p_from_acct
    );
  END IF;

  -- Perform the transfer
  UPDATE Accounts
     SET Balance = Balance - p_amount
   WHERE AccountID = p_from_acct;

  UPDATE Accounts
     SET Balance = Balance + p_amount
   WHERE AccountID = p_to_acct;

  COMMIT;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RAISE_APPLICATION_ERROR(-20002, 'Account not found.');
  WHEN OTHERS THEN
    ROLLBACK;
    RAISE;  -- propagate unexpected errors
END TransferFunds;
/
BEGIN
  -- Transfer 500 units from account 1001 to 1002
  TransferFunds(1001, 1002, 500);
END;
/
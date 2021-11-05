--Before inserting data into BOOK Table
CREATE TRIGGER TR_Book_Insert ON BOOK
INSTEAD OF INSERT
AS
BEGIN
	INSERT INTO BOOK
		SELECT b.* FROM inserted b
			INNER JOIN PRODUCT p ON p.PID=b.PID
		WHERE p.PCategory='book' AND b.PubID <= p.PImportedDate;
END
GO
--Before inserting data into STATIONERY Table
CREATE TRIGGER TR_Stationery_Insert ON STATIONERY
INSTEAD OF INSERT
AS
BEGIN
	INSERT INTO STATIONERY
		SELECT s.* FROM inserted s
			INNER JOIN PRODUCT p ON p.PID=s.PID
		WHERE p.PCategory='stationery';
END
GO
--Before inserting data into ONLINE_BILL Table
CREATE TRIGGER TR_OnBill_Insert ON ONLINE_BILL
INSTEAD OF INSERT
AS
BEGIN
	INSERT INTO ONLINE_BILL
		SELECT b.* FROM inserted b
			INNER JOIN USERS u ON u.UID = b.UID
			INNER JOIN BILL bb ON b.BID = bb.BID
		WHERE u.RegisterDate <= bb.BDate;
END
GO
--Before inserting data into OFFLINE_BILL Table
CREATE TRIGGER TR_OffBill_Insert ON OFFLINE_BILL
INSTEAD OF INSERT
AS
BEGIN
	INSERT INTO OFFLINE_BILL
		SELECT b.* FROM inserted b
			INNER JOIN EMPLOYEE e ON e.EID = b.EID
			INNER JOIN BILL bb ON b.BID = bb.BID
		WHERE e.InDate <= bb.BDate;
END
GO
--Before inserting data into LEADS Table

CREATE TRIGGER TR_Leads_Insert ON LEADS
INSTEAD OF INSERT
AS
BEGIN
	INSERT INTO LEADS
		SELECT l.* FROM inserted l
			INNER JOIN EMPLOYEE e ON e.EID = l.EID
		WHERE e.InDate <= l.StartedDate;
END
GO
--Before inserting data into VOUCHER Table
CREATE TRIGGER TR_Voucher_Insert ON VOUCHER
INSTEAD OF INSERT
AS
BEGIN
	INSERT INTO VOUCHER
		SELECT v.* FROM inserted v
		WHERE v.StartedDate <= v.EndedDate;
END
GO
--Before inserting data into DISCOUNT_PROGRAM Table
CREATE TRIGGER TR_Discount_Insert ON DISCOUNT_PROGRAM
INSTEAD OF INSERT
AS
BEGIN
	INSERT INTO DISCOUNT_PROGRAM
		SELECT d.* FROM inserted d
		WHERE d.StartedDate <= d.EndedDate;
END
GO
--Before inserting data into EMPLOYEE Table
CREATE TRIGGER TR_Employee_Insert ON EMPLOYEE
INSTEAD OF INSERT
AS
BEGIN
	INSERT INTO EMPLOYEE
		SELECT e.* FROM inserted e
		WHERE e.InDate <= e.OutDate;
END
GO

-- Adding procedure to update Rank
CREATE PROCEDURE UpdateUserRank AS BEGIN WITH USERS_profit AS
  (SELECT u.UID,
          COALESCE(SUM(pro.PPrice - (CASE
                                         WHEN pro.PPrice * d.DRate < d.DLimit THEN pro.PPrice * d.DRate
                                         ELSE d.DLimit
                                     END) * ib.Amount), 0) AS money_u
   FROM in_bill ib
   JOIN ONLINE_BILL on_b ON ib.BID = on_b.BID
   JOIN PRODUCT pro ON pro.PID = ib.PID
   JOIN DISCOUNT_PROGRAM d ON d.DID = ib.DID
   RIGHT JOIN USERS u ON on_b.UID = u.UID
   GROUP BY u.UID)
UPDATE [USERS]
SET [USERS].URank = CASE
                        WHEN USERS_profit.money_u < 100000
                             OR USERS_profit.money_u IS NULL THEN 'newbie'
                        WHEN (USERS_profit.money_u BETWEEN 100000 AND 500000) THEN 'brown'
                        WHEN (USERS_profit.money_u BETWEEN 500001 AND 1000000) THEN 'silver'
                        WHEN (USERS_profit.money_u BETWEEN 1000001 AND 10000000) THEN 'gold'
                        ELSE 'diamond'
                    END
FROM USERS_profit,
     USERS
WHERE USERS_profit.UID = [USERS].UID;

END
GO

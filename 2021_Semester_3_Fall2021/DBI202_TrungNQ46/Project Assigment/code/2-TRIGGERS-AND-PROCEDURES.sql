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
CREATE PROCEDURE UpdateUserRank 
AS
BEGIN
		with USERS_profit as
		(
		select on_b.UID, sum(pro.PPrice*ib.Amount)as money_u  from in_bill ib 
		join ONLINE_BILL on_b
		on ib.BID=on_b.BID 
		join PRODUCT pro
		on pro.PID=ib.PID
		group by on_b.UID)
		update [USERS]
		set [USERS].URank=
		case 
			when USERS_profit.money_u < 100000 then 'newbie'
			when (USERS_profit.money_u between 100000 and 500000) then 'brown'
			when (USERS_profit.money_u between 500000 and 1000000)  then 'silver'
			when (USERS_profit.money_u between 1000000 and 10000000)  then 'gold'
			else 'diamond'
		end
		from  USERS_profit, USERS
		WHERE USERS_profit.UID=[USERS].UID;
END
GO
-- TOP 100 Products which are Bestsellers

SELECT TOP 100 pro.PID,
           pro.PName,
           pro.PCategory,
           sum(ib.Amount)*avg(pro.PPrice) AS ProductRevenue
FROM IN_BILL ib
JOIN PRODUCT pro ON ib.PID=pro.PID
GROUP BY pro.PID,
         pro.PName,
         pro.PCategory
ORDER BY ProductRevenue DESC;

-- TOP 100 Users which Buy the most

SELECT TOP 100 on_b.UID,
           (u.UFirstName + ' ' + u.UMiddleName +' '+ u.ULastName) AS FullName,
           u.UPhone,
           sum(pro.PPrice*ib.Amount) AS Profit
FROM in_bill ib
JOIN ONLINE_BILL on_b ON ib.BID=on_b.BID
JOIN PRODUCT pro ON pro.PID=ib.PID
JOIN USERS u ON u.UID = on_b.UID
GROUP BY on_b.UID,
         u.UFirstName,
         u.UMiddleName,
         u.ULastName,
         u.UPhone
ORDER BY Profit DESC;

-- TOP 10 Authors which have Books in Bestsellers

SELECT TOP 10 au.AID,
           au.AName,
           au.ANationality,
           SUM(ib.Amount) AS BookAmount
FROM BOOK_AUTHOR au
JOIN BOOK bo ON au.AID=bo.AID
JOIN IN_BILL ib ON ib.PID=bo.PID
GROUP BY au.AID,
         au.AName,
         au.ANationality
ORDER BY BookAmount DESC;

-- TOP 100 Products which are Bestsellers

SELECT TOP 100 pro.PID,
           pro.PName,
           sum(ib.Amount) AS ProductAmount
FROM IN_BILL ib
JOIN PRODUCT pro ON ib.PID = pro.PID
GROUP BY pro.PID,
         pro.PName
ORDER BY ProductAmount DESC;
-- TOP 100 Users which Buy the most

SELECT TOP 100 u.UID,
           COALESCE(SUM(pro.PPrice - (CASE
                                          WHEN pro.PPrice * d.DRate < d.DLimit THEN pro.PPrice * d.DRate
                                          ELSE d.DLimit
                                      END) * ib.Amount), 0) AS Profit
FROM IN_BILL ib
JOIN ONLINE_BILL on_b ON ib.BID = on_b.BID
JOIN PRODUCT pro ON pro.PID = ib.PID
JOIN DISCOUNT_PROGRAM d ON d.DID = ib.DID
RIGHT JOIN USERS u ON u.UID = on_b.UID
GROUP BY u.UID
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

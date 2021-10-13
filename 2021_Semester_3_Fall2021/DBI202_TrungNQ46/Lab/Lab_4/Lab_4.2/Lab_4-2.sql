USE Company;



-- a
SELECT DEPARTMENT.dname as deptName, MIN(EMPLOYEE.salary) as minSalary, MAX(EMPLOYEE.salary) as maxSalary, COUNT(*) as empCount FROM EMPLOYEE
INNER JOIN DEPARTMENT ON DEPARTMENT.dnumber=EMPLOYEE.dno
GROUP BY DEPARTMENT.dname;


-- b
SELECT COUNT(*) as pCount FROM PROJECT WHERE plocation='Sharjah' GROUP BY dnum;

-- c
SELECT ssn, address from EMPLOYEE
WHERE dno=(SELECT DEPARTMENT.dnumber FROM DEPARTMENT WHERE dname='HR')
AND
'F' in (SELECT sex from DEPENDENT WHERE DEPENDENT.essn=ssn)

-- d
SELECT DISTINCT EMPLOYEE.fname , EMPLOYEE.lname FROM EMPLOYEE
INNER JOIN DEPARTMENT ON DEPARTMENT.dname!='HR';

-- e
SELECT EMPLOYEE.lname, EMPLOYEE.ssn FROM EMPLOYEE
INNER JOIN (SELECT essn FROM WORKS_ON GROUP BY WORKS_ON.essn HAVING COUNT(*) > 3) gr3 ON EMPLOYEE.ssn=gr3.essn;

-- f
SELECT em.ssn, em.lname, em.fname FROM EMPLOYEE em 
JOIN 
(SELECT de.dnumber AS de_num , pro.pnumber , pro.plocation
FROM
DEPARTMENT de 
JOIN PROJECT pro
ON de.dnumber=pro.dnum) de_pro
ON em.dno=de_pro.de_num
WHERE de_pro.plocation='Sharjah' AND de_pro.de_num=(SELECT de.dnumber FROM DEPARTMENT de WHERE de.dname='HR')
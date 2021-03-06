USE Company;

-- a
SELECT DEPARTMENT.dname as dept_name, MIN(EMPLOYEE.salary) as min_salary, 
MAX(EMPLOYEE.salary) as max_salary, COUNT(*) as emp_count FROM EMPLOYEE
INNER JOIN DEPARTMENT ON DEPARTMENT.dnumber=EMPLOYEE.dno
GROUP BY DEPARTMENT.dname;


-- b
SELECT DEPARTMENT.dname as dept_name, COUNT(*) as project_count FROM PROJECT
INNER JOIN DEPARTMENT ON DEPARTMENT.dnumber=PROJECT.dnum 
WHERE plocation='Sharjah' 
GROUP BY dname;


-- c
SELECT ssn, address FROM EMPLOYEE
WHERE dno=(SELECT DEPARTMENT.dnumber FROM DEPARTMENT WHERE dname='HR')
AND
(SELECT COUNT(sex) from DEPENDENT WHERE DEPENDENT.essn=ssn AND DEPENDENT.sex='F') != 0


-- d
SELECT fname, lname, DEPARTMENT.dname FROM EMPLOYEE
JOIN DEPARTMENT ON EMPLOYEE.dno=DEPARTMENT.dnumber
WHERE DEPARTMENT.dname!='HR';


-- e
SELECT lname, ssn FROM EMPLOYEE
JOIN WORKS_ON ON EMPLOYEE.ssn=WORKS_ON.essn
JOIN PROJECT ON PROJECT.pnumber=WORKS_ON.pno
GROUP BY lname, ssn HAVING COUNT(*) > 3;

-- f
SELECT DISTINCT WORKS_ON.essn, EMPLOYEE.fname, EMPLOYEE.lname FROM WORKS_ON
JOIN PROJECT ON PROJECT.pnumber=WORKS_ON.pno
JOIN EMPLOYEE ON EMPLOYEE.dno=PROJECT.dnum
JOIN DEPARTMENT ON EMPLOYEE.dno=DEPARTMENT.dnumber
WHERE DEPARTMENT.dname='HR' AND PROJECT.plocation='Sharjah';
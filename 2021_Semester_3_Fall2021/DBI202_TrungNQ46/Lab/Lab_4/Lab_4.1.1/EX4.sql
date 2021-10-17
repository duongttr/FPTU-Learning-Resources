-- a
SELECT (fname + ' ' + lname) AS name FROM EMPLOYEE
WHERE dno=(SELECT dno FROM EMPLOYEE 
WHERE salary=(SELECT MAX(salary) FROM EMPLOYEE))

-- b
SELECT (fname + ' ' + lname) AS name FROM EMPLOYEE
WHERE superssn IN (SELECT ssn FROM EMPLOYEE WHERE superssn='888665555');

-- c
SELECT (fname + ' ' + lname) AS name, salary FROM EMPLOYEE
WHERE salary-(SELECT MIN(salary) FROM EMPLOYEE) >= 10000

-- d
SELECT (fname + ' ' + lname) AS name FROM WORKS_ON
JOIN PROJECT ON WORKS_ON.pno=PROJECT.pnumber AND PROJECT.pname='ProductX' AND WORKS_ON.hours > 10
JOIN EMPLOYEE ON WORKS_ON.essn=EMPLOYEE.ssn AND EMPLOYEE.dno=5;

-- e
SELECT ssn, (fname + ' ' + lname) AS name FROM EMPLOYEE
JOIN DEPENDENT ON DEPENDENT.essn=EMPLOYEE.ssn AND DEPENDENT.dependent_name LIKE (EMPLOYEE.fname + '%')

-- f
SELECT (fname + ' ' + lname) AS name FROM EMPLOYEE
WHERE superssn=(SELECT ssn FROM EMPLOYEE WHERE (fname + ' ' + lname) = 'Franklin Wong')
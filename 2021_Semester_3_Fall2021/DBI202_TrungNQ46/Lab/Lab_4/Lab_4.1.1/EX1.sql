CREATE DATABASE Company;
USE Company;


CREATE TABLE DEPARTMENT(
    dname VARCHAR(25) NOT NULL,
    dnumber INT PRIMARY KEY,
    mgrssn CHAR(9) NOT NULL,
    mgrstartdate DATE
)
GO

CREATE TABLE DEPT_LOCATIONS(
    dnumber INT NOT NULL,
    dlocation VARCHAR(15) NOT NULL,

    PRIMARY KEY (dnumber, dlocation),
    FOREIGN KEY (dnumber) REFERENCES DEPARTMENT(dnumber)
)
GO

CREATE TABLE PROJECT(
    pname VARCHAR(25) NOT NULL,
    pnumber INT PRIMARY KEY,
    plocation VARCHAR(15),
    dnum INT NOT NULL,
    FOREIGN KEY (dnum) REFERENCES DEPARTMENT(dnumber)
)
GO

CREATE TABLE EMPLOYEE(
    fname VARCHAR(15) NOT NULL,
    minit VARCHAR(1),
    lname VARCHAR(15) NOT NULL,
    ssn CHAR(9) PRIMARY KEY,
    bdate DATE,
    address VARCHAR(50),
    sex CHAR(1),
    salary DECIMAL(10,2),
    superssn CHAR(9),
    dno INT,

    FOREIGN KEY (superssn) REFERENCES EMPLOYEE(ssn),
    FOREIGN KEY (dno) REFERENCES DEPARTMENT(dnumber)
)
GO

CREATE TABLE DEPENDENT(
    essn CHAR(9) NOT NULL,
    dependent_name VARCHAR(15) NOT NULL,
    sex CHAR(1),
    bdate DATE,
    relationship VARCHAR(8),

    PRIMARY KEY(essn, dependent_name),
    FOREIGN KEY (essn) REFERENCES EMPLOYEE(ssn)
)
GO



CREATE TABLE WORKS_ON(
    essn CHAR(9) NOT NULL,
    pno INT NOT NULL,
    hours DECIMAL(4,1),
    
    PRIMARY KEY(essn, pno),
    FOREIGN KEY (essn) REFERENCES EMPLOYEE(ssn),
    FOREIGN KEY (pno) REFERENCES PROJECT(pnumber)
)
GO
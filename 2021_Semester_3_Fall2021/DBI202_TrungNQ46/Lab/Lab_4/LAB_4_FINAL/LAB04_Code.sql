-- 1
CREATE DATABASE HR;
GO
USE HR;

-- 2
CREATE TABLE JOBS(
    job_id INT PRIMARY KEY,
    job_title VARCHAR(20) NOT NULL,
    min_salary INT,
    max_salary INT
)
GO

CREATE TABLE REGIONS(
    region_id INT PRIMARY KEY,
    region_name VARCHAR(20)
)
GO

CREATE TABLE COUNTRIES(
    country_id INT PRIMARY KEY,
    country_name VARCHAR(20),
    region_id INT,

    FOREIGN KEY (region_id) REFERENCES REGIONS(region_id)
)
GO

CREATE TABLE LOCATIONS(
    location_id INT PRIMARY KEY,
    street_address VARCHAR(50),
    postal_code INT,
    city VARCHAR(10),
    state_province VARCHAR(10),
    country_id INT,

    FOREIGN KEY (country_id) REFERENCES COUNTRIES(country_id)

)
GO

CREATE TABLE DEPARTMENTS(
    department_id INT PRIMARY KEY,
    department_name VARCHAR(20),
    manager_id INT,
    location_id INT,

    --FOREIGN KEY (manager_id) REFERENCES EMPLOYEES(employee_id),
    FOREIGN KEY (location_id) REFERENCES LOCATIONS(location_id)
)
GO


CREATE TABLE JOB_HISTORY(
    employee_id INT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    job_id INT,
    department_id INT,

    PRIMARY KEY (employee_id, start_date),
    FOREIGN KEY (job_id) REFERENCES JOBS(job_id),
    FOREIGN KEY (department_id) REFERENCES DEPARTMENTS(department_id)

)
GO

CREATE TABLE  EMPLOYEES(
    employee_id INT PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    email VARCHAR(30),
    phone_number VARCHAR(15),
    hire_date DATE NOT NULL,
    job_id INT,
    salary MONEY,
    commission_pct FLOAT,
    manager_id INT,
    department_id INT,

    FOREIGN KEY (manager_id) REFERENCES EMPLOYEES(employee_id) ,
    FOREIGN KEY (department_id) REFERENCES DEPARTMENTS(department_id),
    FOREIGN KEY (job_id) REFERENCES JOBS(job_id)
)
GO

ALTER TABLE DEPARTMENTS
ADD FOREIGN KEY (manager_id) REFERENCES EMPLOYEES(employee_id);
GO

-- 3
SELECT employee_id, first_name, last_name, phone_number, department_id
FROM EMPLOYEES;
GO

-- 4
SELECT first_name, last_name, EMPLOYEES.department_id, DEPARTMENTS.department_name FROM EMPLOYEES
JOIN DEPARTMENTS ON EMPLOYEES.department_id=DEPARTMENTS.department_id
WHERE EMPLOYEES.department_id IN (10, 20)
GO

-- 5
SELECT first_name, last_name, DEPARTMENTS.department_name, LOCATIONS.city, LOCATIONS.state_province FROM EMPLOYEES
JOIN DEPARTMENTS ON EMPLOYEES.department_id=DEPARTMENTS.department_id
JOIN LOCATIONS ON DEPARTMENTS.location_id=LOCATIONS.location_id
WHERE first_name LIKE '%d%';
GO

-- 6
SELECT first_name, last_name, salary FROM EMPLOYEES
WHERE
salary > (SELECT salary FROM EMPLOYEES WHERE employee_id=200);
GO

-- 7
SELECT e1.first_name AS "employee_name",
       e2.first_name AS "manager_name"
FROM EMPLOYEES e1
INNER JOIN EMPLOYEES e2
    ON e1.manager_id = e2.employee_id;
GO

-- 8
SELECT JOBS.job_title, DEPARTMENTS.department_name, (first_name + ' ' + last_name) AS full_name, JOB_HISTORY.start_date FROM EMPLOYEES
JOIN JOB_HISTORY ON JOB_HISTORY.employee_id=EMPLOYEES.employee_id
JOIN JOBS ON JOB_HISTORY.job_id=JOBS.job_id
JOIN DEPARTMENTS ON DEPARTMENTS.department_id=EMPLOYEES.department_id
WHERE JOB_HISTORY.start_date BETWEEN '20180101' AND '20210831';
GO

-- 9
SELECT DEPARTMENTS.department_name, AVG(salary) AS average_salary, COUNT(employee_id) AS employee_count FROM EMPLOYEES
JOIN DEPARTMENTS ON EMPLOYEES.department_id=DEPARTMENTS.department_id
WHERE EMPLOYEES.commission_pct IS NOT NULL AND EMPLOYEES.commission_pct > 0
GROUP BY DEPARTMENTS.department_name;
GO

-- 10

SELECT c.country_name,
       l.city,
       COUNT(d.department_id)
FROM COUNTRIES c
  INNER JOIN LOCATIONS l
    ON c.country_id = l.country_id
  INNER JOIN DEPARTMENTS d
     ON l.location_id = d.location_id
WHERE d.department_id IN (SELECT e.department_id
                              FROM employees e
                              GROUP BY e.department_id
                              HAVING COUNT(e.department_id) >= 5)
  GROUP BY c.country_name, l.city;

GO;

-- 11

SELECT (first_name + ' ' + last_name) as full_name,
       j.job_title,
       jh.starting_date,
       jh.ending_date
  FROM EMPLOYEES e
  INNER JOIN (SELECT MAX(start_date) AS starting_date,
                     MAX(end_date) AS ending_date,
                     employee_id
                FROM JOB_HISTORY
                GROUP BY employee_id) jh
    ON e.employee_id = jh.employee_id
  INNER JOIN JOBS j
    ON e.job_id = j.job_id
      WHERE e.commission_pct = 0;
GO;

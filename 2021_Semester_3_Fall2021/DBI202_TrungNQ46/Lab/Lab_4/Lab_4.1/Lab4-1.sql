-- 0 - Create Database
CREATE DATABASE mybookstore;
USE mybookstore;

-- 1 - Create Books Table
CREATE TABLE Books (
  isbn INT NOT NULL,
  title VARCHAR(50),
  price FLOAT,
  qty INT NOT NULL
);
ALTER TABLE Books ADD CONSTRAINT PK_isbn PRIMARY KEY (isbn);

-- 2 - Create Authors Table
CREATE TABLE Authors(
  authorId INT NOT NULL,
  name VARCHAR(30),
  email VARCHAR(30)
);
ALTER TABLE Authors ADD CONSTRAINT PK_authorId PRIMARY KEY (authorId);
ALTER TABLE Authors ADD CONSTRAINT U_email UNIQUE (email);



-- 3 - Create Book_Authors table
CREATE TABLE Book_Authors(
  authorId INT NOT NULL,
  isbn INT NOT NULL
 );
ALTER TABLE Book_Authors
ADD CONSTRAINT FK_authorId
FOREIGN KEY (authorId) REFERENCES Authors(authorId);

ALTER TABLE Book_Authors
ADD CONSTRAINT FK_isbn
FOREIGN KEY (isbn) REFERENCES Books(isbn);



 -- ADD CONSTRAINTS
 -- 1 - Add UNIQUE to title in Books Table
 ALTER TABLE Books
 ADD CONSTRAINT U_title UNIQUE (title);

 -- 2 - Add NOT NULL to price in Books Table
ALTER TABLE Books
ALTER COLUMN price FLOAT NOT NULL;

-- 3 - Add CHECK constraints to price in Books Table
ALTER TABLE Books
ADD CONSTRAINT CHK_price CHECK (price > 0.0);

-- 4 - Drop NOT NULL constraints for qty in Books Table
ALTER TABLE Books
ALTER COLUMN qty INT NULL;


-- 5 - DEFAULT value 0 for qty in Books Table
ALTER TABLE Books
ADD CONSTRAINT df_qty
DEFAULT 0 FOR qty;

-- 6 - Drop UNIQUE constraint for email in Authors Table
ALTER TABLE Authors
DROP CONSTRAINT U_email;

-- 7 - Drop any foreign key
ALTER TABLE Book_Authors
DROP CONSTRAINT FK_authorId;


-- 8 - Drop a primary key
ALTER TABLE Authors
DROP CONSTRAINT PK_authorId;

-- 9 - Add an attribute and set a constraint
ALTER TABLE Authors
ADD age INT;
ALTER TABLE Authors
ADD CONSTRAINT CHK_AuthorAge CHECK (Age>0);

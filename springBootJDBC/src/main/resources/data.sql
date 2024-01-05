CREATE DATABASE springbootdb;
USE springbootdb;

CREATE TABLE employee (
    empId INT PRIMARY KEY,
    name VARCHAR(225),
    email VARCHAR(225),
    salary DECIMAL(10, 2),
    address VARCHAR(225)
);

SELECT * FROM employee
CREATE DATABASE payroll_management;

USE payroll_management;

CREATE TABLE departments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO departments (name)
VALUES
('IT'),
('HR'),
('Finance'),
('Marketing');

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15),
    joining_date DATE NOT NULL,
    department_id INT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES departments(id)
);

CREATE TABLE payroll (
    id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT NOT NULL,
    basic DECIMAL(10,2) NOT NULL,
    hra DECIMAL(10,2) NOT NULL,
    ta DECIMAL(10,2) NOT NULL,
    medical_allowance DECIMAL(10,2) NOT NULL,
    special_allowance DECIMAL(10,2) NOT NULL,
    pf DECIMAL(10,2) NOT NULL,
    esic DECIMAL(10,2) NOT NULL,
    professional_tax DECIMAL(10,2) NOT NULL,
    total_earnings DECIMAL(10,2) NOT NULL,
    total_deductions DECIMAL(10,2) NOT NULL,
    net_pay DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employees(id)
);

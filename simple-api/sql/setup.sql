CREATE DATABASE sanic_app;
GO

USE java_app;
GO

CREATE TABLE Employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(50)
);
GO

INSERT INTO Employees (username, password, email)
VALUES ('Peter', '123456789', 'php@gmail.com'),
        ('Peter1', '123456789', 'php1@gmail.com'),
        ('Peter2', '123456789', 'php2@gmail.com'),
        ('Peter3', '123456789', 'php3@gmail.com'),
        ('Peter4', '123456789', 'php4@gmail.com'),
        ('Peter5', '123456789', 'php5@gmail.com'),
        ('Peter6', '123456789', 'php6@gmail.com'),
        ('Peter7', '123456789', 'php7@gmail.com'),
        ('Peter8', '123456789', 'php8@gmail.com'),
        ('Peter9', '123456789', 'php9@gmail.com'),
        ('Peter10', '123456789', 'php10@gmail.com');
GO

CREATE TABLE Productions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    amount INT NOT NULL,
    employeeId INT,
    FOREIGN KEY (employeeId) REFERENCES Employees(id)
);
GO

INSERT INTO Productions (name, amount, employeeId)
VALUES ('production1', 100, 1),
        ('production2', 200, 2),
        ('production3', 1000, 3);
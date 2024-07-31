CREATE DATABASE IF NOT EXISTS java_app;
GO;

USE java_app;
GO;

CREATE TABLE Unit (
  id INT NOT NULL AUTO_INCREMENT,
  displayName VARCHAR(50),
  PRIMARY KEY (id)
);
GO;

CREATE TABLE Supplier (
  id INT NOT NULL AUTO_INCREMENT,
  displayName VARCHAR(50),
  address VARCHAR(100),
  phone VARCHAR(20),
  email VARCHAR(100),
  moreInfo VARCHAR(200),
  contractDate DATETIME,
  PRIMARY KEY (id)
);

CREATE TABLE Customer (
  id INT NOT NULL AUTO_INCREMENT,
  displayName VARCHAR(50),
  address VARCHAR(100),
  phone VARCHAR(20),
  email VARCHAR(100),
  moreInfo VARCHAR(200),
  contractDate DATETIME,
  PRIMARY KEY (id)
);

CREATE TABLE Object (
  id BINARY(16) NOT NULL,
  displayName VARCHAR(50),
  unitId INT NOT NULL,
  supplierId INT NOT NULL,
  qrCode VARCHAR(200),
  barCode VARCHAR(200),
  PRIMARY KEY (id),
  FOREIGN KEY (unitId) REFERENCES Unit(id),
  FOREIGN KEY (supplierId) REFERENCES Supplier(id)
);

CREATE TABLE UserRole (
  id INT NOT NULL AUTO_INCREMENT,
  displayName VARCHAR(50),
  PRIMARY KEY (id)
);

CREATE TABLE Users (
  id INT NOT NULL AUTO_INCREMENT,
  displayName VARCHAR(50),
  userName VARCHAR(100),
  password VARCHAR(100),
  roleId INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (roleId) REFERENCES UserRole(id)
);

CREATE TABLE Input (
  id VARCHAR(128) NOT NULL,
  inputDate DATETIME,
  PRIMARY KEY (id)
);

CREATE TABLE InputInfo (
  id VARCHAR(128) NOT NULL,
  objectId BINARY(16) NOT NULL,
  inputId VARCHAR(128) NOT NULL,
  count INT,
  inputPrice FLOAT DEFAULT 0,
  outputPrice FLOAT DEFAULT 0,
  status VARCHAR(10),
  PRIMARY KEY (id),
  FOREIGN KEY (objectId) REFERENCES Object(id),
  FOREIGN KEY (inputId) REFERENCES Input(id)
);

CREATE TABLE Output (
  id VARCHAR(128) NOT NULL,
  outputDate DATETIME,
  PRIMARY KEY (id)
);

CREATE TABLE OutputInfo (
  id VARCHAR(128) NOT NULL,
  objectId BINARY(16) NOT NULL,
  inputInfoId VARCHAR(128) NOT NULL,
  customerId INT NOT NULL,
  count INT,
  status VARCHAR(10),
  PRIMARY KEY (id),
  FOREIGN KEY (objectId) REFERENCES Object(id),
  FOREIGN KEY (inputInfoId) REFERENCES InputInfo(id),
  FOREIGN KEY (customerId) REFERENCES Customer(id)
);

GO

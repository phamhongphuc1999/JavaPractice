CREATE DATABASE IF NOT EXISTS java_app;
GO

USE java_app;
GO

CREATE TABLE IF NOT EXISTS Unit (
  id INT NOT NULL AUTO_INCREMENT,
  displayName VARCHAR(50),
  PRIMARY KEY (id)
);
GO

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
GO

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
GO

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
GO

CREATE TABLE UserRole (
  id INT NOT NULL AUTO_INCREMENT,
  displayName VARCHAR(50),
  PRIMARY KEY (id)
);
GO

CREATE TABLE User (
  id INT NOT NULL AUTO_INCREMENT,
  displayName VARCHAR(50),
  userName VARCHAR(100),
  password VARCHAR(100),
  roleId INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (roleId) REFERENCES UserRole(id)
);
GO

CREATE TABLE Input (
  id VARCHAR(128) NOT NULL,
  inputDate DATETIME,
  PRIMARY KEY (id)
);
GO

CREATE TABLE InputInfo (
  id VARCHAR(128) NOT NULL,
  object_id BINARY(16) NOT NULL,
  input_id VARCHAR(128) NOT NULL,
  count INT,
  input_price FLOAT DEFAULT 0,
  output_price FLOAT DEFAULT 0,
  status VARCHAR(10),
  PRIMARY KEY (id),
  FOREIGN KEY (object_id) REFERENCES Object(id),
  FOREIGN KEY (input_id) REFERENCES Input(id)
);
GO

CREATE TABLE Output (
  id VARCHAR(128) NOT NULL,
  outputDate DATETIME,
  PRIMARY KEY (id)
);
GO

CREATE TABLE OutputInfo (
  id VARCHAR(128) NOT NULL,
  object_id BINARY(16) NOT NULL,
  input_info_id VARCHAR(128) NOT NULL,
  customer_id INT NOT NULL,
  count INT,
  status VARCHAR(10),
  PRIMARY KEY (id),
  FOREIGN KEY (object_id) REFERENCES Object(id),
  FOREIGN KEY (input_info_id) REFERENCES InputInfo(id),
  FOREIGN KEY (customer_id) REFERENCES Customer(id)
);
GO

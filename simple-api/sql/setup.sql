CREATE DATABASE IF NOT EXISTS java_app;
GO

USE java_app;
GO

CREATE TABLE IF NOT EXISTS unit (
  id INT NOT NULL AUTO_INCREMENT,
  display_name VARCHAR(50),
  PRIMARY KEY (id)
);
GO

CREATE TABLE supplier (
  id INT NOT NULL AUTO_INCREMENT,
  display_name VARCHAR(50),
  address VARCHAR(100),
  phone VARCHAR(20),
  email VARCHAR(100),
  more_info VARCHAR(200),
  contract_date DATETIME,
  PRIMARY KEY (id)
);
GO

CREATE TABLE customer (
  id INT NOT NULL AUTO_INCREMENT,
  display_name VARCHAR(50),
  address VARCHAR(100),
  phone VARCHAR(20),
  email VARCHAR(100),
  more_info VARCHAR(200),
  contract_date DATETIME,
  PRIMARY KEY (id)
);
GO

CREATE TABLE object (
  id BINARY(16) NOT NULL,
  display_name VARCHAR(50),
  unitId INT NOT NULL,
  supplier_id INT NOT NULL,
  count INT,
  qr_code VARCHAR(200),
  bar_code VARCHAR(200),
  PRIMARY KEY (id),
  FOREIGN KEY (unit_id) REFERENCES unit(id),
  FOREIGN KEY (supplier_id) REFERENCES supplier(id)
);
GO

CREATE TABLE user_role (
  id INT NOT NULL AUTO_INCREMENT,
  display_name VARCHAR(50),
  PRIMARY KEY (id)
);
GO

CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT,
  display_name VARCHAR(50),
  username VARCHAR(100),
  password VARCHAR(100),
  role_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (role_id) REFERENCES user_role(id)
);
GO

CREATE TABLE input (
  id UUID NOT NULL,
  input_date DATETIME,
  PRIMARY KEY (id)
);
GO

CREATE TABLE input_info (
  id UUID NOT NULL,
  object_id BINARY(16) NOT NULL,
  input_id VARCHAR(128) NOT NULL,
  count INT,
  input_price FLOAT DEFAULT 0,
  status VARCHAR(10),
  PRIMARY KEY (id),
  FOREIGN KEY (object_id) REFERENCES object(id),
  FOREIGN KEY (input_id) REFERENCES input(id)
);
GO

CREATE TABLE output (
  id UUID NOT NULL,
  output_date DATETIME,
  PRIMARY KEY (id)
);
GO

CREATE TABLE output_info (
  id UUID NOT NULL,
  object_id BINARY(16) NOT NULL,
  output_id VARCHAR(128) NOT NULL,
  customer_id INT NOT NULL,
  count INT,
  output_price FLOAT DEFAULT 0,
  status VARCHAR(10),
  PRIMARY KEY (id),
  FOREIGN KEY (object_id) REFERENCES object(id),
  FOREIGN KEY (output_id) REFERENCES output_info(id),
  FOREIGN KEY (customer_id) REFERENCES customer(id)
);
GO

INSERT INTO unit (display_name)
VALUES ("kg"),
        ("unit"),
        ("m");

INSERT INTO supplier (display_name, address, phone, email, more_info, contract_date)
VALUES ("supplier1", "address1", "123456789", "supplier1@mail.com", "supplier1 more information", "2024-08-05 21:57:41.190000"),
        ("supplier2", "address2", "123456799", "supplier2@mail.com", "supplier2 more information", "2024-08-05 21:57:41.190000"),
        ("supplier3", "address3", "123456789", "supplier3@mail.com", "supplier3 more information", "2024-08-05 21:57:41.190000");

INSERT INTO object (display_name, unit_id, supplier_id, qr_code, bar_code)
VALUES ("object1", 1, 1, "0x01", "0x01"),
        ("object2", 2, 2, "0x02", "0x02"),
        ("object3", 3, 2, "0x03", "0x03"),
        ("object4", 1, 3, "0x04", "0x04"),
        ("object5", 3, 1, "0x05", "0x05");

INSERT INTO user_role (display_name)
VALUES ("user"),
        ("admin"),
        ("root");

INSERT INTO user (display_name, username, password, role_id)
VALUES ("user1", "username1", "123", 1),
        ("user2", "username2", "123", 2),
        ("user3", "username3", "123", 3);

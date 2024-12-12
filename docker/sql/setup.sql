CREATE DATABASE IF NOT EXISTS java_app;
GO

USE java_app;
GO

CREATE TABLE supplier (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50),
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
  name VARCHAR(50),
  address VARCHAR(100),
  phone VARCHAR(20),
  email VARCHAR(100),
  more_info VARCHAR(200),
  contract_date DATETIME,
  PRIMARY KEY (id)
);
GO

CREATE TABLE product (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50),
  supplier_id INT NOT NULL,
  quantity INT,
  created_at DATETIME,
  update_at DATETIME,
  FOREIGN KEY (supplier_id) REFERENCES supplier(id),
  PRIMARY KEY (id)
);
GO

CREATE TABLE payment_method (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);
GO

CREATE TABLE order_table (
  id INT NOT NULL AUTO_INCREMENT,
  customer_id INT NOT NULL,
  order_date DATETIME,
  status VARCHAR(10) NOT NULL,
  total_amount INT NOT NULL,
  payment_method_id INT NOT NULL,
  created_at DATETIME,
  updated_at DATETIME,
  FOREIGN KEY (customer_id) REFERENCES customer(id),
  FOREIGN KEY (payment_method_id) REFERENCES payment_method(id),
  PRIMARY KEY (id)
);
GO

CREATE TABLE order_detail (
  id INT NOT NULL AUTO_INCREMENT,
  order_id INT NOT NULL,
  product_id INT NOT NULL,
  quantity INT,
  price FLOAT,
  FOREIGN KEY (order_id) REFERENCES order_table(id),
  FOREIGN KEY (product_id) REFERENCES product(id),
  PRIMARY KEY (id)
);
GO

CREATE TABLE import_product (
  id INT NOT NULL AUTO_INCREMENT,
  input_date DATETIME,
  PRIMARY KEY (id)
);
GO

CREATE TABLE import_product_detail (
  id INT NOT NULL AUTO_INCREMENT,
  product_id INT NOT NULL,
  import_id INT NOT NULL,
  quantity INT,
  FOREIGN KEY (product_id) REFERENCES product(id),
  FOREIGN KEY (import_id) REFERENCES import_product(id),
  PRIMARY KEY (id)
);
GO

INSERT INTO supplier (name, address, phone, email, more_info, contract_date)
VALUES ("supplier1", "address1", "123456789", "supplier1@mail.com", "supplier1 more information", "2024-08-05 21:57:41.190000"),
("supplier2", "address2", "123456799", "supplier2@mail.com", "supplier2 more information", "2024-08-05 21:57:41.190000"),
("supplier3", "address3", "123456789", "supplier3@mail.com", "supplier3 more information", "2024-08-05 21:57:41.190000");

INSERT INTO customer (name, address, phone, email, more_info, contract_date)
VALUES ("customer1", "address-c1", "234523501", "customer1@mail.com", "customer1 more information", "2024-08-05 21:57:41.190000"),
("customer2", "address-c2", "234523501", "customer2@mail.com", "customer2 more information", "2024-08-05 21:57:41.190000"),
("customer3", "address-c3", "234523501", "customer3@mail.com", "customer3 more information", "2024-08-05 21:57:41.190000");

INSERT INTO product (name, supplier_id, quantity, created_at, update_at)
VALUES ("product1", 1, 100, "2024-08-05 21:57:41.190000", NULL),
("product2", 2, 10, "2024-08-05 21:57:41.190000", NULL),
("product3", 3, 5, "2024-08-05 21:57:41.190000", NULL),
("product4", 1, 3, "2024-08-05 21:57:41.190000", NULL),
("product5", 3, 67, "2024-08-05 21:57:41.190000", NULL);

INSERT INTO payment_method (name)
VALUES ("CREDIT_CARD"), ("PAYPAL"), ("CASH_ON_DELIVERY");

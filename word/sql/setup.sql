CREATE DATABASE IF NOT EXISTS word_app;
GO

USE word_app;
GO

CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT,
  display_name VARCHAR(50),
  username VARCHAR(100),
  password VARCHAR(100),
  PRIMARY KEY (id)
);
GO

CREATE TABLE category (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(50),
  user_id INT NOT NULL,
  create_at DATETIME,
  update_at DATETIME,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user(id)
);
GO

CREATE TABLE pair (
  id INT NOT NULL AUTO_INCREMENT,
  en VARCHAR(255),
  vi VARCHAR(255),
  category_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (category_id) REFERENCES category(id)
);
GO

INSERT INTO user (display_name, username, password)
VALUES ("peter1", "peter1", "$2a$10$dyBaBpKlQpEkjx06.SqNceta6JruZNMrI1m.rcPchF0hHLPSZen16");

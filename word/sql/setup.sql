CREATE DATABASE IF NOT EXISTS word_app;
GO

USE java_app;
GO

CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT,
  display_name VARCHAR(50),
  username VARCHAR(100),
  password VARCHAR(100),
  PRIMARY KEY (id)
);
GO

CREATE TABLE category {
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(50),
  user_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user(id)
}

CREATE TABLE pair {
  id INT NOT NULL AUTO_INCREMENT,
  en VARCHAR(50),
  vi VARCHAR(50),
  category_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (category_id) REFERENCES category(id)
}

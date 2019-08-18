-- Creating database.
CREATE DATABASE Shop_front;

-- Using database.
USE shop_front;

-- Creating table user.
CREATE TABLE User (
email_id VARCHAR(30) NOT NULL,
Name VARCHAR(30) NOT NULL,
DOB DATE,
phn_no BIGINT NOT NULL,
CONSTRAINT PK_user PRIMARY KEY(email_id)
);

-- Specialization of table user by creating table shopper.
CREATE TABLE shopper (
email_id VARCHAR(30) PRIMARY KEY REFERENCES user(user_id)
);

-- Specialization of table user by creating table administrator.
CREATE TABLE administrator (
email_id VARCHAR(30) PRIMARY KEY REFERENCES user(user_id)
);

-- Creating orders table.
CREATE TABLE orders (
Order_id INT PRIMARY KEY AUTO_INCREMENT,
order_timestamp TIMESTAMP NOT NULL DEFAULT current_timestamp,
shopper_mail Varchar(30) NOT NULL,
total_amount DECIMAL(9,2),
CONSTRAINT FK_order FOREIGN KEY(shopper_mail) REFERENCES shopper(email_id)
);

-- Creating table for products.
CREATE TABLE products (
p_id INT PRIMARY KEY,
p_Name VARCHAR(30) NOT NULL,
p_Price DECIMAL(7,2) NOT NULL,
availability BOOLEAN NOT NULL
-- FOREIGN KEY(image_id) REFERENCES images(image_id)
);

-- Creating table for storing images.
CREATE TABLE images (
image_id INT PRIMARY KEY,
P_id INT NOT NULL REFERENCES products(p_id),
image_link VARCHAR(30) DEFAULT 'https//google.co.in/images'
);
 desc images;

-- Creating table order_items.
CREATE TABLE order_items (
product_id INT,
order_id INT,
itm_price decimal(9, 2) NOT NULL,
quantity INT(2) DEFAULT 1,
ordr_status Varchar(30) NOT NULL DEFAULT "PENDING",
FOREIGN KEY (order_id) REFERENCES orders(order_id),
FOREIGN KEY (product_id) REFERENCES products(p_id),
PRIMARY KEY (product_id, order_id)
); 
desc order_items;

-- Creating table categories.
CREATE TABLE categories (
c_id INT UNIQUE,
category_Name VARCHAR(30) PRIMARY KEY,
parent_category VARCHAR(30) DEFAULT "Top category",
CONSTRAINT FK_categories FOREIGN KEY(parent_category) REFERENCES categories(category_Name)
);

-- Creating junction table products_categories.
CREATE TABLE products_categories (
product_id INT  NOT NULL REFERENCES products(p_id),
category_id INT NOT NULL REFERENCES categories(c_id),
CONSTRAINT PK_pro_categories PRIMARY KEY(product_id, category_id)
);

-- Creating table shipping_address.
CREATE TABLE shipping_address (
address_id INT PRIMARY KEY AUTO_INCREMENT,
shopper_mail VARCHAR(30) NOT NULL REFERENCES shopper(email_id),
country VARCHAR(30) NOT NULL,
state VARCHAR(30) NOT NULL,
postal_code INT(6) NOT NULL,
city VARCHAR(30) NOT NULL,
area VARCHAR(30) NOT NULL,
house_no INT NOT NULL
);

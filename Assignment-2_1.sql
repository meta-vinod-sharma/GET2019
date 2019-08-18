-- Assignment#1

/* Query#1 : Create all tables of eCommerce Application:  StoreFront  covered in Session 1 
 * Assignments. (Write all CREATE commands in a SQL file and run that SQL File). 
 */
-- Inserting into user table
INSERT INTO user VALUES ("bk9929@gmail.com","Bhupendra Kumawat",'1996-05-07',08852060530);
INSERT INTO user VALUES ("vinodSharma@gmail.com","VInod Sharma",'1996-05-02',9785226344);
INSERT INTO user VALUES ("vinayPancholi@gmail.com","Vinay Pancholi",'1996-05-18',9785666666);
INSERT INTO user VALUES ("AvneetDhaliwalmps@gmail.com","Avneet Kaur",'1998-12-29',7232821414);

-- Inserting data into administrator
INSERT INTO administrator VALUES ("bk9929@gmail.com");
INSERT INTO administrator VALUES ("vinodsharma@gmail.com");

-- Inserting data into shoppers
INSERT INTO shopper VALUES ("bk9929@gmail.com");
INSERT INTO shopper VALUES ("avneetDhaliwalmps@gmail.com");
INSERT INTO shopper VALUES ("vinayPancholi@gmail.com");

-- Inserting into products.
INSERT INTO products (`p_id`, `p_Name`, `p_Price`, `availability`) VALUES (1, 'SONY BRAVIA TV', 49000, 1);
INSERT INTO products (`p_id`, `p_Name`, `p_Price`, `availability`) VALUES (2, 'Ogeneral AC', 55000, 1);
INSERT INTO products (`p_id`, `p_Name`, `p_Price`, `availability`) VALUES (3, 'Fossil Watch', 12000, 1);
INSERT INTO products (`p_id`, `p_Name`, `p_Price`, `availability`) VALUES (4, 'Trimmer', 3000, 1);
INSERT INTO products (`p_id`, `p_Name`, `p_Price`, `availability`) VALUES (5, 'Adidas Shoes', 7999, 1);
INSERT INTO products (`p_id`, `p_Name`, `p_Price`, `availability`) VALUES (6, 'Peanut Butter', 350, 1);
INSERT INTO products (`p_id`, `p_Name`, `p_Price`, `availability`) VALUES (7, 'Shirt', 1299, 1);
INSERT INTO products (`p_id`, `p_Name`, `p_Price`, `availability`) VALUES (8, 'Jeans', 1799, 0);


-- Inserting into orders.
INSERT INTO orders (`Order_id`, `shopper_mail`, `total_amount`) VALUES (1, 'avneetDhaliwalmps@gmail.com', 5555);
INSERT INTO orders (`Order_id`, `shopper_mail`, `total_amount`) VALUES (2, 'bk9929@gmail.com', 9999);
INSERT INTO orders (`Order_id`, `shopper_mail`, `total_amount`) VALUES (3, 'bk9929@gmail.com', 11119);
INSERT INTO orders (`Order_id`, `order_timestamp`, `shopper_mail`, `total_amount`) VALUES ('4', '2019-01-21 11:27:39', 'avneetDhaliwalmps@gmail.com', '100.00');
INSERT INTO orders (`Order_id`, `order_timestamp`, `shopper_mail`, `total_amount`) VALUES ('5', '2019-02-21 11:27:39', 'avneetDhaliwalmps@gmail.com', '1000');
INSERT INTO orders (`Order_id`, `order_timestamp`, `shopper_mail`, `total_amount`) VALUES ('6', '2019-05-21 11:27:39', 'bk9929@gmail.com', '500');

-- Inserting into order_items.
INSERT INTO order_items (`product_id`, `order_id`, `itm_price`) VALUES (1, 1, 49000);
INSERT INTO order_items (`product_id`, `order_id`, `itm_price`) VALUES (3, 1, 12000);
INSERT INTO order_items (`product_id`, `order_id`, `itm_price`) VALUES (6, 1, 350);
INSERT INTO order_items (`product_id`, `order_id`, `itm_price`) VALUES (2, 2, 55000);
INSERT INTO order_items (`product_id`, `order_id`, `itm_price`) VALUES (4, 2, 3000);

-- Inserting into categories.
INSERT INTO categories (`c_id`, `category_Name`, `parent_category`) VALUES (1, 'Top category', 'Top category');
INSERT INTO categories (`c_id`, `category_Name`) VALUES (2, 'Electronics');
INSERT INTO categories (`c_id`, `category_Name`) VALUES (3, 'Men');
INSERT INTO categories (`c_id`, `category_Name`) VALUES (4, 'Women');
INSERT INTO categories (`c_id`, `category_Name`, `parent_category`) VALUES (5, 'Phones', 'Electronics');
INSERT INTO categories (`c_id`, `category_Name`, `parent_category`) VALUES (6, 'Appliances', 'Electronics');
INSERT INTO categories (`c_id`, `category_Name`, `parent_category`) VALUES (7, 'TV', 'Appliances');
INSERT INTO categories (`c_id`, `category_Name`, `parent_category`) VALUES (8, 'Mobile Devices', 'Electronics');
INSERT INTO categories (`c_id`, `category_Name`, `parent_category`) VALUES (9, 'iPhones', 'Mobile Devices');

-- Inserting into products_categories.
INSERT INTO products_categories (`product_id`, `category_id`) VALUES (1, 6);
INSERT INTO products_categories (`product_id`, `category_id`) VALUES (2, 6);
INSERT INTO products_categories (`product_id`, `category_id`) VALUES (1, 2);
INSERT INTO products_categories (`product_id`, `category_id`) VALUES (2, 2);
INSERT INTO products_categories (`product_id`, `category_id`) VALUES (4, 2);
INSERT INTO products_categories (`product_id`, `category_id`) VALUES (5, 3);
INSERT INTO products_categories (`product_id`, `category_id`) VALUES (7, 3);

-- Inserting int shipping_address.
INSERT INTO shipping_address (`address_id`, `shopper_mail`, `country`, `state`, `postal_code`, `city`, `area`, `house_no`) VALUES (1, "bk9929@gmail.com", 'INDIA', 'RAJASTHAN', 302001, 'Jaipur', 'indira Bazar', 1900);
INSERT INTO shipping_address (`address_id`, `shopper_mail`, `country`, `state`, `postal_code`, `city`, `area`, `house_no`) VALUES (2, "vinayPancholi@gmail.com", 'INDIA', 'RAJASTHAN', 302017, 'Jaipur', 'JAGATPURA', 256);
INSERT INTO shipping_address (`address_id`, `shopper_mail`, `country`, `state`, `postal_code`, `city`, `area`, `house_no`) VALUES (3, "bk9929@gmail.com", 'INDIA', 'MAHARASHTRA', 202222, 'MUMBAI', 'DOMBIVILI', 702);

-- Query#2 : Write a command to display all the table names present in StoreFront.
SHOW TABLES;

-- Query#3 : Write a command to remove  Product  table of the StoreFront database.
SAVEPOINT sp1;
DROP TABLE products;

-- Query#4 : Create the  Product  table again.
ROLLBACK TO sp1;

-- Extra Queries.
SELECT * from products;
SELECT * from shipping_address;
SELECT * from user;
SELECT * from shopper;
SELECT * from orders;
SELECT * from order_items;
SELECT * FROM categories;
SELECT * FROM products_categories;
DESC products;
USE shop_front;
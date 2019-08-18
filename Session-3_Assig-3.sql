-- Assignment # 3

-- Query#1: Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT u.name AS Shopper_Name, count(o.order_id) AS No_Of_Orders 
FROM user u
LEFT JOIN shopper s ON u.email_id = s.email_id
LEFT JOIN orders o ON s.email_id = o.shopper_mail
WHERE TIMESTAMPDIFF(DAY, o.order_timestamp, CURRENT_TIMESTAMP) <= 30 
GROUP BY o.shopper_mail ;

-- Query#2: Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT u.Name, SUM(o.total_amount) AS Revenue 
FROM user u
LEFT JOIN shopper s ON u.email_id = s.email_id
LEFT JOIN orders o ON s.email_id = o.shopper_mail
WHERE TIMESTAMPDIFF(DAY, o.order_timestamp, CURRENT_TIMESTAMP) < 30
GROUP BY s.email_id 
ORDER BY SUM(o.total_amount) DESC ;

-- Query#3: Display top 20 Products which are ordered most in last 60 days along with numbers. 	
SELECT p.p_Name, SUM(oi.quantity )  AS No_Of_Units_Ordered 
FROM products p
LEFT JOIN order_items oi ON p.p_id = oi.product_id
LEFT JOIN orders o ON oi.order_id = o.order_id
WHERE TIMESTAMPDIFF(DAY, o.order_timestamp, CURRENT_TIMESTAMP) < 60
GROUP BY p.p_id
ORDER BY No_Of_Units_Ordered DESC 
LIMIT 20;

-- Query#4: Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT MONTHNAME(DATE(o.order_timestamp)) AS MONTH , SUM(o.total_amount) AS REVENUE 
FROM orders o
WHERE TIMESTAMPDIFF(MONTH, o.order_timestamp, CURRENT_TIMESTAMP) < 6
GROUP BY MONTH(o.order_timestamp)
ORDER BY MONTH(o.order_timestamp) DESC;

-- Query#5: Mark the products as Inactive which are not ordered in last 90 days.
SELECT p.p_Name , o.order_timestamp 
FROM products p 	
LEFT JOIN order_items oi ON p.p_id = oi.product_id
LEFT JOIN orders o ON oi.order_id = o.order_id
-- SET p.availability = 0 
 WHERE p.p_id NOT IN (SELECT product_id 
 FROM order_items oi 
 WHERE oi.order_id NOT IN (
 SELECT order_id FROM orders 
 WHERE  TIMESTAMPDIFF(DAY, o.order_timestamp, CURRENT_TIMESTAMP) > 90));
 
-- Query#6: Given a category search keyword, display all the Products present in this category/categories.
SELECT c.category_Name, p.p_Name 
FROM products p
LEFT JOIN products_categories pc ON p.p_id = pc.product_id
LEFT JOIN categories c ON pc.category_id = c.c_id
WHERE  c.category_Name = 'Electronics' OR 'Grocery' OR 'Men';

-- Query#7: Display top 10 Items which were cancelled most.
SELECT p.p_id, p.p_Name, count(p.p_id) AS No_Of_Cancellations 
FROM products p
LEFT JOIN order_items oi ON p.p_id = oi.product_id
WHERE ordr_status = "Cancelled"
GROUP BY p.p_id
ORDER BY No_Of_Cancellations DESC;
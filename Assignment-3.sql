-- ASSIGNMENT#3

-- QUERY#1 : Display Recent 50 Orders placed (Id, Order Date, Order Total). 
SELECT * FROM orders ORDER BY order_timestamp DESC LIMIT 50;

-- QUERY#2 : Display 10 most expensive Orders
SELECT * FROM orders ORDER BY total_amount DESC LIMIT 10;

/* Query#3 : Display all the Orders which are placed more than 10 days old 
 * and one or more items from those orders are still not shipped.
 */
SELECT * 
FROM orders, order_items 
WHERE orders.order_id = order_items.order_id 
AND DATEDIFF(CURRENT_TIMESTAMP(), orders.order_timestamp) > 10 
AND order_items.ordr_status = "PENDING";

-- Query#4 : Display list of shoppers which haven't ordered anything since last month. 
SELECT * FROM  user 
WHERE email_id = 
(SELECT shopper_mail 
FROM  orders 
WHERE MONTH(order_timestamp) < MONTH(current_date()) 
OR year(order_timestamp) < YEAR(CURRENT_DATE()));

-- Query#5 : Display list of shopper along with orders placed by them in last 15 days.  
SELECT shopper.email_id, orders.order_id, orders.order_timestamp 
FROM orders INNER JOIN shopper ON orders.shopper_mail = shopper.email_id  
WHERE DATEDIFF(CURDATE(), DATE(order_timestamp)) <= 15;

/* Query#6 : Display list of order items which are in “shipped” state for particular 
 * Order Id (i.e.: 1020)).
 */
SELECT * FROM order_items WHERE ordr_status = "Shipped";

/*Query#7 : Display list of order items along with order placed date which fall between 
 * Rs 20 to Rs 50 price.
 */
SELECT products.p_Name, DATE(orders.order_timestamp), order_items.itm_price
FROM order_items 
INNER JOIN products 
INNER JOIN orders 
WHERE order_items.product_id = products.p_id 
AND order_items.itm_price BETWEEN 20000 AND 60000;

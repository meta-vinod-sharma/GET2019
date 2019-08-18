-- Assignment#5

/* Query#1: Create a view displaying the order information (Id, Title, Price, Shopper’s name, 
  Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days.
  */
CREATE VIEW view1 AS
SELECT oi.order_id, p.p_Name, oi.itm_price, u.Name AS Shopper_Name, o.shopper_mail, DATE(o.order_timestamp) AS Order_Date, oi.ordr_status AS Status
FROM order_items oi 
LEFT JOIN products p ON p.p_id = oi.product_id
LEFT JOIN orders o ON oi.order_id = o.order_id
LEFT JOIN user u ON o.shopper_mail = u.email_id
WHERE TIMESTAMPDIFF(DAY, o.order_timestamp, CURRENT_TIMESTAMP) < 60
ORDER BY o.order_timestamp DESC; 

-- Displays view1.
Select * FROM view1;

-- Query#2: Use the above view to display the Products(Items) which are in ‘shipped’ state. 
SELECT p_Name FROM view1
WHERE status = 'Shipped';

-- Query#3: Use the above view to display the top 5 most selling products.
SELECT p_Name, COUNT(p_Name) AS Units_sold FROM view1 
GROUP BY p_NAME HAVING Units_sold <= 2 
LIMIT 5;
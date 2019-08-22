use store_front;

-- Query 1--> Create a function to calculate number of orders in a month. Month and year will be input parameter to function.


DELIMITER $$
CREATE FUNCTION no_of_orders(month INT, year INT)
RETURNS int 
DETERMINISTIC
BEGIN

DECLARE total_orders int;

SELECT count(Order_id) into total_orders FROM orders 
WHERE MONTH(order_timestamp) = month AND YEAR(order_timestamp) = year;

return  total_orders;
END $$

select no_of_orders(08, 2019);



-- Query 2 --> Create a function to return month in a year having maximum orders. Year will be input parameter.


DELIMITER $$
CREATE FUNCTION max_of_orders(year INT)
RETURNS int 
DETERMINISTIC
BEGIN

DECLARE max_order_month int;
DECLARE total_orders int;

SELECT MONTH(order_timestamp) as month into max_order_month  FROM orders 
WHERE YEAR(order_timestamp) = year
GROUP BY month order by count(Order_id) desc limit 1;

return  max_order_month;
END $$
DELIMITER ;



select max_of_orders(2019);






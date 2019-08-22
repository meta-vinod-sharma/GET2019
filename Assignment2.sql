-- Assignmnet # 2 

/* Query#1 : Create a Stored procedure to retrieve average sales of each product in a month. Month and year 
 * will be input parameter to function.
 */
 DROP PROCEDURE IF EXISTS Average_Sale;
 
DELIMITER $$
CREATE PROCEDURE Average_Sale(month INT, year INT)
    BEGIN
	SELECT p.p_Name AS Product_Name, SUM(oi.quantity) / month AS AVERAGE_SALE
	FROM products p
	LEFT JOIN order_items oi ON p.p_id = oi.product_id 
	LEFT JOIN orders o ON oi.order_id = o.order_id
	AND MONTH(o.order_timestamp) <=  month AND YEAR(o.order_timestamp) = year
	GROUP BY p.p_Name
    ORDER BY AVERAGE_SALE DESC; 
    END $$    
DELIMITER ;

   -- Procedure Calling Average_Sale;
CALL  Average_Sale(8, 2019);

/* Query#2 : Create a stored procedure to retrieve table having order detail with status for a given period. 
 * Start date and end date will be input parameter. Put validation on input dates like start date is less than 
 * end date. If start date is greater than end date take first date of month as start date.
 */
DROP PROCEDURE IF EXISTS order_Detail;

DELIMITER $$
CREATE PROCEDURE Order_Detail(start_date DATE, end_date DATE)
	BEGIN
    DECLARE temp_year INT;
    DECLARE temp_month INT;
    DECLARE temp_date VARCHAR(10);
    
    --  Validation on input dates like start_date is less than end_date. 
    IF(start_date > end_date) THEN 
		SET temp_year = (SELECT YEAR(end_date));
		SET temp_month = (SELECT MONTH(end_date));
        SET temp_date = (SELECT CONCAT(temp_year, '-', temp_month, '-', '01'));
		SET start_date = (SELECT CAST(temp_date AS DATE));
	END IF;
		SELECT * 
        FROM order_items 
        WHERE order_id IN (
        SELECT order_id
        FROM orders
        WHERE DATE(order_timestamp) BETWEEN start_date AND end_date);
	END $$
    DELIMITER ;
	
    -- Procedure Calling order_Detail.
    CALL order_Detail('2019-08-03', '2019-08-20');
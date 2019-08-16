/*
Assignment 5:
Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days.
*/


CREATE VIEW OrderDetails AS SELECT
    U.Name As User_NAME , U.Email AS User_email, P.Id AS Product_Id , P.Price As Product_Price, P.Name As Product_Name, O.user_Id AS User_ID, O.Status AS PRODUCT_STATUS , O.order_Date AS ORDER_DATE
FROM
    ORDERS O,
    orderitem I,
    User U,
    Product P
WHERE
    o.Order_Id = I.Order_Id AND  DATEDIFF(now(), O.order_Date) < 60 AND  U.Id = O.User_Id  AND P.Id = I.Product_Id
ORDER BY  O.order_Date DESC;

SELECT * FROM OrderDetails;


SELECT 
    PRODUCT_NAME, PRODUCT_ID, PRODUCT_PRICE, PRODUCT_STATUS
FROM
    OrderDetails
WHERE
    PRODUCT_STATUS = 'P';

SELECT 
    PRODUCT_NAME, COUNT(PRODUCT_ID) AS TOTAL_ORDER
FROM
    OrderDetails
GROUP BY PRODUCT_ID
ORDER BY COUNT(PRODUCT_ID) DESC
LIMIT 5;
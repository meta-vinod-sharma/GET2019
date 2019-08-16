/*
Display Shopper’s information along with number of orders he/she placed during last 30 days.
*/
SELECT 
    user.*, COUNT(orders.order_id)
from
    orders,
    user
WHERE
    (DATEDIFF(now(), orders.order_date) < 30 AND user.id = orders.user_id)
GROUP BY orders.user_id;

/*
Display the top 10 Shoppers who generated maximum number of revenue in last 30 days
*/
select * from orderitem;
select * from orders;

SELECT 
    user.*, SUM(orderitem.total) AS MAX_REVENUE
from
    orders,
    user,
    orderitem
WHERE
    DATEDIFF(now(), orders.order_date) < 30 AND orderitem.order_id = orders.order_id AND user.id = orders.user_id GROUP BY orders.user_id DESC limit 10;
    
/*
    Display top 20 Products which are ordered most in last 60 days along with numbers.
*/
select * from orders;
select 
    product.name, count(o.product_id) as freq
from
    orders as o
        inner join
    product ON product.product_id = o.product_id
where
    o.order_date >= DATE_SUB('2008-12-12', INTERVAL 60 DAY)
group by product.product_title
order by freq desc
limit 10;

/*
Given a category search keyword, display all the Products present in this category/categories
*/
SELECT product.* 
FROM product , product_category,categories
Where product.id = product_category.product_id AND categories.type = 't-shirt' AND categories.id = product_category.category_id;

/*
Mark the products as Inactive which are not ordered in last 90 days.
*/
SELECT 
   *
FROM
   PRODUCT
WHERE
   ID NOT IN (SELECT DISTINCT
       PRODUCT_ID
   FROM
       ORDERITEM I
           LEFT JOIN
       ORDERS O ON O.ORDER_ID = I.ORDER_ID AND DATEDIFF(now(), O.order_Date) < 90);





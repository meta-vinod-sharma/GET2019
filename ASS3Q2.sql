/*
Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
*/
SELECT 
    product.id,
    product.name,
    COUNT(DISTINCT p.category_id) AS Total_category
from
    product,
    product_category p
WHERE
    (p.product_id = product.id)
GROUP BY p.product_id
HAVING COUNT(p.product_id) > 1  ;

/*
Display the Categories along with number of products under each category.
*/
select 
    *
from
    product_category;
SELECT 
    c.*, COUNT(DISTINCT p.product_id) AS Total_product
from
    category c,
    product_category p
WHERE
    (p.category_id = c.id)
GROUP BY p.category_id
HAVING COUNT(p.product_id) > 0  ;

/*
Display Count of products as per below price range:

Range in Rs.   Count
0 - 100
101 - 50
Above 500
*/
SELECT 
    price, count(*) No_of_products
FROM
    (SELECT 
        CASE
                WHEN price >= 0 AND price <= 100 THEN '0 - 100'
                WHEN price > 101 AND price <= 500 THEN '101 - 500'
                ELSE 'Above 500'
            END AS price
    FROM
        product) AS count_of_products
GROUP BY price;



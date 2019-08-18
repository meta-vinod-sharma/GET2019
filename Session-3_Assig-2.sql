-- Assignment#2
-- Query#1: Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories. 
SELECT count(p.p_Id) AS cat_count, p.* 
FROM products_categories pc 
LEFT JOIN products p
ON pc.product_id = p.p_id 
GROUP BY p.p_id  HAVING cat_count > 1;

-- Query#2: Display Count of products as per below price range.
SELECT p_price, Count(*) COUNT_OF_PRODUCTS FROM 
(SELECT 
CASE 
WHEN p_price BETWEEN 0 AND 100 THEN '0 - 100' 
WHEN p_price BETWEEN 101 AND 500 THEN '101 - 500' 
WHEN p_price > 500 THEN 'Above 500' END AS p_price
FROM products) AS COUNT_OF_PRODUCTS 
GROUP BY p_price;

-- Query#3: Display the Categories along with number of products under each category.
SELECT c.category_Name, count(p.p_id) AS Products_count 
FROM categories c
LEFT JOIN products_categories pc ON c.c_id = pc.category_id
LEFT JOIN products p ON pc.product_id = p.p_id
GROUP BY c.category_Name;

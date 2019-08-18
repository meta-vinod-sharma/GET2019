-- Assignment#2

-- Query 1
SELECT * FROM products ;

/* Query#2 : Display Id, Title, Category Title, Price of the products which are Active and 
 *          recently added products should be at top. 
 */
SELECT DISTINCT products.p_id, products.p_Name, products_categories.category_id, 
products.p_price, products.availability, categories.category_Name
FROM products 
LEFT JOIN products_categories ON products.p_id = products_categories.product_id 
LEFT JOIN categories ON categories.c_id = products_categories.category_id
WHERE products_categories.category_id = categories.c_id 
AND products.availability > 0;

-- Query#3 : Display the list of products which don't have any images.
SELECT * FROM products 
WHERE p_id NOT IN (
SELECT DISTINCT p_id 
FROM images);

/* Query#4 : Display all Id, Title and Parent Category Title for all the Categories listed, 
 * sorted by Parent Category Title and then Category Title. (If Category is top category 
 * then Parent Category Title column should display “Top Category” as value.) 
 */
SELECT * FROM categories ORDER BY parent_category, category_name;

-- Query#5 : Display Id, Title, Parent Category Title of all the leaf Categories.
SELECT * FROM categories WHERE category_Name NOT IN (SELECT parent_category FROM categories); 

/* Query#6 : Display Product Title, Price & Description which falls into particular 
 * category Title (i.e. “Mobile”).
 */
SELECT products.p_Name,products.p_Price 
FROM products, products_categories,categories 
WHERE products_categories.category_id = categories.c_id 
AND categories.category_Name = "Mobile" 
AND products.p_id = products_categories.product_id;

-- Query#7 : Display the list of Products whose Quantity on hand (Inventory) is under 50.
SELECT * FROM  products WHERE availability < 50;
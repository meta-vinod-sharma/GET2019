-- Assignment # 3

-- Queries : Identify the columns require indexing in order, product, category tables and create indexes. 

ALTER TABLE products
ADD INDEX product_name_index(p_Name);

ALTER TABLE products
ADD INDEX product_price_index(p_price);

ALTER TABLE categories
ADD INDEX category_id_index(c_id);

ALTER TABLE images
ADD INDEX image_link_index(image_link);

SHOW INDEX FROM products;
SHOW INDEX FROM categories;
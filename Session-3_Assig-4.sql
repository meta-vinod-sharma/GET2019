-- Assignment#4

/* Query#1: Create appropriate tables and relationships for the same and write a SQL query 
			for that returns a Resultset containing Zip Code, City Names and States ordered 
            by State Name and City Name. 
 */
CREATE TABLE states (
s_id INT(3) PRIMARY KEY, 
s_Name VARCHAR(30) NOT NULL);

CREATE TABLE cities (
c_id INT(3) PRIMARY KEY, 
s_id INT(3) NOT NULL REFERENCES state(s_id), 
c_Name VARCHAR(30) NOT NULL);

CREATE TABLE zipcode (
zipcode INT(6) PRIMARY KEY, 
c_id INT(3)  NOT NULL REFERENCES cities(c_id), 
s_id INT(3) NOT NULL REFERENCES state(s_id));

-- Inserting data into states.
INSERT INTO states (`s_id`, `s_Name`) VALUES ('1', 'Rajasthan');
INSERT INTO states (`s_id`, `s_Name`) VALUES ('2', 'Madhya Pradesh');
INSERT INTO states (`s_id`, `s_Name`) VALUES ('3', 'Maharashtra');
INSERT INTO states (`s_id`, `s_Name`) VALUES ('4', 'Gujrat');

-- Inserting data into cities.
INSERT INTO cities (`c_id`, `s_id`, `c_Name`) VALUES ('1', '1', 'Jaipur');
INSERT INTO cities (`c_id`, `s_id`, `c_Name`) VALUES ('2', '1', 'Jodhpur');
INSERT INTO cities (`c_id`, `s_id`, `c_Name`) VALUES ('3', '1', 'Udaipur');
INSERT INTO cities (`c_id`, `s_id`, `c_Name`) VALUES ('4', '1', 'Ajmer');
INSERT INTO cities (`c_id`, `s_id`, `c_Name`) VALUES ('8', '2', 'Ujjain');
INSERT INTO cities (`c_id`, `s_id`, `c_Name`) VALUES ('9', '2', 'Indore');
INSERT INTO cities (`c_id`, `s_id`, `c_Name`) VALUES ('10', '2', 'Bhopal');
INSERT INTO cities (`c_id`, `s_id`, `c_Name`) VALUES ('5', '3', 'Mumbai');
INSERT INTO cities (`c_id`, `s_id`, `c_Name`) VALUES ('6', '3', 'Pune');
INSERT INTO cities (`c_id`, `s_id`, `c_Name`) VALUES ('7', '3', 'Nagpur');
INSERT INTO cities (`c_id`, `s_id`, `c_Name`) VALUES ('11', '4', 'Ahmedabad');
INSERT INTO cities (`c_id`, `s_id`, `c_Name`) VALUES ('12', '4', 'Surat');


-- Inserting data into zipcode
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('302001', '1', '1');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('302002', '1', '1');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('302003', '1', '1');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('302004', '1', '1');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('302005', '1', '1');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('302006', '1', '1');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('302007', '1', '1');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('302008', '1', '1');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('302009', '1', '1');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('302010', '1', '1');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('400001', '5', '3');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('400002', '5', '3');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('400003', '5', '3');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('400004', '5', '3');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('456001', '8', '2');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('456006', '8', '2');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('456010', '8', '2');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('456664', '8', '2');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('411000', '6', '3');
INSERT INTO zipcode (`zipcode`, `c_id`, `s_id`) VALUES ('411001', '6', '3');

-- Main Query
SELECT s.s_Name, c.c_Name, z.zipcode FROM states s
LEFT JOIN cities c ON s.s_id = c.s_id
LEFT JOIN zipcode z ON c.c_id = z.c_id
ORDER BY s.s_Name, c.c_Name DESC;

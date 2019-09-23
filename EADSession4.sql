show databases;
drop database MetaCube_Parking;
create database MetaCube_Parking;

use MetaCube_Parking;
create table employee_details(
  regId int primary key auto_increment,
  firstName varchar(30),
  lastName varchar(30),
  gender VARCHAR(6) CHECK (gender IN ('Male','Female')) ,
  email varchar(50) unique,
  password varchar(20),
  contact varchar(10),
  organization varchar(30) 

);
create table vehicle (
regId int primary key,
vehicle_name varchar(20),
vehicle_type varchar(20) CHECK (vehicle_type IN ('Cycle','MotorCycle','Four Wheelers')),
vehicle_number varchar(20),
Identification varchar(100),
foreign key (regId) references employee_details(regId) 
       ON DELETE CASCADE ON UPDATE CASCADE
);
create table passDetails(
regId int primary key,
plan varchar(20) check (plan in ('Daily' , 'Monthly' ,'Yearly')),
price int ,
foreign key (regId) references employee_details(regId) 
       ON DELETE CASCADE ON UPDATE CASCADE
);

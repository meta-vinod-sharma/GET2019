package com.metacube.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

		
		static String host = "jdbc:mysql://localhost:3306/";
		static String dbName = "student";
		static String mysqlURL = host + dbName;
		
	public static Connection getConnection(){
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(mysqlURL, "root","root");
		} catch (ClassNotFoundException | SQLException cnfe) {
			System.out.println("Error loding driver :" + cnfe);
		}
		return con;
	}
}

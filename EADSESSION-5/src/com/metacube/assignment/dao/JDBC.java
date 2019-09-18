package com.metacube.assignment.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
	public static Connection getConnection() {
		
		String host = "jdbc:mysql://localhost:3306/";
		String dbName = "SHOPPING_APP";
		String mysqlURL = host + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(mysqlURL, "root", "root");
			return connection;
		} catch (ClassNotFoundException e) {
			throw new AssertionError("class not found");
		} catch (SQLException e) {
			throw new AssertionError("SQL connection not found");
		}
	}
}

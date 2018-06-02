package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil{
private final String user="MyCat";
private final String pwd="java12";
private final String url="jdbc:sqlserver://127.0.0.1:1433;databasename=MyDB";
private Connection connection;
private static DataBaseUtil dataBaseUtil=new DataBaseUtil();
private DataBaseUtil() {
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
public boolean testDataBase() {
	 try {
		connection=DriverManager.getConnection(url,user, pwd);
		connection.close();
	} catch (SQLException e) {
		return false;
	}
	 return true;
}
public Connection getConnection() throws Exception {
		return DriverManager.getConnection(url, user, pwd);
}
public static DataBaseUtil getInstance() {
	return dataBaseUtil;
}
}

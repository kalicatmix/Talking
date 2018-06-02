package com.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

public class Register {
	private String sql;
	private Statement statement;
	private Connection connection;
  public Register(String name,String password) {
		sql = "insert into dbo.users values('" + name + "'" + ",'" + password + "'" + ",NULL);";
		try {
			connection = DataBaseUtil.getInstance().getConnection();
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
	}  
  }
  public boolean insert() {
		try {
			statement.executeUpdate(sql);
			statement.close();
			connection.close();
		} catch (Exception e) {
			return false;
		}
		return true;
  }
}
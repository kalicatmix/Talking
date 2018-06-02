package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class IpAddress {
	private static Connection connection;
	private static Statement statement;
private IpAddress() {	
}
public static String getIp(String name) {
	try {
		connection=DataBaseUtil.getInstance().getConnection();
		statement=connection.createStatement();
		ResultSet set=statement.executeQuery("select ip from dbo.address where name='"+name+"';");
		if(set.next()) {
			return set.getString(1);
		}
		return null;
	}catch (Exception e) {
		return null;
	}
}
}

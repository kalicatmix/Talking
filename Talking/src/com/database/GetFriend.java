package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
public class GetFriend {
	private static HashMap<String,String>status=new HashMap<>();
private GetFriend() {
	
}
public static ArrayList friendList(){
	ArrayList<String>list=new ArrayList<>();
	Connection connection;
	Statement statement;
	try {
		connection=DataBaseUtil.getInstance().getConnection();
		statement=connection.createStatement();
		ResultSet friendlist=statement.executeQuery("select * from dbo.users;");
		while(friendlist.next()) {
			list.add(friendlist.getString("name"));
			status.put(friendlist.getString("name"),friendlist.getString("status"));
		}
		connection.close();
		statement.close();
	} catch (Exception e) {
		return null;
	}
	return list;
}
public static HashMap<String,String>getStatus(){
	return status;
}
}

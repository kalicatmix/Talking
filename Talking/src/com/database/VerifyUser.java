package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class VerifyUser {
 private static String sql;
 private static Connection connection;
 private static Statement statement;
 private static String pwd1;
 public static String user;
 private VerifyUser() {	 
 }
 public static boolean verifyUser(String name,String pwd) throws SQLException {
	 //simply verify
	 if(!StringValidator.verifyName(name))return false;
	 if(!StringValidator.verifyPwd(pwd))return false;
	 //cost verify
	 
	 sql="select pwd from dbo.users where name ='"+name+"';";
	 try {
     connection=DataBaseUtil.getInstance().getConnection();
     statement=connection.createStatement();
	 ResultSet set=statement.executeQuery(sql);
	 if(set.next())
		  pwd1=set.getObject("pwd").toString();
	 }catch(Exception e) {
		 return false;
	 }finally {
		statement.close();
		connection.close();
	}
	 if(pwd1.equals(pwd)) {user=name;return true;}
	 return false;
 } 
}

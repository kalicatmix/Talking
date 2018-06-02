package com.database;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.window.Toast;

import javafx.scene.chart.PieChart.Data;

public class Online {
	 private static java.sql.Connection connection;
	 private static Statement statement;
     private Online() {
    	 
     }
    public static boolean setStatusOnline(String name) {
    	try {
			connection=DataBaseUtil.getInstance().getConnection();
			statement=connection.createStatement();
			statement.executeUpdate("update dbo.users set status='1' where name='"+name+"';");
			statement.close();
			connection.close();
			return true;
		} catch (Exception e) {
			//new Toast("¸Ä±ä×´Ì¬´íÎó",Color.red).start();
			e.printStackTrace();
			return false;
		}
    	
    }
    public static boolean setStatusOffLine(String name) {
    	try {
    		connection=DataBaseUtil.getInstance().getConnection();
    		statement=connection.createStatement();
    		statement.executeUpdate("update dbo.users set status=NULL where name='"+name+"';");
    		statement.close();
    		connection.close();
    		return true;
    	}catch (Exception e) {
    		e.printStackTrace();
			return false;
		}
    }
    public static boolean getStatus(String name) {
    	 try {
    		 connection=DataBaseUtil.getInstance().getConnection();
    		 statement=connection.createStatement();
    		 ResultSet set=statement.executeQuery("select status from dbo.users where name='"+name+"';");
    		 set.next();	
    		 if(set.getString(1).equals("1")) {
    			 return true;
    		 }
    		 return false;
    	 }catch (Exception e) {
			return false;
		}
    }
}

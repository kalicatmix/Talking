package com.window;

import java.awt.Frame;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import com.chat.ChatMan;
import com.chat.CurrentTime;
import com.database.GetFriend;
import com.database.IpAddress;
import com.database.Logging;
import com.database.Online;
import com.database.Register;
import com.database.StringValidator;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.swing.internal.plaf.basic.resources.basic;

import sun.rmi.runtime.Log;

public class Test {
    public static void main (String args[]) throws Exception{
    	/*JFrame frame=new JFrame();
    	frame.setSize(200, 200);
    	frame.setLocation(500, 100);
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       new Chat("world", frame).setVisible(true);  
       new Chat("world",frame).setVisible(true);*/ 	    
    ChatMan man1=new ChatMan(1024,InetAddress.getByName("127.0.0.1"),null);
    ChatMan man2=new ChatMan(1024, InetAddress.getByName("127.0.0.2"),null);
    man1.start();
    man2.start();
   // man2.sendString("hello",1024,man1.socket.getLocalAddress());
    man1.sendString("ÄãºÃÂð",1024,man2.socket.getLocalAddress());
    man1.sendString("are you ok,jerry",1024,man2.socket.getLocalAddress());
   
}}

package com.chat;

import java.awt.Color;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.spi.CharsetProvider;

import com.sun.org.glassfish.external.statistics.Statistic;
import com.window.TalkingPanel;
import com.window.Toast;

import jdk.internal.dynalink.beans.StaticClass;
import sun.security.ssl.SSLServerSocketFactoryImpl;

public class ChatMan extends Thread{
   public DatagramSocket socket;
   public int port;
   private String text=null;
   private static DatagramPacket receive_packet;
   private static DatagramPacket send_packet;
   private TalkingPanel panel;
   private byte buffer[]=new byte[20];
   public String getText() throws UnsupportedEncodingException {
	text=new String(buffer,"GBK");
	return text;
}
   public ChatMan(int port,InetAddress address,TalkingPanel panel){
	this.panel=panel;
    this.port=port;
    try {
	socket=new DatagramSocket(port,address);
    }catch(SocketException e) {
    	
    }
	receive_packet=new DatagramPacket(buffer,buffer.length);
  }
   @Override
   public void run() {
	   while(true) {
		 try {
			socket.setSoTimeout(1);
			socket.receive(receive_packet);
			changePanel(getText());
		} catch (IOException e) {
		 //fix bug
		}
	   }
   }
   public void sendString(String text,int port,InetAddress address) throws UnknownHostException {
	   send_packet=new DatagramPacket(text.getBytes(),text.getBytes().length,address,port);
	   try {
		socket.send(send_packet);
	} catch (IOException e) {
		System.out.println(e.toString());
	   new Toast("∑¢ÀÕ ß∞‹",Color.red).start();
	}
   }
   public void changePanel(String text) {
	   panel.addRight(text);
	 //  System.out.println(text);
   }
}

package com.window;
import java.awt.Color;
import java.awt.FocusTraversalPolicy;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.stream.events.StartDocument;

import com.chat.ChatMan;
import com.chat.VeriryString;
import com.database.GetFriend;
import com.database.IpAddress;
import com.database.Online;
import com.database.VerifyUser;
import com.sun.glass.ui.Menu;
import com.sun.xml.internal.ws.api.Component;
import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import javafx.beans.binding.ObjectExpression;
import sun.util.resources.cldr.es.CalendarData_es_AR;
public class Chat extends JFrame{
  private String name;
  private JLabel namex;
  private String online="离线";
  private TalkingPanel panel;
  private JTextField talk;
  private String ip;
  private ChatMan chatMan;
  public void start() {
		ip=IpAddress.getIp(VerifyUser.user);
		//start listen
		if(ip.equals("null")) {
		new Toast("初始化回话错误",Color.red).start();
		}else {
			try {
			chatMan=new ChatMan(1024,InetAddress.getByName(ip),panel);
			chatMan.start();
			}catch (Exception e) {
				new Toast("初始化回话错误",Color.red).start();
			}
		}
	}
  public Chat(String name) {
	  //check online
	  if(Online.getStatus(name))online="在线";
	  this.setResizable(false);
	 // this.setLocationRelativeTo(component);
	  this.setLocation(400, 300);
	  this.setSize(1000,800);
      this.setLayout(null);
      JLabel background=new JLabel();
      background.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("image/glass.jpg").getScaledInstance(1000, 1000, Image.SCALE_SMOOTH)));
      background.setBounds(0, 0, 1000, 800);
      namex=new JLabel("当前用户:"+VerifyUser.user+"  对方昵称:"+name+"状态:"+online);
      namex.setFont(new Font("微软雅黑",Font.HANGING_BASELINE,40));
      namex.setBounds(100, 0, 700, 100);
      panel=new TalkingPanel();
      JScrollPane pane=new JScrollPane(panel);
      pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      pane.setBounds(100, 100, 800, 400);
      CustomButton send=new CustomButton("发送消息");
      CustomButton clear=new CustomButton("清除消息");
      send.setBounds(0,500,200,200);
      clear.setBounds(780,500,200,200);
      talk=new JTextField();
      talk.setFont(new Font("微软雅黑",Font.CENTER_BASELINE, 30));
      talk.setBackground(Color.white);
      talk.setForeground(Color.gray);
      talk.setColumns(30);
      talk.setBounds(200, 500, 580, 100);
      send.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(online.equals("在线")) {
			if(talk.getText().length()>15) {
				 new Toast("内容过长",Color.red).start();
				 talk.setText("");
			 }else {
			  panel.addLeft(talk.getText());
			  try {
				chatMan.sendString(VeriryString.verifyString(talk.getText()),1024,InetAddress.getByName(IpAddress.getIp(name)));
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
				new Toast("ip错误",Color.red).start();
			}
			 }
			}else {
				new Toast("对方不在线",Color.red).start();
				talk.setText("");
			}
		}
    	  
	});
      clear.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			panel.clear();
		}	  
	});
      //menu
      JMenuBar bar=new JMenuBar();
      JMenu menu=new JMenu("菜单");
      Font font=new Font("微软雅黑", Font.CENTER_BASELINE,30);
      menu.setFont(font);
      menu.setForeground(Color.pink);
      menu.setAutoscrolls(true);
      menu.setVisible(true);
      JMenuItem open=new JMenuItem("打开官网");
      JMenuItem log=new JMenuItem("打开日志");
      JMenuItem join=new JMenuItem("加入我们");
      open.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		try {
			Runtime.getRuntime().exec("C:\\Users\\kalicat\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe www.qq.com");
		} catch (IOException e1) {
			new Toast("请检查浏览器,发生错误",Color.red).start();;
		}
		}
	});
      log.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Runtime.getRuntime().exec("C:\\Windows\\explorer.exe C:\\eclipseworkplace\\Talking\\log");
			} catch (IOException e1) {
			  new Toast("错误,请检查问题",Color.red).start();
			}
		}
	});
      join.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Runtime.getRuntime().exec("C:\\Users\\kalicat\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe https://github.com/kalicatmix");
			} catch (IOException e1) {
		    new Toast("请检查浏览器,发生错误",Color.red).start();;
			}
		}
	});
      open.setForeground(Color.pink);
      log.setForeground(Color.pink);
      join.setForeground(Color.pink);
      open.setFont(font);
      log.setFont(font);
      join.setFont(font);;
      menu.add(open);
      menu.add(log);
      menu.add(join);
      bar.add(menu);
      //start listen
	  start();
      this.setJMenuBar(bar);
      this.add(talk);
      this.add(namex);
      this.add(pane);
      this.add(send);
      this.add(clear);
      this.add(background);
      this.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			Chat.this.dispose();
			chatMan.stop();
			chatMan.interrupt();
		}
		 
	});
  }
 
}

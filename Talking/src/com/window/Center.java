package com.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import com.chat.ChatMan;
import com.database.IpAddress;
import com.database.Online;
import com.database.VerifyUser;
import com.sun.javafx.fxml.builder.JavaFXFontBuilder;
import com.sun.org.apache.xerces.internal.impl.dtd.models.DFAContentModel;
import com.sun.prism.Image;
import com.sun.xml.internal.ws.org.objectweb.asm.Label;

public class Center extends RootWindow {
	private JPanel up=new JPanel();
	private JPanel top=new JPanel();
	private Friend fd=new Friend();
	private Setting sg=new Setting();
	private About at=new About();
	public Center() {
		//set status
		Online.setStatusOnline(VerifyUser.user);
		this.setLayout(null);
		up.setBounds(0, 0, 1000, 100);
		up.setLayout(null);
		JLabel background=new JLabel();
		ImageIcon icon=new ImageIcon(Toolkit.getDefaultToolkit().getImage("image/transparent.jpg").getScaledInstance(1000, 100, java.awt.Image.SCALE_SMOOTH));
		background.setIcon(icon);
		Font font=new Font("微软雅黑", Font.ITALIC,50);
		JLabel friendx=new JLabel("我的好友");
		JLabel settingx=new JLabel("设置");
		JLabel aboutx=new JLabel("关于");
		friendx.setFont(font);
		settingx.setFont(font);
		aboutx.setFont(font);
		background.setBounds(0, 0, 1000, 100);
		friendx.setBounds(100, 0, 300, 100);
		settingx.setBounds(500,0, 300, 100);
		aboutx.setBounds(800, 0, 300, 100);
		up.add(friendx);
		up.add(settingx);
		up.add(aboutx);
		up.add(background);
		top.setBounds(0, 100,1000, 200);
	    top.setLayout(new GridLayout(1, 3));
	    JLabel friend=new JLabel();
	    JLabel setting=new JLabel();
	    JLabel about=new JLabel();
	    friend.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("image/live.png").getScaledInstance(333,200, java.awt.Image.SCALE_DEFAULT)));
	    setting.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("image/operator.png").getScaledInstance(333, 200, java.awt.Image.SCALE_SMOOTH)));
	    about.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("image/world.png").getScaledInstance(333, 200, java.awt.Image.SCALE_SMOOTH)));
		friend.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				sg.setVisible(false);
				at.setVisible(false);
				fd.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseEntered(e);
				friendx.setForeground(Color.gray);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				friendx.setForeground(Color.pink);
			}
			
			
		});
		setting.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				fd.setVisible(false);
				at.setVisible(false);
				sg.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseEntered(e);
				settingx.setForeground(Color.gray);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				settingx.setForeground(Color.pink);
			}
			
		});
		about.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				fd.setVisible(false);
				sg.setVisible(false);
				at.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseEntered(e);
				aboutx.setForeground(Color.gray);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				aboutx.setForeground(Color.pink);
			}
				
		});
	    top.add(friend);
	    top.add(setting);
	    top.add(about);
	    fd.setVisible(true);
		this.add(up);
		this.add(top);
		this.add(fd);
		this.add(sg);
		this.add(at);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Online.setStatusOffLine(VerifyUser.user);
			}
		});
	}
}

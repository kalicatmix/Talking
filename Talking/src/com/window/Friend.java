package com.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.util.Date;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

import com.chat.ChatMan;
import com.database.GetFriend;
import com.database.IpAddress;
import com.database.Online;
import com.database.VerifyUser;

import jdk.internal.dynalink.beans.StaticClass;

public class Friend extends RootPanel{
 private static String s="当前时间: ";
 private static JLabel currentTime=new JLabel();
 private JTree root;
 private javax.swing.Timer timer;
 private Chat chat;
 private DefaultMutableTreeNode friend,family,cluter[];
   public Friend() {
	this.setLayout(null);
	JLabel background=new JLabel();
	background.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("image/glass.jpg").getScaledInstance(1000, 700, Image.SCALE_SMOOTH)));
    background.setBounds(0, 0, 1000, 700);
    currentTime.setFont(new Font("微软雅黑",Font.ITALIC,50));
    currentTime.setBounds(0, 00, 1000, 100);
    currentTime.setForeground(Color.gray);
    timer=new javax.swing.Timer(500, new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
			currentTime.setText(s+new Date().toString());
		}
	});
    timer.start();
    DefaultMutableTreeNode node=new DefaultMutableTreeNode("我的联系人");
    friend=new DefaultMutableTreeNode("我的朋友");
    family=new DefaultMutableTreeNode("我的家人");
    cluter =new DefaultMutableTreeNode[GetFriend.friendList().size()];
    for(int i=0;i<cluter.length;i++) {
    	if(GetFriend.friendList().get(i).equals(VerifyUser.user)) {
    		cluter[i]=null;
    		continue;
    	}
    	cluter[i]=new DefaultMutableTreeNode(GetFriend.friendList().get(i));
    	friend.add(cluter[i]);
    }
    node.add(friend);
    node.add(family);
    root=new JTree(node);
    root.addTreeSelectionListener(new TreeSelectionListener() {
		
		@Override
		public void valueChanged(TreeSelectionEvent e) {
			 for(int i=0;i<cluter.length;i++) {
				 if(cluter[i]==null)continue;
		    	  if(cluter[i].hashCode()==e.getPath().hashCode()) { 
		    		   chat=new Chat(GetFriend.friendList().get(i).toString());
		    		   chat.setVisible(true);
		    		   break;	  
		       }
			}
	}});
    DefaultTreeCellRenderer renderer=(DefaultTreeCellRenderer) root.getCellRenderer();
    renderer.setOpenIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("image/Super.png")));
    renderer.setClosedIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("image/internet.png")));
    renderer.setLeafIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("image/iron.png")));
    root.setFont(new Font("微软雅黑",Font.PLAIN,30));
    root.setBackground(Color.gray);
    JScrollPane panel=new JScrollPane(root);
    panel.setBounds(0, 100, 1000, 400);
    panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    this.add(currentTime);
    this.add(panel);
    this.add(background);
}
}

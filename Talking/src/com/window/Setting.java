package com.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import com.sun.org.apache.xpath.internal.operations.String;
import com.sun.xml.internal.ws.api.Component;

import jdk.internal.org.objectweb.asm.Label;

public class Setting extends RootPanel{
	private JList list;
	private JLabel label;
	public Setting() {
	this.setLayout(null);
	Font font=new Font("微软雅黑",Font.ITALIC,50);
	java.lang.String set[]={"设置时间","设置界面","设置好友","设置自己"};
	list=new JList(set);
	list.setForeground(Color.PINK);
	list.setFont(font);
	list.setBounds(400, 0, 250, 300);
	label=new JLabel();
	label.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("image/gxgreen.png").getScaledInstance(1000, 700, Image.SCALE_FAST)));
	label.setBounds(0, 0, 1000, 700);
	this.add(list);
	this.add(label);
    }
}
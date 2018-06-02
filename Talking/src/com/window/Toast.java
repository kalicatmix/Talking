package com.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class Toast extends Thread{
   private JDialog dialog;
   private JLabel label;
   public Toast(String text,Color color) {
	dialog=new JDialog();
	dialog.setUndecorated(true);
	dialog.setLayout(null);
	dialog.setLocation(300,500);
	dialog.setResizable(false);
	dialog.setSize(1000,100);
	dialog.setBackground(Color.white);
	label=new JLabel(text);
	label.setBounds(300, 0, 500, 100);
	label.setForeground(color);
	label.setFont(new Font("Î¢ÈíÑÅºÚ",Font.ITALIC,40));
	dialog.add(label);
}
	@Override 
	public void run() {
		dialog.setVisible(true);
	    try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    dialog.dispose();
	}
	
}

package com.window;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ProgressBarUI;

import com.sun.glass.ui.Timer;
import com.sun.prism.Image;

import sun.security.jca.GetInstance;

public class Loading extends RootWindow{
	private JLabel label,label2[];
	private JProgressBar bar;
	private int x=500;
	private int y=500;
	public static  int value=0;
	private javax.swing.Timer timer;
    public Loading() {
		this.setLayout(null);
		label=new JLabel();
		java.awt.Image image=getToolkit().getImage("image/load.jpg").getScaledInstance(this.framex,this.framey,java.awt.Image.SCALE_SMOOTH);
	    label.setIcon(new ImageIcon(image));
	    label.setBounds(0, 0, framex, framey);
	    label2=new JLabel[50];
	    java.awt.Image image1=getToolkit().getImage("image/main.gif").getScaledInstance(500,500,java.awt.Image.SCALE_SMOOTH);
	    for(int i=0;i<50;i++) {
	    	label2[i]=new JLabel(new ImageIcon(image1));
	    	label2[i].setBounds(getRandom(), getRandom(), x, y);
	    }
	    bar=new JProgressBar();
	    bar.setMaximum(100);
	    bar.setBounds(0,framey/2,framex,100);
	    bar.setStringPainted(true);
	    Font font=new Font("Î¢ÈíÑÅºÚ",Font.CENTER_BASELINE,50);
	    bar.setFont(font);
	    bar.setString("welcome to talking");
	    this.add(bar);
	    for(int i=0;i<50;i++) {
	    	this.add(label2[i]);
	    }
	    this.add(label);
	    this.startProgress();
    }
	private static int getRandom() {
		int x=-1;
		while(true) {
			x=(int) (Math.random()*1000);
			if(x>=0&&x<1000){
				break;
			}
		}
		return x;
	}
	public void startProgress() {
		 timer=new javax.swing.Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				value+=10;
				bar.setValue(value);
              if(value>100) {
            	  timer.stop();
            	  new Login().setVisible(true);
            	  Loading.this.dispose();
              }
			}
		});
		timer.start();
	}
}

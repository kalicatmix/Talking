package com.window;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.sun.prism.Image;
public class RootWindow  extends JFrame{
	private int screenx=Toolkit.getDefaultToolkit().getScreenSize().width;
	private int screeny=Toolkit.getDefaultToolkit().getScreenSize().height;
    protected int framex=1000;
    protected int framey=1000;
	public RootWindow() {
   this.setSize(framex,framey);
   this.setLocation(screenx/4,0);
   this.setTitle("talking");
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   this.setResizable(false);
}
	public java.awt.Image getImageInstance(String location) {
		return Toolkit.getDefaultToolkit().getImage(location);
	}
}
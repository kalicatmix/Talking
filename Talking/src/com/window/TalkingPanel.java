package com.window;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.chat.CurrentTime;
public class TalkingPanel extends JTextArea{
 public TalkingPanel() {
	 this.setEditable(false);
	 this.setFont(new Font("Î¢ÈíÑÅºÚ",Font.HANGING_BASELINE,40));
	 this.setColumns(20); 
	 this.setForeground(Color.pink);
}
 public String spaceKey() {
	 String string="";
	 for(int i=0;i<40;i++) {
		 string+=" ";
	 }	
	 return string;
 }
 public void addRight(String s) {

	 this.append(spaceKey());
	 this.append(CurrentTime.currentTime()+"\n");
	 this.append(spaceKey());
	 this.append(s);
	 this.append("\n");
 }
 public void addLeft(String s) {
	 this.append(CurrentTime.currentTime()+"\n");
	 this.append(s);
	 this.append("\n");
 }
 public void clear() {
	this.setText("");
 }
}

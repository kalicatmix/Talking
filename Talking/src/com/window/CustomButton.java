package com.window;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import jdk.internal.dynalink.beans.StaticClass;

public class CustomButton extends Component {
	private String text;
	private static Font font=new Font("Î¢ÈíÑÅºÚ",Font.HANGING_BASELINE,50);
    public CustomButton(String text) {
		this.text=text;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.gray);
		g.fillOval(0, 0, 200, 200);
		g.setColor(Color.pink);
		g.setFont(font);
		g.drawString(text.substring(0, 2),50,100);
		if(text.length()>2) {
			g.drawString(text.substring(2, 4),50,150);
		}
	}

}

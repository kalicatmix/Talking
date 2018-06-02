package com.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import sun.awt.image.ToolkitImage;

public class About extends RootPanel {
    private JTabbedPane panel;
    private JPanel auther,copyright,date,about_us;
	public About() {
	this.setLayout(new GridLayout(1, 1));
	panel=new JTabbedPane();
	panel.setAutoscrolls(true);
	Font font=new Font("微软雅黑",Font.ITALIC,50);
	panel.setFont(font);
	auther=new JPanel();
	copyright=new JPanel();
	date=new JPanel();
	about_us=new JPanel();
	JTextArea copyrightx=new JTextArea();
	copyrightx.setEditable(false);
	copyrightx.setFont(font);
	copyrightx.setText(getString("腾讯公司对其发行的或与合作伙伴共同发行的作品享有版权，受各国版权法及国际版权公约的保护. 对于上述版权内容，超越合理使用范畴、并未经本公司书面许可的使用行为，我公司均保留追究法律责任的权利."));
	copyrightx.setForeground(Color.gray);
	copyright.setLayout(new GridLayout(1, 1));
	copyright.add(copyrightx);
	JTextArea autherx=new JTextArea();
	JLabel label=new JLabel();
	label.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("image/transparent.jpg").getScaledInstance(1000, 700, Image.SCALE_DEFAULT)));
	label.setBounds(0, 0, 1000, 700);
	autherx.setBounds(0,150, 1000, 330);
	autherx.setEditable(false);
	autherx.setFont(font);
	autherx.setForeground(Color.gray);
	auther.setLayout(null);
	autherx.setText(getString("我是看着童话故事、听着童话故事、梦想着童话故事长大的…最后我发现，每一个童话故事背后都有一个心思缜密且足够温柔的作者。而现实世界背后…无人执笔。"));
	auther.add(autherx);
	auther.add(label);
	JLabel label2=new JLabel();
	label2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("image/red.jpg").getScaledInstance(1000, 700, Image.SCALE_FAST)));
    label2.setBounds(0, 0, 1000, 700);
    date.setLayout(null);
    date.add(label2);
	JTextArea aboutx=new JTextArea();
	aboutx.setFont(font);
	aboutx.setText(getString("你撑把油纸伞 笑叹缘分几笔 皆徒然 我路过青石板 静听花开一束 落长安"));
	aboutx.setEditable(false);
	about_us.setLayout(new GridLayout(1, 1));
	about_us.add(aboutx);
	panel.addTab("版权",copyright);
	panel.addTab("关于作者",auther);
	panel.addTab("日期",date);
	panel.addTab("关于我们",about_us);
	this.add(panel);
}
	public String getString(String s) {
		StringBuilder string=new StringBuilder(s);
		for(int i=0,j=0;i<string.length();i++) {
			if(j>=18) {
				string.insert(i, "\n");
				j=0;
			}
			j++;
		}
		return string.toString();
	}
}


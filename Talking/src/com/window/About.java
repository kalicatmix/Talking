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
	Font font=new Font("΢���ź�",Font.ITALIC,50);
	panel.setFont(font);
	auther=new JPanel();
	copyright=new JPanel();
	date=new JPanel();
	about_us=new JPanel();
	JTextArea copyrightx=new JTextArea();
	copyrightx.setEditable(false);
	copyrightx.setFont(font);
	copyrightx.setText(getString("��Ѷ��˾���䷢�еĻ��������鹲ͬ���е���Ʒ���а�Ȩ���ܸ�����Ȩ�������ʰ�Ȩ��Լ�ı���. ����������Ȩ���ݣ���Խ����ʹ�÷��롢��δ������˾������ɵ�ʹ����Ϊ���ҹ�˾������׷���������ε�Ȩ��."));
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
	autherx.setText(getString("���ǿ���ͯ�����¡�����ͯ�����¡�������ͯ�����³���ġ�����ҷ��֣�ÿһ��ͯ�����±�����һ����˼�������㹻��������ߡ�����ʵ���米������ִ�ʡ�"));
	auther.add(autherx);
	auther.add(label);
	JLabel label2=new JLabel();
	label2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("image/red.jpg").getScaledInstance(1000, 700, Image.SCALE_FAST)));
    label2.setBounds(0, 0, 1000, 700);
    date.setLayout(null);
    date.add(label2);
	JTextArea aboutx=new JTextArea();
	aboutx.setFont(font);
	aboutx.setText(getString("��Ű���ֽɡ Ц̾Ե�ּ��� ��ͽȻ ��·����ʯ�� ��������һ�� �䳤��"));
	aboutx.setEditable(false);
	about_us.setLayout(new GridLayout(1, 1));
	about_us.add(aboutx);
	panel.addTab("��Ȩ",copyright);
	panel.addTab("��������",auther);
	panel.addTab("����",date);
	panel.addTab("��������",about_us);
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


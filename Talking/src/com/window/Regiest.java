package com.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.database.Register;
import com.database.StringValidator;
import com.sun.glass.events.MouseEvent;
import com.sun.glass.ui.TouchInputSupport;

import javafx.scene.image.Image;
public class Regiest extends RootWindow{
	private RootWindow window;
	private JTextField user;
	private JPasswordField password;
    public Regiest(RootWindow window) {
       this.window=window;
       this.addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosed(WindowEvent e) {
		   window.setEnabled(true);
		   window.setVisible(true);
		}
    	   
	});
	   this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   Font font=new Font("微软雅黑", Font.ROMAN_BASELINE,50);
	   user=new JTextField();
	   password=new JPasswordField();
	   user.setFont(font);
	   password.setFont(font);
	   user.setBounds(200, 230, 700, 150);
	   password.setBounds(200, 430, 700, 150);
	   JLabel userx=new JLabel("用户");
	   userx.setFont(font);
	   userx.setBounds(0, 200, 200, 200);
	   userx.setForeground(Color.pink);
	   JLabel passwordx=new JLabel("密码");
	   passwordx.setFont(font);
	   passwordx.setBounds(0, 400, 200, 200);
	   passwordx.setForeground(Color.pink);
	   JLabel background=new JLabel();
	   background.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage("image/gxgreen.png").getScaledInstance(1000, 1000, java.awt.Image.SCALE_SMOOTH)));
	   background.setBounds(0, 0, 1000, 1000);
	   this.setLayout(null);
	   CustomButton confirm=new CustomButton("立即注册");
	   confirm.setBounds(400, 700, 200, 200);
	   confirm.addMouseListener(new MouseAdapter() {
		   @Override 
		   public void mouseClicked(java.awt.event.MouseEvent e) {
			   if(StringValidator.verifyName(user.getText())) {
				   if(StringValidator.verifyPwd(password.getText())) {	   
				if (new Register(user.getText(), password.getText()).insert()) {
					new Toast("注册成功", Color.green).start();
					Regiest.this.dispose();
					window.setEnabled(true);
					window.setVisible(true);
					} else {		
					new Toast("注册失败", Color.red).start();
				}
				}else {
				 new Toast("密码格式不对",Color.red).start();
				 }
				}else {
					new Toast("账户格式不对",Color.red).start();
				}
		   }
	});
	   this.add(userx);
	   this.add(passwordx);
	   this.add(user);
	   this.add(password);
	   this.add(confirm);
	   this.add(background);
    } 
}

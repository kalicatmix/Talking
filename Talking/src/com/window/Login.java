package com.window;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import com.database.Logging;
import com.database.Online;
import com.database.VerifyUser;
public class Login extends RootWindow{
private JLabel background=new JLabel();	
private JPanel top,midium,under;
private JTextField user;
private JPasswordField password;
public Login() {
	//����ʽ����
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(new GridLayout(3, 1));
	top=new JPanel();
	midium=new JPanel();
	under=new JPanel();
	//����1
	top.setLayout(null);
	Image image=getImageInstance("image/background.jpg");
	ImageIcon icon=new ImageIcon(image.getScaledInstance(1000,1000/3, Image.SCALE_SMOOTH));
	JLabel label=new JLabel();
    label.setIcon(icon);
    label.setBounds(0, 0, 1000, 333);
    Font font=new Font("΢���ź�",Font.ITALIC,100);
    JLabel top_text=new JLabel("��ӭ��½");
    top.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseEntered(e);
			top_text.setForeground(Color.gray);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			super.mouseExited(e);
			top_text.setForeground(Color.pink);
		}
		
    	
	});
    top_text.setForeground(Color.PINK);
    top_text.setFont(font);
    top_text.setBounds(300, 0, 500, 333);
   top.add(top_text);
   top.add(label);
    //����2
    midium.setLayout(null);
    JTextField name=new JTextField();
    name.setColumns(6);
    name.setToolTipText("����");
    JPasswordField field=new JPasswordField();
    field.setToolTipText("����");
    field.setColumns(6);
    Image image2=getImageInstance("image/background.jpg");
    ImageIcon icon2=new ImageIcon(image2.getScaledInstance(1000, 1000/3, Image.SCALE_FAST));
    JLabel background=new JLabel(icon2);
    background.setBounds(0,0,1000,1000/3);
    JLabel user_text=new JLabel("�û�");
    JLabel password_text=new JLabel("����");
    user_text.setFont(font);
    password_text.setFont(font);
    user_text.setBounds(0,0,220,150);
    password_text.setBounds(0,150, 220,150);
    password_text.setForeground(Color.pink);
    user_text.setForeground(Color.pink);
    user=new JTextField(10);
    password=new JPasswordField(6);
    user.setBounds(250,0,700,150);
    password.setBounds(250,150,700,150);
    user.setBackground(Color.gray);
    user.setMaximumSize(new Dimension(5, 1));
    user.setFont(font);
    user.setToolTipText("�����˻�");
    password.setBackground(Color.gray);
    password.setFont(font);
    password.setToolTipText("��������");
    midium.add(user_text);
    midium.add(password_text);
    midium.add(user);
    midium.add(password);
    midium.add(background);
    //����3
    under.setLayout(null);
    JLabel under_background=new JLabel();
    under_background.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("image/transparent.jpg").getScaledInstance(1000,333,Image.SCALE_SMOOTH)));
    under_background.setBounds(0, 0, 1000, 333);
    CustomButton press=new CustomButton("��½");
    press.setBounds(100,0, 200, 333);
    press.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			try {  
				  
					if (VerifyUser.verifyUser(user.getText(), password.getText())) {
						if(Online.getStatus(VerifyUser.user)) {
						new Toast("�û�������",Color.red).start();
						}else {
						new Center().setVisible(true);
						Login.this.dispose();
						Logging.log(VerifyUser.user);
						new Toast("��½�ɹ�", Color.green).start();
						}
					} else {
						new Toast("������˻�����", Color.red).start();
					}
			} catch (SQLException e1) {
			  new Toast("���ݿ����",Color.red).start();	
			} catch (Exception e1) {
				new Toast("io����",Color.red).start();
			}
		}
    	
	});
    CustomButton regist=new CustomButton("ע��");
    regist.setBounds(400, 0, 200, 333);
    regist.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			Login.this.setEnabled(false);
			new Regiest(Login.this).setVisible(true);
		}	
	});
    CustomButton forget=new CustomButton("��������");
    forget.setBounds(700, 0, 200, 333);
    forget.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				Runtime.getRuntime().exec("C:\\Users\\kalicat\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe https://aq.qq.com/v2/uv_aq/html/reset_pwd/pc_reset_pwd_input_account.html?v=4.0");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}		
	});
    under.add(press);
    under.add(regist);
    under.add(forget);
    under.add(under_background);
    //���𴰿�
    this.add(top);
    this.add(midium);
    this.add(under);
}
}
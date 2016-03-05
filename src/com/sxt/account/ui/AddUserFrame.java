package com.sxt.account.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sxt.account.dao.UserInfoDao;
/**
 * @功能：实现添加新用户
 * @author 张珊珊
 *@time 8.12
 */

public class AddUserFrame extends JFrame implements ActionListener{
	JTextField txt1=new JTextField(30); 
	JPasswordField pwd1=new JPasswordField();
	JPasswordField pwd2=new JPasswordField();
	JButton btn1=new JButton("确认");
	JButton btn2=new JButton("取消");
	public AddUserFrame(){
		
		init();
	}
	public void init(){
		//设置标题
		this.setTitle("添加用户");
		//设置大小
		this.setSize(400, 300);
		//设置位置(居中)
		this.setLocationRelativeTo(null);
		//设置关闭的行为
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//设置不可变
		this.setResizable(false);
		this.setLayout(null);
		
		JLabel lbl=new JLabel("欢迎您成为随手记新用户");
		lbl.setBounds(20, 20, 150, 40);
		this.add(lbl);
		
		JLabel lbl1=new JLabel("用户名:");
		JLabel lbl2=new JLabel("输入密码：");
		JLabel lbl3=new JLabel("确认密码：");
		
		
		
		lbl1.setBounds(50, 100, 80, 20);
		txt1.setBounds(150, 100, 150, 20);
		lbl2.setBounds(50, 130, 80, 20);
		pwd1.setBounds(150, 130, 150, 20);
		lbl3.setBounds(50, 160, 80, 20);
		pwd2.setBounds(150, 160, 150, 20);
		
		this.add(lbl1);
		this.add(lbl2);
		this.add(lbl3);
		this.add(txt1);
		this.add(pwd1);
		this.add(pwd2);
		
		
		btn1.setBounds(80, 230, 60, 25);
		btn2.setBounds(220, 230, 60, 25);
		btn1.addActionListener(this);
		this.add(btn1);
		this.add(btn2);	
		//添加图片
		JLabel lblPhoto=new JLabel();
		lblPhoto.setIcon(new ImageIcon("imgs/20.jpg"));
		lblPhoto.setBounds(180, 0, 350, 80);
		this.add(lblPhoto);
		
	    }
	public static void main(String[] args) {
		new AddUserFrame().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn1){
			String userName=txt1.getText().trim();
		    String pwd3=String.valueOf(pwd1.getPassword()).trim();
		    String pwd4=String.valueOf(pwd2.getPassword()).trim();
		    int len1=pwd3.length();
		    if(userName.isEmpty()){
				 JOptionPane.showMessageDialog(null, "用户名不能为空");
				 return;
			 }
			 if(pwd3.isEmpty() || pwd3.length() < 6){
				 JOptionPane.showMessageDialog(null, "密码不能为空或密码小于6位");
				 return;
			 }
		    if(pwd3.endsWith(pwd4)){
		    	 UserInfoDao uid=new UserInfoDao();
		 	    uid.addUser(userName,pwd3);
				JOptionPane.showMessageDialog(null, "用户注册成功");
		    }else if(pwd3!=pwd4){
				JOptionPane.showMessageDialog(null, "您两次输入的密码不一致，请重新输入");
				txt1.setText("");
				pwd1.setText("");
				pwd2.setText("");
		    }

		}
		if(e.getSource()==btn2){
			this.dispose();
			new LoginFrame().setVisible(true);
		}
		
	}

}

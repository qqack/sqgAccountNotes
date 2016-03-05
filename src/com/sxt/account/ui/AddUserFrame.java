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
 * @���ܣ�ʵ��������û�
 * @author ��ɺɺ
 *@time 8.12
 */

public class AddUserFrame extends JFrame implements ActionListener{
	JTextField txt1=new JTextField(30); 
	JPasswordField pwd1=new JPasswordField();
	JPasswordField pwd2=new JPasswordField();
	JButton btn1=new JButton("ȷ��");
	JButton btn2=new JButton("ȡ��");
	public AddUserFrame(){
		
		init();
	}
	public void init(){
		//���ñ���
		this.setTitle("����û�");
		//���ô�С
		this.setSize(400, 300);
		//����λ��(����)
		this.setLocationRelativeTo(null);
		//���ùرյ���Ϊ
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//���ò��ɱ�
		this.setResizable(false);
		this.setLayout(null);
		
		JLabel lbl=new JLabel("��ӭ����Ϊ���ּ����û�");
		lbl.setBounds(20, 20, 150, 40);
		this.add(lbl);
		
		JLabel lbl1=new JLabel("�û���:");
		JLabel lbl2=new JLabel("�������룺");
		JLabel lbl3=new JLabel("ȷ�����룺");
		
		
		
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
		//���ͼƬ
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
				 JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
				 return;
			 }
			 if(pwd3.isEmpty() || pwd3.length() < 6){
				 JOptionPane.showMessageDialog(null, "���벻��Ϊ�ջ�����С��6λ");
				 return;
			 }
		    if(pwd3.endsWith(pwd4)){
		    	 UserInfoDao uid=new UserInfoDao();
		 	    uid.addUser(userName,pwd3);
				JOptionPane.showMessageDialog(null, "�û�ע��ɹ�");
		    }else if(pwd3!=pwd4){
				JOptionPane.showMessageDialog(null, "��������������벻һ�£�����������");
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

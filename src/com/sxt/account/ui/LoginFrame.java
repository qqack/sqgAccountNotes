package com.sxt.account.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.theme.SubstanceLightAquaTheme;

import com.sxt.account.bean.UserInfo;
import com.sxt.account.dao.UserInfoDao;
import com.sxt.account.util.BackGroundPane;
/**
 * @���ܣ���½����ʵ��
 * @author ��ɺɺ
 *@time 8.9
 */
public class LoginFrame extends JFrame implements ActionListener{
	
	JLabel lblName=new JLabel("�û���");
	JLabel lblPwd=new JLabel("����");
	JLabel lblPhoto=new JLabel();
	JTextField   txtName  =new JTextField();
	JPasswordField  txtPwd = new JPasswordField();
	JButton  btnLogin =new JButton("��      ¼");
	JButton  btnCancel =new JButton("��      ��");
	JButton btnForget=new JButton("��������");
	JButton btnRegister=new JButton("ע�����û�");
	
	public LoginFrame(){
		init();
	}
	public void init(){
		
		//��ʼ��DAO
		dao = new UserInfoDao();
		//���ñ���
		this.setTitle("���ּ�");
		//���ô�С
		this.setSize(400, 370);
		//����λ��(����)
		this.setLocationRelativeTo(null);
		//����ͼ��
		 this.setIconImage(new ImageIcon("imgs/0.jpg").getImage());
		//���ùرյ���Ϊ
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//���ò��ɱ�
		this.setResizable(false);
		BackGroundPane  bgp =new BackGroundPane("imgs/2.jpg",400,370);
		this.setContentPane(bgp);	
		 this.setLayout(null);
		    lblName.setBounds(70, 180, 45, 20);
			lblPwd.setBounds(70, 220, 45, 20);
			txtName.setBounds(120,180,150,20);
			txtPwd.setBounds(120, 220, 150, 20);
			//��������ĸ�ʽ
			txtPwd.setEchoChar('*');
			btnLogin.setBounds(100, 260, 80, 20);
			btnCancel.setBounds(200, 260, 80, 20);
			btnRegister.setBounds(280, 310, 100, 20);
			
			btnLogin.addActionListener(this);
			btnCancel.addActionListener(this);
			btnRegister.addActionListener(this);
		
			//��Ӹ���������
			this.add(lblName);
			this.add(lblPwd);
			this.add(txtName);
			this.add(txtPwd);
			this.add(btnLogin);
			this.add(btnCancel);
			this.add(btnRegister);
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            UIManager.setLookAndFeel(new SubstanceLookAndFeel());
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            SubstanceLookAndFeel.setCurrentTheme(new SubstanceLightAquaTheme());

        } catch (Exception e) {
            System.err.println("Something went wrong!");
        }

		new LoginFrame().setVisible(true);
	}
	
	private UserInfoDao dao;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnLogin){
			//1.2��ȡ�û���������
			 String userName=  txtName.getText().trim();
			 //char[] ->String 
			 String uPwd=  String.valueOf(txtPwd.getPassword()).trim();
			 //1.2��֤Ϊ��
			 if(userName.isEmpty()){
				 JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
				 return;
			 }
			 if(uPwd.isEmpty() || uPwd.length() < 6){
				 JOptionPane.showMessageDialog(null, "���벻��Ϊ�ջ�����С��6λ");
				 return;
			 }
			try {
				boolean result = dao.findUser(userName, uPwd);
				if(result){
					
					//2.1�ɹ� ,��ת��������
					JOptionPane.showMessageDialog(null, userName+"�û���¼�ɹ�!");
					new MainFrame().setVisible(true);
					this.dispose();//�رմ���
				              											
				}else{
					//2.2ʧ��,��ʾ
					JOptionPane.showMessageDialog(null, "�û������������!");
					
				}
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		}
		if(e.getSource()==btnCancel){
			txtName.setText(null);
			txtPwd.setText(null);

		}
		if(e.getSource()==btnRegister){
			
			new AddUserFrame().setVisible(true);			

		}

	}
}




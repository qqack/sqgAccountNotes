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
 * @功能：登陆界面实现
 * @author 张珊珊
 *@time 8.9
 */
public class LoginFrame extends JFrame implements ActionListener{
	
	JLabel lblName=new JLabel("用户名");
	JLabel lblPwd=new JLabel("密码");
	JLabel lblPhoto=new JLabel();
	JTextField   txtName  =new JTextField();
	JPasswordField  txtPwd = new JPasswordField();
	JButton  btnLogin =new JButton("登      录");
	JButton  btnCancel =new JButton("清      除");
	JButton btnForget=new JButton("忘记密码");
	JButton btnRegister=new JButton("注册新用户");
	
	public LoginFrame(){
		init();
	}
	public void init(){
		
		//初始化DAO
		dao = new UserInfoDao();
		//设置标题
		this.setTitle("随手记");
		//设置大小
		this.setSize(400, 370);
		//设置位置(居中)
		this.setLocationRelativeTo(null);
		//设置图标
		 this.setIconImage(new ImageIcon("imgs/0.jpg").getImage());
		//设置关闭的行为
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//设置不可变
		this.setResizable(false);
		BackGroundPane  bgp =new BackGroundPane("imgs/2.jpg",400,370);
		this.setContentPane(bgp);	
		 this.setLayout(null);
		    lblName.setBounds(70, 180, 45, 20);
			lblPwd.setBounds(70, 220, 45, 20);
			txtName.setBounds(120,180,150,20);
			txtPwd.setBounds(120, 220, 150, 20);
			//设置密码的格式
			txtPwd.setEchoChar('*');
			btnLogin.setBounds(100, 260, 80, 20);
			btnCancel.setBounds(200, 260, 80, 20);
			btnRegister.setBounds(280, 310, 100, 20);
			
			btnLogin.addActionListener(this);
			btnCancel.addActionListener(this);
			btnRegister.addActionListener(this);
		
			//添加各组件到面板
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
			//1.2获取用户名和密码
			 String userName=  txtName.getText().trim();
			 //char[] ->String 
			 String uPwd=  String.valueOf(txtPwd.getPassword()).trim();
			 //1.2验证为空
			 if(userName.isEmpty()){
				 JOptionPane.showMessageDialog(null, "用户名不能为空");
				 return;
			 }
			 if(uPwd.isEmpty() || uPwd.length() < 6){
				 JOptionPane.showMessageDialog(null, "密码不能为空或密码小于6位");
				 return;
			 }
			try {
				boolean result = dao.findUser(userName, uPwd);
				if(result){
					
					//2.1成功 ,跳转到主界面
					JOptionPane.showMessageDialog(null, userName+"用户登录成功!");
					new MainFrame().setVisible(true);
					this.dispose();//关闭窗口
				              											
				}else{
					//2.2失败,提示
					JOptionPane.showMessageDialog(null, "用户名或密码错误!");
					
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




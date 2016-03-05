package com.sxt.account.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sxt.account.dao.BookInfoDao;
/**
 * @功能：实现添加新账簿
 * @author 张珊珊
 *@time 8.11
 */
public class AddBookFrame extends JFrame implements ActionListener{
	private JTextField txt1;
	private JTextField txt2;
	private JPasswordField pwd1;
	private JPasswordField pwd2;
	private BookInfoDao dao;
	private BookFrame bookFrame;
	
	JButton btn1=new JButton("确认");
	JButton btn2=new JButton("取消");
	
	public AddBookFrame(BookFrame bookFrame){
		this.bookFrame = bookFrame;
		init();
	}
	public void init(){
		
		dao = new BookInfoDao();
		
		this.setTitle("新建账簿");
		//设置大小
		this.setSize(400, 300);
		//设置位置(居中)
		this.setLocationRelativeTo(null);
		//设置关闭的行为
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//设置不可变
		this.setResizable(false);
		this.setLayout(null);
		
		JLabel lbl=new JLabel("欢迎您新建账簿");
		lbl.setBounds(20, 20, 150, 40);
		this.add(lbl);
		
		JLabel lbl1=new JLabel("账簿名称:");
		JLabel lbl2=new JLabel("记账人:");
		JLabel lbl3=new JLabel("输入密码：");
		JLabel lbl4=new JLabel("确认密码：");

		
		txt1 = new JTextField(30); 
		txt2 = new JTextField(30); 
		pwd1 = new JPasswordField();
		pwd2 = new JPasswordField();
		
		lbl1.setBounds(50, 100, 80, 20);
		txt1.setBounds(150, 100, 150, 20);
		lbl2.setBounds(50, 130, 80, 20);
		txt2.setBounds(150, 130, 150, 20);
		lbl3.setBounds(50, 160, 80, 20);
		pwd1.setBounds(150, 160, 150, 20);
		lbl4.setBounds(50, 190, 80, 20);
		pwd2.setBounds(150, 190, 150, 20);


		//txt1.setBounds(50, 70, 100, 20);
		
		this.add(lbl1);
		this.add(lbl2);
		this.add(lbl3);
		this.add(lbl4);
		this.add(txt1);
		this.add(txt2);
		this.add(pwd1);
		this.add(pwd2);
		
		
		btn1.setBounds(80, 230, 60, 25);
		btn1.addActionListener(this);
		btn2.setBounds(200, 230, 60, 25);
		btn2.addActionListener(this);

		this.add(btn1);
		this.add(btn2);
		
		JLabel lblPhoto=new JLabel();
		lblPhoto.setIcon(new ImageIcon("imgs/17.png"));
		lblPhoto.setBounds(120, 0, 280, 80);
		this.add(lblPhoto);
	}
	public void actionPerformed(ActionEvent e) {
		 //TODO Auto-generated method stub
		if(e.getSource()==btn1){
			String bname = txt1.getText().trim();
			int userId = Integer.valueOf(txt2.getText().trim());
			String fpwd = new String(pwd1.getPassword());
			String spwd = new String(pwd2.getPassword());
			if( bname.isEmpty()){
				 JOptionPane.showMessageDialog(null, "用户名不能为空");
				 return;
			 }
			 if(fpwd.isEmpty() || fpwd.length() < 6){
				 JOptionPane.showMessageDialog(null, "密码不能为空或密码小于6位");
				 return;
			 }
			
			//如果两次输入密码相同则可向数据库插入
			if(fpwd.equals(spwd)){
				
				dao.addBookInfo(bname, fpwd, userId);
				JOptionPane.showMessageDialog(null, "新账簿创建成功");
				AddBookFrame.this.setVisible(false);
				
				//动态刷新数据
				Vector rowdata; rowdata = dao.getAll();
				
				bookFrame.setDtm(new DefaultTableModel(rowdata,bookFrame.getCloNames()));
		        bookFrame.getTable().setModel(bookFrame.getDtm());
				
			}else{
				//提示检查两次输入密码是否一致
				JOptionPane.showMessageDialog(null, "两次输入密码不一致！");
			}
		}
		if(e.getSource()==btn2){
			this.dispose();
		}
	}
	
}

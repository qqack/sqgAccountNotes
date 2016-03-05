package com.sxt.account.ui;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sxt.account.bean.BookInfo;
import com.sxt.account.dao.BookInfoDao;
/**
 * @功能：账簿登陆页面
 * @author 张珊珊
 *@time 8.12
 */
public class MyNoteFrame extends JFrame{
	
	
	public MyNoteFrame(){
		init();
	}
	private BookInfoDao dao;
	private JComboBox cb1;
	private JComboBox cb2;
	public void init(){
		
		dao = new BookInfoDao();
		//设置标题
		this.setTitle("我的账簿");
		//设置大小
		this.setSize(400, 300);
		//设置位置(居中)
		this.setLocationRelativeTo(null);
		//设置关闭的行为
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//设置不可变
		this.setResizable(false);
		this.setLayout(null);
		
		JLabel lbl1=new JLabel("账簿名");
		JLabel lbl2=new JLabel("用户名");
		JLabel lbl3=new JLabel("密码");
		cb1 = new JComboBox();
		cb2 = new JComboBox();
		JPasswordField pwd=new JPasswordField(20);
		
		addCheckItems();
		
		
		lbl1.setBounds(50, 110, 50, 20);
		cb1.setBounds(140, 110, 130, 20);
		lbl2.setBounds(50, 150, 50, 20);
		cb2.setBounds(140, 150, 130, 20);
		lbl3.setBounds(50, 190, 50, 20);
		pwd.setBounds(140, 190, 130, 20);

		this.add(lbl1);
		this.add(lbl2);
		this.add(lbl3);
		this.add(cb1);
		this.add(cb2);
		this.add(pwd);

		JButton btn1=new JButton("登陆");
		JButton btn2=new JButton("取消");
		
		btn1.setBounds(80, 230, 70, 25);
		btn2.setBounds(200, 230, 70, 25);
		this.add(btn1);
		this.add(btn2);
		
		JLabel lblPhoto=new JLabel();
		lblPhoto.setIcon(new ImageIcon("imgs/17.png"));
		lblPhoto.setBounds(0, 0, 400, 100);
		this.add(lblPhoto);
		
	}
	
	private void addCheckItems(){
		
		List<BookInfo> list = dao.findAll();
		
		for (BookInfo bookInfo : list) {
			System.out.println(bookInfo.getbName());
			System.out.println(bookInfo.getuName());
			cb1.addItem(bookInfo.getbName());
			cb2.addItem(bookInfo.getuName());
		}
	}
	

}

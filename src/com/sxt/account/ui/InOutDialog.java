package com.sxt.account.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.sxt.account.dao.InOutInfoDao;

public class InOutDialog extends JDialog implements ActionListener{
	
	JTextField txtName = new JTextField();
	JTextField txtType = new JTextField();
	JTextField txtUname = new JTextField();
	JButton btnSave = new JButton("保  存");
	JButton btnExit = new JButton("退  出");
	JLabel lblErr = new JLabel();
	JRadioButton rdoIn = new JRadioButton("收入");
	JRadioButton rdoOut = new JRadioButton("支出");
	public InOutDialog(){
		init();
	}
	public void init(){
		//设置窗体属性
		this.setSize(250,180);
		this.setTitle("添加");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//添加相应的组件
		JLabel lblTitle = new JLabel("项目名称");
		lblTitle.setBounds(15, 20, 70, 15);
		txtName.setBounds(85, 17, 130, 21);
		
		JLabel lblType = new JLabel("类   型");
		lblType.setBounds(25, 48, 60, 15);
		//txtType.setBounds(85, 45, 130, 21);
		rdoIn.setBounds(85, 44, 59, 23);
		rdoOut.setBounds(153, 44, 62, 23);
		//RadioButton设置成一组逻辑
		ButtonGroup group = new ButtonGroup();
		group.add(rdoIn);
		group.add(rdoOut);
		
		JLabel lblUname = new JLabel("用户名");
		lblUname.setBounds(23, 79, 42, 15);
		txtUname.setBounds(85, 76, 80, 21);
		
		btnSave.setBounds(10, 117, 93, 23);
		btnExit.setBounds(131, 117, 93, 23);
		
		this.add(lblTitle);
		this.add(txtName);
		this.add(lblType);
		//this.add(txtType);
		this.add(rdoIn);
		this.add(rdoOut);
		this.add(lblUname);
		this.add(txtUname);
		this.add(btnSave);
		this.add(btnExit);
		
		
		//添加按钮事件
		btnSave.addActionListener(this);
		btnExit.addActionListener(this);

	}
	public static void main(String[] args) {
		new InOutDialog().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSave){
			//1.获取用户输入的文本，验证文本
			String name = txtName.getText();
			String form = null;
			//得到JRadioButton的文本
			if(rdoIn.isSelected()){
				 form = rdoIn.getText();
				System.out.println(form);
			}else if(rdoOut.isSelected()){
				form = rdoOut.getText();
				System.out.println(form);
			}
			//String form = txtType.getText();
			String uname = txtUname.getText();
			if(name.trim().length() == 0){
				JOptionPane.showMessageDialog(null, "添加项名称不能为空！");
				return;
			}else if(form.trim().length() == 0){
				JOptionPane.showMessageDialog(null, "添加类型不能为空！");
				return;
			}else if(uname.trim().length() == 0){
				JOptionPane.showMessageDialog(null, "用户名称不能为空！");
				return;
			}
			
			//2.调用dao的add方法
			InOutInfoDao ioi = new InOutInfoDao();
			ioi.add(name, form, uname);
			//3.提示
			JOptionPane.showMessageDialog(null, "添加类型成功！");
			//4.关闭自己
			this.dispose();
		}else if(e.getSource() == btnExit){
			     this.dispose();
		}
		
	}
}

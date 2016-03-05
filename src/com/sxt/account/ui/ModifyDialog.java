package com.sxt.account.ui;

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

/**
 * 点击修改后的修改窗体
 * @author 勾润雪
 * @version 1.0
 *  2015-8-12
 */
public class ModifyDialog extends JDialog implements ActionListener{
	JLabel lblNum = new JLabel("收支编号");
	JLabel lblName = new JLabel("修改类型名称");
	JLabel lblType = new JLabel("修改类型");
	JTextField txtNum = new JTextField();
	JTextField txtName = new JTextField();
	JTextField txtType = new JTextField();
	JButton btnModify = new JButton("确认修改");
	JButton btnExit = new JButton("退   出");
	JRadioButton rdoIn = new JRadioButton("收入");
	JRadioButton rdoOut = new JRadioButton("支出");
	InOutInfoDao iod = new InOutInfoDao();
	
	public ModifyDialog(){
		init();
	}
	public void init(){
		//设置窗体属性
		this.setBounds(100, 100, 251, 200);
		this.setTitle("修改");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//设置相应的组件大小、位置
		lblNum.setBounds(37, 20, 54, 15);
		txtNum.setBounds(103, 17, 66, 21);
		lblName.setBounds(10, 56, 82, 15);
		txtName.setBounds(103, 53, 110, 21);
		lblType.setBounds(37, 92, 63, 15);
		rdoIn.setBounds(102, 88, 65, 30);
		rdoOut.setBounds(164, 88, 65, 30);
		//txtType.setBounds(103, 89, 110, 21);
		btnModify.setBounds(21, 129, 90, 23);
		btnExit.setBounds(131, 129, 90, 23);
		//RadioButton设置成一组逻辑
		ButtonGroup group = new ButtonGroup();
		group.add(rdoIn);
		group.add(rdoOut);
		//添加相应组件
		this.add(lblNum);
		this.add(txtNum);
		this.add(lblName);
		this.add(txtName);
		this.add(lblType);
		this.add(txtType);
		this.add(btnModify);
		this.add(btnExit);
		this.add(rdoIn);
		this.add(rdoOut);
		
		//添加按钮事件
		btnModify.addActionListener(this);
		btnExit.addActionListener(this);
		
	}
	public static void main(String[] args) {
		new ModifyDialog().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnModify){
			//1.获取用户输入的文本，并验证
			int num = Integer.parseInt(txtNum.getText());
			String name = txtName.getText();
			String form = null;
			if(rdoIn.isSelected()){
				 form = rdoIn.getText();
				System.out.println(form);
			}else if(rdoOut.isSelected()){
				form = rdoOut.getText();
				System.out.println(form);
			}
			
			//判断是否为空的情况
			if(name.trim().length() == 0){
				JOptionPane.showMessageDialog(null, "修改类型名称不能为空！");
				return;
			}else if(form.trim().length() == 0){
				JOptionPane.showMessageDialog(null, "修改类型不能为空！");
				return;
			}
			//2.调用dao的modify方法
			
			iod.modify(name,form,num);
			//3.提示
			JOptionPane.showMessageDialog(null, "修改成功！");
			//4.关闭自己
			this.dispose();
		}else if(e.getSource() == btnExit){
			this.dispose();
		}
		
	}
}

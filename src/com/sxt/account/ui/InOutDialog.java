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
	JButton btnSave = new JButton("��  ��");
	JButton btnExit = new JButton("��  ��");
	JLabel lblErr = new JLabel();
	JRadioButton rdoIn = new JRadioButton("����");
	JRadioButton rdoOut = new JRadioButton("֧��");
	public InOutDialog(){
		init();
	}
	public void init(){
		//���ô�������
		this.setSize(250,180);
		this.setTitle("���");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//�����Ӧ�����
		JLabel lblTitle = new JLabel("��Ŀ����");
		lblTitle.setBounds(15, 20, 70, 15);
		txtName.setBounds(85, 17, 130, 21);
		
		JLabel lblType = new JLabel("��   ��");
		lblType.setBounds(25, 48, 60, 15);
		//txtType.setBounds(85, 45, 130, 21);
		rdoIn.setBounds(85, 44, 59, 23);
		rdoOut.setBounds(153, 44, 62, 23);
		//RadioButton���ó�һ���߼�
		ButtonGroup group = new ButtonGroup();
		group.add(rdoIn);
		group.add(rdoOut);
		
		JLabel lblUname = new JLabel("�û���");
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
		
		
		//��Ӱ�ť�¼�
		btnSave.addActionListener(this);
		btnExit.addActionListener(this);

	}
	public static void main(String[] args) {
		new InOutDialog().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSave){
			//1.��ȡ�û�������ı�����֤�ı�
			String name = txtName.getText();
			String form = null;
			//�õ�JRadioButton���ı�
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
				JOptionPane.showMessageDialog(null, "��������Ʋ���Ϊ�գ�");
				return;
			}else if(form.trim().length() == 0){
				JOptionPane.showMessageDialog(null, "������Ͳ���Ϊ�գ�");
				return;
			}else if(uname.trim().length() == 0){
				JOptionPane.showMessageDialog(null, "�û����Ʋ���Ϊ�գ�");
				return;
			}
			
			//2.����dao��add����
			InOutInfoDao ioi = new InOutInfoDao();
			ioi.add(name, form, uname);
			//3.��ʾ
			JOptionPane.showMessageDialog(null, "������ͳɹ���");
			//4.�ر��Լ�
			this.dispose();
		}else if(e.getSource() == btnExit){
			     this.dispose();
		}
		
	}
}

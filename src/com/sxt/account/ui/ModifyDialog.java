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
 * ����޸ĺ���޸Ĵ���
 * @author ����ѩ
 * @version 1.0
 *  2015-8-12
 */
public class ModifyDialog extends JDialog implements ActionListener{
	JLabel lblNum = new JLabel("��֧���");
	JLabel lblName = new JLabel("�޸���������");
	JLabel lblType = new JLabel("�޸�����");
	JTextField txtNum = new JTextField();
	JTextField txtName = new JTextField();
	JTextField txtType = new JTextField();
	JButton btnModify = new JButton("ȷ���޸�");
	JButton btnExit = new JButton("��   ��");
	JRadioButton rdoIn = new JRadioButton("����");
	JRadioButton rdoOut = new JRadioButton("֧��");
	InOutInfoDao iod = new InOutInfoDao();
	
	public ModifyDialog(){
		init();
	}
	public void init(){
		//���ô�������
		this.setBounds(100, 100, 251, 200);
		this.setTitle("�޸�");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//������Ӧ�������С��λ��
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
		//RadioButton���ó�һ���߼�
		ButtonGroup group = new ButtonGroup();
		group.add(rdoIn);
		group.add(rdoOut);
		//�����Ӧ���
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
		
		//��Ӱ�ť�¼�
		btnModify.addActionListener(this);
		btnExit.addActionListener(this);
		
	}
	public static void main(String[] args) {
		new ModifyDialog().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnModify){
			//1.��ȡ�û�������ı�������֤
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
			
			//�ж��Ƿ�Ϊ�յ����
			if(name.trim().length() == 0){
				JOptionPane.showMessageDialog(null, "�޸��������Ʋ���Ϊ�գ�");
				return;
			}else if(form.trim().length() == 0){
				JOptionPane.showMessageDialog(null, "�޸����Ͳ���Ϊ�գ�");
				return;
			}
			//2.����dao��modify����
			
			iod.modify(name,form,num);
			//3.��ʾ
			JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
			//4.�ر��Լ�
			this.dispose();
		}else if(e.getSource() == btnExit){
			this.dispose();
		}
		
	}
}

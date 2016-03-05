package com.sxt.account.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * @���ܣ�����ѡ����
 * @author ����
 * @time:2015.08.12
 *
 */
public class DailyDialog extends JDialog implements ActionListener{
	
	JButton btnConfirm = new JButton("ȷ��");
	JButton btnCancel = new JButton("ȡ��");

	public DailyDialog(){
		init();
	}
	public void init(){
		
		//��������
		this.setTitle("����ѡ����");
		this.setSize(450, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JPanel pnlMain = new JPanel();
		JLabel lblYear = new JLabel("���");
		JLabel lblMonth = new JLabel("�·�");
		JTextField txtYear = new JTextField(10);
		JTextField txtMonth = new JTextField(10);
		
		lblYear.setPreferredSize(new Dimension(50,30));
		lblMonth.setPreferredSize(new Dimension(50,30));
		txtYear.setPreferredSize(new Dimension(100,20));
		txtMonth.setPreferredSize(new Dimension(100,20));
		btnConfirm.setPreferredSize(new Dimension(100,30));
		btnCancel.setPreferredSize(new Dimension(100,30));
		pnlMain.setBorder(BorderFactory.createTitledBorder("ѡ�����ڷ�Χ"));
		pnlMain.add(lblYear);
		pnlMain.add(txtYear);
		pnlMain.add(lblMonth);
		pnlMain.add(txtMonth);
		pnlMain.add(btnConfirm);
		pnlMain.add(btnCancel);
		btnConfirm.addActionListener(this);
		btnCancel.addActionListener(this);
		this.add(pnlMain);
		
	}
	public static void main(String[] args) {
		new DailyDialog().setVisible(true);

	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCancel){
			this.dispose();
		}else if(e.getSource()==btnConfirm){
			//?
		}
		
	}

}

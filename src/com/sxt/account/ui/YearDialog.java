package com.sxt.account.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import oracle.security.o5logon.a;
/**
 * @���ܣ����ѡ����
 * @author ����
 * @time:2015.08.12
 * @version: 1.0
 *
 */
public class YearDialog extends JDialog implements ActionListener{
	JButton btnConfirm = new JButton("ȷ��");
	JButton btnCancel = new JButton("ȡ��");
	public YearDialog(){
	init();
}
public void init(){
	
	//��������
	this.setTitle("���ѡ����");
	this.setSize(450, 250);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	this.setLayout(new BorderLayout());
	
	JPanel pnlMain = new JPanel();
	JLabel lblYear = new JLabel("���");
	JTextField txtYear = new JTextField(10);
	//JTextField txtMonth = new JTextField(10);
	
	lblYear.setPreferredSize(new Dimension(50,30));
	//lblMonth.setPreferredSize(new Dimension(50,30));
	txtYear.setPreferredSize(new Dimension(100,20));
	//txtMonth.setPreferredSize(new Dimension(100,20));
	btnConfirm.setPreferredSize(new Dimension(100,30));
	btnCancel.setPreferredSize(new Dimension(100,30));
	pnlMain.setBorder(BorderFactory.createTitledBorder("ѡ�����ڷ�Χ"));
	pnlMain.add(lblYear);
	pnlMain.add(txtYear);
	//pnlMain.add(lblMonth);
	//pnlMain.add(txtMonth);
	pnlMain.add(btnConfirm);
	pnlMain.add(btnCancel);
	btnConfirm.addActionListener(this);
	btnCancel.addActionListener(this);
	this.add(pnlMain);
	
}
public static void main(String[] args) {
	new YearDialog().setVisible(true);

}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==btnCancel){
		this.dispose();
	}else if(e.getSource()==btnConfirm){
		//?
	}
	
}

}

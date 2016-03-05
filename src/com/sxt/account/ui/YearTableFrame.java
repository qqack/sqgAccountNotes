package com.sxt.account.ui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * @���ܣ���ȱ���
 * @author ����
 * @time:2015.08.12
 * @version: 1.0
 *
 */
public class YearTableFrame extends JFrame{
	public YearTableFrame(){
		init();
	}
	public void init(){
		
		 //���ñ���
		 this.setTitle("��ȱ���");
		 //���ô�С
		 this.setSize(800,500);
		 //����λ��(����)
		 this.setLocationRelativeTo(null);
		 //���ùرյ���Ϊ
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 //���ò���
		 this.setLayout(new BorderLayout());
		 
		 JLabel lblTitle = new JLabel("�����֧ͳ�Ʊ�");
		 JLabel lblBook = new JLabel("�˲����ҵļ�ͥ��");
		 JLabel lblMoney = new JLabel("���ҵ�λ�������Ԫ");
		 
		 JLabel lblTable = new JLabel();
		 lblTable.setIcon(new ImageIcon("imgs/table.png"));
		 lblTable.setBounds(20, 100,750,400);
		 lblTitle.setBounds(200, 20, 200, 50);
		 lblBook.setBounds(20, 70, 200, 30);
		 lblMoney.setBounds(600, 70, 200, 30);
		 
		 
		 this.add(lblTitle);
		 this.add(lblBook);
		 this.add(lblMoney);
		 this.add(lblTable);
		 
	}
	
	public static void main(String[] args) {
		new YearTableFrame().setVisible(true);

	}

}

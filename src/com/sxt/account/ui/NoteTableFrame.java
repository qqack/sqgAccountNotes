package com.sxt.account.ui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.sxt.account.dao.NoteInfoDao;
/**
 * @���ܣ���������
 * @author ����
 * @time:2015.08.12
 * @version: 1.0
 *
 */
public class NoteTableFrame extends JFrame{
	JPanel pnlMain;
	JTabbedPane  tabbedPane =new JTabbedPane();
	Vector colNames = new Vector();
	JTable table = new JTable();
	JButton btnDaily,btnYear;
	public NoteTableFrame(){
		init();
	}
	public void init(){
		
		 //���ñ���
		 this.setTitle("�ҵı�������");
		 //���ô�С
		 this.setSize(800,500);
		 //����λ��(����)
		 this.setLocationRelativeTo(null);
		 //���ùرյ���Ϊ
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 //���ò���
		 this.setLayout(new BorderLayout());
		 btnDaily = new JButton("�ճ���֧ͳ�Ʊ�");
		 btnYear = new JButton("��֧���ͳ�Ʊ�");
		 JLabel lblDaily = new JLabel("ͳ��ĳ��ʱ����������֧�ֲ������Ҳ���Ǽ�ͥ�����");
		 JLabel lblYear = new JLabel("ͳ��һ������ڣ�����������֧��Ŀ��ÿ���µ��ۼƷ����");
		 
		 btnDaily.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				new NormalInOutFrame().setVisible(true);
				
			}
		});
		 btnYear.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					new YearTableFrame().setVisible(true);
					
				}
			});
		 
		 //��ҳ���
		 pnlMain = new JPanel();
		 pnlMain.setLayout(new FlowLayout(20,20,20));
		 btnDaily.setPreferredSize(new Dimension(200,30));
		 lblDaily.setPreferredSize(new Dimension(500,30));
		 btnYear.setPreferredSize(new Dimension(200,30));
		 pnlMain.add(btnDaily);
		 pnlMain.add(lblDaily);
		 pnlMain.add(btnYear);
		 pnlMain.add(lblYear);
		 tabbedPane.add("�ҵı�������", pnlMain);
		 this.add(tabbedPane);
		 
		 }
	
	public static void main(String[] args) {
		new NoteTableFrame().setVisible(true);
	}
}
	

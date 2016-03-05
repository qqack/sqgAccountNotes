package com.sxt.account.ui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.sxt.account.bean.AccountInfo;
import com.sxt.account.dao.AccountInfoDao;
import com.sxt.account.util.AccTableModel;

/**
 * �����˻�����ģ��--����
 * @author ����ѩ
 * 2015-8-8
 */
public class AccountInfoFrame extends JFrame{
	JTabbedPane tabbedPane = new JTabbedPane();
	Vector colNames = new Vector();
	JTable 	table1 = new JTable();
	JTable 	table2 = new JTable();
	JTable 	table3 = new JTable();
	
	
	public AccountInfoFrame(){
		init();
	}
	public void init(){
		//��������
		this.setTitle("�˻�����");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		//����λ�þ���
		this.setLocationRelativeTo(null);
		
		JPanel pnlCard = new JPanel();//���п�
		JPanel pnlMoney = new JPanel();//�ֽ�
		JPanel pnlBank = new JPanel();//����
		tabbedPane.setTabPlacement(JTabbedPane.NORTH);
		//ѡ�������
		tabbedPane.add("���п�",pnlCard);
		tabbedPane.add("�ֽ�",pnlMoney);
		tabbedPane.add("����",pnlBank);
		//�������
		colNames.add("�˻�ID");
		colNames.add("�˻�����");
		colNames.add("�˻����");
		colNames.add("remark1");
		colNames.add("remark2");

		//����get()������ʾ3�����͵�����
		Vector rowdata = new AccountInfoDao().getAll(1);
		DefaultTableModel   dtm1 =new DefaultTableModel(rowdata,colNames);
		System.out.println(colNames);
        table1.setModel(dtm1);
        //��table������������
        JScrollPane sp1 = new JScrollPane();
    	sp1.setViewportView(table1);
        pnlCard.add(sp1);
        
        Vector rowdata2 = new AccountInfoDao().getAll(2);
		DefaultTableModel   dtm2 =new DefaultTableModel(rowdata2,colNames);
        table2.setModel(dtm2);
        //��table������������
        JScrollPane sp2 = new JScrollPane();
    	sp2.setViewportView(table2);
        pnlMoney.add(sp2);
        
        Vector rowdata3 = new AccountInfoDao().getAll(3);
		DefaultTableModel   dtm3 =new DefaultTableModel(rowdata3,colNames);
        table3.setModel(dtm3);
        //��table������������
        JScrollPane sp3 = new JScrollPane();
    	sp3.setViewportView(table3);
        pnlBank.add(sp3);
        
		this.add(tabbedPane);
		
	}
	
	
}
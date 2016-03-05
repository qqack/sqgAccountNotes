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
 * 创建账户管理模块--窗体
 * @author 勾润雪
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
		//窗体设置
		this.setTitle("账户管理");
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		//设置位置居中
		this.setLocationRelativeTo(null);
		
		JPanel pnlCard = new JPanel();//银行卡
		JPanel pnlMoney = new JPanel();//现金
		JPanel pnlBank = new JPanel();//网银
		tabbedPane.setTabPlacement(JTabbedPane.NORTH);
		//选项卡的名称
		tabbedPane.add("银行卡",pnlCard);
		tabbedPane.add("现金",pnlMoney);
		tabbedPane.add("网银",pnlBank);
		//添加列名
		colNames.add("账户ID");
		colNames.add("账户类型");
		colNames.add("账户余额");
		colNames.add("remark1");
		colNames.add("remark2");

		//调用get()方法显示3个类型的数据
		Vector rowdata = new AccountInfoDao().getAll(1);
		DefaultTableModel   dtm1 =new DefaultTableModel(rowdata,colNames);
		System.out.println(colNames);
        table1.setModel(dtm1);
        //将table加入滚动面板中
        JScrollPane sp1 = new JScrollPane();
    	sp1.setViewportView(table1);
        pnlCard.add(sp1);
        
        Vector rowdata2 = new AccountInfoDao().getAll(2);
		DefaultTableModel   dtm2 =new DefaultTableModel(rowdata2,colNames);
        table2.setModel(dtm2);
        //将table加入滚动面板中
        JScrollPane sp2 = new JScrollPane();
    	sp2.setViewportView(table2);
        pnlMoney.add(sp2);
        
        Vector rowdata3 = new AccountInfoDao().getAll(3);
		DefaultTableModel   dtm3 =new DefaultTableModel(rowdata3,colNames);
        table3.setModel(dtm3);
        //将table加入滚动面板中
        JScrollPane sp3 = new JScrollPane();
    	sp3.setViewportView(table3);
        pnlBank.add(sp3);
        
		this.add(tabbedPane);
		
	}
	
	
}
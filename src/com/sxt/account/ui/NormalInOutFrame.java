package com.sxt.account.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.sxt.account.bean.InOutInfo;
import com.sxt.account.dao.NoteInfoDao;
import com.sxt.account.util.DBOperator;

/**
 * 功能：日常收支记账表的窗体
 * @author 仇艳
 * 日期：2015.08.09
 *
 */
public class NormalInOutFrame extends JFrame implements ActionListener{
	JPanel pnlMain;
	JTabbedPane  tabbedPane =new JTabbedPane();
	JButton btnUpdate = new JButton("刷新收支");
	JButton btnAdd = new JButton("新添收支");
	JButton btnTransfer = new JButton("账户转账");
	JButton btnChange = new JButton("调整余额");
	JButton btnModify = new JButton("修改");
	JButton btnDelete = new JButton("删除");
	JButton btnSelect = new JButton("查询");
	JTable 	table = new JTable();
	Vector colNames =new Vector();
	String rowNum,ndate,Actype,form,money,notes,uid,nid,typeName;
//	InOutInfo typeName;
	private int flag;
	public NormalInOutFrame(){
		init();
	}
	public void init(){
		//窗体设置
		this.setTitle("收支记账");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		//添加列名
		colNames.add("标记");
		colNames.add("nid");
    	colNames.add("日期");
    	colNames.add("收支种类");
    	colNames.add("账户");
    	colNames.add("收入");
    	colNames.add("支出");
    	colNames.add("人员");
    	colNames.add("备注");
    	
    	//将数据展示到table中
    	Vector rowdata = new NoteInfoDao().getAll();
    	DefaultTableModel   dtm =new DefaultTableModel(rowdata,colNames);
        table.setModel(dtm);
    	//将table加到滚动面板中
    	JScrollPane sp = new JScrollPane();
    	sp.setViewportView(table);
    	sp.setPreferredSize(new Dimension(700,500));
    	
		//添加分页面板
		pnlMain = new JPanel();
		pnlMain.setLayout(new BorderLayout());
		JPanel pnlMainNorth = new JPanel();
		JPanel pnlMainSouth = new JPanel();
		pnlMain.add(pnlMainNorth,BorderLayout.NORTH);
		pnlMain.add(pnlMainSouth);
		tabbedPane.add("收支记账", pnlMain);
		
		//添加组件
		pnlMainNorth.add(btnUpdate);
		pnlMainNorth.add(btnAdd);
		pnlMainNorth.add(btnTransfer);
		pnlMainNorth.add(btnChange);
		pnlMainNorth.add(btnModify);
		pnlMainNorth.add(btnDelete);
		pnlMainNorth.add(btnSelect);
		
		pnlMainSouth.add(sp);
		this.add(tabbedPane);
		
		

		//各按钮添加监听
		btnUpdate.addActionListener(this);
		btnAdd.addActionListener(this);
		btnTransfer.addActionListener(this);
		btnChange.addActionListener(this);
		btnModify.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSelect.addActionListener(this);
		
		//刷新
		
		
	}
	public static void main(String[] args) {
		new NormalInOutFrame().setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnUpdate){
			Vector rowdata = new NoteInfoDao().getAll();
	    	DefaultTableModel   dtm =new DefaultTableModel(rowdata,colNames);
	        table.setModel(dtm);
		}else if(e.getSource()==btnAdd){
			NoteDialog nd = new NoteDialog();
			nd.setVisible(true);
		}else if(e.getSource()==btnTransfer){
			
			new TransferDialog().setVisible(true);
			
		}else if(e.getSource()==btnChange){
			new ChangeMoneyDialog().setVisible(true);
			
		}else if(e.getSource()==btnModify){
			//获取变革内容
			rowNum=table.getValueAt(table.getSelectedRow(),0).toString();
			nid=table.getValueAt(table.getSelectedRow(),1).toString();
			ndate=table.getValueAt(table.getSelectedRow(),2).toString();
			typeName=table.getValueAt(table.getSelectedRow(),3).toString();
			Actype=table.getValueAt(table.getSelectedRow(),4).toString();
			form=table.getValueAt(table.getSelectedRow(),5).toString();
			money=table.getValueAt(table.getSelectedRow(),6).toString();
			uid=table.getValueAt(table.getSelectedRow(),7).toString();
			notes=table.getValueAt(table.getSelectedRow(),8).toString();
//			
			UpdateDialog ud = new UpdateDialog();
			ud.setVisible(true);
			if(form.equals("收入")){
				ud.rbtnIncome.setSelected(true);
				ud.form="收入";
			}else if(form.equals("支出")){
				ud.rbtnOutcome.setSelected(true);
				ud.form="支出";
			}
			ud.cboAcType.setSelectedItem(Actype.trim());
			ud.cboForm.setSelectedItem(typeName.trim());
			ud.txtDate.setText(ndate.trim());
			ud.txtMoney.setText(money.trim());
			ud.txtNotes.setText(notes.trim());
			ud.getNid(Integer.parseInt(nid));

			
		}else if(e.getSource()==btnDelete){
			
			 int flag=JOptionPane.showConfirmDialog(null, "确认删除？", "删除",JOptionPane.YES_NO_OPTION);
			    if(flag==0){
				String nid = table.getValueAt(table.getSelectedRow(),1).toString();
				System.out.println(nid);
				new NoteInfoDao().delete(nid);
				JOptionPane.showMessageDialog(null, "删除成功！");
			    }else{
			    	return;
			    }
			
		}
		else if(e.getSource()==btnSelect){
			
			SelectDialog nd = new SelectDialog();
			nd.setVisible(true);
			
			if(!nd.isVisible()){
				System.out.println("laile ");
//				Vector data =nd.getData();
//				System.out.println(data+"nnnn");
//		    	DefaultTableModel   dtm =new DefaultTableModel(data,colNames);
//		        table.setModel(dtm);
				System.out.println("nnn");
			}
		}
	}
}
		
		
		
		
		

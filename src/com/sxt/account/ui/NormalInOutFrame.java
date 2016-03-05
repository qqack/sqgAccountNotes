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
 * ���ܣ��ճ���֧���˱�Ĵ���
 * @author ����
 * ���ڣ�2015.08.09
 *
 */
public class NormalInOutFrame extends JFrame implements ActionListener{
	JPanel pnlMain;
	JTabbedPane  tabbedPane =new JTabbedPane();
	JButton btnUpdate = new JButton("ˢ����֧");
	JButton btnAdd = new JButton("������֧");
	JButton btnTransfer = new JButton("�˻�ת��");
	JButton btnChange = new JButton("�������");
	JButton btnModify = new JButton("�޸�");
	JButton btnDelete = new JButton("ɾ��");
	JButton btnSelect = new JButton("��ѯ");
	JTable 	table = new JTable();
	Vector colNames =new Vector();
	String rowNum,ndate,Actype,form,money,notes,uid,nid,typeName;
//	InOutInfo typeName;
	private int flag;
	public NormalInOutFrame(){
		init();
	}
	public void init(){
		//��������
		this.setTitle("��֧����");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		//�������
		colNames.add("���");
		colNames.add("nid");
    	colNames.add("����");
    	colNames.add("��֧����");
    	colNames.add("�˻�");
    	colNames.add("����");
    	colNames.add("֧��");
    	colNames.add("��Ա");
    	colNames.add("��ע");
    	
    	//������չʾ��table��
    	Vector rowdata = new NoteInfoDao().getAll();
    	DefaultTableModel   dtm =new DefaultTableModel(rowdata,colNames);
        table.setModel(dtm);
    	//��table�ӵ����������
    	JScrollPane sp = new JScrollPane();
    	sp.setViewportView(table);
    	sp.setPreferredSize(new Dimension(700,500));
    	
		//��ӷ�ҳ���
		pnlMain = new JPanel();
		pnlMain.setLayout(new BorderLayout());
		JPanel pnlMainNorth = new JPanel();
		JPanel pnlMainSouth = new JPanel();
		pnlMain.add(pnlMainNorth,BorderLayout.NORTH);
		pnlMain.add(pnlMainSouth);
		tabbedPane.add("��֧����", pnlMain);
		
		//������
		pnlMainNorth.add(btnUpdate);
		pnlMainNorth.add(btnAdd);
		pnlMainNorth.add(btnTransfer);
		pnlMainNorth.add(btnChange);
		pnlMainNorth.add(btnModify);
		pnlMainNorth.add(btnDelete);
		pnlMainNorth.add(btnSelect);
		
		pnlMainSouth.add(sp);
		this.add(tabbedPane);
		
		

		//����ť��Ӽ���
		btnUpdate.addActionListener(this);
		btnAdd.addActionListener(this);
		btnTransfer.addActionListener(this);
		btnChange.addActionListener(this);
		btnModify.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSelect.addActionListener(this);
		
		//ˢ��
		
		
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
			//��ȡ�������
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
			if(form.equals("����")){
				ud.rbtnIncome.setSelected(true);
				ud.form="����";
			}else if(form.equals("֧��")){
				ud.rbtnOutcome.setSelected(true);
				ud.form="֧��";
			}
			ud.cboAcType.setSelectedItem(Actype.trim());
			ud.cboForm.setSelectedItem(typeName.trim());
			ud.txtDate.setText(ndate.trim());
			ud.txtMoney.setText(money.trim());
			ud.txtNotes.setText(notes.trim());
			ud.getNid(Integer.parseInt(nid));

			
		}else if(e.getSource()==btnDelete){
			
			 int flag=JOptionPane.showConfirmDialog(null, "ȷ��ɾ����", "ɾ��",JOptionPane.YES_NO_OPTION);
			    if(flag==0){
				String nid = table.getValueAt(table.getSelectedRow(),1).toString();
				System.out.println(nid);
				new NoteInfoDao().delete(nid);
				JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
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
		
		
		
		
		

package com.sxt.account.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.sxt.account.dao.InOutInfoDao;
/**
 * ������֧��Ŀ������Ŀ--����
 * @author ����ѩ
 *2015-8-9
 * @version 1.0
 * @param <InOutInfo>
 */

public class InOutInfoFrame<InOutInfo> extends JFrame implements ActionListener{ 
	Vector colNames = new Vector();
	InOutInfoDao InOutDao = new InOutInfoDao();
	JTable table = new JTable();
	JButton btnAdd = new JButton("��    ��");
	JButton btnRemove = new JButton("ɾ    ��");
	JButton btnModify = new JButton("��    ��");
	JButton btnUpdate = new JButton("ˢ    ��");
	public InOutInfoFrame(){
		init();
	}
	public void init(){
		
		//���ô����������
		this.setTitle("��֧��Ŀ"); 
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 520, 450);  
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//�������
		colNames.add("��֧���");
		colNames.add("��Ŀ����");
		colNames.add("���");
		colNames.add("�û���");
		colNames.add("˵��");
//		colNames.add("remark1");
//		colNames.add("remark2");
//		colNames.add("remark3");
		
		//������չʾ��table��
    	Vector rowdata = new InOutInfoDao().getAll();
    	DefaultTableModel   dtm =new DefaultTableModel(rowdata,colNames);
        System.out.println(colNames);
    	table.setModel(dtm);
    	//��table�ӵ����������
    	JScrollPane sp = new JScrollPane();
    	sp.setBounds(10, 10, 495, 300);
		this.add(sp);
    	sp.setViewportView(table);
		
		
        //�ĸ���ť��� 
    	btnUpdate.setBounds(57,368,93,23);
    	this.add(btnUpdate);
    	
		btnAdd.setBounds(172, 368, 93, 23);
		this.add(btnAdd);

		btnModify.setBounds(287, 368, 93, 23);
		this.add(btnModify);
		
		btnRemove.setBounds(401, 368, 93, 23);
		this.add(btnRemove);

		//ˢ�¹���
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vector rowdata = new InOutInfoDao().getAll();
		    	DefaultTableModel   dtm =new DefaultTableModel(rowdata,colNames);
		        table.setModel(dtm);
			}
		});
		//��ӹ���
		btnAdd.addActionListener(this);
		//ɾ������
		btnRemove.addActionListener(this);
		//�޸Ĺ���
		btnModify.addActionListener(this);
		
	}
	
	
	public static void main(String[] args) {
		new InOutInfoFrame().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd){
			//1.��ʾ��ӵĶԻ���
			InOutDialog iod = new InOutDialog();
			iod.setModal(true);
			iod.setVisible(true);
			//2.ˢ��JTable
			Vector rowdata = new InOutInfoDao().getAll();
	    	DefaultTableModel   dtm =new DefaultTableModel(rowdata,colNames);
	        table.setModel(dtm);
		}else if(e.getSource() == btnModify){
			//1.��ʾ�޸ĵĶԻ���
			ModifyDialog md = new ModifyDialog();
			md.setModal(true);
			md.setVisible(true);
			//ˢ��JTable
			Vector rowdata = new InOutInfoDao().getAll();
	    	DefaultTableModel   dtm =new DefaultTableModel(rowdata,colNames);
	        table.setModel(dtm);
		}else if(e.getSource() == btnRemove){
			int index = table.getSelectedRow();
			int number = (Integer)table.getValueAt(index, 0);
			JOptionPane.showMessageDialog(null,"��ȷ��Ҫɾ����"+number+"��ô��");
			//����dao��delete����
			InOutInfoDao ioi = new InOutInfoDao();
			ioi.delete(number);
			//ˢ��JTable
			Vector rowdata = new InOutInfoDao().getAll();
	    	DefaultTableModel   dtm =new DefaultTableModel(rowdata,colNames);
	        table.setModel(dtm);
		}
		else{
			//�˳�
			this.dispose();
		}
		
	}

}

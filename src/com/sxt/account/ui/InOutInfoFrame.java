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
 * 创建收支类目管理类目--窗体
 * @author 勾润雪
 *2015-8-9
 * @version 1.0
 * @param <InOutInfo>
 */

public class InOutInfoFrame<InOutInfo> extends JFrame implements ActionListener{ 
	Vector colNames = new Vector();
	InOutInfoDao InOutDao = new InOutInfoDao();
	JTable table = new JTable();
	JButton btnAdd = new JButton("添    加");
	JButton btnRemove = new JButton("删    除");
	JButton btnModify = new JButton("修    改");
	JButton btnUpdate = new JButton("刷    新");
	public InOutInfoFrame(){
		init();
	}
	public void init(){
		
		//设置窗体基本属性
		this.setTitle("收支类目"); 
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 520, 450);  
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		//添加列名
		colNames.add("收支编号");
		colNames.add("类目名称");
		colNames.add("类别");
		colNames.add("用户名");
		colNames.add("说明");
//		colNames.add("remark1");
//		colNames.add("remark2");
//		colNames.add("remark3");
		
		//将数据展示到table中
    	Vector rowdata = new InOutInfoDao().getAll();
    	DefaultTableModel   dtm =new DefaultTableModel(rowdata,colNames);
        System.out.println(colNames);
    	table.setModel(dtm);
    	//将table加到滚动面板中
    	JScrollPane sp = new JScrollPane();
    	sp.setBounds(10, 10, 495, 300);
		this.add(sp);
    	sp.setViewportView(table);
		
		
        //四个按钮组件 
    	btnUpdate.setBounds(57,368,93,23);
    	this.add(btnUpdate);
    	
		btnAdd.setBounds(172, 368, 93, 23);
		this.add(btnAdd);

		btnModify.setBounds(287, 368, 93, 23);
		this.add(btnModify);
		
		btnRemove.setBounds(401, 368, 93, 23);
		this.add(btnRemove);

		//刷新功能
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vector rowdata = new InOutInfoDao().getAll();
		    	DefaultTableModel   dtm =new DefaultTableModel(rowdata,colNames);
		        table.setModel(dtm);
			}
		});
		//添加功能
		btnAdd.addActionListener(this);
		//删除功能
		btnRemove.addActionListener(this);
		//修改功能
		btnModify.addActionListener(this);
		
	}
	
	
	public static void main(String[] args) {
		new InOutInfoFrame().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd){
			//1.显示添加的对话框
			InOutDialog iod = new InOutDialog();
			iod.setModal(true);
			iod.setVisible(true);
			//2.刷新JTable
			Vector rowdata = new InOutInfoDao().getAll();
	    	DefaultTableModel   dtm =new DefaultTableModel(rowdata,colNames);
	        table.setModel(dtm);
		}else if(e.getSource() == btnModify){
			//1.显示修改的对话框
			ModifyDialog md = new ModifyDialog();
			md.setModal(true);
			md.setVisible(true);
			//刷新JTable
			Vector rowdata = new InOutInfoDao().getAll();
	    	DefaultTableModel   dtm =new DefaultTableModel(rowdata,colNames);
	        table.setModel(dtm);
		}else if(e.getSource() == btnRemove){
			int index = table.getSelectedRow();
			int number = (Integer)table.getValueAt(index, 0);
			JOptionPane.showMessageDialog(null,"您确定要删除第"+number+"项么？");
			//调用dao的delete方法
			InOutInfoDao ioi = new InOutInfoDao();
			ioi.delete(number);
			//刷新JTable
			Vector rowdata = new InOutInfoDao().getAll();
	    	DefaultTableModel   dtm =new DefaultTableModel(rowdata,colNames);
	        table.setModel(dtm);
		}
		else{
			//退出
			this.dispose();
		}
		
	}

}

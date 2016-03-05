package com.sxt.account.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sxt.account.bean.InOutInfo;
import com.sxt.account.dao.InOutInfoDao;
import com.sxt.account.dao.NoteInfoDao;

	/**
	 * 功能：修改的界面
	 * @author 仇艳
	 * 日期：2015.08.07
	 *
	 */

	public class SelectDialog extends JDialog implements ActionListener{
		JPanel pnlMain = new JPanel();
		JPanel pnlSouth = new JPanel();
		JButton btnConfirm = new JButton("确认");
		JButton btnCancel = new JButton("取消");
		JRadioButton rbtnOutcome;
		JRadioButton rbtnIncome;
		JComboBox cboAcType;
		JComboBox cboForm;
		JTextField txtDate;
		JTextField txtMoney;
		JTextArea txtNotes;
		InOutInfoDao iid = new InOutInfoDao();
		NoteInfoDao nid = new NoteInfoDao();
		public SelectDialog(){
			init();
		}
		public void init(){
			
			//窗体设置
			this.setTitle("记一笔");
			this.setSize(600, 450);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setLayout(new BorderLayout());
			
			//主面板设置边界布局
			pnlMain.setLayout(new FlowLayout(10,20,20));
			//添加外围框线
			pnlMain.setBorder(BorderFactory.createTitledBorder(""));
			
			//记账类型
			ButtonGroup btnGroup = new ButtonGroup();
			JLabel lblNoteForm = new JLabel("记账类型->");
			rbtnIncome = new JRadioButton("收入");
			rbtnOutcome = new JRadioButton("支出");
			btnGroup.add(rbtnIncome);
			btnGroup.add(rbtnOutcome);
			
			lblNoteForm.setPreferredSize(new Dimension(150,30));
			rbtnIncome.setPreferredSize(new Dimension(158,30));
			rbtnOutcome.setPreferredSize(new Dimension(158,30));
			
			//记账等的主要信息 
			JLabel lblAcTyoe  = new JLabel("当前账户");
			JLabel lblForm  = new JLabel("收支分类");
			JLabel lblDate  = new JLabel("日期");
			JLabel lblMoney  = new JLabel("金额");
			JLabel lblNotes  = new JLabel("备注");
			
			cboAcType = new JComboBox();
			cboForm  = new JComboBox();
			txtDate = new JTextField("系统默认时间");
			txtMoney = new JTextField();
			txtNotes = new JTextArea();
			//为组件设置值
			cboAcType.addItem("----请选择----");
			cboAcType.addItem("银行卡");
			cboAcType.addItem("现金");
			cboAcType.addItem("网银");
			
			cboForm.addItem("----请选择----");
			ArrayList<InOutInfo> iois =iid.takeAll();
			for(InOutInfo  si:iois){
				cboForm.addItem(si.toString());
			}
			//为组件设置大小
			lblAcTyoe.setPreferredSize(new Dimension(100,30));
			cboAcType.setPreferredSize(new Dimension(120,20));
			lblForm.setPreferredSize(new Dimension(100,30));
			cboForm.setPreferredSize(new Dimension(120,20));
			lblDate.setPreferredSize(new Dimension(100,30));
			txtDate.setPreferredSize(new Dimension(120,20));
			lblMoney.setPreferredSize(new Dimension(100,30));
			txtMoney.setPreferredSize(new Dimension(120,20));
			lblNotes.setPreferredSize(new Dimension(100,30));
			txtNotes.setPreferredSize(new Dimension(500,200));
			
			//添加组件
			pnlMain.add(lblNoteForm);
			pnlMain.add(rbtnIncome);
			pnlMain.add(rbtnOutcome);
			
			pnlMain.add(lblAcTyoe);
			pnlMain.add(cboAcType);
			pnlMain.add(lblForm);
			pnlMain.add(cboForm);
			pnlMain.add(lblDate);
			pnlMain.add(txtDate);
			pnlMain.add(lblMoney);
			pnlMain.add(txtMoney);
			
			pnlMain.add(lblNotes);
			pnlMain.add(txtNotes);
			
			
			pnlSouth.add(btnConfirm);
			pnlSouth.add(btnCancel);
			
			rbtnIncome.addActionListener(this);
			rbtnOutcome.addActionListener(this);
			btnConfirm.addActionListener(this);
			btnCancel.addActionListener(this);
			
			this.add(pnlMain);
			this.add(pnlSouth,BorderLayout.SOUTH);
			
		}
		
		String form;
		int id;
		private Vector data = new Vector();
//		private ArrayList<String> ssss = new ArrayList<String>();
//		
//		public ArrayList<String> getSsss() {
//			System.out.println(ssss);
//			return ssss;
//		}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnCancel){
				this.dispose();
			}
			if(e.getSource()==rbtnIncome){
				form = "收入";
//				System.out.println(form);
			}
			if(e.getSource()==rbtnOutcome){
				form = "支出";
//				System.out.println(form);
			}
			if(e.getSource()==btnConfirm){
				String sql;
				if(rbtnIncome.isSelected()){
					 sql = "select rownum ,n.* from NoteInfo n where form ='收入' order by nid";
				}else
					if(rbtnOutcome.isSelected()){
					
						sql = "select rownum ,n.* from NoteInfo n where form ='支出' order by nid";
//						data = new NoteInfoDao().select(sql);
//						ssss.add("haha");
//						System.out.println(ssss);
//						System.out.println(data);
//					//	this.dispose();
//						return;
//						
					}else
						if(!cboAcType.getSelectedItem().equals("")){
							 sql = "select rownum ,n.* from NoteInfo n where AcType ='"+cboAcType.getSelectedItem()+"' order by nid";
						}else
							if(!cboForm.getSelectedItem().equals("")){
								 sql = "select rownum ,n.* from NoteInfo n where typeName ='"+cboForm.getSelectedItem()+"' order by nid";
							}
							else
								if(!txtMoney.getText().equals("")){
									 sql = "select rownum ,n.* from NoteInfo n where money='"+txtMoney.getText().trim()+"' order by nid";
								}
								else
									if(!txtNotes.getText().equals("")){
										 sql = "select rownum ,n.* from NoteInfo n where notes='"+txtNotes.getText().trim()+"' order by nid";
									}else {
											sql="select rownum ,n.* from NoteInfo n order by nid";
							}
//				System.out.println(sql);
//				data = new NoteInfoDao().select(sql);
//				ssss.add("haha");
//				System.out.println(ssss);
//				System.out.println(data);
//				this.dispose();
				
			}
			
		}
		public Vector getData(){
			return data;
		} 
		public void getNid(int nid){
			this.id = nid;
		}
//		public static void main(String[] args) {
//			
//			new SelectDialog().setVisible(true);
//		}

	}


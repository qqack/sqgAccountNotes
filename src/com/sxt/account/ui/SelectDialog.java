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
	 * ���ܣ��޸ĵĽ���
	 * @author ����
	 * ���ڣ�2015.08.07
	 *
	 */

	public class SelectDialog extends JDialog implements ActionListener{
		JPanel pnlMain = new JPanel();
		JPanel pnlSouth = new JPanel();
		JButton btnConfirm = new JButton("ȷ��");
		JButton btnCancel = new JButton("ȡ��");
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
			
			//��������
			this.setTitle("��һ��");
			this.setSize(600, 450);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.setLayout(new BorderLayout());
			
			//��������ñ߽粼��
			pnlMain.setLayout(new FlowLayout(10,20,20));
			//�����Χ����
			pnlMain.setBorder(BorderFactory.createTitledBorder(""));
			
			//��������
			ButtonGroup btnGroup = new ButtonGroup();
			JLabel lblNoteForm = new JLabel("��������->");
			rbtnIncome = new JRadioButton("����");
			rbtnOutcome = new JRadioButton("֧��");
			btnGroup.add(rbtnIncome);
			btnGroup.add(rbtnOutcome);
			
			lblNoteForm.setPreferredSize(new Dimension(150,30));
			rbtnIncome.setPreferredSize(new Dimension(158,30));
			rbtnOutcome.setPreferredSize(new Dimension(158,30));
			
			//���˵ȵ���Ҫ��Ϣ 
			JLabel lblAcTyoe  = new JLabel("��ǰ�˻�");
			JLabel lblForm  = new JLabel("��֧����");
			JLabel lblDate  = new JLabel("����");
			JLabel lblMoney  = new JLabel("���");
			JLabel lblNotes  = new JLabel("��ע");
			
			cboAcType = new JComboBox();
			cboForm  = new JComboBox();
			txtDate = new JTextField("ϵͳĬ��ʱ��");
			txtMoney = new JTextField();
			txtNotes = new JTextArea();
			//Ϊ�������ֵ
			cboAcType.addItem("----��ѡ��----");
			cboAcType.addItem("���п�");
			cboAcType.addItem("�ֽ�");
			cboAcType.addItem("����");
			
			cboForm.addItem("----��ѡ��----");
			ArrayList<InOutInfo> iois =iid.takeAll();
			for(InOutInfo  si:iois){
				cboForm.addItem(si.toString());
			}
			//Ϊ������ô�С
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
			
			//������
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
				form = "����";
//				System.out.println(form);
			}
			if(e.getSource()==rbtnOutcome){
				form = "֧��";
//				System.out.println(form);
			}
			if(e.getSource()==btnConfirm){
				String sql;
				if(rbtnIncome.isSelected()){
					 sql = "select rownum ,n.* from NoteInfo n where form ='����' order by nid";
				}else
					if(rbtnOutcome.isSelected()){
					
						sql = "select rownum ,n.* from NoteInfo n where form ='֧��' order by nid";
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


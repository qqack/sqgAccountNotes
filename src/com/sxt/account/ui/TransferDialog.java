package com.sxt.account.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * @���ܣ��˻�ת��
 * @author ����
 * @time:2015.08.12
 * @version: 1.0
 *
 */
public class TransferDialog extends JDialog implements ActionListener{
	JPanel pnlMain = new JPanel();
	JPanel pnlSouth = new JPanel();
	JButton btnConfirm = new JButton("ȷ��");
	JButton btnCancel = new JButton("ȡ��");
	JRadioButton rbtnOutcome;
	JRadioButton rbtnIncome;
	public TransferDialog(){
		init();
	}
	public void init(){
		
		//��������
		this.setTitle("�˻�ת��");
		this.setSize(600, 450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		//��������ñ߽粼��
		pnlMain.setLayout(new FlowLayout(10,20,20));
		//�����Χ����
		pnlMain.setBorder(BorderFactory.createTitledBorder(""));
		
		//��������
//		JLabel lblNoteForm = new JLabel("ת������->");
//		rbtnIncome = new JRadioButton("����");
//		rbtnOutcome = new JRadioButton("֧��");
//		lblNoteForm.setPreferredSize(new Dimension(150,30));
//		rbtnIncome.setPreferredSize(new Dimension(158,30));
//		rbtnOutcome.setPreferredSize(new Dimension(158,30));
		
		//ת�˵ȵ���Ҫ��Ϣ 
		JLabel lblAcTypeIn  = new JLabel("ת���˻�");
		JLabel lblAcTypeOut  = new JLabel("ת���˻�");
		JLabel lblDate  = new JLabel("ת������");
		JLabel lblMoney  = new JLabel("���");
		JLabel lblNotes  = new JLabel("ת�˱�ע");
		
		JComboBox cboAcTypeIn = new JComboBox();
		JComboBox cboAcTypeOut  = new JComboBox();
		JTextField txtDate = new JTextField();
		JTextField txtMoney = new JTextField();
		JTextArea txtNotes = new JTextArea();
		//Ϊ�������ֵ
		cboAcTypeIn.addItem("----��ѡ��----");
		cboAcTypeIn.addItem("���п�");
		cboAcTypeIn.addItem("�ֽ�");
		cboAcTypeIn.addItem("����");
		
		cboAcTypeOut.addItem("----��ѡ��----");
		cboAcTypeOut.addItem("���п�");
		cboAcTypeOut.addItem("�ֽ�");
		cboAcTypeOut.addItem("����");
		
		//Ϊ������ô�С
		lblAcTypeIn.setPreferredSize(new Dimension(100,30));
		cboAcTypeIn.setPreferredSize(new Dimension(120,20));
		lblAcTypeOut.setPreferredSize(new Dimension(100,30));
		cboAcTypeOut.setPreferredSize(new Dimension(120,20));
		lblDate.setPreferredSize(new Dimension(100,30));
		txtDate.setPreferredSize(new Dimension(120,20));
		lblMoney.setPreferredSize(new Dimension(100,30));
		txtMoney.setPreferredSize(new Dimension(120,20));
		lblNotes.setPreferredSize(new Dimension(100,30));
		txtNotes.setPreferredSize(new Dimension(500,200));
		
		//������
//		pnlMain.add(lblNoteForm);
//		pnlMain.add(rbtnIncome);
//		pnlMain.add(rbtnOutcome);
		
		pnlMain.add(lblAcTypeIn);
		pnlMain.add(cboAcTypeIn);
		pnlMain.add(lblAcTypeOut);
		pnlMain.add(cboAcTypeOut);
		pnlMain.add(lblDate);
		pnlMain.add(txtDate);
		pnlMain.add(lblMoney);
		pnlMain.add(txtMoney);
		
		pnlMain.add(lblNotes);
		pnlMain.add(txtNotes);
		
		
		pnlSouth.add(btnConfirm);
		pnlSouth.add(btnCancel);
		
		btnCancel.addActionListener(this);
		
		this.add(pnlMain);
		this.add(pnlSouth,BorderLayout.SOUTH);
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCancel){
			this.dispose();
		}
		
	}
	
	public static void main(String[] args) {
		
		new TransferDialog().setVisible(true);
	}

}

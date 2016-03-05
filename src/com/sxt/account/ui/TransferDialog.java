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
 * @功能：账户转账
 * @author 仇艳
 * @time:2015.08.12
 * @version: 1.0
 *
 */
public class TransferDialog extends JDialog implements ActionListener{
	JPanel pnlMain = new JPanel();
	JPanel pnlSouth = new JPanel();
	JButton btnConfirm = new JButton("确认");
	JButton btnCancel = new JButton("取消");
	JRadioButton rbtnOutcome;
	JRadioButton rbtnIncome;
	public TransferDialog(){
		init();
	}
	public void init(){
		
		//窗体设置
		this.setTitle("账户转账");
		this.setSize(600, 450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		//主面板设置边界布局
		pnlMain.setLayout(new FlowLayout(10,20,20));
		//添加外围框线
		pnlMain.setBorder(BorderFactory.createTitledBorder(""));
		
		//记账类型
//		JLabel lblNoteForm = new JLabel("转账类型->");
//		rbtnIncome = new JRadioButton("收入");
//		rbtnOutcome = new JRadioButton("支出");
//		lblNoteForm.setPreferredSize(new Dimension(150,30));
//		rbtnIncome.setPreferredSize(new Dimension(158,30));
//		rbtnOutcome.setPreferredSize(new Dimension(158,30));
		
		//转账等的主要信息 
		JLabel lblAcTypeIn  = new JLabel("转出账户");
		JLabel lblAcTypeOut  = new JLabel("转入账户");
		JLabel lblDate  = new JLabel("转账日期");
		JLabel lblMoney  = new JLabel("金额");
		JLabel lblNotes  = new JLabel("转账备注");
		
		JComboBox cboAcTypeIn = new JComboBox();
		JComboBox cboAcTypeOut  = new JComboBox();
		JTextField txtDate = new JTextField();
		JTextField txtMoney = new JTextField();
		JTextArea txtNotes = new JTextArea();
		//为组件设置值
		cboAcTypeIn.addItem("----请选择----");
		cboAcTypeIn.addItem("银行卡");
		cboAcTypeIn.addItem("现金");
		cboAcTypeIn.addItem("网银");
		
		cboAcTypeOut.addItem("----请选择----");
		cboAcTypeOut.addItem("银行卡");
		cboAcTypeOut.addItem("现金");
		cboAcTypeOut.addItem("网银");
		
		//为组件设置大小
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
		
		//添加组件
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

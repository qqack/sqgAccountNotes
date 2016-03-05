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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sxt.account.dao.InOutInfoDao;
/**
 * @功能：调整余额
 * @author 仇艳
 * @time:2015.08.12
 * @version: 1.0
 *
 */
public class ChangeMoneyDialog extends JDialog implements ActionListener{

	JPanel pnlMain = new JPanel();
	JPanel pnlSouth = new JPanel();
	JButton btnConfirm = new JButton("确认");
	JButton btnCancel = new JButton("取消");
	JRadioButton rbtnOutcome;
	JRadioButton rbtnIncome;
	JComboBox cboAcTypeIn = new JComboBox();
	JComboBox cboOpMan  = new JComboBox();
	JTextField txtDate = new JTextField();
	JTextField txtMoney = new JTextField();
	JTextField txtRealMoney = new JTextField();
	JTextArea txtNotes = new JTextArea();
	public ChangeMoneyDialog(){
		init();
	}
	public void init(){
		
		//窗体设置
		this.setTitle("调整余额");
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
		JLabel lblAcTypeIn  = new JLabel("账户名称");
		JLabel lblOpMan  = new JLabel("操作人员");
		JLabel lblDate  = new JLabel("对账日期");
		JLabel lblMoney  = new JLabel("账面余额");
		JLabel lblRealMoney  = new JLabel("实际余额");
		JLabel lblNotes  = new JLabel("转账备注:");
		

		//为组件设置值
		cboAcTypeIn.addItem("----请选择----");
		cboAcTypeIn.addItem("银行卡");
		cboAcTypeIn.addItem("现金");
		cboAcTypeIn.addItem("网银");
		
		cboOpMan.addItem("----请选择----");
		cboOpMan.addItem("本人");
		
		//为组件设置大小
		lblAcTypeIn.setPreferredSize(new Dimension(100,30));
		cboAcTypeIn.setPreferredSize(new Dimension(120,20));
		lblOpMan.setPreferredSize(new Dimension(100,30));
		cboOpMan.setPreferredSize(new Dimension(120,20));
		lblDate.setPreferredSize(new Dimension(100,30));
		txtDate.setPreferredSize(new Dimension(120,20));
		lblMoney.setPreferredSize(new Dimension(100,30));
		txtMoney.setPreferredSize(new Dimension(120,20));
		lblRealMoney.setPreferredSize(new Dimension(100,30));
		txtRealMoney.setPreferredSize(new Dimension(120,20));
		lblNotes.setPreferredSize(new Dimension(100,30));
		txtNotes.setPreferredSize(new Dimension(500,200));
		
		//添加组件
//		pnlMain.add(lblNoteForm);
//		pnlMain.add(rbtnIncome);
//		pnlMain.add(rbtnOutcome);
		
		pnlMain.add(lblAcTypeIn);
		pnlMain.add(cboAcTypeIn);
		pnlMain.add(lblOpMan);
		pnlMain.add(cboOpMan);
		pnlMain.add(lblDate);
		pnlMain.add(txtDate);
		pnlMain.add(lblMoney);
		pnlMain.add(txtMoney);
		pnlMain.add(lblRealMoney);
		pnlMain.add(txtRealMoney);
		pnlMain.add(lblNotes);
		pnlMain.add(txtNotes);
		
		
		pnlSouth.add(btnConfirm);
		pnlSouth.add(btnCancel);
		
		btnCancel.addActionListener(this);
		btnConfirm.addActionListener(this);
		
		this.add(pnlMain);
		this.add(pnlSouth,BorderLayout.SOUTH);
		
	}

	InOutInfoDao iid = new InOutInfoDao();
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCancel){
			this.dispose();
		}if(e.getSource()==btnConfirm){
			String newMoney = txtRealMoney.getText().trim();
			String notes = txtNotes.getText().trim();
			String acc = cboAcTypeIn.getSelectedItem().toString();
			String sql = "update AccountInfo set balance ="+newMoney+" where actype ='"+acc+"' ";
			JOptionPane.showMessageDialog(null, "调整余额成功！");
		}
		if(e.getSource()==cboAcTypeIn.getSelectedItem()){
			String acc = cboAcTypeIn.getSelectedItem().toString();
			String sql1 = "select balance from AccountInfo where actype ='"+acc+"'";
			System.out.println(sql1);
			txtMoney.setText(iid.seleleMoney(sql1));
		}
		
	}
	public static void main(String[] args) {
		new ChangeMoneyDialog().setVisible(true);
	}


}

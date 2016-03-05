package com.sxt.account.ui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * @功能：年度报表
 * @author 仇艳
 * @time:2015.08.12
 * @version: 1.0
 *
 */
public class YearTableFrame extends JFrame{
	public YearTableFrame(){
		init();
	}
	public void init(){
		
		 //设置标题
		 this.setTitle("年度报表");
		 //设置大小
		 this.setSize(800,500);
		 //设置位置(居中)
		 this.setLocationRelativeTo(null);
		 //设置关闭的行为
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 //设置布局
		 this.setLayout(new BorderLayout());
		 
		 JLabel lblTitle = new JLabel("年度收支统计表");
		 JLabel lblBook = new JLabel("账簿：我的家庭账");
		 JLabel lblMoney = new JLabel("货币单位：人民币元");
		 
		 JLabel lblTable = new JLabel();
		 lblTable.setIcon(new ImageIcon("imgs/table.png"));
		 lblTable.setBounds(20, 100,750,400);
		 lblTitle.setBounds(200, 20, 200, 50);
		 lblBook.setBounds(20, 70, 200, 30);
		 lblMoney.setBounds(600, 70, 200, 30);
		 
		 
		 this.add(lblTitle);
		 this.add(lblBook);
		 this.add(lblMoney);
		 this.add(lblTable);
		 
	}
	
	public static void main(String[] args) {
		new YearTableFrame().setVisible(true);

	}

}

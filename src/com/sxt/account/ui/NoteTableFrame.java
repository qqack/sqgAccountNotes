package com.sxt.account.ui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.sxt.account.dao.NoteInfoDao;
/**
 * @功能：报表中心
 * @author 仇艳
 * @time:2015.08.12
 * @version: 1.0
 *
 */
public class NoteTableFrame extends JFrame{
	JPanel pnlMain;
	JTabbedPane  tabbedPane =new JTabbedPane();
	Vector colNames = new Vector();
	JTable table = new JTable();
	JButton btnDaily,btnYear;
	public NoteTableFrame(){
		init();
	}
	public void init(){
		
		 //设置标题
		 this.setTitle("我的报表中心");
		 //设置大小
		 this.setSize(800,500);
		 //设置位置(居中)
		 this.setLocationRelativeTo(null);
		 //设置关闭的行为
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 //设置布局
		 this.setLayout(new BorderLayout());
		 btnDaily = new JButton("日常收支统计表");
		 btnYear = new JButton("收支年度统计表");
		 JLabel lblDaily = new JLabel("统计某段时间内所有收支分布情况。也就是家庭损益表。");
		 JLabel lblYear = new JLabel("统计一个年度内，您的所有收支项目在每个月的累计发生额。");
		 
		 btnDaily.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				new NormalInOutFrame().setVisible(true);
				
			}
		});
		 btnYear.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					new YearTableFrame().setVisible(true);
					
				}
			});
		 
		 //分页面板
		 pnlMain = new JPanel();
		 pnlMain.setLayout(new FlowLayout(20,20,20));
		 btnDaily.setPreferredSize(new Dimension(200,30));
		 lblDaily.setPreferredSize(new Dimension(500,30));
		 btnYear.setPreferredSize(new Dimension(200,30));
		 pnlMain.add(btnDaily);
		 pnlMain.add(lblDaily);
		 pnlMain.add(btnYear);
		 pnlMain.add(lblYear);
		 tabbedPane.add("我的报表中心", pnlMain);
		 this.add(tabbedPane);
		 
		 }
	
	public static void main(String[] args) {
		new NoteTableFrame().setVisible(true);
	}
}
	

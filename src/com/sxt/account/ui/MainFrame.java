package com.sxt.account.ui;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.theme.SubstanceLightAquaTheme;
import org.jvnet.substance.theme.SubstanceOliveTheme;
import org.jvnet.substance.theme.SubstancePurpleTheme;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;

import com.sxt.account.util.ImageHelper;
/**
 * @功能：主界面的实现 
 * @author 仇艳
 * @时间：2015.08.11
 * @version 1.0
 */
public class MainFrame extends JFrame implements TreeSelectionListener{
	  JTabbedPane  tabbedPaneWest =new JTabbedPane();
	  JTabbedPane  tabbedPaneMain =new JTabbedPane();
	  
	public MainFrame(){
		init();
	}
	public void init(){
		
		 //设置标题
		 this.setTitle("账簿(Master)--随手记");
		 //设置大小
		 this.setSize(1000,700);
		 //设置位置(居中)
		 this.setIconImage(new ImageIcon("imgs/icon.jpg").getImage());
		 this.setLocationRelativeTo(null);
		 //设置关闭的行为
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 //设置布局
		 this.setLayout(new BorderLayout());
		 //分割面板
		 JPanel pnlWest = new JPanel();
		 JPanel pnlMain = new JPanel();
		 pnlWest.setBorder(BorderFactory.createTitledBorder(""));
		 pnlMain.setBorder(BorderFactory.createTitledBorder(""));
		 //添加分页面板
		 tabbedPaneMain.add("收支记账",new NormalInOutFrame().pnlMain);
		 tabbedPaneMain.add("报表中心",new NoteTableFrame().pnlMain);
		 //pnlMain.add(tabbedPaneMain);
		 this.add(pnlWest,BorderLayout.WEST);
		 this.add(tabbedPaneMain);
		 //添加菜单栏
		 JMenuBar mb=new JMenuBar();
		 
		 //菜单
		 JMenu fileMenu=new JMenu("文件");
		 JMenu financeMenu=new JMenu("财务");
		 JMenu assetMenu=new JMenu("资产");
		 JMenu detailMenu=new JMenu("明细查看");
		 JMenu setMenu=new JMenu("设置");
		 JMenu helpMenu=new JMenu("帮助");
		 //文件的菜单项
		 JMenuItem newItem=new JMenuItem("新建");
		 JMenuItem openItem=new JMenuItem("打开");
		 JMenuItem closeItem=new JMenuItem("关闭");
		 JMenuItem bookManageItem=new JMenuItem("账簿管理中心");
//		 JMenuItem pwdSetItem=new JMenuItem("密码设置");
		 
		 newItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AddBookFrame(null).setVisible(true);
			}
		});
		 openItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new MyNoteFrame().setVisible(true);
				}
			});
		 closeItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.exit(0);
				}
			});
		 bookManageItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new BookFrame().setVisible(true);
				}
			});
		 //财务的菜单项
		 JMenuItem firstItem=new JMenuItem("家庭首页");
		 JMenuItem accountItem=new JMenuItem("账户列表");
		 JMenuItem ioItem=new JMenuItem("收支类目");
//		 JMenuItem newAccItem=new JMenuItem("新建账户");
		 //资产的菜单项
		 JMenuItem assetItem=new JMenuItem("资产中心");
		 //报表的菜单项
		 JMenuItem dayItem=new JMenuItem("日常收支");
		 JMenuItem yearItem=new JMenuItem("年度收支");
		 dayItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new  NormalInOutFrame().setVisible(true);
				
			}
		});
		 yearItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new  YearTableFrame().setVisible(true);
					
				}
			});
		 accountItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new  AccountInfoFrame().setVisible(true);
					
				}
			});
		 ioItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new  InOutInfoFrame().setVisible(true);
					
				}
			});
		 //设置的菜单项
		 //帮助的菜单项
//		 JMenuItem aboutItem=new JMenuItem("关于");
		 //添加菜单项到菜单
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(closeItem);
		fileMenu.add(bookManageItem);
//		fileMenu.add(pwdSetItem);
		financeMenu.add(firstItem);
		financeMenu.add(accountItem);
		financeMenu.add(ioItem);
//		financeMenu.add(newAccItem);
		assetMenu.add(assetItem);
		detailMenu.add(dayItem);
		detailMenu.add(yearItem);
//		setMenu.add(assetItem);
//		helpMenu.add(aboutItem);
		
		mb.add(fileMenu);
		mb.add(financeMenu);
		mb.add(assetMenu);
		mb.add(detailMenu);
		mb.add(setMenu);
		mb.add(helpMenu);
		
		//将菜单添加到窗体中
		this.setJMenuBar( mb );
		//设置工具栏
		JToolBar  toolBar =new JToolBar();
		this.add(toolBar,BorderLayout.NORTH);
		//工具栏项
		
		JButton btnNewNote = new JButton("记一笔");
		JButton btnAccount = new JButton("账户列表");
		JButton btnInOutType = new JButton("收支类目");
		JButton btnAllNotes = new JButton("报表中心");
		
		//设置组件

		
		btnNewNote.setIcon(ImageHelper.getScaledIcon(50, 40, "imgs/newNote.jpg"));
		//图片在文本的上方
		btnNewNote.setIconTextGap(2);  
		btnNewNote.setHorizontalTextPosition(JButton.CENTER); 
		btnNewNote.setVerticalTextPosition(JButton.BOTTOM);
		toolBar.addSeparator();
		
		btnAccount.setIcon(ImageHelper.getScaledIcon(50, 40, "imgs/account.png"));
		//图片在文本的上方
		btnAccount.setIconTextGap(2);  
		btnAccount.setHorizontalTextPosition(JButton.CENTER); 
		btnAccount.setVerticalTextPosition(JButton.BOTTOM);
		toolBar.addSeparator();
		
		btnInOutType.setIcon(ImageHelper.getScaledIcon(50,40, "imgs/type.jpg"));
		//图片在文本的上方
		btnInOutType.setIconTextGap(2);  
		btnInOutType.setHorizontalTextPosition(JButton.CENTER); 
		btnInOutType.setVerticalTextPosition(JButton.BOTTOM);
		toolBar.addSeparator();
		
		btnAllNotes.setIcon(ImageHelper.getScaledIcon(50, 40, "imgs/all.png"));
		//图片在文本的上方
		btnAllNotes.setIconTextGap(2);  
		btnAllNotes.setHorizontalTextPosition(JButton.CENTER); 
		btnAllNotes.setVerticalTextPosition(JButton.BOTTOM);
		toolBar.addSeparator();
		
		//添加监听
		btnNewNote.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				new NoteDialog().setVisible(true);
			}
		});
		btnAllNotes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				new NoteTableFrame().setVisible(true);
			}
		});
		
		btnAccount.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				new AccountInfoFrame().setVisible(true);
			}
		});
		btnInOutType.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				new InOutInfoFrame().setVisible(true);
			}
		});
		
		//添加工具栏项

		toolBar.add(btnNewNote);
		toolBar.add(btnAccount);
		toolBar.add(btnInOutType);
		toolBar.add(btnAllNotes);
		
		//添加树
		  JPanel pnlNotes = new JPanel();
		  JPanel pnlAllNotes = new JPanel();
		  JPanel pnlAccount = new JPanel();
		  //账本树
		  DefaultMutableTreeNode   root =new DefaultMutableTreeNode("我的账本");
		  JTree  tree =new JTree(root);
		  DefaultMutableTreeNode   notes1=new DefaultMutableTreeNode("家庭账本");
		  DefaultMutableTreeNode   notes2 =new DefaultMutableTreeNode("工作账本");
		  DefaultMutableTreeNode   notes3 =new DefaultMutableTreeNode("旅游账本");
		  root.add(notes1);
		  root.add(notes2);
		  root.add(notes3);
		  pnlNotes.add(tree);
		  //报表树
		  DefaultMutableTreeNode   allRoot =new DefaultMutableTreeNode("我的报表");
		  JTree  treeAll =new JTree(allRoot);
		  DefaultMutableTreeNode   all1=new DefaultMutableTreeNode("日常报表");
		  DefaultMutableTreeNode   all2 =new DefaultMutableTreeNode("年度报表");
		  allRoot.add(all1);
		  allRoot.add(all2);
		  pnlAllNotes.add(treeAll);
		  //账户树
		  DefaultMutableTreeNode   accRoot =new DefaultMutableTreeNode("我的账户");
		  JTree  treeAcc =new JTree(accRoot);
		  DefaultMutableTreeNode   acc1=new DefaultMutableTreeNode("银行卡");
		  DefaultMutableTreeNode   acc2 =new DefaultMutableTreeNode("现金");
		  DefaultMutableTreeNode   acc3 =new DefaultMutableTreeNode("网银");
		  accRoot.add(acc1);
		  accRoot.add(acc2);
		  accRoot.add(acc3);
		  pnlAccount.add(treeAcc);
		  //左边的分页面板
		  tabbedPaneWest.setTabPlacement(JTabbedPane.LEFT);
		  tabbedPaneWest.add("账本",pnlNotes);
		  tabbedPaneWest.add("报表",pnlAllNotes);
		  tabbedPaneWest.add("账户",pnlAccount);
		  pnlWest.add(tabbedPaneWest,BorderLayout.WEST);
		  tabbedPaneWest.setPreferredSize(new Dimension(160,600));

		
	}
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode  treeNode=(DefaultMutableTreeNode)e.getPath().getLastPathComponent();
		if(treeNode.isLeaf()){
			JOptionPane.showMessageDialog(null,treeNode.toString());
		}
	}	
	public static void main(String[] args) {
		new MainFrame().setVisible(true);
	}

}


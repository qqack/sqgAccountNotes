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
 * @���ܣ��������ʵ�� 
 * @author ����
 * @ʱ�䣺2015.08.11
 * @version 1.0
 */
public class MainFrame extends JFrame implements TreeSelectionListener{
	  JTabbedPane  tabbedPaneWest =new JTabbedPane();
	  JTabbedPane  tabbedPaneMain =new JTabbedPane();
	  
	public MainFrame(){
		init();
	}
	public void init(){
		
		 //���ñ���
		 this.setTitle("�˲�(Master)--���ּ�");
		 //���ô�С
		 this.setSize(1000,700);
		 //����λ��(����)
		 this.setIconImage(new ImageIcon("imgs/icon.jpg").getImage());
		 this.setLocationRelativeTo(null);
		 //���ùرյ���Ϊ
		 this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 //���ò���
		 this.setLayout(new BorderLayout());
		 //�ָ����
		 JPanel pnlWest = new JPanel();
		 JPanel pnlMain = new JPanel();
		 pnlWest.setBorder(BorderFactory.createTitledBorder(""));
		 pnlMain.setBorder(BorderFactory.createTitledBorder(""));
		 //��ӷ�ҳ���
		 tabbedPaneMain.add("��֧����",new NormalInOutFrame().pnlMain);
		 tabbedPaneMain.add("��������",new NoteTableFrame().pnlMain);
		 //pnlMain.add(tabbedPaneMain);
		 this.add(pnlWest,BorderLayout.WEST);
		 this.add(tabbedPaneMain);
		 //��Ӳ˵���
		 JMenuBar mb=new JMenuBar();
		 
		 //�˵�
		 JMenu fileMenu=new JMenu("�ļ�");
		 JMenu financeMenu=new JMenu("����");
		 JMenu assetMenu=new JMenu("�ʲ�");
		 JMenu detailMenu=new JMenu("��ϸ�鿴");
		 JMenu setMenu=new JMenu("����");
		 JMenu helpMenu=new JMenu("����");
		 //�ļ��Ĳ˵���
		 JMenuItem newItem=new JMenuItem("�½�");
		 JMenuItem openItem=new JMenuItem("��");
		 JMenuItem closeItem=new JMenuItem("�ر�");
		 JMenuItem bookManageItem=new JMenuItem("�˲���������");
//		 JMenuItem pwdSetItem=new JMenuItem("��������");
		 
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
		 //����Ĳ˵���
		 JMenuItem firstItem=new JMenuItem("��ͥ��ҳ");
		 JMenuItem accountItem=new JMenuItem("�˻��б�");
		 JMenuItem ioItem=new JMenuItem("��֧��Ŀ");
//		 JMenuItem newAccItem=new JMenuItem("�½��˻�");
		 //�ʲ��Ĳ˵���
		 JMenuItem assetItem=new JMenuItem("�ʲ�����");
		 //����Ĳ˵���
		 JMenuItem dayItem=new JMenuItem("�ճ���֧");
		 JMenuItem yearItem=new JMenuItem("�����֧");
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
		 //���õĲ˵���
		 //�����Ĳ˵���
//		 JMenuItem aboutItem=new JMenuItem("����");
		 //��Ӳ˵���˵�
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
		
		//���˵���ӵ�������
		this.setJMenuBar( mb );
		//���ù�����
		JToolBar  toolBar =new JToolBar();
		this.add(toolBar,BorderLayout.NORTH);
		//��������
		
		JButton btnNewNote = new JButton("��һ��");
		JButton btnAccount = new JButton("�˻��б�");
		JButton btnInOutType = new JButton("��֧��Ŀ");
		JButton btnAllNotes = new JButton("��������");
		
		//�������

		
		btnNewNote.setIcon(ImageHelper.getScaledIcon(50, 40, "imgs/newNote.jpg"));
		//ͼƬ���ı����Ϸ�
		btnNewNote.setIconTextGap(2);  
		btnNewNote.setHorizontalTextPosition(JButton.CENTER); 
		btnNewNote.setVerticalTextPosition(JButton.BOTTOM);
		toolBar.addSeparator();
		
		btnAccount.setIcon(ImageHelper.getScaledIcon(50, 40, "imgs/account.png"));
		//ͼƬ���ı����Ϸ�
		btnAccount.setIconTextGap(2);  
		btnAccount.setHorizontalTextPosition(JButton.CENTER); 
		btnAccount.setVerticalTextPosition(JButton.BOTTOM);
		toolBar.addSeparator();
		
		btnInOutType.setIcon(ImageHelper.getScaledIcon(50,40, "imgs/type.jpg"));
		//ͼƬ���ı����Ϸ�
		btnInOutType.setIconTextGap(2);  
		btnInOutType.setHorizontalTextPosition(JButton.CENTER); 
		btnInOutType.setVerticalTextPosition(JButton.BOTTOM);
		toolBar.addSeparator();
		
		btnAllNotes.setIcon(ImageHelper.getScaledIcon(50, 40, "imgs/all.png"));
		//ͼƬ���ı����Ϸ�
		btnAllNotes.setIconTextGap(2);  
		btnAllNotes.setHorizontalTextPosition(JButton.CENTER); 
		btnAllNotes.setVerticalTextPosition(JButton.BOTTOM);
		toolBar.addSeparator();
		
		//��Ӽ���
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
		
		//��ӹ�������

		toolBar.add(btnNewNote);
		toolBar.add(btnAccount);
		toolBar.add(btnInOutType);
		toolBar.add(btnAllNotes);
		
		//�����
		  JPanel pnlNotes = new JPanel();
		  JPanel pnlAllNotes = new JPanel();
		  JPanel pnlAccount = new JPanel();
		  //�˱���
		  DefaultMutableTreeNode   root =new DefaultMutableTreeNode("�ҵ��˱�");
		  JTree  tree =new JTree(root);
		  DefaultMutableTreeNode   notes1=new DefaultMutableTreeNode("��ͥ�˱�");
		  DefaultMutableTreeNode   notes2 =new DefaultMutableTreeNode("�����˱�");
		  DefaultMutableTreeNode   notes3 =new DefaultMutableTreeNode("�����˱�");
		  root.add(notes1);
		  root.add(notes2);
		  root.add(notes3);
		  pnlNotes.add(tree);
		  //������
		  DefaultMutableTreeNode   allRoot =new DefaultMutableTreeNode("�ҵı���");
		  JTree  treeAll =new JTree(allRoot);
		  DefaultMutableTreeNode   all1=new DefaultMutableTreeNode("�ճ�����");
		  DefaultMutableTreeNode   all2 =new DefaultMutableTreeNode("��ȱ���");
		  allRoot.add(all1);
		  allRoot.add(all2);
		  pnlAllNotes.add(treeAll);
		  //�˻���
		  DefaultMutableTreeNode   accRoot =new DefaultMutableTreeNode("�ҵ��˻�");
		  JTree  treeAcc =new JTree(accRoot);
		  DefaultMutableTreeNode   acc1=new DefaultMutableTreeNode("���п�");
		  DefaultMutableTreeNode   acc2 =new DefaultMutableTreeNode("�ֽ�");
		  DefaultMutableTreeNode   acc3 =new DefaultMutableTreeNode("����");
		  accRoot.add(acc1);
		  accRoot.add(acc2);
		  accRoot.add(acc3);
		  pnlAccount.add(treeAcc);
		  //��ߵķ�ҳ���
		  tabbedPaneWest.setTabPlacement(JTabbedPane.LEFT);
		  tabbedPaneWest.add("�˱�",pnlNotes);
		  tabbedPaneWest.add("����",pnlAllNotes);
		  tabbedPaneWest.add("�˻�",pnlAccount);
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


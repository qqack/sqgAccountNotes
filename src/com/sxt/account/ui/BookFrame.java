package com.sxt.account.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.sxt.account.bean.BookInfo;
import com.sxt.account.dao.BookInfoDao;
//import com.sxt.account.util.BookInfoTableModel;
/**
 * @功能：我的记账簿主页
 * @author 张珊珊
 *@time 8.12
 */
public class BookFrame extends JFrame implements ActionListener{
	
	//private static final String String = null;
	//JButton btnOpen = new JButton("打开");
	JButton btnAdd = new JButton("新建");
	JButton btnDelete = new JButton("删除");
	JButton btnReName = new JButton("重命名");
	JButton btnExit = new JButton("退出");
	JButton btnHelp = new JButton("帮助");
	
	
	private boolean selected = false;
	private BookInfoDao dao;
	private JTable table;
	private JPanel pnlMain;
	private DefaultTableModel dtm;
	public Vector getCloNames() {
		return cloNames;
	}
	public void setCloNames(Vector cloNames) {
		this.cloNames = cloNames;
	}
	private Vector rowdata;
	private Vector cloNames;

	public BookFrame(){
		init();
	}
	public void init(){	
		dao = new BookInfoDao();
		this.setTitle("我的记账簿");
		//设置大小
		this.setSize(500, 370);
		//设置位置(居中)
		this.setLocationRelativeTo(null);
		//设置关闭的行为
		 this.setIconImage(new ImageIcon("imgs/0.jpg").getImage());

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//设置不可变
		this.setResizable(false);
		
		this.setLayout(null);
		//String s="账簿管理中心";
		JLabel lbl=new JLabel("账簿管理中心");
		lbl.setBounds(20, 20, 100, 30);
		this.add(lbl);
		
		JLabel lblPhoto=new JLabel();
		lblPhoto.setIcon(new ImageIcon("imgs/17.png"));
		lblPhoto.setBounds(120, 0, 370, 60);
		this.add(lblPhoto);
		
		pnlMain = new JPanel();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.blue);
		scrollPane.setBounds(20, 60, 320, 250);
		
		setTable(new JTable());
		rowdata = dao.getAll();
		cloNames = new Vector();
		cloNames.add("编号");
		cloNames.add("记账簿名称");
		cloNames.add("记账人");
		
		
		setDtm(new DefaultTableModel(rowdata,cloNames));
	
		
        getTable().setModel(getDtm());
  

		
        //scrollPane.add(table);
        scrollPane.setViewportView(getTable());
        this.add(scrollPane);


//		JTable table =new JTable();
//		scrollPane.setViewportView(table);
//		//给 table添加数据
//		BookInfoDao bookDao =new BookInfoDao();
//		ArrayList<BookInfo> books =bookDao.getBook(new String());
//		for(BookInfo b: books){
//			System.out.println(b);
			
//		}
//		 BookInfoTableModel   btm = new BookInfoTableModel(books);
//		table.setModel(btm);
		
//		btnOpen.setBounds(400, 70, 80, 25);
//		btnOpen.addActionListener(this);
//		this.add(btnOpen);
		
		btnAdd.setBounds(400, 110, 80, 25);
		btnAdd.addActionListener(this);
		this.add(btnAdd);
		
		btnDelete.setBounds(400, 150, 80, 25);
		btnDelete.addActionListener(this);
		this.add(btnDelete);
		
		btnReName.setBounds(400, 190, 80, 25);
		btnReName.addActionListener(this);
		this.add(btnReName);
		
		btnExit.setBounds(400, 230, 80, 25);
		btnExit.addActionListener(this);
		this.add(btnExit);
		
		btnHelp.setBounds(400, 270, 80, 25);
		btnHelp.addActionListener(this);
		this.add(btnHelp);	 

	}
	
	public static void main(String[] args) {
		new BookFrame().setVisible(true);
	}
//	public void paint(Graphics g){
//		Font f=new Font("隶书",Font.PLAIN,180);
//		g.setFont(f);
//		String str=null;
//		g.drawString(str, 100, 200);
//	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//打开
//		if(e.getSource()==btnOpen){
//			new MyNoteFrame().setVisible(true);	
//		}
		//添加
		if(e.getSource()==btnAdd){
			new AddBookFrame(this).setVisible(true);
		
		}
		//删除
		if(e.getSource() == btnDelete){
			
			//获取选中行中第一列的数据
			int cId = 0;
			int rId = getTable().getSelectedRow();
			if(cId == -1 || rId == -1){
				
				JOptionPane.showMessageDialog(null, "你并没有选中要删除的行");
				return;
			}
			int bid = (Integer) getTable().getValueAt(rId, cId);
			boolean result = dao.removeBook(bid);
			
			if(result){
				JOptionPane.showMessageDialog(null, "删除成功！");
				rowdata = dao.getAll();
				
				setDtm(new DefaultTableModel(rowdata,cloNames));
		        getTable().setModel(getDtm());
		  
			}else{
				
				JOptionPane.showMessageDialog(null, "删除失败！");
			}
		
		}
		//重命名
		if(e.getSource() == btnReName){
			
			//获取帐薄名字
			int cbname = 1;
			int rbname = getTable().getSelectedRow();
			
			//获取帐薄id
			int cBId = 0;
			int rbId = getTable().getSelectedRow();
			
			if(cbname == -1 || rbname == -1){
				
				JOptionPane.showMessageDialog(null, "你并没有选中要重命名的行");
				return;
			}
			//获得数据库汇总的名字
			 int bid = (Integer) getTable().getValueAt(rbId, cBId);
			BookInfo bookInfo = dao.find(bid);
			
			//获取当前的名字
			String bName = (String) getTable().getValueAt(rbname, cbname);
			//判断是否相同，相同则提示，否则重命名
			if(bookInfo.getbName().equals(bName)){
			
				JOptionPane.showMessageDialog(null, "你并没有修改帐薄名字");
				return;
			}else{
				boolean result = dao.updateBname(bid, bName);
				
				if(result){
					JOptionPane.showMessageDialog(null, "重命名成功！");
				}else{
					
					JOptionPane.showMessageDialog(null, "重命名失败");
				}
			}
			
		}
		if(e.getSource() == btnExit){
			this.dispose();
			new MainFrame().setVisible(true);
		}
		if(e.getSource() == btnHelp){
			JOptionPane.showMessageDialog(null, "此功能需联网");

		}
		

	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public DefaultTableModel getDtm() {
		return dtm;
	}
	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

}

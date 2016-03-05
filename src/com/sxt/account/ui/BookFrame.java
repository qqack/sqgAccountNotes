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
 * @���ܣ��ҵļ��˲���ҳ
 * @author ��ɺɺ
 *@time 8.12
 */
public class BookFrame extends JFrame implements ActionListener{
	
	//private static final String String = null;
	//JButton btnOpen = new JButton("��");
	JButton btnAdd = new JButton("�½�");
	JButton btnDelete = new JButton("ɾ��");
	JButton btnReName = new JButton("������");
	JButton btnExit = new JButton("�˳�");
	JButton btnHelp = new JButton("����");
	
	
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
		this.setTitle("�ҵļ��˲�");
		//���ô�С
		this.setSize(500, 370);
		//����λ��(����)
		this.setLocationRelativeTo(null);
		//���ùرյ���Ϊ
		 this.setIconImage(new ImageIcon("imgs/0.jpg").getImage());

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//���ò��ɱ�
		this.setResizable(false);
		
		this.setLayout(null);
		//String s="�˲���������";
		JLabel lbl=new JLabel("�˲���������");
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
		cloNames.add("���");
		cloNames.add("���˲�����");
		cloNames.add("������");
		
		
		setDtm(new DefaultTableModel(rowdata,cloNames));
	
		
        getTable().setModel(getDtm());
  

		
        //scrollPane.add(table);
        scrollPane.setViewportView(getTable());
        this.add(scrollPane);


//		JTable table =new JTable();
//		scrollPane.setViewportView(table);
//		//�� table�������
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
//		Font f=new Font("����",Font.PLAIN,180);
//		g.setFont(f);
//		String str=null;
//		g.drawString(str, 100, 200);
//	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//��
//		if(e.getSource()==btnOpen){
//			new MyNoteFrame().setVisible(true);	
//		}
		//���
		if(e.getSource()==btnAdd){
			new AddBookFrame(this).setVisible(true);
		
		}
		//ɾ��
		if(e.getSource() == btnDelete){
			
			//��ȡѡ�����е�һ�е�����
			int cId = 0;
			int rId = getTable().getSelectedRow();
			if(cId == -1 || rId == -1){
				
				JOptionPane.showMessageDialog(null, "�㲢û��ѡ��Ҫɾ������");
				return;
			}
			int bid = (Integer) getTable().getValueAt(rId, cId);
			boolean result = dao.removeBook(bid);
			
			if(result){
				JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
				rowdata = dao.getAll();
				
				setDtm(new DefaultTableModel(rowdata,cloNames));
		        getTable().setModel(getDtm());
		  
			}else{
				
				JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
			}
		
		}
		//������
		if(e.getSource() == btnReName){
			
			//��ȡ�ʱ�����
			int cbname = 1;
			int rbname = getTable().getSelectedRow();
			
			//��ȡ�ʱ�id
			int cBId = 0;
			int rbId = getTable().getSelectedRow();
			
			if(cbname == -1 || rbname == -1){
				
				JOptionPane.showMessageDialog(null, "�㲢û��ѡ��Ҫ����������");
				return;
			}
			//������ݿ���ܵ�����
			 int bid = (Integer) getTable().getValueAt(rbId, cBId);
			BookInfo bookInfo = dao.find(bid);
			
			//��ȡ��ǰ������
			String bName = (String) getTable().getValueAt(rbname, cbname);
			//�ж��Ƿ���ͬ����ͬ����ʾ������������
			if(bookInfo.getbName().equals(bName)){
			
				JOptionPane.showMessageDialog(null, "�㲢û���޸��ʱ�����");
				return;
			}else{
				boolean result = dao.updateBname(bid, bName);
				
				if(result){
					JOptionPane.showMessageDialog(null, "�������ɹ���");
				}else{
					
					JOptionPane.showMessageDialog(null, "������ʧ��");
				}
			}
			
		}
		if(e.getSource() == btnExit){
			this.dispose();
			new MainFrame().setVisible(true);
		}
		if(e.getSource() == btnHelp){
			JOptionPane.showMessageDialog(null, "�˹���������");

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

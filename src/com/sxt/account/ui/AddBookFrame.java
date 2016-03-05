package com.sxt.account.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sxt.account.dao.BookInfoDao;
/**
 * @���ܣ�ʵ��������˲�
 * @author ��ɺɺ
 *@time 8.11
 */
public class AddBookFrame extends JFrame implements ActionListener{
	private JTextField txt1;
	private JTextField txt2;
	private JPasswordField pwd1;
	private JPasswordField pwd2;
	private BookInfoDao dao;
	private BookFrame bookFrame;
	
	JButton btn1=new JButton("ȷ��");
	JButton btn2=new JButton("ȡ��");
	
	public AddBookFrame(BookFrame bookFrame){
		this.bookFrame = bookFrame;
		init();
	}
	public void init(){
		
		dao = new BookInfoDao();
		
		this.setTitle("�½��˲�");
		//���ô�С
		this.setSize(400, 300);
		//����λ��(����)
		this.setLocationRelativeTo(null);
		//���ùرյ���Ϊ
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//���ò��ɱ�
		this.setResizable(false);
		this.setLayout(null);
		
		JLabel lbl=new JLabel("��ӭ���½��˲�");
		lbl.setBounds(20, 20, 150, 40);
		this.add(lbl);
		
		JLabel lbl1=new JLabel("�˲�����:");
		JLabel lbl2=new JLabel("������:");
		JLabel lbl3=new JLabel("�������룺");
		JLabel lbl4=new JLabel("ȷ�����룺");

		
		txt1 = new JTextField(30); 
		txt2 = new JTextField(30); 
		pwd1 = new JPasswordField();
		pwd2 = new JPasswordField();
		
		lbl1.setBounds(50, 100, 80, 20);
		txt1.setBounds(150, 100, 150, 20);
		lbl2.setBounds(50, 130, 80, 20);
		txt2.setBounds(150, 130, 150, 20);
		lbl3.setBounds(50, 160, 80, 20);
		pwd1.setBounds(150, 160, 150, 20);
		lbl4.setBounds(50, 190, 80, 20);
		pwd2.setBounds(150, 190, 150, 20);


		//txt1.setBounds(50, 70, 100, 20);
		
		this.add(lbl1);
		this.add(lbl2);
		this.add(lbl3);
		this.add(lbl4);
		this.add(txt1);
		this.add(txt2);
		this.add(pwd1);
		this.add(pwd2);
		
		
		btn1.setBounds(80, 230, 60, 25);
		btn1.addActionListener(this);
		btn2.setBounds(200, 230, 60, 25);
		btn2.addActionListener(this);

		this.add(btn1);
		this.add(btn2);
		
		JLabel lblPhoto=new JLabel();
		lblPhoto.setIcon(new ImageIcon("imgs/17.png"));
		lblPhoto.setBounds(120, 0, 280, 80);
		this.add(lblPhoto);
	}
	public void actionPerformed(ActionEvent e) {
		 //TODO Auto-generated method stub
		if(e.getSource()==btn1){
			String bname = txt1.getText().trim();
			int userId = Integer.valueOf(txt2.getText().trim());
			String fpwd = new String(pwd1.getPassword());
			String spwd = new String(pwd2.getPassword());
			if( bname.isEmpty()){
				 JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
				 return;
			 }
			 if(fpwd.isEmpty() || fpwd.length() < 6){
				 JOptionPane.showMessageDialog(null, "���벻��Ϊ�ջ�����С��6λ");
				 return;
			 }
			
			//�����������������ͬ��������ݿ����
			if(fpwd.equals(spwd)){
				
				dao.addBookInfo(bname, fpwd, userId);
				JOptionPane.showMessageDialog(null, "���˲������ɹ�");
				AddBookFrame.this.setVisible(false);
				
				//��̬ˢ������
				Vector rowdata; rowdata = dao.getAll();
				
				bookFrame.setDtm(new DefaultTableModel(rowdata,bookFrame.getCloNames()));
		        bookFrame.getTable().setModel(bookFrame.getDtm());
				
			}else{
				//��ʾ����������������Ƿ�һ��
				JOptionPane.showMessageDialog(null, "�����������벻һ�£�");
			}
		}
		if(e.getSource()==btn2){
			this.dispose();
		}
	}
	
}

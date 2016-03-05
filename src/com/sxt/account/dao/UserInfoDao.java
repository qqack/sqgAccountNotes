package com.sxt.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.sxt.account.util.LoginDB;

public class UserInfoDao {
	
	private LoginDB logindb;
	public UserInfoDao() {
		
		logindb = LoginDB.getInstance();
	}
	
	/**
	 * 
	 * ע��ʱ�����ݿ���������û�
	 * @param uname  �û���
	 * @param upwd   �û�����
	 */
	public void addUser(String uname, String upwd){
		
		
		//������ݿ�����
		Connection connection = logindb.getConnection();
		
		String sql = "insert into userInfo values(userid.nextval, ?, ?)";
		try {
			//׼��ִ�е�sql���
			PreparedStatement ps = connection.prepareStatement(sql);
			
			//���ò���
			ps.setString(1, uname);
			ps.setString(2, upwd);
			ps.execute();
			
			ps.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * ��ѯ�û��Ƿ������ݿ��д���
	 * 
	 * @return  ���ڷ���true�� �����ڷ���false;
	 */
	public boolean findUser(String uname, String upwd){
		
		boolean result = false;
		
		Connection connection = logindb.getConnection();
		
		String sql = "select * from userInfo where uname= ? and upwd= ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, uname);
			ps.setString(2, upwd);
			
			ResultSet query = ps.executeQuery();
			
			if(query.next()){
				
				result = true;
			}
			
			query.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}

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
	 * 注册时向数据库中添加新用户
	 * @param uname  用户名
	 * @param upwd   用户密码
	 */
	public void addUser(String uname, String upwd){
		
		
		//获得数据库连接
		Connection connection = logindb.getConnection();
		
		String sql = "insert into userInfo values(userid.nextval, ?, ?)";
		try {
			//准备执行的sql语句
			PreparedStatement ps = connection.prepareStatement(sql);
			
			//设置参数
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
	 * 查询用户是否在数据空中存在
	 * 
	 * @return  存在返回true， 不存在返回false;
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

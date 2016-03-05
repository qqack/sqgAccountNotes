package com.sxt.account.util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBHelp {
	static String DRIVE;
	static String URL;
	static String USER;
	static String PWD;
	static{
		try {
			Properties p = new Properties();
			p.load(new FileReader("conf/dbconfig.properties"));
			DRIVE = p.getProperty("drive");
			URL = p.getProperty("url");
			USER = p.getProperty("user");
			PWD = p.getProperty("pwd");
			Class.forName(DRIVE);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConn() throws SQLException{
		  Connection conn = DriverManager.getConnection(URL,USER,PWD);//oracle 11g,12c的版本注意用户名和密码大写
		
		 //System.out.println("连接成功....");
		 return conn;
	}
	public static void DBClose(Connection conn,Statement  st,ResultSet rs){
		try {
			if(rs!=null){
					rs.close();
			}
			if(st!=null){
				st.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

package com.sxt.account.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class LoginDB {
	
	private final static LoginDB instance = new LoginDB();
	
	private LoginDB(){	
	}
	
	public static LoginDB getInstance(){
		
		return instance;
	}
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String user = "scott";
	private String password = "tiger";

	
	public Connection getConnection(){
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}

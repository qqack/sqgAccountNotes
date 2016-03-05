package com.sxt.account.util;
import java.sql.*;

public class DBOperator {
	/**
	 * ��װ��ѯ�ķ���
	 * ע��:�Ͳ�ѯ��صĶ����ڷ����в������ر�
	 *  �ر�  rs->statment->conn
	 *    rs.getStatement().close();
    rs.getStatement().getConnection().close();
	 * @param sql
	 * @return
	 */
	public static  ResultSet  executeQuery(String sql){
		
		Connection conn=null;
		Statement  st=null;
		ResultSet  rs=null;
		
		try {
			conn=DBHelp.getConn();
			st=conn.createStatement();
			rs=  st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * ��װinsert,update,delete �ķ���
	 * @param sql
	 * @return
	 */
   public static  int  executeUpdate(String sql){
		
		Connection conn=null;
		Statement  st=null;
	    int count=0;
		
		try {
			conn=DBHelp.getConn();
			st=conn.createStatement();
			count = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelp.DBClose(conn, st, null);
		}
		return count;
	}
   
  
	
}

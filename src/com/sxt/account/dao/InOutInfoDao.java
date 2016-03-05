package com.sxt.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.sxt.account.bean.AccountInfo;
import com.sxt.account.bean.InOutInfo;
import com.sxt.account.util.DBHelp;
import com.sxt.account.util.DBOperator;

public class InOutInfoDao {
	//ArrayList<AccountInfo> acc = new ArrayList<AccountInfo>();
	Vector allData = new Vector();
	
	public void add(String TypeName,String form,String uname){
		String sql = "insert into InOutInfo values(IOID.Nextval,'"+TypeName+"','"+form+"','"+uname+"','','','','')";
//		System.out.println(sql);
		ResultSet rs= DBOperator.executeQuery(sql);
		
		try {
			DBHelp.DBClose(rs.getStatement().getConnection(), rs.getStatement(), rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			getAll();
	}

	public void modify(String TypeName,String form,int IOID){
		String sql = "update InOutInfo set TypeName='"+TypeName+"',form='"+form+"' where IOID="+IOID;
		System.out.println("modify"+sql);
		ResultSet rs= DBOperator.executeQuery(sql);
		
		try {
			DBHelp.DBClose(rs.getStatement().getConnection(), rs.getStatement(), rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getAll();
	}
	
	public void delete(int number){
		String sql = "delete from InOutInfo where IOID = "+ number;
		System.out.println("modify"+sql);
		Connection conn=null;
		Statement  st=null;
		try {
			conn=DBHelp.getConn();
			st=conn.createStatement();
			int count = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelp.DBClose(conn, st, null);
		}
		
		
	
	}
	
	public Vector getAll(){
		String sql = "select * from InOutInfo";
//		System.out.println(sql);
		ResultSet rs= DBOperator.executeQuery(sql);
        try {
        	
		while(rs.next()){
			int IOID = rs.getInt(1);
			String TypeName = rs.getString(2);
			String form = rs.getString(3);
			String uname = rs.getString(4);
			String describe = rs.getString(5);
			//--------------------
			String Remark1 = rs.getString(6);
			String Remark2 = rs.getString(7);
			String Remark3 = rs.getString(8);
  
			Vector rowdata = new Vector();
			
			rowdata.add(IOID);
			rowdata.add(TypeName);
			rowdata.add(form);
			rowdata.add(uname);
			rowdata.add(describe);
			rowdata.add(Remark1);
			rowdata.add(Remark2);
			rowdata.add(Remark3);
			
			allData.add(rowdata);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelp.DBClose(rs.getStatement().getConnection(), rs.getStatement(), rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        
		return allData;
		
	}
public ArrayList<InOutInfo> takeAll(){
		
		String sql = "select * from InOutInfo";
		ResultSet rs= DBOperator.executeQuery(sql);
		ArrayList<InOutInfo> iois = new ArrayList<InOutInfo>();
        try {	
		while(rs.next()){
			int IOID = rs.getInt(1);
			String TypeName = rs.getString(2);
			String form = rs.getString(3);
			String uname = rs.getString(4);
			String describe = rs.getString(5);
			String Remark1 = rs.getString(6);
			String Remark2 = rs.getString(7);
			String Remark3 = rs.getString(8);
  

			InOutInfo  ioi=new InOutInfo(IOID,TypeName,form,uname,describe,Remark1,Remark2,Remark3);
			
			iois.add(ioi);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelp.DBClose(rs.getStatement().getConnection(), rs.getStatement(), rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        
		return iois;
		
	}
	public String seleleMoney(String sql){
		String money = null;
		ResultSet rs= DBOperator.executeQuery(sql);
		try {
			while(rs.next()){
				 money = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				DBHelp.DBClose(rs.getStatement().getConnection(), rs.getStatement(), rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return money;
	}
	
}

package com.sxt.account.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import com.sxt.account.bean.NoteInfo;
import com.sxt.account.util.DBHelp;
import com.sxt.account.util.DBOperator;

public class NoteInfoDao {
	
	
	Vector allDate = new Vector();
	public Vector getAll(){
		   String sql="select rownum ,n.* from NoteInfo n order by nid";
		   ResultSet  rs= DBOperator.executeQuery(sql);
		   try {
			while(rs.next()){
				int rownum = rs.getInt(1);
				int nid = rs.getInt(2);
				int uid = rs.getInt(3);
				String form = rs.getString(4);
				String AcType = rs.getString(5);
				String typeName = rs.getString(6);
				Date nDate = rs.getDate(7);
				double money = rs.getDouble(8);
				String notes = rs.getString(9);
				
				Vector rowdata = new Vector();
				rowdata.add(rownum);
				rowdata.add(nid);
				rowdata.add(nDate);
				rowdata.add(typeName);
				rowdata.add(AcType);
				rowdata.add(form);
				rowdata.add(money);
				rowdata.add(uid);
				rowdata.add(notes);
				
				allDate.add(rowdata);
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelp.DBClose(rs.getStatement().getConnection(),rs.getStatement(), rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		   return allDate;
	}
	//添加
	public void add(String form,String AcType,Object TypeName,double money,String notes){
		
			String sql="insert into NoteInfo values(nid.nextval,1,'"+form+"','"+AcType+"','"+TypeName+"',default,"+money+",'"+notes+"','','','')";
			
			ResultSet  rs=DBOperator.executeQuery(sql);
			try {
				DBHelp.DBClose(rs.getStatement().getConnection(),rs.getStatement(), rs);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			getAll();
	}
	
	//删除
	public void delete(String nid){
		
		String sql = "delete from NoteInfo where nid="+nid;
		System.out.println(sql);
		ResultSet  rs=DBOperator.executeQuery(sql);
		try {
			DBHelp.DBClose(rs.getStatement().getConnection(),rs.getStatement(), rs);
//			System.out.println("删除成功");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	//修改
		public void update(String form,String AcType,Object typeName,double money,String notes,int nid){
		String sql = "update NoteInfo set form='"+form+"',Actype = '"+AcType+"',typeName='"+typeName+"',money="+money+",notes='"+notes+"' where nid ="+nid;
//		System.out.println(sql);
		ResultSet  rs=DBOperator.executeQuery(sql);
		try {
			DBHelp.DBClose(rs.getStatement().getConnection(),rs.getStatement(), rs);
//			System.out.println("修改成功");
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
	//查询
	public Vector select(String sql){
		ResultSet  rs=DBOperator.executeQuery(sql);
		 try {
				while(rs.next()){
					int rownum = rs.getInt(1);
					int nid = rs.getInt(2);
					int uid = rs.getInt(3);
					String form = rs.getString(4);
					String AcType = rs.getString(5);
					String typeName = rs.getString(6);
					Date nDate = rs.getDate(7);
					double money = rs.getDouble(8);
					String notes = rs.getString(9);
					
					Vector rowdata = new Vector();
					rowdata.add(rownum);
					rowdata.add(nid);
					rowdata.add(nDate);
					rowdata.add(typeName);
					rowdata.add(AcType);
					rowdata.add(form);
					rowdata.add(money);
					rowdata.add(uid);
					rowdata.add(notes);
					
					allDate.add(rowdata);
				   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					DBHelp.DBClose(rs.getStatement().getConnection(),rs.getStatement(), rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			   return allDate;
	}

}

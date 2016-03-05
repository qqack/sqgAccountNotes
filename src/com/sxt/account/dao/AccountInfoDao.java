package com.sxt.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import com.sxt.account.bean.AccountInfo;
import com.sxt.account.util.DBHelp;
import com.sxt.account.util.DBOperator;


/**
 * 创建账户管理模块--联系数据库
 * @author 勾润雪
 * 2015-8-8
 */
public class AccountInfoDao{
	
	ArrayList<AccountInfo> acc = new ArrayList<AccountInfo>();
	Vector allData = new Vector();
	
	public Vector getAll(int id){
		String sql = "select * from AccountInfo where AID="+id;
		System.out.println(sql);
		ResultSet rs= DBOperator.executeQuery(sql);
        try {
        	
		while(rs.next()){
			int AID = rs.getInt(1);
			String AcType = rs.getString(2);
			int Balance = rs.getInt(3);
			//--------------------
			String Remark1 = rs.getString(4);
			String Remark2 = rs.getString(5);
			String Remark3 = rs.getString(6);
  
			Vector rowdata = new Vector();
			
			rowdata.add(AID);
			rowdata.add(AcType);
			rowdata.add(Balance);
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
}

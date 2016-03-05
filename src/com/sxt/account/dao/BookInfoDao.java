package com.sxt.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.sxt.account.bean.BookInfo;
import com.sxt.account.util.LoginDB;
import com.sxt.account.util.DBHelp;
import com.sxt.account.util.DBOperator;

public class BookInfoDao {
	
	private LoginDB logindb;
	
	public BookInfoDao(){
		
		logindb = LoginDB.getInstance();
	}
	public Vector getAll(){
		
		Vector allData= new Vector();
		   String sql="select bId,bName,uName from bookInfo,userInfo where bookInfo.userid = userInfo.userid";
		   ResultSet  rs= DBOperator.executeQuery(sql);
		   try {
			while(rs.next()){
				int bId = rs.getInt(1);
				String bName = rs.getString(2);
				String uName = rs.getString(3);
				
				Vector rowdata = new Vector();
				rowdata.add(bId);
				rowdata.add(bName);
				rowdata.add(uName);
				System.out.println(uName);
				allData.add(rowdata);
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
		   return allData;
	}
	
	/**
	 * 
	 * 获取所有帐薄的信息
	 * @return 
	 */
	public List<BookInfo> findAll(){
		
		Connection conn = logindb.getConnection();
		String sql = "select bid, bname, bpwd, userInfo.uname from userInfo, bookInfo where userInfo.userid = bookInfo.userid";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet query = ps.executeQuery();
			List<BookInfo> list = new ArrayList<BookInfo>();
			while(query.next()){
				
				BookInfo bookInfo = new BookInfo();
				bookInfo.setbId(query.getInt(1));
				bookInfo.setbName(query.getString(2));
				bookInfo.setbPwd(query.getString(3));
				bookInfo.setuName(query.getString(4));
				list.add(bookInfo);
			}
			
			query.close();
			ps.close();
			conn.close();
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * 查询某一个帐薄
	 * @param bId
	 * @return
	 */
	public BookInfo find(int bId){
		
		Connection conn = logindb.getConnection();
		String sql = "select bid, bname, bpwd, userInfo.uname from bookInfo, userInfo where bookInfo.Userid = userInfo.Userid and bookInfo.bid = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bId);
			ResultSet query = ps.executeQuery();
			BookInfo bookInfo = null;
			if(query.next()){
				
				bookInfo = new BookInfo();
				bookInfo.setbId(query.getInt(1));
				bookInfo.setbName(query.getString(2));
				bookInfo.setbPwd(query.getString(3));
				bookInfo.setuName(query.getString(4));
				
			}
			
			query.close();
			ps.close();
			conn.close();
			return bookInfo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * 修改帐薄名字
	 * @param bId
	 * @return
	 */
	public boolean updateBname(int bId, String bname){
		
		boolean result = false;
		Connection conn = logindb.getConnection();
		String sql = "update bookInfo set bname = ? where bid = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bname);
			ps.setInt(2, bId);
			ps.execute();
			result = true;
			ps.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 
	 * 删除一个账簿
	 * @param bId
	 * @return
	 */
	public boolean removeBook(int bId){
		
		boolean result = false;
		Connection conn = logindb.getConnection();
		String sql = "delete from bookInfo where bid = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bId);
			ps.execute();
			result = true;
			ps.close();
			conn.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 
	 * 添加新的帐薄
	 * @param bname
	 * @param bpwd
	 * @param userId
	 */
	public void addBookInfo(String bname, String bpwd, int userId){
		
		Connection conn = logindb.getConnection();
		
		String sql = "insert into bookInfo values(bid.nextval,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bname);
			ps.setString(2, bpwd);
			ps.setInt(3, userId);
			
			ps.execute();
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public ArrayList<BookInfo>  getBook(String bName){
//			String sql="select * from BookInfo where bName=?";
//	        Connection conn=null;
//	        PreparedStatement  pst=null;
//	        ResultSet rs=null;
//	        ArrayList<BookInfo>  books =new ArrayList<BookInfo>();
//	        int bId=(Integer) null;
//	        try {
//				conn = DBHelp.getConn();
//				pst = conn.prepareStatement(sql);
//				pst.setInt(0, bId);
//				rs = pst.executeQuery();
//				while(rs.next()){
//					BookInfo  book=new BookInfo();
//					book.setbId(rs.getInt(1));
//					book.setbPwd(rs.getString(2));  
//					book.setbName(rs.getString(3));				
//				}			
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally{
//				DBHelp.DBClose(conn, pst, rs);
//			}       
//	        return books;
//	}	
	

}

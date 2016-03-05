package com.sxt.account.util;

import java.util.ArrayList;

import com.sxt.account.bean.AccountInfo;

/**
 * 创建账户管理模块--加table表
 * @author 勾润雪
 * 2015-8-8
 *@version 1.0
 */

public class AccTableModel {
	ArrayList<AccountInfo>  accs=null;
	String []colNames ={"账户类型","余额"};
	public  AccTableModel(ArrayList<AccountInfo>  accs){
		this.accs = accs;
	}
	
	public int getRowCount() {
		
		return accs.size();
	}

	public int getColumnCount() {
		
		return colNames.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		AccountInfo  account = accs.get(rowIndex);
		Object value=null;
		switch(columnIndex){
		case 0:
			value= account.getAcType();
			break;
		case 1:
			value= account.getBalance();
			break;
		}
		return value;
	}

	public String getColumnName(int column) {
		
		return  colNames[column];
	}
}

package com.sxt.account.util;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.sxt.account.bean.InOutInfo;

public class InOutTableModel extends AbstractTableModel{
	ArrayList<InOutInfo> IOIs = null;
	String []colNames = {"��֧���","��Ŀ����","���","�û���","˵��"};
	public InOutTableModel(ArrayList<InOutInfo> IOIs){
		this.IOIs = IOIs;
	}
	
	@Override
	public int getRowCount() {
		return IOIs.size();
	}

	@Override
	public int getColumnCount() {
		return colNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		InOutInfo IOI = IOIs.get(rowIndex);
		Object value = null;
		switch(columnIndex){
		case 0:
			value = IOI.getIOID();
			break;
		case 1:
			value = IOI.getTypeName();
			break;
		case 2:
			value = IOI.getForm();
			break;
		case 3:
			value = IOI.getUname();
			break;
		case 4:
			value = IOI.getDescribe();
			break;
		}
		return value;
	}
	public String getColumnName(int column) {
		
		return  colNames[column];
	}
}

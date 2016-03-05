package com.sxt.account.bean;

import java.io.Serializable;

/**
 * 创建账户管理模块--get()、set()等方法
 * @author 勾润雪   
 * @time 2015-8-8
 */

public class AccountInfo implements Serializable{
	private int AID;//账户ID
	private String AcType;//账户类型
	private int balance;//账户余额
	private String remark1;
	private String remark2;
	private String remark3;
	public int getAID() {
		return AID;
	}
	public void setAID(int aID) {
		AID = aID;
	}
	public String getAcType() {
		return AcType;
	}
	public void setAcType(String acType) {
		AcType = acType;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	public String getRemark3() {
		return remark3;
	}
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + AID;
		result = prime * result + ((AcType == null) ? 0 : AcType.hashCode());
		result = prime * result + balance;
		result = prime * result + ((remark1 == null) ? 0 : remark1.hashCode());
		result = prime * result + ((remark2 == null) ? 0 : remark2.hashCode());
		result = prime * result + ((remark3 == null) ? 0 : remark3.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountInfo other = (AccountInfo) obj;
		if (AID != other.AID)
			return false;
		if (AcType == null) {
			if (other.AcType != null)
				return false;
		} else if (!AcType.equals(other.AcType))
			return false;
		if (balance != other.balance)
			return false;
		if (remark1 == null) {
			if (other.remark1 != null)
				return false;
		} else if (!remark1.equals(other.remark1))
			return false;
		if (remark2 == null) {
			if (other.remark2 != null)
				return false;
		} else if (!remark2.equals(other.remark2))
			return false;
		if (remark3 == null) {
			if (other.remark3 != null)
				return false;
		} else if (!remark3.equals(other.remark3))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AccountInfo [AID=" + AID + ", AcType=" + AcType + ", balance="
				+ balance + ", remark1=" + remark1 + ", remark2=" + remark2
				+ ", remark3=" + remark3 + "]";
	}
	
	

}

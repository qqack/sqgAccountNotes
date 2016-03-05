package com.sxt.account.bean;

import java.util.Date;

/**
 * 功能：记录表的信息获取
 * @author 仇艳
 * 日期：20150808
 *
 */

public class NoteInfo {
	private int NID;
	private int userid;
	private String form;
	private String Actype;
	private String TypeName;
	private Date NDate;
	private double money;
	private String notes;
	
	public NoteInfo(int nID, int userid, String form, String actype,
			String typeName, Date nDate, double money, String notes) {
		super();
		NID = nID;
		this.userid = userid;
		this.form = form;
		Actype = actype;
		TypeName = typeName;
		NDate = nDate;
		this.money = money;
		this.notes = notes;
	}

	

	public String toString() {
		return "NoteInfo [NID=" + NID + ", userid=" + userid + ", form=" + form
				+ ", Actype=" + Actype + ", TypeName=" + TypeName + ", NDate="
				+ NDate + ", money=" + money + ", notes=" + notes + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Actype == null) ? 0 : Actype.hashCode());
		result = prime * result + ((NDate == null) ? 0 : NDate.hashCode());
		result = prime * result + NID;
		result = prime * result
				+ ((TypeName == null) ? 0 : TypeName.hashCode());
		result = prime * result + ((form == null) ? 0 : form.hashCode());
		long temp;
		temp = Double.doubleToLongBits(money);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + userid;
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
		NoteInfo other = (NoteInfo) obj;
		if (Actype == null) {
			if (other.Actype != null)
				return false;
		} else if (!Actype.equals(other.Actype))
			return false;
		if (NDate == null) {
			if (other.NDate != null)
				return false;
		} else if (!NDate.equals(other.NDate))
			return false;
		if (NID != other.NID)
			return false;
		if (TypeName == null) {
			if (other.TypeName != null)
				return false;
		} else if (!TypeName.equals(other.TypeName))
			return false;
		if (form == null) {
			if (other.form != null)
				return false;
		} else if (!form.equals(other.form))
			return false;
		if (Double.doubleToLongBits(money) != Double
				.doubleToLongBits(other.money))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	public int getNID() {
		return NID;
	}
	public void setNID(int nID) {
		NID = nID;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getActype() {
		return Actype;
	}
	public void setActype(String actype) {
		Actype = actype;
	}
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	public Date getNDate() {
		return NDate;
	}
	public void setNDate(Date nDate) {
		NDate = nDate;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}

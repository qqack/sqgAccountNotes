package com.sxt.account.bean;

import java.io.Serializable;

public class InOutInfo implements Serializable{
	private int IOID;
	private String TypeName;
	private String form;
	private String uname;
	private String describe;
	private String remark1;
	private String remark2;
	private String remark3;
	public InOutInfo(int iOID, String typeName, String form, String uname,
			String describe, String remark1, String remark2, String remark3) {
		super();
		IOID = iOID;
		TypeName = typeName;
		this.form = form;
		this.uname = uname;
		this.describe = describe;
		this.remark1 = remark1;
		this.remark2 = remark2;
		this.remark3 = remark3;
	}
	public int getIOID() {
		return IOID;
	}
	public void setIOID(int iOID) {
		IOID = iOID;
	}
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
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
		result = prime * result + IOID;
		result = prime * result
				+ ((TypeName == null) ? 0 : TypeName.hashCode());
		result = prime * result
				+ ((describe == null) ? 0 : describe.hashCode());
		result = prime * result + ((form == null) ? 0 : form.hashCode());
		result = prime * result + ((remark1 == null) ? 0 : remark1.hashCode());
		result = prime * result + ((remark2 == null) ? 0 : remark2.hashCode());
		result = prime * result + ((remark3 == null) ? 0 : remark3.hashCode());
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
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
		InOutInfo other = (InOutInfo) obj;
		if (IOID != other.IOID)
			return false;
		if (TypeName == null) {
			if (other.TypeName != null)
				return false;
		} else if (!TypeName.equals(other.TypeName))
			return false;
		if (describe == null) {
			if (other.describe != null)
				return false;
		} else if (!describe.equals(other.describe))
			return false;
		if (form == null) {
			if (other.form != null)
				return false;
		} else if (!form.equals(other.form))
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
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return TypeName;
	}
	
}

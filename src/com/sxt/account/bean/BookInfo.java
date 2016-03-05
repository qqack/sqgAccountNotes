package com.sxt.account.bean;

public class BookInfo {
	private int bId;
	private String bName;
	private String bPwd;
	private String uName;
	public BookInfo(){
		
	}
	public BookInfo(int bId,String name,String upwd){
	super();
	this.bId=bId;
	this.bName=bName;
	this.bPwd=bPwd;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbPwd() {
		return bPwd;
	}
	public void setbPwd(String bPwd) {
		this.bPwd = bPwd;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bId;
		result = prime * result + ((bName == null) ? 0 : bName.hashCode());
		result = prime * result + ((bPwd == null) ? 0 : bPwd.hashCode());
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
		BookInfo other = (BookInfo) obj;
		if (bId != other.bId)
			return false;
		if (bName == null) {
			if (other.bName != null)
				return false;
		} else if (!bName.equals(other.bName))
			return false;
		if (bPwd == null) {
			if (other.bPwd != null)
				return false;
		} else if (!bPwd.equals(other.bPwd))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BookInfo [bId=" + bId + ", bName=" + bName + ", bPwd=" + bPwd
				+ "]";
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	
}

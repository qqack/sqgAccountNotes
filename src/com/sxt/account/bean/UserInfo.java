package com.sxt.account.bean;

public class UserInfo {
	private int userId;
	private String uname;
	private String upwd;
	public UserInfo(){
		
	}
	public UserInfo(int userId,String name,String upwd){
	super();
	this.userId=userId;
	this.uname=uname;
	this.upwd=upwd;
	}
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
		result = prime * result + ((upwd == null) ? 0 : upwd.hashCode());
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
		UserInfo other = (UserInfo) obj;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		if (upwd == null) {
			if (other.upwd != null)
				return false;
		} else if (!upwd.equals(other.upwd))
			return false;
		return true;
	}
	public String toString() {
		return "UserInfo [userId=" + userId + ", uname=" + uname + ", upwd="
				+ upwd + "]";
	}
		
}

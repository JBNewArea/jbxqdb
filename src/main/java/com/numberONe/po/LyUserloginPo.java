package com.numberONe.po;

import java.io.Serializable;
import java.util.Date;

public class LyUserloginPo implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private int userId;
	private String accountName;
	private Date loginTime;
	private String loginIP;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginIP() {
		return loginIP;
	}
	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}

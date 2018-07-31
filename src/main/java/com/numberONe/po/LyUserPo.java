package com.numberONe.po;

import java.io.Serializable;
import java.util.Date;

public class LyUserPo implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String userName;
	private String accountName;
	private String password;
	private String description;
	private String locked;
	private String credentialsSalt;
	private Date createTime;
	private int deletestatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocked() {
		return locked;
	}
	public void setLocked(String locked) {
		this.locked = locked;
	}
	public String getCredentialsSalt() {
		return credentialsSalt;
	}
	public void setCredentialsSalt(String credentialsSalt) {
		this.credentialsSalt = credentialsSalt;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getDeletestatus() {
		return deletestatus;
	}
	public void setDeletestatus(int deletestatus) {
		this.deletestatus = deletestatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

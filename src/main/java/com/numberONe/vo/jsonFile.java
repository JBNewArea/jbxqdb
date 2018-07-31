package com.numberONe.vo;

import java.io.Serializable;

public class jsonFile implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String remarks;
	private String fileName;
	private String userMaterialid;
	private String userMaterialName;
	private String fileAddress;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUserMaterialid() {
		return userMaterialid;
	}
	public void setUserMaterialid(String userMaterialid) {
		this.userMaterialid = userMaterialid;
	}
	public String getFileAddress() {
		return fileAddress;
	}
	public void setFileAddress(String fileAddress) {
		this.fileAddress = fileAddress;
	}
	public String getUserMaterialName() {
		return userMaterialName;
	}
	public void setUserMaterialName(String userMaterialName) {
		this.userMaterialName = userMaterialName;
	}
	

}

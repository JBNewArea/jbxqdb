package com.numberONe.vo;

import java.io.Serializable;

public class applyPerson implements Serializable{
	private static final long serialVersionUID = 1L;
	private String applicationName;
	private String applicationDocumentNumber;
	private String applicationPhone;
	private String applicationPostCode;
	private String applicationAddress;
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getApplicationDocumentNumber() {
		return applicationDocumentNumber;
	}
	public void setApplicationDocumentNumber(String applicationDocumentNumber) {
		this.applicationDocumentNumber = applicationDocumentNumber;
	}
	public String getApplicationPhone() {
		return applicationPhone;
	}
	public void setApplicationPhone(String applicationPhone) {
		this.applicationPhone = applicationPhone;
	}
	public String getApplicationPostCode() {
		return applicationPostCode;
	}
	public void setApplicationPostCode(String applicationPostCode) {
		this.applicationPostCode = applicationPostCode;
	}
	public String getApplicationAddress() {
		return applicationAddress;
	}
	public void setApplicationAddress(String applicationAddress) {
		this.applicationAddress = applicationAddress;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "applyPerson [applicationName=" + applicationName
				+ ", applicationDocumentNumber=" + applicationDocumentNumber
				+ ", applicationPhone=" + applicationPhone
				+ ", applicationPostCode=" + applicationPostCode
				+ ", applicationAddress=" + applicationAddress + "]";
	}
	
}

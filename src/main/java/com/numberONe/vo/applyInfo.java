package com.numberONe.vo;

import java.io.Serializable;

public class applyInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String matterId;//事项id
	private String matterThmeId;//主题事项ID
	private String applicationName;
	private String applicantDocumentType;
	private String applicationDocumentNumber;
	private String applicationPhone;
	private String applicationPostCode;
	private String applicationAddress;
	private String applySource;
	private String agentName;
	private String agentDocumentType;
	private String agentDocumentNumber;
	private String legalRepresentative;
	private String officeNumber;
	private String status;
	private boolean hasten;
	private String transName;
	private String applyTime;
	private String finishTime;
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getApplicantDocumentType() {
		return applicantDocumentType;
	}
	public void setApplicantDocumentType(String applicantDocumentType) {
		this.applicantDocumentType = applicantDocumentType;
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
	public String getApplySource() {
		return applySource;
	}
	public void setApplySource(String applySource) {
		this.applySource = applySource;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getMatterId() {
		return matterId;
	}
	public void setMatterId(String matterId) {
		this.matterId = matterId;
	}
	
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentDocumentType() {
		return agentDocumentType;
	}
	public void setAgentDocumentType(String agentDocumentType) {
		this.agentDocumentType = agentDocumentType;
	}
	public String getAgentDocumentNumber() {
		return agentDocumentNumber;
	}
	public void setAgentDocumentNumber(String agentDocumentNumber) {
		this.agentDocumentNumber = agentDocumentNumber;
	}
	
	public String getLegalRepresentative() {
		return legalRepresentative;
	}
	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	
	public String getMatterThmeId() {
		return matterThmeId;
	}
	public void setMatterThmeId(String matterThmeId) {
		this.matterThmeId = matterThmeId;
	}
	
	public String getOfficeNumber() {
		return officeNumber;
	}
	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean isHasten() {
		return hasten;
	}
	public void setHasten(boolean hasten) {
		this.hasten = hasten;
	}
	
	public String getTransName() {
		return transName;
	}
	public void setTransName(String transName) {
		this.transName = transName;
	}
	
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	@Override
	public String toString() {
		return "applyInfo [matterId=" + matterId + ", matterThmeId="
				+ matterThmeId + ", applicationName=" + applicationName
				+ ", applicantDocumentType=" + applicantDocumentType
				+ ", applicationDocumentNumber=" + applicationDocumentNumber
				+ ", applicationPhone=" + applicationPhone
				+ ", applicationPostCode=" + applicationPostCode
				+ ", applicationAddress=" + applicationAddress
				+ ", applySource=" + applySource + ", agentName=" + agentName
				+ ", agentDocumentType=" + agentDocumentType
				+ ", agentDocumentNumber=" + agentDocumentNumber
				+ ", legalRepresentative=" + legalRepresentative
				+ ", officeNumber=" + officeNumber + ", status=" + status
				+ ", hasten=" + hasten + ", transName=" + transName
				+ ", applyTime=" + applyTime + ", finishTime=" + finishTime
				+ "]";
	}
	
	
}

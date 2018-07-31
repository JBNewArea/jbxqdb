package com.numberONe.po;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ThemeApplyPo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String themeApplyId;
	private String matterThemeId;
	private String matterThemeName;
	private String applicationName;
	private String applicantDocumentType;
	private String applicationDocumentNumber;
	private String applicationPhone;
	private String applicationPostCode;
	private String applicationAddress;
	private String legalRepresentative;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date statusDate;
	private String agentId;
	private String status;
	
	private String mainLandContent;
	private String isImport;
	private String moneyResource;
	private String invest;
	private String themeAddress;
	private String name;
	
	private String xzq;
	private String dbzxName;
	private String qyTime;
	private String xieyihao ;
	private String bumen;
	private String personOne;
	private String personTwo;
	private String daibanStyle;
	private String weituoStart;
	private String weituoEnd;
//	private String danweiName;
	private String danweiPlace;
	private String danweiStyle;
	private String projectPerson;
	private String personPosition;
	private String personPhone;
	private String youxiang;
	
	
	public String getThemeApplyId() {
		return themeApplyId;
	}
	public void setThemeApplyId(String themeApplyId) {
		this.themeApplyId = themeApplyId;
	}
	public String getMatterThemeId() {
		return matterThemeId;
	}
	public void setMatterThemeId(String matterThemeId) {
		this.matterThemeId = matterThemeId;
	}
	public String getMatterThemeName() {
		return matterThemeName;
	}
	public void setMatterThemeName(String matterThemeName) {
		this.matterThemeName = matterThemeName;
	}
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
	public String getLegalRepresentative() {
		return legalRepresentative;
	}
	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getMainLandContent() {
		return mainLandContent;
	}
	public void setMainLandContent(String mainLandContent) {
		this.mainLandContent = mainLandContent;
	}
	public String getIsImport() {
		return isImport;
	}
	public void setIsImport(String isImport) {
		this.isImport = isImport;
	}
	public String getMoneyResource() {
		return moneyResource;
	}
	public void setMoneyResource(String moneyResource) {
		this.moneyResource = moneyResource;
	}
	public String getInvest() {
		return invest;
	}
	public void setInvest(String invest) {
		this.invest = invest;
	}
	public String getThemeAddress() {
		return themeAddress;
	}
	public void setThemeAddress(String themeAddress) {
		this.themeAddress = themeAddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXzq() {
		return xzq;
	}
	public void setXzq(String xzq) {
		this.xzq = xzq;
	}
	public String getDbzxName() {
		return dbzxName;
	}
	public void setDbzxName(String dbzxName) {
		this.dbzxName = dbzxName;
	}
	public String getQyTime() {
		return qyTime;
	}
	public void setQyTime(String qyTime) {
		this.qyTime = qyTime;
	}
	public String getXieyihao() {
		return xieyihao;
	}
	public void setXieyihao(String xieyihao) {
		this.xieyihao = xieyihao;
	}
	public String getBumen() {
		return bumen;
	}
	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
	public String getPersonOne() {
		return personOne;
	}
	public void setPersonOne(String personOne) {
		this.personOne = personOne;
	}
	public String getPersonTwo() {
		return personTwo;
	}
	public void setPersonTwo(String personTwo) {
		this.personTwo = personTwo;
	}
	public String getDaibanStyle() {
		return daibanStyle;
	}
	public void setDaibanStyle(String daibanStyle) {
		this.daibanStyle = daibanStyle;
	}
	public String getWeituoStart() {
		return weituoStart;
	}
	public void setWeituoStart(String weituoStart) {
		this.weituoStart = weituoStart;
	}
	public String getWeituoEnd() {
		return weituoEnd;
	}
	public void setWeituoEnd(String weituoEnd) {
		this.weituoEnd = weituoEnd;
	}
//	public String getDanweiName() {
//		return danweiName;
//	}
//	public void setDanweiName(String danweiName) {
//		this.danweiName = danweiName;
//	}
	public String getDanweiPlace() {
		return danweiPlace;
	}
	public void setDanweiPlace(String danweiPlace) {
		this.danweiPlace = danweiPlace;
	}
	public String getDanweiStyle() {
		return danweiStyle;
	}
	public void setDanweiStyle(String danweiStyle) {
		this.danweiStyle = danweiStyle;
	}
	public String getProjectPerson() {
		return projectPerson;
	}
	public void setProjectPerson(String projectPerson) {
		this.projectPerson = projectPerson;
	}
	public String getPersonPosition() {
		return personPosition;
	}
	public void setPersonPosition(String personPosition) {
		this.personPosition = personPosition;
	}
	public String getPersonPhone() {
		return personPhone;
	}
	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}
	public String getYouxiang() {
		return youxiang;
	}
	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}
	
}

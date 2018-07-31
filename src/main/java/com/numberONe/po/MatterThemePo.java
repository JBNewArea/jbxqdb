package com.numberONe.po;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MatterThemePo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String matterThemeId;
	private String matterThemeCode;
	private String matterThemeName;
	private String matterThemeType;
	private String matterId;
	private String themeAddress;
	private String invest;
	private String moneyResource;
	private String isImport;
	private String landCharac;
	private String mainLandContent;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date statusDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	private String status;
	
	public String getMatterThemeId() {
		return matterThemeId;
	}
	public void setMatterThemeId(String matterThemeId) {
		this.matterThemeId = matterThemeId;
	}
	public String getMatterThemeCode() {
		return matterThemeCode;
	}
	public void setMatterThemeCode(String matterThemeCode) {
		this.matterThemeCode = matterThemeCode;
	}
	public String getMatterThemeName() {
		return matterThemeName;
	}
	public void setMatterThemeName(String matterThemeName) {
		this.matterThemeName = matterThemeName;
	}
	public String getMatterId() {
		return matterId;
	}
	public void setMatterId(String matterId) {
		this.matterId = matterId;
	}
	public Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getThemeAddress() {
		return themeAddress;
	}
	public void setThemeAddress(String themeAddress) {
		this.themeAddress = themeAddress;
	}
	public String getInvest() {
		return invest;
	}
	public void setInvest(String invest) {
		this.invest = invest;
	}
	public String getMoneyResource() {
		return moneyResource;
	}
	public void setMoneyResource(String moneyResource) {
		this.moneyResource = moneyResource;
	}
	public String getIsImport() {
		return isImport;
	}
	public void setIsImport(String isImport) {
		this.isImport = isImport;
	}
	public String getLandCharac() {
		return landCharac;
	}
	public void setLandCharac(String landCharac) {
		this.landCharac = landCharac;
	}
	public String getMainLandContent() {
		return mainLandContent;
	}
	public void setMainLandContent(String mainLandContent) {
		this.mainLandContent = mainLandContent;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getMatterThemeType() {
		return matterThemeType;
	}
	public void setMatterThemeType(String matterThemeType) {
		this.matterThemeType = matterThemeType;
	}
	
}

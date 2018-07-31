package com.numberONe.vo;

import java.io.Serializable;

import com.numberONe.po.MaterialPo;


public class MaterialVo extends MaterialPo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String materialName;
	private String materialGetId;
	private String getMode;
	private String userIdCard;
	private String userType;
	private String materialNameget;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getMaterialGetId() {
		return materialGetId;
	}
	public void setMaterialGetId(String materialGetId) {
		this.materialGetId = materialGetId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getGetMode() {
		return getMode;
	}
	public void setGetMode(String getMode) {
		this.getMode = getMode;
	}
	public String getUserIdCard() {
		return userIdCard;
	}
	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getMaterialNameget() {
		return materialNameget;
	}
	public void setMaterialNameget(String materialNameget) {
		this.materialNameget = materialNameget;
	}
	

}

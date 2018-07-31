package com.numberONe.vo;

import java.io.Serializable;

public class material implements Serializable{
	private static final long serialVersionUID = 1L;
	private String matterId;
	private String materialId;
	private String materialName;
	private String materialGetId;
	private String isShow;
	
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
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
	public String getMatterId() {
		return matterId;
	}
	public void setMatterId(String matterId) {
		this.matterId = matterId;
	}
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	

}

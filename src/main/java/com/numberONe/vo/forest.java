package com.numberONe.vo;

import java.io.Serializable;

public class forest implements Serializable{
	private static final long serialVersionUID = 1L;
	private String forestArea;//森林采伐面积
	private String forestAccumulation;//森林采伐积蓄
	private String forestAddress;//森林采伐地点
	private String forestReason;//森林采伐事由
	private String forestType;//森林采伐树种
	public String getForestArea() {
		return forestArea;
	}
	public void setForestArea(String forestArea) {
		this.forestArea = forestArea;
	}
	public String getForestAccumulation() {
		return forestAccumulation;
	}
	public void setForestAccumulation(String forestAccumulation) {
		this.forestAccumulation = forestAccumulation;
	}
	public String getForestAddress() {
		return forestAddress;
	}
	public void setForestAddress(String forestAddress) {
		this.forestAddress = forestAddress;
	}
	public String getForestReason() {
		return forestReason;
	}
	public void setForestReason(String forestReason) {
		this.forestReason = forestReason;
	}
	public String getForestType() {
		return forestType;
	}
	public void setForestType(String forestType) {
		this.forestType = forestType;
	}
	
}

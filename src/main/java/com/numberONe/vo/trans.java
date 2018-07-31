package com.numberONe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class trans implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String transName;
	private String transBaseCode;
	private String materialIds;
	private String materialName;
	private String materialNames;
	private ArrayList<String> materialNameList;
	private ArrayList<String> materialIdList;
	private String applyId;
	private String themeApplyId;
	private Map<String,Object> result;//办件的办件结果 map
	private ArrayList<applyInfo> applylist;
	private String officeName;
	private String officeId;
	private Map<String,Object> hasten;//办件的催办信息
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTransName() {
		return transName;
	}
	public void setTransName(String transName) {
		this.transName = transName;
	}
	public String getMaterialIds() {
		return materialIds;
	}
	public void setMaterialIds(String materialIds) {
		this.materialIds = materialIds;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getMaterialNames() {
		return materialNames;
	}
	public void setMaterialNames(String materialNames) {
		this.materialNames = materialNames;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "trans [id=" + id + ", transName=" + transName
				+ ", materialIds=" + materialIds + ", materialName="
				+ materialName + ", materialNames=" + materialNames + "]";
	}
	public ArrayList<String> getMaterialNameList() {
		return materialNameList;
	}
	public void setMaterialNameList(ArrayList<String> materialNameList) {
		this.materialNameList = materialNameList;
	}
	public ArrayList<String> getMaterialIdList() {
		return materialIdList;
	}
	public void setMaterialIdList(ArrayList<String> materialIdList) {
		this.materialIdList = materialIdList;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getThemeApplyId() {
		return themeApplyId;
	}
	public void setThemeApplyId(String themeApplyId) {
		this.themeApplyId = themeApplyId;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
	public ArrayList<applyInfo> getApplylist() {
		return applylist;
	}
	public void setApplylist(ArrayList<applyInfo> applylist) {
		this.applylist = applylist;
	}
	public String getTransBaseCode() {
		return transBaseCode;
	}
	public void setTransBaseCode(String transBaseCode) {
		this.transBaseCode = transBaseCode;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public Map<String, Object> getHasten() {
		return hasten;
	}
	public void setHasten(Map<String, Object> hasten) {
		this.hasten = hasten;
	}
	public String getOfficeId() {
		return officeId;
	}
	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}
	
	

}

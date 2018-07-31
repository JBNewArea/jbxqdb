package com.numberONe.po;

import java.io.Serializable;

public class MaterialPo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String materialId;
	private String materialName;
	private String applyId;
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
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	@Override
	public String toString() {
		return "MaterialPo [materialId=" + materialId + ", materialName="
				+ materialName + ", applyId=" + applyId + "]";
	}
	

}

package com.numberONe.vo;

import java.io.Serializable;

import com.numberONe.po.MatterThemePo;


public class MatterThemeVo extends MatterThemePo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String matterName;
	public String getMatterName() {
		return matterName;
	}
	public void setMatterName(String matterName) {
		this.matterName = matterName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

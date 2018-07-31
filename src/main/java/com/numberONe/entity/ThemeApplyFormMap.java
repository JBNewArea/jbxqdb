package com.numberONe.entity;

import com.numberONe.annotation.TableSeg;
import com.numberONe.util.FormMap;
@TableSeg(tableName = "theme_apply", id="id")
public class ThemeApplyFormMap extends FormMap<String, Object>{
	private static final long serialVersionUID = 1L;
	private String matterStatus;
	private String matterThemeName;
	private String roleName;
	public String getMatterStatus() {
		return matterStatus;
	}
	public void setMatterStatus(String matterStatus) {
		this.matterStatus = matterStatus;
	}
	public String getMatterThemeName() {
		return matterThemeName;
	}
	public void setMatterThemeName(String matterThemeName) {
		this.matterThemeName = matterThemeName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	

}

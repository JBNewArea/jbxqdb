package com.numberONe.vo;

import java.io.Serializable;

import com.numberONe.po.LyResourcesPo;


public class LyResourcesVo extends LyResourcesPo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String parentName;
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	

}

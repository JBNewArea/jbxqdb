package com.numberONe.po;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HastenPo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String hastenId;
	private String applyId;
	private String themeApplyId;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date StatusDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date CreateDate;
	private String status;
	public String getHastenId() {
		return hastenId;
	}
	public void setHastenId(String hastenId) {
		this.hastenId = hastenId;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public Date getStatusDate() {
		return StatusDate;
	}
	public void setStatusDate(Date statusDate) {
		StatusDate = statusDate;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
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
	public String getThemeApplyId() {
		return themeApplyId;
	}
	public void setThemeApplyId(String themeApplyId) {
		this.themeApplyId = themeApplyId;
	}
	

}

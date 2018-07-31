package com.numberONe.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HastenBackVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String officeNumber;			// 办件编号
	private String hastenNumber;			// 督办编号
	private String hastenMan;				// 督办人
	private String hastenDate;				// 督办时间
	private String hastenIdea;				// 督办意见
	private String isTrue;					// 是否属实（1.是  2.否）
	private String hastenStatus;			// 督办状态（1.在督办 2.办结督办）
	private String _hastenStatus;//翻译
	private String officeName;				// 所属部门 
	private String transName;				// 事项名称
	private String applicantName;			// 申请人
	private String Status; 					// 办件状态
	private String _Status;//办件状态 翻译
	private String promiseDay;			    // 承诺时间 
	private String remarks;                 // 备注
	private String updateby;                //反馈人
	private String hupdateDate;                //反馈时间
	public String getOfficeNumber() {
		return officeNumber;
	}
	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}
	public String getHastenNumber() {
		return hastenNumber;
	}
	public void setHastenNumber(String hastenNumber) {
		this.hastenNumber = hastenNumber;
	}
	public String getHastenMan() {
		return hastenMan;
	}
	public void setHastenMan(String hastenMan) {
		this.hastenMan = hastenMan;
	}
	public String getHastenIdea() {
		return hastenIdea;
	}
	public void setHastenIdea(String hastenIdea) {
		this.hastenIdea = hastenIdea;
	}
	public String getIsTrue() {
		return isTrue;
	}
	public void setIsTrue(String isTrue) {
		this.isTrue = isTrue;
	}
	public String getHastenStatus() {
		return hastenStatus;
	}
	public void setHastenStatus(String hastenStatus) {
		this.hastenStatus = hastenStatus;
		if("1".equals(this.hastenStatus)){
			this._hastenStatus = "在督办";
		}else if("2".equals(this.hastenStatus)){
			this._hastenStatus = "办结督办";
		}
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public String getTransName() {
		return transName;
	}
	public void setTransName(String transName) {
		this.transName = transName;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		this.Status = status;
		if("0".equals(this.Status)){
			this._Status = "待接件";
		}else if("1".equals(this.Status)){
			this._Status = "已删除";
		}else if("2".equals(this.Status)){
			this._Status = "审批中";
		}else if("3".equals(this.Status)){
			this._Status = "待办结";
		}else if("4".equals(this.Status)){
			this._Status = "已办结";
		}else if("5".equals(this.Status)){
			this._Status = "已归档";
		}else if("6".equals(this.Status)){
			this._Status = "待受理";
		}
		
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getUpdateby() {
		return updateby;
	}
	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}
	public String get_hastenStatus() {
		return _hastenStatus;
	}
	public void set_hastenStatus(String _hastenStatus) {
		this._hastenStatus = _hastenStatus;
	}
	public String get_Status() {
		return _Status;
	}
	public void set_Status(String _Status) {
		this._Status = _Status;
	}
	public String getHastenDate() {
		return hastenDate;
	}
	public void setHastenDate(String hastenDate) {
		this.hastenDate = hastenDate;
	}
	public String getPromiseDay() {
		return promiseDay;
	}
	public void setPromiseDay(String promiseDay) {
		this.promiseDay = promiseDay;
	}
	public String getHupdateDate() {
		return hupdateDate;
	}
	public void setHupdateDate(String hupdateDate) {
		this.hupdateDate = hupdateDate;
	}
	

}

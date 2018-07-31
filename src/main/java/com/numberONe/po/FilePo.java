package com.numberONe.po;

import java.io.Serializable;
import java.util.Date;

public class FilePo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String fileId;
	private String fileName;
	private String fileType;
	private String filePath;
	private String materialId;
	private String applyId;
	private Date createDate;
	private Date statusDate;
	private String status;
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "FilePo [fileId=" + fileId + ", fileName=" + fileName
				+ ", fileType=" + fileType + ", filePath=" + filePath
				+ ", materialId=" + materialId + ", applyId=" + applyId
				+ ", createDate=" + createDate + ", statusDate=" + statusDate
				+ ", status=" + status + "]";
	}
	
}

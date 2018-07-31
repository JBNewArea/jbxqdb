package com.numberONe.po;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserPo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @Fields custId null
     */
    private Long custId;
    /**
     * @Fields custCode 可映射学号，房号等
     */
    private String custCode;
    /**
     * @Fields custName null
     */
    private String custName;
    /**
     * @Fields custType null
     */
    private String custType;
    /**
     * @Fields custSex null
     */
    private String custSex;
    
    private String custNation;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date custBirth;
    /**
     * @Fields identityType 目前只有身份证
I00 身份证
     */
    private String identityType;
    /**
     * @Fields identityCode null
     */
    private String identityCode;
    /**
     * @Fields identityCardFront null
     */
    private Long identityCardFront;
    /**
     * @Fields identityCardBack null
     */
    private Long identityCardBack;
    /**
     * @Fields handheldPhoto null
     */
    private Long handheldPhoto;
    /**
     * @Fields password MD5加密过的
     */
    private String password;
    /**
     * @Fields email null
     */
    private String email;
    /**
     * @Fields phoneNbr null
     */
    private String phoneNbr;
    /**
     * @Fields regDate null
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date regDate;
    /**
     * @Fields passExpDate null
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date passExpDate;
    /**
     * @Fields address null
     */
    private String address;
    /**
     * @Fields verifiedStatus null
     */
    private String verifiedStatus;
    /**
     * @Fields verifiedDate null
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date verifiedDate;
    /**
     * @Fields verifiedChannel 窗口
自助终端
网上
手机APP
关联
     */
    private String verifiedChannel;
    /**
     * @Fields verifiedChannelNo null
     */
    private String verifiedChannelNo;
    /**
     * @Fields status 00A 有效
00X 失效
00U 归档
     */
    
    private String issueGov;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date idEffDate;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date idExpDate;
    
    private String status;
    /**
     * @Fields createDate null
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    /**
     * @Fields statusDate null
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date statusDate;
    /**
     * @Fields effDate null
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date effDate;
    /**
     * @Fields expDate null
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date expDate;
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getCustSex() {
		return custSex;
	}
	public void setCustSex(String custSex) {
		this.custSex = custSex;
	}
	public String getCustNation() {
		return custNation;
	}
	public void setCustNation(String custNation) {
		this.custNation = custNation;
	}
	public Date getCustBirth() {
		return custBirth;
	}
	public void setCustBirth(Date custBirth) {
		this.custBirth = custBirth;
	}
	public String getIdentityType() {
		return identityType;
	}
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}
	public String getIdentityCode() {
		return identityCode;
	}
	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}
	public Long getIdentityCardFront() {
		return identityCardFront;
	}
	public void setIdentityCardFront(Long identityCardFront) {
		this.identityCardFront = identityCardFront;
	}
	public Long getIdentityCardBack() {
		return identityCardBack;
	}
	public void setIdentityCardBack(Long identityCardBack) {
		this.identityCardBack = identityCardBack;
	}
	public Long getHandheldPhoto() {
		return handheldPhoto;
	}
	public void setHandheldPhoto(Long handheldPhoto) {
		this.handheldPhoto = handheldPhoto;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNbr() {
		return phoneNbr;
	}
	public void setPhoneNbr(String phoneNbr) {
		this.phoneNbr = phoneNbr;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getPassExpDate() {
		return passExpDate;
	}
	public void setPassExpDate(Date passExpDate) {
		this.passExpDate = passExpDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVerifiedStatus() {
		return verifiedStatus;
	}
	public void setVerifiedStatus(String verifiedStatus) {
		this.verifiedStatus = verifiedStatus;
	}
	public Date getVerifiedDate() {
		return verifiedDate;
	}
	public void setVerifiedDate(Date verifiedDate) {
		this.verifiedDate = verifiedDate;
	}
	public String getVerifiedChannel() {
		return verifiedChannel;
	}
	public void setVerifiedChannel(String verifiedChannel) {
		this.verifiedChannel = verifiedChannel;
	}
	public String getVerifiedChannelNo() {
		return verifiedChannelNo;
	}
	public void setVerifiedChannelNo(String verifiedChannelNo) {
		this.verifiedChannelNo = verifiedChannelNo;
	}
	public String getIssueGov() {
		return issueGov;
	}
	public void setIssueGov(String issueGov) {
		this.issueGov = issueGov;
	}
	public Date getIdEffDate() {
		return idEffDate;
	}
	public void setIdEffDate(Date idEffDate) {
		this.idEffDate = idEffDate;
	}
	public Date getIdExpDate() {
		return idExpDate;
	}
	public void setIdExpDate(Date idExpDate) {
		this.idExpDate = idExpDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public Date getEffDate() {
		return effDate;
	}
	public void setEffDate(Date effDate) {
		this.effDate = effDate;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
    
}

package com.numberONe.vo;

import java.io.Serializable;

import com.numberONe.po.ThemeApplyPo;


public class ThemeApplyVo extends ThemeApplyPo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String matterId;//事项id
	private String matterThmeId;//主题事项ID
	private String matterThemeCode;//主题事项编码
	private String applySource;
	private String agentName;
	private String agentDocumentType;
	private String agentDocumentNumber;
	private String matterIds;
	
	//个性化数据 土地
	private String gongchengName;		//工程名称GONGCHENGNAME
	private String gongchengAddress;	//工程建设地点GONGCHENGADDRESS
	private String gongchengCotent;		//建设内容GONGCHENGCOTENT
	private String gongchengGuiMo;		//建设规模GONGCHENGGUIMO
	private String gongchengBeiZhu;		//备注GONGCHENGBEIZHU
	private Double gongchengMianJi;		//申报建筑面积GONGCHENGMIANJI
	private Double gongchengZaoJia;		//工程合同造价GONGCHENGZAOJIA
	private String gongchengKaiGong;	//开工日期GONGCHENGKAIGONG
	private String gongchengJunGong;	//竣工日期GONGCHENGJUNGONG
	
	//个性化数据 森林
	private Double forestArea;//森林采伐面积
	private Double forestAccumulation;//森林采伐积蓄
	private String forestAddress;//森林采伐地点
	private String forestReason;//森林采伐事由
	private String forestType;//森林采伐树种
	
	public String getMatterId() {
		return matterId;
	}
	public void setMatterId(String matterId) {
		this.matterId = matterId;
	}
	public String getMatterThmeId() {
		return matterThmeId;
	}
	public void setMatterThmeId(String matterThmeId) {
		this.matterThmeId = matterThmeId;
	}
	public String getApplySource() {
		return applySource;
	}
	public void setApplySource(String applySource) {
		this.applySource = applySource;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentDocumentType() {
		return agentDocumentType;
	}
	public void setAgentDocumentType(String agentDocumentType) {
		this.agentDocumentType = agentDocumentType;
	}
	public String getAgentDocumentNumber() {
		return agentDocumentNumber;
	}
	public void setAgentDocumentNumber(String agentDocumentNumber) {
		this.agentDocumentNumber = agentDocumentNumber;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getMatterIds() {
		return matterIds;
	}
	public void setMatterIds(String matterIds) {
		this.matterIds = matterIds;
	}
	public String getMatterThemeCode() {
		return matterThemeCode;
	}
	public void setMatterThemeCode(String matterThemeCode) {
		this.matterThemeCode = matterThemeCode;
	}
	public String getGongchengName() {
		return gongchengName;
	}
	public void setGongchengName(String gongchengName) {
		this.gongchengName = gongchengName;
	}
	public String getGongchengAddress() {
		return gongchengAddress;
	}
	public void setGongchengAddress(String gongchengAddress) {
		this.gongchengAddress = gongchengAddress;
	}
	public String getGongchengCotent() {
		return gongchengCotent;
	}
	public void setGongchengCotent(String gongchengCotent) {
		this.gongchengCotent = gongchengCotent;
	}
	public String getGongchengGuiMo() {
		return gongchengGuiMo;
	}
	public void setGongchengGuiMo(String gongchengGuiMo) {
		this.gongchengGuiMo = gongchengGuiMo;
	}
	public String getGongchengBeiZhu() {
		return gongchengBeiZhu;
	}
	public void setGongchengBeiZhu(String gongchengBeiZhu) {
		this.gongchengBeiZhu = gongchengBeiZhu;
	}
	public Double getGongchengMianJi() {
		return gongchengMianJi;
	}
	public void setGongchengMianJi(Double gongchengMianJi) {
		this.gongchengMianJi = gongchengMianJi;
	}
	public Double getGongchengZaoJia() {
		return gongchengZaoJia;
	}
	public void setGongchengZaoJia(Double gongchengZaoJia) {
		this.gongchengZaoJia = gongchengZaoJia;
	}
	public String getGongchengKaiGong() {
		return gongchengKaiGong;
	}
	public void setGongchengKaiGong(String gongchengKaiGong) {
		this.gongchengKaiGong = gongchengKaiGong;
	}
	public String getGongchengJunGong() {
		return gongchengJunGong;
	}
	public void setGongchengJunGong(String gongchengJunGong) {
		this.gongchengJunGong = gongchengJunGong;
	}

	public Double getForestArea() {
		return forestArea;
	}
	public void setForestArea(Double forestArea) {
		this.forestArea = forestArea;
	}
	public Double getForestAccumulation() {
		return forestAccumulation;
	}
	public void setForestAccumulation(Double forestAccumulation) {
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

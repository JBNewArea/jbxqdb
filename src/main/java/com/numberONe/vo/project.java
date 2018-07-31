package com.numberONe.vo;

import java.io.Serializable;

public class project implements Serializable{
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
		
		//临时占用城市绿地审批---0100169001-1
		private Double greenLandArea;		//绿地占用面积
		private String greenLandAddress;	//绿地所在地
		private String greenLandOccupyTerm; //绿地占用期限
		
		//砍伐城市树木、迁移古树名木审批---0100169002-1
		private String treeName;		 //树木名称
		private String treeAddress;		 //树木所在地
		private String treeNumber;		 //树木数量

		//占用、挖掘城市道路审批----0100166001-1
		private String roadAddress;		 //挖掘占用地点和范围
		private String roadOccupyTerm;	 //挖掘占用期限
		private Double roadwayLong;	 	 //车行道长
		private Double roadwayWide;	 	 //车行道宽
		private Double roadwayArea;	 	 //车行道占用面积
		private Double footwayLong;	 	 //人行道长
		private Double footwayWide;	 	 //人行道宽
		private Double footwayArea;	 	 //人行道占用面积

		
		public Double getGreenLandArea() {
			return greenLandArea;
		}
		public void setGreenLandArea(Double greenLandArea) {
			this.greenLandArea = greenLandArea;
		}
		public String getGreenLandAddress() {
			return greenLandAddress;
		}
		public void setGreenLandAddress(String greenLandAddress) {
			this.greenLandAddress = greenLandAddress;
		}
		public String getGreenLandOccupyTerm() {
			return greenLandOccupyTerm;
		}
		public void setGreenLandOccupyTerm(String greenLandOccupyTerm) {
			this.greenLandOccupyTerm = greenLandOccupyTerm;
		}
		public String getTreeName() {
			return treeName;
		}
		public void setTreeName(String treeName) {
			this.treeName = treeName;
		}
		public String getTreeAddress() {
			return treeAddress;
		}
		public void setTreeAddress(String treeAddress) {
			this.treeAddress = treeAddress;
		}
		public String getTreeNumber() {
			return treeNumber;
		}
		public void setTreeNumber(String treeNumber) {
			this.treeNumber = treeNumber;
		}
		public String getRoadAddress() {
			return roadAddress;
		}
		public void setRoadAddress(String roadAddress) {
			this.roadAddress = roadAddress;
		}
		public String getRoadOccupyTerm() {
			return roadOccupyTerm;
		}
		public void setRoadOccupyTerm(String roadOccupyTerm) {
			this.roadOccupyTerm = roadOccupyTerm;
		}
		public Double getRoadwayLong() {
			return roadwayLong;
		}
		public void setRoadwayLong(Double roadwayLong) {
			this.roadwayLong = roadwayLong;
		}
		public Double getRoadwayWide() {
			return roadwayWide;
		}
		public void setRoadwayWide(Double roadwayWide) {
			this.roadwayWide = roadwayWide;
		}
		public Double getRoadwayArea() {
			return roadwayArea;
		}
		public void setRoadwayArea(Double roadwayArea) {
			this.roadwayArea = roadwayArea;
		}
		public Double getFootwayLong() {
			return footwayLong;
		}
		public void setFootwayLong(Double footwayLong) {
			this.footwayLong = footwayLong;
		}
		public Double getFootwayWide() {
			return footwayWide;
		}
		public void setFootwayWide(Double footwayWide) {
			this.footwayWide = footwayWide;
		}
		public Double getFootwayArea() {
			return footwayArea;
		}
		public void setFootwayArea(Double footwayArea) {
			this.footwayArea = footwayArea;
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
		public void setGongchengMianJi(String gongchengMianJi){
			this.gongchengMianJi = Double.valueOf(gongchengMianJi);
		}
		public Double getGongchengZaoJia() {
			return gongchengZaoJia;
		}
		public void setGongchengZaoJia(Double gongchengZaoJia) {
			this.gongchengZaoJia = gongchengZaoJia;
		}
		public void setGongchengZaoJia(String gongchengZaoJia){
			this.gongchengZaoJia = Double.valueOf(gongchengZaoJia);
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
		public void setForestArea(String forestArea){
			this.forestArea = Double.valueOf(forestArea);
		}
		public Double getForestAccumulation() {
			return forestAccumulation;
		}
		public void setForestAccumulation(Double forestAccumulation) {
			this.forestAccumulation = forestAccumulation;
		}
		public void setForestAccumulation(String forestAccumulation){
			this.forestAccumulation = Double.valueOf(forestAccumulation);
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

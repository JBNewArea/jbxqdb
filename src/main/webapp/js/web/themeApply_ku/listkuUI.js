var pageii = null;
var pageDO = null;//点击继续办理的弹窗
var grid = null;
//function openApplyPage(id1,id2){
//	pageDO = layer.open({
//		title : "代办操作",
//		type : 2,
//		area : [ "1200px", "90%" ],
//		content : rootPath + '/themeApply_fq/doApplyUI.shtml?id1=' + id1+'&id2='+id2
//	});
//};
$(function() {
	
	grid = lyGrid({
		pagId : 'paging',
		l_column : [ {
			colkey : "id",
			name : "id",
			hide:true,
		}, {
			colkey : "name",
			name : "项目名称",
			isSort:false,
			renderData : function(rowindex,data, rowdata, column) {
				console.log(rowdata);
				return ['<a class="a_goontoApply" href="javascript:void(0);" onclick="clickbind(this);" style="color:#0000FF;" data-matterStatus = "',rowdata.matterStatus,'" ',
				        'data-matterThemeId = "',rowdata.matterThemeId,'"',
				        'data-applicantDocumentType = "',rowdata.applicantDocumentType,'"',
				        'data-applicationDocumentNumber = "',rowdata.applicationDocumentNumber,'"',
				        'data-id = "',rowdata.id,'"',
					'>',data,'</a>'].join('');
			}
		},{
			colkey:"matterThemeName",
			name:"主题事项名称",
			isSort:false,
		},{
			colkey : "createDate",
			name : "创建办件时间",
			isSort:true,
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		},{
			colkey : "roleName",
			name : "代办平台",
			isSort : false,
		}, {
			colkey:"agentName",
			name:"代办人",
			isSort:false,
		},{
			colkey : "statusDate",
			name : "上次办理时间",
			isSort:false,
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd");
			}
		},{
			colkey : "matterStatus",
			name : "主题事项状态",
			hide:true,
		}],
		jsonUrl : rootPath + '/themeApply_ku/findByPage.shtml',
		data:{column:"createDate",sort:"desc",pageNow:1,pageSize:9},
		checkbox : true,
		serNumber : true
	});
	$("#search").click("#search", function() {// 绑定查询按扭
		var searchParams = $("#searchForm").serializeJson();// 初始化传参数
		searchParams = $.extend(searchParams,{"pageNow":'1'});
		grid.setOptions({
			data : searchParams
		});
	});
	
	//点击继续办理按钮事件
	$('#btn_goontoApply').on("click",function(){
		goontoApply();
	});
	//点击项目名称继续办理 按钮事件
	/*$('.a_goontoApply').on("click",function(){
		alert("start");
		var matterStatus = $(this).attr("data-matterStatus");
		if(matterStatus != '00Y'){
			layer.msg("该主题事项已经被删除!无法代办");
			return;
		}
		var cbox = $(this).attr("data-id");
		var matterThemeId = $(this).attr("data-matterThemeId");
		var applicantDocumentType = $(this).attr("data-applicantDocumentType");
		var applicationDocumentNumber = $(this).attr("data-applicationDocumentNumber");
		console.log($(this).attr("data-applicantDocumentType"));
		pageDO = layer.open({
			title : "代办操作",
			type : 2,
			area : [ "1200px", "80%" ],
			//传入主题办件id1和主题事项id2
			content : rootPath + '/themeApply_fq/doApplyUI.shtml?id1=' + cbox+'&id2='+matterThemeId
			+'&applicantDocumentType='+applicantDocumentType+'&applicationDocumentNumber='+applicationDocumentNumber,
		});
	});*/
	
	
	function goontoApply(){
		var cbox = grid.getSelectedCheckbox();
		var row = grid.selectRow(); 
		if (cbox.length > 1 || cbox == "") {
			layer.msg("只能选中一个");
			return;
		}
		if(row[0].matterStatus != '00Y'){
			layer.msg("该主题事项已经被删除!无法代办");
			return;
		}
		var matterThemeId = row[0].matterThemeId;
		var applicantDocumentType = row[0].applicantDocumentType;
		var applicationDocumentNumber = row[0].applicationDocumentNumber;
		pageDO = layer.open({
			title : "代办操作",
			type : 2,
			area : [ "1200px", "80%" ],
			//传入主题办件id1和主题事项id2
			content : rootPath + '/themeApply_fq/doApplyUI.shtml?id1=' + cbox+'&id2='+matterThemeId
			+'&applicantDocumentType='+applicantDocumentType+'&applicationDocumentNumber='+applicationDocumentNumber,
		});
	}
	
	
//	$("#addMatterTheme").click("click", function() {
//		addMatterTheme();
//	});
//	$("#editMatterTheme").click("click", function() {
//		editMatterTheme();
//	});
//	$("#deleteMatterTheme").click("click", function() {
//		deleteMatterTheme();
//	});
//	$("#permissions").click("click", function() {
//		permissions();
//	});
});
function clickbind(ele){
	var _this = $(ele);
	var matterStatus = _this.attr("data-matterStatus");
	if(matterStatus != '00Y'){
		layer.msg("该主题事项已经被删除!无法代办");
		return;
	}
	var cbox = _this.attr("data-id");
	var matterThemeId = _this.attr("data-matterThemeId");
	var applicantDocumentType = _this.attr("data-applicantDocumentType");
	var applicationDocumentNumber = _this.attr("data-applicationDocumentNumber");
	console.log(_this.attr("data-applicantDocumentType"));
	pageDO = layer.open({
		title : "代办操作",
		type : 2,
		area : [ "1200px", "80%" ],
		//传入主题办件id1和主题事项id2
		content : rootPath + '/themeApply_fq/doApplyUI.shtml?id1=' + cbox+'&id2='+matterThemeId
		+'&applicantDocumentType='+applicantDocumentType+'&applicationDocumentNumber='+applicationDocumentNumber,
	});
}
//function gotoApply(){
//	var cbox = grid.getSelectedCheckbox();
//	if (cbox.length > 1 || cbox == "") {
//		layer.msg("只能选中一个");
//		return;
//	}
//	pageii = layer.open({
//		title : "请填写单位及项目基本信息",
//		type : 2,
//		area : [ "1200px", "90%" ],
//		content : rootPath + '/themeApply_fq/basicInfo.shtml?id=' + cbox
//	});
//}
//function editMatterTheme() {
//	var cbox = grid.getSelectedCheckbox();
//	if (cbox.length > 1 || cbox == "") {
//		layer.msg("只能选中一个");
//		return;
//	}
//	pageii = layer.open({
//		title : "编辑代办项目",
//		type : 2,
//		area : [ "1200px", "90%" ],
//		content : rootPath + '/matterTheme/editUI.shtml?id=' + cbox
//	});
//}
//function addMatterTheme() {
//	pageii = layer.open({
//		title : "新增代办项目",
//		type : 2,
//		area : [ "1200px", "90%" ],
//		content : rootPath + '/matterTheme/addUI.shtml'
//	});
//}
//function deleteMatterTheme() {
//	var cbox = grid.getSelectedCheckbox();
//	console.log(cbox);
//	if (cbox == "") {
//		layer.msg("请选择删除项！！");
//		return;
//	}
//	layer.confirm('是否删除？', function(index) {
//		var url = rootPath + '/matterTheme/deleteEntity.shtml';
//		var s = CommnUtil.ajax(url, {
//			ids : cbox.join(",")
//		}, "json");
//		if (s == "success") {
//			layer.msg('删除成功');
//			grid.loadData();
//		} else {
//			layer.msg('删除失败');
//		}
//	});
//}
//function permissions() {
//	var cbox = grid.getSelectedCheckbox();
//	if (cbox.length > 1 || cbox == "") {
//		layer.msg("请选择一个对象！");
//		return;
//	}
//	var url = rootPath + '/resources/permissions.shtml?userId='+cbox;
//	pageii = layer.open({
//		title : "分配权限",
//		type : 2,
//		area : [ "700px", "80%" ],
//		content : url
//	});
//}
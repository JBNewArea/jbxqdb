var pageii = null;
var grid = null;
var pageDO = null;
function openApplyPage(id1,id2,applicantDocumentType,applicationDocumentNumber){
	pageDO = layer.open({
		title : "代办操作",
		type : 2,
		area : [ "1200px", "80%" ],
		content : rootPath + '/themeApply_fq/doApplyUI.shtml?id1=' + id1+'&id2='+id2
		+'&applicantDocumentType='+applicantDocumentType+'&applicationDocumentNumber='+applicationDocumentNumber,
	});
};
$(function() {
	
	grid = lyGrid({
		pagId : 'paging',
		l_column : [ {
			colkey : "id",
			name : "id",
			hide:true,
		}, {
			colkey : "matterThemeName",
			name : "主题事项名称",
			isSort:false,
			renderData : function(rowindex,data, rowdata, column) {
				console.log(rowdata);
				return '<a class="a_gotoApply" style="color:#0000FF;" data-id = "'+rowdata.id+'" >'+data+'</a>';
			}
		},{
			colkey : "createDate",
			name : "创建时间",
			isSort:true,
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		}, {
			colkey:"userNameMade",
			name:"项目创建人",
			isSort:false,
		},{
			colkey : "statusDate",
			name : "上次修改时间",
			isSort:false,
			renderData : function(rowindex,data, rowdata, column) {
				return new Date(data).format("yyyy-MM-dd hh:mm:ss");
			}
		}],
		jsonUrl : rootPath + '/matterTheme/findByPage.shtml',
		data:{column:"createDate",sort:"desc",pageNow:1,pageSize:9},
		checkbox : true,
		serNumber : true
	});
	$("#search").click("#search", function() {// 绑定查询按扭
		var searchParams = $("#searchForm").serializeJson();// 初始化传参数
		console.log(searchParams,{"pageNow":'1'});
		grid.setOptions({
			data : searchParams
		});
	});
	
	//点击代办发起按钮事件
	$('#btn_gotoApply').click("click",function(){
		gotoApply();
	});
	//点击事项名称发起 代办按钮的事件
	$('.a_gotoApply').click("click",function(){
		var cbox = $(this).attr("data-id");
		pageii = layer.open({
			title : "请填写单位及项目基本信息",
			type : 2,
			area : [ "1200px", "90%" ],
			content : rootPath + '/themeApply_fq/basicInfo.shtml?id=' + cbox
		});
	});
	
	
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
function gotoApply(){
	var cbox = grid.getSelectedCheckbox();
	if (cbox.length > 1 || cbox == "") {
		layer.msg("只能选中一个");
		return;
	}
	pageii = layer.open({
		title : "请填写单位及项目基本信息",
		type : 2,
		area : [ "1200px", "90%" ],
		content : rootPath + '/themeApply_fq/basicInfo.shtml?id=' + cbox
	});
}
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
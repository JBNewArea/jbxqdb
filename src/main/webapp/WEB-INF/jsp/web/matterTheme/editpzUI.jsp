<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/web/matterTheme/editpzUI.js"></script>
<script type="text/javascript" src="${ctx}/js/enhance.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.serializeObject.min.js"></script>
<style type="text/css">
.col-sm-3 {
	width: 15%;
	float: left;
}

.col-sm-9 {
	width: 85%;
	float: left;
}


.detail_table{
	width:100%;
}
.top_left_td{
	background:#eff0f4!important;
	width:15%;
	text-align:center;
	height:50px;
    display: table-cell;
    vertical-align: inherit;
}
.top_right_td{
	width:35%;
	text-align:center;
	height:50px;
}
.table_checkbox{
	width:100px;
	float:left;
	height:15px;
	margin-top:15px;
	margin-bottom:15px;
	text-align:left;
	padding-left:15px;
}
.left_td{
	background:#eff0f4!important;
	width:15%;
	text-align:center;
	height:50px;
}
.right_td{
	width:35%;
	height:50px;
	text-align:center;
	padding-left:10px;
	padding-right:10px;
	padding-top:10px;
	padding-bottom:10px;
}
.showMatter{
	width: 53px;
    height: 30px;
    background-color: #ffffff;
    border-radius: 3px;
    border: solid 1px #57a3f2;
    color: #57a3f2;
    outline: none;
    margin-left: 3%;
}
.flow_matter_theme_edit{
	height:630px!important;
	overflow-y:scroll;
}
.flow_matter_theme_edit::-webkit-scrollbar
{
    width: 0!important;
    height: 0!important;;
}
.querenButton{
	width: 230px;
    height: 58px;
    background-color: #57a3f2;
    border-radius: 9px;
    color: white;
    border: none;
    outline: none;
    font-size: 20px;
    align:center;
}
.bootstrap-dialog-footer-buttons{
	text-align:center!important;
}
.detail_table .inputWord{
	margin-left:5px;
	font-weight: normal;
	font-family: Arial;
}
.hide{
	display:none;
}
.panel-body{
	min-height:347px;
}
</style>
</head>
<body>
	<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
	
	<form id="form" name="form" class="form-horizontal" method="post"
		url="${ctx}/matterTheme/editEntity.shtml">
	<section class="panel panel-default">
			<input type="hidden" class="form-control" name="dataSet_id" value="${matterTheme.id }">
			<input type="hidden" class="form-control" name="id" value="${matterTheme.id }">
			<input type="hidden" class="form-control" name="dataset_matterThemeName" value="${matterTheme.matterThemeName }">
			<div class="panel-body">
			<input type='text' name="dataSet" style="display:none;" data-set="${matterTheme}">
			<table class="detail_table" border="1" style="border:1px;border-spacing: 2px;border-collapse: collapse;border-color:#DBDCDD;">
			<tbody style="border-color: inherit;">
				<!-- <tr>
					<td class="top_left_td">
						主题事项名称
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control" name="matterThemeName" style="background-color:#eff0f4;border-radius:0px;width:100%;"
						placeholder="项目名称" validate="{required:true}">
					</td>
					<td class="top_left_td">
						项目地址
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control" name="themeAddress" 
							style="background-color:#eff0f4;border-radius:0px;width:100%;"
							placeholder="项目地址" validate="{required:true}">
					</td>
				</tr> -->
				<tr>
					<td class="left_td">
						主题事项名称
					</td>
					<td class="right_td" colspan="3">
						<input type="text" class="form-control" name="matterThemeName" style="background-color:white;border-radius:0px;width:100%;"
						placeholder="主题事项名称" >
					</td>
				</tr>
				
				<!-- <tr>
					<td class="top_left_td">
						项目编码
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control" name="matterThemeCode" style="background-color:#eff0f4;border-radius:0px;width:100%;"
						placeholder="项目编码" validate="{required:true}">
					</td>
					<td class="top_left_td">
						总投资额
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control" name="invest" style="float:left;background-color:#eff0f4;border-radius:0px;width:40%;"
						placeholder="总投资额" validate="{required:true,isNumber:true}">
						<span style="float:left;line-height:35px;margin-left:10px;">元</span>
					</td>
				</tr> -->
				
				<!-- <tr>
					<td class="left_td">
						资金来源
					</td>
					<td class="right_td" colspan="3">
						<span class="table_checkbox">
							<input type='checkbox' name="moneyResource" value="1" ><label class="inputWord">政府</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="moneyResource"  value="2" ><label class="inputWord">民资</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="moneyResource"  value="3" ><label class="inputWord">港澳台</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="moneyResource" value="4" ><label class="inputWord">外资</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="moneyResource"  value="5" ><label class="inputWord">其他</label>
						</span>
					</td>
				</tr> -->
				
				<tr>
					<td class="left_td">
							项目类型
						</td>
					<td class="right_td" colspan="3">
						<span class="table_checkbox">
							<input type='checkbox' name="matterThemeType" value="1"><label class="inputWord">区域交通</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="matterThemeType"  value="2"><label class="inputWord">城市道路</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="matterThemeType"  value="3"><label class="inputWord">环境整治</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="matterThemeType" value="4"><label class="inputWord">商业办公</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="matterThemeType"  value="5"><label class="inputWord">居住</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="matterThemeType"  value="6"><label class="inputWord">科研</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="matterThemeType"  value="7"><label class="inputWord">工业仓储</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="matterThemeType"  value="8"><label class="inputWord">市政设施</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="matterThemeType"  value="9"><label class="inputWord">公建配套</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="matterThemeType"  value="a"><label class="inputWord">公园绿地</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="matterThemeType"  value="b"><label class="inputWord">其他</label>
						</span>
					</td>
				</tr>
				
				<!-- <tr>
					<td class="left_td">
							是否重大项目
						</td>
					<td class="right_td" colspan="3">
						<div class="isImport">
							<div class=" yes" style="text-align:left;float:left;">
								<div style="float:left;">
									<input type='radio' name="isImport" id="T" value="T" style="float:left;margin-left:15px;" ><label class="inputWord">是</label>
								</div>
								<div class=" howImport hide" style="text-align:left;float:left;">
									<span>(</span>
									<input type='radio' name="isImport" class="child" value="1">省级
									<input type='radio' name="isImport" class="child"  value="2">市级
									<input type='radio' name="isImport" class="child"  value="3">区级
									<input type='radio' name="isImport" class="child" value="4">其他
									<span>)</span>
								</div>
							</div>
							<div class=" no" style="text-align:left;padding-left:15px;padding-right:15px;float:left;">
								<input type='radio' name="isImport" id="F" value="F"><label class="inputWord">否</label>
							</div>
						</div>
					</td>
				</tr> -->
				
				<tr>
					<td class="left_td">
							土地性质
						</td>
					<td class="right_td" colspan="3">
						<span class="table_checkbox">
							<input type='checkbox' name="landCharac" value="1"><label class="inputWord">划拨</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="landCharac"  value="2"><label class="inputWord">出让</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="landCharac"  value="3"><label class="inputWord">集体</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="landCharac" value="4"><label class="inputWord">自有</label>
						</span>
						<span class="table_checkbox">
							<input type='checkbox' name="landCharac"  value="5"><label class="inputWord">其他</label>
						</span>
					</td>
				</tr>
				
				<!-- <tr>
					<td class="left_td">
							项目主要建设内容
						</td>
					<td class="right_td" colspan="3">	
						<textarea rows="5" cols="10" name="mainLandContent" style="resize:none;background-color:#eff0f4;border-radius:0px;width:100%;" class="form-control" placeholder="项目主要建设内容" validate="{required:true}"></textarea>
					</td>
				</tr> -->
				
				<tr>
					<td class="left_td">
							基础事项配置
						</td>
					<td class="right_td" colspan="3">
						<input type="text" name="matterId" class=" form-control hide">
						<textarea rows="5" cols="10" name="matterName"  style="display:none;resize:none;width:40%;float:left;border-radius:0px;width:80%;" class="form-control" readonly></textarea>
						<textarea rows="10" cols="10" name="matterNameList" style="resize:none;width:40%;float:left;border-radius:0px;width:80%;" class="form-control" readonly></textarea>
						<button type='button' style="float:left;" class="showMatter">展示</button>
					</td>
				</tr>
			</tbody>
		</table>
			
		</div>
		<footer class="panel-footer text-right bg-light lter" style="margin-top:200px;">
		<button  class="btn btn-primary btn-send btn-s-xs">提交</button>
		</footer> 
		
		
		</section>
		
	</form>
	<script type="text/javascript">
	onloadurl();
	var $form = $('#form');
	var $table = $('.detail_table');
	hello();
	$form.on('click','input[name=isImport]',function(){
		hello();
	});
	function hello(){
		var _thisId = $("input[name=isImport]:checked").attr("id");
		switch($("input[name=isImport]:checked").attr("id")){
		  case "T":
		   $(".howImport").removeClass("hide");
		   break;
		  case "F":
		   $(".howImport").addClass("hide");
		   break;
		  default:
		   break;
		 }
	}
	
	/*填充form*/
	editOnload();
	function editOnload(){
		var id=$('input[name="dataSet_id"]').val();
		console.log(id);
		$.ajax({
			url:rootPath +'/matterTheme/editOnload.shtml',
			type:'post',
			data:{id:id},
			dataType:'json',
			success:function(res){
				console.log(res);
				loadDom(res);
				if(res.isImport!="F"&&res.isImport!=""){
					$form.find('.howImport').removeClass('hide');
				}
			}
		});
	}
	function loadDom(data){
		$table.deSerializeObject(data);
		var namelist = data['matterNameList'];
		var namesStr = "";
		for(var i=0;i<namelist.length;i++){
			namelist[i] = parseInt(i+1)+"  :  "+namelist[i]+" ;"+"\r\n";
			namesStr += namelist[i];
		}
		$('textarea[name=matterNameList]').val(namesStr);
		
	}
	
	
	/* var data_isImport = $form.find('input[name="data_isImport"]').val();
	var data_moneyResource = $form.find('input[name="data_moneyResource"]').val();
	var data_matterThemeType = $form.find('input[name="data_matterThemeType"]').val();
	var data_landCharac = $form.find('input[name="data_landCharac"]').val();
	$form.find('input[name="isImport"]').each(function(){
		var _this=$(this);
		for(var i=0;i>data_isImport;i++){
			if(_this.val()==data_isImport[i]){
				_this.attr("checked","true");
			}
		}
	});
	$form.find('input[name="isImport"]').val(data_isImport);
	$form.find('input[name="moneyResource"]').val(data_moneyResource);
	$form.find('input[name="matterThemeType"]').val(data_matterThemeType);
	$form.find('input[name="landCharac"]').val(data_landCharac); */
	
	</script>
</body>
</html>
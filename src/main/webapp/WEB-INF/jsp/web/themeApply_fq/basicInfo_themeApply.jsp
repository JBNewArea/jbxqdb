<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script src="${ctx}/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctx}/js/web/themeApply_fq/basicInfo_themeApply.js"></script>
<script type="text/javascript" src="${ctx}/js/enhance.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.serializeObject.min.js"></script>
<style>
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
.title{
	margin-top:10px;
	margin-bottom:10px;
	font-weight:bold;
	color:#3e3eed;
}
</style>
</head>
<script>
/* laydate.render({
	  elem: '.date' //指定元素
	}); */
</script>
<body>
	<form id="form" name="form" class="form-horizontal" method="post"
		url="${ctx}/themeApply_fq/gotoApply.shtml">
	<section class="panel panel-default">
			<input type="hidden" class="form-control" name="data_matterThemeId" value="${matterThemeId }">
			<input type="hidden" class="form-control" name="data_themeApplyId" value="${themeApplyId }">
			<div class="panel-body">
			
			<!-- 项目信息 -->
			<div class="title">
						项目基本信息
					</div>
			<input type='text' name="dataSet" style="display:none;" data-set="${matterTheme}">
			<table class="detail_table" border="1" style="border:1px;border-spacing: 2px;border-collapse: collapse;border-color:#DBDCDD;">
			<tbody style="border-color: inherit;">
				<tr>
					<td class="top_left_td">
						主题事项名称
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control"  name="matterThemeName" 
						 validate="{required:true}" readonly>
					</td>
					<td class="top_left_td">
						项目名称
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control"  name="name" 
						 validate="{required:true}" readonly>
					</td>
				</tr>
				
				<tr>
					<td class="top_left_td">
						项目代码
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control"  name="matterThemeCode" 
						 validate="{required:true}" readonly>
					</td>
					<td class="top_left_td">
						代办平台(园区)
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control"  name="yuanqu" 
						 validate="{required:true}" readonly>
					</td>
				</tr>
				
				<tr>
					<td class="top_left_td">
						申请单位名称
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control"  name="applicationName" 
						 validate="{required:true}" readonly>
					</td>
					<td class="top_left_td">
						申请单位证件类型
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<select name="applicantDocumentType" style="border-radius:0px;" class="status-valid creatable editable pointer form-control status_selector" validate="{required:true}" readonly>
						<option selected="selected"></option>
						<option value="1" selected>身份证号码</option>
						<option value="2">统一信用代码</option>
					</select>
					</td>
				</tr>
				<tr>
					<td class="top_left_td">
						证件号码
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control"  name="applicationDocumentNumber" 
						 validate="{required:true}" readonly >
					</td>
					<td class="top_left_td">
						联系电话
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control"  name="applicationPhone" 
						 validate="{required:true}" readonly>
					</td>
				</tr>
				<tr>
					<td class="top_left_td">
						邮编
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control"  name="applicationPostCode" 
						 validate="{required:true}" readonly>
					</td>
					<td class="top_left_td">
						通讯地址
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control"  name="applicationAddress" 
						 validate="{required:true}" readonly>
					</td>
				</tr>
				
				<tr>
					<td class="top_left_td">
						法定代表人
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control"  name="legalRepresentative" 
						 validate="{required:true}" readonly>
					</td>
					<td class="top_left_td">
						项目地址
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control" name="themeAddress" 
							 validate="{required:true}" readonly>
					</td>
				</tr>
				
				<tr>
					<td class="top_left_td">
						用地面积（公顷）
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control"  name="yongdi"  readonly
						  >
					</td>
					<td class="top_left_td">
						总建筑面积（万平方米）
					</td>
					<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control" name="zongjianzhu"  readonly
							 >
					</td>
				</tr>
				
				
				<tr>
					<td class="left_td">
						总投资额
					</td>
					<td class="right_td" colspan="3" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control" name="invest" 
						 validate="{required:true,isNumber:true}" style="width:80%;float:left;" readonly >
						 <span colspan=1 style="float:left;line-height:35px;margin-left:10px;">亿元</span>
					</td>
				</tr>
				
				<tr>
					<td class="left_td">
						资金来源
					</td>
					<td class="right_td" colspan="3">
					<input name="data_moneyResource" class="hide">
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
				</tr>
				
				<tr>
					<td class="left_td">
							项目类型
						</td>
					<td class="right_td" colspan="3">
					<input name="data_matterThemeType" class="hide">
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
				
				<tr>
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
				</tr>
				
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
				
				<tr>
					<td class="left_td">
							项目主要建设内容
						</td>
					<td class="right_td" colspan="3">	
						<textarea rows="5" cols="10" name="mainLandContent" style="resize:none;background-color:#eff0f4;border-radius:0px;width:100%;" class="form-control"  validate="{required:true}"  readonly  >${matterTheme.mainLandContent}</textarea>
					</td>
				</tr>
				
				<tr>
					<td class="left_td">
							基础事项配置
						</td>
					<td class="right_td" colspan="3">
						<input type="text" name="matterId" class=" form-control hide">
						<input type="text" name="matterName" titile="" style="width:40%;float:left;border-radius:0px;" class="form-control" readonly>
						<!-- <button type='button' style="float:left;" class="showMatter">展示</button> -->
					</td>
				</tr>
				<tr>
					<td class="left_td">
							项目当前申报阶段
						</td>
					<td class="right_td" colspan="3">
						<input type="text" name="whatNow" titile="" style="width:40%;float:left;border-radius:0px;" class="form-control" readonly>
					</td>
				</tr>
			</tbody>
		</table>
		
		<!-- 项目委托信息 -->
			<div class="title">
						项目委托信息
					</div>
			<table class="xiangmuweituo_table" border="1" style="width:100%;border:1px;border-spacing: 2px;border-collapse: collapse;border-color:#DBDCDD;">
				<tbody style="border-color: inherit;">
					<tr>
						<td class="top_left_td">
							行政区
						</td>
						<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
							<input type="text" class="form-control"  name="xzq" readonly
							 >
						</td>
						<td class="top_left_td">
							代办中心名称
						</td>
						<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
							<input type="text" class="form-control"  name="dbzxName" readonly
							  >
						</td>
					</tr>
					<tr>
						<td class="top_left_td">
							签约时间
						</td>
						<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
							<input type="text" class="form-control date"  name="qyTime"readonly
							 >
						</td>
						<td class="top_left_td">
							协议号
						</td>
						<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
							<input type="text" class="form-control"  name="xieyihao" readonly
							  >
						</td>
					</tr>
					<tr>
						<td class="top_left_td">
							部门
						</td>
						<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
							<input type="text" class="form-control"  name="bumen" readonly
							 >
						</td>
						<td class="top_left_td">
							主要代办人员
						</td>
						<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
							<input type="text" class="form-control"  name="personOne" readonly
							  >
						</td>
					</tr>
					<tr>
						<td class="top_left_td">
							辅助代办人员
						</td>
						<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
							<input type="text" class="form-control"  name="personTwo" readonly
							 >
						</td>
						<td class="top_left_td">
							代办形式
						</td>
						<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
							<input type="text" class="form-control"  name="daibanStyle" readonly
							  >
						</td>
					</tr>
					<tr>
						<td class="top_left_td">
							委托代办起始环节
						</td>
						<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
							<input type="text" class="form-control"  name="weituoStart" readonly
							 >
						</td>
						<td class="top_left_td">
							委托代办结束环节
						</td>
						<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
							<input type="text" class="form-control"  name="weituoEnd" readonly
							  >
						</td>
					</tr>
					
				</tbody>
			</table>
			
			<!-- 委托单位信息 -->
			<div class="title">
						委托单位信息
					</div>
			<table class="weituodanwei_table" border="1" style="width:100%;border:1px;border-spacing: 2px;border-collapse: collapse;border-color:#DBDCDD;">
				<tbody style="border-color: inherit;">
					<tr>
						<tr>
						<td class="left_td">
							单位地址
						</td>
						<td class="right_td" colspan="3" style="padding-left:10px;padding-right:10px;">
							<input type="text" class="form-control  " name="danweiPlace" 
							  style="width:100%;float:left;" readonly >
						</td>
					</tr>
					</tr>
					<tr>
						<td class="top_left_td">
							单位性质
						</td>
						<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
							<input type="text" class="form-control"  name="danweiStyle" readonly
							 >
						</td>
						<td class="top_left_td">
							项目经办人
						</td>
						<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
							<input type="text" class="form-control"  name="projectPerson" readonly
							  >
						</td>
					</tr>
					<tr>
						<td class="top_left_td">
							经办人职务
						</td>
						<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
							<input type="text" class="form-control"  name="personPosition" readonly
							 >
						</td>
						<td class="top_left_td">
							经办人电话
						</td>
						<td class="top_right_td" style="padding-left:10px;padding-right:10px;">
							<input type="text" class="form-control"  name="personPhone" readonly
							  >
						</td>
					</tr>
					<tr>
					<td class="left_td">
						电子邮箱
					</td>
					<td class="right_td" colspan="3" style="padding-left:10px;padding-right:10px;">
						<input type="text" class="form-control  " name="youxiang" readonly
						  style="width:100%;float:left;"  >
					</td>
				</tr>
				</tbody>
			</table>
			
		</div>
		<!-- <footer class="panel-footer text-right bg-light lter">
		<button  class="btn btn-success btn-send btn-s-xs">开始代办</button>
		</footer> </section> -->
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
		var matterThemeId=$('input[name="data_matterThemeId"]').val();
		var themeApplyId=$('input[name="data_themeApplyId"]').val();
		var data = {matterThemeId:matterThemeId,themeApplyId:themeApplyId};
		$.ajax({
			url:rootPath +'/themeApply_fq/loadApplyInfo.shtml',
			type:'post',
			data:data,
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
		$('.xiangmuweituo_table').deSerializeObject(data);
		$('.weituodanwei_table').deSerializeObject(data);
		$('input[name="matterName"]').attr("title",data.matterName);
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
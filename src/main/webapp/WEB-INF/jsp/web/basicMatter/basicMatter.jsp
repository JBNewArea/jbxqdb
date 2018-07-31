<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/web/basicMatter/basicMatter.js"></script>
<script type="text/javascript" src="${ctx}/js/enhance.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.serializeObject.min.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-table/js/bootstrap-table.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-table/locale/bootstrap-table-zh-CN.js"></script>
<link rel="stylesheet" type="text/css"  href="${ctx}/js/bootstrap-table/css/bootstrap-table.css">
<link rel="stylesheet" type="text/css"  href="${ctx}/css/daiban.css">

<style type="text/css">
/* .col-sm-3 {
	width: 25%;
	float: left;
	text-align: right;
}

.col-sm-9 {
	width: 85%;
	float: left;
	text-align: left;
} */

label[class^="btn btn-default"] {
	margin-top: -4px;
}
#basicMatter_table td{
	border:1px solid #dddddd;
}
#basicMatter_table thead{
	background-color:#ccc;
}
.fht-cell{
	display:none;
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
.th-inner {
	color:black!important;
}
#basicMatter_table{
	min-height:400px;
}
</style>
</head>
<body>
	<div class="l_err" style="width: 100%; margin-top: 2px;"></div>
	<section class="panel panel-default">
	<div class="panel-body">
		<form class="search_form col-lg-12 col-md-12 col-sm-12 row" style="margin-bottom:2%;">
			<div class="my-search-group col-lg-12 col-md-12 col-sm-12">
				<div class="col-lg-3 col-md-3 col-sm-3">
					<input type='text' class="form-control" name="transName" placeholder="基础事项名称">
				</div>
				<div class="col-lg-3 col-md-3 col-sm-3">
					<input type='text' class="form-control" name="transBaseCode" placeholder="基础事项编码">
				</div>
				<div class="col-lg-3 col-md-3 col-sm-3">
					<select class="form-control" name="officeId" placeholder="请选择部门">
						<option value="" disabled selected style="display:none;">请选择组织</option>
						<c:forEach var="key" items="${officeList}">
				             <option value="${key.officeId}">${key.officeName}</option>
				       </c:forEach>
					</select>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-3">
					<button class="btn btn-default btn-search pull-right" style="width:53px;height:34px;background-color:#41c97b;" type="button">
						搜索
					</button>
				</div>
			</div>
		</form>
		<form class="col-lg-12 col-sm-12 col-md-12">
			<div id="basicMatter_table"></div>
		</form>
	</div>
	<footer class="panel-footer text-right bg-light lter">
		<button type="submit" class="btn btn-success btn-sure btn-s-xs">确定</button>
	</footer>
	<input name="startMatterIds" style="display:none;" value="${matterIds}">
	<input name="startMatterNames" style="display:none;"value="${matterNames}">
	</section >
	
	<!-- <div class="table-responsive"> -->
		
	<!-- </div> -->


	<!-- <script type="text/javascript">
	onloadurl();
	</script> -->
	<script type="text/javascript"
		src="${ctx}/notebook/notebook_files/bootstrap-filestyle.min.js"></script>
</body>
</html>
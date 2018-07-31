<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/web/hasten/hastenUI.js"></script>
<script type="text/javascript" src="${ctx}/js/enhance.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.serializeObject.min.js"></script>
<style>
	.panel-body{
		min-height:360px;
	}
</style>
</head>
<body>
<div class="l_err" style="width: 100%; margin-top:2%;"></div>
	
	<%-- <form id="form" name="form" class="form-horizontal" method="post"
		url="${ctx}/matterTheme/editEntity.shtml"> --%>
	<section class="panel panel-default">
		<div class="panel-body">
		
			<input type="hidden" class="form-control" name="applyId" value="${applyId}">
			<input type="hidden" class="form-control" name="themeApplyId" value="${themeApplyId}">
			
			<form class="detail_form col-lg-12 col-md-12 col-sm-12 row" style="margin-bottom:2%;display:block;">
				<div class="col-lg-12 col-sm-12 col-md-12  " style="margin-top:2%;width:100%!important;">
					<label class="col-lg-3 col-sm-3 col-md-3 control-label">督办人意见:</label>
					<div class="col-lg-9 col-sm-9 col-md-9">
						<textarea rows="5" cols="10" style="resize:none;" name="hastenIdea" class="form-control hastenIdea " validate="{required:true}" ></textarea>
					</div>
				</div>
				<div class="col-lg-12 col-sm-12 col-md-12  " style="margin-top:2%;">
					<label class="col-lg-3 col-sm-3 col-md-3 control-label">备注:</label>
					<div class="col-lg-9 col-sm-9 col-md-9">
						<textarea rows="5" cols="10" name="remarks" class="form-control remarks " style="resize:none;" validate="{required:true}"></textarea>
					</div>
				</div>
			</form>
			
		</div>
		<footer class="panel-footer text-right bg-light lter">
			<button  class="btn btn-success btn-hasten btn-s-xs">催办</button>
		</footer>
		
		</section>
	<!-- </form> -->
	<script type="text/javascript">
		onloadurl();
		
	</script>
</body>
</html>
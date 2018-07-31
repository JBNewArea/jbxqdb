<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/web/externalInfo/greenLand.js"></script>
<script type="text/javascript" src="${ctx}/js/enhance.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.serializeObject.min.js"></script>
<style>
	.panel-body{
		min-height:400px;
	}
</style>
</head>
<body>
<div class="l_err" style="width: 100%; margin-top:2%;"></div>
	
	<form id="form" name="form" class=" form-horizontal" method="post"
		url="${ctx}/themeApply_fq/apply.shtml">
		<section class="panel panel-default">
			<div class="panel-body">
				<input type="hidden" name="matterThemeId" value="${matterThemeId }">
				<input type="hidden" name="themeApplyId" value="${themeApplyId }">
				<input type="hidden" name="matterId" value="${matterId }">
				
			<div class="col-lg-12 col-sm-12 col-md-12 " style="margin-top:2%">
				<label class="col-lg-3 col-sm-3 col-md-3 control-label">绿地占用面积(㎡):</label>
				<div class="col-lg-9 col-sm-9 col-md-9">
					<input type='text' name="greenLandArea" class="form-control lrunlv" placeholder="绿地占用面积(㎡)"  >
				</div>
			</div>
			<div class="col-lg-12 col-sm-12 col-md-12  " style="margin-top:2%">
				<label class="col-lg-3 col-sm-3 col-md-3 control-label">绿地所在地:</label>
				<div class="col-lg-9 col-sm-9 col-md-9">
					<input type='text' name="greenLandAddress" class="form-control" placeholder="绿地所在地">
				</div>
			</div>
			<div class="col-lg-12 col-sm-12 col-md-12 " style="margin-top:2%">
				<label class="col-lg-3 col-sm-3 col-md-3 control-label">绿地占用期限(天):</label>
				<div class="col-lg-9 col-sm-9 col-md-9">
					<input type='text' name="greenLandOccupyTerm" class="form-control num" placeholder="绿地占用期限(天)" >
				</div>
			</div>
			
		</div>
		<footer class="panel-footer text-right bg-light lter">
			<button type="submit"  class="btn btn-success btn-ok btn-s-xs">填写完毕</button>
		</footer>
		
		</section>
	</form>
	<script type="text/javascript">
		onloadurl();
		
	</script>
</body>
</html>

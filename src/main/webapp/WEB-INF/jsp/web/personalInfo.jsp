<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/web/personalInfo.js"></script>
<script type="text/javascript" src="${ctx}/js/enhance.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.serializeObject.min.js"></script>
<style>
	.panel-body{
		min-height:300px;
	}
</style>
</head>
<body>
<div class="l_err" style="width: 100%; margin-top:2%;"></div>
	
	<%-- <form id="form" name="form" class="form-horizontal" method="post"
		url="${ctx}/matterTheme/editEntity.shtml"> --%>
	<section class="panel panel-default">
			<div class="panel-body">
				<div class="form-group">
					<span class="col-sm-6 col-lg-6 col-md-6 control-label" style="font-weight:bold;">账号:</span>
						<span class="accountName" name="accountName">${user.accountName }</span>
				</div>
				<div class="line line-dashed line-lg pull-in"></div>
				<div class="form-group">
					<span class="col-sm-6 col-lg-6 col-md-6 control-label" style="font-weight:bold;">用户名:</span>
						<span class="userName" name="userName">${user.userName }</span>
				</div>
				<div class="line line-dashed line-lg pull-in"></div>
				<div class="form-group">
					<span class="col-sm-6 col-lg-6 col-md-6 control-label" style="font-weight:bold;">密码:</span>
						<a style="cursor:pointer;" onclick="javascript:updatePasswordLayer();">修改密码</a>
				</div>
			</div>
			<footer class="panel-footer text-right bg-light lter">
				<button type="submit" class="btn btn-success btn-close btn-s-xs">关闭</button>
			</footer> 
		</section>
	<!-- </form> -->
	<script type="text/javascript">
		onloadurl();
		$('.btn-close').on('click',function(){
			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭   
		});
		
	</script>
</body>
</html>
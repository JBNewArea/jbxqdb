<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/web/hasten/hishastenUI.js"></script>
<script type="text/javascript" src="${ctx}/js/enhance.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.serializeObject.min.js"></script>
<style>
	.panel-body{
		min-height:360px;
	}
	.detail_form div{
		margin-bottom:1%;
	}
</style>
</head>
<body>
<div class="l_err" style="width: 100%; margin-top:2%;"></div>
	
	<%-- <form id="form" name="form" class="form-horizontal" method="post"
		url="${ctx}/matterTheme/editEntity.shtml"> --%>
	<section class="panel panel-default">
		<div class="panel-body">
		
			<%-- <input type="hidden" class="form-control" name="hisHastenId" value="${hisHastenId}"> --%>
			
			
			<form class="detail_form col-lg-12 col-md-12 col-sm-12 row" style="margin-bottom:2%;display:block;">
						<div class="col-lg-12 col-sm-12 col-md-12  " >
							<label class="col-lg-3 col-sm-3 col-md-3 control-label">办件编号:</label>
							<div class="col-lg-9 col-sm-9 col-md-9">
								<input  name="officeNumber" class="form-control " readonly value="${hastenInfo.officeNumber}">
							</div>
						</div>
						<div class="col-lg-12 col-sm-12 col-md-12  " >
							<label class="col-lg-3 col-sm-3 col-md-3 control-label">督办人编号:</label>
							<div class="col-lg-9 col-sm-9 col-md-9">
								<input  name="hastenNumber" class="form-control " readonly value="${hastenInfo.hastenNumber}">
							</div>
						</div>
						<div class="col-lg-12 col-sm-12 col-md-12  ">
							<label class="col-lg-3 col-sm-3 col-md-3 control-label">督办人:</label>
							<div class="col-lg-9 col-sm-9 col-md-9">
								<input  name="hastenMan" class="form-control " readonly value="${hastenInfo.hastenMan}">
							</div>
						</div>
						<div class="col-lg-12 col-sm-12 col-md-12  ">
							<label class="col-lg-3 col-sm-3 col-md-3 control-label">督办时间:</label>
							<div class="col-lg-9 col-sm-9 col-md-9">
								<input  name="hastenDate" class="form-control" readonly value="${hastenInfo.hastenDate}">
							</div>
						</div>
						<div class="col-lg-12 col-sm-12 col-md-12  ">
							<label class="col-lg-3 col-sm-3 col-md-3 control-label">督办意见:</label>
							<div class="col-lg-9 col-sm-9 col-md-9">
								<input  name="hastenIdea" class="form-control" readonly value="${hastenInfo.hastenIdea}">
							</div>
						</div>
						<div class="col-lg-12 col-sm-12 col-md-12  ">
							<label class="col-lg-3 col-sm-3 col-md-3 control-label">督办状态:</label>
							<div class="col-lg-9 col-sm-9 col-md-9">
								<input  name="_hastenStatus" class="form-control" readonly value="${hastenInfo._hastenStatus}">
							</div>
						</div>
						<div class="col-lg-12 col-sm-12 col-md-12  ">
							<label class="col-lg-3 col-sm-3 col-md-3 control-label">所属部门:</label>
							<div class="col-lg-9 col-sm-9 col-md-9">
								<input  name="officeName" class="form-control" readonly value="${hastenInfo.officeName}">
							</div>
						</div>
						<div class="col-lg-12 col-sm-12 col-md-12  ">
							<label class="col-lg-3 col-sm-3 col-md-3 control-label">事项名称:</label>
							<div class="col-lg-9 col-sm-9 col-md-9">
								<input  name="transName" class="form-control" readonly value="${hastenInfo.transName}">
							</div>
						</div>
						<div class="col-lg-12 col-sm-12 col-md-12  ">
							<label class="col-lg-3 col-sm-3 col-md-3 control-label">申请人:</label>
							<div class="col-lg-9 col-sm-9 col-md-9">
								<input  name="applicantName" class="form-control" readonly value="${hastenInfo.applicantName}">
							</div>
						</div>
						<div class="col-lg-12 col-sm-12 col-md-12  ">
							<label class="col-lg-3 col-sm-3 col-md-3 control-label">办件状态:</label>
							<div class="col-lg-9 col-sm-9 col-md-9">
								<input  name="_Status" class="form-control" readonly value="${hastenInfo._Status}">
							</div>
						</div>
						<div class="col-lg-12 col-sm-12 col-md-12  ">
							<label class="col-lg-3 col-sm-3 col-md-3 control-label">承诺时间:</label>
							<div class="col-lg-9 col-sm-9 col-md-9">
								<input  name="promiseDay" class="form-control" readonly value="${hastenInfo.promiseDay}">
							</div>
						</div>
						
						
						<div class="col-lg-12 col-sm-12 col-md-12  ">
							<label class="col-lg-3 col-sm-3 col-md-3 control-label">备注:</label>
							<div class="col-lg-9 col-sm-9 col-md-9">
								<textarea rows="5" cols="10" style="resize:none;" name="remarks" class="form-control " readonly value="${hastenInfo.remarks}"></textarea>
							</div>
						</div>
						<div class="col-lg-12 col-sm-12 col-md-12  ">
							<label class="col-lg-3 col-sm-3 col-md-3 control-label">反馈人:</label>
							<div class="col-lg-9 col-sm-9 col-md-9">
								<input  name="updateby" class="form-control" readonly value="${hastenInfo.updateby}">
							</div>
						</div>
						<div class="col-lg-12 col-sm-12 col-md-12  ">
							<label class="col-lg-3 col-sm-3 col-md-3 control-label">反馈时间:</label>
							<div class="col-lg-9 col-sm-9 col-md-9">
								<input  name="hupdateDate" class="form-control" readonly value="${hastenInfo.hupdateDate}">
							</div>
						</div>
			</form>
			
		</div>
		<!-- <footer class="panel-footer text-right bg-light lter">
			<button  class="btn btn-success btn-hasten btn-s-xs">催办</button>
		</footer> -->
		
		</section>
	<!-- </form> -->
	<script type="text/javascript">
		onloadurl();
		
	</script>
</body>
</html>
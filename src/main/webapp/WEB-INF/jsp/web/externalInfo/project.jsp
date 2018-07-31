<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script src="${ctx}/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctx}/js/web/externalInfo/project.js"></script>
<script type="text/javascript" src="${ctx}/js/enhance.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.serializeObject.min.js"></script>
<style>
	
</style>
</head>
<body>
<div class="l_err" style="width: 100%; margin-top:2%;"></div>
	
	<form id="form" name="form" class="form-horizontal"  method="post"
	 url="${ctx}/themeApply_fq/apply.shtml">
		<section class="panel panel-default">
			<div class="panel-body">
				<input type="hidden" name="matterThemeId" value="${matterThemeId }">
				<input type="hidden" name="themeApplyId" value="${themeApplyId }">
				<input type="hidden" name="matterId" value="${matterId }">
				
		
			<div class="col-lg-12 col-sm-12 col-md-12 " style="margin-top:2%">
				<label class="col-lg-3 col-sm-3 col-md-3 control-label">工程名称:</label>
				<div class="col-lg-9 col-sm-9 col-md-9">
					<input type='text' name="gongchengName" class="form-control" placeholder="工程名称" validate="{required:true}" >
				</div>
			</div>
			<div class="col-lg-12 col-sm-12 col-md-12  " style="margin-top:2%">
				<label class="col-lg-3 col-sm-3 col-md-3 control-label">工程建设地点:</label>
				<div class="col-lg-9 col-sm-9 col-md-9">
					<input type='text' name="gongchengAddress" class="form-control" placeholder="工程建设地点" validate="{required:true}">
				</div>
			</div>
			<div class="col-lg-12 col-sm-12 col-md-12 " style="margin-top:2%">
				<label class="col-lg-3 col-sm-3 col-md-3 control-label">建设内容:</label>
				<div class="col-lg-9 col-sm-9 col-md-9">
					<input type='text' name="gongchengCotent" class="form-control" placeholder="建设内容" validate="{required:true}">
				</div>
			</div>
			<div class="col-lg-12 col-sm-12 col-md-12 " style="margin-top:2%">
				<label class="col-lg-3 col-sm-3 col-md-3 control-label">建设规模:</label>
				<div class="col-lg-9 col-sm-9 col-md-9">
					<input type="text" name="gongchengGuiMo" class="form-control" placeholder="建设规模" validate="{required:true}">
				</div>
			</div>
			<div class="col-lg-12 col-sm-12 col-md-12 " style="margin-top:2%">
				<label class="col-lg-3 col-sm-3 col-md-3 control-label">备注:</label>
				<div class="col-lg-9 col-sm-9 col-md-9">
					<input type="text" name="gongchengBeiZhu" class="form-control" placeholder="备注" validate="{required:true}">
				</div>
			</div>
			<div class="col-lg-12 col-sm-12 col-md-12 " style="margin-top:2%">
				<label class="col-lg-3 col-sm-3 col-md-3 control-label">申报建筑面积(㎡):</label>
				<div class="col-lg-9 col-sm-9 col-md-9">
					<input type="text" name="gongchengMianJi" class="form-control lrunlv" placeholder="申报建筑面积(㎡)" >
				</div>
			</div>
			<div class="col-lg-12 col-sm-12 col-md-12 " style="margin-top:2%">
				<label class="col-lg-3 col-sm-3 col-md-3 control-label">工程合同造价(元):</label>
				<div class="col-lg-9 col-sm-9 col-md-9">
					<input type="text" name="gongchengZaoJia" class="form-control lrunlv" placeholder="工程合同造价(元)">
				</div>
			</div>
			<div class="col-lg-12 col-sm-12 col-md-12 " style="margin-top:2%">
				<label class="col-lg-3 col-sm-3 col-md-3 control-label">开工日期:</label>
				<div class="col-lg-9 col-sm-9 col-md-9">
					<!-- <div class='input-group date'>
						<input type='text' name="gongchengKaiGong" class="form-control datepicker  " validate="{required:true}" readonly/>
						<span class="input-group-addon">
						<span class="glyphicon glyphicon-calendar" style="cursor:pointer;"></span>
						</span>
					</div> --> 
					<input type='text' name="gongchengKaiGong" class="form-control date " validate="{required:true}" readonly/>
				</div>
			</div>
			<div class="col-lg-12 col-sm-12 col-md-12 " style="margin-top:2%">
				<label for="gongchengjunGong" class="col-lg-3 col-sm-3 col-md-3 control-label">竣工日期:</label>
				<div class="col-lg-9 col-sm-9 col-md-9">
					<!-- <div class='input-group date'>
						<input type='text' name="gongchengJunGong" class="form-control datepicker  " validate="{required:true}" readonly/>
						<span class="input-group-addon">
						<span class="glyphicon glyphicon-calendar" style="cursor:pointer;"></span>
						</span>
					</div>  -->
					<input type='text' name="gongchengJunGong" class="form-control date " validate="{required:true}" readonly/>
				</div>
			</div>
	
		</div>
		<footer class="panel-footer text-right bg-light lter">
			<button type="submit"  class="btn btn-success btn-ok btn-s-xs">填写完毕</button>
		</footer>
		
		</section>
	</form>
	<!-- </form> -->
	<script type="text/javascript">
		onloadurl();
		laydate.render({
			  elem: '.date' //指定元素
			});
	</script>
</body>
</html>


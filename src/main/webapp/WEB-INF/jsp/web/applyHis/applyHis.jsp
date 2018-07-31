<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/web/applyHis/applyHis.js"></script>
<script type="text/javascript" src="${ctx}/js/enhance.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.serializeObject.min.js"></script>
<style>
	.panel-body{
		min-height:360px;
	}
	.ssl{
		border-collapse: collapse;
	    border: 1px solid #e6e6e6;
	    width: 98%;
	    margin: 4px auto 0;
	}
	.table{
		display:table;
		max-width: 100%;
   	    background-color: transparent;
	}
	.table td{
		border-left:1px solid #f1f1f1!important;
	}
	.table thead{
		background-color:#EAEAEA;
	}
	.modal-dialog{
		left:0%;
	}
	.hide{
		display:none;
	}
</style>
</head>
<body>
<div class="l_err" style="width: 100%; margin-top:2%;"></div>
	
	<%-- <form id="form" name="form" class="form-horizontal" method="post"
		url="${ctx}/matterTheme/editEntity.shtml"> --%>
	<section class="panel panel-default">
		<div class="panel-body">
		
			<input type="hidden" class="form-control" name="matterId" value="${matterId}">
			<input type="hidden" class="form-control" name="applicantDocumentType" value="${applicantDocumentType}">
			<input type="hidden" class="form-control" name="applicationDocumentNumber" value="${applicationDocumentNumber}">
			
			<!-- <form class="detail_form col-lg-12 col-md-12 col-sm-12 row" style="margin-bottom:2%;display:block;">
				
			</form> -->
			<div class="materialDiv">
				<table class="ssl table">
						<thead>
							<tr>
								<th width="10%">编号</th>
								<th width="60%">材料名称</th>
								<th width="30%">材料上传</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var ="key" items="${materialList}" varStatus="i">
		    					<tr>
		    						<td width="10%">
		    							${i.index+1 }
		    						</td>
		    						<td class="materialName" width="60%">
		    							<span class=" materialName"  name="materialName">${key.materialName}</span>
		    						</td>
		    			 			<td class="materialId" width="30%"  data-id="${key.materialId}">
		    							<div class="showupload shangchuan" style="text-align:center;">
		    								<div style="width:50%;float:left;"><a class="btn btn-primary upload" data-id="${key.materialId }" style="margin-left:30px;background-color: #428bca!important;border-color: #428bca;">附件上传</a></div>
		    								<div style="float:left;width:50%;"><a class="btn btn-primary allfile ${key.isShow } allfile_${key.materialId}" data-id="${key.materialId }" style="margin-right:30px;background-color: #428bca!important;border-color: #428bca;">附件管理</a></div>
		    							</div>
		    						</td>
		    					</tr>
		    				</c:forEach>
    					</tbody>
    			</table>
    				
			</div>
			
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				  <form method="post" id="mm" enctype="multipart/form-data">  
				    <div class="modal-dialog">
				        <div class="modal-content">
				            <div class="modal-header">
				                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				                <h4 class="modal-title" id="myModalLabel">文件上传</h4>
				            </div>
				            <div class="l_err" style="width: 100%;"></div>
				            <div class="modal-body">
				              <div class="control-group">
				                 <div class="controls">
				                 	<input type="hidden" class="form-control" name="userType" >
									<input type="hidden" class="form-control" name="userIdCard">
				                 	<input type="hidden" class="form-control" name="materialId">
				                 	<!-- 声明由代办系统上传 -->
				                 	<input type="hidden" class="form-control" name="comeType">
				                 	<input class="input-file uniform_on" id="file" name="file" type="file">
				                 </div>
				                 <div style="margin-top:10px;">
				                 	<a class="result" style="color:red;"></a>
				                 </div>
				             </div>
				            </div>
				            <div class="modal-footer">
				            	<a class="btn btn-primary uploadFile">提交</a>
				            	 <a class="btn btn-default cancle">关闭</a>
				            </div>
				        </div><!-- /.modal-content -->
				    </div><!-- /.modal -->
				</form>
			</div>
			
		</div>
		<!-- <footer class="panel-footer text-right bg-light lter">
			<button  class="btn btn-success btn-hasten btn-s-xs"></button>
		</footer> -->
		
		</section>
	<!-- </form> -->
	<script type="text/javascript">
		onloadurl();
		/* var matterId = $('input[name="matterId"]').val();
		var applicantDocumentType=$('input[name="applicantDocumentType"]').val();
		var applicationDocumentNumber=$('input[name="applicationDocumentNumber"]').val(); */
		
		
		
	</script>
</body>
</html>
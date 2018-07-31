<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/web/upload/showAllfileUI.js"></script>
<script type="text/javascript" src="${ctx }/js/jquery/jquery.form.js">
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
		display:table-cell;
		vertical-align:middle;
	}
	.table tbody tr td{
		display:table-cell;
		vertical-align:middle;
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
			
			<div class="materialDiv">
				<table class="ssl table">
						<thead>
							<tr>
								<th width="10%">编号</th>
								<th width="30%">材料名称</th>
								<th width="20%">上传来源</th>
								<th width="20%">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var ="key" items="${materialGetList}" varStatus="i">
		    					<tr class="tr_${key.id }">
		    						<td  width="10%">
		    							${i.index+1 }
		    						</td>
		    						<td width="30%">
		    							<span>${key.fileName}</span>
		    						</td>
		    						<td width="30%">
		    							<span>${key.remarks }</span>
		    						</td>
		    			 			<td class="createDate" width="30%" >
		    							<div class="showupload shangchuan" style="text-align:center;">
		    								<a class="btn btn-primary Down"  data-id="${key.id }" style="background-color: #428bca!important;border-color: #428bca;">附件下载</a>
		    								<a class="btn btn-danger del" data-id="${key.id }" data-userMaterial="${key.userMaterialid }"
		    								  data_url="http://221.226.86.27:8090/xzsp-interface/a/rpc/realUserMaterial/realUserMaterial/delete?id=${key.id }&userMaterialid=${key.userMaterialid }
		    								   style="background-color: #999!important;border-color:white;">附件删除</a>
		    							</div>
		    						</td>
		    					</tr>
		    				</c:forEach>
    					</tbody>
    			</table>
    				
			</div>
			
		</div>
		<!-- <footer class="panel-footer text-right bg-light lter">
			<button  class="btn btn-success btn-hasten btn-s-xs"></button>
		</footer> -->
		
		</section>
	<!-- </form> -->
	<script type="text/javascript">
		onloadurl();
		
		
	</script>
</body>
</html>
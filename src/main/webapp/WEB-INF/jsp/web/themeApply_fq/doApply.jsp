<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/common.jspf"%>
<script type="text/javascript" src="${ctx}/js/web/themeApply_fq/doApply.js"></script>
<script type="text/javascript" src="${ctx}/js/enhance.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.serializeObject.min.js"></script>
<style>
	.matter_info{
		margin-top:2%;width:100%;
	}
	.eveMatter{
		margin-top:1%;
		height: 56px;
		background: #fafcff;
		border:1px dashed #346ba3;
		margin-left:30px;
	}
	.eveMatter_name{
		font-size: 14px;
		color: #666666;
		line-height: 56px;
		margin-left: -25px;
		cursor:pointer;
	}
	.showMaterial{
		margin-left: 0px;
		margin-top:15px;
		cursor:pointer;
		color:green;
	}
	.num{
		font-size: 24px;
		line-height: 56px;
		color: #53a2f5;
		font-style: italic;
		margin-left:10px;
	}
	
	/*可点击的代办按钮样式*/
	.doApply_usable{
		width: 57px;
		height: 28px;
		background-color: #57a3f2;
		border-radius: 9px;
		outline: none;
		margin-left: 0px;
		margin-top:10px;
		color: white!important;
		border:none;
		float:left;
	}
	/*不可点击的代办按钮样式*/
	.doApply_disable{
		width: 57px;
		height: 28px;
		background-color: white;
		border-radius: 9px;
		outline: none;
		margin-left: 0px;
		margin-top:10px;
		color: black;
		border:none;
		float:left;
		cursor:not-allowed;
	}
	.hasten_show{
		margin-top:15px;
		float:left;
		cursor:pointer;
		color:green;
	}
	.hasten_hide{
		display:none;
		cursor:pointer;
	}
	.Hishasten_show{
		margin-top:15px;
		float:left;
		cursor:pointer;
		color:green;
	}
	.Hishasten_hide{
		display:none;
		cursor:pointer;
	}
	.matterStatus{
		float:left;
		margin-top:15px;
		color:red;
	}
	.hide{
		display:none;
	}
	.panel-body{
		min-height:525px;
	}
	.modal-dialog{
		left:0%;
	}
	.matterStatus{
		cursor:pointer;
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
	.date_show{
		display:block;
	}
	.date_hide{
		display:none;
	}
	.interval{
		margin-top:5px;
		color:blue;
		float:left;
	}
	.intervalOfApply{
		margin-top:5px;
		color:blue;
		float:left;
	}
	.yjclUL{
		list-style-type:none;
	}
</style>
</head>
<body>
<div class="l_err" style="width: 100%; margin-top:2%;"></div>
	
	<%-- <form id="form" name="form" class="form-horizontal" method="post"
		url="${ctx}/matterTheme/editEntity.shtml"> --%>
	<section class="panel panel-default">
		<div class="panel-body">
			<input type="hidden" class="form-control" name="dataSet_id" value="${id }">
			<input type="hidden" class="form-control" name="themeApplyId" value="${themeApplyId }">
			<input type="hidden" class="form-control" name="matterThemeId" value="${matterThemeId }">
			<input type="hidden" class="form-control" name="applicationDocumentNumber" value="${applicationDocumentNumber}">
			<input type="hidden" class="form-control" name="applicantDocumentType" value="${applicantDocumentType}">
			<form class="search_form col-lg-12 col-md-12 col-sm-12 row" style="margin-bottom:2%;display:block;">
				<div class="my-search-group col-lg-12 col-md-12 col-sm-12" style="width:100%!important;">
					<div class="col-lg-3 col-md-3 col-sm-3">
						<input type='text' class="form-control" name="transName" placeholder="基础事项名称">
					</div>
					<!-- <div class="col-lg-3 col-md-3 col-sm-3">
						<input type='text' class="form-control" name="transBaseCode" placeholder="基础事项编码">
					</div> -->
					<div class="col-lg-3 col-md-3 col-sm-3">
						<select class="form-control" name="officeId" placeholder="请选择部门">
							<option value=""  selected>请选择组织</option>
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
			<div>
				<a class="btn btn-primary basicInfo" style="margin-left:30px;" data-id="${themeApplyId }">项目及单位详情</a>
			</div>
			<div class="matter_info col-lg-12 col-md-12 col-sm-12 row " >
				<c:forEach var="key" items="${matterList}" varStatus="i">
		        	<div class="eveMatter " id="${key.matterId}">
			        	<div class="col-lg-12 col-md-12 col-sm-12">
			        		<span style="display:none;"class="dataSet" data-matterId="${key.matterId }"  data-officeId="${key.officeId }"></span>
			        		<span class="num col-lg-1 col-md-1 col-sm-1">${i.index+1}</span>
			        		<span class="eveMatter_name col-lg-5 col-sm-5 col-md-5" data-id="${key.matterId}" data-name="${key.transName}" title="${key.transName}" >${key.transNameSHOW}</span>
		        			<span class="showMaterial col-lg-1 col-md-1 col-sm-1" data-clicked="false" data-id="${key.matterId}">要件管理</span>
		        			<span class="matterStatus col-lg-1 col-md-1 col-sm-1" data-id="${key.applyId}" >${key.matterStatus}</span>
		        			<button type="button" class="${key.doApplyClass} btn btn-default col-lg-3 col-md-3 col-sm-3" id="db_${key.matterId }" data-id="${key.matterId}" data-code="${key.transBaseCode }" >代办</button>
		        			<span class="${key.hastenClass} col-lg-1 col-md-1 col-sm-1" data-id="${key.applyId}">催办</span>
		        			<span class="${key.HishastenClass} col-lg-1 col-md-1 col-sm-1" data-id="${key.hastenId }">历史催办</span>
		        			<span class="${key.createDateClass } interval" date-id="${key.createDate }" date-applyTime="${key.applyTime }"></span>
		        			<span class="${key.createDateClass } intervalOfApply" date-id="${key.createDate }" date-applyTime="${key.applyTime }"></span>
		        		</div>	
	        				<%-- <table>
		        				<c:forEach var ="mat" items="${key.materialList}">
		        					<tr>
		        						<td class="materialName" colspan="2">
		        							<span class=" materialName" name="materialName">${mat.materialName}</span>
		        						</td>
		        			 			<td class="materialId" colspan="2" data-id="${mat.materialId}">
		        							<div class="showupload shangchuan">
		        								<span class="jiahao">+</span><span class="xuanze">选择材料</span>
		        							</div>
		        						</td>
		        					</tr>
		        				</c:forEach>
	        				</table> --%>
		        	</div>
		       	</c:forEach>
			</div>
			
			<!-- modal框，存放历史办件 -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display:none;">
				    <div class="modal-dialog">
				        <div class="modal-content">
				            <div class="modal-header">
				                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				                <h4 class="modal-title" id="myModalLabel">办件详细信息</h4>
				            </div>
				            <div class="l_err" style="width: 100%;"></div>
				            <div class="modal-body">
				              <div class="control-group" style="width:100%;">
					                 <table class="detail_table" border="1" style="border:1px;border-spacing: 2px;border-collapse: collapse;border-color:#DBDCDD;">
					                 	<tbody style="border-color: inherit;">
					                 		<tr>
												<td class="left_td">
													事项名称
												</td>
												<td class="right_td" colspan="3">
													<input type="text" class="form-control" name="transName" 
													placeholder="事项名称" readonly>
												</td>
											</tr>
											<tr>
												<td class="left_td">
													受理人
												</td>
												<td class="right_td" colspan="3">
													<input type="text" class="form-control" name="acceptPerson" 
													placeholder="受理人" readonly>
												</td>
											</tr>
											<tr>
												<td class="left_td">
													办件状态
												</td>
												<td class="right_td" colspan="3">
													<input type="text" class="form-control" name="status" 
													placeholder="办件状态" readonly>
												</td>
											</tr>
											<tr>
												<td class="left_td">
													受理时间
												</td>
												<td class="right_td" colspan="3">
													<input type="text" class="form-control" name="applyTime" 
													placeholder="受理时间" readonly>
												</td>
											</tr>
											<tr>
												<td class="left_td">
													办结时间
												</td>
												<td class="right_td" colspan="3">
													<input type="text" class="form-control" name="finishTime" 
													placeholder="办结时间" readonly>
												</td>
											</tr>
					                 </table>
				             </div>
				            </div>
				            <div class="modal-footer">
				            	 <a class="btn btn-default cancle">关闭</a>
				            </div>
				        </div><!-- /.modal-content -->
				    </div><!-- /.modal -->
			</div>
			
			<!-- modal框，存放事项详情 -->
			<div class="modal fade" id="myModal_matter" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display:none;">
				    <div class="modal-dialog">
				        <div class="modal-content">
				            <div class="modal-header">
				                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				                <h4 class="modal-title" id="myModalLabel">事项详细信息</h4>
				            </div>
				            <div class="l_err" style="width: 100%;"></div>
				            <div class="modal-body">
				              <div class="control-group" style="width:100%;">
					                 <table class="detail_table" border="1" style="border:1px;border-spacing: 2px;border-collapse: collapse;border-color:#DBDCDD;">
					                 	<tbody style="border-color: inherit;">
					                 		<tr>
												<td class="left_td">
													事项名称
												</td>
												<td class="right_td" colspan="3">
													<input type="text" class="form-control" name="transName" 
													placeholder="事项名称" readonly>
												</td>
											</tr>
											<tr>
												<td class="left_td">
													办事人员
												</td>
												<td class="right_td" colspan="3">
													<input type="text" class="form-control" name="acceptPerson" 
													placeholder="办事人员" readonly>
												</td>
											</tr>
											<tr>
												<td class="left_td">
													联系方式
												</td>
												<td class="right_td" colspan="3">
													<input type="text" class="form-control" name="acceptPerson" 
													placeholder="联系方式" readonly>
												</td>
											</tr>
											<tr>
												<td class="left_td">
													受理地点
												</td>
												<td class="right_td" colspan="3">
													<input type="text" class="form-control" name="acceptPerson" 
													placeholder="受理地点" readonly>
												</td>
											</tr>
											<tr>
												<td class="left_td">
													要件材料
												</td>
												<td class="right_td" colspan="3" style="text-align:left!important;">
													<div class=" yjcl" readonly>
													
													</div>
												</td>
											</tr>
					                 </table>
				             </div>
				            </div>
				            <div class="modal-footer">
				            	 <a class="btn btn-default cancle_matter">关闭</a>
				            </div>
				        </div><!-- /.modal-content -->
				    </div><!-- /.modal -->
			</div>
			
		</div>
		<!-- <footer class="panel-footer text-right bg-light lter">
			<button  class="btn btn-success btn-send btn-s-xs">提交</button>
		</footer>  -->
		
		</section>
	<!-- </form> -->
	<script type="text/javascript">
		onloadurl();
		
		

		
	</script>
</body>
</html>
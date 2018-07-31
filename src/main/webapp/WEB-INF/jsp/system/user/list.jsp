<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<style>
	#searchForm input{
	width: 265px;
    height: 32px;
    border: 1px solid rgb(243,243,244);
    text-indent: 1em;
    outline: none;
    font-size:14px;
}
#paging{
	margin-left:10px!important;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/system/user/list.js"></script>
	<div class="m-b-md">
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<div class="form-group">
				<!-- <label class="control-label"> <span
					class="h4 font-thin v-middle">账号:</span></label> -->
					 <input
					class="input-medium ui-autocomplete-input" id="accountName" style="height:35px!important;line-height:1"
					name="userFormMap.accountName" placeholder="账号">
			</div>
			<a href="javascript:void(0)" class="btn btn-default" style="height:35px!important;line-height:1" id="search">查询</a>
			<a href="javascript:grid.exportData('/user/export.shtml')" style="height:35px!important;line-height:1" class="btn btn-info" id="search">导出excel</a>
		</form>
	</div>
	<header class="panel-heading">
	<div class="doc-buttons">
		<c:forEach items="${res}" var="key">
			${key.description}
		</c:forEach>
	</div>
	</header>
	<div class="table-responsive content-tab">
		<div id="paging" class="pagclass"></div>
	</div>
	
	<div class="table-responsive">
		<div id="paging2" class="pagclass"></div>
	</div>

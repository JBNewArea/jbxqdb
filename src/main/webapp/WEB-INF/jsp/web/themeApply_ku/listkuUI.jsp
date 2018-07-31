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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/web/themeApply_ku/listkuUI.js"></script>
	<div class="m-b-md">
		<form class="form-inline" role="form" id="searchForm"
			name="searchForm">
			<!-- <div class="form-group">
				<label class="control-label"> <span
					class="h4 font-thin v-middle">账号:</span></label> <input
					class="input-medium ui-autocomplete-input" id="accountName"
					name="userFormMap.accountName">
			</div> -->
			<div class="form-group">
				<!-- <label class="control-label"> <span
					class="h4 font-thin v-middle">主题事项名称:</span></label> --> 
					<input
					class="input-medium ui-autocomplete-input" id="matterThemeName" style="height:35px!important;"
					name="matterThemeName" placeholder="主题事项名称">
			</div>
			<div class="form-group">
				<!-- <label class="control-label"> <span
					class="h4 font-thin v-middle">项目名称:</span></label> -->
					 <input
					class="input-medium ui-autocomplete-input" style="height:35px!important;" id="name"
					name="name" placeholder="项目名称/代码">
			</div>
			<div class="form-group">
				<!-- <label class="control-label"> <span
					class="h4 font-thin v-middle">代办人:</span></label> -->
					 <input
					class="input-medium ui-autocomplete-input" id="agentName" style="height:35px!important;"
					name="agentName" placeholder="代办人">
			</div>
			
			<a href="javascript:void(0)" class="btn btn-default" style="height:35px!important;line-height:1" id="search">查询</a>
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

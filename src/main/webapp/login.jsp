<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html lang="en"
	class="app">
<%@include file="/common/common.jspf"%>
<head>
<meta charset="utf-8" />
<title>江北新区代办系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="shortcut icon" href="favicon.png" type="image/png" />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/logincss/reset.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/logincss/dly.css">
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/layer-v2.3/layer/layer.js"></script>
</head>
<body  >
	<div class="index">
		<div class="logo">
			<img src="${pageContext.servletContext.contextPath }/css/img/logo.png" alt="">
		</div>
		<div class="title">
			南京江北新区代办系统
		</div>
		<div class="center">
			<div class="dl-bj">
				<div class="dl-ck">
					<div class="dl">
						<div class="dl-nb">
							<form id="loginform" name="loginform" class="form-vertical"
							        action="${pageContext.servletContext.contextPath }/login.shtml" method="post">
								<div class="control-group yhm">
										<span>用户名</span>
										<input type="text" name = "username">
								</div>
								<div class="control-group mm">
										<span>密码</span>
										<input type="password" name = "password">
								</div>
								<div class="jzmm">
										<input type="checkbox">
										<span>记住密码</span>
								</div>
								<div class="form-actions dlan">
										 <button type="submit"
										onclick="javascript:checkUserForm()">登录</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		if ("${error}" != "") {
			layer.msg("${error}");
		};
		function checkUserForm() {
			document.loginform.submit();
		}
		function to_top(){
			if(window != top){
		        top.location.href=location.href;
		    }
		}
	</script>
</body>
</html>
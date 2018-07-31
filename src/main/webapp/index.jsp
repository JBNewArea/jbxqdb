<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html lang="en"
	class="app">
<head>
    
<%@include file="/common/common.jspf"%>
<head>
    <meta charset="utf-8" />
    <title>江北新区代办系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    
    <link rel="stylesheet" href="bootstrapAce/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrapAce/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrapAce/css/ace.min.css">
    <link rel="stylesheet" href="bootstrapAce/css/ace-rtl.min.css">
    <link rel="stylesheet" href="bootstrapAce/css/ace-skins.min.css">
    <link rel="stylesheet" href="bootstrapAce/css/sidebar-menu.css">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/daiban.css">
    <link rel="stylesheet" href="css/calendar.css">
    <link href="css/jquery.circliful.css" rel="stylesheet" type="text/css" />
    <style>
        html,
        body,
        .main-container,
        .main-container-inner,
        .main-content,
        .page-content,
        .col-xs-12,
        .tab-content,
        .tab-pane{
            height: 100%;
        }
        .nav-mini{
            position: fixed!important;
            top: 100px!important;
            left: -280px!important;
        }
        .main-page-gai{
            margin: 0;
        }
        .circle-text{
            color: #eb7a54;
        }
        .layui-layer-btn0{
        	line-height: 1!important;
    		height: 25px!important;
        }
    </style>
    <script>
    </script>
    <!-- <script type="text/javascript" src="bootstrapAce/js/jquery-1.10.2.min.js"></script> -->
    <script type="text/javascript" src="bootstrapAce/js/ace-extra.min.js"></script>
    <script type="text/javascript" src="bootstrapAce/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrapAce/js/ace-extra.min.js"></script>
    <script type="text/javascript" src="bootstrapAce/js/ace.min.js"></script>
    <script type="text/javascript" src="bootstrapAce/js/sidebar-menu.js"></script>
    <script type="text/javascript" src="bootstrapAce/js/bootstrap-tab.js"></script>
    <script type="text/javascript" src="layer-v2.3/layer/layer.js"></script>
    <script type="text/javascript" src="javascript/shijian.js"></script>
    <script type="text/javascript" src="javascript/sideToggleExtended.js"></script>
    <script type="text/javascript" src="javascript/velocity.min.js"></script>
    <script type="text/javascript" src="javascript/jquery.circliful.min.js"></script>
<script type="text/javascript">
	$(function() {
    //修改时间2015年10月13日14:32:57
    //修改在手机上点击菜单后菜单不关闭问题
    //修改人NumberOne
    var winwidth = $("body").width();
    if(winwidth<770){
      $("#nav ul.lt li").click(function(){
        $("#nav").removeClass("nav-off-screen");
     });
    }
    //---------修改人NumberOne完毕----------
		var tb = $("#loadhtml");
		tb.html(CommnUtil.loadingImg());
		//系统初始加载时显示首页欢迎页面
			 tb.load(rootPath+"/welcome_shtml.jsp"); 
		//系统初始化时通过url参数显示固定页面
			/* var firstLi = $("#menu").children(':first');
			var loadNav = firstLi.find('.submenu').children(':first').find('a');
			var str = loadNav.attr("nav-n");
			var loadsn = str.split(",");
			var html = '<li><i class="fa fa-home"></i>';
			html+='<a href="index.shtml">Home</a></li>';
			for(var i=0;i<2;i++){
				html+='<li><a href="javascript:void(0)">'+loadsn[i]+'</a></li>';
			}
			$("#topli").html(html);
			tb.html(CommnUtil.loadingImg());
			tb.load(rootPath+loadsn[2]); */
		
		//给菜单栏加点击链接
		$("[nav-n]").each(function () {
				$(this).bind("click",function(){
						var nav = $(this).attr("nav-n");
						var sn = nav.split(",");
						var html = '<li><i class="fa fa-home"></i>';
						html+='<a href="index.shtml">首页</a></li>';
						for(var i=0;i<2;i++){
							html+='<li><a href="javascript:void(0)">'+sn[i]+'</a></li>';
						}
						$("#topli").html(html);
						var tb = $("#loadhtml");
						tb.html(CommnUtil.loadingImg());
						tb.load(rootPath+sn[2]);
				});
			});
			
			
		//首页的点击链接
		$('.shouye').on('click',function(){
			tb.load(rootPath+"/welcome_shtml.jsp");
		});
		
	});
	
		
	
</script>
    <script type="text/javascript">
        $(function () {
            
          //退出系统
            $('#sideMenu').on('click',function(){
            	 layer.alert('确定要退出系统吗?',{
            			btn:['退出'],
            			yes:function(){
            				//window.location.href=rootPath+"/logout.shtml";
            				custom_close();
            			}
            	}); 
            	
            	
            	
            }); 
            function custom_close() {
                var browserName = navigator.appName;
                var browserVer = parseInt(navigator.appVersion);
                //alert(browserName + " : "+browserVer);

                //document.getElementById("flashContent").innerHTML = "<br>&nbsp;<font face='Arial' color='blue' size='2'><b> You have been logged out of the Game. Please Close Your Browser Window.</b></font>";

                if(browserName == "Microsoft Internet Explorer"){
                    var ie7 = (document.all && !window.opera && window.XMLHttpRequest) ? true : false;
                    if (ie7)
                    {
                        //This method is required to close a window without any prompt for IE7 & greater versions.
                        window.open('','_parent','');
                        window.close();
                    }
                    else
                    {
                        //This method is required to close a window without any prompt for IE6
                        this.focus();
                        self.opener = this;
                        self.close();
                    }
                }else{
                    //For NON-IE Browsers except Firefox which doesnt support Auto Close
                    try{
                        this.focus();
                        self.opener = this;
                        self.close();
                    }
                    catch(e){

                    }

                    try{
                        window.open('','_self','');
                        window.close();
                    }
                    catch(e){

                    }
                }
            }
            
           
    }); 
       

        
        
    </script>

</head>

<body>
<div class="navbar navbar-default navbar-new navbar-gai" id="navbar">
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container container-gai " id="navbar-container">
        <div class="top-title  pull-right">
            <div class="navbar-header pull-right" role="navigation">
                <div class="title">
                    <div class="title-left">
                        <span>欢迎来到江北新区</span>
                        <span>代办系统</span>
                        <span>!</span>
                    </div>
                    <a    id="sideMenu">
                        <img  id="sideMenuClosed" src="dbimg/tc.png"  alt="">
                    </a>
                    </div>
                </div>
            </div><!-- /.navbar-header -->
        </div>
    </div><!-- /.container -->
</div>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>
	
    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <div class="sidebar sidebar-gai" id="sidebar">
            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
            </script><!-- #sidebar-shortcuts -->
            <div class="tx-top">
                <!-- <a href="###">
                    <img id="click" src="dbimg/caidan.png" alt="">
                </a> -->
            </div>
            <div class="tx-center">
                <!-- <div class="tx-center-top">
                        <img src="dbimg/tximg.png" alt="">
                </div> -->
                <div class="tx-center-center">
                    <p>${userFormMap.userName}</p>
                    <p>您好！</p>
                </div>
                <div class="tx-center-bottom personalInfo" data-accountName = "${userFomrMap.accountName }" data-userName = "${userFomrMap.userName }" style="cursor:pointer;">
                    <a href="###">个人信息</a>
                </div>
            </div>


<!-- <nav class="nav-primary hidden-xs"> -->
            <ul class="nav nav-list nav-list-gai" id="menu">
            	<!-- 增加首页的菜单 -->
	            <li class="">
		            <a
						href="javascript:void(0)"
						class="shouye" > <span style="margin-left:100px!important;">首</span><span style="margin-right:80px!important;">页</span>
					</a>
				</li>
            	<c:forEach var="key" items="${list}" varStatus="s">
											<!-- <li class="active"> 某一项展开-->
											<li class="yijicaidanli"><a
												href="javascript:void(0)" class="dropdown-toggle">
												<%-- <c:if
														test="${s.index==0}">
														<i class="fa fa-dashboard icon"> <b class="bg-danger"></b>
														</i>
													</c:if>  <c:if test="${s.index==1}">
														<i class="fa fa-pencil-square icon"> <b
															class="bg-warning"></b>
														</i>
													</c:if> <c:if test="${s.index==2}">
														<i class="fa fa-columns icon"> <b class="bg-primary"></b>
														</i>
													</c:if> <c:if test="${s.index==3}">
														<i class="fa fa-book icon"> <b class="bg-info"></b>
														</i>
													</c:if> <c:if test="${s.index==4}">
														<i class="fa fa-th-list icon"> <b class="bg-success"></b>
														</i>
													</c:if> --%> 
														<i class="fa ${key.icon}  icon" style="width:30px;">
														</i>
													  <span class="menu-text">${key.name}</span><span class="pull-right" style="margin-top:10px;"> <i
														class="fa fa-angle-down menu-text"></i> 
												</span>
											</a>

												<ul class="nav  submenu">
													<c:forEach var="kc" items="${key.children}">
														<li class=""><a
															href="javascript:void(0)"
															class="" nav-n="${key.name},${kc.name},${kc.resUrl}?id=${kc.id}"> <span style="margin-left:50px!important;">${kc.name}</span>
														</a></li>
													</c:forEach>
												</ul></li>
										</c:forEach>
										
            </ul><!-- /.nav-list -->
<!-- </nav>      -->      
            <!-- <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
            </div> -->

            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
            </script>
        </div>

        <div class="main-content main-title main-page">
            <div class="page-content page-gai">
                <div class="col-xs-12 page-title" style="padding-left:5px;">
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active">
                            <div class="content" id="content">
								<section id="id_vbox" class="vbox">
									<ul class="breadcrumb no-border no-radius b-b b-light" id="topli">
									</ul>
									<section class="scrollable" style="margin-top: 35px;">
									<div id="loadhtml"></div>
									</section>
								</section>

                            </div>  
                        </div>
                    </div>
                </div>
            </div><!-- /.page-content -->
        </div><!-- /.main-content -->
    </div><!-- /.main-container-inner -->
</div><!-- /.main-container -->
</body>


<!-- 菜单点击 -->
<script>
   /* $(document).ready(function(){
        $('#li_1').addClass('on');
        $('#li_1').click(function(){
            $('#li_1').addClass('on');
            $('#li_2').removeClass('on');
            $('#li_3').removeClass('on');
        })
        $('#li_2').click(function(){
            $('#li_2').addClass('on');
            $('#li_1').removeClass('on');
            $('#li_3').removeClass('on');
        })
        $('#li_3').click(function(){
            $('#li_3').addClass('on');
            $('#li_2').removeClass('on');
            $('#li_1').removeClass('on');
        })
   }) */
</script>

<!-- 隔行换色 -->
<script>
    /* function SetTableColor() {
      var tbl = document.getElementById("tblMain");
      var trs = tbl.getElementsByTagName("tr");
      for (var i = 0; i < trs.length; i++) {
     var j = i + 1;
     if (j % 2 == 0) { //偶数行
       trs[i].style.background = "#f8f9fb";
     }
     else {
       trs[i].style.background = "#fff";
     }
      }
    } */
</script>


<!-- 菜单伸缩 -->
 <script>
    
    var pagePersonalInfo = null;
    $(function(){
    $('#click').on('click',function(){
        if (!$('.sidebar-gai').hasClass('sidebar-caidan')) {
            $('.sidebar-gai').addClass('sidebar-caidan');
            $('.tx-top').addClass('tx-top-caidan');
            $('.tx-center-center').addClass('tx-yincang');
            $('.tx-center-bottom').addClass('tx-yincang');
            $('.tx-center-top').addClass('tx-center-top-gai');
            $('.menu-text').addClass('menu-txet-gai');
            $('.a-text').addClass('a-text-gai');
            $('.main-page').addClass('main-page-caidan');
            
        }else{
            $('.sidebar-gai').removeClass('sidebar-caidan');
            $('.tx-top').removeClass('tx-top-caidan');
            $('.tx-center-center').removeClass('tx-yincang');
            $('.tx-center-bottom').removeClass('tx-yincang');
            $('.tx-center-top').removeClass('tx-center-top-gai');
            $('.menu-text').removeClass('menu-txet-gai');
            $('.a-text').removeClass('a-text-gai');
            $('.main-page').removeClass('main-page-caidan');
        }
    });
    
    //个人信息 点击展示
    $('.personalInfo').on('click',function(){
    	var accountName = $(this).attr("data-accountName");
    	var userName = $(this).attr("data-userName");
    	openPersonalInfo(userName,accountName);
    });
    
    function openPersonalInfo(userName,accountName){
    	//加载层
     	var index1 = layer.load(0, {shade: false}); //0代表加载的风格，支持0-2
    	//iframe层-禁滚动条
    	layer.open({
    	    type: 2,
    	    title:'个人信息中心',
    	    area: ['700px', '400px'],
    	    skin: 'layui-layer-rim', //加上边框
    	    content: [rootPath+'/user/personalInfo.shtml', 'no']
    	});
    	//关闭加载效果
    	layer.close(index1);
    }
    
});
</script>
</html>
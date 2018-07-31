<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- <div class="col-md-12">
		<div class="alert alert-warning alert-block">
		<table>
		<tr>
		<td align="center" colspan="2"><h1>江北新区代办系统</h1></td>
		</tr>
		<tr>
		<td style="width:80%;">
			首页正在开发，敬请期待....
		</td>
		<td style="width: 20%;"><div
				style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; PADDING-TOP: 0px; WIDTH: 100%; HEIGHT: 148px; border: 1px solid #cacaca; background: #FFFFFF">
				<div
					style="WIDTH: 100%; clear: both; height: 31px; background-image: url(http://www.tianqi.com/static/images/code/bg_13.jpg); background-repeat: repeat-x; border-bottom: 1px solid #cacaca;">
					<div
						style="float: left; height: 31px; color: #9e0905; font-weight: bold; line-height: 31px; margin-left: 20px; font-size: 14px;">城市天气预报</div>

				</div>
				<iframe width="400" scrolling="no" height="120" frameborder="0"
					allowtransparency="true"
					src="http://i.tianqi.com/index.php?c=code&id=19&bgc=%23FFFFFF&bdc=%23&icon=1&temp=1&num=2"></iframe>
			</div></td>
		</tr>
		</table>
		</div>
	</div> -->

<%@include file="/common/common.jspf"%>
<script src="${pageContext.request.contextPath}/echarts/esl/esl.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/echarts/echarts-all.js"
	type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/welcome.js"></script>
<style>
	.index{
	    width: 100%;
	    height:100%;
	 	overflow-y: scroll;
	}
	.index-tongzhi {
		width: 100%;
		overflow: hidden;
		background: white;
		padding-bottom: 40px;
	}
	.tongzhi-left {
	    width: 40%;
	    overflow: hidden;
	    float: left;
	}
	.tongzhi-right {
	    width: 60%;
	    height: 350px;
	    float: left;
	    margin-top: 2%;
	}
	.left-neirong {
	    width: 90%;
	    margin: 5% 0 0 5%;
	    overflow: hidden;
	    border-right: 1px solid #f4f4f4;
	    padding-right: 5%;
	}
	.neirong-top {
	    width: 100%;
	    border-bottom: 1px solid #f4f4f4;
	    padding-bottom: 3%;
	    overflow: hidden;
	}
	.neirong-xuanxiang {
	    width: 100%;
	    margin-top: 3%;
	    overflow: hidden;
	}
	.tongzhi-top {
	    width: 95%;
	    overflow: hidden;
	}
	.tongzhi-title {
	    float: left;
	    font-size: 16px;
	}
	.tongzhi-nian {
	    float: right;
	}	
	.jcsx {
	    width: 45%;
	    background: #66b7f0;
	    border-radius: 10px;
	    float: left;
	    overflow: hidden;
	    height: 100px;
	}
	.xx-shuoming {
	    float: left;
	    width: 80%;
	    margin: 30px 0 0 15%;
	}
	.xx-shuoming p:nth-child(1) {
	    font-size: 36px;
	    font-weight: bold;
	    color: white;
	    padding: 0;
	    line-height: 27px;
	}
	.xx-shuoming p:nth-child(2) {
	    font-size: 14px;
	    font-weight: bold;
	    color: #ffffff;
	    line-height: 10px;
	}
	.zbxm {
	    width: 45%;
	    background: #fcb945;
	    border-radius: 10px;
	    float: left;
	    overflow: hidden;
	    height: 100px;
	    margin-left:5%;
	}
	.ywj {
	    width: 45%;
	    background: #a4c55f;
	    border-radius: 10px;
	    float: left;
	    overflow: hidden;
	    height: 100px;
	    margin-top: 5%;
	}
	.tze{
		width: 45%;
	    background: #45fcc1;
	    border-radius: 10px;
	    float: left;
	    overflow: hidden;
	    height: 100px;
	    margin-top: 5%;
	    margin-left:5%;
	}


.index-bottom {
    width: 100%;
    height: 500px;
    margin-top: 25px;
    overflow: hidden;
}
.circle-chart-list {
	list-style-type:none;
    padding-bottom: 10px;
    margin-left:0px;
}
.circle-chart-list li>h1 {
    margin: 21px 0px 0 21px;
}

.title_tj {
    height: 18px;
    line-height: 18px;
    font-size: 18px;
    font-weight: bold;
    color: #4178be;
    padding-left: 15px;
    border-left:5px solid #4178be;
}
.circle-chart-list li>div {
    width: 386px;
    height: 400px;
    margin-top: 12px;
}
.circle-chart-list li {
    float: left;
    margin: 0 21px 20px 0;
    width: 32%;
    height: 470px;
    background-color: white;
}
.mr0{
	margin-right:0!important;
}

</style>

	<div class="index">
		<div class="index-tongzhi">
			<div class="tongzhi-left">
				<div class="left-neirong">
					<div class="neirong-left">
					
					</div>
					<div class="neirong-xuanxiang">
						<!-- 基础事项 -->
						<div class="jcsx">
							<a href="javascript:void(0);" data-url="">
								<span>
									<img>
								</span>
								<div class="xx-shuoming">
									<p id="count_dwsp">${jichu}</p>
									<p>基础事项</p>
								</div>
							</a>
						</div>
						<!-- 主题项目 -->
						<!-- <div class="ztxm">
							<a href="javascript:void(0);" data-url="">
								<span>
									<img>
								</span>
								<div class="xx-shuoming">
									<p id="count_dwsp">6</p>
									<p>主题项目</p>
								</div>
							</a>
						</div> -->
						<!-- 在办项目 -->
						<div class="zbxm">
							<a href="javascript:void(0);" data-url="">
								<span>
									<img>
								</span>
								<div class="xx-shuoming">
									<p id="count_dwsp">${zaiban }</p>
									<p>在办项目</p>
								</div>
							</a>
						</div>
						<!-- 已完结 -->
						<div class="ywj">
							<a href="javascript:void(0);" data-url="">
								<span>
									<img>
								</span>
								<div class="xx-shuoming">
									<p id="count_dwsp">${banjie}</p>
									<p>已办结</p>
								</div>
							</a>
						</div>
						<!-- 投资额 -->
						<div class="tze">
							<a href="javascript:void(0);" data-url="">
								<span>
									<img>
								</span>
								<div class="xx-shuoming">
									<p id="count_dwsp">${money }</p>
									<p>总投资额(亿元)</p>
								</div>
							</a>
						</div>
						<!-- zdxm -->
						<!-- <div class="zdxm">
							<a href="javascript:void(0);" data-url="">
								<span>
									<img>
								</span>
								<div class="xx-shuoming">
									<p id="count_dwsp">2</p>
									<p>重大项目</p>
								</div>
							</a>
						</div> -->
					</div>
				
				</div>
			</div>
			<div class="tongzhi-right">
				<div class="tongzhi-top">
					<div class="tongzhi-title">
						代办项目统计
					</div>
					<div class="tongzhi-nian">
						<select id="pingtaiSelect">
							<option value="">---代办平台---</option>
							<c:forEach var="key" items="${pingtaiList}" varStatus="s">
								<option value="${key.id}">${key.name} </option>
							</c:forEach>
						</select>
						<select id="yearSelect" >
							<option value="">--按年份--</option>
							<option selected>2018</option>
							<option>2017</option>
							<option>2016</option>
						</select>
					</div>
				</div>
				<div class="zhexian" id="zhexian" style="height:350px;">
					
				</div>
			
			</div>
		</div>
		<div class="index-bottom">
			<div style="margin-left:60px;">
				<select id="yearEcharts">
					<option selected>2018</option>
					<option>2017</option>
					<option>2016</option>
				</select>
				<!-- <select id="typeEcharts">
					<option value="0">按项目数量</option>
					<option value="1">按项目金额</option>
				</select> -->
				<button id="changeYearOfEcharts">切换</button>
			</div>
			<ul class="circle-chart-list clearfix">
				<li>
					<h1 class="title_tj">土地性质（项）</h1>
					<div class="circle-chart1" id="circle-chart1">
					
					</div>
				</li>
				<li>
					<h1 class="title_tj">代办项目类型（项）</h1>
					<div class="circle-chart2" id="circle-chart2">
					
					</div>
				</li>
				<li class="mr0">
					<h1 class="title_tj">代办项目资金来源（项）</h1>
					<div class="circle-chart3" id="circle-chart3">
					
					</div>
				</li>
				<!-- <li>
					<h1 class="title_tj">代办项目土地来源（项）</h1>
					<div class="circle-chart4" id="circle-chart4">
					
					</div>
				</li>
				<li>
					<h1 class="title_tj">代办重大项目（项）</h1>
					<div class="circle-chart5" id="circle-chart5">
					
					</div>
				</li> -->
			</ul>
		</div>
	</div>

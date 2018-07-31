$(function() {
	// <!--Step:1 为ECharts准备一个具备大小（宽高）的Dom-->
	// Step:3 echarts & zrender as a Global Interface by the echarts-plain.js.
	// Step:3 echarts和zrender被echarts-plain.js写入为全局接口
//	onloadurl();
	var myChart = echarts.init(document.getElementById('zhexian'));
//	var now = new Date();
//	var res = [];
//	var len = 20;
//	while (len--) {
//		var time = now.toLocaleTimeString().replace(/^\D*/, '');
//		time = time.substr(time.indexOf(":") + 1);
//		res.unshift(time);
//		now = new Date(now - 1000);
//	}
	
	initzhexian();
	$('#pingtaiSelect').change(initzhexian);
	$('#yearSelect').change(initzhexian);
	
	function initzhexian(){
		var year = $("#yearSelect").val();
		var pingtai = $("#pingtaiSelect").val();
		var data = {"year":year,"pingtai":pingtai};
		$.ajax({
			url:rootPath+'/tongji/zhexian.shtml',
			type:'post',
			data:data,
			dataType:'json',
			success:function(res){
				var banjie = res.banjie;
				var daiban = res.daiban;
//				var data_banjie = [banjie.january,banjie.february,banjie.march,banjie.april,banjie.may,banjie.june,banjie.july,
//				                   banjie.august,banjie.september,banjie.october,banjie.november,banjie.december];
//				var data_daiban = [daiban.january,daiban.february,daiban.march,daiban.april,daiban.may,daiban.june,daiban.july,
//				                   daiban.august,daiban.september,daiban.october,daiban.november,daiban.december];
				/*var data_banjie = [banjie.january,banjie.february,banjie.march,banjie.april,banjie.may];
				var data_daiban = [daiban.january,daiban.february,daiban.march,daiban.april,daiban.may];*/
				var data_banjie = res.banjie;
				var data_daiban = res.daiban;
				var temp = data_banjie[0];
				var temp2 = data_daiban[0];
				for(var i=0;i<data_banjie.length;i++){
					if(data_banjie[i]>temp){
						temp = data_banjie[i];
					}
				}
				for(var i=0;i<data_daiban.length;i++){
					if(data_daiban[i]>temp2){
						temp2 = data_daiban[i];
					}
				}
				if(temp2>temp){
					temp=temp2;
				}
				
				option = {
						tooltip : {
							trigger: 'axis',
							axisPointer : { // 坐标轴指示器，坐标轴触发有效
							type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
							}
						},
						toolbox: {
							show : true,
							feature : {
							mark : {show: true},
							dataView : {show: true, readOnly: false},
							magicType : {show: true, type: ['line', 'bar']},
							restore : {show: true},
							saveAsImage : {show: true}
							}
							},
							calculable : true,
						legend : {
							data : [  '代办项目数', '办结项目数' ]
						},
						grid : {
							x : 40,
							y : 30,
							x2 : 10,
							y2 : 35,
							borderWidth : 0,
							borderColor : "#FFFFFF"
						},
						xAxis : [ {
							axisLabel : {
								rotate : 40,
							},
							type : 'category',// 坐标轴类型，横轴默认为类目型'category'，纵轴默认为数值型'value'
							data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月',]
						} ],
						yAxis : [ {
							min : 0,
							max : temp<1?1:temp,
							axisLabel : {
								formatter : '{value}'
							}
						} ],
						series : [
								{
									name : '代办项目数',
									type : 'line',
									data : data_daiban,
								},
								{
									name : '办结项目数',
									type : 'line',
									data : data_banjie,
								} ]
					};
					myChart.setOption(option);
			}
		});
	}
	
	
	 	var echart1 = echarts.init(document.getElementById("circle-chart1"));
	    var echart2 = echarts.init(document.getElementById("circle-chart2"));
	    var echart3 = echarts.init(document.getElementById("circle-chart3"));
//	    var echart4 = echarts.init(document.getElementById("circle-chart4"));
//	    var echart5 = echarts.init(document.getElementById("circle-chart5"));
	
	initecharts();
	
	$('#changeYearOfEcharts').on('click',function(){
		initecharts();
	});
	    
	    
	function initecharts(){
		var echart1 = echarts.init(document.getElementById("circle-chart1"));
	    var echart2 = echarts.init(document.getElementById("circle-chart2"));
	    var echart3 = echarts.init(document.getElementById("circle-chart3"));
		var year = $('#yearEcharts').val();
//		var type = $('#typeEcharts').val();//0指按数量，1指金额
		var data={"year":year};
		$.ajax({
			url:rootPath+'/tongji/echarts.shtml',
			type:'post',
			data:data,
			dataType:'json',
			success:function(res){
				var echartslandCharac = [];
				var echartsmatterThemeType = [];
				var echartsmoneyResource = [];
				var echartslandCharac_name = [];
				var echartsmatterThemeType_name = [];
				var echartsmoneyResource_name = [];
				 echartslandCharac = res.echartslandCharac;
				 echartsmatterThemeType = res.echartsmatterThemeType;
				 echartsmoneyResource = res.echartsmoneyResource;
				 echartslandCharac_name = res.echartslandCharac_name;
				 echartsmatterThemeType_name = res.echartsmatterThemeType_name;
				 echartsmoneyResource_name = res.echartsmoneyResource_name;
				//土地性质
				var data1 = echartslandCharac;
				var data1_name = echartslandCharac_name;
				    var option1 =  {  
//				        title : {  
//				            text: '土地性质',  
//				            x:"center"  
//				        },  
				        tooltip : {  
				            trigger: 'item',  
				            formatter: "{a} <br/>{b} : {c} ({d}%)"  
				        },  
				        legend: {  
				            orient: 'horizontal',  
				            x:"center",  
				            y:"bottom",  
				            data: data1_name  
				        },  
				        series : [  
				            {  
				                name: '土地性质(项)',  
				                type: 'pie',  
				                radius : ['40%','60%'],  
				                center: ['50%', '40%'],  
				                data:data1,  
				                itemStyle: {  
				                    emphasis: {  
				                        shadowBlur: 10,  
				                        shadowOffsetX: 0,  
				                        shadowColor: 'rgba(0, 0, 0, 0.5)'  
				                    }  
				                }  
				            }  
				        ]  
				    };  
				    echart1.clear();
				    echart1.setOption(option1,true);

				//代办项目类型
				var data2 = echartsmatterThemeType;
				var data2_name = echartsmatterThemeType_name;
				    
				    var option2 =  {  
				        tooltip : {  
				            trigger: 'item',  
				            formatter: "{a} <br/>{b} : {c} ({d}%)"  
				        },  
				                  
				        legend: {  
				            orient: 'horizontal',  
				            x:"center",  
				            y:"bottom",  
				            data: data2_name  
				        },  
				        series : [  
				            {  
				                name: '代办项目类型',  
				                type: 'pie',  
				                radius : ['40%','60%'],  
				                center: ['50%', '40%'],  
				                data:data2,  
				                itemStyle: {  
				                    emphasis: {  
				                        shadowBlur: 10,  
				                        shadowOffsetX: 0,  
				                        shadowColor: 'rgba(0, 0, 0, 0.5)'  
				                    }  
				                }  
				            }  
				        ]  
				    };  
				    echart2.clear();
				    echart2.setOption(option2,true);
					
				//代办项目资金来源
				var data3 = echartsmoneyResource;
				var data3_name = echartsmoneyResource_name;
				    
				var option3 = {  
				        tooltip : {  
				            trigger: 'item',  
				            formatter: "{a} <br/>{b} : {c} ({d}%)"  
				        },  
				                  
				        legend: {  
				            orient: 'horizontal',  
				            x:"center",  
				            y:"bottom",  
				            data: data3_name 
				        },  
				        series : [  
				            {  
				                name: '资金来源(项)',  
				                type: 'pie',  
				                radius : ['40%','60%'],  
				                center: ['50%', '40%'],  
				                data:data3,  
				                itemStyle: {  
				                    emphasis: {  
				                        shadowBlur: 10,  
				                        shadowOffsetX: 0,  
				                        shadowColor: 'rgba(0, 0, 0, 0.5)'  
				                    }  
				                }  
				            }  
				        ]  
				    };
				echart3.clear();
				echart3.setOption(option3,true);
			}
		});
		
		
		
	}

	
   

});
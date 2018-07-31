var pageHasten = null;
var pageHishasten = null;
var pageupload = null;
var pagebaseInfo_themeApply = null;
var pageforest = null;
var pageproject = null;
function disDBBtn(data){
	var _this = $('#db_'+data);
	_this.removeClass("doApply_usable");
	_this.addClass("doApply_disable");
	_this.attr("disabled",true);
}
function closepageproject(){
	layer.close(pageproject);
}
function closepageforest(){
	layer.close(pageforest);
}

//var t3="2017-08-18 04:56:38";
//timeFn(t3);
$(function(){
	//计算当前时间和某一个时间点的时间差，，注意格式
	function timeFn(time) {//di作为一个变量传进来
	    //如果时间格式是正确的，那下面这一步转化时间格式就可以不用了
//	    var dateBegin = new Date(d1.replace(/-/g, "/"));//将-转化为/，使用new Date
	    var dateEnd = new Date();//获取当前时间
//	    var dateDiff = dateEnd.getTime() - dateBegin.getTime();//时间差的毫秒数
		var dateDiff = dateEnd.getTime() - time;//时间差的毫秒数
	    var dayDiff = Math.floor(dateDiff / (24 * 3600 * 1000));//计算出相差天数
	    var leave1=dateDiff%(24*3600*1000)    //计算天数后剩余的毫秒数
	    var hours=Math.floor(leave1/(3600*1000))//计算出小时数
	    //计算相差分钟数
	    var leave2=leave1%(3600*1000)    //计算小时数后剩余的毫秒数
	    var minutes=Math.floor(leave2/(60*1000))//计算相差分钟数
	    //计算相差秒数
	    var leave3=leave2%(60*1000)      //计算分钟数后剩余的毫秒数
	    var seconds=Math.round(leave3/1000)
	    console.log(" 相差 "+dayDiff+"天 "+hours+"小时 "+minutes+" 分钟"+seconds+" 秒")
	    console.log(dateDiff+"时间差的毫秒数",dayDiff+"计算出相差天数",leave1+"计算天数后剩余的毫秒数"
	        ,hours+"计算出小时数",minutes+"计算相差分钟数",seconds+"计算相差秒数");
	    return dayDiff+"天 "+hours+"小时 "+minutes+" 分钟"+seconds+" 秒";
	}
	//计时
		function jishi(){
			$('.matter_info').find('.interval.date_show').each(function(){
				var t = $(this).attr("date-id");
				var applyTime = $(this).attr("date-applyTime");
				
				var timeStr = timeFn(t);
				var applyTimeStr = timeFn(applyTime);
				
				$(this).html("代办时长 : "+timeStr);
			});
			$('.matter_info').find('.intervalOfApply.date_show').each(function(){
				var t = $(this).attr("date-applyTime");
				
				var timeStr = timeFn(t);
				$(this).html("受理时长 : "+timeStr);
			});
		}
	//定时器
		window.setInterval(jishi,1000);
//		window.setInterval("jishi();",1000);
	
		//点击代办按钮去办理
		$('.doApply_usable').on('click',function(){
			var _this = $(this);
			var clicked = _this.parent().find('.showMaterial').attr("data-clicked");
			if(clicked == "false"){
				layer.msg('此次操作没有添加材料，请添加');
				return;
			}
			var matterThemeId=$('input[name="matterThemeId"]').val();
			var themeApplyId=$('input[name="themeApplyId"]').val();
			var matterId = $(this).attr("data-id");
			var code = $(this).attr("data-code");
			var data = {matterThemeId:matterThemeId,themeApplyId:themeApplyId,matterId:matterId};
			//对事项编码进行判断，施工等等事项有单独的表单需要填写
			//判断是否是建筑施工许可 需要填写个性化数据
			if("0100157000-1"==code){//建筑施工
				pageproject = layer.open({
					title : "个性化信息填写",
					type : 2,
					area : [ "1000px", "90%" ],
					content : rootPath + '/external/externalProjectUI.shtml?matterId='+matterId+'&matterThemeId='+matterThemeId
				 					+'&themeApplyId='+themeApplyId,
				});
			}else if("0100451003-1"==code||"0100451004-1"==code||"0100451001-1"==code||"0100451002-1"==code){
				pageforest = layer.open({
					title : "个性化信息填写",
					type : 2,
					area : [ "1000px", "90%" ],
					content : rootPath + '/external/externalForestUI.shtml?matterId='+matterId+'&matterThemeId='+matterThemeId
					 				+'&themeApplyId='+themeApplyId,
				});
			}
			
			else if("0100169001-1"==code){//临时占用城市绿地审批
				pagegreenLand = layer.open({
					title : "个性化信息填写",
					type : 2,
					area : [ "1000px", "90%" ],
					content : rootPath + '/external/externalGreenLandUI.shtml?matterId='+matterId+'&matterThemeId='+matterThemeId
					 				+'&themeApplyId='+themeApplyId,
				});
			}else if("0100169002-1"==code){//砍伐城市树木、迁移古树名木审批---
				pagetree = layer.open({
					title : "个性化信息填写",
					type : 2,
					area : [ "1000px", "90%" ],
					content : rootPath + '/external/externalTreeUI.shtml?matterId='+matterId+'&matterThemeId='+matterThemeId
					 				+'&themeApplyId='+themeApplyId,
				});
			}else if("0100166001-1"==code){//占用、挖掘城市道路审批----
				pageroad = layer.open({
					title : "个性化信息填写",
					type : 2,
					area : [ "1000px", "90%" ],
					content : rootPath + '/external/externalRoadUI.shtml?matterId='+matterId+'&matterThemeId='+matterThemeId
					 				+'&themeApplyId='+themeApplyId,
				});
			}
			
			else{
				$.ajax({
					url:rootPath +'/themeApply_fq/apply.shtml',
					type:'post',
					data:data,
					dataType:'json',
					success:function(res){
						if (res == 'true') {
							_this.removeClass("doApply_usable");
							_this.addClass("doApply_disable");
							_this.attr("disabled",true);
//							layer.confirm('代办发起成功!是否关闭窗口?',function(index) {
//								parent.grid.loadData();
////								parent.layer.close(parent.pageii);
//								layer.close(index);
//								var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
//								parent.layer.close(index);
//							});
							 layer.confirm('代办发起成功!继续办理?',{
						            btn:['继续','取消']
						        },function(index){
						                layer.close(index);
						        },function(){
						        	parent.grid.loadData();
//									parent.layer.close(parent.pageii);
									layer.close(index);
									var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
									parent.layer.close(index);
						        })
						} else {
							layer.alert('发起代办失败！请联系管理员');
						}
					}
				});
			}
		});
		
		
		
		//根据搜索条件加载dom 注:不重新发送请求到后台,前台过滤
		$('.btn-search').on('click',function(){
			var transNamefilter = $('input[name="transName"]').val();
			var officeIdfilter = $('select[name="officeId"] option:selected').val();
			var matterThemeId=$('input[name="matterThemeId"]').val();
			var themeApplyId=$('input[name="themeApplyId"]').val();
			var applicantDocumentType=$('input[name="applicantDocumentType"]').val();
			var applicationDocumentNumber=$('input[name="applicationDocumentNumber"]').val();
			
			var transNamelist = [];
			var officeIdlist = [];
			$('.eveMatter_name').each(function(){
				 transNamelist.push($(this).attr("data-name"));
			});
			$('.dataSet').each(function(){
				officeIdlist.push($(this).attr("data-officeId"));
			});
			console.log(transNamelist);
			$('.eveMatter').each(function(){
				var _this = $(this);
				_this.addClass("hide");
				if(
						_this.find('.dataSet').attr("data-officeId").indexOf(officeIdfilter) > -1
							&&
						_this.find('.eveMatter_name').attr("data-name").indexOf(transNamefilter) > -1
				){
					_this.removeClass("hide");
				}
			});
		});
		
		
		//添加材料
		$('.showMaterial').on('click',function(){
			$(this).attr("data-clicked","true");
			var matterId = $(this).attr("data-id");
			var applicantDocumentType=$('input[name="applicantDocumentType"]').val();
			var applicationDocumentNumber=$('input[name="applicationDocumentNumber"]').val();
			pageupload = layer.open({
				title : "上传事项材料",
				type : 2,
				area : [ "1000px", "90%" ],
				content : rootPath + '/upload/uploadUI.shtml?matterId='+matterId+'&applicantDocumentType='+applicantDocumentType
									+'&applicationDocumentNumber='+applicationDocumentNumber,
			});
			
		});
		
		//催办
		$('.hasten_show').on('click',function(){
			var applyId = $(this).attr("data-id");
			var themeApplyId = $('input[name="themeApplyId"]').val();
			pageHasten = layer.open({
				title : "催办",
				type : 2,
				area : [ "800px", "90%" ],
				content : rootPath + '/hasten/hastenUI.shtml?applyId='+applyId+'&themeApplyId='+themeApplyId,
			});
		});
		
		//查看催办历史信息
		$('.Hishasten_show').on('click',function(){
			var hastenId = $(this).attr("data-id");
			pageHishasten = layer.open({
				title : "催办反馈信息",
				type : 2,
				area : [ "800px", "90%" ],
				content : rootPath + '/hasten/hishastenUI.shtml?hastenId='+hastenId,
			});
		});
		
		//查看办件的详情
		$('.basicInfo').on('click',function(){
			var matterThemeId=$('input[name="matterThemeId"]').val();
			var themeApplyId=$('input[name="themeApplyId"]').val();
			pagebaseInfo_themeApply = layer.open({
				title : "申请单位及项目基本信息",
				type : 2,
				area : [ "1200px", "90%" ],
				content : rootPath + '/themeApply_fq/basicInfoOfUI.shtml?matterThemeId='+matterThemeId+'&themeApplyId='+themeApplyId,//代办操作中的基础信息链接
			});
			
		});
		
		//给办件状态添加 办件当前信息和时间展示的按钮点击时间
		$('.matterStatus').on('click',function(){
			var applyId = $(this).attr("data-id");
			var applicantDocumentType=$('input[name="applicantDocumentType"]').val();
			var applicationDocumentNumber=$('input[name="applicationDocumentNumber"]').val();
			var data={"applyId":applyId,"applicantDocumentType":applicantDocumentType,"applicationDocumentNumber":applicationDocumentNumber};
			$.ajax({
				url:rootPath +'/themeApply_fq/applyDetail.shtml',
				type:'post',
				data:data,
				dataType:'json',
				success:function(res){
					console.log(res);
					//清空上次打开模态框留下的无用数据
					$('#myModal').find('.transName').val('');
					$('#myModal').find('.acceptPerson').val('');
					$('#myModal').find('.status').val('');
					$('#myModal').find('.applyTime').val('');
					$('#myModal').find('.finishTime').val('');
					$('#mm').find(".l_err").css('display', 'none');
					$('#myModal').modal('show');
					$('#myModal').find('input[name="transName"]').val(res.transName);
					$('#myModal').find('input[name="acceptPerson"]').val(res.acceptPerson);
					$('#myModal').find('input[name="status"]').val(res.status);
					$('#myModal').find('input[name="applyTime"]').val(res.applyTime);
					$('#myModal').find('input[name="finishTime"]').val(res.finishTime);
				}
			});
			
		});
		
		//给事项名称 添加 事项的信息的按钮点击事件
		$('.eveMatter_name').on('click',function(){
			var matterId = $(this).attr("data-id");
			var data = {"matterId":matterId};
			$.ajax({
				url:rootPath +'/matterTheme/transDetail.shtml',
				type:'post',
				data:data,
				dataType:'json',
				success:function(res){
					//清空上次打开模态框留下的无用数据
					$('#myModal_matter').find('input[name="transName"]').val('');
					$('#myModal_matter').find('input[name="acceptPerson"]').val('');
					$('#myModal_matter').find('.yjcl').html('');
//					$('#mm').find(".l_err").css('display', 'none');
					$('#myModal_matter').modal('show');
					$('#myModal_matter').find('input[name="transName"]').val(res.transName);
					$('#myModal_matter').find('input[name="acceptPerson"]').val(res.acceptPerson);
					$('#myModal_matter').find('.yjcl').html(res.yjcl);
				}
			});
		});
		
		//关闭 要件详情模态框
		$('.cancle').on('click',function(){
			$('#myModal').modal('hide');
		}); 
		//关闭 事项详情模态框
		$('.cancle_matter').on('click',function(){
			$('#myModal_matter').modal('hide');
		}); 
});
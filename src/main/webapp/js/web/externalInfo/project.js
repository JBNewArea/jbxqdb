jQuery.validator.addMethod("lrunlv", function(value, element) {     
return this.optional(element) || /^\d+(\.\d{1,2})?$/.test(value);     
}, "请正确输入数字(包括小数)，精确到小数点后两位"); 
jQuery.validator.addMethod("num", function(value, element) {     
	return this.optional(element) || /^[0-9]*[1-9][0-9]*$/.test(value);     
	}, "请正确输入正整数"); 
$(function(){
	/*$('.btn-ok').on('click',function(){
		var data = $('.detail_form').serializeObject();
		var matterThemeId = $('input[name="matterThemeId"]').val();
		var themeApplyId = $('input[name="themeApplyId"]').val();
		var matterId = $('input[name="matterId"]').val();
		data = $.extend({matterThemeId:matterThemeId,themeApplyId:themeApplyId,matterId:matterId},data);
		$.ajax({
			url:rootPath+'/themeApply_fq/apply.shtml',
			type:'post',
			data:data,
			datType:'json',
			success:function(res){
				if(res == "success"){
					parent.disDBBtn(matterId);
					layer.confirm('代办发起成功!是否关闭窗口?', function(index) {
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(index);
					});
				}
			}
			
		});
	
	
	});*/
	
	
	
	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			var data = $('#form').serializeObject();
			var matterThemeId = $('input[name="matterThemeId"]').val();
			var themeApplyId = $('input[name="themeApplyId"]').val();
			var matterId = $('input[name="matterId"]').val();
			data = $.extend({matterThemeId:matterThemeId,themeApplyId:themeApplyId,matterId:matterId},data);
			console.log(data);
			$.ajax({
				url:rootPath+'/themeApply_fq/apply.shtml',
				type:'post',
				data:data,
				success:function(res){
					if(res == '"true"'){
						parent.disDBBtn(matterId);
//						layer.confirm('代办发起成功!是否关闭窗口?', function(index) {
//							layer.close(index);
//							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
//							parent.layer.close(index);
//						});
						layer.alert('代办发起成功!',function(index){
							parent.layer.close(parent.pageii);
							layer.close(index);
							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							parent.layer.close(index);
				        })
					}else{
						layer.alert('发起代办失败！请联系管理员');
					}
				}
				
			});
		},
		rules : {
			"gongchengName" : {
				required : true,
			},
			"gongchengAddress" : {
				required : true,
			},
			"gongchengCotent" : {
				required : true,
			},
			"gongchengGuiMo" : {
				required : true,
			},
			"gongchengBeiZhu" : {
				required : true,
			},
			"gongchengMianJi" : {
				required : true,
			},
			"gongchengZaoJia" : {
				required : true,
			},
			"gongchengKaiGong" : {
				required : true,
			},
			"gongchengJunGong" : {
				required : true,
			}
		},
		messages : {
			"gongchengName" : {
				required : "请填写工程名称",
			},
			"gongchengAddress" : {
				required : "请填写工程地址",
			},
			"gongchengCotent" : {
				required : "请填写工程内容",
			},
			"gongchengGuiMo" : {
				required : "请填写工程规模",
			},
			"gongchengBeiZhu" : {
				required : "请填写工程备注",
			},
			"gongchengMianJi" : {
				required : "请填写工程面积",
			},
			"gongchengZaoJia" : {
				required : "请填写工程造价",
			},
			"gongchengKaiGong" : {
				required : "请选择工程开工日期",
			},
			"gongchengJunGong" : {
				required : "请选择工程日期",
			}
		},
		errorPlacement : function(error, element) {// 自定义提示错误位置
			$(".l_err").css('display', 'block');
			// element.css('border','3px solid #FFCCCC');
			$(".l_err").html(error.html());
		},
		success : function(label) {// 验证通过后
			$(".l_err").css('display', 'none');
		}
	});
})
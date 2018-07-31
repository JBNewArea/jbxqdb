jQuery.validator.addMethod("lrunlv", function(value, element) {     
return this.optional(element) || /^\d+(\.\d{1,2})?$/.test(value);     
}, "请正确输入数字(包括小数)，精确到小数点后两位"); 
jQuery.validator.addMethod("num", function(value, element) {     
	return this.optional(element) || /^[0-9]*[1-9][0-9]*$/.test(value);     
	}, "请正确输入正整数"); 
$(function(){
	var $form = $('#form');
	
	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			var data = $form.serializeObject();
			var matterThemeId = $('input[name="matterThemeId"]').val();
			var themeApplyId = $('input[name="themeApplyId"]').val();
			var matterId = $('input[name="matterId"]').val();
			data = $.extend({matterThemeId:matterThemeId,themeApplyId:themeApplyId,matterId:matterId},data);
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
			"greenLandArea" : {
				required : true,
			},
			"greenLandAddress" : {
				required : true,
			},
			"greenLandOccupyTerm" : {
				required : true,
			},
		},
		messages : {
			"greenLandArea" : {
				required : "请正确填写绿地占用面积",
			},
			"greenLandAddress" : {
				required : "请正确填写绿地所在地",
			},
			"greenLandOccupyTerm" : {
				required : "请正确填写绿地占用期限",
			},
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
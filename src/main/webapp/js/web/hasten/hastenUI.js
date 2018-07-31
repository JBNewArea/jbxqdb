
$(function(){
	//提交催办信息
	$('.btn-hasten').on('click',function(){
		var applyId = $('input[name="applyId"]').val();
		var themeApplyId = $('input[name="themeApplyId"]').val();
		var data = $('.detail_form').serializeObject();
		data=$.extend({applyId:applyId,themeApplyId:themeApplyId},data);
		$.ajax({
			url:rootPath+'/hasten/hasten.shtml',
			type:'post',
			data:data,
			dataType:'json',
			success:function(res){
				if(res == "success"){
					layer.confirm('催办成功!是否关闭窗口?', function(index) {
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(index);
					});
				}
			}
		});
	});
});
var pageiii = null; 
function resetMatterIdAndName(id,nameobject){
	$('input[name=matterId]').val(id);
	var name = JSON.stringify(nameobject);
	namelist = name.substring(1,name.length-1).split(',');
	var namesStr = '';
	//删除数组中的空元素
	for(var i = 0; i < namelist.length; i++) {
		   if(namelist[i] == undefined || namelist[i] == '""'||namelist[i] == null) {
			   namelist.splice(i,1);
		      i = i - 1; // i - 1 ,因为空元素在数组下标 2 位置，删除空之后，后面的元素要向前补位，
		                       // 这样才能真正去掉空元素,觉得这句可以删掉的连续为空试试，然后思考其中逻辑
		   }
	}
	for(var i=0;i<namelist.length;i++){
		namelist[i] = parseInt(i+1)+"  :  "+namelist[i].substring(1,namelist[i].length-1)+" ;"+"\r\n";
		namesStr += namelist[i];
	}
	$('textarea[name=matterName]').val(nameobject);
	$('textarea[name=matterNameList]').val(namesStr);
}
//单独验证某一个input  class="checkpass"
jQuery.validator.addMethod("checkacc", function(value, element) {
	return this.optional(element)
			|| ((value.length <= 30) && (value.length >= 3));
}, "账号由3至30位字符组合构成");

$(function() {
	var $form = $('#form');
//	var validator = $form.validate;
//	$("#form").on('click','.btn-send',function(){
//		var data = $form.serializeObject();
//			var moneyResource = "";
//			var matterThemeType="";
////			var isImport="";
//			var landCharac="";
//			$form.find('input[name="moneyResource"]:checked').each(function(){
//				var _this = $(this);
//				moneyResource+=_this.attr("value")+",";
//			});
//			$form.find('input[name="matterThemeType"]:checked').each(function(){
//				var _this = $(this);
//				matterThemeType+=_this.attr("value")+",";
//			});
////			$form.find('input[name="isImport"]:checked').each(function(){
////				var _this = $(this);
////				isImport+=_this.attr("value")+",";
////			});
//			$form.find('input[name="landCharac"]:checked').each(function(){
//				var _this = $(this);
//				landCharac+=_this.attr("value")+",";
//			});
//			data["moneyResource"]=moneyResource;
//			data["matterThemeType"]=matterThemeType;
////			data["isImport"]=isImport;
//			data["landCharac"]=landCharac;
//			var url=$('#form').attr("url");
//			$.ajax({
//				url:url,
//				type : "post",
//				data:data,
//				dataType : "json",//ajaxSubmi带有文件上传的。不需要设置json
//				success : function(res) {
//					if (res == "success") {
//						layer.confirm('新增成功!是否关闭窗口?', function(index) {
//							parent.grid.loadData();
////							parent.layer.close(parent.pageii);
//							layer.close(index);
//							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
//							parent.layer.close(index);
//						});
//					} else { 
//						layer.msg('更新失败！', 3);
//					}
//				}
//			});
//	});
	
	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			var data = $form.serializeObject();
			var moneyResource = "";
			var matterThemeType="";
//			var isImport="";
			var landCharac="";
			$form.find('input[name="moneyResource"]:checked').each(function(){
				var _this = $(this);
				moneyResource+=_this.attr("value")+",";
			});
			$form.find('input[name="matterThemeType"]:checked').each(function(){
				var _this = $(this);
				matterThemeType+=_this.attr("value")+",";
			});
//			$form.find('input[name="isImport"]:checked').each(function(){
//				var _this = $(this);
//				isImport+=_this.attr("value")+",";
//			});
			$form.find('input[name="landCharac"]:checked').each(function(){
				var _this = $(this);
				landCharac+=_this.attr("value")+",";
			});
			data["moneyResource"]=moneyResource;
			data["matterThemeType"]=matterThemeType;
//			data["isImport"]=isImport;
			data["landCharac"]=landCharac;
			var url=$('#form').attr("url");
			$.ajax({
				url:url,
				type : "post",
				data:data,
				dataType : "json",//ajaxSubmi带有文件上传的。不需要设置json
				success : function(res) {
					if (res == "success") {
						layer.confirm('新增成功!是否关闭窗口?', function(index) {
							parent.grid.loadData();
//							parent.layer.close(parent.pageii);
							layer.close(index);
							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							parent.layer.close(index);
						});
					} else { 
						layer.msg('更新失败！', 3);
					}
				}
			});
		},
		rules : {
			"matterThemeName" : {
				required : true,
				remote : { // 异步验证是否存在
					type : "POST",
					url : rootPath+'/matterTheme/ismtNameExist.shtml',
					data : {
						name : function() {
							return $('input[name="matterThemeName"]').val();
						}
					}
				}
			}
		},
		messages : {
			"matterThemeName" : {
				required : "请输入项目名称",
				remote : "该名称已经存在"
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
	
	$("#form").on('click','.showMatter',function(){
//		pageiii = layer.open({
//			title : "基础事项配置",
//			type : 2,
//			area : [ "1100px", "100%" ],
//			content : rootPath + '/basicMatter/showUI.shtml',
//		});
		var matterId=$("#form").find('input[name="matterId"]').val();
		var matterName=$("#form").find('textarea[name="matterName"]').val();
		pageiii = layer.open({
			title : "基础事项配置",
			type : 2,
			area : [ "1100px", "100%" ],
			content : rootPath + '/basicMatter/showUI.shtml?matterId='+matterId+'&matterName='+matterName,
			resetMatterIdAndName:resetMatterIdAndName,
		});
	});
	
	
		
});

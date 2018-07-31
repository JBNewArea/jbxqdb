var pagebasic = null;
function resetMatterIdAndName(id,name){
	$('input[name=matterId]').val(id);
	$('input[name=matterName]').val(name);
}
//手机号码验证
jQuery.validator.addMethod("isMobile", function(value, element) {
	var length = value.length;
	var mobile = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
	//验证用于手机号验证,手机号位数皆为11位，所以将内部的固话验证注释
	//固话
//	if(mobile.test(value)){
//		return true;
//	}
	//手机
	var mobileRex = /^1(3[0-9]|4[57]|5[0-35-9]|8[0-9]|70)\d{8}$/;
	var cmRex = /^(1(3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\d{8})|(1705\d{7})$/;
	var cuRex = /^(1(3[0-2]|4[5]|5[56]|7[6]|8[56])\d{8})|(1709\d{7})$/;
    var ctRex = /^(1(33|53|77|8[019])\d{8})|(1700\d{7})$/; 
    
	return this.optional(element) || (length == 11 && (mobileRex.test(value) 
			||cmRex.test(value) ||cuRex.test(value) ||ctRex.test(value)));
}, "请正确填写您的手机号码");

//邮政编码验证
jQuery.validator.addMethod("isyoubian", function(value, element) {
	var length = value.length;
	var req = /^[1-9]\d{5}(?!\d)$/;
	if(value!=""){
		return this.optional(element) || req.test(value) ;
	}else{
		return true;
	}
}, "请正确填写邮编号码");
//投资额
jQuery.validator.addMethod("num", function(value, element) {     
	return this.optional(element) || /^[0-9]*[1-9][0-9]*$/.test(value);     
	}, "请正确输入正整数");
$(function() {
	
	/*$("form").on('click','.btn-send',function(){
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
					if (res.flag == "success") {
//						layer.confirm('发起代办成功!是否关闭窗口?', function(index) {
							parent.grid.loadData();
//							parent.layer.close(parent.pageii);
							layer.close(index);
							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							var matterThemeId = $('input[name="id"]').val();
							var applicantDocumentType = $('select[name="applicantDocumentType"] option:selected').val();
							var applicationDocumentNumber = $('input[name="applicationDocumentNumber"]').val();
							//控制父级页面打开代办弹窗
							parent.openApplyPage(res.id,matterThemeId,applicantDocumentType,applicationDocumentNumber);
							parent.layer.close(index);
							
							
							
//						});
					} else {
						layer.msg('更新失败！', 3);
					}
				},
			});
//			var s = CommnUtil.ajax(url, data, "json");
//			if (s == "success") {
//				layer.confirm('更新成功!是否关闭窗口?', function(index) {
//					parent.grid.loadData();
//					parent.layer.close(parent.pageii);
//					return false;
//				});
//			} else {
//				layer.msg('更新失败！', 3);
//			}
	});*/
	
	$("form").validate({
		submitHandler : function(form) {// 必须写在验证前面，否则无法ajax提交
			var data = $form.serializeObject();
			var moneyResource = "";
			var matterThemeType="";
			var isImport="";
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
//				alert(isImport);
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
					if (res.flag == "success") {
//						layer.confirm('发起代办成功!是否关闭窗口?', function(index) {
							parent.grid.loadData();
//							parent.layer.close(parent.pageii);
							layer.close(index);
							var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							var matterThemeId = $('input[name="id"]').val();
							var applicantDocumentType = $('select[name="applicantDocumentType"] option:selected').val();
							var applicationDocumentNumber = $('input[name="applicationDocumentNumber"]').val();
							//控制父级页面打开代办弹窗
							parent.openApplyPage(res.id,matterThemeId,applicantDocumentType,applicationDocumentNumber);
							parent.layer.close(index);
							
							
							
//						});
					} else {
						layer.msg('更新失败！', 3);
					}
				},
			});
		},
		rules : {
			"name" : {
				required : true,
				remote : { // 异步验证是否存在
					type : "POST",
					url : rootPath+'/themeApply_fq/istaNameExist.shtml',
					data : {
						name : function() {
							return $('input[name="name"]').val();
						}
					}
				}
			},
			"applicationName":{
				required : true,
			},
			"applicantDocumentType":{
				required:true,
			},
			"applicationDocumentNumber":{
				required:true,
				remote:{
					type : "POST",
					url : rootPath+'/themeApply_fq/iscorectdocumentNumber.shtml',
					data : {
						type:function(){
							return $('select[name="applicantDocumentType"] option:selected').val();
						},
						number : function() {
							return $('input[name="applicationDocumentNumber"]').val();
						}
					}
				}
			},
			"applicationPhone":{
				required:true,
			},
			/*"applicationPostCode":{
				required:true,
			},
			"applicationAddress":{
				required:true,
			},
			"legalRepresentative":{
				required:true,
			},*/
			"themeAddress":{
				required:true,
			}
		},
		messages : {
			"name" : {
				required : "请输入账号",
				remote : "该名称已经存在"
			},
			"applicationName":{
				required : "请填写申请单位名称",
			},
			"applicantDocumentType":{
				required:"请选择申请单位证件类型",
			},
			"applicationDocumentNumber":{
				required:"请填写证件号码",
				remote:"请填写正确的证件号码"
			},
			"applicationPhone":{
				required:"请填写正确的联系电话",
			}
			/*,
			"applicationPostCode":{
				required:"请填写正确的邮编",
			},
			"applicationAddress":{
				required:"请填写通讯地址",
			},
			"legalRepresentative":{
				required:"请填写法定代表人",
			}*/
			,
			"themeAddress":{
				required:"请填写项目地址",
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
	
	
	
	
});

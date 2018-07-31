var pageAllfile = null;
$(function(){
//	$('.upload').on('click',function(){
//		pageuploadFile = layer.open({
//			title : "附件上传",
//			type : 2,
//			area : [ "800px", "90%" ],
//			content : rootPath + '/upload/uploadUI.shtml?matterId='+matterId+'&applicantDocumentType='+applicantDocumentType
//								+'&applicationDocumentNumber='+applicationDocumentNumber,
//		});
//	});
	
	$('.upload').on('click',function(){
		//清空上次打开模态框留下的无用数据
		$('#myModal').find('.result').text("");
		$('#mm').find(".l_err").css('display', 'none');
		$('#myModal').modal('show');
		var materialId = $(this).attr("data-id");
		var userType = $('input[name="applicantDocumentType"]').val();
		var userIdCard = $('input[name="applicationDocumentNumber"]').val();
		$('#myModal').find('input[name="materialId"]').val(materialId);
		$('#myModal').find('input[name="userIdCard"]').val(userIdCard);
		$('#myModal').find('input[name="userType"]').val(userType);
	});
	
	var fileElement = document.getElementById('file');
	fileElement.onchange = function(){
		if(this.value==''){
			$('#mm').find(".l_err").css('display', 'block');
			// element.css('border','3px solid #FFCCCC');
			$('#mm').find(".l_err").html("请先选择文件");
		}else{
			$('#mm').find(".l_err").css('display', 'none');
		}
	}
	
	
	//在模态框中上传文件
	$('.uploadFile').on('click',function(){
		var oInput = document.getElementById('file');
		if(oInput.value==''){
			$('#mm').find(".l_err").css('display', 'block');
			// element.css('border','3px solid #FFCCCC');
			$('#mm').find(".l_err").html("请先选择文件");
			return;
		}
		$('#myModal').find('.result').text("正在上传,请稍后...");
		$("#mm").ajaxSubmit({
		       url: rootPath+"/upload/uploadFile.shtml",  //
		       type: "post",
		       success: function (res) {
		    	   if(res!=null&&res!=''){//
		    		   $('#myModal').find('.result').text("上传材料已完成");
		    		   var materialId = $('#myModal').find('input[name="materialId"]').val();
		    		   $('.allfile_'+materialId).removeClass("hide");
		    		   setTimeout(function(){
		    			   $('#myModal').modal('hide');
		    		   },1000);
		    	   }else{
		    		   $('#myModal').find('.result').text("上传失败，请联系管理员");
		    	   }
//		    	   if(data!=null&&data!=''){
//		    		   $('#myModal').find('.result').text("上传材料已完成");
//		    		   setTimeout(function(){
//		    			   $('#myModal').modal('hide');
//		    		   },1000);
//		    	   }else{
//		    		   $('#myModal').find('.result').text("上传失败，请联系管理员");
//		    	   }
		       }
		});
	});
	
	//关闭模态框
	$('.cancle').on('click',function(){
		$('#myModal').modal('hide');
	}); 
	//打开材料清单
	$('.allfile').on('click',function(){
		var materialId = $(this).attr("data-id");
		var userType = $('input[name="applicantDocumentType"]').val();
		var userIdCard = $('input[name="applicationDocumentNumber"]').val();
		//证件号码和类型和事项id，查找该证件号码的材料清单
		var data={materialId:materialId,userIdCard:userIdCard,userType:userType};
		pageAllfile = layer.open({
			title : "附件管理",
			type : 2,
			area : [ "800px", "90%" ],
			content : rootPath + '/upload/showAllfileUI.shtml?materialId='+materialId+'&userIdCard='+userIdCard+'&userType='+userType,
		});
	});
});
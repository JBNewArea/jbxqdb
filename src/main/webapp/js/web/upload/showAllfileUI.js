$(function(){
	//下载
		$('.Down').on('click',function(){
			 var id = $(this).attr("data-id");
			 window.open("http://221.226.86.27:8090/xzsp-interface/a/rpc/realUserMaterial/realUserMaterial/realUserMaterialDown?id="+id,"_self");
		});
		//删除
		$('.del').on('click',function(){
			var _this = $(this);
			layer.confirm('确定要删除该附件吗？',function(){
				var url = _this.attr("data_url");
				$.ajax({
					url:url,
					type:'post',
					data:null,
					success:function(data){
						if(data=="success"){
							layer.alert('成功删除附件！', 3);
							var id = _this.attr("data-id");
							$('.tr_'+id).addClass('hide');
						}else{
							layer.alert('删除附件失败',3);
						}
					}
				});
			});
		}); 
})
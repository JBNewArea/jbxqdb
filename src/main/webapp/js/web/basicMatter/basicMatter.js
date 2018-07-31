$(function(){
	
	

//		var startMatterIds=self.initialData.startMatterIds;
//		var startMatterNames = self.initialData.startMatterNames;
		var startMatterIds = $('input[name="startMatterIds"]').val();
		var startMatterNames = $('input[name="startMatterNames"]').val();
		var startMatterIdArr =startMatterIds==""||startMatterIds==null?[]: startMatterIds.split(",");
		var startMatterNameArr = startMatterNames==""||startMatterNames==null?[]:startMatterNames.split(",");
//		var $table = $page.find('#basicmatter_table');
		var selectionIds = self.selectionIds = startMatterIdArr;  //保存选中ids  
		var selectionNames = self.selectionNames=startMatterNameArr;//返回给调用方页面展示用
		console.log("进入:"+selectionNames);
		
		//搜索按钮
		$('.search_form').on('click','.btn-search',function(){
			$table.bootstrapTable('refresh', {url:rootPath+'/basicMatter/findAllBasicMatter.shtml',silent: true,
	             query: {pageNumber: 1,    
		              pageSize: 5,
		              transName:$('.search_form').find('input[name="transName"]').val(),
		              transBaseCode:$('.search_form').find('input[name="transBaseCode"]').val(),
		              officeId:$('.search_form').find('select[name="officeId"]').val()}});
		});
		
		$table = $('#basicMatter_table').bootstrapTable({
	        //【发出请求的基础信息】
	        url: rootPath+'/basicMatter/findAllBasicMatter.shtml',
	        method: 'post',
	        contentType: "application/x-www-form-urlencoded",
	        
	        
	        //【查询设置】
	        /* queryParamsType的默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
	                          设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber */
	        queryParamsType:'', 
	       queryParams: function queryParams(params) {  
	          var param = {  
	              pageNumber: params.pageNumber,    
	              pageSize: params.pageSize,
	              transName:$('.search_form').find('input[name="transName"]').val(),
	              transBaseCode:$('.search_form').find('input[name="transBaseCode"]').val(),
	              officeId:$('.search_form').find('select[name="officeId"]').val()
	          }; 
	          return param;                   
	        },
	        clickToSelect:true,//是否选中
	        //【其它设置】
	        locale:'zh-CN',//中文支持
	        pagination: true,//是否开启分页（*）
	        pageNumber:1,//初始化加载第一页，默认第一页
	        pageSize: 5,//每页的记录行数（*）
	        pageList: [5,6,7],//可供选择的每页的行数（*）
	        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
//	        showRefresh:true,//刷新按钮
	        responseHandler:responseHandler,
	        idField:"id",  
	        //【样式设置】
//	        height: 500,//table的高度
	        //按需求设置不同的样式：5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
	        rowStyle: function (row, index) {
	            var style = "";
	            if (row.name=="小红") {style='success';}
	            return { classes: style }
	        },
	        
	        //【设置列】
	        columns: [
	         {field: 'checkStatus',checkbox: true,width:'10%',formatter:function(value, row, index){
	        	 if($.inArray(row.id,startMatterIdArr) !=-1){
	        		 return{checked:true};
	        	 }
	        	 return value;
	         }},
	         {field: 'transName',width:'50%',title:'事项名称',formatter:function(value, row, index){
	        	 if(row.transName.length>12){
	        		 return '<div title="'+row.transName+'">'+row.transName.substring(0,12)+'...</div>';
	        	 }else{
	        		 return row.transName;
	        	 }
	        	 
	         }}, 
	         {field: 'transBaseCode',width:'30%',title: '事项编码'},
	         {field: 'officeName',width:'30%',title: '所属部门'}
	        ],
//	        onClickCell: function (field, value, row, $element) {
//	        	$element.parent().parent().children().each(function(e){
//	        		$(this).removeClass('selected');
//	        	});
//	        	$element.parent().addClass('selected');
//	        	_selected=row;
//	        },
	    });
		/*选中事件 存放id*/
		 //选中事件操作数组  
	    var union = function(array,ids){  
	        $.each(ids, function (i, id) {  
	            if($.inArray(id,array)==-1){  
	                array[array.length] = id;  
	            }  
	             });  
	            return array;  
	    };  
	    //取消选中事件操作数组  
	    var difference = function(array,ids){  
//	    	console.log("进入取消id方法");
	            $.each(ids, function (i, id) {  
	                 var index = $.inArray(id,array);  
	                 if(index!=-1){  
	                     array.splice(index, 1);  
	                 }  
	             });  
	            return array;  
	    };  
	    /*选中事件 绑定name*/
	    var unionname = function(namearray,names){ 
	        $.each(names, function (i, name) {  
	            if($.inArray(name,namearray)==-1){  
	            	namearray[namearray.length] = name;  
	            }  
	             });  
	            return namearray;  
	    };  
	    //取消选中事件操作数组  
	    var differencename = function(namearray,names){ 
//	    	console.log("进入取消name方法");
	            $.each(names, function (i, name) {  
	                 var index = $.inArray(name,namearray);  
	                 if(index!=-1){  
	                     namearray.splice(index, 1);  
	                 }  
	             });  
	            return namearray;  
	    };  
	    
	    var _ = {"union":union,"difference":difference,"unionname":unionname,"differencename":differencename};  
	    //绑定选中事件、取消事件、全部选中、全部取消  
	    $table.on('check.bs.table check-all.bs.table uncheck.bs.table uncheck-all.bs.table', function (e, rows) {  
	            var ids = $.map(!$.isArray(rows) ? [rows] : rows, function (row) {  
	                     return row.id;  
	            });  
	            var names=$.map(!$.isArray(rows) ? [rows] : rows, function (row) {  
	                     return row.transName;  
	            });  
	             func = $.inArray(e.type, ['check', 'check-all']) > -1 ? 'union' : 'difference';  
	             self.selectionIds = _[func](self.selectionIds, ids); 
	             if(func=='union'){
	            	 newfunc='unionname';
	            	 self.selectionNames = _[newfunc](self.selectionNames,names);
	             }else{
	            	 newfunc='differencename';
	            	 self.selectionNames = _[newfunc](self.selectionNames,names);
	             }
	             
//	             alert(selectionIds);
	     }); 
	    //表格分页之前处理多选框数据 
	    function responseHandler(resdata) { 
//	    	alert(res);
	    	if(resdata.success==false){
//	    		BootstrapDialog.danger(resdata.errInfo);
//	    		BootstrapDialog.show({
//	    	        message: resdata.errInfo, 
//	    	        type: BootstrapDialog.TYPE_DANGER, 
//	    	        title: '错误', 
//	    	        buttons: [{
//	    	            label: '关闭',
//	    	            action: function (dialog) {
//	    	                dialog.close();
//	    	            }
//	    	        }]
//	    	    });
	    	}else{
	    		var res=resdata.entity;
		    	var data=res["datalist"];  
		    	var returndata=new Array();
		    	$.each(data, function (i, row) { 
		    		row.checkStatus = $.inArray(row.id, self.selectionIds) != -1;  //判断当前行的数据id是否存在与选中的数组，存在则将多选框状态变为true  
		    		returndata.push(row);
		    	});  
		    	return {  
		    		"total": res.count,//总页数  
		    		"page":res.pageNumber,  
		    		"rows": returndata //数据转成json对象  
	            }; 
	    	}
	    	
	    }
	    
	    $('.btn-sure').click(function(){
	    	console.log("selectionIds"+selectionIds);
	    	console.log("selectionNames:"+selectionNames);
			parent.resetMatterIdAndName(selectionIds,selectionNames);
			parent.layer.close(parent.pageiii);
		});
	    
	    
});
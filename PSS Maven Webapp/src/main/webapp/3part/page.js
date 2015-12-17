(function($){
	$.fn.page = function(options) { 
		var defaults = { 
			ajaxType:0,
			url:"#",
			mao:"",
			method:null,
			pageNo:1, 
			pageCount:1,
			pageSize:3,
			formId:""
		};
		var options = $.extend(defaults, options); 
		return this.each(function(){ 
			var $thisPage=$(this); 
			//options.url=createUrl(options.url);
			$thisPage.addClass("r-pagination");
			var optionStr="url:'"+options.url+"',ajaxType:"+options.ajaxType+",pageCount:"+options.pageCount+",pageSize:"+options.pageSize+",formId:'"+options.formId+"',method:'"+options.method+"',pageNo:";
			var addStr="";
			addStr+='<a class="page-li" data-options="'+optionStr+1+'">首页</a>';
			for(var i=1;i<=options.pageCount;i++){
				var cPageNo=options.pageNo?options.pageNo:1;
				if(cPageNo==i){
					addStr+='<a class="page-li active" data-options="'+optionStr+i+'">'+i+'</a>';
				}else{
					addStr+='<a class="page-li" data-options="'+optionStr+i+'" data-pageNo="'+i+'">'+i+'</a>';
				}
			}
			addStr+='<a class="page-li" data-options="'+optionStr+options.pageCount+'">末页</a>';
			$thisPage.empty().append(addStr);
			//alert(option);
//			if(options.method!=null){
//				var pageNums=$thisPage.find("a");
//				$.each(pageNums,function(i,v){
//					$(v).on("click",function(e){
//						var returnData="";
//						$.ajax({
//				             type: "POST",
//				             url: $(v).attr("href"),
//				             data:{},
//				             async:false,
//				             success: function(data){
//				            	 returnData=data;
//				             }
//				        });
//						var method=eval(options.method);
//						method.call(window,returnData);
//						return false;
//					});
//				});
//			}
		}); 
		
		function createUrl(url){
			if(url.indexOf("?")==-1){
				return url+"?";
			}else{
				return url;
			}
		}
		
		
	}; 
	/*$.fn.pagination.parsePage=function(option){
		var opt={};
		var str=option.split(",");
		$.each(str,function(i,v){
			var temp=v.split("=");
			if(temp[0].replace(/(^\s*)|(\s*$)/g,"")=="begin") opt.begin=temp[1];
			if(temp[0].replace(/(^\s*)|(\s*$)/g,"")=="end") opt.end=temp[1];
			if(temp[0].replace(/(^\s*)|(\s*$)/g,"")=="length") opt.length=temp[1];
			if(temp[0].replace(/(^\s*)|(\s*$)/g,"")=="totalRecords") opt.totalRecords=temp[1];
			if(temp[0].replace(/(^\s*)|(\s*$)/g,"")=="pageNo") opt.pageNo=temp[1];
			if(temp[0].replace(/(^\s*)|(\s*$)/g,"")=="pageCount") opt.pageCount=temp[1];
		});
		
		return opt;
	};*/
})(jQuery);



$(function(){
	var $page=$(".r-pagination");
	$.each($page,function(i,v){
		var options={};
		var optionsStr="{"+$(v).data("options")+"}";
		optionsStr = eval("("+optionsStr+")");
		if(optionsStr.url!=undefined) options.url=optionsStr.url;
		if(optionsStr.pageNo!=undefined) options.pageNo=optionsStr.pageNo;
		if(optionsStr.pageCount!=undefined) options.pageCount=optionsStr.pageCount;
		if(optionsStr.pageSize!=undefined) options.pageSize=optionsStr.pageSize;
		if(optionsStr.formId!=undefined) options.formId=optionsStr.formId;
		if(optionsStr.method!=undefined) options.method=optionsStr.method;
		$(this).page(options);
	});
});

$(".page-li").live("click", function(){
	var options="{"+$(this).data("options")+"}";
	options = eval("("+options+")");
	var pageNo=options.pageNo;
	var url=options.url;
	var formId=options.formId;
	if(formId==""){
		if($("#fm").length<=0){
			formId="fm";
			$("body").append("<form id='"+formId+"'></form>");
		}
	}else{
		if($("#"+formId).length<=0){
			$("body").append("<form id='"+formId+"'></form>");
		}
	}
	if($("#"+formId).find("input[name=pageNo]").length<=0){
		$("#"+formId).append("<input type='hidden' name='pageNo' value='"+pageNo+"' />");
	}else{
		$("#"+formId).find("input[name=pageNo]").val(pageNo);
	}
	if(options.method!=null && options.method!=undefined && options.method!="null"){
		$.post(url,$("#"+formId).serialize(),function(data){
			var method=eval(options.method);
			method.call(window,data);
		});
	}else{
		$("#"+formId).attr("action",url);
		$("#"+formId).submit();
	}
	$(this).parents(".r-pagination").find("a").removeClass("active");	
	$(this).parents(".r-pagination").find("a").eq(pageNo).addClass("active");
});

function test(){
	var options={
		url:"http://www.baidu.com",
		pageNo:1,
		formId:"fm",
		pageCount:3
	};
	$("#page1").page(options);
}


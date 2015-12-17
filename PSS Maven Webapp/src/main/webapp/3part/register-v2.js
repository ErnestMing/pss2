var YOP = YOP || {};

var InterValObj; //timer变量，控制时间
var count =60; //间隔函数，1秒执行
var curCount;//当前剩余秒数

YOP.registerV2 = (function() {
	var emailUtils={};
	emailUtils["163"]="http://mail.163.com/";
	emailUtils["126"]="http://www.126.com/";
	emailUtils["qq"]="http://mail.qq.com/";
	emailUtils["gmail"]="https://mail.google.com/";
	emailUtils["yahoo"]="http://cn.mail.yahoo.com/";
	emailUtils["hotmail"]="http://www.hotmail.com/";
	emailUtils["sina"]="http://mail.sina.com.cn/";
	emailUtils["139"]="http://mail.139.com/";
	emailUtils["tom"]="http://mail.tom.com/";
	emailUtils["21cn"]="http://mail.21cn.com/";
	emailUtils["sogou"]="http://mail.sogou.com/";
	emailUtils["189"]="http://webmail3.189.cn/webmail/";
	emailUtils["eyou"]="http://www.eyou.com/";
	emailUtils["yeah"]="http://www.yeah.net/";
	emailUtils["sohu"]="http://mail.sohu.com/";
	emailUtils["foxmail"]="http://www.foxmail.com/";
	emailUtils["263"]="http://www.263.net/";
	
	
	if($("#msg").val()){
		 if( $("#status")&&"1"==$("#statusJoin").val()){
			 Widget.prodialog.alert("确定",$("#msg").val(),function(){
				 window.location.href="/yop";
			 }); 
		 }
		 else{
			 Widget.prodialog. alert("确定",$("#msg").val()); 
		 }
		 
		 
	}
	if($("#isMailNormal")&&$("#isMailNormal").val()){
		$("#verification-code-p").hide();
		$("#verification-code-pic").hide();
	}
	
	//表单验证器的一些全局配置
	$.validator.setDefaults({
		errorPlacement:function(error, element) {  
			$("[data-errorFrom=" + element.attr("name") + "]").html(error);
		},
		success: function(label, element) {
			$(element).removeClass("input-error");
			$(".error-label[data-errorfrom=" + $(element).attr("name") + "]").empty();
		}
	});
	
	//当手机或者邮箱号变了  把uuid情空  这样提交的时候  就会再去提示去获取验证码
	$("#emailOrMobile,#email,#mobile").bind("change",function(){
		var form=$(this).parents("form");
		var uuid=form.find("#uuid");
		if(uuid){
			uuid.val("");
		}
	});
	
	var firstValidator = $("#regForm-firstStep").validate({
		rules: {
			"emailOrMobile": {
				required: true,
				emailOrMobile: true
			},
			"verification-code": {
				required: true
			},
			"name": {
				required: true
			},
			"pass": {
				required: true,
				myPassword: true
			},
			"confirm-password": {
				required: true,
				equalTo: "#password"
			},
			"imgValidate":{
				required: true
			},
			"promotionCode":{
				required: true
			}
		},
		
		messages: {
			"confirm-password": {
				equalTo: "两次输入的密码不一致"
			}
		}
	});

	
	var createCompanyValidator = $("#regForm-createCompany").validate({
		rules: {
			"name": {
				required: true,
			},
			"mobile": {
				required: true,
				isMoblie: true
			},
			"email": {
				required: true,
				email: true
			},
			"verificationCode": {
				required: true
			}
		}
	});
	
	var inviteCreateValidator = $("#inviteNoAccount-firstStep").validate({
		rules: {
			"emailOrMobile": {
				required: true,
				emailOrMobile: true
			},
			"verificationCode": {
				required: true
			},
			"name": {
				required: true
			},
			"password": {
				required: true,
				myPassword: true
			},
			"confirm-password": {
				required: true,
				equalTo: "#password"
			}
		},
		messages: {
			"confirm-password": {
				equalTo: "你两次输入的密码不一致"
			}
		}
	});
		
	var invitePersonInfoValidator = $("#inviteNoAccount-secondStep").validate({
		rules: {
			"invite-input-dept": {
				required: true
			},
			"mobile": {
				required: true,
				isMoblie: true
			},
			"email": {
				required: true,
				email: true
			},
			"verificationCode": {
				required: true
			}
			
		}
	});
	
	var inviteHasAccountFirstValidator = $("#inviteHasAccount-firstStep").validate({
		rules: {
			"code": {
				required: true
			},
			"pass": {
				required: true
			}
			
		}
	});
	
	var inviteHasAccountSecondValidator = $("#inviteHasAccount-secondStep").validate({
		rules: {
			"invite-input-hasAccount-dept": {
				required: true
			},
			"mobile":{
				required: true,
				isMoblie: true
			},
			"email":{
				required: true,
				email: true
			},
			"verificationCode":{
				required: true
			}
		}
	});
	
	function createTab() {
		var tab = new YOP.common.Tab({
			navElements: $(".step2-tab > li"),
			navClassName: "tab-active"
		});
	}
	
	function createScrollBar() {
		$(".reg-selectApp-list").mCustomScrollbar({
			theme: "dark"
		});
	}
	
	function createDropSelectTree() {
		var tenantId=$("#tenantId").val();
		if(tenantId){
			/*
			 * 
			<input type="text" name="deptId"  class="input-text hasPlaceholder" id="invite-input-dept" name="invite-input-dept" />
			<div class="select-input-dept-tree pos-a hide" id="invite-noAccount-deptTree"></div>
			*/
			var url="/yop/pc/announcement/getDepartDataByTenantId?tenantId="+tenantId;
			if($("#invite-input-dept").attr("name")){
				YOP.common.selectTree.create(url,"invite-input-dept", "invite-noAccount-deptTree");
			}else if($("#invite-input-hasAccount-dept").attr("name")){
				YOP.common.selectTree.create(url,"invite-input-hasAccount-dept", "invite-hasAccount-deptTree");
			}
		}
	}
/*	function createDropSelectTree() {
		YOP.common.selectTree.create("/yop/pc/announcement/getDepartData",
									"invite-input-dept", "invite-noAccount-deptTree");
		
		YOP.common.selectTree.create("/yop/pc/announcement/getDepartData",
				"invite-input-hasAccount-dept", "invite-hasAccount-deptTree");
	}*/
	
	function ifInviteCodeExist(){
		var code = $("input[name=inviteCode]").val();
		var ret = false;
		$.ajax({
			   url: webCfg.servePath+"/pc/registerv2/isExistEnterpriseCode",
			   data: {"code":code},
			   async: false,
			   cache:false,
			   success: function(data){
				   if (data.succeed) {
					   ret = true;
				   }
			   },
			 });
		return ret;
	}
	
	function handleEvents() {
		
		$(".imgValidate").click(function(){
			var random=Math.random();
			$(this).attr("src",webCfg.servePath+"/pc/checkcode/getCodeImg?random="+random);
		});
		
		
		/*$("#imgValidate").blur(function(){
			var imgValidate=$("#imgValidate").val();
			var isMobile=false;
			var emailOrMobile=$("input[name=emailOrMobile]").val();
			emailOrMobile=emailOrMobile.trim();
			var result=emailOrMobile.match(/^(1)\d{10}$/);
			if(result!=null){
				isEmailOrMobile=true;
				isMobile=true;
			}
			
			if(imgValidate||isMobile){
				$("#verification-code-pic").show();
				$("#verification-code-p").show();
			}else{
				$("#verification-code-p").hide();
				$("#verification-code-pic").hide();
				
			}
		});
		*/
		
		
	/*	$("#imgValidate1").blur(function(){
			var isMobile=false;
			var emailOrMobile=$("input[name=mobile]").val();
			emailOrMobile=emailOrMobile.trim();
			var result=emailOrMobile.match(/^(1)\d{10}$/);
			if(result!=null){
				isEmailOrMobile=true;
				isMobile=true;
			}
			var imgValidate=$("#imgValidate1").val();
			if(imgValidate||isMobile){
				$("#verification-code-pic").show();
				$("#verification-code-p").show();
				
			}else{
				$("#verification-code-pic").hide();
				$("#verification-code-p").hide();
			}
		});*/

		/*$("#imgValidate2").blur(function(){
			var imgValidate=$("#imgValidate2").val();
			if(imgValidate){
				$("#verification-code-pic").show();
					$("#verification-code-p2").show();
				
			}else{
					$("#verification-code-p2").hide();
			}
		});*/
	
		$("#emailOrMobile").blur(function(){
			var emailOrMobile=$(this).val();
			if(emailOrMobile){
				var isEmail=emailOrMobile.match(/^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/);
				//如果是邮件注册则不发送验证码,只进行是否存在验证
				if(isEmail){
					$("#verification-code-p").hide();
					$("#verification-code-pic").hide();
					var isExist=ifUserExist(emailOrMobile);
					if(isExist.data){
						Widget.prodialog. alert("确定","该邮箱已经被注册，请换其他邮箱!");
						return;
					}
				}
				/*var isMobile=emailOrMobile.match(/^(1)\d{10}$/);
				if(isMobile!=null){*/
				else{
					if($(this).attr("data-first")){
						$("#verification-code-p").show();
					}
					$("#verification-code-pic").show();
				}
				//}
				/*else{
					$("#verification-code-p").hide();
					$("#verification-code-pic").hide();
				}*/
				
			}
			else{
				if($(this).attr("data-first")){
					$("#verification-code-p").show();
				}
				$("#verification-code-pic").show();
			}
			
		});
		
		$("#check-promotion").click(function(){
			if($(this).attr("checked")){
				$("#promotion-code-p").show();
			}else{
				$("#promotion-code-p").hide();
			}
		});
		
		    
		
		//部署应用
		$("#reg-selectApp-submit").click(function() {
			$("#reg-selectApp-submit").attr("disabled", "true");
			$("#reg-selectApp-submit").attr("class","btn-disable-v2 reg-submit f14");
			$("#reg-selectApp-submit").html("正在处理中,请稍等......");
			
			var apps=$("input[name=selectApp-checkbox]");
			var appIds = new Array();
			apps.each(function (index, app) { 
				if($(app).attr("checked")=="checked"){
					appIds.push($(app).val());
				}
			});
			if(appIds&&appIds.length>0){
				setApps(appIds);
			}

		});
		
		//注册成功  开始使用   去跳到工作台
		$("#reg-success-start").click(function(){
			window.location = "/yop/pc/workbench";
		});
		
		/**
		 * 无账号邀请注册第一步
		 */
		$("#inviteNoAccount-step1-submit").click(function() {
			if (!inviteCreateValidator.form()) return;
			var checked=$("#check-agreement").attr("checked");
			if(!checked||!checked=="checked"){
				 Widget.prodialog. alert("确定","确认同意YOP云办公使用条款！");
				 return;
			}
			var inviteCode=$("#inviteCode").val();
			var code=$("#verification-code").val();
			var emailOrMobile=$("input[name=emailOrMobile]").val();
			var uuid=$("#uuid").val();
			var isEmail=emailOrMobile.match(/^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/);
			if(isEmail){
				$.ajax({
					   url: webCfg.servePath+"/pc/registerv2/step1/checkValidateCode",
					   data: {"code":code,"uuid":uuid, "emailOrMobile":emailOrMobile},
					   cache:false,
					   success: function(data){
						   if(data&&data.succeed){
							   //验证码正确   提交表单
							   $("#inviteNoAccount-firstStep").attr("action",webCfg.servePath+"/pc/registerv2/inviteNoAccountStep1Do?inviteCode="+inviteCode);
							   $("#inviteNoAccount-firstStep").attr("method","post");
							   $("#inviteNoAccount-firstStep").submit();
							   
						   }else{
							   Widget.prodialog. alert("确定",data.msg);
						   }
					   }
					 });
			}else{
				if(code&&uuid){
					$.ajax({
						   url: webCfg.servePath+"/pc/registerv2/step1/checkValidateCode",
						   data: {"code":code,"uuid":uuid, "emailOrMobile":emailOrMobile},
						   cache:false,
						   success: function(data){
							   if(data&&data.succeed){
								   //验证码正确   提交表单
								   $("#inviteNoAccount-firstStep").attr("action",webCfg.servePath+"/pc/registerv2/inviteNoAccountStep1Do?inviteCode="+inviteCode);
								   $("#inviteNoAccount-firstStep").attr("method","post");
								   $("#inviteNoAccount-firstStep").submit();
								   
							   }else{
								   Widget.prodialog. alert("确定",data.msg);
							   }
						   }
						 });
				}else if(!code){
					Widget.prodialog. alert("确定","请输入验证码");
				}else if(!uuid){
					Widget.prodialog. alert("确定","请先获取验证码");
				}
			}
		});
		/**
		 * 无账号邀请注册第二步
		 */
		$("#inviteNoAccount-step2-submit").click(function() {
			if (!invitePersonInfoValidator.form()) return;
			var code=$("#verification-code").val();
			var uuid=$("#uuid").val();
			var emailOrMobile = '';
			var email=$("input[name=email]").val();
			var mobile=$("input[name=mobile]").val();
			if (email) {
				emailOrMobile = email;
			} else if (mobile) {
				emailOrMobile = mobile;
			}
			var useEmail=$("#useEmail").val();
			if(useEmail&&useEmail==="yes"){
				$.ajax({
					   url: webCfg.servePath+"/pc/registerv2/step1/checkValidateCode",
					   data: {"code":code,"uuid":uuid,"emailOrMobile":emailOrMobile},
					   cache:false,
					   success: function(data){
						   if(data&&data.succeed){
							 //解决下拉选择框value不是id是name
							   
								if($("#invite-input-dept").attr("data-selectedid")){
									$("#invite-input-dept").val($("#invite-input-dept").attr("data-selectedid"));
								}
								else if(!$("#invite-input-dept").attr("data-selectedid")){
									Widget.prodialog.alert("确定","请选择部门");
									return;
								}
							   //验证码正确   提交表单
							   $("#inviteNoAccount-secondStep").attr("action",webCfg.servePath+"/pc/registerv2/inviteNoAccountStep2Do");
							   $("#inviteNoAccount-secondStep").attr("method","post");
							   $("#inviteNoAccount-secondStep").submit();
							   
						   }else{
							   Widget.prodialog. alert("确定",data.msg);
						   }
					   }
					 });
			}else{
				if(code&&uuid){
					$.ajax({
						   url: webCfg.servePath+"/pc/registerv2/step1/checkValidateCode",
						   data: {"code":code,"uuid":uuid,"emailOrMobile":emailOrMobile},
						   cache:false,
						   success: function(data){
							   if(data&&data.succeed){
								 //解决下拉选择框value不是id是name
								   
								   if($("#invite-input-dept").attr("data-selectedid")){
										$("#invite-input-dept").val($("#invite-input-dept").attr("data-selectedid"));
									}
									else if(!$("#invite-input-dept").attr("data-selectedid")){
										Widget.prodialog.alert("确定","请选择部门");
										return;
									}
								   //验证码正确   提交表单
								   $("#inviteNoAccount-secondStep").attr("action",webCfg.servePath+"/pc/registerv2/inviteNoAccountStep2Do");
								   $("#inviteNoAccount-secondStep").attr("method","post");
								   $("#inviteNoAccount-secondStep").submit();
								   
							   }else{
								   Widget.prodialog. alert("确定",data.msg);
							   }
						   }
						 });
				}else if(!code){
					Widget.prodialog. alert("确定","请输入验证码");
				}else if(!uuid){
					Widget.prodialog. alert("确定","请先获取验证码");
				}
			}
			
		});
		
		/**
		 * 无账号邀请注册最后一步
		 */
		$("#join-success-start").click(function(){
			var inviteCode=$("#inviteCode").val();
			window.location.href = "/yop/pc/registerv2/inviteNoAccountFinishDo?inviteCode="+inviteCode;
		});
		
		
		
		
		$("#get-verification-code").click(sendValidateCode);
		$("#get-verification-code-joinCompany").click(sendJoinValidateCode);
		
		/**
		 *有账号邀请注册最后一步
		 */
		$("#join-success-start-hasAccount").click(function(){
			window.location.href =webCfg.servePath+"/pc/registerv2/inviteHasAccountFinishDo";
		});
	}
	
	
	function setApps(appIds){
		if(appIds){
			 YOP.ajax({
				   url: webCfg.servePath+"/pc/registerv2/step3/doStep3",
				   data: {
						   "appIds":appIds
				   },
				   traditional:true,//解决传到后台是ids[]...
				   cache:false,
				   success: function(data){
					   if(data&&data.succeed){
						   	   window.location.href=webCfg.servePath+"/pc/registerv2/stepFinish?userId="+data.data;
					   }else{
							   Widget.prodialog.alert("确定",data.msg);
					   }
				   }
				 });
		}else{
			Widget.prodialog.alert("确定","服务器内部错误，请传入对应的参数");
		}
		
	}
	
	
	function checkImgValidate(code){
		var ret;
		$.ajax({
			   url: webCfg.servePath+"/pc/checkcode/checkImgValidate",
			   data: {"imgValidate":code
				      },
			   async: false,
			   cache:false,
			   success: function(data){
				   ret= data;
			   }
			 });
		return ret;
	}
	
	function ifUserExist(code){
		var ret;
		$.ajax({
			   url: webCfg.servePath+"/pc/registerv2/ifUserExist",
			   data: {"code":code
				      },
			   async: false,
			   cache:false,
			   success: function(data){
				   ret= data;
			   }
			 });
		return ret;
	}
	function doRegisterLogin(code,userPw){
		var url = "/yop/pc/login/doLogin";
		var param = {
			code: code,
			pass: userPw
		};
		$.ajax({
			   url: url,
			   data: param,
			   async: false,
			   cache:false,
			   success: function(data){
			   }
			 });
	}
	function addMonth(nowDate, n)
	{  
	    var yy = nowDate.getFullYear();
	    var mm = nowDate.getMonth();
	    var dd = nowDate.getDate(); 
	    var dt = new Date(yy, mm, dd); 
	    dt.setMonth(dt.getMonth() + n);
	    var month = parseInt(dt.getMonth()) + 1;
	    return dt.getFullYear() + "-" + month  + "-" + dd;
	}  
	
})();
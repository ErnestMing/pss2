var YOP = YOP || {};
var InterValObj; //timer变量，控制时间
var count = 60; //间隔函数，1秒执行
var curCount;//当前剩余秒数
YOP.validateCodeUtils = (function() {
	//发送验证码
	function sendValidateCode(code,type,imgValidate){
		var isMail=false;
		
		if (code&&type) {
			if("email"==type){
				var result=code.match(/^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/); 
				if(result==null){
					Widget.prodialog. alert("确定","请填写正确的邮箱号");
					return;
				}
			}
			else if("mobile"==type){
				var result=code.match(/^(1)\d{10}$/); 
				if(result==null){
					Widget.prodialog. alert("确定","请填写正确的手机号");
					return;
				}else{
					isMail=true;
				}
			}
		}
		else{
			Widget.prodialog. alert("确定","js传递参数错误");
			return;
		}
		
		//如果是发送手机校验码  需要校验图片校验码
		if(imgValidate&&isMail){
			var ret=checkImgValidate(imgValidate);
			if(!ret.data){
				Widget.prodialog. alert("确定","请输入正确是图片校验码");
				return;
			}
		}
		
		
		
		
		curCount = count;
		//设置button效果，开始计时
		$("#get-verification-code").attr("disabled", "true");
		$("#get-verification-code").html(curCount + "秒后重发");
		
		InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
		 $.ajax({
			   url: webCfg.servePath+"/pc/validateCode/sendValidateCodeByType",
			   data: {"code":code,"type":type,"imgValidate":imgValidate},
			   cache:false,
			   type:"post",
			   success: function(data){
				   if(data&&data.succeed){
					   if(data.type&&"mobile"==data.type){
						   Widget.prodialog. alert("确定","已向您的手机"+code+"发送验证码");
					   }else if(data.type&&"mail"==data.type){
						   Widget.prodialog. alert("确定","已向您的邮箱"+code+"发送验证码");
					   }
					   if(data.uuid){
						   $("#uuid").val(data.uuid);
					   }
				   }else{
						   Widget.prodialog. alert("确定",data.msg);
				   }
			   }
			 });
	}
	//发送验证码
	function sendValidateCodeNoTimer(code,type,$uuidinput,imgValidate){
		var isMail=false;
		if (code&&type) {
			if("email"==type){
				var result=code.match(/^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/); 
				if(result==null){
					Widget.prodialog. alert("确定","请填写正确的邮箱号");
					return false;
				}
			}
			else if("mobile"==type){
				var result=code.match(/^(1)\d{10}$/); 
				if(result==null){
					Widget.prodialog. alert("确定","请填写正确的手机号");
					return false;
				}
				else{
					isMail=true;
				}
			}
		}
		else{
			Widget.prodialog. alert("确定","js传递参数错误");
			return false;
		}
		
		//如果是发送手机校验码  需要校验图片校验码
		if(imgValidate&&isMail){
			var ret=checkImgValidate(imgValidate);
			if(!ret.data){
				Widget.prodialog. alert("确定","请输入正确的图片校验码");
				return false;
			}
		}
		

	return {
		init: function(code,type,imgValidate) {
			sendValidateCode(code,type,imgValidate);
		},
		sendValidateCodeNoTimer:function(code,type,$uuidinput,imgValidate) {
			return sendValidateCodeNoTimer(code,type,$uuidinput,imgValidate);
		},
		checkValidateCode:function(code,uuid,emailOrMobile){
			return checkValidateCode(code,uuid,emailOrMobile);
		},
		clearTime:function(){
			clearTime();
		}
		
	};
})();

var YOP = YOP || {};
YOP.ajax = function(ajaxParam,callback){
	var options = $.extend({cache: false}, ajaxParam);
	  $.ajax(options).done(function(dom) {
		 // console.log(dom);
		  if (callback){
			   callback(dom);
			  } 
			
		}).fail(function(jqXHR, error) {
			//console.log(jqXHR.status);
			if (jqXHR.status == 567) {
				YOP.common.login.open(function(){
					YOP.ajax(ajaxParam,callback);
				});

				
			}
			 //alert(error);
		});
}
YOP.common = {
	init: function() {
		placeholder(".input-placeholder.gray, .input-text.gray", "gray");
		this.preventDefault();
		this.createAccordion();
		this.setMainHeight();
		this.setSideMenuHeight();
		this.showTwoCode();
		this.setInputPlaceholder();
		YOP.common.login.init();
		YOP.common.search.init();
		YOP.common.myAppHeader.init();
		YOP.common.table.init();
		YOP.common.setShadow();
		
		/*YOP.common.login.open(function() {
			console.log("登录成功");
		});*/
	},
	//取消属性为'#'的a标签的默认事件
	preventDefault: function() {
		$("body").on("click", "a[href='#']", function(e) {
			e.preventDefault();
		});
	},
	
	setMainHeight: function() {
		var winH = $(window).height();
		var main = $(".main");
		var headerH = $(".header-wrap").height();
		var mainH = main.height();
		var footerH = $(".footer").height();
		var headerMT = parseInt($(".header-wrap").css("margin-top"));
		var mainMT= parseInt(main.css("margin-top"));
		var mainMB = parseInt(main.css("margin-bottom"));
		var targetH = winH - headerH - footerH - mainMT - mainMB;
		if (mainH < targetH) {
			$(".main").css("min-height", targetH);
		}
 	},
 	
 	setSideMenuHeight: function() {
 		var mainHeight = $(".main").children(".main-content").outerHeight();
 		var sideMenu = $(".main").find(".sidebar");
 		sideMenu.css("min-height", mainHeight);
 	},
	
 	resetShadowHeight: function() {
 		var leftShadow = $(".main-shadow-left");
 		var rightShadow = $(".main-shadow-right");
 		leftShadow.add(rightShadow).css("height", $(".main-my17YOP").outerHeight());
 		console.log($(".main-my17YOP").outerHeight());
 	},
 	
	createAccordion: function() {
		var me = this;
		var menus = $(".sideMenu-block");
		var accordion = {};
		menus.each(function(i) {
			var navElement = $(this).children("dt");
			var token = navElement.attr("data-accordion");
			accordion[token] = new YOP.common.Accordion({
				navElement: navElement,
				open: false
			});
			accordion[token].on("expand", function(e, nav, content) {
				nav.children(".sideMenu-arrow").addClass("sideMenu-arrow-down");
				for (var key in accordion) {
					if (accordion[key] === this) continue;
					accordion[key].collapsing();
				}
			});
			accordion[token].on("expanded", function(e, nav, content) {
				me.resetShadowHeight();
			});
			accordion[token].on("collapsing", function(e, nav, content) {
				nav.children(".sideMenu-arrow").removeClass("sideMenu-arrow-down");
			});
			accordion[token].on("collapsed", function(e, nav, content) {
				me.resetShadowHeight();
			});
		});
		
	},
	
	createLoadingIcon: function(container) {
		var loadingHtml = $('<div class="upload-loading"></div>');
		loadingHtml.appendTo(container);
	},
	
	removeLoadingIcon: function(context) {
		var loadingIcon = context.find(".upload-loading");
		loadingIcon.remove();
	},
	
	showTwoCode: function() {
		var triggerEle = $(".mobileApp-down-btn");
		triggerEle.hover(function() {
			$(this).parent().siblings(".down-code-border").show();
		}, function() {
			$(this).parent().siblings(".down-code-border").hide();
		});
	},
	
	//取消一行里最后一个条目的右外边距
	cancelLastItemMargin: function(items, step) {
		for (var i = step - 1, len = items.length; i < len; i += step) {
			items.eq(i).addClass("no-margin-r");
		}
	},
	
	//设置输入框的点位符
	setInputPlaceholder: function() {
		var broswer = navigator.appName;
		if (broswer === "Netscape") {
			$(".placeholder-label").hide();
			$(".hasPlaceholder").each(function() {
				var targetLabel = $(this).parent().find(".placeholder-label");
				$(this).attr("placeholder", targetLabel.text());
			});
			return;
		}
		$("body").on("focus", ".hasPlaceholder", function() {
			var targetLabel = $(this).parent().find(".placeholder-label");
			targetLabel.hide();
		});
		$("body").on("blur", ".hasPlaceholder", function() {
			if ($.trim($(this).val()).length === 0) {
				$(this).parent().find(".placeholder-label").show();
			}
		});
	}
};

//折叠菜单
YOP.common.Accordion = function(opts) {
	this.navElement = opts.navElement;
	this.open = opts.open;
	this.init();
}
YOP.common.Accordion.prototype = $.extend({
	init: function() {
		var me = this;
		this.contentPanel = this.getContentPanel();
		//if (this.contentPanel.length == 0) return;
		this.navElement.click(function() {
			if (me.contentPanel.is(":hidden")) {
				me.expand();
			} else {
				me.collapsing();
			}
		});
		if (this.open) {
			this.expand();
		}
	},
	expand: function() {
		var me = this;
		this.contentPanel.slideDown(function() {
			me.trigger("expanded", me.navElement, me.contentPanel);
		});
		this.trigger("expand", this.navElement, this.contentPanel);
	},
	collapsing: function() {
		var me = this;
		this.contentPanel.slideUp(function() {
			me.trigger("collapsed", me.navElement, me.contentPanel);
		});
		this.trigger("collapsing", this.navElement, this.contentPanel);
	},
	getContentPanel: function() {
		var navTarget = this.navElement.attr("data-accordion");
		var contentPanel = $("[data-accordion='" + navTarget + "']").not(this.navElement);
		return contentPanel;
	}
}, PubSub);

//标签页切换
YOP.common.Tab = function(opts) {
	this.navElements = opts.navElements;
	this.navClassName = opts.navClassName;
	this.initTab = opts.initTab || $(this.navElements).eq(0);
	this.currentTab = null;
	this.currentContent = null;
	Observer.call(this);
	this.init();
};
extend(YOP.common.Tab, Observer);
YOP.common.Tab.prototype.init = function() {
	this.currentTab = this.initTab;
	this.changeTab(this.initTab);
	this.handleEvents();
};
YOP.common.Tab.prototype.handleEvents = function() {
	var me = this;
	this.navElements.click(function() {
		me.changeTab($(this));
	});
};
YOP.common.Tab.prototype.changeTab = function(triggerEle) {
	var tabFlag = triggerEle.attr("data-tab");
	this.currentTab.removeClass(this.navClassName);
	triggerEle.addClass(this.navClassName);
	this.currentTab = triggerEle;
	this.currentContent ? this.currentContent.hide() : "";
	this.currentContent = $('[data-tab-content=' + tabFlag + ']');
	this.currentContent.show();
	this.trigger("change", triggerEle, this.currentContent);
};
/*YOP.common.Tab = function(opts) {
	this.navElements = opts.navElements;
	this.navClassName = opts.navClassName;
	this.initTab = opts.initTab || this.navElements.eq(0);
	this.currentTab = null;
	this.currentContent = null;
	this.init();
}
YOP.common.Tab.prototype = $.extend({
	init: function() {
		this.currentTab = this.initTab;
		this.changeTab(this.initTab);
		this.handleEvents();
	},
	handleEvents: function() {
		var me = this;
		this.navElements.click(function() {
			me.changeTab($(this));
		});
	},
	changeTab: function(triggerEle) {
		var tabFlag = triggerEle.attr("data-tab");
		this.currentTab.removeClass(this.navClassName);
		triggerEle.addClass(this.navClassName);
		this.currentTab = triggerEle;
		this.currentContent ? this.currentContent.hide() : "";
		this.currentContent = $('[data-tab-content=' + tabFlag + ']');
		this.currentContent.show();
		this.trigger("change", triggerEle, this.currentContent);
	}
}, PubSub);*/

//登录窗口
YOP.common.login = (function() {
	var loginVaildator;
	var successCallback;
	//自定义弹窗HTML
	function createLoginHtml() {
		var html = [
		            '<div class="Widget-prodialog-head">',
		            	'<h2><em></em><span class="close">close</span></h2>',
		            '</div>',
		            '<form class="login-panel login-panel-dialog f14 black bc">',
			            '<div class="login-input">',
				            '<p class="input-row clearfix">',
				            	'<span class="error-label" data-errorFrom="login-userName"></span>',
				            	'<span class="input-icon input-icon-user float-l"></span>',
								'<span class="input-item-wrap float-l pos-r">',
									'<label class="placeholder-label" for="login-userName">用户名</label>',
									'<input type="text" class="input-text-v2 input-required hasPlaceholder" name="login-userName" id="login-userName" />',
								'</span>',
							'</p>',
							'<p class="input-row clearfix">',
								'<span class="error-label" data-errorFrom="login-password"></span>',
								'<span class="input-icon input-icon-lock float-l"></span>',
								'<span class="input-item-wrap float-l pos-r">',
									'<label class="placeholder-label" for="login-password">密码</label>',
									'<input type="password" class="input-text-v2 hasPlaceholder" name="login-password" id="login-password" />',
								'</span>',
							'</p>',
							'<p class="input-row login-fail-msg red hide">用户名或密码错误！</p>',
							'<p class="input-row login-input-row-btn">',
								'<a href="#" class="btn-v2 reg-submit f14" id="login-dialog-submit">登录</a>',
							'</p>',
							'<p class="clearfix">',
								'<span class="float-l">',
									'<label><input type="checkbox" name="autoLogin" id="checkbox-remember-userName" />记住账号</label>',
								'</span>',
								'<a href="/yop/pc/login/findpwd/step1" class="float-r green-v2" id="forgetPwd">忘记密码？</a>',
							'</p>',
		            '</form>'
		            ];
		return html.join("");
	}
	
	function createLoginHandleHtml(userId) {
		var html = [
					'<div class="Widget-prodialog-head">',
						'<h2><em></em><span class="close">close</span></h2>',
					'</div>',
					'<div class="loginHandlePanel">',
						'<div class="to-enterprise-list bc f14">',
						'</div>',
						/*'<div class="loginHandle-msg f16">',
							'<p class="black">请您选择您所属的公司，如果您还没有所属的公司，请进行下面的操作：</p>',
							'<p class="loginHandle-other f14">',
								'<a href="/yop/pc/registerv2/step2?userId='+userId+'&cmd=create" class="btn－v2 loginHandle-btn">创建公司</a>',
								'<a href="/yop/pc/registerv2/step2?userId='+userId+'&cmd=join" class="btn-v2 loginHandle-btn">加入公司</a>',
							'</p>',
						'</div>',*/
					'</div>'
		            ];
		
		return html.join("");
	}
	
	function createEnterpriseItem(enterprises) {
		var itemStr = "";
		for (var i = 0; i < enterprises.length; i++) {
			itemStr += '<a href="#" class="to-enterprise-item to-enterprise-dialog btn-v2" data-id="' + enterprises[i].id + '">'; 
			itemStr +=  	'<p class="to-enterprise-name tl">' + enterprises[i].name + '</p>';
			itemStr +=  	'<p class="to-enterprise-numOfPeople-dialog tr">企业人数：' + enterprises[i].userCount + '人</p>';
			itemStr += '</a>';
		}
		$(".loginHandlePanel").find(".to-enterprise-list").append(itemStr);
		$(".to-enterprise-item:first").addClass("to-enterprise-item-first btn-v2-red");
	}
	
	function openLoginWinow() {
		Widget.prodialog({
			target : $(this),
			overlay : true,
			screenCenter : true,
			title : "登录",
			width : 380,
			close: {
				fn: function() {
					
				}
            },
            submitFn: function(btn, dialogEl, overlay) {
            	
            	//return true;
            },
			content : createLoginHtml()
		});
		YOP.common.setInputPlaceholder();
		setUserName();
	}
	
	function setUserName() {
		var userName = cookie.read("_SAAS_CODE");
		$("#login-userName").val(userName || "");
	}
	
	function openLoginHandleWin(enterprises,userId) {
		Widget.prodialog({
			target : $(this),
			overlay : true,
			screenCenter : true,
			title : "选择公司",
			width : 430,
			close: {
				fn: function() {
					
				}
            },
            submitFn: function(btn, dialogEl, overlay) {
            	
            	//return true;
            },
			content : createLoginHandleHtml(userId)
		});
		if (enterprises.length === 0) return;
		createEnterpriseItem(enterprises);
		
	}
	
	/*function closeDialog(dialogEl, overlay) {
		$(dialogEl).remove();
		$(overlay).remove();
	}*/
	function closeDialog() {
		$(".Widget-prodialog-head .close").click();
	}
	
	function showLoginName(userName) {
		var nameEle = $('<span class="header-userName">' + userName + '</span>');
		$(".header-ul-l").remove();
		nameEle.appendTo(".h-navBar-l");
	}
	
	function showLoginFail() {
		$(".fail-msg").show();
	}
	
	function hideFailMsg() {
		var failMsg = $(".fail-msg");
		if (failMsg.is(":visible")) {
			failMsg.hide();
		}
	}
	
	function validLoginForm() {
		loginVaildator = $(".login-panel").validate({
			rules: {
				"login-userName": {
					required: true
				},
				"login-password": {
					required: true
				}
			}
		});
	}
	
	function changeHeader() {
		var url = "/yop/pc/login/header";
		$.post(url, function(result) {
			$(".header-wrap").replaceWith(result);
		});
	}
	
	function submitLoginInfo() {
		var url = "/yop/pc/login/doLogin";
		var userName = $("#login-userName").val();
		var userPw = $("#login-password").val();
		var isAutoLogin = $("#checkbox-remember-userName").attr("checked") ? true : false;
		var param = {
			code: userName,
			pass: userPw,
			autoLogin: isAutoLogin
		};
		
		$.post(url, param, function(result) {
			if (result.succeed) {
				closeDialog();
				//showLoginName(result.data.code);
				//changeHeader();
				if (!result.data.currentTenant) {
					openLoginHandleWin(result.data.tenantList,result.data.id);
				}
				
				if (successCallback && result.data.currentTenant) {
					successCallback();
				}
			} else {
				showLoginFail();
			}
		});
	}
	
	function handleSelect(triggerEle) {
		var url = "/yop/pc/login/choose/tenant/";
		var enterpriseId = triggerEle.attr("data-id");
		var container = $(".to-enterprise-list");
		url += enterpriseId;
		$.post(url, function(result) {
			YOP.common.removeLoadingIcon(container);
			triggerEle.show().addClass("enterprise-active");
			$(".Widget-prodialog-head").find(".close").click();
			if (successCallback && result.data) {
				successCallback();
			}
			/*container.append('<p class="red">选择公司成功！</p>');
			setTimeout(function() {
				$(".Widget-prodialog-head").find(".close").click();
			}, 1000);*/
		});
		container.children().hide();
		YOP.common.createLoadingIcon(container);
	}
	
	function bindEvents() {
		/*$("#header-login").click(function() {
			openLoginWinow();
			validLoginForm();
		});*/
		
		$("body").on("click", "#login-dialog-submit", function() {
			hideFailMsg();
        	if (!loginVaildator.form()) return;
        	submitLoginInfo();
		});
		
		$("body").on("click", ".to-enterprise-dialog", function() {
			handleSelect($(this));
		});
		
		$(document).on("click",".j-go-tenant",function(){
			$that = $(this);
			var url = "/yop/pc/login/choose/tenant/";
			var tenantId =  $(this).data("id");
			url += tenantId;
			var goback ="/yop/pc/personal/myapp";
			if ($that.data("goback")) {
				goback = $that.data("goback");
			}
			$.post(url, function(result) {
				if (result && result.succeed) {
					window.location = goback;
				}
			},"json");
		 
		});
		
		//回车键登录
		$(window).keypress(function(event) {
			if ($(".login-panel-dialog").length === 0) return;
			if (event.keyCode === 13) {
				$(".submit-fn").click();
			}
		});
	}
	
	return {
		init: function() {
			bindEvents();
		},
		open: function(callback) {
			openLoginWinow();
			validLoginForm();
			if (typeof callback === "function") {
				successCallback = callback;
			}
		},
		validLoginForm: validLoginForm,
		getLoginVaildator: function() {
			return loginVaildator;
		},
		showLoginFail: showLoginFail,
		hideFailMsg: hideFailMsg,
		openLoginHandleWin: openLoginHandleWin
	};
})();

//表单验证的全局设置
YOP.common.setValidator = (function() {
	$.validator.setDefaults({
		highlight: function(element) {
			$(element).addClass("input-error");
		},
		errorPlacement:function(error, element) {  
			$("[data-errorFrom=" + element.attr("name") + "]").html(error);
		},
		success: function(label, element) {
			$(element).removeClass("input-error");
			$(".error-label[data-errorfrom=" + $(element).attr("name") + "]").empty();
		}
	});
	/*$.validator.setDefaults({
		highlight: function(element) {
			$(element).addClass("input-error");
		},
		success: function(label, element) {
			$(element).removeClass("input-error");
		},
		errorPlacement:function(error, element) {  
			//error.appendTo(element.parent().find(".error-label"));
			element.parent().find(".error-label").html(error);
			
	   } 
	});*/
})();

//添加表单验证规则
YOP.common.addValidRules = (function() {
	$.validator.addMethod("myRequired", function(value, element, params) {
		var defaultValue = element.defaultValue;
		if ($(element).val() === defaultValue && $(element).hasClass("gray")) {
			return false;
		} else {
			return true;
		}
		
	}, $.validator.format("请输入内容！"));
	
	$.validator.addMethod("isMoblie", function(value, element, params) {
		if (value === "") return true;
		var pattern = /^(1)\d{10}$/;
		var value = $(element).val();
		return pattern.test(value);
		
	}, $.validator.format("请输入正确的手机号！"));
	
	$.validator.addMethod("isPhoneNum", function(value, element, params) {
		if (value === "") return true;
		var patterns = {
				pattern: /^0\d{2,3}-\d{7,8}$/,
				mobliePattern: /^(1)\d{10}$/
			};
			for (var key in patterns) {
				if (patterns[key].test(value)) return true;
			}
			return false;
	}, $.validator.format("请输入正确的电话号码！"));
	
	$.validator.addMethod("isWechat", function(value, element, params) {
		if (value === "") return true;
		var pattern = /^[a-zA-Z\d_]{5,}$/;
		var value = $(element).val();
		return pattern.test(value);
		
	}, $.validator.format("请输入正确的微信号！"));
	
	$.validator.addMethod("emailOrMobile", function(value, element, params) {
		if (value === "") return true;
		var patterns = {
			mPattern: /^(1)\d{10}$/,
			ePattern: /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/
		};
		for (var key in patterns) {
			if (patterns[key].test(value)) return true;
		}
		return false;
	}, $.validator.format("请输入正确的邮箱或手机号！"));
	
	$.validator.addMethod("myPassword", function(value, element, params) {
		var pattern = /^[a-zA-Z0-9]{6,14}$/;
		var contents = value.split("");
		var subPattern = /\d/;
		if (!/\d/.test(contents[0])) {
			subPattern = /[a-zA-Z]/;
		}
		if (pattern.test(value)) {
			for (var i = 0, len = contents.length; i < len - 1; i++) {
				if (subPattern.test(contents[i]) != subPattern.test(contents[i + 1])) return true;
			}
		}
		return false;
	}, $.validator.format("请输入6-14位数字+字母的组合密码！"));
	
	$.validator.addMethod("isEmail", function(value, element, params) {
		if (value === "") return true;
		var pattern = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/
		var value = $(element).val();
		return pattern.test(value);
	}, $.validator.format("请输入有效的电子邮件"));

	$.validator.addMethod("fax", function(value, element, params) {
		if (value === "") return true;
		var pattern = /(^[0-9]{3,4}-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^([0-9]{3,4})[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)/
		var value = $(element).val();
		return pattern.test(value);
	}, $.validator.format("请输入有效的传真"));

	$.validator.addMethod("postCode", function(value, element, params) {
		if (value === "") return true;
		var pattern =  /^[0-9]{6}$/
		var value = $(element).val();
		return pattern.test(value);
	}, $.validator.format("请输入有效的邮编"));
})();

//ajax获取服务器端数据
YOP.common.serverData = (function() {
	function requestData(opts) {
		var url = opts.url;
		var param = opts.param;
		var dataContainer = opts.renderTo;
		$.post(url, param, function(result) {
			renderData(dataContainer, result);
			if (typeof opts.callback === 'function') {
				opts.callback(result);
			}
		});
	}
	
	function renderData(container, data) {
		container.html(data);
	}
	
	return {
		request: requestData
	}
	
})();

//搜索
YOP.common.search = (function() {
	var searchValidator;
	
	function getSearchParam(searchBtn) {
		var form = searchBtn.parents(".search-form-main");
		var formElements = form.find("input, select");
		var param = {};
		formElements.each(function() {
			var elementType = $(this).attr("type");
			if (elementType === "radio" || elementType === "checkbox") {
				if (!$(this).is(":checked")) return;
			}
			if (elementType === "submit"
				|| elementType === "button") return;
			var value = $.trim($(this).val());
			var elementName = $(this).attr("name");
			if (elementType === "text") {
				value = filterInputVal($(this));
			}
			param[elementName] = value;
		});
		return param;
	}
	
	function handleNotFound(result) {
		var table = $(result);
		var tr = table.find("tr");
		if (tr.length <= 1) {
			$(".data-result").html('<p class="search-notFound-msg red tc">没有找到符合条件的内容！</p>');
		}
	}
	
	function validSearchForm() {
		searchValidator = $(".search-form-main").validate({
			rules: {
				"startDate": {
					dateISO: true
				},
				"endDate": {
					dateISO: true
				},
				"amountStart": {
					number: true,
					min: 0
				},
				"amountEnd": {
					number: true,
					min: 0
				}
			}
		});
	}
	
	//validSearchForm();
	
	function isPassValid(searchBtn) {
		var formElements = searchBtn.parents(".search-form-main").find("input[type=text]");
		for (var i = 0, len = formElements.length; i < len; i++) {
			if (formElements.eq(i).hasClass("input-error")
				&& formElements.eq(i)[0].value != formElements.eq(i)[0].defaultValue
				) break;
		}
		if (i === len) {
			return true;
		} else {
			return false;
		}
	}
	
	function setHotWordSearch(triggerEle) {
		var searchText = triggerEle.text();
		$(".header-main-r").find(".search-input").val(searchText);
		$(".search-btn-header").click();
	}
	
	function bindEvents() {
		$(".search-btn").not(".search-btn-header").click(function() {
			//if (!searchValidator.form()) return;
			if (!isPassValid($(this))) return;
			var submitData = getSearchParam($(this));
			var url = $(this).data("url");
			//console.log(submitData);
			YOP.common.serverData.request({
				url: url,
				param: submitData,
				renderTo: $(".data-result"),
				callback: handleNotFound
			});
		});
		
		$(".search-btn-header").click(function(e) {
			/*Widget.prodialog.alert("提示框", "抱歉，此功能暂不能使用！");
			e.preventDefault();*/
			$("#searchForm").submit();
		});
		
		$(".s-hotWord-item").click(function() {
			setHotWordSearch($(this));
		});
	}
	
	return {
		init: function() {
			bindEvents();
			validSearchForm();
		}
	}
})();

//我的应用头部
YOP.common.myAppHeader = (function() {
	function handleEvent() {
		$("#addFavorites").click(function() {
			addFavorite("17YOP");
		});
		
		$("#setIndex").click(function() {
			setHome(this);
		});
	}
	return {
		init: function() {
			handleEvent();
		}
	};
})();

//顶部导航条
YOP.common.topNavbar = (function() {
	var navLine;
	
	function initNavStyle(navLineSelector) {
		var targetNav = $(".nav-active");
		targetNavLine = targetNav.prev(navLineSelector).add(targetNav.next(navLineSelector));
		targetNavLine.css({
			"color": "#01b9ff"
		});
	}
	
	function activeNavStyle(triggerEle, navLineSelector) {
		var prevLine = triggerEle.prev(navLineSelector);
		var nextLine = triggerEle.next(navLineSelector);
		//var prevLine;
		/*if (triggerEle.prev(navLineSelector).is(":visible")) {
			prevLine = triggerEle.prev(navLineSelector)
		}
		if (triggerEle.next(navLineSelector).is(":visible")) {
			navLine = triggerEle.next(navLineSelector).add(prevLine);
		}*/
		if (prevLine.prev().hasClass("nav-active")) {
			navLine = nextLine;
		} else if (nextLine.next().hasClass("nav-active")) {
			navLine = prevLine;
		} else {
			navLine = prevLine.add(nextLine);
		}
		//navLine = triggerEle.prev(".index-nav-line").add(triggerEle.next(".index-nav-line"));
		
		navLine.css({
			"color": "#01b9ff"
		});
		triggerEle.addClass("nav-active");
	}
	
	function removeNavStyle(triggerEle) {
		navLine.css({
			"color": "#fff"
		});
		triggerEle.removeClass("nav-active");
	}
	
	function handleEvent(navItem, navLineSelector) {
		navItem.hover(function() {
			activeNavStyle($(this), navLineSelector);
		}, function() {
			removeNavStyle($(this), navLineSelector);
		});
	}
	return {
		init: function(navItem, navLineSelector) {
			initNavStyle(navLineSelector);
			handleEvent(navItem, navLineSelector);
		}
	};
})();

//右侧操作条
YOP.common.returnTop = (function() {
	
	function returnTop() {
		$("html,body").animate({
			scrollTop: 0
		}, 200);
	}
	
	function handleEvents(returnBtn) {
		returnBtn.click(function() {
			returnTop();
		});
	}
	
	return {
		init: function(returnBtn) {
			handleEvents(returnBtn);
		}
	};
})();

YOP.common.scrollFix = (function() {
	var target,
		offsetTop,
		offsetLeft,
		oldStyle;

	function getOldPositionInfo(fixTarget) {
		target = fixTarget;
		offsetTop = target.offset().top;
		offsetLeft = target.offset().left;
		oldStyle = target.attr("style");
	}
	
	function getVCenterValue() {
		var winHeight = $(window).height();
		var targetHeight = target.height();
		var top = (winHeight - targetHeight) / 2;
		return top;
	}
	
	function fixTarget(top) {
		var scrollTop = $(window).scrollTop();
		var topVal  = top || "10px";
		if (top === "middle") {
			topVal = getVCenterValue();
		}
		if (scrollTop >= offsetTop) {
			target.css({
				position: "fixed",
				top: topVal,
				left: offsetLeft
			});
		} else {
			target.removeAttr("style");
			target.attr("style", oldStyle);
			
		}
	}
	
	return {
		init: function(opts) {
			getOldPositionInfo(opts.target);
			$(window).scroll(function() {
				fixTarget(opts.top);
			});
			$(window).resize(function() {
				fixTarget(opts.top);
			});
		}
	}
	
})();

YOP.common.sidebarHandler = (function() {
	var telIcon,
		telIconOldLeft,
		sidebarOffsetTop;
	function getTelIconOldInfo() {
		telIcon = $(".side-telNum");
		telIconOldLeft = telIcon.css("left");
	}
	
	
	function showTelIcon() {
		var iconWidth = telIcon.width();
		telIcon.show();
		telIcon.animate({
			left: "-" + iconWidth
		}, 200);
	}
	
	function hideTelIcon() {
		telIcon.hide();
		telIcon.css("left", telIconOldLeft);
	}
	
	function displayReturnTopBtn() {
		var scrollTop = $(window).scrollTop();
		var returnTopBtn = $("#handle-sidebar-returnTop");
		if (scrollTop >  sidebarOffsetTop) {
			returnTopBtn.css("display", "inline-block");
		} else {
			returnTopBtn.hide();
		}
	}
	
	function handleEvents() {
		$("#handle-sidebar-tel").hover(function() {
			showTelIcon();
		}, function() {
			hideTelIcon();
		});
		
		$(window).scroll(function() {
			displayReturnTopBtn();
		});
	}
	
	return {
		init: function() {
			sidebarOffsetTop = $(".handle-sidebar").offset().top;
			getTelIconOldInfo();
			handleEvents();
			//滚动时固定侧边条
			YOP.common.scrollFix.init({
				target: $(".handle-sidebar"),
				top: "middle"
			});
			//返回顶部
			YOP.common.returnTop.init($("#handle-sidebar-returnTop"));
		}
	};
})();

//设置表格条纹
YOP.common.table = (function() {
	return {
		init: function() {
			var target = $(".table-stripes");
			target.children("tbody").children("tr:odd").addClass("tr-stripes");
			
		}
	};
	
	
})();

//设置my17YOP的阴影背景
YOP.common.setShadow = function() {
	var context = $(".main-my17YOP");
	var mainHeight = context.outerHeight();
	var topShadow = $('<div class="main-shadow main-shadow-top"></div>');
	var leftShadow = $('<div class="main-shadow main-shadow-left"></div>');
	var rightShadow = $('<div class="main-shadow main-shadow-right"></div>');
	leftShadow.add(rightShadow).css("height", mainHeight);
	context.append(topShadow, leftShadow, rightShadow);
};

//下拉选择树
YOP.common.selectTree = (function() {
	var container,
		containerSelector,
		input,
		inputSelector;
	function getData(url) {
		YOP.ajax({
			url :  url,
			dataType : "json"
		}, function(result) {
			createTree(container, result);
			handleTreeEvents();
		});
	}
	
	function setSelectedDeptVal(node) {
		input.focus();
		input.val(node.text).attr("data-selectedId", node.id);
	}
	
	function handleTreeEvents() {
		container.on('changed.jstree', function (e, data) {
			if (data.node.id === "root") return;
			setSelectedDeptVal(data.node);
			container.hide();
		});
		
		input.click(function() {
			container.show();
		});
		
		$("body").on("click", function(e) {
			if ($(e.target).attr("id") === inputSelector
				|| $(e.target).attr("id") === containerSelector
				|| $(e.target).parents(containerSelector).length > 0
				|| $(e.target).hasClass("jstree-ocl")) return;
			container.hide();
		});
	}
	
	function createTree(container, data) {
		container.jstree({
			'plugins': ["wholerow"],
            'core': {
            	"multiple" : false,
                'themes': {
                    'icons': false
                },
                "check_callback" : true,
                'data': data
            }
        });
	}
	
	return {
		create: function(url, inputIdSelector, containerIdSelector) {
			container = $("#" + containerIdSelector);
			containerSelector = containerIdSelector;
			input = $("#" + inputIdSelector);
			inputSelector = inputIdSelector;
			getData(url);
		}
	};
})();

//窗口滚动时弹窗也随之滚动
YOP.common.dialogScroll = (function() {
	$(window).scroll(function() {
		var dialog = $(".Widget-prodialog");
		var position = dialog.css("position");
		if (dialog.length === 0 || position === "absolute") return;
		if (position === "fixed") {
			var oldTop = $(window).scrollTop() + parseInt(dialog.css("top"));
		}
		dialog.css({
			position: "absolute",
			top: oldTop
		});
	});
})();

//显示和隐藏头部app导航条
YOP.common.showAppNav = function() {
	if (!$(".header-v2-nav-app").attr("data-showNav")) return; 
	$(".header-v2-nav-app").hover(function() {
		$(".appSlider").show();
	}, function(e) {
		var related = e.relatedTarget;
		if ($(related).hasClass("header-v2-shadow")) return;
		$(".appSlider").hide();
	});
};

//立即体验层
YOP.common.explore = (function() {
	var exploreInfoValidate;
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
	function createExplorePhone() {
		exploreInfoValidate = $("#explore-form").validate({
			rules: {
				"explorePhone":{
					isMoblie: true,
					required: true
				}
				
			}
		});
	}

	//初始化在线体验的状态判定准备
	function initExplore(){
		var ifShowDialog=false;
		YOP.ajax({
				   url: webCfg.servePath+"/pc/explore/initExplore",
				   async: false,
				   success: function(data){
				   	ifShowDialog=data;
				   }
				 });
			return ifShowDialog;
	}
	function bindEvents() {  
		$("#nav-explore,#btn-try-ontitle,#btn-explore-v3").bind("click",function(){
			var random=Math.random();
			$("#imgValidatePicExplore").attr("src",webCfg.servePath+"/pc/checkcode/getCodeImg?random="+random);
			if(!initExplore()){
				toggleExploreDiv();
			}
			else{
				window.location=webCfg.servePath+"/pc/explore";
			}
		});
		$("#imgValidateExplore").blur(function(){
			$("#valiP").show();
		});
		$("#imgValidatePicExplore").click(function(){
			var random=Math.random();
			$(this).attr("src",webCfg.servePath+"/pc/checkcode/getCodeImg?random="+random);
		});
		
		
		
		//获取验证码
		$("#explore-getCode").click(function() {
			if (!exploreInfoValidate.form()) return;
			var mobile=$("input[name=explorePhone]").val();
			var imgValidate=$("#imgValidateExplore").val();
			var ret=YOP.validateCodeUtils.sendValidateCodeNoTimer(mobile,"mobile",$("#uuidinput"),imgValidate);
			if(ret){
				$(this).hide();
				$("#explore-countdown").show();
				var num = 59;
				var time = setInterval(function(){
					if (num <= 1) {
						clearInterval(time);
						$("#explore-countdown").hide();
						$("#explore-getCode").show();
						var random=Math.random();
			    		$("#imgValidatePicExplore").attr("src",webCfg.servePath+"/pc/checkcode/getCodeImg?random="+random);
						
					}
					$(".countdown-num").text(num);
					num--;
				},1000);
			}
			
		});
		//立即体验
		$(".btn-header-explore").bind("click",function(){
			var code=$("#input-explore-code").val();
			var mobile=$("input[name=explorePhone]").val();
			var uuid=$("#uuidinput").val();
			if(!code){
				 Widget.prodialog. alert("确定","请输入验证码");
				 return;
			}
			if(!uuid){
				 Widget.prodialog. alert("确定","请先获取验证码");
				 return;
			}
			if(!mobile){
				 Widget.prodialog. alert("确定","请输入手机号");
				 return;
			}
			if(YOP.validateCodeUtils.checkValidateCode(code,uuid,mobile)){
				window.location=webCfg.servePath+"/pc/explore/exploreUnlogin?valiCode="+code+"&uuid="+uuid+"&mobile="+mobile+"";
			}
			
		});
		
		$("#input-explore-phone,#input-explore-code").keyup(function(){
			var phone = $("#input-explore-phone").val();
			var code = $("#input-explore-code").val();
			if(phone.length > 0 && code.length > 0){
				$(".btn-header-explore-disabled").hide();
				$(".btn-header-explore").show();
			}else{
				$(".btn-header-explore").hide();
				$(".btn-header-explore-disabled").show();
			}
		});
		
	}
	
	//动态绑定事件
	function dyBindEvents() {
			//点击选择层以外的地方则关闭选择层
		$("body").on('click',function(e){
			var _con = $('.explore-div');   // 设置目标区域
			if(!_con.is(e.target) && _con.has(e.target).length === 0 ){ 
				if(!$(e.target).hasClass('nav-explore')&&!$(e.target).hasClass('btn-try-ontitle')&&!$(e.target).hasClass('link-experience-v3')){
					_con.removeClass('explore-div-open');
					_con.hide();
				}
				
			}
			
		});
		

	}
	function toggleExploreDiv(){
		if ($(".explore-div").hasClass("explore-div-open")) {
			//目前是显示，隐藏
			$(".explore-div").removeClass("explore-div-open").hide();
		}else{
			$(".explore-div").addClass("explore-div-open").show();
		}
	}
	return {
		init: function() {
			createExplorePhone();
			bindEvents();
			dyBindEvents();
		}
	};
})();

$(function() {
	YOP.common.init();
	YOP.common.showAppNav();
	YOP.common.explore.init();
});

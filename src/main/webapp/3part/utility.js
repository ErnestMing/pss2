
//操作cookie
var cookie = {
	read: function(name) {
		var cookieStr = "; " + document.cookie + "; ";
		var index = cookieStr.indexOf("; " + name + "=");
		if (index != -1) {
			var s = cookieStr.substring(index + name.length + 3, cookieStr.length);
			return unescape(s.substring(0, s.indexOf("; ")));
		} else {
			return null;
		}
	},
	
	set: function(name, value, expires) {
		var expDays = expires * 24 * 60 * 60 * 1000;
		var expDate = new Date();
		expDate.setTime(expDate.getTime() + expDays);
		var expString = expires ? "; expires=" + expDate.toGMTString() : "";
		var pathString = ";path=/";
		document.cookie = name + "=" + escape(value) + expString + pathString; 
	},
	
	del: function(name) {
		var exp = new Date(new Date().getTime() - 1);
		var s = this.read(name);
		if (s != null) {
			document.cookie = name + "=" + s + ";expires=" + exp.toGMTString() + ";path=/";
		}
	}
};


var PubSub = {
	handler: {},
	
	on: function(type, handle) {
		this.handler[type] = this.handler[type] || [];
		this.handler[type].push(handle);
	},
	
	trigger: function() {
		var args = Array.prototype.slice.call(arguments, 0);
		var type = args[0];
		var target = this.handler[type];
		if (!target) return;
		for (var i = 0, len = target.length; i < len; i++) {
			target[i].apply(this, args);
		}
	},
	
	remove: function(type, handle) {
		var target = this.handler[type];
		if (!target) return;
		for (var i = 0, len = target.length; i < len; i++) {
			if (target[i] === handle) {
				target.splice(i, 1);
				break;
			}
		}
	}
};

function Observer() {
	this.handler = {};
}
Observer.prototype = {
	on: function(type, handle) {
		this.handler[type] = this.handler[type] || [];
		this.handler[type].push(handle);
	},
	
	trigger: function() {
		var args = Array.prototype.slice.call(arguments, 0);
		var type = args[0];
		var target = this.handler[type];
		if (!target) return;
		for (var i = 0, len = target.length; i < len; i++) {
			target[i].apply(this, args);
		}
	},
	
	remove: function(type, handle) {
		var target = this.handler[type];
		if (!target) return;
		for (var i = 0, len = target.length; i < len; i++) {
			if (target[i] === handle) {
				target.splice(i, 1);
				break;
			}
		}
	}
};

//命名空间
function namespace(nameObj) {
	var names = nameObj.split(".");
	var targetName = window;
	for (var i = 0; i < names.length; i++) {
		if (typeof targetName[names[i]] === "undefined") {
			targetName[names[i]] = {};
		}
	targetName = targetName[names[i]];
	}
	return targetName;
}

//文本框占位符
function placeholder(inputTarget,cssStyle) {
	$(inputTarget).each(function() {
		if (this.defaultValue != "") {
			$(this).focus(function() {
				if (this.value == this.defaultValue) {
					this.value = "";
					$(this).removeClass(cssStyle);
					}
				});
			$(this).blur(function() {
				if (this.value == "") {
					this.value = this.defaultValue;
					$(this).addClass(cssStyle);
					}
				});
			}
	});
}

//过滤应用了占位符的文本框的值
function filterInputVal(inputEle) {
	var defaultValue = inputEle[0].defaultValue;
	var value = inputEle.val();
	if (value === defaultValue && !inputEle.attr("no-placeholder")) {
		value = null;
	}
	return value;
}

function formatMsDate(ms, ySplit, mSplit, dSplit) {
	var date = new Date();
	date.setTime(ms);
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var day = date.getDate();
	var dateStr = year + ySplit + month + mSplit + day + (dSplit || "");
	return dateStr;
}

function extend(subObj, superObj) {
	function F() {};
	F.prototype = superObj.prototype;
	subObj.prototype = new F();
	subObj.constructor = subObj;
}

//把HTML标签替换为对应的转义符，以防JS注入
function HTMLEnCode(str) {
	var s = "";
	if (str.length == 0) return "";
	s = str.replace(/&/g, "&gt;");
	s = s.replace(/</g, "&lt;");
	s = s.replace(/>/g, "&gt;");
	s = s.replace(/ /g, "&nbsp;");
	s = s.replace(/\'/g, "'");
	s = s.replace(/\"/g, "&quot;");
	s = s.replace(/\n/g, " <br>");
	return s;
}

//添加到收藏夹
function addFavorite(sTitle) {   
	var ctrl = (navigator.userAgent.toLowerCase()).indexOf('mac') != -1 ? 'Command/Cmd': 'CTRL';
	    if (document.all) { //IE类浏览器
	            try {
	                window.external.toString(); //360浏览器不支持window.external，无法收藏
	                window.alert("国内开发的360浏览器等不支持主动加入收藏。\n您可以尝试通过浏览器菜单栏 或快捷键 ctrl+D 试试。");
	            }
	            catch (e){
	                try{
	                    window.external.addFavorite(window.location, sTitle);
	                }
	                catch (e){
	                    window.external.addToFavoritesBar(window.location, sTitle);  //IE8
	                }
	            }
	        }
	        /*else if (window.sidebar) { //firfox等浏览器
	        	window.sidebar.addPanel(sTitle, window.location, "");
	        }*/
	        else {
	        	Widget.prodialog.alert("提示框", '您的浏览器尚不支持该功能，您可以尝试通过快捷键' + ctrl + ' + D 加入到收藏夹。');
	        }
	    
}

//设为首页
function setHome(obj){
	  try{
	    obj.style.behavior='url(#default#homepage)';
	    obj.setHomePage(window.location);
	    Widget.prodialog.alert("提示框", "设置首页成功!");
	  }catch(e){
	   Widget.prodialog.alert("提示框", "抱歉，您所使用的浏览器无法完成此操作。\n\n您需要手动将【"+window.location+"】设置为首页。");
	  }
	}

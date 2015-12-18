<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>企业进销存管理系统</title>
	<link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/skin/default/css/login.css" media="all" />
</head>

<body style="background:#00716B url(${ctx}/skin/default/images/login/bg2.png) no-repeat 50%;">
<form id="login_main" method="post">
<div id="warpbox">
	<div class="main">
		 <div class="zck">
		  <div class="zc">
		  		<div class="zc_line">租户号：
				<input type="text" value="" name="tenantNo" id="tenantNo"
				 onkeyup="showGs(event)"
				 onFocus="this.select();"
				 autocomplete="off" placeholder="请您输入租户账号"/><div id="ts" style="z-index:1;"></div></div>
				<div class="zc_line">用户名：
				<input type="text" value="" name="userName" id="userName"
				 onkeyup="showGs(event)"
				 onFocus="this.select();"
				 autocomplete="off" placeholder="请您输入用户名"/><div id="ts" style="z-index:1;"></div></div>
			    <div class="zc_line">密　码：
				<input type="password" value="" name="password" id="password"
				 onfocus="$('#ts').css('display','none');this.select();"
				 onKeyDown="javascript:if(event.keyCode==13){ submitFind(); }"
				 placeholder="请您输入密码"/></div>
		  </div>
			<div class="dl">
				<input  class="loginImgOut" value="" type="button" onclick="formSubmit('${ctx}/userfmain.action','_self');"
				  onmouseover="this.className='loginImgOver'" 
				  onmouseout="this.className='loginImgOut'"
				/>
				<input class="resetImgOut" value="" type="button"   
				  onmouseover="this.className='resetImgOver'" 
				  onmouseout="this.className='resetImgOut'"
				/>
			</div>
		</div>
		<div class="bqxx" style="text-align:right;margin-top:0px;">
		<a href="#">系统帮助</a> | <a href="#" onclick="bookmarkit();">加入收藏</a>
	    </div>

	  	<div class="mirro"></div>
			<logic:notEmpty name="loginFailed">
				<c:if test="${loginFailed==1}">
					<c:set var="errorInfo" value="你的输入有误, 请重新输入!"/>
				</c:if>
				<c:if test="${loginFailed==2}">
					<c:set var="errorInfo" value="用户名不存在, 请重新输入!"/>
				</c:if>
				<div class="erro" id="erro">
					<div class="erro_intro">
					${errorInfo}
					</div>
				</div>
			</logic:notEmpty>
		</div>
</div>
</form>
<script type="text/JavaScript">
	document.getElementById('login_main').userName.focus();
</script>

</body>
</html>



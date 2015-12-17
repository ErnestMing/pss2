<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>基于SaaS模式的进销存一体化平台</title>
	<link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx }/skin/default/css/login.css" media="all" />
</head>

<body style="background:#00716B url(${ctx}/skin/default/images/login/bg1.png) no-repeat 50%;">
<form id="login_main" method="post">
<div id="warpbox">
	<div class="main">
		 <div class="zck">
		  <div class="zc">
				<div class="zc_line">租户号：
				<input type="text" value="" name="tenantNo" id="tenantNo"
				 onkeyup="showGs(event)"
				 onFocus="this.select();"
				 autocomplete="off" title="请您输入租户账号"/><div id="ts" style="z-index:1;"></div></div>
			    <div class="zc_line">密　码：
				<input type="password" value="" name="password" id="password"
				 onfocus="$('#ts').css('display','none');this.select();"
				 onKeyDown="javascript:if(event.keyCode==13){ submitFind(); }"
				 title="请您输入密码"/></div>
		  </div>
			<div class="dl">
				<input  class="loginImgOut" value="" type="button" onclick="formSubmit('${ctx}/tenantframe.action','_self');"
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
		<a href="#">系统帮助</a> | <a href="${ctx }/toreg.action" onclick="bookmarkit();">租户注册</a>
	    </div>

	  	<div class="mirro"></div>
			<logic:notEmpty name="loginFailed">
				<c:if test="${loginFailed==1}">
					<c:set var="errorInfo" value="租户账号或密码错误, 请重新输入!"/>
				</c:if>
				<c:if test="${loginFailed==2}">
					<c:set var="errorInfo" value="租户账号不存在, 请重新输入!"/>
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



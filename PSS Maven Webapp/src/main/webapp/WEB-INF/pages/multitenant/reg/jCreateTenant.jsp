<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	        <title>基于SaaS模式的进销存一体化平台 </title>
				<link rel="stylesheet" href="${ctx }/3part/base.css" type="text/css">
				<link rel="stylesheet" href="${ctx }/3part/common.css" type="text/css">
				<link rel="stylesheet" href="${ctx }/3part/page.css" type="text/css">
            <link type="text/css" rel="stylesheet" href="${ctx }/3part/reg-login-v2.css">	
    		
				<!-- JS Global Compulsory -->    
				<script src="${ctx }/3part/jquery_003.js"></script>
				<script type="text/javascript" src="${ctx }/3part/utility.js"></script>
				<script type="text/javascript" src="${ctx }/3part/jquery.js"></script>
				<script type="text/javascript" src="${ctx }/3part/common.js"></script>
				<script type="text/javascript" src="${ctx }/3part/page.js"></script>
				<script type="text/javascript">
					function formSubmit(url){
						document.forms[0].action = url ;
						document.forms[0].method = "POST";
						document.forms[0].submit();
					}
				</script>
	    <body>
        	<div class="regAndLogin-main">
        		<div class="main-panel bc">
        			<h2 class="main-panel-header f18 tc">创建租户</h2>
        			<div class="main-panel-content f12">
        				<div class="main-panel-step black" id="main-panel-step-1">
	        				<span class="step-item" id="step-item-1">创建租户</span>
	        				<span class="step-item" id="step-item-2">服务订购</span>
	        				<span class="step-item" id="step-item-3">完成</span>
	        			</div>
	        			<form novalidate="novalidate" class="panel-form bc" type="post" id="regForm-firstStep">
	        				<p class="input-row clearfix">
	        					<span class="input-item-wrap pos-r">
	        						<span class="error-label" data-errorfrom="emailOrMobile">${ error_tenantNo}</span>
	        						<label style="display: none;" class="placeholder-label" for="tenantNo">创建租户账号</label>
	        						<input data-first="true" class="input-text input-required hasPlaceholder imgVali"
	        							 name="tenantNo" value="${obj.tenantNo }" id="tenantNo" type="text">
	        					</span>
	        				</p>
	        				<p class="input-row clearfix">
	        					<span class="input-item-wrap pos-r">
	        						<span class="error-label" data-errorfrom="name">${ error_name}</span>
	        						<label style="display: none;" class="placeholder-label" for="name">填写租户名称</label>
	        						<input class="input-text hasPlaceholder" name="name" value="${obj.name}" type="text">
	        					</span>
	        				</p>
	        				<p class="input-row clearfix">
	        					<span class="input-item-wrap pos-r">
	        						<span class="error-label" data-errorfrom="company">${ error_company}</span>
	        						<label style="display: none;" class="placeholder-label" for="company">填写所属企业</label>
	        						<input class="input-text hasPlaceholder" name="company" value="${obj.company}"  id="company" type="text">
	        					</span>
	        				</p>
	        				<p class="input-row clearfix">
	        					<span class="input-item-wrap pos-r">
	        						<span class="error-label" data-errorfrom="pass">${ error_password}</span>
	        						<label style="display: none;" class="placeholder-label" for="password">用户密码（6-14位数字+字母的组合）</label>
	        						<input placeholder="用户密码（6-14位数字+字母的组合）" class="input-text hasPlaceholder" name="password" 
	        						id="password" type="password">
	        					</span>
	        				</p>
	        				<p class="input-row clearfix">
	        					<span class="input-item-wrap pos-r">
	        						<span class="error-label" data-errorfrom="confirmPass">${error_confirmPass }</span>
	        						<label style="display: none;" class="placeholder-label" for="confirm-password">确认密码</label>
	        						<input placeholder="确认密码" class="input-text hasPlaceholder" name="confirmPass" 
	        						id="confirm-password" type="password">
	        					</span>
	        				</p>
	        				<p class="input-row clearfix">
	        					<span class="input-item-wrap pos-r">
	        						<span class="error-label" data-errorfrom="contractor">${ error_contactor}</span>
	        						<label style="display: none;" class="placeholder-label" for="contactor">联系人</label>
	        						<input class="input-text hasPlaceholder" name="contactor"  value="${obj.contactor}"  id="contractor" type="text">
	        					</span>
	        				</p>
	        				<p class="input-row clearfix">
	        					<span class="input-item-wrap pos-r">
	        						<span class="error-label" data-errorfrom="address">${ error_address}</span>
	        						<label style="display: none;" class="placeholder-label" for="address">详细地址</label>
	        						<input class="input-text hasPlaceholder" name="address" value="${obj.address}"  id="address" type="text">
	        					</span>
	        				</p>
	        				<p class="input-row clearfix">
	        					<span class="input-item-wrap pos-r">
	        						<span class="error-label" data-errorfrom="telphone">${error_telephone}</span>
	        						<label style="display: none;" class="placeholder-label" for="telphone">联系方式</label>
	        						<input class="input-text hasPlaceholder" name="telephone" value="${obj.telephone}"  id="telphone" type="text">
	        					</span>
	        				</p>
	        				<p class="input-row">
	        					<a href="#" class="btn-v2 reg-submit f14" id="reg-step1-submit" onclick="formSubmit('reg.action')">创建租户</a>
	        				</p>
	        			</form>
        			</div>
        			
        		</div>
        	</div>
</body></html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html><head>
	        <title>基于SaaS的进销存一体化平台</title>
	       
    		
				<link rel="stylesheet" href="${ctx }/3part/base.css" type="text/css">
				<link rel="stylesheet" href="${ctx }/3part/common.css" type="text/css">
				<link rel="stylesheet" href="${ctx }/3part/page.css" type="text/css"> 
           		<link type="text/css" rel="stylesheet" href="${ctx }/3part/jquery.css">	
           		<link type="text/css" rel="stylesheet" href="${ctx }/3part/reg-login-v2.css">	
    		
				<script src="${ctx }/3part/b.js" charset="utf-8"></script><script src="${ctx }/3part/v.htm" charset="utf-8"></script><script type="text/javascript" src="${ctx }/3part/jquery_005.js"></script>
				<script type="text/javascript" src="${ctx }/3part/json2.js"></script>
				<script type="text/javascript" src="${ctx }/3part/utility.js"></script>
				<script type="text/javascript" src="${ctx }/3part/jquery_002.js"></script>
				<script type="text/javascript" src="${ctx }/3part/common.js"></script>
				<script type="text/javascript" src="${ctx }/3part/page.js"></script>

	    	
	    <body>
        	<div class="regAndLogin-main">
        		<div class="main-panel bc">
        			<h2 class="main-panel-header f18 tc">完成</h2>
        			<div class="main-panel-content f12" id="panel-content-step-3">
        				<div class="main-panel-step black" id="main-panel-step-3" style="background: url(3part/reg-step-3.png) no-repeat;">
	        				<span class="step-item" id="step-item-1">创建租户</span>
	        				<span class="step-item" id="step-item-2">服务订购</span>
	        				<span class="step-item" id="step-item-3">完成</span>
	        			</div>
	        			<div class="reg-end-content tc f14">
	        				<p class="reg-complete-msg red f18">创建账号完成！</p>
	        				<p>恭喜！您已成功创建“进销存一体化平台”租户账号！</p>
	        				<p>请点击"开始使用",进行系统初始化配置</p>
	        			</div>
	        			<ul class="reg-two-code-list clearfix">
	        				<li id="two-code-ios" class="no-margin-l">
	        					<img src="${ctx }/3part/two-code-ios.png" alt="">
	        				</li>
	        				<li id="two-code-android">
	        					<img src="${ctx }/3part/two-code-android.png" alt="">
	        				</li>
	        				<li id="two-code-wechat">
	        					<img src="${ctx }/3part/two-code-wechat.png" alt="" height="98px" width="98px">
	        				</li>
	        			</ul>
	        			<p class="input-row handle-next tc">
        					<a href="${ctx }/tenantframe2.action" class="btn-v2 reg-submit f14" id="reg-success-start">开始使用</a>
        				</p>
        			</div>
        			
        		</div>
        	</div>
</body></html>
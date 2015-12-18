<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
	<script type="text/javascript" src="${ctx}/components/jquery-ui/jquery-1.2.6.js"></script>
</head>
 
<body id="left_frame">
<div class="PositionFrame_black" id="PositionFrame"></div>
 
 
<!-- begin1  -->
<div id="sidebar" class="sidebar">
	<div class="sidebar_t">
		<div class="sidebar_t_l"></div>
		<div class="sidebar_t_c"></div>
		<div class="sidebar_t_r"></div>
	</div>
        <div class="panel">
        <div class="panel_icon"><img src="${ctx}/skin/default/images/icon/user1_lock.png"/></div>
        <div class="panel-header">
        <div class="panel-title">租户信息</div>
        <div class="panel-content">
			<ul>
				<li><a href="${ctx }/multitenant/tenantadmin/tenant/toview.action?id=${sessionScope.CURTENANT.id}" onclick="linkHighlighted(this)" target="main" id="aa_1">租户信息查看</a></li>
				<li><a href="${ctx }/multitenant/tenantadmin/tenant/toupdate.action?id=${sessionScope.CURTENANT.id}" onclick="linkHighlighted(this)" target="main" id="aa_1">租户信息修改</a></li>
			</ul>
        </div>
        </div>
    </div>
    <div class="sidebar_t">
		<div class="sidebar_b_l"></div>
		<div class="sidebar_t_c"></div>
		<div class="sidebar_b_r"></div>
	</div>  
</div>	



</body>
</html>

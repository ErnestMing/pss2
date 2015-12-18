<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../baselist.jsp" %>
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
        <div class="panel_icon"><img src="${ctx}/skin/default/images/icon/document_into.png"/></div>
        <div class="panel-header">
        <div class="panel-title">采购管理</div>
        <div class="panel-content">
			<ul>
				<li><a href="${ctx}/cargo/purchaseorder/list.action" onclick="linkHighlighted(this)" target="main" id="aa_1">原材料采购</a></li>
				<li><a href="${ctx}/cargo/materialull/list.action" onclick="linkHighlighted(this)" target="main" id="aa_1">原材料上下限</a></li>
				<li><a href="${ctx}/baseinfo/material/list.action" onclick="linkHighlighted(this)" target="main" id="aa_1">原材料信息</a></li>
				<li><a href="${ctx}/baseinfo/supplier/list.action" onclick="linkHighlighted(this)" target="main" id="aa_1">供应商信息</a></li>
				<li><a href="${ctx}/cargo/export/toexport.action" onclick="linkHighlighted(this)" target="main" id="aa_1">报表统计</a></li>
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

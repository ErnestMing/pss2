<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>查看客户信息</title>
     <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
     <script type="text/javascript" src="${ctx}/js/datepicker/WdatePicker.js"></script>
</head>
<body>
<form method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="back"><a href="list.action">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		查看客户信息
    </div> 
    </div>
    </div>
</div>
 
    <div>
			<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">客户编号：</td>
	            <td class="tableContent">${obj.customNo }</td>
	            <td class="columnTitle_mustbe">简称：</td>
	            <td class="tableContent">${obj.shortName }</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">客户名称：</td>
	            <td class="tableContent">${obj.name }</td>
	            <td class="columnTitle_mustbe">联系人：</td>
	            <td class="tableContent">${obj.contacts }</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">地址：</td>
	            <td class="tableContent">${obj.address }</td>
	            <td class="columnTitle_mustbe">邮编：</td>
	            <td class="tableContent">${obj.email }</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">电话：</td>
	            <td class="tableContent">${obj.mobile }</td>
	            <td class="columnTitle_mustbe">传真：</td>
	            <td class="tableContent">${obj.fax }</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">备注：</td>
	            <td class="tableContent">
	            	<textarea name = "memo" style="height:120px;">${obj.memo }</textarea>
	            </td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>
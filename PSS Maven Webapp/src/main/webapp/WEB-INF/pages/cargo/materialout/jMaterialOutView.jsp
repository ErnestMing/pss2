<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>查看出库单信息</title>
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
		查看出库单信息
    </div> 
    </div>
    </div>
</div>
 
    <div>
		<table class="commonTable" cellspacing="1">
			<tr>
	            <td class="columnTitle_mustbe">原材料编号：</td>
	            <td class="tableContent">${obj.materialNo }/${obj.materialName }</td>
	            <td class="columnTitle_mustbe">原材料数量：</td>
	            <td class="tableContent">${obj.materialAmount }/${obj.packingUnit}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">领料人：</td>
	            <td class="tableContent">${obj.pickingPeople }</td>
	            <td class="columnTitle_mustbe">操作者：</td>
	            <td class="tableContent">${obj.operator }</td>
	        </tr>
	        <tr>
	      		<td class="columnTitle_mustbe">操作者：</td>
	            <td class="tableContent">${obj.repositoryNo }</td>
	            <td class="columnTitle_mustbe">出库时间：</td>
	            <td class="tableContent">
	            	<fmt:formatDate value='${obj.outTime }' pattern='yyyy-MM-dd'/>
	            </td>
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
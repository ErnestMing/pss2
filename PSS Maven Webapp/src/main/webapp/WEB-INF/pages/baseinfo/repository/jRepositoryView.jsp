<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>查看仓库信息</title>
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
		查看仓库信息
    </div> 
    </div>
    </div>
</div>
 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">仓库编号：</td>
	            <td class="tableContent">${obj.repositoryNo}</td>
	            <td class="columnTitle_mustbe">创建时间：</td>
	            <td class="tableContent">
	            	<fmt:formatDate value="${obj.createTime}" pattern="yyyy-MM-dd"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">仓库名称：</td>
	            <td class="tableContent">${obj.name}</td>
	            <td class="columnTitle_mustbe">仓库缩写：</td>
	            <td class="tableContent">${obj.shortName}</td>
	        </tr>
	          <tr>
	        	<td class="columnTitle_mustbe">仓库类别：</td>
	            <td class="tableAutoContent">
					<c:if test="${obj.type == '1'}">原材料仓库</c:if>
					<c:if test="${obj.type == '2'}">货物仓库</c:if>					
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">仓库位置：</td>
	            <td class="tableContent">${obj.location}</td>
	            <td class="columnTitle_mustbe">仓库面积：</td>
	            <td class="tableContent">${obj.area}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">仓库备注：</td>
	            <td class="tableContent">
	            	<textarea name = "memo" style="height:120px;" readonly="true">${obj.memo }</textarea>
	            </td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>


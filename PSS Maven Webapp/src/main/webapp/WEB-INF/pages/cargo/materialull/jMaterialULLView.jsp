<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>查看原材料上下限信息</title>
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
		查看原材料上下限信息
    </div> 
    </div>
    </div>
</div>
 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">仓库编号：</td>
	            <td class="tableContent">${obj.repositoryNo }</td>
	            <td class="columnTitle_mustbe">上限数量：</td>
	            <td class="tableContent">${obj.upperAmount }/${obj.packingUnit }</td>
	            
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">原材料编号：</td>
	            <td class="tableContent">${ obj.materialNo}</td>
	            <td class="columnTitle_mustbe">下限数量：</td>
	            <td class="tableContent">${obj.lowerAmount }/${obj.packingUnit }</td>
	        </tr>
	        
	        <tr>
	   	     	<td class="columnTitle_mustbe">原材料编号：</td>
	            <td class="tableContent">${ obj.materialName}</td>
	            <td class="columnTitle_mustbe">最佳数量：</td>
	            <td class="tableContent">${obj.bestAmount }/${obj.packingUnit }</td>
	        </tr>
	        <tr>
	        	<td class="columnTitle_mustbe">备注：</td>
	            <td class="tableContent">
	            	<textarea name = "memo" style="height:120px;" readonly="true">${obj.memo}</textarea>
	            </td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>


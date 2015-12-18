<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
     <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
     <script type="text/javascript" src="${ctx}/js/datepicker/WdatePicker.js"></script>
</head>
<body>
<form method="post">

	<input type="hidden" name="id" value="${obj.id}"/>


<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('update.action','_self');">确定</a></li>
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
		修改功能信息
    </div> 
    </div>
    </div>
</div>
 
    <div>
		 <table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">功能编号：</td>
	            <td class="tableContent"><input type="text" name="functionNo" value="${obj.functionNo }"/></td>
	            <td class="columnTitle_mustbe">功能名称：</td>
	            <td class="tableContent"><input type="text" name="functionName"  value="${obj.functionName }"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">功能对应URL：</td>
	            <td class="tableContent"><input type="text" name="functionURL" value="${obj.functionURL }"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">功能描述：</td>
	            <td class="tableContent">
	            	<textarea name = "description" style="height:120px;">${obj.description }</textarea>
	            </td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>


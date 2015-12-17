<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>修改服务价格信息</title>
     <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
     <script type="text/javascript" src="${ctx}/js/datepicker/WdatePicker.js"></script>
     <script type="text/javascript">
     	function setFunctionName(opt){
			var obj = document.getElementById("functionName");
			obj.value = opt.text ; 
     	}
     </script>
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
		修改服务价格
    </div> 
    </div>
    </div>
</div>
 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">策略编号：</td>
	            <td class="tableContent"><input type="text" name="pricepolicyNo" value="${obj.pricepolicyNo }" /></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">对应模块：</td>
	              <td class="tableAutoContent">
	            	<select name="functionNo" onchange="setFunctionName(this.options[this.selectedIndex])">
	            		<option>----请选择----</option>
	            		<c:forEach items="${functionList }" var="f">
	            			<option value="${f.functionNo }" <c:if test="${obj.functionNo == f.functionNo }">selected</c:if>>${f.functionName }</option>
	            		</c:forEach>
	            	</select>
	            	<!-- 模块名称 -->
	            	<input type="hidden" name="functionName" id="functionName" value="${obj.functionName }" />
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">模块价格：</td>
	            <td class="tableContent"><input type="text" name="price" value="${obj.price }" /></td>
	            <td class="columnTitle_mustbe">收费单位：</td>
	            <td class="tableContent"><input type="text" name="unit" value="${obj.unit }" /></td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>


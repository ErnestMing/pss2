<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>修改仓库信息</title>
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
		修改仓库信息
    </div> 
    </div>
    </div>
</div>
 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">仓库编号：</td>
	            <td class="tableContent"><input type="text" name="repositoryNo" value="${obj.repositoryNo }"/></td>
	            <td class="columnTitle_mustbe">创建时间：</td>
	            <td class="tableContent">
	           	 <input type="text" name="createTime"  value="<fmt:formatDate value='${obj.createTime}' pattern='yyyy-MM-dd'/>"  readonly ="true"  style="width:90px;"
	            		onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'})"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">仓库名称：</td>
	            <td class="tableContent"><input type="text" name="name"  value="${obj.name }"/></td>
	            <td class="columnTitle_mustbe">仓库缩写：</td>
	            <td class="tableContent"><input type="text" name="shortName"  value="${obj.shortName }"/></td>
	        </tr>
	          <tr>
	        	<td class="columnTitle_mustbe">仓库类别：</td>
	            <td class="tableAutoContent">
	            	<select name="type">
						<option value="">----请选择----</option>
						<option value="1" <c:if test='${obj.type == "1" }'>selected</c:if>>原材料仓库</option>
						<option value="2" <c:if test='${obj.type == "2" }'>selected</c:if>>货物仓库</option>
	            	</select>
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">仓库位置：</td>
	            <td class="tableContent"><input type="text" name="location"  value="${obj.location }"/></td>
	            <td class="columnTitle_mustbe">仓库面积：</td>
	            <td class="tableContent"><input type="text" name="area"  value="${obj.area }"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">仓库备注：</td>
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


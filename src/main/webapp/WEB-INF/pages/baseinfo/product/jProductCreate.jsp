<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>添加货物信息</title>
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
<li id="save"><a href="#" onclick="formSubmit('insert.action','_self');">确定</a></li>
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
		添加货物信息
    </div> 
    </div>
    </div>
</div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">货物编号：</td>
	            <td class="tableContent"><input type="text" name="productNo" /></td>
	            <td class="columnTitle_mustbe">货物名称：</td>
	            <td class="tableContent"><input type="text" name="name" /></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">条形码：</td>
	            <td class="tableContent"><input type="text" name="barCode" /></td>
	            <td class="columnTitle_mustbe">规格：</td>
	            <td class="tableContent"><input type="text" name="specification" /></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">包装单位：</td>
	            <td class="tableContent"><input type="text" name="packingUnit" /></td>
	            <td class="columnTitle_mustbe">价格：</td>
	            <td class="tableContent"><input type="text" name="price" /></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">描述：</td>
	            <td class="tableContent">
	            	<textarea name = "description" style="height:120px;">
	            	</textarea>
	            </td>
	            <td class="columnTitle_mustbe">备注：</td>
	            <td class="tableContent">
	            	<textarea name = "memo" style="height:120px;">
	            	</textarea>
	            </td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>




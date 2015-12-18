<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>添加客户信息</title>
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
		添加客户信息
    </div> 
    </div>
    </div>
</div>
    <div>
    <table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">客户编号：</td>
	            <td class="tableContent"><input type="text" name="customNo" /></td>
	            <td class="columnTitle_mustbe">简称：</td>
	            <td class="tableContent"><input type="text" name="shortName" /></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">客户名称：</td>
	            <td class="tableContent"><input type="text" name="name" /></td>
	            <td class="columnTitle_mustbe">联系人：</td>
	            <td class="tableContent"><input type="text" name="contacts" /></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">地址：</td>
	            <td class="tableContent"><input type="text" name="address" /></td>
	            <td class="columnTitle_mustbe">邮编：</td>
	            <td class="tableContent"><input type="text" name="email" /></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">电话：</td>
	            <td class="tableContent"><input type="text" name="mobile" /></td>
	            <td class="columnTitle_mustbe">传真：</td>
	            <td class="tableContent"><input type="text" name="fax" /></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">备注：</td>
	            <td class="tableContent">
	            	<textarea name = "memo" style="height:120px;"></textarea>
	            </td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>




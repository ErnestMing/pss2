<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>添加用户信息</title>
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
		添加用户信息
    </div> 
    </div>
    </div>
</div>
    <div>
    <table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">用户编号：</td>
	            <td class="tableContent"><input type="text" name="userNo" style="width:200px;" /></td>
	            <td class="columnTitle_mustbe">用户密码：</td>
	            <td class="tableContent"><input type="text" name="password" style="width:200px;" /></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">联系方式：</td>
	            <td class="tableContent"><input type="text" name="telephone"  /></td>
	            <td class="columnTitle_mustbe">邮箱：</td>
	            <td class="tableContent"><input type="text" name="email"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">地址：</td>
	            <td class="tableContent"><input type="text" name="address" style="width:400px;" /></td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>




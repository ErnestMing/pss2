<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>修改租户信息</title>
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
		修改租户信息
    </div> 
    </div>
    </div>
</div>
    <div>
		 <table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">租户编号：</td>
	            <td class="tableContent"><input type="text" name="tenantNo" style="width:200px;" value = "${obj.tenantNo }" /></td>
	            <td class="columnTitle_mustbe">租户密码：</td>
	            <td class="tableContent"><input type="text" name="password" style="width:200px;" value = "${obj.password }" /></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">租户名称：</td>
	            <td class="tableContent"><input type="text" name="name"   value = "${obj.name }"/></td>
	            <td class="columnTitle_mustbe">所属企业：</td>
	            <td class="tableContent"><input type="text" name="company"  value = "${obj.company }"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">联系人：</td>
	            <td class="tableContent"><input type="text" name="contactor" value = "${obj.contactor}"  style="width:400px;" /></td>
	            <td class="columnTitle_mustbe">联系电话：</td>
	            <td class="tableContent"><input type="text" name="telephone" value = "${obj.telephone}"  style="width:400px;" /></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">地址：</td>
	            <td class="tableContent"><input type="text" name="address" value = "${obj.address}"  style="width:400px;" /></td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>


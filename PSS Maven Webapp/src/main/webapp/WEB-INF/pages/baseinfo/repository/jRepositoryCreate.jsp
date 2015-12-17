<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>添加仓库信息</title>
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
		添加仓库信息
    </div> 
    </div>
    </div>
</div>
 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">仓库编号：</td>
	            <td class="tableContent"><input type="text" name="repositoryNo" /></td>
	            <td class="columnTitle_mustbe">创建时间：</td>
	            <td class="tableContent">
	           	 <input type="text" name="createTime"  readonly ="true"  style="width:90px;"
	            		onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'})"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">仓库名称：</td>
	            <td class="tableContent"><input type="text" name="name" /></td>
	            <td class="columnTitle_mustbe">仓库缩写：</td>
	            <td class="tableContent"><input type="text" name="shortName" /></td>
	        </tr>
	        <tr>
	        	<td class="columnTitle_mustbe">仓库类别：</td>
	            <td class="tableAutoContent">
	            	<select name="type">
						<option value="">----请选择----</option>
						<option value="1" >原材料仓库</option>
						<option value="2" >货物仓库</option>
	            	</select>
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">仓库位置：</td>
	            <td class="tableContent"><input type="text" name="location"/></td>
	            <td class="columnTitle_mustbe">仓库面积：</td>
	            <td class="tableContent"><input type="text" name="area"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">仓库备注：</td>
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


<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>新增原材料入库单</title>
     <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
     <script type="text/javascript" src="${ctx}/js/datepicker/WdatePicker.js"></script>
     <script type="text/javascript">
 		function setMaterialName(opt){
		 var obj = document.getElementById("materialName");
		 obj.value = opt.text ; 
		}
     </script>
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
		新增原材料入库单
    </div> 
    </div>
    </div>
</div>
    <div>
    	<table class="commonTable" cellspacing="1">
    		<tr>
	            <td class="columnTitle_mustbe">原材料：</td>
	            <td class="tableAutoContent">
	            	<select name="materialNo" onchange="setMaterialName(this.options[this.selectedIndex])">
						<option value="">----请选择----</option>
						<c:forEach items="${materialList}" var="s">
							<option value="${s.materialNo}" >${s.name }</option>
						</c:forEach>	  
	            	</select>
	            	<!-- 原材料名称 -->
	            	<input type="hidden" name="materialName" id = "materialName"/>
	            </td>
	            <td class="columnTitle_mustbe">原材料数量：</td>
	            <td class="tableContent"><input type="text" name="materialAmount" /></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">经办人：</td>
	            <td class="tableContent"><input type="text" name="operator" /></td>
	            <td class="columnTitle_mustbe">入库仓库：</td>
	            <td class="tableContent">
	            	<select name="repositoryNo">
						<option value="">----请选择----</option>
						<c:forEach items="${repositoryList}" var="s">
							<option value="${s.repositoryNo}" >${s.name }</option>
						</c:forEach>	  
	            	</select>
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">入库时间：</td>
	            <td class="tableContent">
	            	<input type="text" name="putTime" readonly ="true"  style="width:90px;"
	            		onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'})"/>
	            </td>
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




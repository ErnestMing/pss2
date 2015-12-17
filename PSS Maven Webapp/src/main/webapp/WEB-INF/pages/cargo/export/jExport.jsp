<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>报表统计</title>
	 <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
     <script type="text/javascript" src="${ctx}/js/datepicker/WdatePicker.js"></script>
     <script type="text/javascript">
     	//给打印 链接 添加参数 saleTime
     	function setSaleExport(saleTime){
     		var obj = document.getElementById("saleExport");
     		obj.href = obj.href +"?saleTime="+saleTime +""; 
     	}
     	//给打印 链接 添加参数 purchaseTime
    	function setPurchaseExport(purchaseTime){
     		var obj = document.getElementById("purchaseExport");
     		obj.href = obj.href +"?purchaseTime="+purchaseTime +""; 
     	}
     </script>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
  </div>
</div>
</div>
</div>
   
<div>
	
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		报表统计
    </div> 
    </div>
    </div>
</div>
    <div>
    	<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe" style="width:300px;">货物月销售统计表：</td>
	            <td class="tableContent">
	            	<input type="text" name="saleTime" readonly ="true"  style="width:90px;" onchange="setSaleExport(this.value)"
	            		onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM'})"/>
	            </td>
	            <td><a id = "saleExport" href="${ctx}/cargo/export/saleexport.action"><font color="red" size="3">打印</font></a></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">原材料月采购统计表：</td>
	            <td class="tableContent">
	            	<input type="text" name="purchaseTime" readonly ="true"  style="width:90px;" onchange="setPurchaseExport(this.value)"
	            		onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM'})"/>
	            </td>
	          	<td><a id = "purchaseExport" href="${ctx}/cargo/export/purchaseexport.action"><font color="red" size="3">打印</font></a></td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>


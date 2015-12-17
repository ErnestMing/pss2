<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>修改销售订单货物信息</title>
     <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
     <script type="text/javascript" src="${ctx}/js/datepicker/WdatePicker.js"></script>
     <script type="text/javascript">
     	function setCustomName(opt){
    		 var obj = document.getElementById("materialName");
    		 obj.value = opt.text ; 
   		}
     	function setProductName(opt){
    		 var obj = document.getElementById("supplierName");
    		 obj.value = opt.text ; 
   		}
     </script>
</head>
<body>
<form method="post">
	<!-- 在采购订单中原材料的ID -->
	<input type = "hidden" name ="id" value = "${obj.id}"/>
	<!-- 传递订单ID -->
	<input type = "hidden" name ="orderNo" value = "${orderNo}"/>
	
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('updateproduct.action','_self');">确定</a></li>
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
		修改销售订单货物信息
    </div> 
    </div>
    </div>
</div>
    <div>
    <table class="commonTable" cellspacing="1">
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">客户编号：</td>
	            <td class="tableAutoContent">
	            	<select name="customNo" onchange="setCustomName(this.options[this.selectedIndex])">
						<option value="">----请选择----</option>
						<c:forEach items="${customList}" var="s">
							<option value="${s.customNo}" <c:if test='${s.name == obj.customName }'>selected</c:if>>${s.name }</option>
						</c:forEach>	  
	            	</select>
	            	<!-- 客户名称 -->
	            	<input type="hidden" name="customName" id = "customName" value="${obj.customName }"/>
	            </td>
	            <td class="columnTitle_mustbe">货物编号：</td>
	            <td class="tableAutoContent">
					<select name="productNo" onchange="setProductName(this.options[this.selectedIndex])">
						<option value="">----请选择----</option>
						<c:forEach items="${productList}" var="s">
							<option value="${s.productNo}" <c:if test='${s.name == obj.productName }'>selected</c:if>>${s.name }</option>
						</c:forEach>	            	
	            	</select>
	            	<!-- 货物名称 -->
	            	<input type="hidden" name="productName" id = "productName" value="${obj.productName }"/>
	            </td>
	        </tr>
	        <tr>
	        	<td class="columnTitle_mustbe">货物数量：</td>
	            <td class="tableContent">
	            	<input type = "text" name = "productAmount" value="${obj.productAmount }"/>
	            </td>
	        	<td class="columnTitle_mustbe">销售日期：</td>
	            <td class="tableContent">
	            	<input type="text" name="saleTime" value="<fmt:formatDate value='${obj.saleTime }' pattern='yyyy-MM-dd'/>" readonly ="true"  style="width:90px;"
	            		onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'})"/>
	            </td>
	        </tr>
	        <tr>
	        	<td class="columnTitle_mustbe">有效起日：</td>
	            <td class="tableContent">
	            	<input type="text" name="validStartTime" value="<fmt:formatDate value='${obj.validStartTime }' pattern='yyyy-MM-dd'/>"  readonly ="true"  style="width:90px;"
	            		onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'})"/>
	            </td>
	        	<td class="columnTitle_mustbe">有效止日：</td>
	            <td class="tableContent">
	            	<input type="text" name="validEndTime" value="<fmt:formatDate value='${obj.validEndTime }' pattern='yyyy-MM-dd'/>" readonly ="true"  style="width:90px;"
	            		onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'})"/>
	            </td>
	        </tr>
		</table>
	</div>
</div>
 
</form>
</body>
</html>




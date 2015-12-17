<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>修改采购原材料信息</title>
     <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
     <script type="text/javascript" src="${ctx}/js/datepicker/WdatePicker.js"></script>
     <script type="text/javascript">
     	function setMaterialName(opt){
    		 var obj = document.getElementById("materialName");
    		 obj.value = opt.text ; 
   		}
     	function setSupplierName(opt){
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
<li id="save"><a href="#" onclick="formSubmit('updatematerial.action','_self');">确定</a></li>
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
		修改采购原材料信息
    </div> 
    </div>
    </div>
</div>
    <div>
    <table class="commonTable" cellspacing="1">
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">原材料：</td>
	            <td class="tableAutoContent">
	            	<select name="materialId" onchange="setMaterialName(this.options[this.selectedIndex])">
						<option value="">----请选择----</option>
						<c:forEach items="${materialList}" var="s">
							<option value="${s.id}" <c:if test="${s.name == obj.materialName }">selected</c:if>>${s.name }</option>
						</c:forEach>	  
	            	</select>
	            	<!-- 原材料名称 -->
	            	<input type="hidden" name=materialName id = "materialName" value="${obj.materialName }" />
	            </td>
	        </tr>
	        <tr>
	        	<td class="columnTitle_mustbe">采购数量：</td>
	            <td class="tableContent">
	            	<input type = "text" name = "purchaseAmount" value="${obj.materialAmount }"/>
	            </td>
	        	<td class="columnTitle_mustbe">包装单位：</td>
	            <td class="tableContent">
	            	<input type = "text" name = "packingUnit" value="${obj.packingUnit }"/>
	            </td>
	        </tr>
	         <tr>
	        	<td class="columnTitle_mustbe">采购日期：</td>
	            <td class="tableContent">
	            	<input type="text" name="purchaseTime"  value="<fmt:formatDate value='${obj.purchaseTime }' pattern='yyyy-MM-dd'/>" readonly ="true"  style="width:90px;"
	            		onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'})"/>
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">供应商：</td>
	            <td class="tableAutoContent">
					<select name="supplierId" onchange="setSupplierName(this.options[this.selectedIndex])">
						<option value="">----请选择----</option>
						<c:forEach items="${supplierList}" var="s">
							<option value="${s.id}" <c:if test="${s.supplierName == obj.supplierName }">selected</c:if> >${s.supplierName }</option>
						</c:forEach>	            	
	            	</select>
	            	<!-- 供应商名称 -->
	            	<input type="hidden" name="supplierName" id = "supplierName" value="${obj.supplierName }"/>
	            </td>
	            <td class="columnTitle_mustbe">联系方式：</td>
	            <td class="tableContent">
	            	<input type = "text" name = "phone" value="${obj.phone }"/>
	            </td>
	        </tr>
		</table>
	</div>
</div>
 
</form>
</body>
</html>




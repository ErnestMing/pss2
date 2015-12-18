<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>查看采购订单信息</title>
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
		查看采购订单信息
    </div> 
    </div>
    </div>
</div>
 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">订单编号：</td>
	            <td class="tableContent">${obj.orderNo }</td>
	            <td class="columnTitle_mustbe">订单类型：</td>
	            <td class="tableAutoContent">
	            	原材料采购
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">单位：</td>
	            <td class="tableContent">${obj.orderer }</td>
	            <td class="columnTitle_mustbe">制单人：</td>
	            <td class="tableContent">${obj.input }</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">签单日期 </td>
	            <td class="tableContent">
	          	  <fmt:formatDate value='${obj.purchaseTime }' pattern='yyyy-MM-dd'/>
	            </td>
	        </tr>
	        <tr>
	        	<td class="columnTitle_mustbe">备注：</td>
	            <td class="tableContent">
	            	${obj.memo }
	            </td>
	        </tr>
		</table>
	</div>
</div>
 
 <!-- ----------------------------------------------订单下物品信息------------------------------------------------ -->
 
 <!-- 页面主体部分（列表等） -->  
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">

	采购订单下原材料信息列表
	   
  </div> 
  </div>
  </div>
  
<div>
	
<div class="eXtremeTable" >

<!-- 原材料订单 -->
<c:if test="${obj.type == 1 }">
	<table id="ec_table" class="tableRegion" width="98%" >
		<thead>
		<tr>
			<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
			<td class="tableHeader">序号</td>
			<td class="tableHeader">供应商编号</td>
			<td class="tableHeader">供应商名称</td>
			<td class="tableHeader">原材料编号</td>
			<td class="tableHeader">原材料名称</td>
			<td class="tableHeader">数量</td>
		</tr>
		</thead>
		<tbody class="tableBody" >
		
		<c:forEach items="${goodsList}" var="o" varStatus="status">
		<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
			<td><input type="checkbox" name="id" value="${o.id}"/></td>
			<td>${status.index+1}</td>
			<td>${o.supplierNo}</td>
			<td>${o.supplierName}</td>
			<td>${o.materialNo}</td>
			<td>${o.materialName}</td>
			<td>${o.materialAmount}/${o.packingUnit }</td>
		</tr>
		</c:forEach>
		
		</tbody>
	</table>
</c:if>
<!-- 货物订单 -->
<c:if test="${obj.type == 2 }">
	<table id="ec_table" class="tableRegion" width="98%" >
		<thead>
		<tr>
			<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
			<td class="tableHeader">序号</td>
			<td class="tableHeader">客户编号</td>
			<td class="tableHeader">客户名称</td>
			<td class="tableHeader">货物编号</td>
			<td class="tableHeader">货物名称</td>
			<td class="tableHeader">数量</td>
		</tr>
		</thead>
		<tbody class="tableBody" >
		
		<c:forEach items="${goodsList}" var="o" varStatus="status">
		<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
			<td><input type="checkbox" name="id" value="${o.id}"/></td>
			<td>${status.index+1}</td>
			<td>${o.customNo}</td>
			<td>${o.customName}</td>
			<td>${o.productNo}</td>
			<td>${o.productName}</td>
			<td>${o.productAmount}/${o.packingUnit }</td>
		</tr>
		</c:forEach>
		
		</tbody>
	</table>
</c:if>

</div>
 
</div>
 
 
</form>
</body>
</html>


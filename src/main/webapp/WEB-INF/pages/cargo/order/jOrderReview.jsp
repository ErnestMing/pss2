<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>购销订单审核</title>
	 <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
	 
</head>

<body>
<form name="icform" method="post">
	
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>

<li id="enable"><a href="#" onclick="formSubmit('toview.action','_self');this.blur();">查看</a></li>
<li id="enable"><a href="#" onclick="formSubmit('check.action','_self');this.blur();">审核</a></li>
 
</ul>
  </div>
</div>
</div>
</div>
   
<!-- 页面主体部分（列表等） -->  
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">

	购销订单审核
	   
  </div> 
  </div>
  </div>
  
<div>
	
<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">订单编号</td>
		<td class="tableHeader">订单类型</td>
		<td class="tableHeader">单位</td>
		<td class="tableHeader">制单人</td>
		<td class="tableHeader">执行日期</td>
		<td class="tableHeader">订单状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${dataList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td><a href="toview.action?id=${o.id}">${o.orderNo}</a></td>
		<td>
			<c:if test="${o.type == 1}">原材料采购</c:if>
			<c:if test="${o.type == 2}">产品销售</c:if>
		</td>
		<td>${o.orderer}</td>
		<td>${o.input}</td>
		<td><fmt:formatDate value="${o.purchaseTime}" pattern="yyyy-MM-dd"/></td>
		<td>
			<c:if test="${o.state == 2}"><a href = "${ctx }/cargo/order/check.action?id=${o.id}"><font color="blue">${orderState["2"] }</font></a></c:if>
			<c:if test="${o.state == 3}">${orderState["3"] }</c:if>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>


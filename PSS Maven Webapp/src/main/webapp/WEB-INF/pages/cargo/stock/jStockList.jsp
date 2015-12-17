<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>库存管理</title>
	 <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>

<li id="save" style="width:100px;background:url('${ctx}/skin/default/put.gif') no-repeat;">
													<a href="#" onclick="formSubmit('materialput.action','_self');this.blur();">原材料入库</a></li>
													
<li id="report" style="width:100px;background:url('${ctx}/skin/default/out.gif') no-repeat;">
													<a href="#" onclick="formSubmit('materialout.action','_self');this.blur();">原材料出库</a></li>
													
<li id="save" style="width:100px;background:url('${ctx}/skin/default/put.gif') no-repeat;">
													<a href="#" onclick="formSubmit('productput.action','_self');this.blur();">货物入库</a></li>
													
<li id="report" style="width:100px;background:url('${ctx}/skin/default/out.gif') no-repeat;">
													<a href="#" onclick="formSubmit('productout.action','_self');this.blur();">货物出库</a></li>
<li id="print"><a href="#" onclick="formSubmit('${ctx}/cargo/export/stock.action','_self');this.blur();">打印</a></li>
 
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

	库存物品列表
	   
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
		<td class="tableHeader">仓库编号</td>
		<td class="tableHeader">物品编号</td>
		<td class="tableHeader">物品名称</td>
		<td class="tableHeader">类别</td>
		<td class="tableHeader">当前库存量</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${dataList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.repositoryNo }</td>
		<td>${o.goodsNo }</td>
		<td>${o.goodsName }</td>
		<td>
			<c:if test="${o.goodsType == 1}">原材料</c:if>
			<c:if test="${o.goodsType == 2}">货物</c:if>
		</td>
		<td>${o.amount }/${o.packingUnit}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
<!-- 分页操作 -->
	${pageLinks }
	
</div>
 
</div>
 
 
</form>
</body>
</html>


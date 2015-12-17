<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>租户信息列表</title>
	 <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
	 
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="enable"><a href="#" onclick="formSubmit('start.action','_self');this.blur();">启用</a></li>
<li id="disable"><a href="#" onclick="formSubmit('cancel.action','_self');this.blur();">禁用</a></li>
 
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

	租户信息列表
	   
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
		<td class="tableHeader">租户编号</td>
		<td class="tableHeader">租户名称</td>
		<td class="tableHeader">所属企业</td>
		<td class="tableHeader">租户状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${dataList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.tenantNo}</td>
		<td>${o.name}</td>
		<td>${o.company}</td>
		<td>
			<c:if test="${o.state == 1}"><a href="${ctx }/multitenant/tenantadmin/tenant/start.action?id=${o.id}"><font color="blue">${tenantState['1'] }</font></a></c:if> 
			<c:if test="${o.state == 2}"><a href="${ctx }/multitenant/tenantadmin/tenant/cancel.action?id=${o.id}"><font color="blue">${tenantState['2'] }</font></a></c:if> 
			<c:if test="${o.state == 3}"><a href="${ctx }/multitenant/tenantadmin/tenant/start.action?id=${o.id}"><font color="blue">${tenantState['3'] }</font></a></c:if> 
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


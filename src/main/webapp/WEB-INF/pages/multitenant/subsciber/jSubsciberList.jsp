<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>服务订购信息列表</title>
	 <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
	 
</head>

<body>
<form name="icform" method="post">

<!-- 页面主体部分（列表等） -->  
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">

	服务订购信息列表
	   
  </div> 
  </div>
  </div>
  
<div>
	<div id="menubar">
		<div id="middleMenubar">
			<div id="innerMenubar">
			    <div id="navMenubar">
			<ul>
			<li id="delete"><a href="#" onclick="formSubmit('delete.action','_self');this.blur();">删除</a></li>
			</ul>
	    </div>
	</div>
	</div>
</div>

	
<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">服务名称</td>
		<td class="tableHeader">价格</td>
		<td class="tableHeader">订购日期</td>
		<td class="tableHeader">开始日期</td>
		<td class="tableHeader">结束日期</td>
		<td class="tableHeader">剩余月数</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${dataList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>	
		<td>${status.index+1}</td>
		<td>${o.function.functionName}</td>
		<td>${o.function.pricePolicy.price}元/${o.function.pricePolicy.unit}</td>
		<td><fmt:formatDate value="${o.supsciberDate }" pattern="yyyy-MM-dd"/> </td>
		<td><fmt:formatDate value="${o.beginDate }" pattern="yyyy-MM-dd"/> </td>
		<td><fmt:formatDate value="${o.endDate }" pattern="yyyy-MM-dd"/> </td>
		<td>
			<c:if test="${o.remainder <=1 }"><font color="red">${o.remainder } 个月</font></c:if>
			<c:if test="${o.remainder >1 }">${o.remainder } 个月</c:if>
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


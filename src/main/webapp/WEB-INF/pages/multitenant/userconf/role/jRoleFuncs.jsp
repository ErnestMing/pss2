<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>角色权限分配</title>
	 <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
	 
</head>

<body>
<form name="icform" method="post">
	<!-- 角色ID -->
	<input type="hidden" name = "roleId" value="${roleId }" >

<!-- 角色拥有的权限 -->
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">

	角色拥有权限列表
	   
  </div> 
  </div>
  </div>
  
<div>
	
<div class="eXtremeTable" >
	<table id="ec_table" class="tableRegion" width="98%" >
		<thead>
		<tr>
			<td class="tableHeader">序号</td>
			<td class="tableHeader">角色名称</td>
			<td class="tableHeader">功能</td>
			<td class="tableHeader">操作</td>
		</tr>
		</thead>
		<tbody class="tableBody" >
		
		<c:forEach items="${roleFuncsList}" var="o" varStatus="status">
		<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
			<td>${status.index+1}</td>
			<td>${o.roleName}</td>
			<td>
				<c:if test="${o.functionName == null}"><font color="red">无任何权限</font></c:if>
				<c:if test="${o.functionName != null}">${o.functionName}</c:if>
			</td>
			<td>
				<a href="${ctx }/sysadmin/rolefuncs/delete.action?id=${o.roleFuncsID}&roleId=${roleId}"><font color="blue">取消权限</font></a> 
			</td>
		</tr>
		</c:forEach>
		
		</tbody>
	</table>

</div>
 
</div>

<br><br>
<hr style="background:#007064;height:5px;">

<!-- 权限列表 -->

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>

<li id="new"><a href="#" onclick="formSubmit('${ctx}/sysadmin/rolefuncs/insert.action','_self');this.blur();">添加</a></li>
 
</ul>
  </div>
</div>
</div>
</div>

<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">

	系统功能列表
	   
  </div> 
  </div>
  </div>
  
<div>
	
<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">功能编号</td>
		<td class="tableHeader">功能资源</td>
		<td class="tableHeader">功能名称</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${functionList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="functionId" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.functionNo}</td>
		<td>${o.functionURL}</td>
		<td>${o.functionName}</td>
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


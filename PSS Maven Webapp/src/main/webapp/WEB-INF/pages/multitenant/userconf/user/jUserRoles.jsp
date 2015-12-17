<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户权限分配</title>
	 <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
	 
</head>

<body>
<form name="icform" method="post">

	<input type="hidden" name ="userId" value="${userId }"/>

<!-- 用户拥有的权限 -->
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">

	用户拥有权限列表
	   
  </div> 
  </div>
  </div>
  
<div>
	
<div class="eXtremeTable" >
	<table id="ec_table" class="tableRegion" width="98%" >
		<thead>
		<tr>
			<td class="tableHeader">序号</td>
			<td class="tableHeader">用户账号</td>
			<td class="tableHeader">角色名称</td>
			<td class="tableHeader">操作</td>
		</tr>
		</thead>
		<tbody class="tableBody" >
		
		<c:forEach items="${userRolesList}" var="o" varStatus="status">
		<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
			<td>${status.index+1}</td>
			<td>${o.userNo}</td>
			<td>
				<c:if test="${o.roleName == null}"><font color="red">无任何权限</font></c:if>
				<c:if test="${o.roleName != null}">${o.roleName}</c:if>
			</td>
			<td>
				<a href="${ctx }/sysadmin/userroles/delete.action?id=${o.userRoleId}&userId=${userId}"><font color="blue">撤销角色</font></a> 
			</td>
		</tr>
		</c:forEach>
		
		</tbody>
	</table>

</div>
 
</div>

<br><br>
<hr style="background:#007064;height:5px;">

<!-- 角色列表 -->

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>

<li id="new"><a href="#" onclick="formSubmit('${ctx}/sysadmin/userroles/insert.action','_self');this.blur();">添加</a></li>
 
</ul>
  </div>
</div>
</div>
</div>

<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">

	角色列表
	   
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
		<td class="tableHeader">角色编号</td>
		<td class="tableHeader">角色资源</td>
		<td class="tableHeader">角色名称</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${roleList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="roleId" value="${o.id }"/></td>
		<td>${status.index+1}</td>
		<td>${o.roleNo}</td>
		<td>${o.name}</td>
		<td>${o.description}</td>
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


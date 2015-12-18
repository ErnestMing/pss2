<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>原材料出库单列表</title>
	 <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
	 
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>

<li id="view"><a href="#" onclick="formSubmit('toview.action','_self');this.blur();">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('tocreate.action','_self');this.blur();">添加</a></li>
<li id="update"><a href="#" onclick="formSubmit('toupdate.action','_self');this.blur();">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('delete.action','_self');this.blur();">删除</a></li>
<li id="new"><a href="#" onclick="formSubmit('${ctx }/cargo/materialout/start.action','_self');this.blur();">登记</a></li>
<li id="new"><a href="#" onclick="formSubmit('${ctx }/cargo/materialout/cancel.action','_self');this.blur();">取消</a></li>
 
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

	原材料出库单列表
	   
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
		<td class="tableHeader">原材料编号</td>
		<td class="tableHeader">原材料名称</td>
		<td class="tableHeader">所在仓库</td>
		<td class="tableHeader">原材料数量</td>
		<td class="tableHeader">领料人</td>
		<td class="tableHeader">操作者</td>
		<td class="tableHeader">出库时间</td>
		<td class="tableHeader">状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${dataList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.materialNo}</td>
		<td>${o.materialName}</td>
		<td>${o.repositoryNo}</td>
		<td>${o.materialAmount}/${o.packingUnit}</td>
		<td>${o.pickingPeople}</td>
		<td>${o.operator}</td>
		<td><fmt:formatDate value="${o.outTime}" pattern="yyyy-MM-dd"/></td>
		<td>
			<c:if test="${o.state == 1}">已登记</c:if>
			<c:if test="${o.state == 0}"><a href = "${ctx }/cargo/materialout/start.action?id=${o.id}"><font color="blue">草稿</font></a></c:if>
		</td>
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


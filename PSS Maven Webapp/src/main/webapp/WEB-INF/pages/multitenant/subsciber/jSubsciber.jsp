<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>服务订购信息列表</title>
	 <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
	 <script type="text/javascript" src="${ctx}/js/datepicker/WdatePicker.js"></script>
	 <script type="text/javascript">
	 	function submitForm(url,n){
	 		document.forms[n].action = url;
	 		document.forms[n].submit();
	 	}
	 </script>
</head>

<body>
<form name="icform" method="post">

<!-- 页面主体部分（列表等） -->  
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">

	服务列表	<font color="red">${errorMsg}</font>	
	   
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
		<td class="tableHeader">服务名称</td>
		<td class="tableHeader">价格</td>
		<td class="tableHeader">开始日期</td>
		<td class="tableHeader">结束日期</td>
		<td class="tableHeader">操作</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${dataList}" var="o" varStatus="status">
	<form id = "form${status.index }" action = "subsciberService.action" method ="POST">
		<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
			<!-- 防止没有点击CheckBox时,functionId 为空 -->
			<input type="hidden" name="functionId" value="${o.id}"/>
			<td><input type="checkbox" name="id" value="${o.id}"/></td>	
			<td>${status.index+1}</td>
			<td><font color="red">${o.functionName}</font></td>
			<td>${o.pricePolicy.price}元/${o.pricePolicy.unit}</td>
			<td>
				<input type="text" name="beginDate" id = "beginDate${status.index}" readonly ="true"  placeholder="输入起始日期" style="width:90px;"
		            onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd','minDate':'%y-%M-{%d+1}'})" >
			</td>
			<td>
				<input type="text" name="endDate" id = "endDate${status.index}" readonly ="true" placeholder="输入终止日期"  style="width:90px;"
		            onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd','minDate':'#F{$dp.$D(\'beginDate${status.index}\')}'})" >
			</td>
			<td>
				<a href = "#" onclick="submitForm('subsciberService.action',${status.index} );"><font color="blue">订购</font></a>
			</td>
		</tr>
	</form>
	
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>


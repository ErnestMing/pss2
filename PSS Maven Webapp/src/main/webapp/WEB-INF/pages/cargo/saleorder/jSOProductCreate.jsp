<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>添加销售货物信息</title>
     <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
     <script type="text/javascript" src="${ctx}/js/datepicker/WdatePicker.js"></script>
     <script type="text/javascript">
     	function setCustomName(opt){
    		 var obj = document.getElementById("customName");
    		 obj.value = opt.text ; 
   		}
     	function setProductName(opt){
    		 var obj = document.getElementById("productName");
    		 obj.value = opt.text ; 
   		}
     </script>
</head>
<body>
<form method="post">
	<!-- 传递订单编号 -->
	<input type = "hidden" name ="orderNo" value = "${orderNo}"/>
	
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('addproduct.action','_self');">确定</a></li>
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
		添加销售货物信息
    </div> 
    </div>
    </div>
</div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	        	<!-- 保存订单编号 -->
				<input type="hidden" name = "salesOrderNo" value="${orderNo }"/>
	            <td class="columnTitle_mustbe">客户编号：</td>
	            <td class="tableAutoContent">
	            	<select name="customNo" onchange="setCustomName(this.options[this.selectedIndex])">
						<option value="">----请选择----</option>
						<c:forEach items="${customList}" var="s">
							<option value="${s.customNo}" >${s.name }</option>
						</c:forEach>	  
	            	</select>
	            	<!-- 客户名称 -->
	            	<input type="hidden" name="customName" id = "customName"/>
	            </td>
	            <td class="columnTitle_mustbe">货物编号：</td>
	            <td class="tableAutoContent">
					<select name="productNo" onchange="setProductName(this.options[this.selectedIndex])">
						<option value="">----请选择----</option>
						<c:forEach items="${productList}" var="s">
							<option value="${s.productNo}">${s.name }</option>
						</c:forEach>	            	
	            	</select>
	            	<!-- 货物名称 -->
	            	<input type="hidden" name="productName" id = "productName"/>
	            </td>
	        </tr>
	        <tr>
	        	<td class="columnTitle_mustbe">货物数量：</td>
	            <td class="tableContent">
	            	<input type = "text" name = "productAmount"/>
	            </td>
	            <td class="columnTitle_mustbe">包装单位：</td>
	            <td class="tableContent">
	            	<input type = "text" name = "packingUnit"/>
	            </td>
	        </tr>
	        <tr>
	        	<td class="columnTitle_mustbe">销售日期：</td>
	            <td class="tableContent">
	            	<input type="text" name="saleTime" readonly ="true"  style="width:90px;"
	            		onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'})"/>
	            </td>
	        </tr>
	        <tr>
	        	<td class="columnTitle_mustbe">有效起日：</td>
	            <td class="tableContent">
	            	<input type="text" name="validStartTime" readonly ="true"  style="width:90px;"
	            		onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'})"/>
	            </td>
	        	<td class="columnTitle_mustbe">有效止日：</td>
	            <td class="tableContent">
	            	<input type="text" name="validEndTime" readonly ="true"  style="width:90px;"
	            		onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'})"/>
	            </td>
	        </tr>
		</table>
	</div>
</div>
 
</form>
 
 <div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">

	采购原材料列表
	   
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
		<td class="tableHeader">客户名称</td>
		<td class="tableHeader">货物名称</td>
		<td class="tableHeader">货物数量</td>
		<td class="tableHeader">销售日期</td>
		<td class="tableHeader">有效起日</td>
		<td class="tableHeader">有效止日</td>
		<td class="tableHeader">操作</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${saleOrderList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.customName}</td>
		<td>${o.productName}</td>
		<td>${o.productAmount}</td>
		<td><fmt:formatDate value="${o.saleTime}" pattern="yyyy-MM-dd"/></td>
		<td><fmt:formatDate value="${o.validStartTime}" pattern="yyyy-MM-dd"/></td>
		<td><fmt:formatDate value="${o.validEndTime}" pattern="yyyy-MM-dd"/></td>
		<td>
			<a href="${ctx }/cargo/saleorder/toupdateproduct.action?id=${o.id}&orderNo=${orderNo}">修改</a>
			<a href="${ctx }/cargo/saleorder/deleteproduct.action?id=${o.id }&orderNo=${orderNo}">删除</a>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
</body>
</html>




<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>添加采购原材料信息</title>
     <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
     <script type="text/javascript" src="${ctx}/js/datepicker/WdatePicker.js"></script>
     <script type="text/javascript">
     	function setMaterialName(opt){
    		 var obj = document.getElementById("materialName");
    		 obj.value = opt.text ; 
   		}
     	function setSupplierName(opt){
    		 var obj = document.getElementById("supplierName");
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
<li id="save"><a href="#" onclick="formSubmit('addmaterial.action','_self');">确定</a></li>
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
		添加采购原材料信息
    </div> 
    </div>
    </div>
</div>
    <div>
    <table class="commonTable" cellspacing="1">
        <tr>
			<!-- 订单编号 -->
			<input type="hidden" name = "purchaseOrderNo" value="${orderNo }"/>
            <td class="columnTitle_mustbe">原材料：</td>
            <td class="tableAutoContent">
            	<select name="materialNo" onchange="setMaterialName(this.options[this.selectedIndex])">
					<option value="">----请选择----</option>
					<c:forEach items="${materialList}" var="s">
						<option value="${s.materialNo}" >${s.name }</option>
					</c:forEach>	  
            	</select>
            	<!-- 原材料名称 -->
            	<input type="hidden" name="materialName" id = "materialName"/>
            </td>
        </tr>
        <tr>
        	<td class="columnTitle_mustbe">原材料数量：</td>
            <td class="tableContent">
            	<input type = "text" name = "materialAmount"/>
            </td>
        	<td class="columnTitle_mustbe">包装单位：</td>
            <td class="tableContent">
            	<input type = "text" name = "packingUnit"/>
            </td>
        </tr>
         <tr>
        	<td class="columnTitle_mustbe">采购日期：</td>
            <td class="tableContent">
            	<input type="text" name="purchaseTime" readonly ="true"  style="width:90px;"
            		onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'})"/>
            </td>
        </tr>
        <tr>
            <td class="columnTitle_mustbe">供应商：</td>
            <td class="tableAutoContent">
				<select name="supplierNo" onchange="setSupplierName(this.options[this.selectedIndex])">
					<option value="">----请选择----</option>
					<c:forEach items="${supplierList}" var="s">
						<option value="${s.supplierNo}">${s.supplierName }</option>
					</c:forEach>	            	
            	</select>
            	<!-- 供应商名称 -->
            	<input type="hidden" name="supplierName" id = "supplierName"/>
            </td>
            <td class="columnTitle_mustbe">联系方式：</td>
            <td class="tableContent">
            	<input type = "text" name = "phone"/>
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
		<td class="tableHeader">原材料名称</td>
		<td class="tableHeader">供应商名称</td>
		<td class="tableHeader">采购数量</td>
		<td class="tableHeader">采购日期</td>
		<td class="tableHeader">联系方式</td>
		<td class="tableHeader">操作</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${purchaseOrderList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td>${o.materialName}</td>
		<td>${o.supplierName}</td>
		<td>${o.materialAmount}/${o.packingUnit}</td>
		<td><fmt:formatDate value="${o.purchaseTime }" pattern="yyyy-MM-dd"/></td>
		<td>${o.phone}</td>
		<td>
			<a href="${ctx }/cargo/purchaseorder/toupdatematerial.action?id=${o.id}&orderNo=${orderNo}">修改</a>
			<a href="${ctx }/cargo/purchaseorder/deletematerial.action?id=${o.id }&orderNo=${orderNo}">删除</a>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
</body>
</html>




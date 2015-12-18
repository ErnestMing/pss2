<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>添加货物上下限信息</title>
     <link rel="stylesheet" type="text/css" href="${ctx}/skin/default/css/table.css">
     <script type="text/javascript" src="${ctx}/js/datepicker/WdatePicker.js"></script>
     <script type="text/javascript">
    	 function setProductName(opt){
			 var obj = document.getElementById("productName");
			 obj.value = opt.text ; 
		}
     </script>
</head>
<body>
<form method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('insert.action','_self');">确定</a></li>
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
		设置货物上下限信息
    </div> 
    </div>
    </div>
</div>
 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">仓库编号：</td>
	            <td class="tableContent">
	            	<select name="repositoryNo">
	            		<option value="">----请选择----</option>
	            		<c:forEach items="${repositoryList }" var="rep">
	            			<option value="${rep.repositoryNo }">${rep.name }</option>
	            		</c:forEach>
	            	</select>
	            </td>
	            <td class="columnTitle_mustbe">上限数量：</td>
	            <td class="tableContent"><input type="text" name="upperAmount" style="width:120px"/></td>
	            
	        </tr>
	        <tr>
	           <td class="columnTitle_mustbe">货物编号：</td>
	            <td class="tableAutoContent">
	            	<select name="productNo" onchange="setProductName(this.options[this.selectedIndex])">
						<option value="">----请选择----</option>
						<c:forEach items="${productList}" var="s">
							<option value="${s.productNo}" >${s.name }</option>
						</c:forEach>	  
	            	</select>
	            	<!-- 货物名称 -->
	            	<input type="hidden" name="productName" id = "productName"/>
	            </td>
	            <td class="columnTitle_mustbe">下限数量：</td>
	            <td class="tableContent"><input type="text" name="lowerAmount"  style="width:120px"/></td>
	        </tr>
	        
	        <tr>
	   	     	<td class="columnTitle_mustbe">备注：</td>
	            <td class="tableContent">
	            	<textarea name = "memo" style="height:120px;"></textarea>
	            </td>
	            <td class="columnTitle_mustbe">最佳数量：</td>
	            <td class="tableContent"><input type="text" name="bestAmount"  style="width:120px"/></td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>


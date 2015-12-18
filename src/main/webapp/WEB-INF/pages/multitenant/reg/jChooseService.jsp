<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html><head>
	        <title>基于SaaS模式的进销存一体化平台</title>
	       
				<link rel="stylesheet" href="${ctx }/3part/base.css" type="text/css">
				<link rel="stylesheet" href="${ctx }/3part/common.css" type="text/css">
				<link rel="stylesheet" href="${ctx }/3part/page.css" type="text/css">
            <link type="text/css" rel="stylesheet" href="${ctx }/3part/jquery.css">	
            <link type="text/css" rel="stylesheet" href="${ctx }/3part/reg-login-v2.css">	
    		
				<!-- JS Global Compulsory -->    
				<script src="${ctx }/3part/jquery_004.js"></script>
				<script type="text/javascript" src="${ctx }/3part/json2.js"></script>
				<script type="text/javascript" src="${ctx }/3part/utility.js"></script>
				<script type="text/javascript" src="${ctx }/3part/jquery_002.js"></script>
				<script type="text/javascript" src="${ctx }/3part/common.js"></script>
				<script type="text/javascript" src="${ctx }/3part/page.js"></script>
				
				<script type="text/javascript" src="${ctx}/js/datepicker/WdatePicker.js"></script>
				<script type="text/javascript">
					function submitForm (url){
						var form1 = document.forms[0] ;
						form1.action = url ; 
						form1.method = "post"
						form1.submit();
					}
				</script>
	    <body>
        	<div class="regAndLogin-main">
        		<div class="main-panel bc">
        			<h2 class="main-panel-header f18 tc">服务订购</h2>
        			
	        			<div class="main-panel-content f12" id="panel-content-step-2">
	        			
	        			<form id = "chooseService" method="post">
	        			
		        				<div class="main-panel-step black" id="main-panel-step-2" style="background: url(3part/reg-step-2.png) no-repeat;">
		        				<span class="step-item" id="step-item-1">创建租户</span>
		        				<span class="step-item" id="step-item-2">服务订购</span>
		        				<span class="step-item" id="step-item-3">完成</span>
		        			</div>
		        			<div class="reg-selectApp">
		        				<p class="reg-selectApp-h f14 black">选择服务</p>
		        				<div class="reg-selectApp-list mCustomScrollbar _mCS_1">
		        				<div tabindex="0" id="mCSB_1" class="mCustomScrollBox mCS-dark mCSB_vertical mCSB_inside">
		        				<div id="mCSB_1_container" class="mCSB_container" style="po sition:relative; top:0; left:0;" dir="ltr">
		        					<table class="selectApp-table black width-fit">
		        						<tbody>
		        						
		        							<c:forEach items="${functionList }" var="s">
			        							<tr>
				        							<td width="44px"><input checked="checked" name="id" value="${s.id}" class="selectApp-checkbox"  type="checkbox"></td>
				        							<td width="100px"><font color="#ED5565">${s.functionName }</font></td>
				        							<td width="80px">${s.pricePolicy.price }/${s.pricePolicy.unit }</td>
				        							<td class="startTime">
				        							开始日期：<input type="text" name="startDate" readonly ="true"  style="width:90px;"
	            													onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'})" ></td>
				        							<td>
				        							<td class="endTime">
				        							终止日期：<input type="text" name="endDate" readonly ="true"  style="width:90px;"
	            													onclick="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'})" ></td>
				        							<td>
			        							</tr>
		        							</c:forEach>
		        							
			        					</tbody>
		        					</table>
		        					
		        				</div><div style="display: block;" id="mCSB_1_scrollbar_vertical" class="mCSB_scrollTools mCSB_1_scrollbar mCS-dark mCSB_scrollTools_vertical">
		        				<div class="mCSB_draggerContainer">
		        				<div id="mCSB_1_dragger_vertical" class="mCSB_dragger" style="position: absolute; min-height: 30px; display: block; height: 99px; max-height: 240px;" oncontextmenu="return false;">
		        				<div style="line-height: 30px;" class="mCSB_dragger_bar"></div></div><div class="mCSB_draggerRail">
		        				</div>
		        				</div>
		        				</div></div></div>
		        			</div>
		        					<p class="input-row handle-next tc">
	        					<a href="#" onclick="submitForm('servicechoose.action')" class="btn-v2 reg-submit f14">订购服务</a>
	        				</p>
        				</form>
        			</div>
        			
        		</div>
        	</div>
        	
	
</body></html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Result Page</title>
</head>
<body>
	<div style="margin:150px;">
		<!-- 库存操作结果消息 -->
		<font style="color:red;font-size:20px;">${msg }</font><br><br>
		<a href="${listUrl}" style="color:blue;font-size:15px;">点击此处，返回上一页面..</a>
	</div>
</body>
</html>


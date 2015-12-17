<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>基于SaaS模式的进销存一体化平台--SaaS平台</title>
</head>
<frameset rows="125,*" name="topFrameset" border="0">
	<frame name="top_frame" scrolling="no"  target="middleFrameSet" src="tenantadmintitle.action">	
	<frameset cols="202,*" height="100%" name="middle" frameborder="no" border="0" framespacing="0">
		<frame name="leftFrame" class="leftFrame" target="main" scrolling="no" src="tenantadminleft.action" />
		<frame name="main" class="rightFrame" src="tenantadminmain.action" />
	</frameset>
</frameset>

<noframes>
<body>
    <p>此网页使用了框架，但您的浏览器不支持框架。</p>
</body>
</noframes>

</html>
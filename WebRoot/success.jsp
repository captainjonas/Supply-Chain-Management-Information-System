<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/common.js" ></script>

  </head>
  
  <body>
  <c:choose>
  	<c:when test="${empty sessionScope.user }">
  		${ew }<br/>
  		<a href="login.jsp">点击重新登录</a>
  	</c:when>
  	<c:when test="${sessionScope.user.status=='锁定'}">
  		${er }
  	</c:when>
  <c:otherwise>
  <script type="text/javascript">
  	this.parent.topFrame.location.href="title.jsp";
  </script>
    <span>欢迎，${sessionScope.user.name}，请选择左边的菜单进行操作。</span>
  </c:otherwise>
  </c:choose>
  </body>
</html>

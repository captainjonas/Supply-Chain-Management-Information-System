<%@ page language="java" import="java.util.*" import="com.aowin.dao.RecordDao" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'changeRec.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/common.js"></script>

  </head>
  
  <body>
 
  
   <table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－库存变更记录</td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
	<caption><font size="3">入库记录信息</font></caption>
  <tr>
    <td class="title1">入库时间</td>
	<td class="title1">相关采购单号</td>
    <td class="title1">入库经手人</td>
    <td class="title1">入库数量</td>
    <td class="title1">入库类型</td>
  </tr>

<%String code=request.getParameter("productCode");
  RecordDao rd1=new RecordDao();
 request.setAttribute("instock",rd1.getInstockRecords(code)); 
 request.setAttribute("outstock",rd1.getOutstockRecords(code)); 
 %>  
  <c:forEach items="${instock }" var="pro">
  <tr align="center">
  	 <td><c:out value="${pro.stockTime }"></c:out></td>
  	 <td><c:out value="${pro.orderCode }"></c:out></td>
     <td><c:out value="${pro.createUser }"></c:out></td>
     <td><c:out value="${pro.stockNum }"></c:out></td>
     <td><c:out value="${pro.stockType }"></c:out></td>
  </tr>
  </c:forEach>
	</table>
	<br>
	<table width="100%"  border="0" align="center" cellspacing="1">
	<caption><font size="3">出库记录信息</font></caption>
 <tr>
    <td class="title1">出库时间</td>
	<td class="title1">相关销售单号</td>
    <td class="title1">出库经手人</td>
    <td class="title1">出库数量</td>
    <td class="title1">出库类型</td>
  </tr>


  <c:forEach items="${outstock }" var="pr">
  <tr align="center">
  	 <td><c:out value="${pr.stockTime }"></c:out></td>
  	 <td><c:out value="${pr.orderCode }"></c:out></td>
     <td><c:out value="${pr.createUser }"></c:out></td>
     <td><c:out value="${pr.stockNum }"></c:out></td>
     <td><c:out value="${pr.stockType }"></c:out></td>
  </tr>
  </c:forEach>
	</table>
  </body>
</html>

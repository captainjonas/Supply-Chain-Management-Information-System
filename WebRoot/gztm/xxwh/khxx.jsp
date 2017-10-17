<%@ page language="java" import="java.util.*" import="java.util.regex.Matcher" import="java.util.regex.Pattern" import="com.aowin.dao.SalesDao" import="java.util.Date" import="java.text.SimpleDateFormat" import="com.aowin.model.User" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>出库</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	
	<script language="javascript" src="script/common.js"></script>
	<script type="text/javascript">
	function upda(obj){
	var sure=confirm("确定将此单出库吗？");
	if(sure){
	var tr=obj.parentNode.parentNode;
	var idLink=tr.cells[0].innerHTML;
 	var id="";
 	id=idLink.substring();
 	var reg=/blank/;
 	var regex=/a>/;
 	var start=idLink.search(reg);
 	var end=idLink.search(regex);
 	id=idLink.substring(start+7,end-2);
 	document.getElementById("soid").value=id;
	<%    
	    Date d=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		String s=sf.format(d);
		String nam=((User)session.getAttribute("user")).getName();
		%>
	
	document.getElementById("time").value='<%=s%>';
	document.getElementById("name").value='<%=nam%>';
	document.getElementById("outStock").submit();
	}
	}
	
	
	</script>

  </head>
  
  <body>
      <table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－出库登记</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
    <td nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
	<caption><font size="3">销售单：货到付款</font></caption>
  <tr>
    <td class="title1">销售单编号</td>
	<td class="title1">创建时间</td>
    <td class="title1">客户名称</td>
    <td class="title1">创建用户</td>
    <td class="title1">附加费用</td>
    <td class="title1">产品总价</td>
    <td class="title1">销售单总价格</td>
    <td class="title1">付款方式</td>
    <td class="title1">最低预付款金额</td>
    <td class="title1">处理状态</td>
    <td class="title1">操作</td>
  </tr>

<%request.setAttribute("sales",SalesDao.getSomain("货到付款"));

 %>  
  <c:forEach items="${sales }" var="pro">
  <tr align="center">
 	 <td><a href="gztm/xxwh/soDetail.jsp?soid=${pro.soid }" target="_blank"><c:out value="${pro.soid }"></c:out></a></td>
  	 <td><c:out value="${pro.createTime }"></c:out></td>
  	 <td><c:out value="${pro.customerName }"></c:out></td>
     <td><c:out value="${pro.creatorName }"></c:out></td>
     <td><c:out value="${pro.tipFee }"></c:out></td>
     <td><c:out value="${pro.productTotal }"></c:out></td>
  	 <td><c:out value="${pro.soTotal }"></c:out></td>
  	 <td>货到付款</td>
     <td><c:out value="${pro.prepayFee }"></c:out></td>
     <td>新增的销售单</td>
      <td align="center"><a onClick="upda(this)">出库</a></td>
  </tr>
  </c:forEach>
	</table>
<form id="outStock" action="sale1" method="post">
<input type="hidden" id="soid" name="soid">
<input type="hidden" id="time" name="time">
<input type="hidden" id="name" name="name">
</form>
	<br>
	<table width="100%"  border="0" align="center" cellspacing="1">
	<caption><font size="3">销售单：款到发货</font></caption>
  <tr>
    <td class="title1">销售单编号</td>
	<td class="title1">创建时间</td>
    <td class="title1">客户名称</td>
    <td class="title1">创建用户</td>
    <td class="title1">附加费用</td>
    <td class="title1">产品总价</td>
    <td class="title1">销售单总价格</td>
    <td class="title1">付款方式</td>
    <td class="title1">最低预付款金额</td>
    <td class="title1">处理状态</td>
    <td class="title1">操作</td>
  </tr>

 <%request.setAttribute("cash1",SalesDao.getSomain("款到发货")); %>  
  <c:forEach items="${cash1 }" var="proc">
  <tr align="center">
 	 <td><a href="gztm/xxwh/soDetail.jsp?soid=${proc.soid }" target="_blank"><c:out value="${proc.soid }"></c:out></a></td>
  	 <td><c:out value="${proc.createTime }"></c:out></td>
  	 <td><c:out value="${proc.customerName }"></c:out></td>
     <td><c:out value="${proc.creatorName }"></c:out></td>
     <td><c:out value="${proc.tipFee }"></c:out></td>
     <td><c:out value="${proc.productTotal }"></c:out></td>
  	 <td><c:out value="${proc.soTotal }"></c:out></td>
  	 <td>款到发货</td>
     <td><c:out value="${proc.prepayFee }"></c:out></td>
     <td>已付款的销售单</td>
      <td align="center"><a onClick="upda(this)">出库</a></td>
  </tr>
  </c:forEach>
	</table>
   <br><br>
    <table width="100%"  border="0" align="center" cellspacing="1">
	<caption><font size="3">销售单：预付款到发货</font></caption>
  <tr>
    <td class="title1">销售单编号</td>
	<td class="title1">创建时间</td>
    <td class="title1">客户名称</td>
    <td class="title1">创建用户</td>
    <td class="title1">附加费用</td>
    <td class="title1">产品总价</td>
    <td class="title1">销售单总价格</td>
    <td class="title1">付款方式</td>
    <td class="title1">最低预付款金额</td>
    <td class="title1">处理状态</td>
    <td class="title1">操作</td>
  </tr>

<%request.setAttribute("prepay1",SalesDao.getSomain("预付款到发货")); 
 
%>  
  <c:forEach items="${prepay1 }" var="procu">
  <tr align="center">
 	 <td><a href="gztm/xxwh/soDetail.jsp?soid=${procu.soid }" target="_blank"><c:out value="${procu.soid }"></c:out></a></td>
  	 <td><c:out value="${procu.createTime }"></c:out></td>
  	 <td><c:out value="${procu.customerName }"></c:out></td>
     <td><c:out value="${procu.creatorName }"></c:out></td>
     <td><c:out value="${procu.tipFee }"></c:out></td>
     <td><c:out value="${procu.productTotal }"></c:out></td>
  	 <td><c:out value="${procu.soTotal }"></c:out></td>
  	 <td>预付款到发货</td>
     <td><c:out value="${procu.prepayFee }"></c:out></td>
     <td>已预付的销售单</td>
      <td align="center"><a onClick="upda(this)">出库</a></td>
  </tr>
  </c:forEach>
	</table>
    
  </body>
</html>

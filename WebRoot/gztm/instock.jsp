<%@ page language="java" import="java.util.*" import="java.util.regex.Matcher" import="java.util.regex.Pattern" import="com.aowin.dao.ProcurementDao" import="java.util.Date" import="java.text.SimpleDateFormat" import="com.aowin.model.User" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'instock.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	
	<script language="javascript" src="script/common.js"></script>
	<script type="text/javascript">
	<c:if test="${empty sessionScope.user}">
		<jsp:forward page="login.jsp"/>
	</c:if>
	function upda(obj){
	var sure=confirm("确定将此单入库吗？");
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
 	document.getElementById("poid").value=id;
	<%    
	    Date d=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		String s=sf.format(d);
		String nam=((User)session.getAttribute("user")).getName();
		%>
	
	document.getElementById("time").value='<%=s%>';
	document.getElementById("name").value='<%=nam%>';
	document.getElementById("forStock").submit();
	}
	}
	
	
	</script>
  </head>
  
  <body>
     <table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－入库登记</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
    <td nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
	<caption><font size="3">采购单：货到付款</font></caption>
  <tr>
    <td class="title1">采购单编号</td>
	<td class="title1">创建时间</td>
    <td class="title1">供应商名称</td>
    <td class="title1">创建用户</td>
    <td class="title1">附加费用</td>
    <td class="title1">采购产品总价</td>
    <td class="title1">采购单总价格</td>
    <td class="title1">付款方式</td>
    <td class="title1">最低预付款金额</td>
    <td class="title1">处理状态</td>
    <td class="title1">操作</td>
  </tr>

<%request.setAttribute("procure",ProcurementDao.getPomain("货到付款")); %>  
  <c:forEach items="${procure }" var="pro">
  <tr align="center">
 	 <td><a href="gztm/proDetail.jsp?poid=${pro.poid }" target="_blank"><c:out value="${pro.poid }"></c:out></a></td>
  	 <td><c:out value="${pro.createtime }"></c:out></td>
  	 <td><c:out value="${pro.venderName }"></c:out></td>
     <td><c:out value="${pro.creatorName }"></c:out></td>
     <td><c:out value="${pro.tipfee }"></c:out></td>
     <td><c:out value="${pro.producttotal }"></c:out></td>
  	 <td><c:out value="${pro.pototal }"></c:out></td>
  	 <td>货到付款</td>
     <td><c:out value="${pro.prepayfee }"></c:out></td>
     <td>新增的采购单</td>
      <td align="center"><a onClick="upda(this)">入库</a></td>
  </tr>
  </c:forEach>
	</table>
<form id="forStock" action="procure" method="post">
<input type="hidden" id="poid" name="poid">
<input type="hidden" id="time" name="time">
<input type="hidden" id="name" name="name">
</form>
	<br>
	<table width="100%"  border="0" align="center" cellspacing="1">
	<caption><font size="3">采购单：款到发货</font></caption>
  <tr>
    <td class="title1">采购单编号</td>
	<td class="title1">创建时间</td>
    <td class="title1">供应商名称</td>
    <td class="title1">创建用户</td>
    <td class="title1">附加费用</td>
    <td class="title1">采购产品总价</td>
    <td class="title1">采购单总价格</td>
    <td class="title1">付款方式</td>
    <td class="title1">最低预付款金额</td>
    <td class="title1">处理状态</td>
    <td class="title1">操作</td>
  </tr>

 <%request.setAttribute("cash",ProcurementDao.getPomain("款到发货")); %>  
  <c:forEach items="${cash }" var="proc">
  <tr align="center">
 	 <td><a href="gztm/proDetail.jsp?poid=${proc.poid }" target="_blank"><c:out value="${proc.poid }"></c:out></a></td>
  	 <td><c:out value="${proc.createtime }"></c:out></td>
  	 <td><c:out value="${proc.venderName }"></c:out></td>
     <td><c:out value="${proc.creatorName }"></c:out></td>
     <td><c:out value="${proc.tipfee }"></c:out></td>
     <td><c:out value="${proc.producttotal }"></c:out></td>
  	 <td><c:out value="${proc.pototal }"></c:out></td>
  	 <td>款到发货</td>
     <td><c:out value="${proc.prepayfee }"></c:out></td>
     <td>已付款的采购单</td>
      <td align="center"><a onClick="upda(this)">入库</a></td>
  </tr>
  </c:forEach>
	</table>
   <br><br>
    <table width="100%"  border="0" align="center" cellspacing="1">
	<caption><font size="3">采购单：预付款到发货</font></caption>
  <tr>
    <td class="title1">采购单编号</td>
	<td class="title1">创建时间</td>
    <td class="title1">供应商名称</td>
    <td class="title1">创建用户</td>
    <td class="title1">附加费用</td>
    <td class="title1">采购产品总价</td>
    <td class="title1">采购单总价格</td>
    <td class="title1">付款方式</td>
    <td class="title1">最低预付款金额</td>
    <td class="title1">处理状态</td>
    <td class="title1">操作</td>
  </tr>

<%request.setAttribute("prepay",ProcurementDao.getPomain("预付款到发货")); %>  
  <c:forEach items="${prepay }" var="procu">
  <tr align="center">
 	 <td><a href="gztm/proDetail.jsp?poid=${procu.poid }" target="_blank"><c:out value="${procu.poid }"></c:out></a></td>
  	 <td><c:out value="${procu.createtime }"></c:out></td>
  	 <td><c:out value="${procu.venderName }"></c:out></td>
     <td><c:out value="${procu.creatorName }"></c:out></td>
     <td><c:out value="${procu.tipfee }"></c:out></td>
     <td><c:out value="${procu.producttotal }"></c:out></td>
  	 <td><c:out value="${procu.pototal }"></c:out></td>
  	 <td>预付款到发货</td>
     <td><c:out value="${procu.prepayfee }"></c:out></td>
     <td>已预付的采购单</td>
      <td align="center"><a onClick="upda(this)">入库</a></td>
  </tr>
  </c:forEach>
	</table>
  </body>
</html>

<%@ page language="java" import="java.util.*" import="java.util.Calendar" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'StockSum.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/common.js" ></script>
	<script type="text/javascript" src="script/productDiv.js" ></script>
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/common.js" ></script>
	<script type="text/javascript" src="script/productDiv.js" ></script>
	<%Calendar c=Calendar.getInstance();
	  int year=c.get(Calendar.YEAR);
	 %>
	<script type="text/javascript">
	function addoption(id,start,end){
			var id=document.getElementById(id);
			for(var i=start;i<=end;i++){
				var opt=document.createElement("option");
				opt.innerHTML=i;
				id.add(opt);
			}
		}
		function inition(){
			addoption("year",2010,<%=year%>);        //从2010年到今年
			addoption('month',1,12);
			document.getElementById("totalOrder").value="${n}";
			document.getElementById("quantity").value="${num}";
			document.getElementById("totalMoney").value="${money}";
		}
		function query(){
		var year=document.getElementById("year").value;
		var month=document.getElementById("month").value;
		location="stockSum?year="+year+"&month="+month;
		}
</script>
  </head>
  
  <body onLoad="inition()">
   <div id="m">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－月度产品库存表</td>
  </tr>
	</table>

</div>
<div id="add" >
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
	<caption>库存表查询</caption>
	 <tr>
    <td class="title1"><font size="2">查询月份</font></td>
    <td class="title1"><select id="year"></select>年<select id="month"></select>月</td>
	</tr>
	<tr>
	<td height="18" colspan="2" align="center"><input type="button" value="查询" onClick="query()"/></td>
	</tr>
	</table>
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
<caption>库存报表明细</caption>
<tr>
    <td class="title1"><font size="2">产品编号</font></td>
    <td class="title1"><font size="2">产品名称</font></td>
    <td class="title1"><font size="2">库存数</font></td>
</tr>
 <c:forEach items="${requestScope.monthStock }" var="cate">
  <tr align="center">
    <td><c:out value="${cate.proCode }"></c:out></td>
    <td><c:out value="${cate.name }"></c:out></td>
	<td><c:out value="${cate.number }"></c:out></td>
  </tr>
 </c:forEach>
 <tr align="center">
 <td>产品总库存数</td>
 <td colspan="2">${size }</td>
 </tr>
</table>
 <div align="center">
    <input type="button" id="dy" value="打印" onClick="window.print()"/>
    <input type="button" id="gb" value="关闭" onClick="window.close()"/>
</div>
	
  </div>  
  </body>
</html>

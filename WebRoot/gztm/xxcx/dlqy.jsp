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
    
    <title>My JSP 'dlqy.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/common.js" ></script>
	<script type="text/javascript" src="script/productDiv.js" ></script>
	
	<%Calendar c=Calendar.getInstance();
	  int yea=c.get(Calendar.YEAR);
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
			addoption("year",2010,<%=yea%>);   //暂时将定为2010年到今年
			addoption("month",1,12);
			document.getElementById("totalOrder").value="${n}";
			document.getElementById("quantity").value="${num}";
			document.getElementById("totalMoney").value="${money}";
		}
		function query(){
		var mon="0";
		var year=document.getElementById("year").value;
		var month=document.getElementById("month").value;
		if(month<10){
			mon="0"+month;
		}
		location="instockSum?month="+year+"-"+mon;
		}
	
	
	</script>
  </head>
  
  <body onload="inition()">
  <div id="m">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－月度入库报表</td>
  </tr>
</table>

</div>
<div id="add" >
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
	<caption>报表查询</caption>
	 <tr>
    <td class="title1"><font size="2">查询月份</font></td>
    <td class="title1"><select id="year"></select>年<select id="month"></select>月</td>
	</tr>
	<tr>
	<td height="18" colspan="2" align="center"><input type="button" value="查询" onClick="query()"/></td>
	</tr>
	</table>
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
	<caption>入库统计</caption>
  <tr>
    <td class="title1"><font size="2">项目</font></td>
    <td class="title1"><font size="2">内容</font></td>
	</tr>

  <tr>
    <td align="center">入库单据数</td>
    <td align="center"><input type="text" id="totalOrder"/></td>
	</tr>
	 <tr>
    <td align="center">产品总数量</td>
    <td align="center"><input type="text" id="quantity"/></td>
	</tr>
  <tr>
    <td align="center">产品总金额</td>
    <td align="center"><input type="text" id="totalMoney"/></td>
	</tr>
</table>


<table width="100%"  border="0" align="center" cellspacing="1" class="c">
<caption>入库报表明细</caption>
<tr>
    <td class="title1"><font size="2">采购单编号</font></td>
    <td class="title1"><font size="2">名称</font></td>
    <td class="title1"><font size="2">时间</font></td>
    <td class="title1"><font size="2">类型</font></td>
    <td class="title1"><font size="2">数量</font></td>
    <td class="title1"><font size="2">金额</font></td>
</tr>
  <c:forEach items="${requestScope.instockRecord }" var="cate">
  <tr align="center">
    <td><c:out value="${cate.poID }"></c:out></td>
    <td><c:out value="${cate.proName }"></c:out></td>
	<td><c:out value="${cate.stockTime }"></c:out></td>
	<td><c:out value="${cate.type }"></c:out></td>
    <td><c:out value="${cate.num }"></c:out></td>
	<td><c:out value="${cate.itemPrice }"></c:out></td>
  </tr>
 </c:forEach>
</table>
 <div align="center">
    <input type="button" id="dy" value="打印" onClick="window.print()"/>
    <input type="button" id="gb" value="关闭" onClick="window.close()"/>
</div>
</div>
  </body>
</html>

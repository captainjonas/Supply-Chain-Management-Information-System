<%@ page language="java" import="java.util.*" import="com.aowin.dao.SalesDao" import="com.aowin.model.SoItem" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>销售单明细</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/common.js" ></script>
	<script type="text/javascript" src="script/productDiv.js" ></script>

  </head>
  
  <body>
   <table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－出库登记</td>
  </tr>
</table>
 
  <% String soid=request.getParameter("soid");
	SoItem item=new SoItem();
	item=SalesDao.getItem(soid); %> 
 <table width="100%"  border="0" align="center" cellspacing="1" class="c">
  <tr align="center">
    <td>产品编号</td>
    <td><%=item.getProductCode() %></td>
	</tr>
  <tr>
    <td align="center">产品名称</td>
    <td align="center"><%=item.getProductName() %></td>
	</tr>
  <tr>
    <td align="center">产品数量单位</td>
    <td align="center"><%=item.getUnitName() %></td>
    </tr>
    <tr>
    <td align="center">产品数量</td>
    <td align="center"><%=item.getNum() %></td>
   
    </tr>
    <tr align="center">
    <td>采购单价</td>
    <td><%=item.getUnitPrice() %></td>
	</tr>
    <tr>
    <tr align="center">
    <td>产品明细总价</td>
    <td><%=item.getItemPrice() %></td>
	</tr>
	
</table>
   <div align="center">
    <input type="button" id="dy" value="打印" onClick="window.print()"/>
    <input type="button" id="gb" value="关闭" onClick="window.close()"/>
</div>
   
  </body>
</html>

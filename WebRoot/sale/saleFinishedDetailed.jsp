<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script language="javascript" src="script/common.js"
	type="text/javascript"></script>
<script type="text/javascript" src="script/productDiv.js"></script>
<script type="text/javascript" src="script/customer.js"></script>
<script type="text/javascript" src="script/sale.js"></script>
<script language="javascript" type="text/javascript">
	
</script>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		id="maintable">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－销售管理－－销售单详细信息</td>
		</tr>
	</table>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="30px" nowrap class="toolbar">&nbsp;</td>
			<td width="40px" nowrap class="toolbar"></td>
			<td width="20px" nowrap class="toolbar"></td>
			<td width="40px" nowrap class="toolbar"><a></a></td>
			<td nowrap class="toolbar">&nbsp;</td>
			<td width="60px" nowrap class="toolbar">&nbsp;</td>
			<td width="20px" nowrap class="toolbar">&nbsp;</td>
			<td width="60px" nowrap class="toolbar">&nbsp;</td>
			<td width="20px" nowrap class="toolbar">&nbsp;</td>
			<td width="60px" nowrap class="toolbar">&nbsp;</td>
			<td width="20px" nowrap class="toolbar">&nbsp;</td>
			<td width="60px" nowrap class="toolbar">&nbsp;</td>
			<td width="20px" nowrap class="toolbar">&nbsp;</td>
		</tr>
	</table>

	<table width="100%" border="0" align="center" cellspacing="1" class="c">
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
		</tr>
			<tr align="center">
				<td>${sm.soId }</td>
				<td>${sm.createTime}</td>
				<td>${sm.name }</td>
				<td>${sm.account}</td>
				<td>${sm.tipFee }</td>
				<td>${sm.productTotal}</td>
				<td>${sm.soTotal}</td>
				<td>${sm.payType }</td>
				<td>${sm.prePayFee }</td>
				<td>${sm.status }</td>
			</tr>
	</table>
	
	
	<table width="100%"  border="0" align="center" cellspacing="1" id="detailTable">
  <tr>
    <td class="toolbar">&nbsp;</td>
    <td class="toolbar">商品编码</td>
    <td class="toolbar">商品名称</td>
    <td class="toolbar">产品数量</td>
    <td class="toolbar">数量单位</td>
    <td class="toolbar">销售单价</td>
    <td class="toolbar">销售明细总价</td>
    <td class="toolbar">&nbsp;</td>
  </tr>
  <c:forEach items="${cll }" var="soitem" varStatus="i">
			<tr align="center" >
				<td>${i.index+1 }</td>
				<td><input type="text"  name="spbm" size="10" readonly="readonly"  value="${soitem.productCode }"></td>
				<td><input type="text" name="spmc" size="15" readonly="readonly" value="${soitem.productName }"></td>
				<td><input type="text" name="ytsl" size="10"  readonly="readonly" value="${soitem.num }"></td>
				<td><input type="text" name="sptj" size="10" readonly="readonly" value="${soitem.unitName }" ></td>
				<td><input type="text" name="spzl" size="10" readonly="readonly" value="${soitem.unitPrice }" ></td>
				<td><input type="text" name="stsl" size="10" readonly="readonly" value="${soitem.itemPrice }"></td>

			</tr>
		</c:forEach>
  
</table>
	
	
	<br />
	<iframe width="174" height="189" name="gToday:normal:agenda.js"
		id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm"
		scrolling="no" frameborder="0"
		style="visibility: visible; z-index: 999; position: absolute; left: -500px; top: 0px;"></iframe>
</body>

</html>


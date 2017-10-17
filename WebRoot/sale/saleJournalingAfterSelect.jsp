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
	function init2() {
	}
</script>
</head>
<body onLoad="init2()">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		id="maintable">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－业务报表－－月度销售报表</td>
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
	<form action="">
		<table width="100%" border="0" cellspacing="1" cellpadding="0">
			<tr align="center" style="width: 100%">
				<td colspan="5">&nbsp;</td>
				<td>年</td>
				<td><input type="text" id="saleJournalingYear"></td>
				<td>月</td>
				<td><input type="text" id="saleJournalingMonth"></td>
			</tr>

			<tr align="center" style="width: 100%">
				<td colspan="12"><input type="button" value="查询"
					onclick="saleJournaling()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="reset"></td>
			</tr>
		</table>
	</form>
	<table width="100%" border="0" align="center" cellspacing="1" class="c">
		<tr>
			<td class="title1">销售单数</td>
			<td class="title1">已了结单数</td>
			<td class="title1">销售总金额</td>
			<td class="title1">已付款金额</td>

		</tr>
		<tr align="center">
			<td>${soIdNum }</td>
			<td>${count }</td>
			<td>${allSoTotal }</td>
			<td>${allPaid }</td>
		</tr>
	</table>

	<br/><br/>


	<table width="100%" border="0" align="center" cellspacing="1" class="c">
		<tr>
			<td class="title1">销售单编号</td>
			<td class="title1">客户编号</td>
			<td class="title1">客户名称</td>
			<td class="title1">销售日期</td>
			<td class="title1">经手人</td>
			<td class="title1">附加费用</td>
			<td class="title1">销售单总金额</td>
			<td class="title1">未付款金额</td>
			<td class="title1">处理状态</td>
		</tr>
		<c:forEach items="${cl }" var="somain">
			<tr align="center">
				<td><a onClick="showSomainSoitem(this)" class="LL" >${somain.soId }</a></td>
				<td>${somain.customerCode}</td>
				<td>${somain.name }</td>
				<td>${somain.createTime}</td>
				<td>${somain.account}</td>
				<td>${somain.tipFee }</td>
				<td>${somain.soTotal}</td>
				<td>${somain.nonPayment}</td>
				<td>${somain.status}</td>
			</tr>
		</c:forEach>
	</table>

	
	
	<iframe width="174" height="189" name="gToday:normal:agenda.js"
		id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm"
		scrolling="no" frameborder="0"
		style="visibility: visible; z-index: 999; position: absolute; left: -500px; top: 0px;"></iframe>
</body>

</html>


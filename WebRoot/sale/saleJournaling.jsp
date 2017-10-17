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
<script type="text/javascript" src="script/jquery-1.8.1.min.js"></script>
<script language="javascript" type="text/javascript">
	function init4(){	
		document.getElementById("saleJournalingMonth").value="";
		for (var i = 1960; i < 2060; i++) {
		$('#saleJournalingYear').append("<option>"+i+"</option>");	
		};
	}
</script>
</head>
<body onLoad="init4()">
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
				<td colspan="6">&nbsp;</td>
				<td>年</td>
				<td><select id="saleJournalingYear">
						
				</select></td>
				<td>月</td>
				<td><select id="saleJournalingMonth">
						<option>01</option>
						<option>02</option>
						<option>03</option>
						<option>04</option>
						<option>05</option>
						<option>06</option>
						<option>07</option>
						<option>08</option>
						<option>09</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
						
				</select></td>
			</tr>

			<tr align="center" style="width: 100%">
				<td colspan="12"><input type="button" value="查询"
					onclick="saleJournaling()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="reset"></td>
			</tr>
		</table>
	</form>


	<br />

	<iframe width="174" height="189" name="gToday:normal:agenda.js"
		id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm"
		scrolling="no" frameborder="0"
		style="visibility: visible; z-index: 999; position: absolute; left: -500px; top: 0px;"></iframe>
</body>

</html>


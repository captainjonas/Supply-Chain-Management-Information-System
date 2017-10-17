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

<title>My JSP 'customer.jsp' starting page</title>
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
<script language="javascript" type="text/javascript">
	function showMain() {
		document.getElementById("control").style.display = "none";

	}
	function control() {
		document.getElementById("control").style.display = "block";
		document.getElementById("x").value = "add";
	}
</script>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		id="maintable">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－销售管理－－客户管理－－查询</td>
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
				<td colspan="7"></td>
				<td>客户编号</td>
				<td><input type="text" id="selectCustomerCode"></td>
				<td>客户名称</td>
				<td><input type="text" id="selectName"></td>
				<td colspan="7"></td>
			</tr>
			<tr align="center" style="width: 100%">
				<td colspan="12"><input type="button" value="查询" onclick="selectCustomer()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="reset"></td>
			</tr>
		</table>
	</form>

	<table border="0" cellspacing="1" style="float: none;" width="100%">
		<tr>
			<td class="title1">客户编号</td>
			<td class="title1">客户名称</td>
			<td class="title1" style="display: none">密码</td>
			<td class="title1">联系人</td>
			<td class="title1">地址</td>
			<td class="title1">邮政编码</td>
			<td class="title1">注册日期</td>
			<td class="title1">电话</td>
			<td class="title1">传真</td>
		</tr>
		<c:forEach items="${cl }" var="customer">
			<tr align="center">
				<td>${customer.customerCode }</td>
				<td>${customer.name }</td>
				<td style="display: none">${customer.password }</td>
				<td>${customer.contactor}</td>
				<td>${customer.address }</td>
				<td>${customer.postcode }</td>
				<td>${customer.createDate }</td>
				<td>${customer.tel }</td>
				<td>${customer.fax }</td>
			</tr>

		</c:forEach>
		<tr>
			<td class="title1"></td>
		</tr>
	</table>
	<br />
	<!-- <div align="center">
		<input type="button" value="确定" onClick="">&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="取消" name="quit" onClick="">
	</div> -->
	<iframe width="174" height="189" name="gToday:normal:agenda.js"
		id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm"
		scrolling="no" frameborder="0"
		style="visibility: visible; z-index: 999; position: absolute; left: -500px; top: 0px;"></iframe>
</body>

</html>

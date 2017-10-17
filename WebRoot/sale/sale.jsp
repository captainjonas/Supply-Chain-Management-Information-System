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
<script type="text/javascript" src="script/sale.js"></script>
<script type="text/javascript" src="script/jquery-1.8.1.min.js"></script>
</head>
<script type="text/javascript">
	if("${warning}"=="success"){
		alert("保存成功！")
	};
	if("${warning}"=="fail"){
		alert("保存失败！")
	};
	if("${warning}"=="deleteSuccess"){
		alert("删除成功！")
	};
	if("${warning}"=="deleteFail"){
		alert("删除失败！")
	};
	if("${warning}"=="updateSuccess"){
		alert("修改成功！")
	};
	if("${warning}"=="updateFail"){
		alert("修改失败！")
	};
</script>
<body>
	<div id="main">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			id="maintable">
			<tr>
				<td nowrap class="title1">您的位置：工作台面－－销售管理－－新添销售单</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar" onClick="control()"><img
					src="images/new.gif" alt=""><a href="somainAdd">新增</a></td>
				<td width="20px" nowrap class="toolbar"></td>
				<td width="40px" nowrap class="toolbar"></td>
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
		<table width="100%" border="0" align="center" cellspacing="1"
			class="c">
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
				<td class="title1">操作</td>
			</tr>
			<c:forEach items="${cl }" var="somain">
				<tr align="center">
					<td ><a onClick="showSomainSoitem(this)" class="LL" >${somain.soId }</a></td>
					<td>${somain.createTime}</td>
					<td>${somain.name }</td>
					<td>${somain.account}</td>
					<td>${somain.tipFee }</td>
					<td>${somain.productTotal}</td>
					<td>${somain.soTotal}</td>
					<td>${somain.payType }</td>
					<td>${somain.prePayFee }</td>
					<td align="center"><a onClick="updateSomainSoitem(this)"
						class="LL">修改</a> <a onClick="deleteSomainSoitem(this)" class="LL">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>


	<iframe width="174" height="189" name="gToday:normal:agenda.js"
		id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm"
		scrolling="no" frameborder="0"
		style="visibility: visible; z-index: 999; position: absolute; left: -500px; top: 0px;"></iframe>
</body>

</html>


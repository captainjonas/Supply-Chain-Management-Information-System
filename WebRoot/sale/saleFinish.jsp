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
</head>
<script type="text/javascript">
	if("${warning}"=="finishedSuccess"){
		alert("了结成功！")
	};
	if("${warning}"=="finishedFail"){
		alert("了结失败！")
	};
</script>
<body>
	<div id="main">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			id="maintable">
			<tr>
				<td nowrap class="title1">您的位置：工作台面－－销售管理－－销售单了结</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar"></td>
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
		<br/><br/><br/>
		<table width="100%" border="0" align="center" cellspacing="1"
			class="c">
			
			<tr  style="width: 100%">			
				<td  align="left" style="color: black;font-size: 14px;" >货到付款如下</td>
				<td  colspan="10">&nbsp;</td>					
			</tr>
			
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
			<c:forEach items="${cl1 }" var="somain">
				<tr align="center">
					<td><a onClick="showSaleFinishedDetailed(this)" class="LL" >${somain.soId }</a></td>
					<td>${somain.createTime}</td>
					<td>${somain.name }</td>
					<td>${somain.account}</td>
					<td>${somain.tipFee }</td>
					<td>${somain.productTotal}</td>
					<td>${somain.soTotal}</td>
					<td>${somain.payType }</td>
					<td>${somain.prePayFee }</td>
					<td>${somain.status }</td>
					<td align="center"><a onClick="finishSomainSoitem(this)" class="LL">了结</a></td>
				</tr>
			</c:forEach>
			</table>
			<br/><br/><br/>
			<table width="100%" border="0" align="center" cellspacing="1"
			class="c">
			
			<tr  style="width: 100%">			
				<td  align="left" style="color: black;font-size: 14px;" >款到发货如下</td>
				<td  colspan="10">&nbsp;</td>					
			</tr>
			
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
			<c:forEach items="${cl2 }" var="somain">
				<tr align="center">
					<td><a onClick="showSaleFinishedDetailed(this)" class="LL" >${somain.soId }</a></td>
					<td>${somain.createTime}</td>
					<td>${somain.name }</td>
					<td>${somain.account}</td>
					<td>${somain.tipFee }</td>
					<td>${somain.productTotal}</td>
					<td>${somain.soTotal}</td>
					<td>${somain.payType }</td>
					<td>${somain.prePayFee }</td>
					<td>${somain.status }</td>
					<td align="center"><a onClick="finishSomainSoitem(this)" class="LL">了结</a></td>
				</tr>
			</c:forEach>		
			</table>
			<br/><br/><br/>
			<table width="100%" border="0" align="center" cellspacing="1"
			class="c">

			
			<tr  style="width: 100%">			
				<td  align="left" style="color: black;font-size: 14px;" >预付款到发货如下</td>
				<td  colspan="10">&nbsp;</td>					
			</tr>
			
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
			<c:forEach items="${cl3 }" var="somain">
				<tr align="center">
					<td><a onClick="showSaleFinishedDetailed(this)" class="LL" >${somain.soId }</a></td>
					<td>${somain.createTime}</td>
					<td>${somain.name }</td>
					<td>${somain.account}</td>
					<td>${somain.tipFee }</td>
					<td>${somain.productTotal}</td>
					<td>${somain.soTotal}</td>
					<td>${somain.payType }</td>
					<td>${somain.prePayFee }</td>
					<td>${somain.status }</td>
					<td align="center"><a onClick="finishSomainSoitem(this)" class="LL">了结</a></td>
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


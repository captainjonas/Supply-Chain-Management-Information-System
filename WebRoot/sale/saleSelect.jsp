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
	function init3(){
		document.getElementById("saleSelectPayType").value="";
	}
</script>
</head>
<body onLoad="init3()">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"
		id="maintable">
		<tr>
			<td nowrap class="title1">您的位置：工作台面－－销售管理－－销售单查询</td>
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
				<td colspan="3">&nbsp;</td>
				<td>销售单编号</td>
				<td><input type="text" id="saleSelectSOID" ></td>				
				<td>开始日期</td>
				<td><input type="text" id="saleSelectStartDate" name="sjk"><a href="javascript:void(0)" onClick="gfPop.fPopCalendar(document.all.sjk);return false;">
     			 <img name="popcal"  src="images/selectDate.gif" width="15" height="12" border="0" alt=""></a></td>
				
				<td>截至日期</td>
				<td><input type="text" id="saleSelectEndDate" name="sjy"><a href="javascript:void(0)" onClick="gfPop.fPopCalendar(document.all.sjy);return false;">
     			 <img name="popcal"  src="images/selectDate.gif" width="15" height="12" border="0" alt=""></a></td>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr align="center" style="width: 100%">
				<td colspan="3">&nbsp;</td>
				<td>客户名称</td>
				<td><input type="text" id="saleSelectCustomerName"></td>
				<td>付款方式</td>
				<td><select id="saleSelectPayType"  >
					<option ></option>
        			<option >货到付款</option>
           		 	<option >款到发货</option>
            		<option >预付款到发货</option>
       			 </select></td>
				<td>处理状态</td>
				<td><input type="text" id="saleSelectStatus"></td>
				<td colspan="3">&nbsp;</td>
			</tr>
			<tr align="center" style="width: 100%">
				<td colspan="12"><input type="button" value="查询"
					onclick="saleSelectSomain()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
					type="reset"></td>
			</tr>
		</table>
	</form>
	
	
	
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
		<c:forEach items="${cl }" var="somain">
			<tr align="center">
				<td><a onClick="showSomainSoitem(this)" class="LL" >${somain.soId }</a></td>
				<td>${somain.createTime}</td>
				<td>${somain.name }</td>
				<td>${somain.account}</td>
				<td>${somain.tipFee }</td>
				<td>${somain.productTotal}</td>
				<td>${somain.soTotal}</td>
				<td>${somain.payType }</td>
				<td>${somain.prePayFee }</td>
				<td>${somain.status }</td>
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


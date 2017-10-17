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
<script type="text/javascript">
    	alert("${warning}");
</script>
<script language="javascript" type="text/javascript">
	
	function showMain() {
		document.getElementById("control").style.display = "none";
	};
	function control() {
		document.getElementById("control").style.display = "block";
		document.getElementById("x").value="add";
		var date=new Date();		
		var createDate = date.getFullYear()+"-"+(date.getMonth()+1<10?'0'+(date.getMonth()+1):date.getMonth())+"-"+(date.getDate()<10?'0'+date.getDate():date.getDate());
		document.getElementById("ucreateDate").value = createDate;
	};
	function init() {
		var date=new Date();		
		var createDate = date.getFullYear()+"-"+(date.getMonth()+1<10?'0'+(date.getMonth()+1):date.getMonth())+"-"+(date.getDate()<10?'0'+date.getDate():date.getDate());
		document.getElementById("ucreateDate").value = createDate;
	};
</script>
</head>
<body onLoad="init()">
	<div id="main">
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			id="maintable">
			<tr>
				<td nowrap class="title1">您的位置：工作台面－－销售管理－－客户管理</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar" onClick="control()"
					><img
					src="images/new.gif" alt=""><a class="LL">新增</a></td>
				<td width="20px" nowrap class="toolbar">|</td>
				<td width="40px" nowrap class="toolbar"><img
					src="images/search.gif" alt=""><a href="sale/customerSelect.jsp">查询</a></td>
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
			<c:forEach items="${cl}" var="customer" >
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
					
					<td ><a onClick=updateCustomer(this) class="LL">修改</a> 
					<a onClick="deleteCustomer(this)" class="LL">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<br/>
		<br/>
		
	</div>
	<form action="">
	<div id="control" class="control" align="center"
		style="float: none; display: none">
		<table border="0" cellspacing="1" width="240px" height="250px"
			id="controltable">
			<tr>
				<td>客户编号</td>
				<td><input type="text" id="ucustomerCode" /></td>
			</tr>
			<tr>
				<td>客户名称</td>
				<td><input type="text" id="uname"  /></td>
			</tr>
			<tr>
				<td>客户密码</td>
				<td><input type="password" id="upassword" /></td>
			</tr>
			<tr>
				<td>联系人</td>
				<td><input type="text" id="ucontactor" /></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" id="uaddress" /></td>
			</tr>
			<tr>
				<td>邮政编码</td>
				<td><input type="text" id="upostcode" /></td>
			</tr>
			<tr>
				<td>注册日期</td>
				<td><input type="text" id="ucreateDate" name="sjj"/><a href="javascript:void(0)" onClick="gfPop.fPopCalendar(document.all.sjj);">
      <img name="popcal"  src="images/selectDate.gif" width="15" height="12" border="0" alt=""></a></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" id="utel" /></td>
			</tr>
			<tr>
				<td>传真</td>
				<td><input type="text" id="ufax" /></td>
			</tr>
		</table>
		
		<br /> <br /> <input type="button" value="保存" name="save"
			onClick="addCustomer()">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"
			value="取消" name="quit" onClick="showMain()">
			<input type="hidden" id="x">
	</div>
	
	</form>
	<iframe width="174" height="189" name="gToday:normal:agenda.js"
		id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm"
		scrolling="no" frameborder="0"
		style="visibility: visible; z-index: 999; position: absolute; left: -500px; top: 0px;"></iframe>
</body>

</html>

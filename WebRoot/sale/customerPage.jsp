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

	function tdyONchagne(){
	var tdy=document.getElementById("tdyText").value;
	var regTdyText=/^[0-9]{1,}$/;
	if(regTdyText.test(tdy)&&tdy>0&&(tdy<=${all})){
		location="pageSplit?page="+tdy;
	}else{
		alert("输入格式有误，请重新输入！");
	}
}		
    	
</script>
<script language="javascript" type="text/javascript">
	function showMain() {
		document.getElementById("control").style.display = "none";
		document.getElementById("ucustomerCode").value="";
		document.getElementById("uname").value="";
		document.getElementById("upassword").value="";
		document.getElementById("ucontactor").value="";
		document.getElementById("uaddress").value="";
		document.getElementById("upostcode").value="";
		document.getElementById("utel").value="";
		document.getElementById("ufax").value="";
		document.getElementById("ucreateDate").value ="";
	};
	function control() {
		document.getElementById("ucustomerCode").removeAttribute("readonly");
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
		
	if("${warning}"=="addSuccess")	{
		alert("保存成功！");
	};
	if("${warning}"=="addFail")	{
		alert("保存失败！");
	};
	if("${warning}"=="updateSuccess")	{
		alert("修改成功！");
	};
	if("${warning}"=="updateFail")	{
		alert("修改失败！");
	};
	if("${warning}"=="保存成功！")	{
		alert("保存成功！");
	};
	if("${warning}"=="保存失败！")	{
		alert("保存失败！");
	};
	if("${warning}"=="删除成功!")	{
		alert("删除成功！");
	};
	if("${warning}"=="删除失败!")	{
		alert("删除失败！");
	};	
	if("${warning}"=="该客户有未完结的销售单，请先了结完销售单！")	{
		alert("不能删除！该客户有未完结的销售单。");
	};
	if("${warning}"=="customerExit")	{
		alert("该客户已存在,不能重复添加！");
	};
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
			<c:forEach items="${page.data }" var="customer" >
				<tr align="center">
					<td>${customer.customerCode }</td>
					<td>${customer.name }</td>
					<td style="display: none">${customer.password }</td>
					<td>${customer.contactor}</td>
					<td>${customer.address }</td>
					<td>${customer.postcode }</td>
					<td >${customer.createDate }</td>
					<td>${customer.tel }</td>
					<td>${customer.fax }</td>
					
					<td ><a onClick=updateCustomer(this) class="LL">修改</a> 
					<a onClick="deleteCustomer(this)" class="LL">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<br/>
		<br/>
	 <div align="center">
    	<c:choose>
    		<c:when test="${page.currentPage==1 }">
		    	当前第${page.currentPage }页/共${page.totalPage }页
		    	<a href="pageSplit?page=${page.currentPage+1 }">下一页</a>
		    	<a href="pageSplit?page=${page.totalPage }">末页</a>
		    	<input type="text" value=${page.currentPage } onchange="tdyONchagne()" id="tdyText" size="2">特定页
    		</c:when> 
    		<c:when test="${page.currentPage==page.totalPage }">
    			<a href="pageSplit?page=1">首页</a>
    			<a href="pageSplit?page=${page.currentPage-1 }">上一页</a>
    			当前第${page.currentPage }页/共${page.totalPage }页
    			<input type="text" value=${page.currentPage } onchange="tdyONchagne()" id="tdyText" size="2">特定页
    		</c:when>
    		<c:otherwise>
    			<a href="pageSplit?page=1">首页</a>
    			<a href="pageSplit?page=${page.currentPage-1 }">上一页</a>
    			当前第${page.currentPage }页/共${page.totalPage }页
		    	<a href="pageSplit?page=${page.currentPage+1 }">下一页</a>
		    	<a href="pageSplit?page=${page.totalPage }">末页</a>
		    	<input type="text" value=${page.currentPage } onchange="tdyONchagne()" id="tdyText" size="2">特定页
    		</c:otherwise>
    	</c:choose>
    	
    </div>
		
	</div>
	<form action="">
	<div id="control" class="control" align="center"
		style="float: none; display: none">
		<table border="0" cellspacing="1" width="240px" height="250px"
			id="controltable">
			<tr>
				<td>客户编号</td>
				<td><input type="text" id="ucustomerCode" onchange="onchangePassword()" /></td>
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
				<td><input type="text" id="ucreateDate" readonly="readonly" name="sjjj"/></td>
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

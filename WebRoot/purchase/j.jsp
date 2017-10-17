<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>提货</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="/ERP/purchase/jquery-1.8.1.min.js"></script>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../script/common.js"></script>
<script language="javascript" type="text/javascript">

	function query() {
		var params = new Object();
		var bm = new Array(8);
		bm[0] = "bdbh";
		bm[1] = "zt";
		bm[2] = "jzrq";
		bm[3] = "tdr";
		bm[4] = "strq";
		bm[5] = "tdrq";
		bm[6] = "lrrq";
		bm[7] = "lry";
		var mc = new Array(8);
		mc[0] = "表单编号";
		mc[1] = "表单状态";
		mc[2] = "截止日期";
		mc[3] = "填单人";
		mc[4] = "实提日期";
		mc[5] = "填单日期";
		mc[6] = "录入日期";
		mc[7] = "录入员";
		params.bm = bm;
		params.mc = mc;
		params.actionUrl = "";
		window.showModalDialog("../common/cxtj.htm", params, "dialogHeight:400px; dialogWidth:600px; help:no; status:no");
	}
</script>
<script type="text/javascript">
	$(function(){
		if(${not empty requestScope.neww}){
			alert("${requestScope.neww}");
										}
		$("[name=liao]").click(function(){
			var y=confirm("是否确定了结");
			//alert(this.innerHTML);
			alert(this.parentNode.parentNode.cells[0].childNodes[0].innerHTML);
			if(y)location="Finall?poid="+this.parentNode.parentNode.cells[0].childNodes[0].innerHTML;
		});
	});
	var http;
	function cre(){
		if(window.XMLHttpRequest){
				http=new XMLHttpRequest;
			}else{
				http= new ActiveXObject("Microsoft.XMLHTTP");
			}
	};
	function cl(obj){
		//alert(obj)
		cre();
		http.open("get","servlet/Asd?poid="+obj,true);
		http.send(null);
			http.onreadystatechange=function(){
				if(http.readyState==4 && http.status==200){
					//alert();
					$("#div").css('display','block');
					$("#noo tr:gt(0)").remove();
					$("#noo").append(http.responseText);
				}
			};
	}
</script>
</head>

<body>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置:工作台面——采购单了结</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title1">产品单编号</td>
    <td class="title1">创建时间</td>
	<td class="title1">供货商名称</td>
	<td class="title1">创建用户</td>
    <td class="title1">附加费用</td>
       <td class="title1">采购产品总价</td>
          <td class="title1">采购单总价格</td>
          <td class="title1">付款方式</td>
          <td class="title1">最低预付款</td>
          <td class="title1">处理状态</td>		
   			 <td class="title1">操作</td>
  </tr>
  	<c:forEach items="${pl3}" var="ploi">
  		<tr align="center">
  		<td value="${ploi.poid }"><a name= onclick="cl(${ploi.poid })">${ploi.poid }</a></td>
  		<td>${ploi.createtime }</td>
  		<td>${ploi.name }</td>
  		<td>${ploi.account }</td>
  		<td>${ploi.tipfee }</td>
  		<td>${ploi.producttotal }</td>
  		<td>${ploi.pototal }</td>
  		<td>${ploi.paytype }</td>
  		<td>${ploi.prepayfee }</td>
  		<td>${ploi.status }</td>
  		<td><input type="button" name="liao" value="了结"></td>
  	</tr>
  </c:forEach>
  <c:forEach items="${pl2}" var="ploi">
  		<tr align="center">
  		<td value="${ploi.poid }"><a onclick="cl(${ploi.poid })">${ploi.poid }</a></td>
  		<td>${ploi.createtime }</td>
  		<td>${ploi.name }</td>
  		<td>${ploi.account }</td>
  		<td>${ploi.tipfee }</td>
  		<td>${ploi.producttotal }</td>
  		<td>${ploi.pototal }</td>
  		<td>${ploi.paytype }</td>
  		<td>${ploi.prepayfee }</td>
  		<td>${ploi.status }</td>
  		<td><input type="button" name="liao" value="了结"></td>
  	</tr>
  </c:forEach>
  <c:forEach items="${pl1}" var="ploi">
  		<tr align="center">
  		<td value="${ploi.poid }"><a onclick="cl(${ploi.poid })">${ploi.poid }</a></td>
  		<td>${ploi.createtime }</td>
  		<td>${ploi.name }</td>
  		<td>${ploi.account }</td>
  		<td>${ploi.tipfee }</td>
  		<td>${ploi.producttotal }</td>
  		<td>${ploi.pototal }</td>
  		<td>${ploi.paytype }</td>
  		<td>${ploi.prepayfee }</td>
  		<td>${ploi.status }</td>
  		<td><input type="button" name="liao" value="了结"></td>
  	</tr>
  </c:forEach>
  <tr>
  	<td class="title2"></td>
  </tr>
</table>
	<div id="div" style="display:none">
	<table id="noo" width="100%"  border="0" align="center" class="a1">
	<tr>
		<th>产品编号</th>
		<th>产品名称</th>
		<th>数量单位</th>
		<th>数量</th>
		<th>单价</th>
		<th>明细总价</th>
	</tr>
</table>
</div>
</body>
</html>


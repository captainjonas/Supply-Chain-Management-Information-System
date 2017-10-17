
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<base href="<%=basePath%>">
<head>
<title>提货</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js" ></script>
<script type="text/javascript" src="purchase/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="script/productDiv.js" ></script>
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
		window.showModalDialog("common/cxtj.htm", params, "dialogHeight:400px; dialogWidth:600px; help:no; status:no");
	}
	
	
	function update(){
		document.getElementById("m").style.display="none";
		document.getElementById("add").style.display="block";
		}
	function re(){
		document.getElementById("m").style.display="block";
		document.getElementById("add").style.display="none";
		}
		var httpRequest;
		function yo(){
			if(window.XMLHttpRequest){
				httpRequest=new XMLHttpRequest;
			}else{
				httpRequest= new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		function yp(obj){
			//alert(obj);
			yo();
			httpRequest.open("get","servlet/Asd?poid="+obj,true);
			httpRequest.send(null);
			httpRequest.onreadystatechange=function(){
				if(httpRequest.readyState==4 && httpRequest.status==200){
					//alert();
					$("#div").css('display','block');
					$("#noo tr:gt(0)").remove();
					$("#noo").append(httpRequest.responseText);
				}
			};
		}
		
		
</script>
<script type="text/javascript" src="<%=path %>/purchase/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
<div id="m">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－采购报表</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
	<td nowrap class="toolbar">&nbsp;</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
    <td width="20px" nowrap class="toolbar">&nbsp;</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
    <td width="20px" nowrap class="toolbar">&nbsp;</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
    <td width="20px" nowrap class="toolbar">&nbsp;</td>
    <td width="60px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)">&nbsp;</td>
    <td width="20px" nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>
<form action="servlet/Fr">
<table width="100%"  border="0" align="center" cellspacing="2" class="c">
<tr>	
		<td class="title1" colspan="1">起始日期</td>
		<td class="title1" colspan="1"><input type="text" class="Wdate" id="startime" name="startime" onclick="WdatePicker({isShowClear:true})"></td>
		<td class="title1" colspan="1">截止日期</td>
		<td class="title1" colspan="1"><input type="text" class="Wdate" id="startime" name="endtime" onclick="WdatePicker({isShowClear:true})"></td>
		<td class="title1" colspan='2'><input type="submit" value="提交" ></td>
</tr>
  <tr>
    <td class="title1">采购单总数</td>
    <td class="title1"><input type="text" readonly="readonly"  value=${qe }></td>
    <td class="title1">已了结数</td>
    <td class="title1"><input type="text" readonly="readonly" value=${qw }></td>
    <td class="title1">采购单总金额</td>
    <td class="title1"><input type="text" readonly="readonly"  value=${qs }></td>
    <td class="title1">已付款金额</td>
    <td class="title1"><input type="text" readonly="readonly" value=${fl }></td>
  </tr>
  </table>
  <table width="100%"  border="0" align="center" cellspacing="2" class="c">
  <caption>采购单明细</caption>
  <tr>
    <td class="title1">采购单号</td>
    <td class="title1">供货商编号</td>
	<td class="title1">供货商名称</td>
    <td class="title1">采购日期</td>
    <td class="title1">经手人</td>
    <td class="title1">采购单总金额</td>
    <td class="title1">未付款金额</td>
    <td class="title1">采购单状态</td>
  </tr>
  <c:forEach items="${qwes }" var="ploi">
  	<tr align="center">
  		<td><a onclick="yp('${ploi.poid}')">${ploi.poid}</a></td>
  		<td>${ploi.vendercode }</td>
  		<td>${ploi.name }</td>
  		<td>${ploi.createtime }</td>
  		<td>${ploi.account }</td>
  		<td>${ploi.pototal }</td>
  		<c:choose>
  		<c:when test="${ploi.status==3 }">
  			<td>0</td>
  		</c:when>
  		<c:when test="${ploi.status==4 }">
  			<td>0</td>
  		</c:when>
  		<c:when test="${ploi.status==5 }">
  			<td>${ploi.pototal-ploi.prepayfee }</td>
  		</c:when>
  		<c:otherwise>
  		<td>${ploi.pototal }</td>
  		</c:otherwise>
  		</c:choose>
  		<td>${ploi.status }</td>
  	</tr>
  </c:forEach>
</table>
</form>
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
</div>
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>

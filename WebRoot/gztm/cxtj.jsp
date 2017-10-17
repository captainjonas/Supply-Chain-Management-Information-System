<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<title>查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script/common.js"></script>

<script language="javascript" type="text/javascript">	
	var strField;
	function init() {
		var params = window.dialogArguments;
		strField = "<select id='field' name='field'>";
		var bm=new Array("","产品编号","产品名称","库存数量");
		var paramsLength = bm.length;
		var i=0;
		for (i=0; i<paramsLength; i++)
			strField += "<option value='"+bm[i]+"'>"+bm[i]+"</option>";
		strField += "</select>";
		<c:if test="${empty inStock and seek=='yes'}">
			alert("没有查询到相关产品！");
		</c:if>
		<c:if test="${not empty inStock}">
		 document.getElementById("stock").style.visibility="visible";
		</c:if>
		
	}
	
	function addItem() {
		var oRow = detailTable.insertRow();
		oRow.align = "center";
		oCell = oRow.insertCell();
		oCell.innerHTML = strField;
		
		oCell = oRow.insertCell();
		oCell.innerHTML = "<select name='operator'>\
		<option value='='>等于</option>\
 		 <option value='like' selected>类似</option>\
  		<option value='>'>大于</option>\
 		 <option value='<'>小于</option>\
</select>";
		oCell = oRow.insertCell();
		oCell.innerHTML = "<input type='text' id='fieldValue' name='text' size='10'>";

		oCell = oRow.insertCell();
		oCell.innerHTML = "<select id='logic' name='logic'>\
  <option value='and'>并且</option>\
  <option value='or'>或者</option>\
</select>";

		oCell = oRow.insertCell();
		oCell.innerHTML = '<image src="images/delete.gif" class="LL" onclick="delItem('+oRow.rowIndex+')"/>';
	}
	function delItem(index) {
		detailTable.deleteRow(index);
		var rowNum = detailTable.rows.length;
		var rowlength = detailTable.rows[0].cells.length;
		for (i=index; i<rowNum; i++) {
			detailTable.rows(i).cells(0).innerHTML = i;
			detailTable.rows(i).cells(rowlength-1).innerHTML = '<image src="images/delete.gif" class="LL" onclick="delItem('+i+')"/>';
		}
	}
	function query() {
	   var sql="select * from stock where";
	   var leng=detailTable.rows.length;
	   var field=document.getElementsByName("field");
	   var operators=document.getElementsByName("operator");
	   var texts=document.getElementsByName("text");
	   var logics=document.getElementsByName("logic");
	  	var content="";
	   for(var i=1;i<leng;i++){
	   	 var choice=field[i-1].value;
	   	var text=texts[i-1].value;
	   	var flag1=true,flag2=true,flag3=true;
	   	 if(choice=="产品编号"){
	   		 content="ProductCode";
	   		 var reg=/[0-9]{1,6}$/;
	   		 if(!reg.test(text)){
	   		 	flag1=false;
	   		     alert("请输入正确格式，编号1-6个数字");
	   		 }
	   		 
	   	 }else if(choice=="产品名称"){
	   	 	 content="Name";
	   	 	 var reg1=/[\w||\u4e00-\u9fa5]+/;
	   	 	  if(!reg1.test(text)){
	   		 	flag3=false;
	   		     alert("请输入正确格式，汉字、字母、数字或下划线");
	   		 }
	   		 
	   	 }else if (choice=="库存数量"){
	   	   	content="Num";
	   	   	var tNum1=parseInt(text);
	   	   	if(tNum1<0){
	   	   	flag2=false;
	   	   	 alert("请输入符合大于等于0的整数！");
	   	   	}
	   	 }
	   	 sql+=" "+content;
	   	 
	   	 var operator=operators[i-1].value;
	   	  if(operator=="like"){
	   	  	  sql+=" "+operator+" "+"'%"+text+"%'";
	   	  	}else{
	   	  	  sql+= " "+operator+" '"+text+"'";
	   	  	}
	   	  	
	   	  var logic=logics[i-1].value;
	   	  if(i!=leng-1){
	   	  	sql+=" "+logic;
	   	  }	
	   }
		var hidden=document.getElementById("sql");
		hidden.value=sql;
		if(field!=null&flag1&flag2&flag3){
			
			document.getElementById("form").submit();
		}
		
	}
</script>
</head>

<body onLoad="init()">
<form action="query" method="post" id="form">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="addItem()"><img src="images/add.gif">增加</td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="query()"><img src="images/search.gif">查询</td>
    <td width="20px" nowrap class="toolbar">|</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick='window.close()'><img src="images/cancel.gif">取消</td>
	<td nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1" id="detailTable">
  <tr>
    <td class="title1">字段</td>
    <td class="title1">操作</td>
    <td class="title1">内容</td>
    <td class="title1">逻辑</td>
    <td class="title1">&nbsp;</td>
  </tr>
</table>
<input type="hidden" name="sql" id="sql">
</form>
<br><br><br>
<div class="add" id="stock" style="visibility:hidden">
<table width="100%"  border="0" align="center" cellspacing="1">
<caption>产品库存</caption>
  <tr>
    <th>序列号</th>
    <th>产品编号</th>
    <th>产品名称</th>
    <th>数量</th>
    <th>单位</th>
  </tr>
<c:forEach items="${inStock }" var="stock" varStatus="status">
<tr align="center">
	<td><c:out value="${status.index }"></c:out></td>
	<td><c:out value="${stock.proCode }"></c:out></td>
	<td><c:out value="${stock.name }"></c:out></td>
	<td><c:out value="${stock.number }"></c:out></td>
	<td><c:out value="${stock.unit }"></c:out></td>

</tr>
</c:forEach>

</table>
</div>
</body>
</html>

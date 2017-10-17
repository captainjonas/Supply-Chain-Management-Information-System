<%@ page language="java" import="java.util.*" import="com.aowin.dao.CategoryDao" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>提货</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	
	<script language="javascript" src="script/common.js"></script>
	<script type="text/javascript" src="script/productDiv.js" ></script>
	<script language="javascript" type="text/javascript">	

	
	function up(obj){
	var rowUpdate=obj.parentNode.parentNode;
	var id=rowUpdate.cells[0].innerHTML;
	document.getElementById("NO").value=id;
	document.getElementById("upName").value=rowUpdate.cells[1].innerHTML;
	document.getElementById("upMark").value=rowUpdate.cells[2].innerHTML;
	document.getElementById("forNO").submit();
	}
	
		
	function c(){
			window.location.href="gztm/addGoodsClass.jsp";
			}
	function dele(obj){
		var sure=window.confirm("确认要删除此分类吗？");
		if(sure){
		var rowDel=obj.parentNode.parentNode;
		var inde=rowDel.rowIndex;
		var id=rowDel.cells[0].innerHTML;
		var form=document.getElementById("forID");
		var input=document.getElementById("number");
		input.value=id;
		var table=document.getElementById("category");
		table.deleteRow(inde);
		form.submit();
		}
	}
	function start(){
	<c:if test="${empty sessionScope.user}">
		<jsp:forward page="login.jsp"/>
	</c:if>
	<%Object flag=request.getAttribute("delFlag");
	  if(flag!=null){
	%>
	if(!${requestScope.delFlag}){
		alert("该分类下已有产品存在，不能删除该分类！");
	}else{
	  alert("删除成功");
	}
	<%}%>
	}
	
		
		
</script>
  </head>
  
  <body onLoad="start()">

   <div id="m">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－产品分类</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="c()"><img src="images/new.gif">新增</td>
    <td width="20px" nowrap class="toolbar">|</td>
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

<table width="100%"  border="0" align="center" cellspacing="1" class="c" id="category">
  <tr>
    <td class="title1">产品编号</td>
    <td class="title1">名称</td>
	<td class="title1">描述</td>
    <td class="title1">操作</td>
  </tr>
  <%session.setAttribute("category",CategoryDao.getCategories()); %> 
  <c:forEach items="${sessionScope.category }" var="cate">
  <tr align="center">
    <td><c:out value="${cate.categoryID }"></c:out></td>
    <td><c:out value="${cate.name }"></c:out></td>
	<td><c:out value="${cate.remark }"></c:out></td>
    <td><a onClick="up(this)">修改</a>  <a onClick="dele(this)">删除</a></td>
  </tr>
  </c:forEach>
</table>
<form id="forNO" action="gztm/updateGoodsClass.jsp" method="post">
<input type="hidden" id="NO" name="NO">
<input type="hidden"  name="upName" id="upName">
<input type="hidden"  name="upMark" id="upMark">
</form>
</div>

 <form id="forID" action="dele" method="post">
  <input type="hidden" name="number" id="number">
  </form>
  </body>
</html>
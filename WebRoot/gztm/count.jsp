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
    
    <title>提货</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	
	<script language="javascript" src="script/common.js"></script>
	<script type="text/javascript">
	function upd(obj){
	var rowUpdate=obj.parentNode.parentNode;
	var id=rowUpdate.cells[0].innerHTML;
	document.getElementById("NO").value=id;
	document.getElementById("stockNum").value=rowUpdate.cells[2].innerHTML;
	document.getElementById("name").value=rowUpdate.cells[1].innerHTML;
	document.getElementById("unit").value=rowUpdate.cells[5].innerHTML;
	document.getElementById("forID").submit();
	}
	function addoption(id){
			var id=document.getElementById(id);
			for(var i=1;i<=${page.totalPage };i++){
				var opt=document.createElement("option");
				opt.innerHTML=""+i;
				id.add(opt);
			}
		}
		function inition(){
		if(${page.currentPage }==1){
			addoption("first");
		}else if(${page.currentPage }==${page.totalPage }){
			addoption("last");
		}else{
			addoption("middle");
		}
		}
    function go1(){
    var page=document.getElementById("first").value;
  	location="store?page="+page;
    }
    function go2(){
    var page=document.getElementById("last").value;
    location="store?page="+page;
    }
    function go3(){
    var page=document.getElementById("middle").value;
   	location="store?page="+page;
    }
	</script>

  </head>
  
  <body onload="inition()">
    <table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－库存盘点</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">库存盘点表</td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title1">产品单编号</td>
	<td class="title1">名称</td>
    <td class="title1">当前库存</td>
    <td class="title1">采购在途数</td>
    <td class="title1">销售待发数</td>
    <td class="title1">单位</td>
    <td class="title1">操作</td>
  </tr>

  <c:forEach items="${page.data }" var="pro">
  <tr align="center">
 	 <td><c:out value="${pro.productCode }"></c:out></td>
  	 <td><c:out value="${pro.name }"></c:out></td>
  	 <td><c:out value="${pro.stockNum }"></c:out></td>
  	 <td><c:out value="${pro.poNum }"></c:out></td>
     <td><c:out value="${pro.soNum }"></c:out></td>
     <td><c:out value="${pro.unitName }"></c:out></td>
      <td align="center"><a onClick="upd(this)">盘点</a></td>
  </tr>
  </c:forEach>
	</table>
<form id="forID" action="gztm/changCount.jsp" method="post">
<input type="hidden" id="NO" name="NO">
<input type="hidden"  name="stockNum" id="stockNum">
<input type="hidden"  name="name" id="name">
<input type="hidden"  name="unit" id="unit">
</form>
	
	
	<div class="page">
	<center>
		<c:choose>
			<c:when test="${page.currentPage==1 }">
			当前第${page.currentPage }页/共${page.totalPage }页
			<a href="store?page=${page.currentPage+1 }">下一页</a>
			<a href="store?page=${page.totalPage }">末页</a>
			转到：<select id="first"></select>页&nbsp;&nbsp;&nbsp;&nbsp;
		    <input type="button" value="GO" onclick="go1()">
			</c:when>
			<c:when test="${page.currentPage==page.totalPage }">
    			<a href="store?page=1">首页</a>
    			<a href="store?page=${page.currentPage-1 }">上一页</a>
    			当前第${page.currentPage }页/共${page.totalPage }页
    			转到：<select id="last"></select>页&nbsp;&nbsp;&nbsp;&nbsp;
		    	<input type="button" value="GO" onclick="go2()">
    		</c:when>
    		<c:otherwise>
    			<a href="store?page=1">首页</a>
    			<a href="store?page=${page.currentPage-1 }">上一页</a>
    			当前第${page.currentPage }页/共${page.totalPage }页
		    	<a href="store?page=${page.currentPage+1 }">下一页</a>
		    	<a href="store?page=${page.totalPage }">末页</a>
		    	转到：<select id="middle"></select>页&nbsp;&nbsp;&nbsp;&nbsp;
		    	<input type="button" value="GO" onclick="go3()">
    		</c:otherwise>
		</c:choose>
	</center>
	</div>
  </body>
</html>

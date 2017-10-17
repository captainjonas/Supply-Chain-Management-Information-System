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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="purchase/jquery-1.8.1.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js"></script>
<title>标题</title>
<SCRIPT language=JavaScript>
function closeAlert() {
	question = confirm("您要退出系统，确定吗？");
	//alert(question)
  	if(question){	
  		location="servlet/Login_out";
  	}
}
function oi(){
		var date=new Date();
		var h=date.getHours();
		var m=date.getMinutes();
		var s=date.getSeconds();
		if(s<10){
			s="0"+s;
		}
		if(m<10){
			m="0"+m;
		}
		var te=document.getElementById("text");
		//te.interHTML=h+":"+m+":"+s;
		$("#text").find("span").text(h+":"+m+":"+s);
	};
/* function ini(){
	setInterval("oi()",500);
	//oi(); 
};*/
$(function(){
	setInterval("oi()",500);
});

</SCRIPT>
 <script language="javascript">
 if("${param.mess}"=="out"){
	this.parent.location.href="index.jsp";
	//this.parent.topFrame.location.href="title.jsp";
 }
</script>
</head>

<body topmargin=0 leftmargin=0>
<table width="100%" border="0" align="right" cellpadding="0" cellspacing="0" height="25">
  <tr>
    <td class="toolbar">&nbsp;</td>
     <td class="toolbar" id="text"><span></span></td>
    <c:choose>
    	<c:when test="${empty sessionScope.user }"><td class="toolbar" width="45px" onMouseOver="OMO()" onMouseOut="OMOU()" onClick="window.open('login.jsp', 'mainFrame')"><img src="images/jrxt.jpg" border="0">登录</td></c:when>
    	<c:otherwise>
    		<td class="toolbar" width="100px" >欢迎登陆 ${user.name }</td>
    	</c:otherwise>
    </c:choose>
    <td width="20px" nowrap class="toolbar">|</td>
    <td class="toolbar" width="50px" onMouseOver="OMO()" onMouseOut="OMOU()" onClick="closeAlert()">
      <img src="images/lkxt.jpg" border="0">&nbsp;离开</td>
    <td width="20px" nowrap class="toolbar">|</td>
  </tr>
</table>
</body>
</html>

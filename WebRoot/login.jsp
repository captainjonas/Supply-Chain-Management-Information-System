<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js"></script>
 

</head>
<body bgcolor="#ffffff" >
<script type="text/javascript">
function jiao(obj){
	var reg=/^[a-zA-Z]{1,2}[a-zA-Z0-9]{5,17}$/;
	if(reg.test(obj.value)){
		
	}else{
		alert("请按照标准输入");
		obj.value="";
	}
};
</script>
<form action="servlet/Servlet_login" method="post">
<table width="100%"  border="0"  >
	<tr>
		<td class="title1">&nbsp;</td>
	</tr>
  <tr>
    <td width="50%" align="right">用户名&nbsp;&nbsp;</td>
    <td width="50%"><input type="text" name="username" onchange="jiao(this)" id="user"/></td>
  </tr>
  <tr>
    <td align="right">密码&nbsp;&nbsp;&nbsp;</td>
    <td><input type="password" name="password" id="password"/></td>
  </tr>
  <tr>
  	<td class="title1"><div align="right"><input type="submit" value="提交" onclick="dian()"/></div></td>
	<td class="title1"><div align="left"><input type="reset" value="取消"/></div></td>
  </tr>
</table>
</form>


</body>
</html>

<%@ page language="java" import="java.util.*" import="com.aowin.dao.CategoryDao" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateGoodsClass.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="script/common.js" ></script>
	<script type="text/javascript" src="script/productDiv.js" ></script>
	<script type="text/javascript">
		function note(){
  		var sp = document.getElementById("s3");
  		var sp4 = document.getElementById("s4");
  		var e = document.getElementById("tName");
  		var rema = document.getElementById("tRemark");
  		var reg=/^[a-zA-Z0-9\u4e00-\u9fa5]+$/;
  		if(reg.test(e.value)){
  			sp.innerHTML="√";
  			sp.style="color:green;font-size:13px"
  		}
  		else{
  			sp.innerHTML="× 请输入汉字、字母或数字";
  			sp.style="color:red;font-size:13px"
  		}
  		if(reg.test(rema.value)){
  			sp4.innerHTML="√";
  			sp4.style="color:green;font-size:13px"
  		}
  		else{
  			sp4.innerHTML="× 请输入汉字、字母或数字";
  			sp4.style="color:red;font-size:13px"
  		}
  	}
	function update(){
	var form=document.getElementById("update");
		var iName=document.getElementById("name");
		var iRemark=document.getElementById("remark");
		var cName=document.getElementById("tName").value;
		var cMark=document.getElementById("tRemark").value;
		if(cName==null){
			alert("名称不能为空！");
		}else{
			iName.value=cName;
			iRemark.value=cMark;
			form.submit();
		}
	
	
	}
	
	
	
	</script>
  </head>
  
 <body>
<div id="m">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－产品分类</td>
  </tr>
</table>

</div>
<div id="add" >
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
  <tr>
    <td class="title1"><font size="2">项目</font></td>
    <td class="title1"><font size="2">内容</font></td>
	</tr>
	<%int no=Integer.valueOf(request.getParameter("NO"));
	 String upName=request.getParameter("upName");
	 String upMark=request.getParameter("upMark");
	 %>
  <tr>
    <td align="center">分类序号</td>
    <td align="center"><input type="text" readonly="readonly" value=<%=no %>></td>
	</tr>
  <tr>
    <td align="center">名称</td>
    <td align="center"><input type="text" id="tName"  value='<%=upName %>' onchange="note()"><span id="s3"></span></td>
	</tr>
  <tr>
    <td align="center">描述</td>
    <td align="center"><input type="text" id="tRemark" value='<%=upMark %>' onchange="note()"><span id="s4"></span></td>
	</tr>
  <tr>
    <td height="18" colspan="2" align="center"><input type="button" value="修改" onClick="update()"/></td>
  </tr>
</table>
<form id="update" method="post" action="update">
<input type="hidden" name="name" id="name">
<input type="hidden" name="remark" id="remark">
<input type="hidden" name="no" value="<%=no %>">
</form>

</div>

<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>

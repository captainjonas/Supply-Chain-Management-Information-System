<%@ page language="java" import="java.util.*" import="com.aowin.model.User" import="com.aowin.dao.CategoryDao" import="java.util.regex.Matcher" import="java.util.regex.Pattern" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="script/productDiv.js" ></script>
<%String stockNum=request.getParameter("stockNum");
  int sto=Integer.valueOf(stockNum);
  String name=request.getParameter("name");
  String unitName=request.getParameter("unit");
  String id=request.getParameter("NO");
  String reg="[0-9]+";
  Pattern p=Pattern.compile(reg);
  Matcher m=p.matcher(id);
  String code="";
  if(m.find()){
      code=m.group();
   }
  
  session.setAttribute("proCode",code);
  session.setAttribute("unitName",unitName);
  session.setAttribute("name",name);
  String nam=((User)session.getAttribute("user")).getName();
 %>
<script language="javascript" type="text/javascript">
		function not(){
  		var sp = document.getElementById("s3");
  		var e = document.getElementById("cNumber");
  		var reg=/\d+/;
  		if(reg.test(e.value)){
  			sp.innerHTML="√";
  			sp.style="color:green;font-size:13px"
  		}
  		else{
  			sp.innerHTML="× 请输入整数";
  			sp.style="color:red;font-size:13px"
  		}
  	}
	function updat(){
		var form=document.getElementById("change");
		var iNumber=document.getElementById("realNum");
		var iType=document.getElementById("type");
		var cNumber=document.getElementById("cNumber").value;
		var cTy=document.getElementsByName("ty");
		var cType="损耗";
		if(cTy[1].checked){
			cType="盈余";
		}
		var cDescription=document.getElementById("cDescription").value;
		var cTime=document.getElementById("cTime").value;
		
			iNumber.value=cNumber;
			iType.value=cType;
			document.getElementById("description").value=cDescription;
			document.getElementById("time").value=cTime;
			document.getElementById("createUser").value="<%=nam%>";
			if(cNumber+<%=sto%>>=0){
				form.submit();
			}else{
			 alert("盘点后库存为负数，请重新盘点！")
			}
		
		}
</script>
</head>

<body>
<div id="m">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" id="m">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－库存盘点</td>
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

<div id="add">
	<table width="100%"  border="0" align="center" cellspacing="1" class="c">
  <tr align="center">
    <td>变化数量(减少填负数)</td>
    <td><input id="cNumber" onChange="not()"><span id="s3"></span></td>
	</tr>
  <tr>
    <td align="center">变化类型</td>
    <td align="center"><input id="cType" type="radio" value="损耗" name="ty" checked/>损耗<input id="cType" type="radio" value="盈余" name="ty"/>盈余</td>
	</tr>
  <tr>
    <td align="center">原因</td>
    <td align="center"><input id="cDescription" type="text"/></td>
    </tr>
    <tr>
    <td align="center">时间</td>
    <td align="center">
    	<input name="jzrq" type="text" size="15"  readonly="readonly" id="cTime">
      <span class="requred_symbol">*</span>
      <a href="javascript:void(0)" onClick="gfPop.fPopCalendar(document.all.jzrq);return false;">
      <img name="popcal"  src="images/selectDate.gif" width="15" height="12" border="0" alt=""></a>
    </td>
    <tr>
    <td height="18" colspan="2" align="center"><input type="button" value="更新" onClick="updat()"/></td>
  	</tr>
</table>
<form id="change" method="post" action="chang">
<input type="hidden" name="realNum" id="realNum">
<input type="hidden" name="type" id="type">
<input type="hidden" name="description" id="description">
<input type="hidden" name="time" id="time">
<input type="hidden" name="createUser" id="createUser">
<input type="hidden" name="Num" id="Num" value=<%=stockNum %>>
</form>

</div>
</div>

<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>

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
    <title>My JSP 'provider.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <script type="text/javascript" src="purchase/js/jquery-1.8.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script/productDiv.js" ></script>
<script language="javascript" src="script/common.js"></script>
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
	</script>
<style type="text/css"> 
.div{
	padding-left:40%;
	padding-top: 50px;
}
</style>
</head>
  
 <body>
  <font size="1"><script type="text/javascript">
$(function(){
	if(${not empty requestScope.boo}){
		alert("${requestScope.boo}");
	}
	if(${not empty requestScope.bur}){
		alert("${requestScope.bur}")
	}
	if(${not empty requestScope.qwer}){
		alert("${requestScope.qwer}");
	}
	if(${not empty requestScope.bw}){
		alert("${requestScope.bw}")
	}
	if(${not empty requestScope.zx}){
		alert("${requestScope.zx}")
	}
	if(${not empty requestScope.x}){
		alert("${requestScope.x}")
	}
});
  	function xin(){
  		$("#h1").val("新增");
  		var q = document.getElementById("q");
  	var w = document.getElementById("w");
  	var e = document.getElementById("e");
  	var r = document.getElementById("r");
  	var t = document.getElementById("t");
  	var y = document.getElementById("y");
  	var u = document.getElementById("u");
  	var i = document.getElementById("i");
  		$("#q").removeAttr('readonly','readonly');
 		$("span").text(" ");
  		q.value="";
  		w.value="";
  		e.value="";
  		r.value="";
  		t.value="";
  		y.value="";
  		u.value="";
  		i.value="";
  		document.getElementById("div").style="display:block";
  		var date=new Date();
  		var y=document.getElementById("date");
  		y.value=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
  		
  	}
  	function qw(obj){
  	var q = document.getElementById("q");
  	//alert(q);
  		//alert(q.value)
  	var sp = document.getElementById("s1");
  	$("#e").val(q.value);
  	//alert(sp);
  	//sp.value="1";
  		var reg=/^[a-zA-Z0-9]{4,20}$/;
  		//alert(obj.value)
  		//alert(reg.test(obj.value))
  		if(reg.test(q.value)){
  			sp.innerHTML="√";
  			sp.style="color:green"
  		}
  		else{
  			sp.innerHTML="x";
  			sp.style="color:red"
  		}
  	}
  	function ji(){
  	var q = document.getElementById("q");
  	var w = document.getElementById("w");
  	var e = document.getElementById("e");
  	var r = document.getElementById("r");
  	var t = document.getElementById("t");
  	var y = document.getElementById("y");
  	var u = document.getElementById("u");
  	var i = document.getElementById("i");
  		q.value="";
  		w.value="";
  		e.value="";
  		r.value="";
  		t.value="";
  		y.value="";
  		u.value="";
  		i.value="";
  		$("span").text(" ");
  	}
  	function we(){
  		var reg=/^\S{1,100}$/;
  			var sp = document.getElementById("s2");
  		var w = document.getElementById("w");
  		if(reg.test(w.value)){
  			sp.innerHTML="√";
  			sp.style="color:green"
  		}
  		else{
  			sp.innerHTML="x";
  			sp.style="color:red"
  		}
  	}
  	function re(){
  		var sp = document.getElementById("s4");
  		var r = document.getElementById("r");
  		var reg=/^\S+$/;
  		if(reg.test(r.value)){
  			sp.innerHTML="√";
  			sp.style="color:green";
  		}
  		else{
  			sp.innerHTML="x";
  			sp.style="color:red";
  		}
  		}
 		function ee(){
  		var sp = document.getElementById("s3");
  		var e = document.getElementById("e");
  		var reg=/^[a-zA-Z0-9]{4,20}$/;
  		if(reg.test(e.value)){
  			sp.innerHTML="√";
  			sp.style="color:green"
  		}
  		else{
  			sp.innerHTML="x";
  			sp.style="color:red"
  		}
  	}
  	function te(){
  	//alert($("#t").val());
  		var reg=/^\S+$/;
  		var sp=document.getElementById("s5");
  		if(reg.test($("#t").val())){
  		sp.innerHTML="√";
  			sp.style="color:green"
  		}
  		else{
  			sp.innerHTML="x";
  			sp.style="color:red"
  		}
  	}
  	function ye(){
  		var sp=document.getElementById("s6");
  		var reg=/^\S+$/;
  		if(reg.test($("#y").val())){
  		sp.innerHTML="√";
  			sp.style="color:green"
  		}
  		else{
  			sp.innerHTML="x";
  			sp.style="color:red"
  		}
  	}
  	function ue(){
  		var sp=document.getElementById("s8");
  		var reg=/^\S+$/;
  		if(reg.test($("#u").val())){
  		sp.innerHTML="√";
  			sp.style="color:green"
  		}
  		else{
  			sp.innerHTML="x";
  			sp.style="color:red"
  		}
  	} 
  	function ie(){
  		var sp=document.getElementById("s9");
  		var reg=/^\S+$/;
  		if(reg.test($("#i").val())){
  		sp.innerHTML="√";
  			sp.style="color:green"
  		}
  		else{
  			sp.innerHTML="x";
  			sp.style="color:red"
  		}
  	}
  	function hid(){
  		document.getElementById("div").style="display:none";
  	
  	}
  	function seve(){
  	var flag = true;
  	var q = document.getElementById("q");
  	//alert($("#q").val()==(""));
  	//alert(q.value=="")
  	var w = document.getElementById("w");
  	var e = document.getElementById("e");
  	var r = document.getElementById("r");
  	var t = document.getElementById("t");
  	var y = document.getElementById("y");
  	var u = document.getElementById("u");
  	var i = document.getElementById("i");
  		var sp = document.getElementById("s1");
  		var sp2 = document.getElementById("s2");
  		var sp3= document.getElementById("s3");
  		var sp4 = document.getElementById("s4");
  		var sp5 = document.getElementById("s5");
  		var sp6 = document.getElementById("s6");
  		var sp8 = document.getElementById("s8");
  		var sp9 = document.getElementById("s9");
  		if(q.value==("")||sp.innerHTML=="x"||w.value==""||sp2.innerHTML=="x"||e.value==""||sp3.innerHTML=="x"||r.value==""||sp4.innerHTML=="x"||t.value==""||sp5.innerHTML=="x"||y.value==""||sp6.innerHTML=="x"||u.value==""||sp8.innerHTML=="x"||i.value==""||sp9.innerHTML=="x"){
  			flag=false;
  		}
  		if(flag){
  		document.getElementById("div").style="display:none";
  			$('#form').submit();
  			
  		}else{
  			alert("请认真输入");
  				var q = document.getElementById("q");
  	var w = document.getElementById("w");
  	var e = document.getElementById("e");
  	var r = document.getElementById("r");
  	var t = document.getElementById("t");
  	var y = document.getElementById("y");
  	var u = document.getElementById("u");
  	var i = document.getElementById("i");
 		$("span").text(" ");
  		q.value="";
  		w.value="";
  		e.value="";
  		r.value="";
  		t.value="";
  		y.value="";
  		u.value="";
  		i.value="";
  		}
  	}
  	$(function(){
  		$(":button[value=修改]").live("click",function(){
  			var tr = $(this).parent().parent();
  			var q1=tr.find("td:eq(0)").text();
  			var q2=tr.find("td:eq(1)").text();
  			var q3=tr.find("td:eq(2)").text();
  			var q4=tr.find("td:eq(3)").text();
  			var q5=tr.find("td:eq(4)").text();
  			var q6=tr.find("td:eq(5)").text();
  			var q7=tr.find("td:eq(6)").text();
  			var q8=tr.find("td:eq(7)").text();
	var q = document.getElementById("q");
	var date = document.getElementById("date");
  	var w = document.getElementById("w");
  	var e = document.getElementById("e");
  	var r = document.getElementById("r");
  	var t = document.getElementById("t");
  	var y = document.getElementById("y");
  	var u = document.getElementById("u");
  	var i = document.getElementById("i");
  	q.value=q1;
  	$("#q").attr('readonly','readonly');
  	w.value=q2;
  	r.value=q3;
  	t.value=q4;
  	y.value=q5;
  	date.value=q6;	
  	u.value=q7;
  	i.value=q8;
  		document.getElementById("div").style="display:block";
  		$("#h1").val("修改");
  	
  			
  		})
  	});
  		$(function(){
  			$(":button[value=删除]").live("click",function(){
  				var tr = $(this).parent().parent();
  				var t=tr.find("td:eq(0)").text();
  				var i=confirm("确认删除吗");
  				if(i){
  					location="servlet/Delete?q="+t;
  				}
  			})
  		});
  		
  
  </script></font>
 <table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面——供应商管理</td>
  </tr>
</table>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
    <td width="40px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onclick="xin()"><img src="images/new.gif">新增</td>
    <td width="20px" nowrap class="toolbar">|</td>
	<td nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title1">供应商编号</td>
    <td class="title1">供应商名称</td>
	<td class="title1">联系人</td>
	<td class="title1">地址</td>
    <td class="title1">邮政编码</td>
 
    <td class="title1">注册日期</td>
    <td class="title1">电话</td>
    <td class="title1">传真</td>
    <td class="title1">操作</td>
  </tr>
<c:forEach items="${page.pageyu }" var="Customer">
<tr align="center">
	<td>${Customer.customercode }</td>
	<td>${Customer.name }</td>
	<td>${Customer.contactor }</td>
	<td>${Customer.address }</td>
	<td>${Customer.postcode }</td>
	<td>${Customer.createdate }</td>
	<td>${Customer.tel }</td>
	<td>${Customer.fax }</td>
	<td><input type="button" value="删除" ><input type="button" value="修改" onclick="xiu(this)"></td>
</tr>
	
</c:forEach>
    
</table>
<div>
<center>
    	<c:choose>
    	<c:when test="${page.nowpage==1&&page.nowpage==page.allpage }">
		    	当前第${page.nowpage }页/共${page.allpage }页
		    	共${in }条数据
    		</c:when>
    		<c:when test="${page.nowpage==1 }">
		    	当前第${page.nowpage }页/共${page.allpage }页
		    	共${in }条数据
		    	<a href="servlet/Cur?page=${page.nowpage+1 }">下一页</a>
		    	<a href="servlet/Cur?page=${page.allpage }">末页</a>
    		</c:when>
    		<c:when test="${page.nowpage==page.allpage }">
    			<a href="servlet/Cur?page=1">首页</a>
    			<a href="servlet/Cur?page=${page.nowpage-1 }">上一页</a>
    			当前第${page.nowpage }页/共${page.allpage }页
    			共${in }条数据
    		</c:when>
    		<c:otherwise>
    			<a href="servlet/Cur?page=1">首页</a>
    			<a href="servlet/Cur?page=${page.nowpage-1 }">上一页</a>
    			当前第${page.nowpage }页/共${page.allpage }页
    			共${in }条数据
		    	<a href="servlet/Cur?page=${page.nowpage+1 }">下一页</a>
		    	<a href="servlet/Cur?page=${page.allpage }">末页</a>
    		</c:otherwise>
    	</c:choose>
    	<select id="serlect"  value="${page.nowpage }">
    		<c:forEach items="${jihe }" var="inter">
    		<option value="${inter.inter }" onclick="jiu(this)" <c:if test="${inter.inter==page.nowpage}">selected="selected"</c:if>>${inter.inter }</option>
    		</c:forEach>
    	</select>
    	</center>
    </div>
    <div class="div" style="display: none" id="div">
    <form action="servlet/pro" method="post" id="form">
    	<table class="table" width="270px" height="350px" border="1px" cellspacing="0" style="border-color:#E7E6E8">
    		<tr>
    		<td>供应商编号：</td>
    		<td align="center"><input type="text" onchange="qw(this)" id="q" name="q"><span id="s1"></span></td>
    		</tr>
    		<tr>
    		<td>供应商姓名：</td>
    		<td align="center"><input type="text" onchange="we(this)" id="w" name="w"><span id="s2"></span></td>
    		</tr>
    		<tr>
    		<td>供应商密码：</td>
    		<td align="center"><input type="password" onchange="ee(this)" id="e" name="e"><span id="s3"></span></td>
    		</tr>
    		<tr>
    		<td>联系人：</td>
    		<td align="center"><input type="text" onchange="re(this)" id="r" name="r"><span id="s4"></span></td>
    		</tr>
    		<tr>
    		<td>地址：</td>
    		<td align="center"><input type="text" onchange="te(this)" id="t" name="t"><span id="s5"></span></td>
    		</tr>
    		<tr>
    		<td>邮政编码：</td>
    		<td align="center"><input type="text" onchange="ye(this)" id="y" name="y"><span id="s6"></span></td>
    		</tr>
    		<tr>
    		<td>注册日期：</td>
    		<td align="center"><input type="text" id="date" readonly="readonly" name="u"></td>
    		</tr>
    		<tr>
    		<td>电话：</td>
    		<td align="center"><input type="text" onchange="ue(this)" id="u" name="i"><span id="s8"></span></td>
    		</tr>
    		<tr>
    		<td>传真：</td>
    		<td align="center"><input type="text" onchange="ie(this)" id="i" name="o"><span id="s9"></span></td>
    		</tr>
    		
    		<input type="hidden" name="hi" id="h1"/>

    		<tr align="center">
    		<td><input type="button" value="保存" onclick="seve()"></td>
    		<td><input type="button" value="重置" onclick="ji()"/><input type="button" value="取消" onclick="hid()"/></td>
    		</tr>
    	</table>
    	</form>
    </div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>采购管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/ERP/purchase/jquery-1.8.1.min.js"></script>
<script language="javascript" src="../script/common.js"></script>
<script language="javascript">
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
		window.showModalDialog("../common/cxtj.htm", params,
				"dialogHeight:400px; dialogWidth:600px; help:no; status:no");
	}
</script>
<script type="text/javascript">
	var t=0;
	var u=0;
	var i=0;
									var sun=0;
									var suni=0;
									$(function(){
										if(${not empty requestScope.pol}){
										alert("${requestScope.pol}");
										}
										if(${not empty requestScope.yui}){
										alert("${requestScope.yui}");
										}
											if(${not empty requestScope.yiu}){
										alert("${requestScope.yiu}");
										}
											if(${not empty requestScope.qwe}){
										alert("${requestScope.qwe}");
										}
											if(${not empty requestScope.bol}){
										alert("${requestScope.bol}");
										var d1 = document.getElementById("div1");
										var d2 = document.getElementById("div");
										var d3 = document.getElementById("productDiv");
										d1.style.display = "none";
										d2.style = "display:block";
										d3.style = "display:none";
										}
										if(${not empty requestScope.bo2}){
										alert("${requestScope.bol}");
										var d1 = document.getElementById("div1");
										var d2 = document.getElementById("div");
										var d3 = document.getElementById("productDiv");
										d1.style.display = "none";
										d2.style = "display:block";
										d3.style = "display:none";
										}
											if(${not empty requestScope.shi}){
										alert("${requestScope.shi}");
										}
											if(${not empty requestScope.kimi}){
										alert("${requestScope.kimi}");
										}
											if(${not empty requestScope.qunide}){
										alert("${requestScope.qunide}");
										}
											if(${not empty requestScope.plo}){
										alert("${requestScope.plo}");
										}
											if(${not empty requestScope.mkl}){
										alert("${requestScope.mkl}");
										}
										});
	function qw() {
		var d1 = document.getElementById("div1");
		var d2 = document.getElementById("div");
		var d3 = document.getElementById("productDiv");
		var date = new Date();
		var day = date.getDate();
		var month = date.getMonth() + 1;
		var year = date.getFullYear();
		var q = date.getHours();
		var w = date.getMinutes();
		var r = date.getSeconds();
		d1.style.display = "none";
		d2.style = "display:block";
		d3.style = "display:none";
		$("#cai").val(year + "" + month + "" + day + "" + q + "" + w + "" + r);
	}

	$(function(){
		$("#se").click(function(){
			if($("#se").val()=="预付款到发货"){
				$("#yu").removeAttr("readOnly")
			}else{
				$("#yu").attr("readOnly","readOnly");
			}
		})
	});
	function on(obj){
		var reg=/^[0-9]{1,}(?:.[0-9]{0,2})?$/;
		if(reg.test(obj.value)){
			u=obj.value;
		}else{
			alert("请输入数字");
			obj.value="0";
		}
	}
	function liu(obj){
		var reg=/^[0-9]{1,}(?:.[0-9]{0,2})?$/;
		if(reg.test(obj.value)){
			i=obj.value;
		}else{
			alert("请输入数字");
			obj.value="0";
		}
	}
	$(function() {
		var i = 0;
		$("#img1").live("click",function() {
							i++;
							var index=$("#detailTable").find("tr").length;
							var t=true;
							for(var i=0;i<index;i++){
								if($("[name=tc]:eq("+i+")").val()==""){
									t=false;
								}
							}
							if(t){
							$("#detailTable")
									.append(
											"<tr align='center'><td align='center'>"
													+ i
													+ "</td><td><input type='text' name='te'><img src='../images/selectDate.gif' name='dian'></td><td><input type='text' name='shan'></td><td><input type='text'  name='ta'></td><td><input type='text' name='tb'></td><td><input type='text' name='ted'></td><td><input type='text' name='tc'  readonly='readonly' ></td><td align='center'><img src='images/delete.gif' onclick='ji(this)' id='idp'/></td></tr>");
													}
						});	
						$("[name=ted]").live({'click':function(){
						var td=this.parentNode;//被点击的列
						var tr=td.parentNode;//被点击的行
						t=tr.rowIndex;//点的是第几行
						
							p=t-1;
							//alert($("[name=number]:eq("+p+")").val());
							yui=$("[name=tc]:eq("+p+")").val();
							//alert(yui);
						},'change':function(){
							var reg=/^\+?(0|[1-9][0-9]*)$/;
							if(reg.test($("[name=ted]:eq("+p+")").val())){
								yuj=$("[name='tc']:eq("+p+")").val(($("[name=ted]:eq("+p+")").val()-0)*($("[name=tb]:eq("+p+")").val()-0));
								//alert(yuj.val())
								//alert(yuj.val());
								var table=$("#spxxTable");
								var y=$("#detailTable tr").length;
									sun=0;
								for(var i=0;i<(y-1);i++){
									sun=(sun-0)+($("[name=tc]:eq("+i+")").val()-0);
									//alert(sun);
								}
								//alert(sun);
								$("#allprice").val(sun-0);
								$("#alle").val((sun-0)+($("#fu").val()-0)+($("#yu").val()-0));
							}else{
								alert("请输入整数");
								$("[name='number']:eq("+p+")").val(0);
								$("#allprice").val($("#allprice").val()-yui);
								$("#alle").val($("#alle").val()-yui);
								$("[name=tc]:eq("+p+")").val(0);
							};
						}
		});
						$("[name=tb]").live({'click':function(){
						var td=this.parentNode;//被点击的列
						var tr=td.parentNode;//被点击的行
						t=tr.rowIndex;//点的是第几行
						
							p=t-1;
							//alert($("[name=number]:eq("+p+")").val());
							yui=$("[name=tc]:eq("+p+")").val();
							//alert(yui);
						},'change':function(){
							var reg=/^[0-9]{1,}(?:.[0-9]{0,2})?$/;
							if(reg.test($("[name=tb]:eq("+p+")").val())){
							//alert($("[name='unitprice']:eq("+p+")").val()-0);
								yuj=$("[name='tc']:eq("+p+")").val(($("[name=ted]:eq("+p+")").val()-0)*($("[name=tb]:eq("+p+")").val()-0));
								//alert(yuj.val())
								//alert(yuj.val());
								var table=$("#spxxTable");
								var y=$("#detailTable tr").length;
								//alert(sun+($("[name=teval]:eq("+0+")").val()-0));
									sun=0;
								for(var i=0;i<(y-1);i++){
									sun=(sun-0)+($("[name=tc]:eq("+i+")").val()-0);
									//alert(sun);
								}
								//alert(sun);
								$("#allprice").val(sun-0);
								$("#alle").val((sun-0)+($("#fu").val()-0)+($("#yu").val()-0));
							}else{
								alert("请输入2位小数");
								$("[name='ted']:eq("+p+")").val(0);
								$("#allprice").val($("#allprice").val()-yui);
								$("#alle").val($("#alle").val()-yui);
								$("[name=tc]:eq("+p+")").val(0);
							};
						}
		});
						$("[name=dian]").live('click',function(){
						var td=this.parentNode;
						var tr=td.parentNode;
  							//alert('点击了第'+(tr.rowIndex+1)+'行，第'+(td.cellIndex+1)+'列');
  							t=tr.rowIndex;
							$("#div").css('display','none');
							$("#productDiv").css('display','block');
						});
						//type后面的属性 要加： 否者 寻找目标太多
						$("#que1").click(function(){//find("td:rq(x)")表示在这个对象中找td属性的第x对象
									var  flag=true;
						var table=$("#detailTable");
						// $("table").find("tr").eq(row).find("td").eq(col).text()
						var tr=table.find("tr").eq(t);
						//alert(tr.text())
						//alert(table.find("tr").index())
						for(var j=0;j<=table.find("tr").index();j++){
							if(table.find("tr").eq(j).find("td").eq(1).find("input:text").val()==($(":radio:checked").parent().parent().find("td:eq(1)").text())){
								flag=false;
							}
							//alert(flag)
						}
						if(!flag){
							alert("该商品已经存在，不能重复选择");
						}else{
						tr.find("td").eq(1).html("<input type='text' name='te' readonly='readonly' value="+($(":radio:checked").parent().parent().find("td:eq(1)").text())+"><img src='../images/selectDate.gif' name='dian'>");
						//$("#detailTable").find("tr:eq("+t+")").find("td:eq(1)").val($(":radio:checked").parent().parent().find("td:eq(1)").text());
						tr.find("td").eq(2).html("<input type='text' name='shan' readonly='readonly'  value="+($(":radio:checked").parent().parent().find("td:eq(3)").text())+">");
						tr.find("td").eq(3).html("<input type='text' name='ta' readonly='readonly'  value="+($(":radio:checked").parent().parent().find("td:eq(4)").text())+">");
						tr.find("td").eq(4).html("<input type='text' name='tb'  value="+($(":radio:checked").parent().parent().find("td:eq(5)").text())+">");
						//$(":radio:checked").attr("checked","false");
						$("#div").css('display','block');
						$("#productDiv").css('display','none');
						}
						});	
						});				
	function ji(obj) {
		var row = obj.parentNode.parentNode;
		var index = row.rowIndex;
		var table = document.getElementById("detailTable");
		//alert($("#detailTable").find("tr").eq(index).find("td").eq(6).find("input:text").val());
		sun=sun-($("#detailTable").find("tr").eq(index).find("td").eq(6).find("input:text").val()); 
		//alert(sun)
		$("#headTable").find("tr").eq(1).find("td").eq(3).html("<input type='text' name='allprice' readonly='readonly'  value="+sun+">");
		suni=sun+($("#yu").val()-0)+($("#fu").val()-0);
		alert(suni)
		$("#headTable").find("tr").eq(1).find("td").eq(5).html("<input type='text' name='all' readonly='readonly' value= "+suni+">");
		table.deleteRow(index);
		//var text=table.rows[index].cells;
		//sun-($("#detailTable").find("tr").eq().find("td"))
	}
	function shanchu(obj){
		var i=confirm("确认删除吗");
		var tr=obj.parentNode.parentNode;
		if(i){location="Del?po1="+tr.cells[0].innerHTML+"&po2="+tr.cells[1].innerHTML+"&po3="+tr.cells[2].innerHTML+"&po4="+tr.cells[3].innerHTML+"&po5="+tr.cells[4].innerHTML+"&po6="+tr.cells[5].innerHTML+"&po7="+tr.cells[6].innerHTML+"&po8="+tr.cells[7].innerHTML+"&po9="+tr.cells[8].innerHTML}
		
	}
	function xiugai(obj){
		var tr=obj.parentNode.parentNode;
		location="Chuang?po1="+tr.cells[0].innerHTML+"&po2="+tr.cells[1].innerHTML+"&po3="+tr.cells[2].innerHTML+"&po4="+tr.cells[3].innerHTML+"&po5="+tr.cells[4].innerHTML+"&po6="+tr.cells[5].innerHTML+"&po7="+tr.cells[6].innerHTML+"&po8="+tr.cells[7].innerHTML+"&po9="+tr.cells[8].innerHTML
	}
	function res(){
		$("[name=ra]").removeAttr("checked");
	}
	
</script>
</head>

<body>
	<div id="div1">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td nowrap class="title1">您的位置:工作台面——采购单管理</td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap class="toolbar">&nbsp;</td>
				<td width="40px" nowrap class="toolbar" onclick="qw()" onMouseOver="OMO(event)" onMouseOut="OMOU(event)"><img
					src="../images/new.gif">新增</td>
				<td width="20px" nowrap class="toolbar">|</td>
				<td nowrap class="toolbar">&nbsp;</td>
				<td width="60px" nowrap class="toolbar" >&nbsp;</td>

			</tr>
		</table>
		<table width="100%" border="0" align="center" cellspacing="1">
			<tr>
				<td class="title1">采购单编号</td>
				<td class="title1">创建时间</td>
				<td class="title1">创建用户</td>
				<td class="title1">供应商</td>
				<td class="title1">附加费用</td>
				<td class="title1">采购单总价</td>
				<td class="title1">产品总价</td>
				<td class="title1">付款方式</td>
				<td class="title1">最低预付金额</td>
				<td class="title1">操作</td>
			</tr>
			<c:forEach items="${page1.pageyu }" var="pomain">
				<tr align="center">
					<td>${pomain.poid }</td>
					<td>${pomain.createtime }</td>
					<td>${pomain.account }</td>
					<td>${pomain.vendercode }</td>
					<td>${pomain.tipfee }</td>
					<td>${pomain.pototal }</td>
					<td>${pomain.producttotal }</td>
					<td>${pomain.paytype }</td>
					<td>${pomain.prepayfee }</td>
					<td><input type="button" value="删除" onclick="shanchu(this)"><input
						type="button" value="修改" onclick="xiugai(this)">
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td class="title2"></td>
			</tr>
		</table>
		<div>
			<center>
				<c:choose>
					<c:when test="${page1.nowpage==1&&page1.nowpage==page1.allpage }">
		    	当前第${page1.nowpage }页/共${page1.allpage }页
		    	共${i }条数据
    		</c:when>
					<c:when test="${page1.nowpage==1 }">
		    	当前第${page1.nowpage }页/共${page1.allpage }页
		    	共${i }条数据
		    	<a href="Ser?page1=${page1.nowpage+1 }">下一页</a>
						<a href="Ser?page1=${page1.allpage }">末页</a>
					</c:when>
					<c:when test="${page1.nowpage==page1.allpage }">
						<a href="Ser?page1=1">首页</a>
						<a href="Ser?page1=${page1.nowpage-1 }">上一页</a>
    			当前第${page1.nowpage }页/共${page1.allpage }页
    			共${i }条数据
    		</c:when>
					<c:otherwise>
						<a href="Ser?page1=1">首页</a>
						<a href="Ser?page1=${page1.nowpage-1 }">上一页</a>
    			当前第${page1.nowpage }页/共${page1.allpage }页
    			共${i }条数据
		    	<a href="Ser?page1=${page1.nowpage+1 }">下一页</a>
						<a href="Ser?page1=${page1.allpage }">末页</a>
					</c:otherwise>
				</c:choose>
			</center>
		</div>
	</div>
	
	<div id="div" style="display:none">
		<form action="/ERP/servlet/Adder" name="mainFrm">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="30px" nowrap class="toolbar">&nbsp;</td>
					<td width="70px" nowrap class="toolbar" onMouseOver="OMO(event)"
						onMouseOut="OMOU(event)" id="img1">
						<img src="../images/add.gif" id="img">增加明细
					</td>
					<td nowrap class="toolbar">&nbsp;</td>
				</tr>
			</table>
			
			<table id="headTable" width="100%" border="0" align="center" cellspacing="1" class="a1">
				<tr align="left">
					<td>采购单编号</td>
					<td><input type="text" size="15"readonly="readonly" id="cai" name="bianhao"/>
						<span class="requred_symbol">*</span>
					</td>
					<td>供应商</td>
					<td><select id="s" name="gongying" >
							<c:forEach items="${gonghui }" var="vender">
								<option value=${vender.name }>${vender.name }</option>
							</c:forEach>
					</select> <span class="requred_symbol">*</span></td>
					<td>创建用户</td>
					<td><input  type="text"  name="textfield" size="15" readonly="readonly" value="${user.account }" /> <span
						class="requred_symbol">*</span>
					</td>
					<td>付款类型</td>
					<td><select id="se" onclick="dian()" name="type">
							<option>货到付款</option>
							<option>款到发货</option>
							<option>预付款到发货</option>

					</select> <span class="requred_symbol">*</span></td>
				</tr>
				<tr align="left">
					<td>附加费用</td>
					<td><input type="text" size="15" id="fu" onchange="on(this)" value="0" name="fujia"/> <span
						class="requred_symbol">*</span>
					</td>
					<td>采购 产品总价</td>
					<td><input type="text" size="15" readonly="readonly" id="allprice" name="allprice"/> <span
						class="requred_symbol">*</span>
					</td>
					<td>采购单总价</td>
					<td><input type="text" size="15" readonly="readonly" name="all"  id="alle"/> <span class="requred_symbol">*</span>
					</td>
					<td>预付款</td>
					<td><input type="text" id="yu" readonly="readonly"  onchange="liu(this)" name="yufu" value="0">
					</td>
				</tr>
				<tr align="justify">
					<td>采购单状态</td>
					<td><input type="text" value="1" size="15"
						readonly="readonly" name="zhuangtai"> <span class="requred_symbol">*</span>
					</td>
				</tr>
			</table>
			
			<table width="100%" border="0" align="center" cellspacing="1" id="detailTable">
				<tr>
					<td class="toolbar">序号</td>
					<td class="toolbar">产品编码</td>
					<td class="toolbar">产品名称</td>
					<td class="toolbar">单位</td>
					<td class="toolbar">单价</td>
					<td class="toolbar">数量</td>
					<td class="toolbar">总价</td>
					<td class="toolbar">操作</td>
				</tr>
			</table>
			
			<table width="100%" border="0" align="center" cellspacing="1">
				<tr>
					<td class="title2"></td>
				</tr>
			</table>
			<br/>
			<div  align="center">
				<input type="submit" id="bc" value="保存" />
			</div>
		</form>
	</div>
	
	<div id="productDiv" class="product" style="display:none ">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="30px" nowrap="nowrap" class="toolbar">&nbsp;</td>
				<td width="40px" nowrap="nowrap" class="toolbar"
					onMouseOver="OMO(event)" onMouseOut="OMOU(event)"
					onClick="choiceAnonymous('productDiv')" id="que1"><img
					src="../images/confirm.gif" id="que">确定</td>
				<td width="20px" nowrap="nowrap" class="toolbar">|</td>
				<td width="40px" nowrap="nowrap" class="toolbar"
					onMouseOver="OMO(event)" onMouseOut="OMOU(event)"
				    onclick="res()"><img src="../images/cancel.gif">取消</td>
				<td align="center" valign="middle" nowrap="nowrap" class="toolbar">&nbsp;</td>
			</tr>
		</table>
		<table width="100%" border="0" align="center" cellspacing="1"
			class="a1" id="spxxTable">
			<tr>
				<td class="title1">选择</td>
				<td class="title1">商品编码</td>
				<td class="title1">类别</td>
				<td class="title1">商品名称</td>
				<td class="title1">商品单位</td>
				<td class="title1">商品单价</td>
				<td class="title1">添加时间</td>
				<td class="title1">操作</td>
			</tr>
			<c:forEach items="${al }" var="product">
				<tr align="center">
					<td align="center"><input type="radio" name="ra"></td>
					<td>${product.productcode }</td>
					<td>${product.categoryid }</td>
					<td>${product.name }</td>
					<td>${product.unitname }</td>
					<td>${product.price }</td>
					<td>${product.createdate }</td>
					<td><input type="button" value="删除" /><input type="button"
						value="修改" />
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td class="title2"></td>
			</tr>
		</table>
	</div>



	<iframe width=174 height=189 name="gToday:normal:agenda.js"
		id="gToday:normal:agenda.js" src="../common/calendar/ipopeng.htm"
		scrolling="no" frameborder="0"
		style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>

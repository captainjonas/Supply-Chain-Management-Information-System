<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>采购单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="../script/common.js" ></script>
<script type="text/javascript" src="../script/productDiv.js" ></script>
<script type="text/javascript" src="/ERP/purchase/jquery-1.8.1.min.js"></script>

<style type="text/css">
	div.product{
		position: absolute;
		top:2px;
		left: 2px;
		width:100%;
		height: 98%;
		background-color: #fffffe;
	}

</style>
<script language="javascript">
	function test(){
		document.getElementById("con").style.display="block";
		}
		function init(){
			var y=document.getElementById("se");
			y.value="${requestScope.pomain.paytype}";
			var s=document.getElementById("s");
			s.value="${requestScope.pomain.name}";
		}
		var y;
		var p=0;
		var t;
		var yuj=0;
		var yui=0;
		var m=0;
		var sun=0;
	$(function(){
		$("#se").click(function(){
			if($("#se").val()=="预付款到发货"){
			//alert("asd");
				$("#yu").removeAttr("readonly");
			}else{
				$("#yu").attr("readonly","readonly");
			}
		});
			if(${not empty requestScope.shibai}){
				alert("${requestScope.shibai}");
										}
		/* $("#yu").change(function(){
				var reg=/^\d{0,}\\.?$/;
		if(reg.test($("#yu").val())){	
		}else{
			alert("请输入数字");
			$("#yu").val(0);
		}
		}); */
		//$("#fujia").change(function(){
		$("#fujia").bind({'click':function(){
			y=$("#fujia").val();
					//alert(y);
			
		},'change':function(){
			var reg=/^[0-9]{1,}(?:.[0-9]{0,2})?$/;
			if(reg.test($("#fujia").val())){
				var u=$("#fujia").val();
					//alert(u);
					//$("#allprice").val($("#allprice").val()-(y-0)+(u-0));
					//alert($("#allprice").val()-y+(u-0))
					$("#alle").val($("#alle").val()-(y-0)+(u-0));
			}else{
				alert("请输入数字");
			$("#fujia").val(0);
			$("#alle").val($("#alle").val()-(y-0));
			}
		}});
		$("#yu").bind({'click':function(){
			p=$("#yu").val();
					//alert(p)
			
		},'change':function(){
			var reg=/^[0-9]{1,}(?:.[0-9]{0,2})?$/;
			//alert(reg.test($("#yu").val()));
			if(reg.test($("#yu").val())){
				var u=$("#yu").val();
					//alert(u);
					//$("#allprice").val($("#allprice").val()-(y-0)+(u-0));
					//alert($("#alle").val()-(p-0)+(u+0))
					$("#alle").val($("#alle").val()-(p-0)+(u-0));
			}else{
				alert("只能输入数字，小数点后2位的数");
			$("#yu").val(0);
		$("#alle").val($("#alle").val()-(p-0));
			}
		}});
		$("[name=number]").live({'click':function(){
						var td=this.parentNode;//被点击的列
						var tr=td.parentNode;//被点击的行
						t=tr.rowIndex;//点的是第几行
						
							p=t-1;
							//alert($("[name=number]:eq("+p+")").val());
							yui=$("[name=teval]:eq("+p+")").val();
							//alert(yui);
						},'change':function(){
							var reg=/^\+?(0|[1-9][0-9]*)$/;
							//alert($("[name=number]:eq("+p+")").val());
							//alert($("[name='number']:eq(1)").val());
							//alert(reg.test($("[name=number]:eq("+p+")").val()));
							if(reg.test($("[name=number]:eq("+p+")").val())){
							//alert($("[name='unitprice']:eq("+p+")").val()-0);
								yuj=$("[name='teval']:eq("+p+")").val(($("[name=number]:eq("+p+")").val()-0)*($("[name=unitprice]:eq("+p+")").val()-0));
								//alert(yuj.val())
								//alert(yuj.val());
								var table=$("#spxxTable");
								var y=$("#poli tr").length;
								//alert(sun+($("[name=teval]:eq("+0+")").val()-0));
									sun=0;
								for(var i=0;i<(y-1);i++){
									sun=(sun-0)+($("[name=teval]:eq("+i+")").val()-0);
									//alert(sun);
								}
								//alert(sun);
								$("#allprice").val(sun-0);
								$("#alle").val((sun-0)+($("#fujia").val()-0)+($("#yu").val()-0));
							}else{
								alert("请输入整数");
								$("[name='number']:eq("+p+")").val(0);
								$("#allprice").val($("#allprice").val()-yui);
								$("#alle").val($("#alle").val()-yui);
								$("[name=teval]:eq("+p+")").val(0);
							}
						}
		});
		$("[name=unitprice]").live({'click':function(){
						var td=this.parentNode;//被点击的列
						var tr=td.parentNode;//被点击的行
						t=tr.rowIndex;//点的是第几行
						
							p=t-1;
							//alert($("[name=number]:eq("+p+")").val());
							yui=$("[name=teval]:eq("+p+")").val();
							//alert(yui);
						},'change':function(){
							var reg=/^[0-9]{1,}(?:.[0-9]{0,2})?$/;
							//alert($("[name=number]:eq("+p+")").val());
							//alert($("[name='number']:eq(1)").val());
							//alert(reg.test($("[name=number]:eq("+p+")").val()));
							if(reg.test($("[name=unitprice]:eq("+p+")").val())){
							//alert($("[name='unitprice']:eq("+p+")").val()-0);
								yuj=$("[name='teval']:eq("+p+")").val(($("[name=number]:eq("+p+")").val()-0)*($("[name=unitprice]:eq("+p+")").val()-0));
								//alert(yuj.val())
								//alert(yuj.val());
								var table=$("#spxxTable");
								var y=$("#poli tr").length;
								//alert(sun+($("[name=teval]:eq("+0+")").val()-0));
									sun=0;
								for(var i=0;i<(y-1);i++){
									sun=(sun-0)+($("[name=teval]:eq("+i+")").val()-0);
									//alert(sun);
								}
								//alert(sun);
								$("#allprice").val(sun-0);
								$("#alle").val((sun-0)+($("#fujia").val()-0)+($("#yu").val()-0));
							}else{
								alert("请输入2位小数");
								$("[name='number']:eq("+p+")").val(0);
								$("#allprice").val($("#allprice").val()-yui);
								$("#alle").val($("#alle").val()-yui);
								$("[name=teval]:eq("+p+")").val(0);
							};
						}
		});
		$("#imgs").click(function(){
	 	var $tr=$("#poli tr:last");
    	 if($tr.size()==0){
      	  alert("指定的table id或行数不存在！");
       	 return;
     }
     	//var y=
     	var tf=true;
     	var index=$("#spxxTable").find("tr").length;
    	for(var i=0;i<index;i++){
    		if($("[name=teval]:eq("+i+")").val()==0){
    			tf=false;
    		}
    	}
    	//alert(t)
    	if(tf){
    	var t=$("[name=loi]:last").val();
     $("#poli").append("<tr><td><input type='text' readonly='readonly' name='loi' size='15' value="+((t-0)+1)+"><img src='../images/selectDate.gif' name='dian'></td><td><input type='text' readonly='readonly'name='productcode' size='15'/></td><td><input type='text' name='namepl' readonly='readonly' size='15'/></td><td><input type='text' name='unitname' readonly='readonly' size='15'/></td><td><input type='text'name='unitprice' size='15'/></td><td><input type='text' name='number'/></td><td><input type='text' size='15' value='0' name='teval'/></td><td align='center'><img src='../images/delete.gif' onclick='ji(this)' id='idp'/></td></tr>");
    }
		});
		$("[name=dian]").live('click',function(){
						var td=this.parentNode;
						var tr=td.parentNode;
  							//alert('点击了第'+(tr.rowIndex+1)+'行，第'+(td.cellIndex+1)+'列');
  							m=tr.rowIndex;
							$("#formDiv").css('display','none');
							$("#productDiv").css('display','block');
						});
		$("#yes").click(function(){
				var  flag=true;
				var table=$("#spxxTable");
				var y=$("#poli tr").length;
				//alert(y)
				var tr=table.find("tr").eq(m);
				for(var j=0;j<y;j++){
							if($("[name=productcode]:eq("+(j-0)+")").val()==($(":radio:checked").parent().parent().find("td:eq(1)").text())){
								flag=false;
								//alert($("[name=productcode]:eq("+(j-0)+")").val());
							}
						}
						if(!flag){
							alert("该商品已经存在，不能重复选择");
						}
						else{
						//alert(m)
							$("#formDiv").css('display','block');
							$("#productDiv").css('display','none');
							//alert($(":radio:checked").parent().parent().find("td:eq(1)").text())
							$("[name=productcode]:eq("+(m-1)+")").val($(":radio:checked").parent().parent().find("td:eq(1)").text());
							$("[name=namepl]:eq("+(m-1)+")").val($(":radio:checked").parent().parent().find("td:eq(3)").text());
							$("[name=unitname]:eq("+(m-1)+")").val($(":radio:checked").parent().parent().find("td:eq(4)").text());
							$("[name=unitprice]:eq("+(m-1)+")").val($(":radio:checked").parent().parent().find("td:eq(5)").text());
							$("[name=number]:eq("+(m-1)+")").val("");
							
							var t1=$("[name=teval]:eq("+(m-1)+")").val();
							//alert(t1)
							$("#allprice").val(($("#allprice").val()-0)-(t1-0));
							$("#alle").val(($("#alle").val()-0)-(t1-0));
							$("[name=teval]:eq("+(m-1)+")").val(0);
						}
						//alert($("[name=productcode]:eq("+(m-1)+")").val());
						//alert(m)
		});
	});
	function ji(obj) {
		var row = obj.parentNode.parentNode;
		var index = row.rowIndex;
		var table = document.getElementById("poli");
		$("#allprice").val($("#allprice").val()-($("#poli").find("tr").eq(index).find("td").eq(6).find("input:text").val()));
		$("#alle").val($("#alle").val()-($("#poli").find("tr").eq(index).find("td").eq(6).find("input:text").val()));
		table.deleteRow(index);
	}
</script>
</head>
<body onLoad="init()">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面——修改采购单</td>
  </tr>
</table>
<div class="formVisiblitly" id="formDiv">
<form action="Change">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
    <td width="70px" nowrap class="toolbar" ><img src="../images/add.gif" id="imgs">增加明细</td>
	<td nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>
<table id="detailTable" width="100%"  border="0" align="center" class="a1">
  <tr align="justify">
    <td>采购单编号</td>
    <td><input type="text" name="code" value="${requestScope.pomain.poid }" readonly="readonly" size="15"/>
      <span class="requred_symbol">*</span></td>
    <td>供应商</td>
    		<td><select id="s" name="gongying" >
							<c:forEach items="${gonghui }" var="vender">
								<option value=${vender.name }>${vender.name }</option>
							</c:forEach>
					</select> <span class="requred_symbol">*</span></td>
    <td>创建用户</td>
    <td><input type="text" size="15" onBlur="test()" readonly="readonly"  name="account" value=${requestScope.pomain.account }>
      <span class="requred_symbol">*</span>
      	<div style="border:#3FF 1px solid; height:50px; display:none; position:absolute;  width:120px; background-color:#090;" id="con">
        </div>
      </td>
    <td>付款类型</td>
    <td>
    	<select id="se"  name="paytype">
        	<option value="货到付款">货到付款</option>
            <option value="预付款到发货">预付款到发货</option>
            <option value="款到发货">款到发货</option>
        </select></td>
  </tr>
  <tr align="justify">
    <td>附加费用</td>
    <td><input type="text" size="15" name="fujia" id="fujia" value="${requestScope.pomain.tipfee }"/>
        <span class="requred_symbol">*</span></td>
    <td>采购产品总价</td>
    <td><input type="text" name="allprice" id="allprice" readonly="readonly" size="15" value="${requestScope.pomain.producttotal}"/></td>
    <td>采购单总价</td>
     <td><input type="text" name="alle" id="alle" readonly="readonly" size="15" value="${requestScope.pomain.pototal }"/></td>
    <td>预付款</td>
    <td><input type="text" name="yufu" type="text" size="15" readonly="readonly" id="yu" value="${requestScope.pomain.prepayfee }"/></td>
   </tr>
   <tr><td>采购单状态</td>
    <td><input type="text" name="status" size="15" value="${requestScope.pomain.status }"/></td>
   </tr>
  <tr>
    <td class="title2"></td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1" id="poli">
  <tr>
    <td class="toolbar">序号</td>
    <td class="toolbar"> 产品编号 </td>
    <td class="toolbar"> 产品名称 </td>
    <td class="toolbar"> 单位 </td>
    <td class="toolbar">单价</td>
    <td class="toolbar">数量</td>
    <td class="toolbar">总价</td>
    <td class="toolbar">操作</td>
  </tr>
  <c:forEach items="${ae }" var="poitem" varStatus="i">
  	<tr>
  		<td><input type="text" name="loi" readonly="readonly" size="15" value="${i.index+1}"/><img src='../images/selectDate.gif' name='dian'></td>
  		<td><input type="text" name="productcode" readonly="readonly" size="15" value="${poitem.productcode }"/></td>
  		<td><input type="text" name="namepl" readonly="readonly" size="15" value="${poitem.name }"/></td>
  		<td><input type="text" name="unitname" readonly="readonly" size="15" value="${poitem.unitname }"/></td>
  		<td><input type="text" name="unitprice" name="unitprice" size="15" value="${poitem.unitprice }"/></td>
  		<td><input type="text" name="number" value="${poitem.num }"/></td>
  		<td><input type="text" size="15" name="teval" readonly="readonly" value="${poitem.itemprice }"/></td>
  		<td align='center'><img src='../images/delete.gif' onclick='ji(this)' id='idp'/></td>
  	</tr>
  </c:forEach>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title2"></td>
  </tr>
</table>
<br>
	<center>
    <input type="submit" id="bc" value="保存"/>
    </center>
    </form>
</div>

<!-- div -->
 
<div id="productDiv" style="display:none" class="product">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="30px" nowrap="nowrap" class="toolbar">&nbsp;</td>
	    <td width="40px" nowrap="nowrap" class="toolbar" ><img src="../images/confirm.gif" id="yes">确定</td>
	    <td width="20px" nowrap="nowrap" class="toolbar">|</td>
	    <td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="hiddenDiv()"><img src="../images/cancel.gif">取消</td>
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
				<tr>
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
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="../common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>

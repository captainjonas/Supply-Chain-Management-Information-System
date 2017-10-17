<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/common.js" type="text/javascript"></script>
<script type="text/javascript" src="script/productDiv.js" ></script>
<script type="text/javascript" src="script/sale.js" ></script>
<script type="text/javascript" src="script/jquery-1.8.1.min.js"></script>
<style type="text/css">
	.product{
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
	function init2(){
			var date=new Date();		
			var createDate = date.getFullYear()+"-"+(date.getMonth()+1<10?'0'+(date.getMonth()+1):date.getMonth())+"-"+(date.getDate()<10?'0'+date.getDate():date.getDate());
			var soId=date.getFullYear().toString()+(date.getMonth()+1<10?'0'+(date.getMonth()+1):date.getMonth()).toString()+(date.getDate()<10?'0'+date.getDate():date.getDate()).toString()+(date.getHours()<10?'0'+date.getHours():date.getHours()).toString()+(date.getMinutes()<10?'0'+date.getMinutes():date.getMinutes()).toString()+(date.getSeconds()<10?'0'+date.getSeconds():date.getSeconds()).toString();
			document.getElementById("saleCreateTime").value=createDate;
			document.getElementById("saleSOID").value=soId;
			document.getElementById("saleAccount").value="T000400";
			document.getElementById("salePayType").value="货到付款";
		};
</script>
</head>
<div >
</div>
<body onLoad="init2()">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面－－销售管理－－新添销售单－－新增</td>
  </tr>
</table>
<div class="formVisiblitly" id="formDiv"></div>
<form action="" name="mainFrm">
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
    <td width="70px" nowrap class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="document.mainFrm.mx.click()"><img src="images/add.gif">增加明细</td>
	<td nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>

<table id="headTable" width="100%"  border="0" align="center" class="a1">
  <tr align="justify">
    <td>销售单编号</td>
    <td><input type="text"  size="15" id="saleSOID" readonly="readonly"/>
      <span class="requred_symbol">*</span></td>
    <td>创建时间</td>
    <td><input type="text" size="15" id="saleCreateTime" name="sj" readonly="readonly"/>
    <td>客户名称</td>
    <td><input type="text" size="15"  id="saleCustomerName"/>
      <span class="LL">
    <img  src="images/selectDate.gif" onClick="choiceCustomer()"></span>
      	
      </td>
      <td>客户编号</td>
    <td><input type="text" size="15" id="saleCustomerCode"/><span class="LL">
    <img  src="images/selectDate.gif" onClick="choiceCustomer()"></span>
      	
      </td>
    <td>创建用户</td>
    <td><input name="textfield" type="text" size="15" id="saleAccount"  value="T000400" readonly="readonly"></td>
  </tr>
  <tr align="justify">
    <td>附加费用</td>
    <td><input type="text" size="15" id="saleTipFee" value="0"/>
        <span class="requred_symbol">*</span></td>
    <td>产品总价</td>
    <td><input type="text" size="15" id="saleProductTotal" readonly="readonly" /></td>
    <td>付款方式</td>
    <td >
    	<select id="salePayType" onchange="selectONchange()">
        	<option>货到付款</option>
            <option>款到发货</option>
            <option>预付款到发货</option>
        </select>
    </td>
    <td>最低预付金额</td>
    <td><input name="text" type="text" size="15" id="salePrePayFee" value="0"  readonly="readonly"/><span class="requred_symbol">*</span></td>
    <td>备注：</td>
    <td><input name="text" type="text" size="15" id="saleRemark"/></td>
   </tr>
  <tr>
    <td class="title2"></td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1" id="detailTable">
  <tr>
    <td class="toolbar">&nbsp;</td>
    <td class="toolbar">商品编码</td>
    <td class="toolbar">商品名称</td>
    <td class="toolbar">产品数量</td>
    <td class="toolbar">数量单位</td>
    <td class="toolbar">销售单价</td>
    <td class="toolbar">销售明细总价</td>
    <td class="toolbar">&nbsp;</td>
  </tr>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title2"></td>
  </tr>
</table>
<br>
<div align="center">
    <input type="button" id="mx" value="增加明细" onClick="addItem()"/>
    <input type="button" id="bc" value="保存"   onClick="saveSomainSoitem()"/>
    <input type="button" id="dy" value="打印" onClick="window.print()"/>
    <input name="reset"  id="cz" value="重置" type="reset"/>
    <input type="button" id="gb" value="关闭" onClick="window.location='somainGet'"/>
</div>

<div id="customerDiv" style="visibility: hidden;" class="product">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="30px" nowrap="nowrap" class="toolbar">&nbsp;</td>
	    <td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="choiceAnonymous2('customerDiv')"><img src="images/confirm.gif">确定</td>
	    <td width="20px" nowrap="nowrap" class="toolbar">|</td>
	    <td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="hiddenCustomerDiv()"><img src="images/cancel.gif">取消</td>
		<td align="center" valign="middle" nowrap="nowrap" class="toolbar">&nbsp;</td>
	  </tr>
	</table>
	<table width="100%"  border="0" align="center" cellspacing="1" class="a1" id="customerspxxTable">
	  <tr>
	    <td class="title1">选择</td>
	    <td class="title1">客户编码</td>
	    <td class="title1">客户名称</td>
	  </tr>
	  
	  <c:forEach items="${cl }" var="customer">
			<tr align="center" onClick="selectItem2(this)" onMouseOver="OMO1(event)" onClick="choice2(this)">
				<td>&nbsp;</td>
				<td>${customer.customerCode }</td>
				<td>${customer.name }</td>
			</tr>
		</c:forEach>
	   <tr>
	    <td class="title2"></td>
	  </tr>
	</table>
</div>

 
<div id="productDiv" style="visibility: hidden;" class="product">
	<table width="100%"  border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td width="30px" nowrap="nowrap" class="toolbar">&nbsp;</td>
	    <td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="choiceAnonymous('productDiv')"><img src="images/confirm.gif">确定</td>
	    <td width="20px" nowrap="nowrap" class="toolbar">|</td>
	    <td width="40px" nowrap="nowrap" class="toolbar" onMouseOver="OMO(event)" onMouseOut="OMOU(event)" onClick="hiddenDiv()"><img src="images/cancel.gif">取消</td>
		<td align="center" valign="middle" nowrap="nowrap" class="toolbar">&nbsp;</td>
	  </tr>
	</table>
	<table width="100%"  border="0" align="center" cellspacing="1" class="a1" id="spxxTable">
	  <tr>
	    <td class="title1">选择</td>
	    <td class="title1">商品编码</td>
	    <td class="title1">商品名称</td>
	    <td class="title1">数量单位</td>
	    <td class="title1">销售单价</td>
	  </tr> 
	  <c:forEach items="${cll }" var="product">
			<tr align="center" onClick="selectItem(this)" onMouseOver="OMO1(event)" onDblClick="choice(this)">
				<td>&nbsp;</td>
				<td>${product.productCode }</td>
				<td>${product.productName }</td>
				<td>${product.unitName}</td>
				<td>${product.unitPrice}</td>
			</tr>
		</c:forEach>
	   <tr>
	    <td class="title2"></td>
	  </tr>
	</table>
</div>


</form>
 
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>
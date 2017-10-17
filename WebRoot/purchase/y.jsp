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
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="<%=path %>/script/common.js" ></script>
<script type="text/javascript" src="/ERP/purchase/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/script/productDiv.js" ></script>

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
		$(function(){
			if(${not empty requestScope.quxiao}){
				alert("${requestScope.quxiao}");
				}
				if(${not empty requestScope.qp}){
				alert("${requestScope.qp}");
				}
				$("[name=aa]").click(function(){
					//$("#div").css('display','block');
					var td=this.parentNode;//被点击的列
						var tr=td.parentNode;//被点击的行
						t=tr.rowIndex;//点的是第几行
						//alert(this.innerHTML)
						location="../servlet/Allmo?poid="+tr.cells[0].childNodes[0].innerHTML+"&createtime="+tr.cells[1].innerHTML+"$account="+tr.cells[2].innerHTML+"&name="+tr.cells[3].innerHTML;
				});
				if(${not empty requestScope.po}){
					$("#div").css("display","block");
				}
				
		});
</script>
<script type="text/javascript" src="<%=path %>/purchase/My97DatePicker/WdatePicker.js"></script>
</head>
<div >
</div>
<body>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td nowrap class="title1">您的位置：工作台面——采购单查询</td>
  </tr>
</table>
<div class="formVisiblitly" id="formDiv"></div>
<table width="100%"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="30px" nowrap class="toolbar">&nbsp;</td>
	<td nowrap class="toolbar">&nbsp;</td>
  </tr>
</table>
<form action="/ERP/servlet/Find" >
<table id="headTable" width="100%"  border="0" align="center" class="a1">
  <tr align="justify">
    <td>采购单编号</td>
    <td><input type="text"  name="poid">
      <span class="requred_symbol">*</span></td>
    <td>开始日期</td>
    <td><input type="text" class="Wdate" id="startime" name="startime" onclick="WdatePicker({isShowClear:true})"/>
    </td>
    <td>截止日期</td>
    <td><input type="text" id="endtime" class="Wdate" name="endtime" onclick="WdatePicker({isShowClear:true})"/>
      </td>
  </tr>
  <tr align="justify">
    <td>供应商</td>
    <td><select id="s" name="gongying" >
    						<option selected="selected">请选择供应商</option>
							<c:forEach items="${gonghui }" var="vender">
								<option value=${vender.name }>${vender.name }</option>
							</c:forEach>
					</select> <span class="requred_symbol">*</span></td>
    <td>付款方式</td>
    <td colspan="4">
    	<select name="paytype" >
    		<option value="请选择付款方式" selected="selected">请选择付款方式</option>
        	<option value="货到付款">货到付款</option>
            <option value="预付款到发货">预付款到发货</option>
            <option value="款到发货">款到发货</option>
        </select>
    </td>
   </tr>
   <tr align="center">
   		<td colspan="8"><input type="submit" value=查询 /><input type="reset" value="重置" /></td>
   </tr>
  <tr>
    <td class="title2"></td>
  </tr>
</table>
</form>
<table width="100%"  border="0" align="center" cellspacing="1" id="detailTable">
  <tr>
    <td class="toolbar">采购单编号</td>
    <td class="toolbar">创建时间 </td>
    <td class="toolbar">创建用户 </td>
    <td class="toolbar">供应商</td>
    <td class="toolbar">附加费用</td>
    <td class="toolbar">采购单总价</td>
    <td class="toolbar">产品总价</td>
    <td class="toolbar">付款方式</td>
    <td class="toolbar">最低预付款金额</td>
    <td class="toolbar">操作</td>
  </tr>
  <c:forEach items="${jihe }" var="pomain">
  		<tr align="center">
  			<td><a name="aa">${pomain.poid }</a></td>
  			<td>${pomain.createtime }</td>
  			<td>${pomain.account }</td>
  			<td>${pomain.name }</td>
  			<td>${pomain.tipfee }</td>
  			<td>${pomain.pototal }</td>
  			<td>${pomain.producttotal }</td>
  			<td>${pomain.paytype }</td>
  			<td>${pomain.prepayfee }</td>
  			<td><input type="button" value="观看" name="aa"/></td>
  		</tr>
  </c:forEach>
</table>
<table width="100%"  border="0" align="center" cellspacing="1">
  <tr>
    <td class="title2"></td>
  </tr>
</table>
<br>

<!-- div -->
 <div id="div" style="display:none">
 	<table id="noone" width="100%"  border="0" align="center" class="a1">
  <tr align="justify">
    <td>采购单编号</td>
    <td><input type="text" size=15 name="poid" readonly="readonly" value="${ploi.poid}">
      <span class="requred_symbol">*</span></td>
    <td>创建时间</td>
    <td><input type="text" size="15" readonly="readonly" value="${ploi.createtime}"/>
    </td>
    <td>供应商名称</td>
    <td><input type="text" size="15" readonly="readonly" value="${ploi.name }"/>
      </td>
       <td>附加费用</td>
    <td><input type="text" size="15" readonly="readonly" value="${ploi.tipfee }"/>
      </td>
  </tr>
  <tr align="justify">
    <td>采购产品总价</td>
    <td><input type="text" size="15" readonly="readonly" value="${ploi.producttotal }"/> <span class="requred_symbol">*</span></td>
    <td>采购单总价</td>
    <td>
    	<input type="text" size="15" readonly="readonly" value="${ploi.pototal }"/>
    </td>
 <td>付款方式</td>
    <td>
    	<input type="text" size="15" readonly="readonly" value="${ploi.paytype }"/>
    </td>
     <td>最低预付款金额</td>
    <td>
    	<input type="text" size="15" readonly="readonly" value="${ploi.prepayfee }"/>
    </td>
   </tr>
    <tr align="justify">
    <td>处理状态</td>
    <td><input type="text" size="15" value="${ploi.status }"/> <span class="requred_symbol">*</span></td>
    <td>备注</td>
    <td>
    	<input type="text" size="15" readonly="readonly" value="${ploi.remark }"/>
    </td>
 <td>入库时间</td>
    <td>
    	<input type="text" size="15" readonly="readonly" value="${ploi.stocktime }"/>
    </td>
     <td>入库操作用户</td>
    <td>
    	<input type="text" size="15" readonly="readonly" value="${ploi.stockuser }"/>
    </td>
   </tr>
    <tr align="justify">
    <td>预付时间</td>
    <td><input type="text" size="15" readonly="readonly" value="${ploi.prepaytime }"/> <span class="requred_symbol">*</span></td>
    <td>预付操作用户</td>
    <td colspan="10">
    	<input type="text" size="15" readonly="readonly" value="${ploi.prepayuser }"/>
    </td>
   </tr>
  <tr>
    <td class="title2"></td>
  </tr>
  </table>
<table id="noo" width="100%"  border="0" align="center" class="a1">
	<tr>
		<th>产品编号</th>
		<th>产品名称</th>
		<th>数量单位</th>
		<th>数量</th>
		<th>单价</th>
		<th>明细总价</th>
	</tr>
	<c:forEach items="${po}" var="poiem">
		<tr align="center">
			<td>${poiem.productcode }</td>
			<td>${poiem.name }</td>
			<td>${poiem.unitname }</td>
			<td>${poiem.num }</td>
			<td>${poiem.unitprice }</td>
			<td>${poiem.itemprice }</td>
		</tr>
	</c:forEach>
	
</table>
 </div>
<iframe width=174 height=189 name="gToday:normal:agenda.js" id="gToday:normal:agenda.js" src="../common/calendar/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"></iframe>
</body>
</html>


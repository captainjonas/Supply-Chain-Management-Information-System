
var rowlength; //每行多少个单元
var spxxTable;
var rowIndex;


//逻辑控制

function choiceAnonymous2() {
	var len = document.getElementById("customerspxxTable").rows.length;
	var returnValue2;
	var i;
	for (i = 1; i < len - 1; i++) {
		if (document.getElementById("customerspxxTable").rows[i].cells[0].innerHTML == "\u221a") {
			returnValue2 = choice2(i);
			setValue2();
			hiddenCustomerDiv();
			return;
		}
	}
	alert("请先选中客户");
	function setValue2() {
		var detailTable = document.getElementById("detailTable");
		var length = detailTable.rows.length;
		var scc = document.getElementById("saleCustomerCode");
		var scn = document.getElementById("saleCustomerName");
		scc.value = returnValue2[0];
		scn.value = returnValue2[1];
	}
}

function choiceAnonymous() {
	var len =document.getElementById("spxxTable").rows.length;
	var returnValue;
	var i;
	var length=document.getElementById("detailTable").rows.length;
	var flag=false;
	var flag2=false;
	for (i = 1; i < len - 1; i++) {
		if (document.getElementById("spxxTable").rows[i].cells[0].innerHTML == "\u221a") {
			returnValue = choice(i);
			flag2=true;
		}
	};
	if(!flag2){
		alert("请先选中商品！");
	};
	for(k=0;k<length-1; k++){
		
		var length=document.getElementById("detailTable").rows.length;
		var spbm = document.getElementsByName("spbm");
		if (returnValue[0]==spbm[k].value) {
			alert("不可重复添加同一商品！");
			hiddenDiv();
			flag=true;
			return;
		}
	};
	if(!flag){  
		setValue();
		hiddenDiv();
		return;
	};	
	function setValue() {
		var detailTable = document.getElementById("detailTable");
		var length = detailTable.rows.length;
		var spbm = document.getElementsByName("spbm");
		var spmc = document.getElementsByName("spmc");
		var sptj = document.getElementsByName("sptj");
		var spzl = document.getElementsByName("spzl");
		var ytsl = document.getElementsByName("ytsl");
		var stsl = document.getElementsByName("stsl");
		spbm[rowIndex].value = returnValue[0];
		spmc[rowIndex].value = returnValue[1];
		sptj[rowIndex].value = returnValue[2];
		spzl[rowIndex].value = returnValue[3];
		ytsl[rowIndex].value = 0.0;
		stsl[rowIndex].value = 0.0;
		
		var length=document.getElementById("detailTable").rows.length;
		
		var count=0;
		var stsl=document.getElementsByName("stsl");
		for (var i= 0; i < stsl.length; i++) {
			count=count+parseFloat(stsl[i].value);	
		}
		
		document.getElementById("saleProductTotal").value=parseFloat(count);

	}
}
function selectItem2(tr) {
	clearTable2();
	tr.cells[0].innerHTML = "\u221a";
	var tds = tr.cells;
	for (var j = 0; j < tds.length; j += 1) {
		tds[j].style.backgroundColor = "#C1CDD8";
	}
	
}

function selectItem(tr) {
	clearTable();
	tr.cells[0].innerHTML = "\u221a";
	var tds = tr.cells;
	for (var j = 0; j < tds.length; j += 1) {
		tds[j].style.backgroundColor = "#C1CDD8";
	}
	
}

function choice2(k) {
	var row = document.getElementById("customerspxxTable").rows[k];
	var result = new Array(document.getElementById("customerspxxTable").rows[0].cells.length);
	var i;
	for (i = 1; i < 3; i++) {
		result[i - 1] = row.cells[i].innerHTML;
	}
	return result;
}


function choice(index) {
	var row = document.getElementById("spxxTable").rows[index];
	var result = new Array(document.getElementById("spxxTable").rows[0].cells.length);
	var i;
	for (i = 1; i < document.getElementById("spxxTable").rows[0].cells.length; i++) {
		result[i - 1] = row.cells[i].innerHTML;
	}
	return result;
}

function choiceCustomer(){
	document.getElementById("customerDiv").style.visibility = "visible";
}
function choiceSpxx(rowIndex_) {
	showDiv();
	rowIndex = rowIndex_;
}
  //添加一行
function addItem() {
	var detailTable = document.getElementById("detailTable");
	var oRow = detailTable.insertRow(-1);//在表格最后添加一行
	oRow.align = "center";
	oRow.className = "toolbar";
	oCell = oRow.insertCell(0);//添加单元格
	oCell.innerHTML = oRow.rowIndex;
	oCell = oRow.insertCell(1);
	oCell.innerHTML = "<input type='text'  name='spbm' size='10' readonly='readonly'> <span class='LL'><image src='images/selectDate.gif' onClick='choiceSpxx(\"" + (oRow.rowIndex - 1) + "\")'></span>";
    
    // oCell.class= ;
	oCell = oRow.insertCell(2);
	oCell.innerHTML = "<input type='text' name='spmc' size='15' readonly='readonly'>";
	oCell = oRow.insertCell(3);
	oCell.innerHTML = "<input type='text' name='ytsl' size='10' value='0'>";
	oCell = oRow.insertCell(4);
	oCell.innerHTML = "<input type='text' name='sptj' size='10' value='0' readonly='readonly' >";
	oCell = oRow.insertCell(5);
	oCell.innerHTML = "<input type='text' name='spzl' size='10' value='0' >";
	oCell = oRow.insertCell(6);
	oCell.innerHTML = "<input type='text' name='stsl' size='10' value='0' readonly='readonly'>";

	oCell = oRow.insertCell(7);
	oCell.innerHTML = "<image src=\"images/delete.gif\" class=\"LL\" onclick=\"delItem(" + oRow.rowIndex + ")\"/>";
}


function textChangeNum(obj){
	var num=parseFloat(obj.value);
	var tr=obj.parentNode.parentNode;
	var nowRowIndex=tr.rowIndex;
	var unitPrice=parseFloat(document.getElementsByName("spzl")[nowRowIndex-1].value);

	document.getElementsByName("stsl")[nowRowIndex-1].value=unitPrice*num;
	
	var length=document.getElementById("detailTable").rows.length;
	
	var count=0;
	var stsl=document.getElementsByName("stsl");
	for (var i= 0; i < stsl.length; i++) {
		count=count+parseFloat(stsl[i].value);	
	}
	
	document.getElementById("saleProductTotal").value=parseFloat(count);
}



	//删除行,注意这里的行号全部要重新计算 刷新的
function delItem(index) {
	var detailTable = document.getElementById("detailTable");
	detailTable.deleteRow(index);
	var rowNum = detailTable.rows.length;
	var rowlength = detailTable.rows[0].cells.length;
	for (i = index; i < rowNum; i++) {
		detailTable.rows[i].cells[0].innerHTML = i;
		detailTable.rows[i].cells[rowlength - 1].innerHTML = "<image src=\"../images/delete.gif\" class=\"LL\" onclick=\"delItem(" + i + ")\"/>";
	}
}
function hiddenDiv() {
	document.getElementById("productDiv").style.visibility = "hidden";
	clearTable();
}

function hiddenCustomerDiv(){
	document.getElementById("customerDiv").style.visibility = "hidden";
	clearTable2();
}
function showDiv(){
	document.getElementById("productDiv").style.visibility = "visible";
	
}
 

function clearTable() {
	var trs =document.getElementById("spxxTable").rows;
	for (var i = 1; i < trs.length - 1; i += 1) {
		trs[i].cells[0].innerHTML = "";
		var tds = trs[i].cells;
		for (var j = 0; j < tds.length; j += 1) {
			tds[j].style.backgroundColor = "#fff7e5";
		}
	}
	
}
function clearTable2() {
	var trs = document.getElementById("customerspxxTable").rows;
	for (var i = 1; i < trs.length - 1; i += 1) {
		trs[i].cells[0].innerHTML = "";
		var tds = trs[i].cells;
		for (var j = 0; j < tds.length; j += 1) {
			tds[j].style.backgroundColor = "#fff7e5";
		}
	}
	
}



var arr=new Array();

function saveSomainSoitem(){
	var soId=document.getElementById("saleSOID").value;
	var createTime=document.getElementById("saleCreateTime").value;
	var customerCode=document.getElementById("saleCustomerCode").value;
	var name=document.getElementById("saleCustomerName").value;
	var account=document.getElementById("saleAccount").value;
	var tipFee=document.getElementById("saleTipFee").value;
	var productTotal=document.getElementById("saleProductTotal").value;
	var payType=document.getElementById("salePayType").value;
	var prePayFee=document.getElementById("salePrePayFee").value;
	var remark=document.getElementById("saleRemark").value;
	
	var soTotal=parseFloat(tipFee)+parseFloat(productTotal);
	
	var kytsl = document.getElementsByName("ytsl");
	var kspbm = document.getElementsByName("spbm");
	var flag=false;
	var flag2=false;
	var flag3=false;
	if(parseFloat(productTotal)<parseFloat(prePayFee)){
		flag2=true;
	}
	if(parseFloat(prePayFee)<=0&&(document.getElementById("salePayType").value=="预付款到发货")){
		flag3=true;
	};
	
	for (var i = 0; i < kytsl.length; i++) {		
		if(kytsl[i].value=="0"||kspbm[i].value==""){
			flag=true;
		}
		
	};
	setValue();
	if(customerCode!=""&&name!=""&&!flag&&!flag2&&!flag3){
	location="somainSoitemSave?soId="+soId+"&createTime="+createTime+"&customerCode="+customerCode+"&name="+name+"&account="+account+"&tipFee="+tipFee+"&productTotal="+productTotal+"&payType="+payType+"&prePayFee="+prePayFee+"&remark="+remark+"&soTotal="+soTotal+"&k="+arr;
	}else{
	alert("输入有误，请重新输入！");
	}
	
}

function saveSomainSoitemAfterUpdate(){
	var soId=document.getElementById("saleSOID").value;
	var createTime=document.getElementById("saleCreateTime").value;
	var customerCode=document.getElementById("saleCustomerCode").value;
	var name=document.getElementById("saleCustomerName").value;
	var account=document.getElementById("saleAccount").value;
	var tipFee=document.getElementById("saleTipFee").value;
	var productTotal=document.getElementById("saleProductTotal").value;
	var payType=document.getElementById("salePayType").value;
	var prePayFee=document.getElementById("salePrePayFee").value;
	var remark=document.getElementById("saleRemark").value;
	
	var soTotal=parseFloat(tipFee)+parseFloat(productTotal);	
	
	var kytsl = document.getElementsByName("ytsl");
	var kspbm = document.getElementsByName("spbm");
	var flag=false;
	var flag2=false;
	var flag3=false;
	if(parseFloat(productTotal)<parseFloat(prePayFee)){
		flag2=true;
	}
	if(parseFloat(prePayFee)<=0&&(document.getElementById("salePayType").value=="预付款到发货")){
		flag3=true;
	};
	for (var i = 0; i < kytsl.length; i++) {		
		if(kytsl[i].value=="0"||kspbm[i].value==""){
			flag=true;
		}		
	};
	setValue();	
	if(customerCode!=""&&name!=""&&!flag&&!flag2&&!flag3){
		location="somainSoitemSaveAfterUpdate?soId="+soId+"&createTime="+createTime+"&customerCode="+customerCode+"&name="+name+"&account="+account+"&tipFee="+tipFee+"&productTotal="+productTotal+"&payType="+payType+"&prePayFee="+prePayFee+"&remark="+remark+"&soTotal="+soTotal+"&k="+arr;
	}else{
		alert("输入有误，请重新输入！");
	}
			
}
	



function updateSomainSoitem(obj){
	var tr=obj.parentNode.parentNode;
	var soId=tr.cells[0].childNodes[0].innerHTML;
	location="somainSoitemUpdate?soId="+soId;
}


function setValue() {
	
	var detailTable = document.getElementById("detailTable");
	var length = detailTable.rows.length;
	var spbm = document.getElementsByName("spbm");
	var spmc = document.getElementsByName("spmc");
	var ytsl = document.getElementsByName("ytsl");	
	var sptj = document.getElementsByName("sptj");
	var spzl = document.getElementsByName("spzl");
	var stsl = document.getElementsByName("stsl");	
	var j=0;
	for (var m = 0; m < spbm.length; m++) {			
		arr[j]=spbm[m].value;
		arr[j+1]= spmc[m].value;
		arr[j+2]= ytsl[m].value;		
		arr[j+3]= sptj[m].value;
		arr[j+4]= spzl[m].value;
		arr[j+5]= stsl[m].value;	
		j+=6;	
	}
}

function deleteSomainSoitem(obj){
	var tr=obj.parentNode.parentNode;
	var soId=tr.cells[0].childNodes[0].innerHTML;
	var reg=confirm("确定要删除嘛？")
	if(reg){
		location="somainSoitemDelete?soId="+soId;
	}
	
	
}




function finishSomainSoitem(obj){
	var tr=obj.parentNode.parentNode;
	var soId=tr.cells[0].childNodes[0].innerHTML;
	var reg=confirm("确定要了结嘛？")
	if(reg){
		location="somainFinished?soId="+soId;
	}
	
}


function saleSelectSomain(){
	var soId=document.getElementById("saleSelectSOID").value;
	var startDate=document.getElementById("saleSelectStartDate").value;
	var endDate=document.getElementById("saleSelectEndDate").value;
	var customerName=document.getElementById("saleSelectCustomerName").value;
	var payType=document.getElementById("saleSelectPayType").value;
	var status=document.getElementById("saleSelectStatus").value;
	var regStatus=/^[0-9]$/;
	if(regStatus.test(status)){
		location="somainSelect?customerName="+customerName+"&soId="+soId+"&startDate="+startDate+"&endDate="+endDate+"&payType="+payType+"&status="+status;
	}if((!regStatus.test(status))&&status!=""){
		alert("处理状态应为数字！")
	}if(status==""){
		location="somainSelect?customerName="+customerName+"&soId="+soId+"&startDate="+startDate+"&endDate="+endDate+"&payType="+payType+"&status="+status;
	}
}


function saleJournaling(){
	var saleJournalingYear=document.getElementById("saleJournalingYear").value;
	var saleJournalingMonth=document.getElementById("saleJournalingMonth").value;
	var yearMonth=( saleJournalingYear+saleJournalingMonth);
	location="somainJournaling?yearMonth="+yearMonth;
}




function createDate(){
	var date = new Date();
	var createDate = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
	
}
function showSomainSoitem(obj){
	var soId=obj.innerHTML;
	location="somainSoitemDetailed?soId="+soId;
}

function showSaleFinishedDetailed(obj){
	var soId=obj.innerHTML;
	location="saleFinishedDetailed?soId="+soId;
}


function selectONchange(){
	if(document.getElementById("salePayType").value=="预付款到发货"){
		document.getElementById("salePrePayFee").removeAttribute("readonly");
	}if(document.getElementById("salePayType").value=="货到付款"){
		document.getElementById("salePrePayFee").setAttribute("readonly", true);
	}if(document.getElementById("salePayType").value=="款到发货"){
		document.getElementById("salePrePayFee").setAttribute("readonly", true);
	};	
}








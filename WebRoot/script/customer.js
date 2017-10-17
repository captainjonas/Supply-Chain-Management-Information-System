
function onchangePassword(){
	document.getElementById("upassword").value=document.getElementById("ucustomerCode").value;
}



function addCustomer(){
	document.getElementById("ucustomerCode").removeAttribute("readonly");
	var customerCode=document.getElementById("ucustomerCode").value;
	var regCustomerCode=/^[a-zA-Z0-9]{4,20}$/;
	var regPassword=/^[a-zA-z0-9]{4,20}$/;

	var date = new Date();
	var createDate = date.getFullYear()+"-"+((date.getMonth()+1)<10?'0'+(date.getMonth()+1):(date.getMonth()+1))+"-"+date.getDate();
	
	var name=document.getElementById("uname").value;
	var password=document.getElementById("upassword").value;
	var contactor=document.getElementById("ucontactor").value;
	var address=document.getElementById("uaddress").value;
	var postcode=document.getElementById("upostcode").value;
	var tel=document.getElementById("utel").value;
	var fax=document.getElementById("ufax").value;
	
	var x=document.getElementById("x").value;
	if(name!=""&&tel!=""&&contactor!=""&&name.length!=""&&name.length<=100&&regCustomerCode.test(customerCode)&&regPassword.test(password)){
		if(x=="add"){
			location="customerAdd?customerCode="+customerCode+"&name="+name+"&password="+password+"&postcode="+postcode+"&contactor="+contactor+"&address="+address+"&tel="+tel+"&fax="+fax+"&createDate="+createDate;
		};
		if(x=="update"){
			location="customerUpdate?customerCode="+customerCode+"&name="+name+"&password="+password+"&postcode="+postcode+"&contactor="+contactor+"&address="+address+"&tel="+tel+"&fax="+fax+"&createDate="+createDate;
		};
		
	}else{
		alert("输入格式有误！请重新输入。");
	}	

}
function updateCustomer(obj){
	document.getElementById("control").style.display = "block";
	document.getElementById("x").value="update";
	var tr=obj.parentNode.parentNode;
	document.getElementById("ucustomerCode").value=tr.cells[0].innerHTML;
	document.getElementById("uname").value=tr.cells[1].innerHTML;
	document.getElementById("upassword").value=tr.cells[2].innerHTML;
	document.getElementById("ucontactor").value=tr.cells[3].innerHTML;
	document.getElementById("uaddress").value=tr.cells[4].innerHTML;
	document.getElementById("upostcode").value=tr.cells[5].innerHTML;
	document.getElementById("ucreateDate").value=tr.cells[6].innerHTML;
	document.getElementById("utel").value=tr.cells[7].innerHTML;
	document.getElementById("ufax").value=tr.cells[8].innerHTML;
	
	document.getElementById("ucustomerCode").setAttribute("readonly", true);
	
}

function deleteCustomer(obj){
	
	var res = confirm("确定要删除吗？");
	if(res){
		var tr=obj.parentNode.parentNode;
		var customerCode=tr.cells[0].innerHTML;
		var name=tr.cells[1].innerHTML;
		location="customerDelete?customerCode="+customerCode+"&name="+name;
		document.getElementById("control").style.display="none";
	}
	
}


function selectCustomer(){
	
	var customerCode=document.getElementById("selectCustomerCode").value;
	var name=document.getElementById("selectName").value;
	location="customerSelect?customerCode="+customerCode+"&name="+name;
	
}





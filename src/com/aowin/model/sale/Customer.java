package com.aowin.model.sale;

public class Customer {
	private  String customerCode;
	private String name;
	private String password;
	private String contactor;
	private String address;
	private String postcode;
	private String tel;
	private String fax;
	private String createDate;
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactor() {
		return contactor;
	}
	public void setContactor(String contactor) {
		this.contactor = contactor;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerCode, String name, String password, String contactor, String address,
			String postcode, String tel, String fax, String createDate) {
		super();
		this.customerCode = customerCode;
		this.name = name;
		this.password = password;
		this.contactor = contactor;
		this.address = address;
		this.postcode = postcode;
		this.tel = tel;
		this.fax = fax;
		this.createDate = createDate;
	}
	
	
}

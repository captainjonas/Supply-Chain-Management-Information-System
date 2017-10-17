package com.aowin.model.sale;

import java.math.BigDecimal;

public class Somain {
	private String soId;
	private String customerCode;
	private String account;
	private String createTime;
	private BigDecimal tipFee;
	private BigDecimal productTotal;
	private BigDecimal soTotal;
	private String payType;
	private BigDecimal prePayFee;
	private int status;
	private String remark;
	private String stockTime;
	private String stockUser;
	private String payTime;
	private String payUser;
	private String prePayTime;
	private String prePayUser;
	private String endTime;
	private String endUser;
	private String name;
	private BigDecimal nonPayment;
	public String getSoId() {
		return soId;
	}
	public void setSoId(String soId) {
		this.soId = soId;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public BigDecimal getTipFee() {
		return tipFee;
	}
	public void setTipFee(BigDecimal tipFee) {
		this.tipFee = tipFee;
	}
	public BigDecimal getProductTotal() {
		return productTotal;
	}
	public void setProductTotal(BigDecimal productTotal) {
		this.productTotal = productTotal;
	}
	public BigDecimal getSoTotal() {
		return soTotal;
	}
	public void setSoTotal(BigDecimal soTotal) {
		this.soTotal = soTotal;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public BigDecimal getPrePayFee() {
		return prePayFee;
	}
	public void setPrePayFee(BigDecimal prePayFee) {
		this.prePayFee = prePayFee;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStockTime() {
		return stockTime;
	}
	public void setStockTime(String stockTime) {
		this.stockTime = stockTime;
	}
	public String getStockUser() {
		return stockUser;
	}
	public void setStockUser(String stockUser) {
		this.stockUser = stockUser;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getPayUser() {
		return payUser;
	}
	public void setPayUser(String payUser) {
		this.payUser = payUser;
	}
	public String getPrePayTime() {
		return prePayTime;
	}
	public void setPrePayTime(String prePayTime) {
		this.prePayTime = prePayTime;
	}
	public String getPrePayUser() {
		return prePayUser;
	}
	public void setPrePayUser(String prePayUser) {
		this.prePayUser = prePayUser;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getEndUser() {
		return endUser;
	}
	public void setEndUser(String endUser) {
		this.endUser = endUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getNonPayment() {
		return nonPayment;
	}
	public void setNonPayment(BigDecimal nonPayment) {
		this.nonPayment = nonPayment;
	}
	public Somain() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Somain(String soId, String customerCode, String account, String createTime, BigDecimal tipFee, BigDecimal productTotal,
			BigDecimal soTotal, String payType, BigDecimal prePayFee, int status, String remark, String stockTime,
			String stockUser, String payTime, String payUser, String prePayTime, String prePayUser, String endTime,
			String endUser, String name, BigDecimal nonPayment) {
		super();
		this.soId = soId;
		this.customerCode = customerCode;
		this.account = account;
		this.createTime = createTime;
		this.tipFee = tipFee;
		this.productTotal = productTotal;
		this.soTotal = soTotal;
		this.payType = payType;
		this.prePayFee = prePayFee;
		this.status = status;
		this.remark = remark;
		this.stockTime = stockTime;
		this.stockUser = stockUser;
		this.payTime = payTime;
		this.payUser = payUser;
		this.prePayTime = prePayTime;
		this.prePayUser = prePayUser;
		this.endTime = endTime;
		this.endUser = endUser;
		this.name = name;
		this.nonPayment = nonPayment;
	}
	
	
	
	
}

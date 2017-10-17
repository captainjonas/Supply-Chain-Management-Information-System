package com.aowin.model;

import java.math.BigDecimal;

public class Pomain {
	private String poid;
	private String vendercode;
	private String account;
	private String createtime;
	private BigDecimal tipfee;
	private BigDecimal producttotal;
	private BigDecimal pototal;
	private String paytype;
	private BigDecimal prepayfee;
	private int status;
	private String remark;
	private String stocktime;
	private String stockuser;
	private String paytime;
	private String payuser;
	private String prepaytime;
	private String prepayuser;
	private String endtime;
	private String enduser;
	private String venderName;
	private String creatorName;
	public String getPoid() {
		return poid;
	}
	public void setPoid(String poid) {
		this.poid = poid;
	}
	public String getVendercode() {
		return vendercode;
	}
	public void setVendercode(String vendercode) {
		this.vendercode = vendercode;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public BigDecimal getTipfee() {
		return tipfee;
	}
	public void setTipfee(BigDecimal tipfee) {
		this.tipfee = tipfee;
	}
	public BigDecimal getProducttotal() {
		return producttotal;
	}
	public void setProducttotal(BigDecimal producttotal) {
		this.producttotal = producttotal;
	}
	public BigDecimal getPototal() {
		return pototal;
	}
	public void setPototal(BigDecimal pototal) {
		this.pototal = pototal;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public BigDecimal getPrepayfee() {
		return prepayfee;
	}
	public void setPrepayfee(BigDecimal prepayfee) {
		this.prepayfee = prepayfee;
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
	public String getStocktime() {
		return stocktime;
	}
	public void setStocktime(String stocktime) {
		this.stocktime = stocktime;
	}
	public String getStockuser() {
		return stockuser;
	}
	public void setStockuser(String stockuser) {
		this.stockuser = stockuser;
	}
	public String getPaytime() {
		return paytime;
	}
	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}
	public String getPayuser() {
		return payuser;
	}
	public void setPayuser(String payuser) {
		this.payuser = payuser;
	}
	public String getPrepaytime() {
		return prepaytime;
	}
	public void setPrepaytime(String prepaytime) {
		this.prepaytime = prepaytime;
	}
	public String getPrepayuser() {
		return prepayuser;
	}
	public void setPrepayuser(String prepayuser) {
		this.prepayuser = prepayuser;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getEnduser() {
		return enduser;
	}
	public void setEnduser(String enduser) {
		this.enduser = enduser;
	}
	
	public String getVenderName() {
		return venderName;
	}
	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}
	
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public Pomain(String poid, String vendercode, String account, String createtime, BigDecimal tipfee, BigDecimal producttotal,
			BigDecimal pototal, String paytype, BigDecimal prepayfee, int status, String remark, String stocktime, String stockuser,
			String paytime, String payuser, String prepaytime, String prepayuser, String endtime, String enduser) {
		super();
		this.poid = poid;
		this.vendercode = vendercode;
		this.account = account;
		this.createtime = createtime;
		this.tipfee = tipfee;
		this.producttotal = producttotal;
		this.pototal = pototal;
		this.paytype = paytype;
		this.prepayfee = prepayfee;
		this.status = status;
		this.remark = remark;
		this.stocktime = stocktime;
		this.stockuser = stockuser;
		this.paytime = paytime;
		this.payuser = payuser;
		this.prepaytime = prepaytime;
		this.prepayuser = prepayuser;
		this.endtime = endtime;
		this.enduser = enduser;
	}
	public Pomain() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

package com.aowin.model;

import java.math.BigDecimal;

public class SoItem {
	private String soid;
	private String productCode;
	private BigDecimal unitPrice;
	private int num;
	private String unitName;
	private BigDecimal itemPrice;
	private String productName;
	private String stockTime;
	private String type;
	public String getSoid() {
		return soid;
	}
	public void setSoid(String soid) {
		this.soid = soid;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public BigDecimal getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	public String getStockTime() {
		return stockTime;
	}
	public void setStockTime(String stockTime) {
		this.stockTime = stockTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public SoItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SoItem(String soid, String productCode, BigDecimal unitPrice, int num, String unitName, BigDecimal itemPrice,
			String productName) {
		super();
		this.soid = soid;
		this.productCode = productCode;
		this.unitPrice = unitPrice;
		this.num = num;
		this.unitName = unitName;
		this.itemPrice = itemPrice;
		this.productName = productName;
	}
	
	

}

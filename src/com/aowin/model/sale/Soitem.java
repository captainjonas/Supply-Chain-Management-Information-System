package com.aowin.model.sale;

import java.math.BigDecimal;

public class Soitem {
	private String soId;
	private String productCode;
	private BigDecimal unitPrice;
	private int num;
	private String unitName;
	private BigDecimal itemPrice;
	
	private String productName;

	public String getSoId() {
		return soId;
	}

	public void setSoId(String soId) {
		this.soId = soId;
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

	public Soitem(String soId, String productCode, BigDecimal unitPrice, int num, String unitName, BigDecimal itemPrice,
			String productName) {
		super();
		this.soId = soId;
		this.productCode = productCode;
		this.unitPrice = unitPrice;
		this.num = num;
		this.unitName = unitName;
		this.itemPrice = itemPrice;
		this.productName = productName;
	}

	public Soitem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Soitem [soId=" + soId + ", productCode=" + productCode + ", unitPrice=" + unitPrice + ", num=" + num
				+ ", unitName=" + unitName + ", itemPrice=" + itemPrice + ", productName=" + productName + "]";
	}
	
	
	
}

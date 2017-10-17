package com.aowin.model;

import java.math.BigDecimal;

public class PoItem {
	private String poID;
	private String proCode;
	private BigDecimal unitPrice;
	private int num;
	private String unitName;
	private BigDecimal itemPrice;
	private String proName;
	private String stockTime;
	private String type;
	public String getPoID() {
		return poID;
	}
	public void setPoID(String poID) {
		this.poID = poID;
	}
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
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
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
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
	public PoItem(String poID, String proCode, BigDecimal unitPrice, int num, String unitName, BigDecimal itemPrice,
			String proName) {
		super();
		this.poID = poID;
		this.proCode = proCode;
		this.unitPrice = unitPrice;
		this.num = num;
		this.unitName = unitName;
		this.itemPrice = itemPrice;
		this.proName = proName;
	}
	public PoItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

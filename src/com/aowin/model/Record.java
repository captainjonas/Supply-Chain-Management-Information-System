package com.aowin.model;

public class Record {
	private String stockTime;
	private String orderCode;
	private String createUser;
	private int stockNum;
	private String stockType;
	public String getStockTime() {
		return stockTime;
	}
	public void setStockTime(String stockTime) {
		this.stockTime = stockTime;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public int getStockNum() {
		return stockNum;
	}
	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}
	public String getStockType() {
		return stockType;
	}
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	public Record(String stockTime, String orderCode, String createUser, int stockNum, String stockType) {
		super();
		this.stockTime = stockTime;
		this.orderCode = orderCode;
		this.createUser = createUser;
		this.stockNum = stockNum;
		this.stockType = stockType;
	}
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}

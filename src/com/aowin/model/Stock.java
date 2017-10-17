package com.aowin.model;

public class Stock {
	private String proCode;
	private String name;
	private String unit;
	private int number;
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(String proCode, String name, String unit, int number) {
		super();
		this.proCode = proCode;
		this.name = name;
		this.unit = unit;
		this.number = number;
	}
	
	
	
	

}

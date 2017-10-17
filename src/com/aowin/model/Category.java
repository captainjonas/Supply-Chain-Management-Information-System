package com.aowin.model;

public class Category {
	private int categoryID;
	private String name;
	private String remark;
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Category(int categoryID, String name, String remark) {
		super();
		this.categoryID = categoryID;
		this.name = name;
		this.remark = remark;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

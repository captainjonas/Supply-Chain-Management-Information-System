package com.aowin.model.sale;

import java.math.BigDecimal;

public class Product {
	private String productCode;
	private int  cateGoryID;
	private String productName;
	private String unitName;
	private BigDecimal unitPrice;
	private String createDate;
	private String remark;
	private int poNum;
	private int soNum;
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getCateGoryID() {
		return cateGoryID;
	}
	public void setCateGoryID(int cateGoryID) {
		this.cateGoryID = cateGoryID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getPoNum() {
		return poNum;
	}
	public void setPoNum(int poNum) {
		this.poNum = poNum;
	}
	public int getSoNum() {
		return soNum;
	}
	public void setSoNum(int soNum) {
		this.soNum = soNum;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", cateGoryID=" + cateGoryID + ", productName=" + productName
				+ ", unitName=" + unitName + ", unitPrice=" + unitPrice + ", createDate=" + createDate + ", remark="
				+ remark + ", poNum=" + poNum + ", soNum=" + soNum + "]";
	}
		
	
	
}

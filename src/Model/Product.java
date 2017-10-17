package Model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable{
	private String productcode;
	private int categoryid;
	private String name;
	private String unitname;
	private BigDecimal price;
	private String createdate;
	private String remark;
	private int  ponum;
	private int  sonum;
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnitname() {
		return unitname;
	}
	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getPonum() {
		return ponum;
	}
	public void setPonum(int ponum) {
		this.ponum = ponum;
	}
	public int getSonum() {
		return sonum;
	}
	public void setSonum(int sonum) {
		this.sonum = sonum;
	}

	
}

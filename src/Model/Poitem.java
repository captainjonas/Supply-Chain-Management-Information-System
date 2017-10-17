package Model;

import java.math.BigDecimal;

public class Poitem {
	private String poid;
	private String productcode;
	private BigDecimal unitprice;
	private int num;
	private String unitname;
	private BigDecimal itemprice;
	private int ponum;//�ɹ���;��
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPonum() {
		return ponum;
	}
	public void setPonum(int ponum) {
		this.ponum = ponum;
	}
	public String getPoid() {
		return poid;
	}
	public void setPoid(String poid) {
		this.poid = poid;
	}
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	public BigDecimal getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(BigDecimal unitprice) {
		this.unitprice = unitprice;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUnitname() {
		return unitname;
	}
	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
	public BigDecimal getItemprice() {
		return itemprice;
	}
	public void setItemprice(BigDecimal itemprice) {
		this.itemprice = itemprice;
	}
	
}

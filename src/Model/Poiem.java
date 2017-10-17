package Model;

import java.math.BigDecimal;

public class Poiem {
	private String productcode;//product ��Ʒ���
	private String name;//product ��Ʒ����
	private String unitname;//product ������λ
	private int num;//poitem ����
	private BigDecimal unitprice;//����
	private BigDecimal itemprice;//��ϸ�ܼ�
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public BigDecimal getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(BigDecimal unitprice) {
		this.unitprice = unitprice;
	}
	public BigDecimal getItemprice() {
		return itemprice;
	}
	public void setItemprice(BigDecimal itemprice) {
		this.itemprice = itemprice;
	}
}

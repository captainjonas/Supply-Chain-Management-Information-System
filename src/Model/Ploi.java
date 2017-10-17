package Model;

import java.math.BigDecimal;

public class Ploi {
	private String poid;//pomain ��� �ɹ������
	private String createtime;//pomain ����ʱ��
	private String account;
	private String vendercode;
	public String getVendercode() {
		return vendercode;
	}
	public void setVendercode(String vendercode) {
		this.vendercode = vendercode;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	private String name;//vender ��� ����������
	private BigDecimal tipfee;//pomain �������
	private BigDecimal producttotal;//pomain ��Ʒ�ܼ�
	private BigDecimal pototal;//pomain �ɹ����ܼ�
	private String paytype;//pomain ���ʽ
	private BigDecimal prepayfee;//pomain ���Ԥ�����
	private int status;//pomain ����״̬
	private String remark;//pomain ��ע
	private String stocktime;//pomain ���ʱ��
	private String stockuser;//pomain �����
	private String prepaytime;//pomain Ԥ��ʱ��
	private String prepayuser;//pomain Ԥ�������û�
	public String getPoid() {
		return poid;
	}
	public void setPoid(String poid) {
		this.poid = poid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getTipfee() {
		return tipfee;
	}
	public void setTipfee(BigDecimal tipfee) {
		this.tipfee = tipfee;
	}
	public BigDecimal getProducttotal() {
		return producttotal;
	}
	public void setProducttotal(BigDecimal producttotal) {
		this.producttotal = producttotal;
	}
	public BigDecimal getPototal() {
		return pototal;
	}
	public void setPototal(BigDecimal pototal) {
		this.pototal = pototal;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public BigDecimal getPrepayfee() {
		return prepayfee;
	}
	public void setPrepayfee(BigDecimal prepayfee) {
		this.prepayfee = prepayfee;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStocktime() {
		return stocktime;
	}
	public void setStocktime(String stocktime) {
		this.stocktime = stocktime;
	}
	public String getStockuser() {
		return stockuser;
	}
	public void setStockuser(String stockuser) {
		this.stockuser = stockuser;
	}
	public String getPrepaytime() {
		return prepaytime;
	}
	public void setPrepaytime(String prepaytime) {
		this.prepaytime = prepaytime;
	}
	public String getPrepayuser() {
		return prepayuser;
	}
	public void setPrepayuser(String prepayuser) {
		this.prepayuser = prepayuser;
	}
}

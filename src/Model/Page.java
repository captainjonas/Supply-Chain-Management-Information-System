package Model;

import java.util.List;

public class Page {
	private int nowpage;//��ǰ��ҳ��
	private int allpage;//��ҳ��
	private int  pagefen;//�趨ÿҳ��ʾ���������ݣ�
	private List<Vender> pageyu;//ÿ�β�ѯ��������
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getAllpage() {
		return allpage;
	}
	public void setAllpage(int allpage) {
		this.allpage = allpage;
	}
	public int getPagefen() {
		return pagefen;
	}
	public void setPagefen(int pagefen) {
		this.pagefen = pagefen;
	}
	public List<Vender> getPageyu() {
		return pageyu;
	}
	public void setPageyu(List<Vender> pageyu) {
		this.pageyu = pageyu;
	}
	
}

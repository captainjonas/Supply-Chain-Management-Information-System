package Model;

import java.util.List;

public class Page {
	private int nowpage;//当前的页数
	private int allpage;//总页数
	private int  pagefen;//设定每页显示多少条数据；
	private List<Vender> pageyu;//每次查询到的数据
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

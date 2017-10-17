package com.aowin.model.sale;

import java.util.List;

public class Page {
	private int currentPage;// 当前要显示的页码
	private int pageSize;// 每页显示的数量
	private int totalPage;// 总页数
	private List<Customer> data;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Customer> getData() {
		return data;
	}
	public void setData(List<Customer> data) {
		this.data = data;
	}


}

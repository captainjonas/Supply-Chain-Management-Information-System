package com.aowin.model;

import java.util.List;

public class Page {
	private int currentPage;
	private int pageSize;
	private int totalPage;
	private List data;
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
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public Page(int currentPage, int pageSize, int totalPage, List data) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.data = data;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}

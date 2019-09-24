package com.zcjd.app_server.base.page;

import java.io.Serializable;

public class PageInfo implements Serializable{

	/**
	 * 分页
	 */
	private static final long serialVersionUID = -4076251710795431210L;
	
	private int showCount = 10;//每页显示条数
    private int totalPage;
    private int totalResult;
    private int currentPage;
    private int currentResult;
    private int page;

    private String sortField;
    private String order;
    
	public int getShowCount() {
		return showCount;
	}
	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}
	public int getTotalPage() {
		totalPage = (totalResult+showCount-1)/showCount;
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalResult() {
		return totalResult;
	}
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCurrentResult() {
		return page*showCount;
	}
	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}
	public String getSortField() {
		return sortField;
	}
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
}

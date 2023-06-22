package com.newsweb.sort;

public class Sorter {

	private String sortBy;
	private String sortOrder;

	public Sorter(String sortBy, String sortOrder) {
		this.setSortBy(sortBy);
		this.setSortOrder(sortOrder);
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
}

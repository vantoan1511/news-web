package com.newsweb.paging;

import com.newsweb.sort.Sorter;

public interface Pagable {

	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}

package com.newsweb.service;

import java.util.List;

import com.newsweb.model.NewsModel;
import com.newsweb.paging.Pagable;

public interface INewsService {

	List<NewsModel> findByCategoryId(long categoryId);

	List<NewsModel> findAll(Pagable pagable);

	NewsModel save(NewsModel news);

	NewsModel update(NewsModel updatedNews);

	void delete(long[] ids);

	int getTotalItem();
}

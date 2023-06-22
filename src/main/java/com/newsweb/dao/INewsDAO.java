package com.newsweb.dao;

import java.util.List;

import com.newsweb.model.NewsModel;
import com.newsweb.paging.Pagable;

public interface INewsDAO extends GenericDAO<NewsModel> {

	NewsModel findById(Long id);

	List<NewsModel> findByCategoryId(long categoryId);

	List<NewsModel> findAll(Pagable pagable);

	Long save(NewsModel news);

	void update(NewsModel updatedNews);

	void delete(long id);

	int getTotalItem();
}

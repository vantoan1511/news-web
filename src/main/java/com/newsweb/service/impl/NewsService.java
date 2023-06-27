package com.newsweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.newsweb.dao.INewsDAO;
import com.newsweb.model.NewsModel;
import com.newsweb.paging.Pagable;
import com.newsweb.service.INewsService;

public class NewsService implements INewsService {

	@Inject
	private INewsDAO newsDAO;

	@Override
	public List<NewsModel> findAll(Pagable pagable) {
		return newsDAO.findAll(pagable);
	}

	@Override
	public List<NewsModel> findByCategoryId(long categoryId) {
		return newsDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel news) {
		news.setCreateDate(new Timestamp(System.currentTimeMillis()));
		Long id = newsDAO.save(news);
		return newsDAO.findById(id);
	}

	@Override
	public NewsModel update(NewsModel updatedNews) {
		NewsModel oldModel = newsDAO.findById(updatedNews.getId());
		updatedNews.setCreateDate(oldModel.getCreateDate());
		updatedNews.setCreateBy(oldModel.getCreateBy());
		updatedNews.setModifyDate(new Timestamp(System.currentTimeMillis()));
		newsDAO.update(updatedNews);
		return newsDAO.findById(updatedNews.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			newsDAO.delete(id);
		}
	}

	@Override
	public int getTotalItem() {
		return newsDAO.getTotalItem();
	}

	@Override
	public NewsModel findById(Long id) {
		return newsDAO.findById(id);
	}

}

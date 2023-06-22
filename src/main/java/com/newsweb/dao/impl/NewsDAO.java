package com.newsweb.dao.impl;

import java.util.List;

import com.newsweb.dao.INewsDAO;
import com.newsweb.mapper.NewsMapper;
import com.newsweb.model.NewsModel;
import com.newsweb.paging.Pagable;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

	@Override
	public NewsModel findById(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewsModel> news = query(sql, new NewsMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public List<NewsModel> findByCategoryId(long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewsMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel model) {
//		String sql = "INSERT INTO news(title, content, categoryid) VALUES(?, ?, ?)";
		StringBuilder sql = new StringBuilder("INSERT INTO news (title, content, categoryid, ");
		sql.append("thumbnail, description, create_date, create_by) VALUES ");
		sql.append("(?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), model.getTitle(), model.getContent(), model.getCategoryId(), model.getThumbnail(),
				model.getDescription(), model.getCreateDate(), model.getCreateBy());
	}

	@Override
	public void update(NewsModel updatedNews) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?, ");
		sql.append(" description = ?, content = ?, categoryid = ?, create_date = ?, create_by = ? ");
		sql.append(" WHERE id = ?");
		update(sql.toString(), updatedNews.getTitle(), updatedNews.getThumbnail(), updatedNews.getDescription(),
				updatedNews.getContent(), updatedNews.getCategoryId(), updatedNews.getCreateDate(),
				updatedNews.getCreateBy(), updatedNews.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, id);
	}

	@Override
	public List<NewsModel> findAll(Pagable pagable) {
//		String sql = "SELECT * FROM news LIMIT ?, ?";
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		if (pagable.getSorter() != null) {
			sql.append(" ORDER BY " + pagable.getSorter().getSortBy() + " " + pagable.getSorter().getSortOrder());
		}
		if (pagable.getOffset() != null && pagable.getLimit() != null) {
			sql.append(" LIMIT " + pagable.getOffset() + " ," + pagable.getLimit() + " ");
		}
		return query(sql.toString(), new NewsMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) from news";
		return count(sql);
	}
}

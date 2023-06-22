package com.newsweb.mapper;

import java.sql.ResultSet;

import com.newsweb.model.NewsModel;

public class NewsMapper implements RowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet resultSet) {
		try {
			NewsModel model = new NewsModel();
			model.setId(resultSet.getLong("id"));
			model.setTitle(resultSet.getString("title"));
			model.setContent(resultSet.getString("content"));
			model.setDescription(resultSet.getString("description"));
			model.setCategoryId(resultSet.getLong("categoryid"));
			model.setThumbnail(resultSet.getString("thumbnail"));
			model.setCreateDate(resultSet.getTimestamp("create_date"));
			model.setCreateBy(resultSet.getString("create_by"));
			if (resultSet.getTimestamp("modify_date") != null) {
				model.setModifyDate(resultSet.getTimestamp("modify_date"));
			}
			if (resultSet.getString("modify_by") != null) {
				model.setModifyBy(resultSet.getString("modify_by"));
			}
			return model;
		} catch (Exception e) {
			return null;
		}
	}
}

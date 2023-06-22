package com.newsweb.dao.impl;

import java.util.List;

import com.newsweb.dao.ICategoryDAO;
import com.newsweb.mapper.CategoryMapper;
import com.newsweb.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

}

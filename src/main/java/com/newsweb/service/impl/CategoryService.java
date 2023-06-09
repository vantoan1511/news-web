package com.newsweb.service.impl;

import java.util.List;

import com.newsweb.dao.impl.CategoryDAO;
import com.newsweb.model.CategoryModel;
import com.newsweb.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Override
	public List<CategoryModel> findAll() {
		return new CategoryDAO().findAll();
	}

}

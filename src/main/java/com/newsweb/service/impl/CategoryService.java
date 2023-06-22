package com.newsweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.newsweb.dao.ICategoryDAO;
import com.newsweb.model.CategoryModel;
import com.newsweb.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

}

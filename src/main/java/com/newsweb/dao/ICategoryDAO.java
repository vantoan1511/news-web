package com.newsweb.dao;

import java.util.List;

import com.newsweb.model.CategoryModel;

public interface ICategoryDAO {

	List<CategoryModel> findAll();
}

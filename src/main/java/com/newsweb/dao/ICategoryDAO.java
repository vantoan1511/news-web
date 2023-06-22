package com.newsweb.dao;

import java.util.List;

import com.newsweb.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {

	List<CategoryModel> findAll();
}

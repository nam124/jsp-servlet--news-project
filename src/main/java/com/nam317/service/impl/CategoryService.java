package com.nam317.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.nam317.dao.ICategoryDAO;
import com.nam317.model.CategoryModel;
import com.nam317.service.ICategoryServicve;

public class CategoryService implements ICategoryServicve {

	@Inject
	private ICategoryDAO categoryDao;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findALL();
		
	}

}

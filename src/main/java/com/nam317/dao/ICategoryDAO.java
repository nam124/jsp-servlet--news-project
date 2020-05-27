package com.nam317.dao;
import java.util.List;
import com.nam317.model.CategoryModel;
public interface ICategoryDAO extends GenericDAO<CategoryModel>{
	List<CategoryModel> findALL();
	CategoryModel findOne(long id);
	CategoryModel findOneByCode(String code);
}

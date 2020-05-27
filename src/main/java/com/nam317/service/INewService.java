package com.nam317.service;

import java.util.List;

import com.nam317.model.NewModel;
import com.nam317.paging.Pageble;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryId);
	NewModel save(NewModel newModel);
	NewModel update(NewModel updateNew);
	void delete(long[] ids);
	List<NewModel> findAll(Pageble pageble);
	 int getTotalItem();
	 NewModel findOne(long id);
}

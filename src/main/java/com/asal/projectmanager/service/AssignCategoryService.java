package com.asal.projectmanager.service;

import java.util.List;

import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.AdvertCategory;
import com.asal.projectmanager.domain.AssignCategory;

public interface AssignCategoryService extends
		AdvertBaseService<AssignCategory> {
	
	public List<AssignCategory> findAll(Advert advert);
	public void removeById(Long Id);
	
	public List<Advert> findAll(AdvertCategory advertCategory);
	public List<Advert> findAllActive(AdvertCategory advertCategory);

}

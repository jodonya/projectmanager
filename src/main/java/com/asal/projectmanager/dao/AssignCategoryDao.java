package com.asal.projectmanager.dao;

import java.util.List;

import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.AdvertCategory;
import com.asal.projectmanager.domain.AssignCategory;

public interface AssignCategoryDao extends Dao<AssignCategory> {
	public List<AssignCategory> findAll(Advert advert);
	public List<Advert> findAll(AdvertCategory category);
	public void removeById(Long Id);
	
	public List<Advert> findAllActive(AdvertCategory category);
}

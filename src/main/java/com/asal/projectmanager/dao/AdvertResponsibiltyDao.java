package com.asal.projectmanager.dao;

import java.util.List;

import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.AdvertResponsibilty;

public interface AdvertResponsibiltyDao extends Dao<AdvertResponsibilty> {
	public List<AdvertResponsibilty> findAll(Advert advert);
}

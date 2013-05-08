package com.asal.projectmanager.service;

import java.util.List;

import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.AdvertResponsibilty;

public interface AdvertResponsibiltyService extends
		AdvertBaseService<AdvertResponsibilty> {
	public List<AdvertResponsibilty> findAll(Advert advert);

}

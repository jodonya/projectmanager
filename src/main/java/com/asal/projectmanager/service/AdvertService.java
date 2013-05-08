package com.asal.projectmanager.service;

import java.util.List;

import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.Company;

public interface AdvertService extends AdvertBaseService<Advert> {
	public List<Advert> findAll(Company company);

}

package com.asal.projectmanager.service;

import java.util.List;

import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.Company;

public interface AdvertService extends AdvertBaseService<Advert> {
	public List<Advert> findAll(Company company);
	
	public List<Advert> findAllActive(Company company);
	public List<Advert> findAllActive();
	public List<Advert> findAllExpired(Company company);
	public List<Advert> findAllExpired();
	public Advert findAdvert(String name);

}

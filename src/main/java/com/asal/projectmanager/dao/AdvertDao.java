package com.asal.projectmanager.dao;

import java.util.List;

import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.Company;

public interface AdvertDao extends Dao<Advert> {
	public List<Advert> findAll(Company company);

}

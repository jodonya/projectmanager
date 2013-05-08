package com.asal.projectmanager.dao;

import java.util.List;

import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.AdvertRequirement;

public interface AdvertRequirementDao extends Dao<AdvertRequirement> {
	public List<AdvertRequirement> findAll(Advert advert);

}

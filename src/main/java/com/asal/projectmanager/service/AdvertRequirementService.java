package com.asal.projectmanager.service;

import java.util.List;

import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.AdvertRequirement;

public interface AdvertRequirementService extends
		AdvertBaseService<AdvertRequirement> {
	public List<AdvertRequirement> findAll(Advert advert);

}

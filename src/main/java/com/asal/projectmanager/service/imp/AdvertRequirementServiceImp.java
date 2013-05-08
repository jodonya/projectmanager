package com.asal.projectmanager.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.AdvertRequirementDao;
import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.AdvertRequirement;
import com.asal.projectmanager.service.AdvertRequirementService;

@Service
public class AdvertRequirementServiceImp implements AdvertRequirementService {
	
	@Autowired
	AdvertRequirementDao advertRequirementDao;

	@Transactional
	public void add(AdvertRequirement advertRequirement) {
		advertRequirementDao.save(advertRequirement);
	}

	@Transactional
	public List<AdvertRequirement> findAll() {
		return advertRequirementDao.findAll();
	}

	@Transactional
	public AdvertRequirement findById(Long id) {
		return advertRequirementDao.findOne(id);
	}

	@Transactional
	public void remove(AdvertRequirement advertRequirement) {
		advertRequirementDao.delete(advertRequirement);
	}

	@Transactional
	public void update(AdvertRequirement advertRequirement) {
		advertRequirementDao.update(advertRequirement);
	}

	@Transactional
	public Long count() {
		return advertRequirementDao.count();
	}

	@Transactional
	public List<AdvertRequirement> findAll(Advert advert) {
		return advertRequirementDao.findAll(advert);
	}

}

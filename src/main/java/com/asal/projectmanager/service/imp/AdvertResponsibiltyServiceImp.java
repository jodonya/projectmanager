package com.asal.projectmanager.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.AdvertResponsibiltyDao;
import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.AdvertResponsibilty;
import com.asal.projectmanager.service.AdvertResponsibiltyService;

@Service
public class AdvertResponsibiltyServiceImp implements
		AdvertResponsibiltyService {

	@Autowired
	AdvertResponsibiltyDao advertResponsibiltyDao;
	
	@Transactional
	public void add(AdvertResponsibilty advertResponsibilty) {
		advertResponsibiltyDao.save(advertResponsibilty);
	}

	@Transactional
	public List<AdvertResponsibilty> findAll() {
		return advertResponsibiltyDao.findAll();
	}

	@Transactional
	public AdvertResponsibilty findById(Long id) {
		return advertResponsibiltyDao.findOne(id);
	}

	@Transactional
	public void remove(AdvertResponsibilty advertResponsibilty) {
		advertResponsibiltyDao.delete(advertResponsibilty);
	}

	@Transactional
	public void update(AdvertResponsibilty advertResponsibilty) {
		advertResponsibiltyDao.update(advertResponsibilty);
	}

	@Transactional
	public Long count() {
		return advertResponsibiltyDao.count();
	}

	@Transactional
	public List<AdvertResponsibilty> findAll(Advert advert) {
		return advertResponsibiltyDao.findAll(advert);
	}

}

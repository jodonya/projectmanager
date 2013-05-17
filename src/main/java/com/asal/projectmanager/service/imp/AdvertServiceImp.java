package com.asal.projectmanager.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.AdvertDao;
import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.Company;
import com.asal.projectmanager.service.AdvertService;

@Service
public class AdvertServiceImp implements AdvertService {

	@Autowired
	AdvertDao advertDao;
	
	@Transactional
	public void add(Advert advert) {
		advertDao.save(advert);
	}

	@Transactional
	public List<Advert> findAll() {
		return advertDao.findAll();
	}

	@Transactional
	public Advert findById(Long id) {
		return advertDao.findOne(id);
	}

	@Transactional
	public void remove(Advert advert) {
		advertDao.delete(advert);
	}

	@Transactional
	public void update(Advert advert) {
		advertDao.update(advert);
		
		
	}

	@Transactional
	public Long count() {
		return advertDao.count();
	}

	@Transactional
	public List<Advert> findAll(Company company) {
		return advertDao.findAll(company);
	}

	@Transactional
	public List<Advert> findAllActive(Company company) {
		return advertDao.findAllActive(company);
	}

	@Transactional
	public List<Advert> findAllActive() {
		return advertDao.findAllActive();
	}

	@Transactional
	public List<Advert> findAllExpired(Company company) {
		return findAllExpired(company);
	}

	@Transactional
	public List<Advert> findAllExpired() {
		return advertDao.findAllExpired();
	}

	@Transactional
	public Advert findAdvert(String name) {
		return advertDao.findAdvert(name);
	}

}

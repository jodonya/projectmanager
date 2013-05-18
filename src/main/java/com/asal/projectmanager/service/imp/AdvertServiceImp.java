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

	
	/***
	 * Grouping Live Adverts By Date
	 * */
	public List<Advert> getTodayAdverts() {
		return advertDao.getTodayAdverts();
	}

	public List<Advert> getYesterdayAdverts() {
		// TODO Auto-generated method stub
		return advertDao.getYesterdayAdverts();
	}

	public List<Advert> getPastWeekAdvert() {
		// TODO Auto-generated method stub
		return advertDao.getPastWeekAdvert();
	}

	public List<Advert> getPast2WeeksAdverts() {
		return advertDao.getPast2WeeksAdverts();
	}

	public List<Advert> getOneMonthOldAdverts() {
		// TODO Auto-generated method stub
		return advertDao.getOneMonthOldAdverts();
	}

	public List<Advert> getOlderThanOneMonthAdverts() {
		// TODO Auto-generated method stub
		return advertDao.getOlderThanOneMonthAdverts();
	}

	public Long getTodayAdvertsCount() {
		// TODO Auto-generated method stub
		return advertDao.getTodayAdvertsCount();
	}

	public Long getYesterdayAdvertsCount() {
		// TODO Auto-generated method stub
		return advertDao.getYesterdayAdvertsCount();
	}

	public Long getPastWeekAdvertCount() {
		// TODO Auto-generated method stub
		return advertDao.getPastWeekAdvertCount();
	}

	public Long getPast2WeeksAdvertsCount() {
		// TODO Auto-generated method stub
		return advertDao.getPast2WeeksAdvertsCount();
	}

	public Long getOneMonthOldAdvertsCount() {
		// TODO Auto-generated method stub
		return advertDao.getOneMonthOldAdvertsCount();
	}

	public Long getOlderThanOneMonthAdvertsCount() {
		// TODO Auto-generated method stub
		return advertDao.getOlderThanOneMonthAdvertsCount();
	}

}

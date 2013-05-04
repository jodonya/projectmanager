package com.asal.projectmanager.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.AdvertDownDao;
import com.asal.projectmanager.domain.AdvertDown;
import com.asal.projectmanager.service.AdvertDownService;

@Service
public class AdvertDownServiceImp implements AdvertDownService {

	@Autowired
	AdvertDownDao advertDownDao;
	
	@Transactional
	public void add(AdvertDown advertDown) {
		advertDownDao.save(advertDown);
	}

	@Transactional
	public List<AdvertDown> findAll() {
		return advertDownDao.findAll();
	}

	@Transactional
	public AdvertDown findById(Long id) {
		return advertDownDao.findOne(id);
	}

	@Transactional
	public void remove(AdvertDown advertDown) {
		advertDownDao.delete(advertDown);
	}

	@Transactional
	public void update(AdvertDown advertDown) {
		advertDownDao.update(advertDown);
	}

	@Transactional
	public Long count() {
		return advertDownDao.count();
	}

}

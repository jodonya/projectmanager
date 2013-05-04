package com.asal.projectmanager.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.AdvertUpDao;
import com.asal.projectmanager.domain.AdvertUp;
import com.asal.projectmanager.service.AdvertUpService;

@Service
public class AdvertUpServiceImp implements AdvertUpService {
	
	@Autowired
	AdvertUpDao advertUpDao;

	@Transactional
	public void add(AdvertUp advertUp) {
		advertUpDao.save(advertUp);
	}

	@Transactional
	public List<AdvertUp> findAll() {
		return advertUpDao.findAll();
	}

	@Transactional
	public AdvertUp findById(Long id) {
		return advertUpDao.findOne(id);
	}

	@Transactional
	public void remove(AdvertUp advertUp) {
		advertUpDao.delete(advertUp);
	}

	@Transactional
	public void update(AdvertUp advertUp) {
		advertUpDao.update(advertUp);
	}

	@Transactional
	public Long count() {
		return advertUpDao.count();
	}

}

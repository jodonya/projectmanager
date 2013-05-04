package com.asal.projectmanager.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.AdvertCategoryDao;
import com.asal.projectmanager.domain.AdvertCategory;
import com.asal.projectmanager.service.AdvertCategoryService;

@Service
public class AdvertCategoryServiceImp implements AdvertCategoryService {
	@Autowired
	AdvertCategoryDao advertCategoryDao;

	@Transactional
	public void add(AdvertCategory advertCategory) {
		advertCategoryDao.save(advertCategory);
	}

	@Transactional
	public List<AdvertCategory> findAll() {
		return advertCategoryDao.findAll();
	}

	@Transactional
	public AdvertCategory findById(Long id) {
		return advertCategoryDao.findOne(id);
	}

	@Transactional
	public void remove(AdvertCategory advertCategory) {
		advertCategoryDao.delete(advertCategory);
	}

	@Transactional
	public void update(AdvertCategory advertCategory) {
		advertCategoryDao.update(advertCategory);
	}

	@Transactional
	public Long count() {
		return advertCategoryDao.count();
	}

}

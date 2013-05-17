package com.asal.projectmanager.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.AssignCategoryDao;
import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.domain.AdvertCategory;
import com.asal.projectmanager.domain.AssignCategory;
import com.asal.projectmanager.service.AssignCategoryService;

@Service
public class AssignCategoryServiceImp implements AssignCategoryService {
	
	@Autowired
	AssignCategoryDao assignCategoryDao;

	@Transactional
	public void add(AssignCategory assignCategory) {
		assignCategoryDao.save(assignCategory);
	}

	@Transactional
	public List<AssignCategory> findAll() {
		return assignCategoryDao.findAll();
	}

	@Transactional
	public AssignCategory findById(Long id) {
		return assignCategoryDao.findOne(id);
	}

	@Transactional
	public void remove(AssignCategory assignCategory) {
		assignCategoryDao.delete(assignCategory);
	}

	@Transactional
	public void update(AssignCategory assignCategory) {
		assignCategoryDao.update(assignCategory);
	}

	@Transactional
	public Long count() {
		return assignCategoryDao.count();
	}

	@Transactional
	public List<AssignCategory> findAll(Advert advert) {
		return assignCategoryDao.findAll(advert);
	}

	@Transactional
	public void removeById(Long Id) {
		assignCategoryDao.removeById(Id);
		
	}

	@Transactional
	public List<Advert> findAll(AdvertCategory advertCategory) {
		return assignCategoryDao.findAll(advertCategory);
	}

	
	@Transactional
	public List<Advert> findAllActive(AdvertCategory advertCategory) {
		return assignCategoryDao.findAllActive(advertCategory);
	}

}

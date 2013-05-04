package com.asal.projectmanager.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.AdvertCommentUpDao;
import com.asal.projectmanager.domain.AdvertCommentUp;
import com.asal.projectmanager.service.AdvertCommentUpService;
@Service
public class AdvertCommentUpServiceImp implements AdvertCommentUpService {

	@Autowired
	AdvertCommentUpDao advertCommentUpDao;
	
	@Transactional
	public void add(AdvertCommentUp adverCommentUp) {
		advertCommentUpDao.save(adverCommentUp);
	}

	@Transactional
	public List<AdvertCommentUp> findAll() {
		return advertCommentUpDao.findAll();
	}

	@Transactional
	public AdvertCommentUp findById(Long id) {
		return advertCommentUpDao.findOne(id);
	}

	@Transactional
	public void remove(AdvertCommentUp advertCommentUp) {
		advertCommentUpDao.delete(advertCommentUp);
	}

	@Transactional
	public void update(AdvertCommentUp advertCommentUp) {
		advertCommentUpDao.update(advertCommentUp);
	}

	@Transactional
	public Long count() {
		return advertCommentUpDao.count();
	}

}

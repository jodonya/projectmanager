package com.asal.projectmanager.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.AdvertCommentDownDao;
import com.asal.projectmanager.domain.AdvertCommentDown;
import com.asal.projectmanager.service.AdvertCommentDownService;

@Service
public class AdvertCommentDownServiceImp implements AdvertCommentDownService {
	
	@Autowired
	AdvertCommentDownDao advertCommentDownDao;

	@Transactional
	public void add(AdvertCommentDown advertCommentDown) {
		advertCommentDownDao.save(advertCommentDown);
	}

	@Transactional
	public List<AdvertCommentDown> findAll() {
		return advertCommentDownDao.findAll();
	}

	@Transactional
	public AdvertCommentDown findById(Long id) {
		return advertCommentDownDao.findOne(id);
	}

	@Transactional
	public void remove(AdvertCommentDown advertCommentDown) {
		advertCommentDownDao.delete(advertCommentDown);
	}

	@Transactional
	public void update(AdvertCommentDown advertCommentDown) {
		advertCommentDownDao.update(advertCommentDown);
	}

	@Transactional
	public Long count() {
		return advertCommentDownDao.count();
	}

}

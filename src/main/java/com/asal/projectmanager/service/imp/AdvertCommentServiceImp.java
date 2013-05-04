package com.asal.projectmanager.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.AdvertCommentDao;
import com.asal.projectmanager.domain.AdvertComment;
import com.asal.projectmanager.service.AdvertCommentService;

@Service
public class AdvertCommentServiceImp implements AdvertCommentService {

	@Autowired
	AdvertCommentDao advertCommentDao;
	
	@Transactional
	public void add(AdvertComment advertComment) {
		advertCommentDao.save(advertComment);
	}

	@Transactional
	public List<AdvertComment> findAll() {
		return advertCommentDao.findAll();
	}
	

	@Transactional
	public AdvertComment findById(Long id) {
		return advertCommentDao.findOne(id);
	}

	@Transactional
	public void remove(AdvertComment advertComment) {
		advertCommentDao.delete(advertComment);
	}

	@Transactional
	public void update(AdvertComment advertComment) {
		advertCommentDao.update(advertComment);
	}

	@Transactional
	public Long count() {
		return advertCommentDao.count();
	}

}

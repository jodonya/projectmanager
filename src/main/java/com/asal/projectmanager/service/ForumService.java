package com.asal.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.ForumDao;
import com.asal.projectmanager.domain.Forum;

@Service
@Transactional
public class ForumService implements BaseService<Forum> {
	
	@Autowired
	public ForumDao forumDao;

	public List<Forum> getAll() {
		return forumDao.findAll();
	}

	public void add(Forum forum) {
		forumDao.save(forum);
		
	}

	public void delete(Forum forum) {
		forumDao.delete(forum);
	}

	public Forum findOne(Long id) {
		return forumDao.findOne(id);
	}

}

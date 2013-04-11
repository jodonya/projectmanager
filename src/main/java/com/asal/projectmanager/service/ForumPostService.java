package com.asal.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.ForumPostDao;
import com.asal.projectmanager.domain.ForumPost;

@Service
@Transactional
public class ForumPostService  implements BaseService<ForumPost> {

	@Autowired
	public ForumPostDao forumPostDao;
	
	public List<ForumPost> getAll() {
		return forumPostDao.findAll();
	}

	public void add(ForumPost forumPost) {
		forumPostDao.save(forumPost);
	}

	public void delete(ForumPost forumPost) {
		forumPostDao.delete(forumPost);
	}

	public ForumPost findOne(Long id) {
		return forumPostDao.findOne(id);
	}

}

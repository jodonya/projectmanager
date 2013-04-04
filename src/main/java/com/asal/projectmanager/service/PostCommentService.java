package com.asal.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.PostCommentDao;
import com.asal.projectmanager.domain.PostComment;

@Service
@Transactional
public class PostCommentService implements BaseService<PostComment> {
	
	@Autowired
	public PostCommentDao postCommentDao;

	public List<PostComment> getAll() {
		return postCommentDao.findAll();
	}

	public void add(PostComment postComment) {
		postCommentDao.save(postComment);
	}

	public void delete(PostComment postComment) {
		postCommentDao.delete(postComment);
	}

	public PostComment findOne(Long id) {
		return postCommentDao.findOne(id);
	}

}

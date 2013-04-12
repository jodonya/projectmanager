package com.asal.projectmanager.dao;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.domain.ForumPost;
import com.asal.projectmanager.domain.Photo;
import com.asal.projectmanager.domain.PostComment;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class PostCommentDao extends AbstractJpaDao<PostComment> {
	
	protected static Logger logger = Logger.getLogger(PostCommentDao.class);
	
	@Autowired
	ProjectManagerSession projectManagerSession;

	
	public PostCommentDao(){
		setClazz(PostComment.class);
		setProjectManagerSession(projectManagerSession);
	}
	
	@Transactional
	public Long saveReturnId(PostComment comment){
		
		Long commentId = null;
		commentId = super.saveReturnId(comment);
		logger.info(" XXXXXXXXXXXXXXXGot an ID XXXXXXXXXXXXX "+commentId);
		return commentId;
	}
	
	@Transactional
	public List<PostComment> findAll(ForumPost forumPost){
		// TODO Auto-generated method stub
		Query q = entityManager.createQuery("SELECT pc FROM PostComment pc WHERE pc.forumPost = :forumPost");// "SELECT p FROM Photo p WHERE p.name = :name";
		q.setParameter("forumPost", forumPost);
		
//		if (!q.getResultList().isEmpty())
//			photo =  (Photo)q.getResultList().get(0);
//		return photo;

		return (List<PostComment>)q.getResultList();
	}

}

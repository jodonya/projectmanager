package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}

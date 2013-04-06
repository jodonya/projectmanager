package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.ForumPost;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class ForumPostDao extends AbstractJpaDao<ForumPost> {

	protected static Logger logger = Logger.getLogger(ForumPostDao.class);
	
	@Autowired
	ProjectManagerSession projectManagerSession;

	public ForumPostDao(){
		setClazz(ForumPost.class);
		setProjectManagerSession(projectManagerSession);
	}
}

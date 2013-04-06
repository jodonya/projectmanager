package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.Forum;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class ForumDao extends AbstractJpaDao<Forum> {
	
	protected static Logger logger = Logger.getLogger(ForumDao.class);
	
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	public ForumDao(){
		setClazz(Forum.class);
		setProjectManagerSession(projectManagerSession);
	}

}

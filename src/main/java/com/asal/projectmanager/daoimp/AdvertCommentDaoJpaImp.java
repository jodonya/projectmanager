package com.asal.projectmanager.daoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.AdvertCommentDao;
import com.asal.projectmanager.domain.AdvertComment;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class AdvertCommentDaoJpaImp extends AbstractJpaDao<AdvertComment>
		implements AdvertCommentDao {
	
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	
	

	public AdvertCommentDaoJpaImp(){
		setClazz(AdvertComment.class);
		setProjectManagerSession(projectManagerSession);
	}

}

package com.asal.projectmanager.daoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.AdvertCommentUpDao;
import com.asal.projectmanager.domain.AdvertCommentUp;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class AdvertCommentUpDaoJpaImp extends AbstractJpaDao<AdvertCommentUp>
		implements AdvertCommentUpDao {
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	public AdvertCommentUpDaoJpaImp(){
		setClazz(AdvertCommentUp.class);
		setProjectManagerSession(projectManagerSession);
	}
}

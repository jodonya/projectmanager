package com.asal.projectmanager.daoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.AdvertCommentDownDao;
import com.asal.projectmanager.domain.AdvertCommentDown;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class AdvertCommentDownDaoImp extends AbstractJpaDao<AdvertCommentDown>
		implements AdvertCommentDownDao {
	
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	public AdvertCommentDownDaoImp(){
		setClazz(AdvertCommentDown.class);
		setProjectManagerSession(projectManagerSession);
	}

}

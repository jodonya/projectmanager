package com.asal.projectmanager.daoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.AdvertDao;
import com.asal.projectmanager.domain.Advert;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class AdvertDaoJpaImp extends AbstractJpaDao<Advert> implements
		AdvertDao {
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	
	

	public AdvertDaoJpaImp(){
		setClazz(Advert.class);
		setProjectManagerSession(projectManagerSession);
	}

}
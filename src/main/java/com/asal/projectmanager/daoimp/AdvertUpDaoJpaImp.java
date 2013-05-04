package com.asal.projectmanager.daoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.AdvertUpDao;
import com.asal.projectmanager.domain.AdvertUp;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class AdvertUpDaoJpaImp extends AbstractJpaDao<AdvertUp> implements
		AdvertUpDao {

	@Autowired
	ProjectManagerSession projectManagerSession;
	
	public AdvertUpDaoJpaImp(){
		setClazz(AdvertUp.class);
		setProjectManagerSession(projectManagerSession);
	}
}

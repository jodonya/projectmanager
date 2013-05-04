package com.asal.projectmanager.daoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.AdvertResponsibiltyDao;
import com.asal.projectmanager.domain.AdvertResponsibilty;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class AdvertResponsibiltyDaoJpaImp extends
		AbstractJpaDao<AdvertResponsibilty> implements AdvertResponsibiltyDao {

	@Autowired
	ProjectManagerSession projectManagerSession;
	
	public AdvertResponsibiltyDaoJpaImp(){
		setClazz(AdvertResponsibilty.class);
		setProjectManagerSession(projectManagerSession);
	}
}

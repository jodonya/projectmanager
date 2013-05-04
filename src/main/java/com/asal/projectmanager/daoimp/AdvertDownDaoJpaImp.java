package com.asal.projectmanager.daoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.AdvertDownDao;
import com.asal.projectmanager.domain.AdvertDown;
import com.asal.projectmanager.web.controller.ProjectManagerSession;


@Repository
public class AdvertDownDaoJpaImp extends AbstractJpaDao<AdvertDown> implements
		AdvertDownDao {

	@Autowired
	ProjectManagerSession projectManagerSession;
	
	public AdvertDownDaoJpaImp(){
		setClazz(AdvertDown.class);
		setProjectManagerSession(projectManagerSession);
	}
}

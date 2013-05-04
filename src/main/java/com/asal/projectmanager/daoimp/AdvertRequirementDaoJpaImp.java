package com.asal.projectmanager.daoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.AdvertRequirementDao;
import com.asal.projectmanager.domain.AdvertRequirement;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class AdvertRequirementDaoJpaImp extends
		AbstractJpaDao<AdvertRequirement> implements AdvertRequirementDao {
	
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	public AdvertRequirementDaoJpaImp(){
		setClazz(AdvertRequirement.class);
		setProjectManagerSession(projectManagerSession);
	}

}

package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.ProjectPhase;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class ProjectPhaseDao extends AbstractJpaDao<ProjectPhase> {

	protected static Logger logger = Logger.getLogger(ProjectPhaseDao.class);
	
	@Autowired
	ProjectManagerSession projectManagerSession;


	
	public ProjectPhaseDao(){
		setClazz(ProjectPhase.class);
		setProjectManagerSession(projectManagerSession);
	}

}

package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.ProjectStatus;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class ProjectStatusDao extends AbstractJpaDao<ProjectStatus> {
	
	protected static Logger logger = Logger.getLogger(ProjectStatusDao.class);
	
	@Autowired
	ProjectManagerSession projectManagerSession;

	
	public ProjectStatusDao(){
		setClazz(ProjectStatus.class);
		setProjectManagerSession(projectManagerSession);
	}

}

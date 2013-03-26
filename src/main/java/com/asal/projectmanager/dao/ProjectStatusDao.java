package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.ProjectStatus;

@Repository
public class ProjectStatusDao extends AbstractJpaDao<ProjectStatus> {
	
	protected static Logger logger = Logger.getLogger(ProjectStatusDao.class);
	
	public ProjectStatusDao(){
		setClazz(ProjectStatus.class);
	}

}

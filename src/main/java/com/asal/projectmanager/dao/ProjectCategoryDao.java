package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.ProjectCategory;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class ProjectCategoryDao extends AbstractJpaDao<ProjectCategory> {
	
	protected static Logger logger = Logger.getLogger(ProjectCategoryDao.class);
	
	@Autowired
	ProjectManagerSession projectManagerSession;


	public ProjectCategoryDao(){
		setClazz(ProjectCategory.class);
		setProjectManagerSession(projectManagerSession);
	}
}

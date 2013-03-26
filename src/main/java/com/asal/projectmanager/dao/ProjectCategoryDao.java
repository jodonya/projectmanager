package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.ProjectCategory;

@Repository
public class ProjectCategoryDao extends AbstractJpaDao<ProjectCategory> {
	
	protected static Logger logger = Logger.getLogger(ProjectCategoryDao.class);

	public ProjectCategoryDao(){
		setClazz(ProjectCategory.class);
	}
}

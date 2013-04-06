package com.asal.projectmanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.ProjectType;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class ProjectTypeDao extends AbstractJpaDao<ProjectType> {
	
	@Autowired
	ProjectManagerSession projectManagerSession;


	public ProjectTypeDao(){
		setClazz(ProjectType.class);
		setProjectManagerSession(projectManagerSession);
	}

}

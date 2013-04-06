package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.Project;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

/***
 * @author japheth
 * 
 *         Project DAO is for persisting projects
 **/
@Repository
public class ProjectDao extends AbstractJpaDao<Project> {

	protected static Logger logger = Logger.getLogger(ProjectDao.class);
	
	@Autowired
	ProjectManagerSession projectManagerSession;


	
	public ProjectDao(){
		setClazz(Project.class);
		setProjectManagerSession(projectManagerSession);
	}

}

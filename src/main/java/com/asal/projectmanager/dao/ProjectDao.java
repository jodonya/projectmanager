package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.Project;

/***
 * @author japheth
 * 
 *         Project DAO is for persisting projects
 **/
@Repository
public class ProjectDao extends AbstractJpaDao<Project> {

	protected static Logger logger = Logger.getLogger(ProjectDao.class);

	
	public ProjectDao(){
		setClazz(Project.class);
	}

}

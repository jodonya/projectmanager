package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.ProjectMilestone;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class ProjectMilestoneDao extends AbstractJpaDao<ProjectMilestone> {

	protected static Logger logger = Logger
			.getLogger(ProjectMilestoneDao.class);
	
	@Autowired
	ProjectManagerSession projectManagerSession;


	public ProjectMilestoneDao() {
		setClazz(ProjectMilestone.class);
		setProjectManagerSession(projectManagerSession);
	}

}

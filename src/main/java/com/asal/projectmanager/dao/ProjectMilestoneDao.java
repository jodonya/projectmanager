package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.ProjectMilestone;

@Repository
public class ProjectMilestoneDao extends AbstractJpaDao<ProjectMilestone> {

	protected static Logger logger = Logger
			.getLogger(ProjectMilestoneDao.class);

	public ProjectMilestoneDao() {
		setClazz(ProjectMilestone.class);
	}

}

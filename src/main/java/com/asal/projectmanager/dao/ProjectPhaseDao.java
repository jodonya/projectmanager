package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.ProjectPhase;

@Repository
public class ProjectPhaseDao extends AbstractJpaDao<ProjectPhase> {

	protected static Logger logger = Logger.getLogger(ProjectPhaseDao.class);

	
	public ProjectPhaseDao(){
		setClazz(ProjectPhase.class);
	}

}

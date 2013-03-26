package com.asal.projectmanager.dao;

import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.ProjectType;

@Repository
public class ProjectTypeDao extends AbstractJpaDao<ProjectType> {

	public ProjectTypeDao(){
		setClazz(ProjectType.class);
	}

}

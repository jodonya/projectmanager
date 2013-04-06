package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.Role;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class RoleDao extends AbstractJpaDao<Role> {
	protected static Logger logger = Logger.getLogger(RoleDao.class);
	
	@Autowired
	ProjectManagerSession projectManagerSession;

	
	public RoleDao(){
		setClazz(Role.class);
		setProjectManagerSession(projectManagerSession);
	}

}
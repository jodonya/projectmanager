package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.UserRole;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class UserRoleDao extends AbstractJpaDao<UserRole> {
	protected static Logger logger = Logger.getLogger(UserRoleDao.class);
	
	@Autowired
	ProjectManagerSession projectManagerSession;

	public UserRoleDao(){
		setClazz(UserRole.class);
		setProjectManagerSession(projectManagerSession);
	}
}

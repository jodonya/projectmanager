package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.UserRole;

@Repository
public class UserRoleDao extends AbstractJpaDao<UserRole> {
	protected static Logger logger = Logger.getLogger(UserRoleDao.class);
	public UserRoleDao(){
		setClazz(UserRole.class);
	}
}

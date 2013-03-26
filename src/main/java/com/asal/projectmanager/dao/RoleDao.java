package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.Role;

@Repository
public class RoleDao extends AbstractJpaDao<Role> {
	protected static Logger logger = Logger.getLogger(RoleDao.class);
	
	public RoleDao(){
		setClazz(Role.class);
	}

}
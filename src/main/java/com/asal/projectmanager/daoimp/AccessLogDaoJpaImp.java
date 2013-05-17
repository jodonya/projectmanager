package com.asal.projectmanager.daoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.dao.AbstractJpaDao;
import com.asal.projectmanager.dao.AccessLogDao;
import com.asal.projectmanager.domain.AccessLog;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class AccessLogDaoJpaImp extends AbstractJpaDao<AccessLog> implements
		AccessLogDao {

	@Autowired
	ProjectManagerSession projectManagerSession;

	public AccessLogDaoJpaImp() {
		setClazz(AccessLog.class);
		setProjectManagerSession(projectManagerSession);
	}

}

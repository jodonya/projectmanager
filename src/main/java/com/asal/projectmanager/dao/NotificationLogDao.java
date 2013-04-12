package com.asal.projectmanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.NotificationLog;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class NotificationLogDao extends AbstractJpaDao<NotificationLog> {
	
	
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	public NotificationLogDao()
	{
		setClazz(NotificationLog.class);
		setProjectManagerSession(projectManagerSession);
	}
	

}

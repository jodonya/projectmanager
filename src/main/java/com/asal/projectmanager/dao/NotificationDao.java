package com.asal.projectmanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.Notification;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class NotificationDao extends AbstractJpaDao<Notification> {
	
	@Autowired
	ProjectManagerSession projectManagerSession;
	
	public NotificationDao(){
		setClazz(Notification.class);
		setProjectManagerSession(projectManagerSession);
	}

}

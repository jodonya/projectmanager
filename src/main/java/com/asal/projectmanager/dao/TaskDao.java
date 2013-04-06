package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.Task;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class TaskDao extends AbstractJpaDao<Task> {
	
	protected static Logger logger = Logger.getLogger(TaskDao.class);
	
	@Autowired
	ProjectManagerSession projectManagerSession;

	public TaskDao(){
		setClazz(Task.class);
		setProjectManagerSession(projectManagerSession);
	}

}

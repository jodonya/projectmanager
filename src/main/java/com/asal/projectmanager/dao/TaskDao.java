package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.Task;

@Repository
public class TaskDao extends AbstractJpaDao<Task> {
	
	protected static Logger logger = Logger.getLogger(TaskDao.class);
	public TaskDao(){
		setClazz(Task.class);
	}

}

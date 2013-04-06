package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.TaskComment;
import com.asal.projectmanager.web.controller.ProjectManagerSession;

@Repository
public class TaskCommentDao extends AbstractJpaDao<TaskComment> {

	protected static Logger logger = Logger.getLogger(TaskCommentDao.class);
	
	@Autowired
	ProjectManagerSession projectManagerSession;

	
	public TaskCommentDao(){
		setClazz(TaskComment.class);
		setProjectManagerSession(projectManagerSession);
	}
}

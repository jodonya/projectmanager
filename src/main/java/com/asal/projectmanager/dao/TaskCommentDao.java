package com.asal.projectmanager.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.asal.projectmanager.domain.TaskComment;

@Repository
public class TaskCommentDao extends AbstractJpaDao<TaskComment> {

	protected static Logger logger = Logger.getLogger(TaskCommentDao.class);
	
	public TaskCommentDao(){
		setClazz(TaskComment.class);
	}
}

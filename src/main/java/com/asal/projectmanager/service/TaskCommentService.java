package com.asal.projectmanager.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.TaskCommentDao;
import com.asal.projectmanager.domain.TaskComment;

@Service
@Transactional
public class TaskCommentService implements BaseService<TaskComment> {
	
	protected static Logger logger =  Logger.getLogger(TaskCommentService.class);
	
	@Autowired
	public TaskCommentDao taskCOmmentDao;

	public List<TaskComment> getAll() {
		return taskCOmmentDao.findAll();
	}

	public void add(TaskComment taskComment) {
		taskCOmmentDao.save(taskComment);
	}

	public void delete(TaskComment taskComment) {
		taskCOmmentDao.delete(taskComment);
	}

	public TaskComment findOne(Long id) {
		return taskCOmmentDao.findOne(id);
	}

}
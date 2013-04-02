package com.asal.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.TaskDao;
import com.asal.projectmanager.domain.Task;

@Service
@Transactional
public class TaskService implements BaseService<Task> {
	
	@Autowired
	public TaskDao taskDao;

	public List<Task> getAll() {
		return taskDao.findAll();
	}

	public void add(Task task) {
		taskDao.save(task);
	}

	public void delete(Task task) {
		taskDao.delete(task);
	}

	public Task findOne(Long id) {
		return taskDao.findOne(id);
	}

}

package com.asal.projectmanager.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.ProjectDao;
import com.asal.projectmanager.domain.Project;

@Service
@Transactional
public class ProjectService implements BaseService<Project> {
	
	protected static Logger logger = Logger.getLogger(ProjectService.class);
	
	@Autowired
	public ProjectDao projectDao;

	public List<Project> getAll() {
		return projectDao.findAll();
	}

	public void add(Project project) {
		projectDao.save(project);
	}

	public void delete(Project project) {
		 projectDao.delete(project);
	}


	public Project findOne(Long id) {
		return projectDao.findOne(id);
	}

}

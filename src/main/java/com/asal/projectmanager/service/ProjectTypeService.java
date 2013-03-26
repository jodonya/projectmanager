package com.asal.projectmanager.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.ProjectTypeDao;
import com.asal.projectmanager.domain.ProjectType;

@Service
@Transactional
public class ProjectTypeService implements BaseService<ProjectType> {
	
	protected static Logger logger = Logger.getLogger(ProjectTypeService.class);
	
	@Autowired
	public ProjectTypeDao projectTypeDao;

	public List<ProjectType> getAll() {
		return projectTypeDao.findAll();
	}

	public void add(ProjectType projectType) {
		projectTypeDao.save(projectType);
	}

	public void delete(ProjectType projectType) {
		 projectTypeDao.delete(projectType);
	}

	public ProjectType findOne(Long id) {
		return projectTypeDao.findOne(id);
	}

}

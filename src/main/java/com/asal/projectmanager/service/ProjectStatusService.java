package com.asal.projectmanager.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.ProjectStatusDao;
import com.asal.projectmanager.domain.ProjectStatus;
@Service
@Transactional
public class ProjectStatusService implements BaseService<ProjectStatus> {
	
	protected static Logger logger = Logger.getLogger(ProjectStatusService.class);
	
	public ProjectStatusDao projectStatusDao;

	public List<ProjectStatus> getAll() {
		return projectStatusDao.findAll();
	}

	public void add(ProjectStatus projectStatus) {
		projectStatusDao.save(projectStatus);
	}

	public void delete(ProjectStatus projectStatus) {
		 projectStatusDao.delete(projectStatus);
	}

	public ProjectStatus findOne(Long id) {
		return projectStatusDao.findOne(id);
	}

}

package com.asal.projectmanager.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.ProjectUserDao;
import com.asal.projectmanager.domain.ProjectUser;

@Service
@Transactional
public class ProjectUserService implements BaseService<ProjectUser> {
	
	protected static Logger logger = Logger.getLogger(ProjectUserService.class);
	
	@Autowired
	public ProjectUserDao projectUserDao;

	public List<ProjectUser> getAll() {
		return projectUserDao.findAll();
	}

	public void add(ProjectUser projectUser) {
		projectUserDao.save(projectUser);
	}

	public void delete(ProjectUser projectUser) {
		 projectUserDao.delete(projectUser);
	}

	public ProjectUser findOne(Long id) {
		return projectUserDao.findOne(id);
	}

}

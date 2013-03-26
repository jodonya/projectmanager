package com.asal.projectmanager.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.ProjectCategoryDao;
import com.asal.projectmanager.domain.ProjectCategory;

@Service
@Transactional
public class ProjectCategoryService implements BaseService<ProjectCategory> {
	
	protected static Logger logger = Logger.getLogger(ProjectCategory.class);
	
	@Autowired
	public ProjectCategoryDao projectCategoryDao;

	public List<ProjectCategory> getAll() {
		return projectCategoryDao.findAll();
	}

	public void add(ProjectCategory projectCategory) {
		projectCategoryDao.save(projectCategory);
	}

	public void delete(ProjectCategory projectCategory) {
		// TODO Auto-generated method stub
		 projectCategoryDao.delete(projectCategory);
	}


	public ProjectCategory findOne(Long id) {
		return projectCategoryDao.findOne(id);
	}

}

package com.asal.projectmanager.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.ProjectMilestoneDao;
import com.asal.projectmanager.domain.ProjectMilestone;

@Service
@Transactional
public class ProjectMilestoneService implements BaseService<ProjectMilestone> {

	protected static Logger logger = Logger.getLogger(ProjectMilestoneService.class);
	
	@Autowired
	public ProjectMilestoneDao projectMilestoneDao;
	
	public List<ProjectMilestone> getAll() {
		return projectMilestoneDao.findAll();
	}

	public void add(ProjectMilestone projectMilestone) {
		projectMilestoneDao.save(projectMilestone);
	}

	public void delete(ProjectMilestone projectMilestone) {
		projectMilestoneDao.delete(projectMilestone);
	}

	public ProjectMilestone findOne(Long id) {
		return projectMilestoneDao.findOne(id);
	}

}

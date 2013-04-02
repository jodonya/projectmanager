package com.asal.projectmanager.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.ProjectPhaseDao;
import com.asal.projectmanager.domain.ProjectPhase;

@Service
@Transactional
public class ProjectPhaseService implements BaseService<ProjectPhase> {
	
	protected static Logger logger =  Logger.getLogger(ProjectPhaseService.class);

	@Autowired
	public ProjectPhaseDao projectPhaseDao;
	
	public List<ProjectPhase> getAll() {
		return projectPhaseDao.findAll();
	}

	public void add(ProjectPhase projectPhase) {
		projectPhaseDao.save(projectPhase);
	}

	public void delete(ProjectPhase projectPhase) {
		projectPhaseDao.delete(projectPhase);
	}

	public ProjectPhase findOne(Long id) {
		return projectPhaseDao.findOne(id);
	}

}

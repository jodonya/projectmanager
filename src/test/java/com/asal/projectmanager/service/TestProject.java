package com.asal.projectmanager.service;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.ProjectDao;
import com.asal.projectmanager.domain.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestProject {
	
	@Autowired
	ProjectDao projectDao;
	
	@Test
	@Transactional
	public void testAdd(){
		Project project  =  new Project();
		project.setCode("001");
		project.setName("Umati");
		
		projectDao.save(project);
		
		Assert.assertTrue(projectDao.count() > 0);
	}

}

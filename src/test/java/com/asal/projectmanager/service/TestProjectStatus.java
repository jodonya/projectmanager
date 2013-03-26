package com.asal.projectmanager.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.ProjectStatusDao;
import com.asal.projectmanager.domain.ProjectStatus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Transactional
public class TestProjectStatus {
	
	@Autowired
	ProjectStatusDao projectStatusDao;
	
	@Test
	@Transactional
	public void testAdd(){
		ProjectStatus projectStatus =  new ProjectStatus();
		projectStatus.setName("Started");
		projectStatus.setDescription("Started");
		
		projectStatusDao.save(projectStatus);
		
		Assert.assertTrue(projectStatusDao.count() > 0);
		
	}
}

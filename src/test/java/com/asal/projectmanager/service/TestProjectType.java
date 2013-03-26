package com.asal.projectmanager.service;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.ProjectTypeDao;
import com.asal.projectmanager.domain.ProjectType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Transactional
public class TestProjectType {
	
	@Autowired
	ProjectTypeDao projectTypeDao;
	
	@Test
	@Transactional
	public void testAdd(){
		ProjectType projectType = new ProjectType();
		projectType.setName("Short Term");
		projectType.setDescription("Short Term");
		
		projectTypeDao.save(projectType);
		
		Assert.assertTrue(projectTypeDao.count() > 0);
	}
}

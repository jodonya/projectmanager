package com.asal.projectmanager.service;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.ProjectUserDao;
import com.asal.projectmanager.domain.ProjectUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Transactional
public class TestProjectUser {
	
	@Autowired
	ProjectUserDao projectUserDao;
	
	@Test
	@Transactional
	public void testAdd(){
		ProjectUser projectUser =  new ProjectUser();
		projectUser.setFirstName("Japheth");
		projectUser.setLastName("Odonya");
		projectUser.setEmail("jodonya@gmail.com");
		
		projectUserDao.save(projectUser);
		
		Assert.assertTrue(projectUserDao.count() > 0);
	}
}

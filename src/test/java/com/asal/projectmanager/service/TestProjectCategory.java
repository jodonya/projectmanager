package com.asal.projectmanager.service;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.dao.ProjectCategoryDao;
import com.asal.projectmanager.domain.ProjectCategory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Transactional
public class TestProjectCategory {
	
	@Autowired
	ProjectCategoryDao projectCategoryDao;
	
	@Test
	@Transactional
	public void testAdd(){
		
		ProjectCategory projectCategory = new ProjectCategory();
		projectCategory.setName("Software Development");
		projectCategory.setDescription("Software Development");
		
		projectCategoryDao.save(projectCategory);
		
		Assert.assertTrue(projectCategoryDao.count() > 0);
	}

}

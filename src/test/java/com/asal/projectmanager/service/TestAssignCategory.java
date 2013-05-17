package com.asal.projectmanager.service;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.asal.projectmanager.domain.AdvertCategory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Transactional
public class TestAssignCategory {
	
	@Autowired
	AssignCategoryService assignCategoryService;
	@Autowired
	AdvertCategoryService advertCategoryService;
	
	@Test
	@Transactional
	public void testListAdverts(){
		
		AdvertCategory advertCategory = advertCategoryService.findById(2752512L);
		
		Assert.assertTrue(assignCategoryService.findAll(advertCategory).size() > 0);
	}

}
